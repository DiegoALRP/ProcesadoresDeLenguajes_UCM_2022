/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package asint;

import alex0.UnidadLexica;
import alex0.AnalizadorLexicoTiny;
import alex0.ClaseLexica;
import errors.GestionErroresTiny;
import java.io.IOException;
import java.io.Reader;

public class AnalizadorSintacticoTiny {
   private UnidadLexica anticipo;
   private AnalizadorLexicoTiny alex;
   private GestionErroresTiny errores;

   public AnalizadorSintacticoTiny(Reader input) throws IOException {
      errores = new GestionErroresTiny();
      alex = new AnalizadorLexicoTiny(input);
      alex.fijaGestionErrores(errores);
      sigToken();
   }

   public void Sp() {
      Programa();
      empareja(ClaseLexica.EOF);
   }
   private void Programa() {
     switch(anticipo.clase()) {
         case Bool: case Entero: case Real:
            SDec();
            empareja(ClaseLexica.Sep_seccion);
            SInst();
            break;
         default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
                                          ClaseLexica.Bool, ClaseLexica.Entero, ClaseLexica.Real);                                            
      }
   }

   private void SDec(){
    switch(anticipo.clase()) {
      case Bool: case Entero: case Real:
        Dec();
        RSDec();
        break;
      default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
        ClaseLexica.Bool, ClaseLexica.Entero, ClaseLexica.Real, ClaseLexica.Sep_seccion);  
    }

   }

   private void Dec(){
    switch(anticipo.clase()) {
      case Bool: case Entero: case Real:
        TipoVar();
        Variable();
        break;
      default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
        ClaseLexica.Bool, ClaseLexica.Entero, ClaseLexica.Real);  
    }
   }

   private void RSDec(){
    switch(anticipo.clase()) {
      case PuntoComa:
        empareja(ClaseLexica.PuntoComa);
        Dec();
        RSDec();
        break;
      case Sep_seccion:
        break;
      default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
        ClaseLexica.PuntoComa, ClaseLexica.Sep_seccion);  
    }
   }

   private void TipoVar(){
    switch(anticipo.clase()) {
      case Entero: 
        empareja(ClaseLexica.Entero);
        break;
      case Real:
        empareja(ClaseLexica.Real);
        break;
      case Bool:
        empareja(ClaseLexica.Bool);
        break;
      default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
        ClaseLexica.Bool, ClaseLexica.Entero, ClaseLexica.Real);  
    }
   }

   private void Variable(){
    switch(anticipo.clase()) {
      case Variable: 
        empareja(ClaseLexica.Variable);
        break;
      default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
        ClaseLexica.Variable);  
    }
   }

   private void SInst(){
    switch(anticipo.clase()) {
      case Variable:
        Inst();
        RSInst();
        break;
      default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
        ClaseLexica.Variable, ClaseLexica.EOF);  
    }
   }

   private void RSInst(){
    switch(anticipo.clase()) {
      case PuntoComa:
        empareja(ClaseLexica.PuntoComa);
        Inst();
        RSInst();
        break;
      case EOF:
        break;
      default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
        ClaseLexica.PuntoComa);  
    }
   }

   private void Inst(){
    switch(anticipo.clase()) {
      case Variable:
        empareja(ClaseLexica.Variable);
        empareja(ClaseLexica.Asignacion);
        E0();
        break;
      default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
        ClaseLexica.Variable);  
    }
   }

   private void E0(){
    switch(anticipo.clase()) {
      case Menos:case Not: case Par_aper: case True: case False: case NumeroEntero: case NumeroReal: case Variable:
        E1();
        RE0();
        break;
      default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
        ClaseLexica.Menos,ClaseLexica.Not, ClaseLexica.Par_aper, ClaseLexica.True, ClaseLexica.False, ClaseLexica.NumeroEntero, ClaseLexica.NumeroReal);
    }  
   }

   private void RE0(){
    switch(anticipo.clase()) {
      case Mas:
        empareja(ClaseLexica.Mas);
        E0();
        break;
      case Menos:
        empareja(ClaseLexica.Menos);
        E1();
        break;
      case Par_cier: case PuntoComa: case EOF:
        break;
      default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
        ClaseLexica.Menos,ClaseLexica.Not);
    }  
   }

   private void E1(){
    switch(anticipo.clase()) {
      case Menos:case Not: case Par_aper: case True: case False: case NumeroEntero: case NumeroReal: case Variable:
        E2();
        RE1();
        break;
      default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
        ClaseLexica.Menos,ClaseLexica.Not, ClaseLexica.Par_aper, ClaseLexica.True, ClaseLexica.False, ClaseLexica.NumeroEntero, ClaseLexica.NumeroReal);
    }  
   }

   private void RE1(){
    switch(anticipo.clase()) {
      case And:case Or:
        Op1AI();
        E2();
        RE1();
        break;
      case Par_cier: case Mas: case Menos: case PuntoComa: case EOF:
        break;
      default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
        ClaseLexica.And,ClaseLexica.Or,ClaseLexica.Mas,ClaseLexica.Menos);
    }  
   }


  private void E2(){
    switch(anticipo.clase()) {
      case Menos:case Not: case Par_aper: case True: case False: case NumeroEntero: case NumeroReal: case Variable:
        E3();
        RE2();
        break;
      default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
        ClaseLexica.Menos,ClaseLexica.Not, ClaseLexica.Par_aper, ClaseLexica.True, ClaseLexica.False, ClaseLexica.NumeroEntero, ClaseLexica.NumeroReal);
    }  
   }

   private void RE2(){
    switch(anticipo.clase()) {
      case Menor: case Mayor: case Mayor_igual: case Menor_igual: case Igual_igual: case Distinto:
        Op2AI();
        E3();
        RE2();
        break;
      case Par_cier: case Mas: case Menos: case PuntoComa: case And: case Or: case EOF:
        break;
      default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
      ClaseLexica.And,ClaseLexica.Or,ClaseLexica.Mas,ClaseLexica.Menos,
      ClaseLexica.Menor,ClaseLexica.Mayor, ClaseLexica.Mayor_igual, ClaseLexica.Menor_igual, 
      ClaseLexica.Igual_igual, ClaseLexica.Distinto);
    }  
   }

   private void E3(){
    switch(anticipo.clase()) {
      case Menos:case Not: case Par_aper: case True: case False: case NumeroEntero: case NumeroReal: case Variable:
        E4();
        RE3();
        break;
      default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
        ClaseLexica.Menos,ClaseLexica.Not, ClaseLexica.Mas, ClaseLexica.And, ClaseLexica.Or,
        ClaseLexica.Menor,ClaseLexica.Mayor, ClaseLexica.Mayor_igual, ClaseLexica.Menor_igual, 
        ClaseLexica.Igual_igual, ClaseLexica.Distinto, ClaseLexica.Par_aper, ClaseLexica.True,
        ClaseLexica.False, ClaseLexica.NumeroEntero, ClaseLexica.NumeroReal);
    }  
   }

   private void RE3(){
    switch(anticipo.clase()) {
      case Por: case Div:
        Op3NA();
        E4();
        break;
      case Par_cier: case Mas: case Menos: case PuntoComa: case And: case Or: 
      case Menor: case Mayor: case Mayor_igual: case Menor_igual: case Igual_igual: case Distinto:case EOF:
        break;
      default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
      ClaseLexica.And,ClaseLexica.Or,ClaseLexica.Mas,ClaseLexica.Menos,
      ClaseLexica.Menor,ClaseLexica.Mayor, ClaseLexica.Mayor_igual, ClaseLexica.Menor_igual, 
      ClaseLexica.Igual_igual, ClaseLexica.Distinto, ClaseLexica.Por, ClaseLexica.Div);
    }  
   }

   private void E4(){
    switch(anticipo.clase()) {
      case Not:
        empareja(ClaseLexica.Not);
        E4();
        break;
      case Menos:
        empareja(ClaseLexica.Menos);
        E5();
        break;
      case Par_aper: case True: case False: case NumeroEntero: case NumeroReal: case Variable:
        E5();
        break;
      default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
      ClaseLexica.Menos,ClaseLexica.Not, ClaseLexica.Mas, ClaseLexica.And, ClaseLexica.Or,
      ClaseLexica.Menor,ClaseLexica.Mayor, ClaseLexica.Mayor_igual, ClaseLexica.Menor_igual, 
      ClaseLexica.Igual_igual, ClaseLexica.Distinto, ClaseLexica.Por, ClaseLexica.Div,
      ClaseLexica.Par_aper, ClaseLexica.True, ClaseLexica.False, ClaseLexica.NumeroEntero,
       ClaseLexica.NumeroReal);
    }  
   }

   private void E5(){
    switch(anticipo.clase()) {
      case Par_aper:
        empareja(ClaseLexica.Par_aper);
        E0();
        empareja(ClaseLexica.Par_cier);
        break;
      case False:
        empareja(ClaseLexica.False);
       break;
      case NumeroEntero:
        empareja(ClaseLexica.NumeroEntero);
        break;
      case NumeroReal:
        empareja(ClaseLexica.NumeroReal);
        break;
      case True:
        empareja(ClaseLexica.True);
        break;
      case Variable:
        empareja(ClaseLexica.Variable);
        break;
      default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
      ClaseLexica.Menos,ClaseLexica.Not, ClaseLexica.Mas, ClaseLexica.And, ClaseLexica.Or,
      ClaseLexica.Menor,ClaseLexica.Mayor, ClaseLexica.Mayor_igual, ClaseLexica.Menor_igual, 
      ClaseLexica.Igual_igual, ClaseLexica.Distinto, ClaseLexica.Por, ClaseLexica.Div,
      ClaseLexica.Par_aper, ClaseLexica.NumeroReal, ClaseLexica.NumeroEntero, ClaseLexica.True,
      ClaseLexica.False); 
    }  
   }
   
   
    private void Op1AI() {
      switch(anticipo.clase()) {
        case And:
          empareja(ClaseLexica.And);
          break;
        case Or:
          empareja(ClaseLexica.Or);
          break;
        default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(), 
        ClaseLexica.And, ClaseLexica.Or);
      }
    }

    private void Op2AI() {
      switch(anticipo.clase()) {
        case Menor:
          empareja(ClaseLexica.Menor);
          break;
        case Mayor:
          empareja(ClaseLexica.Mayor);
          break;
        case Menor_igual:
          empareja(ClaseLexica.Menor_igual);
          break;
        case Mayor_igual:
          empareja(ClaseLexica.Mayor_igual);
          break;
        case Igual_igual:
          empareja(ClaseLexica.Igual_igual);
          break;
        case Distinto:
          empareja(ClaseLexica.Distinto);
          break;
        default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(), 
        ClaseLexica.Menor, ClaseLexica.Mayor, ClaseLexica.Menor_igual, ClaseLexica.Mayor_igual, 
        ClaseLexica.Igual_igual, ClaseLexica.Distinto);
      }
    }

    private void Op3NA(){
      switch(anticipo.clase()) {
        case Por:
          empareja(ClaseLexica.Por);
          break;
        case Div:
          empareja(ClaseLexica.Div);
          break;
        default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(), 
        ClaseLexica.Por, ClaseLexica.Div);
      }
    }

   private void empareja(ClaseLexica claseEsperada) {
      if (anticipo.clase() == claseEsperada)
          sigToken();
      else errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),claseEsperada);
   }

   private void sigToken() {
      try {
        anticipo = alex.sigToken();
      }
      catch(IOException e) {
        errores.errorFatal(e);
      }
   }
   
}
