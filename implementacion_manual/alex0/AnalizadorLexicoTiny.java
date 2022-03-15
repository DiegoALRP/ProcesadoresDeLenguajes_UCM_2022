package alex0;

import java.io.FileInputStream;
import java.io.Reader;

import errors.GestionErroresTiny;

import java.io.InputStreamReader;
import java.io.IOException;

public class AnalizadorLexicoTiny {

   private Reader input;
   private StringBuffer lex;
   private int sigCar;
   private int filaInicio;
   private int columnaInicio;
   private int filaActual;
   private int columnaActual;
   private static String NL = System.getProperty("line.separator");
   
   private static enum Estado {
    INIT, VARIABLE, CERO, MENOS, MAS, NUMERO_ENTERO, PRE_DECIMAL, PARTE_DECIMAL, 
    PRE_EXPONENCIAL, PARTE_EXPONENCIAL, PRE_SEP_SECCION, SEP_SECCION, MAYOR, MAYOR_IGUAL,
    MENOR, MENOR_IGUAL, POR, DIV, PRE_DISTINTO, DISTINTO, IGUAL, IGUAL_IGUAL, PUNTO_COMA,
    PAR_APER, PAR_CIER, PUNTO, PUNTO_CERO, SIGNO_ESPONENCIAL, EOF
   }

   private Estado estado;
  private GestionErroresTiny errores;

   public AnalizadorLexicoTiny(Reader input) throws IOException {
    this.input = input;
    lex = new StringBuffer();
    sigCar = input.read();
    filaActual=1;
    columnaActual=1;
   }
   
   public UnidadLexica sigToken() throws IOException {
     estado = Estado.INIT;
     filaInicio = filaActual;
     columnaInicio = columnaActual;
     lex.delete(0,lex.length());
     while(true) {
         switch(estado) {
           case INIT: 
              if(hayLetra())  transita(Estado.VARIABLE);
              else if (hayDigitoPos()) transita(Estado.NUMERO_ENTERO);
              else if (hayCero()) transita(Estado.CERO);
              else if (haySuma()) transita(Estado.MAS);
              else if (hayResta()) transita(Estado.MENOS);
              else if (hayMul()) transita(Estado.POR);
              else if (hayDiv()) transita(Estado.DIV);
              else if (hayPAp()) transita(Estado.PAR_APER);
              else if (hayPCierre()) transita(Estado.PAR_CIER);
              else if (hayIgual()) transita(Estado.IGUAL);
              else if (hayDistinto()) transita(Estado.PRE_DISTINTO);
              else if (hayMenor()) transita(Estado.MENOR);
              else if (hayMayor()) transita(Estado.MAYOR);
              else if (hayPuntoComa()) transita(Estado.PUNTO_COMA);
              else if (hayAmpersand()) transita(Estado.PRE_SEP_SECCION);
              else if (haySep() || hayNL()) transitaIgnorando(Estado.INIT);
              else if (hayEOF()) transita(Estado.EOF);
              else error();
              break;
           case VARIABLE: 
              if (hayLetra() || hayDigito() || haySubrayado()) transita(Estado.VARIABLE);
              else return unidadId();               
              break;
           case NUMERO_ENTERO:
               if (hayDigito()) transita(Estado.NUMERO_ENTERO);
               else if (hayPunto()) transita(Estado.PUNTO);
               else if (hayExponencial()) transita(Estado.PRE_EXPONENCIAL);
               else return unidadEnt();
               break;
           case PUNTO:
                if(hayCero()) transita(Estado.PUNTO_CERO);
                else if(hayDigitoPos()) transita(Estado.PARTE_DECIMAL);
                else error();
                break;
           case PUNTO_CERO:
                if (hayCero()) transita(Estado.PRE_DECIMAL);
                else if(hayDigitoPos()) transita(Estado.PARTE_DECIMAL);
                else return unidadReal();
                break;
           case PRE_DECIMAL:
              if (hayCero()) transita(Estado.PRE_DECIMAL);
              else if (hayDigitoPos()) transita(Estado.PARTE_DECIMAL);
              else error();
              break;
           case PARTE_DECIMAL:
              if (hayExponencial()) transita(Estado.PRE_EXPONENCIAL);
              else if(hayDigitoPos()) transita(Estado.PARTE_DECIMAL);
              else if(hayCero()) transita(Estado.PRE_DECIMAL);
              else return unidadReal();
              break;
           case SIGNO_ESPONENCIAL:
              if (hayDigitoPos()) transita(Estado.PARTE_EXPONENCIAL);
              else error();
              break;
           case PRE_EXPONENCIAL:
              if(hayDigitoPos()) transita(Estado.PARTE_EXPONENCIAL);
              else if(haySuma() || hayResta()) transita(Estado.SIGNO_ESPONENCIAL);
              else error();
              break;
           case PARTE_EXPONENCIAL:
              if(hayDigito()) transita(Estado.PARTE_EXPONENCIAL);
              else return unidadReal();
              break;
           case CERO:
               if (hayPunto()) transita(Estado.PUNTO);
               else if (hayExponencial()) transita(Estado.PRE_EXPONENCIAL);
               else return unidadEnt();
               break;
           case MAS:
               if (hayDigitoPos()) transita(Estado.NUMERO_ENTERO);
               else if(hayCero()) transita(Estado.CERO);
               else return unidadMas();
               break;
           case MENOS: 
               if (hayDigitoPos()) transita(Estado.NUMERO_ENTERO);
               else if(hayCero()) transita(Estado.CERO);
               else return unidadMenos();
               break;
           case POR: return unidadPor();
           case DIV: return unidadDiv();              
           case PAR_APER: return unidadPar_Aper();
           case PAR_CIER: return unidadPar_Cierr();
           case IGUAL_IGUAL: return unidadIgual_Igual();
           case PRE_DISTINTO:
                if (hayIgual()) transita(Estado.DISTINTO);
                else error();
                break;
           case DISTINTO:
                return unidadDistinto();
           case IGUAL:
                if (hayIgual()) transita(Estado.IGUAL_IGUAL);
                else return unidadAsignacion();
                break;
           case PUNTO_COMA: return unidadPuntoComa();
           case MENOR: 
                if(hayIgual()) transita(Estado.MENOR_IGUAL);
                else return unidadMenor();
                break;
           case MENOR_IGUAL: return unidadMenor_Igual();
           case MAYOR: 
                if(hayIgual()) transita(Estado.MAYOR_IGUAL);
                else return unidadMayor();
                break;
           case MAYOR_IGUAL: return unidadMayor_Igual();
           case PRE_SEP_SECCION: 
                if(hayAmpersand()) transita(Estado.SEP_SECCION);
                else error();
                break;
           case SEP_SECCION: return unidadAmpersand();
           case EOF: return unidadEof();
         }
     }    
   }
   private void transita(Estado sig) throws IOException {
     lex.append((char)sigCar);
     sigCar();         
     estado = sig;
   }
   private void transitaIgnorando(Estado sig) throws IOException {
     sigCar();         
     filaInicio = filaActual;
     columnaInicio = columnaActual;
     estado = sig;
   }
   private void sigCar() throws IOException {
     sigCar = input.read();
     if (sigCar == NL.charAt(0)) saltaFinDeLinea();
     if (sigCar == '\n') {
        filaActual++;
        columnaActual=0;
     }
     else {
       columnaActual++;  
     }
   }
   private void saltaFinDeLinea() throws IOException {
      for (int i=1; i < NL.length(); i++) {
          sigCar = input.read();
          if (sigCar != NL.charAt(i)) error();
      }
      sigCar = '\n';
   }
   
   private boolean hayLetra() {return sigCar >= 'a' && sigCar <= 'z' ||
                                      sigCar >= 'A' && sigCar <= 'Z';}
   private boolean hayExponencial() {return sigCar == 'e'|| sigCar == 'E';}
   private boolean hayDigitoPos() {return sigCar >= '1' && sigCar <= '9';}
   private boolean hayCero() {return sigCar == '0';}
   private boolean hayDigito() {return hayDigitoPos() || hayCero();}
   private boolean haySuma() {return sigCar == '+';}
   private boolean hayResta() {return sigCar == '-';}
   private boolean hayMul() {return sigCar == '*';}
   private boolean hayDiv() {return sigCar == '/';}
   private boolean hayPAp() {return sigCar == '(';}
   private boolean hayPCierre() {return sigCar == ')';}
   private boolean hayIgual() {return sigCar == '=';}
   private boolean hayPunto() {return sigCar == '.';}
   private boolean hayMenor() {return sigCar == '<';}
   private boolean hayMayor() {return sigCar == '>';}
   private boolean hayPuntoComa() {return sigCar == ';';}
   private boolean haySubrayado() {return sigCar == '_';}
   private boolean hayDistinto() {return sigCar == '!';}
   private boolean hayAmpersand() {return sigCar == '&';}
   private boolean haySep() {return sigCar == ' ' || sigCar == '\t' || sigCar=='\n';}
   private boolean hayNL() {return sigCar == '\r' || sigCar == '\b' || sigCar == '\n';}
   private boolean hayEOF() {return sigCar == -1;}
  
   private UnidadLexica unidadId() {
    switch(lex.toString()) {
      case "int":  
        return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.Entero);
      case "real":    
        return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.Real);
      case "bool":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.Bool);
      case "true":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.True);
      case "false":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.False);
      case "and":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.And);
      case "or":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.Or);
      case "not":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.Not);
      default:    
        return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,ClaseLexica.Variable,lex.toString());     
    }
  }  

  private UnidadLexica unidadEnt() {
    return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,ClaseLexica.NumeroEntero,lex.toString());     
  }    
  
  private UnidadLexica unidadReal() {
    return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,ClaseLexica.NumeroReal,lex.toString());     
  }    
  
  private UnidadLexica unidadMas() {
    return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.Mas);     
  }    
  
  private UnidadLexica unidadMenos() {
    return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.Menos);     
  }    
  
  private UnidadLexica unidadPor() {
    return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.Por);     
  }  
    
  private UnidadLexica unidadDiv() {
    return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.Div);     
  }

  private UnidadLexica unidadMenor() {
    return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.Menor);     
  }

  private UnidadLexica unidadMayor() {
    return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.Mayor);     
  }

  private UnidadLexica unidadMenor_Igual() {
    return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.Menor_igual);     
  }

  private UnidadLexica unidadMayor_Igual() {
    return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.Mayor_igual);     
  }

  private UnidadLexica unidadDistinto() {
    return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.Distinto);     
  }

  private UnidadLexica unidadPar_Aper() {
    return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.Par_aper);     
  }  

  private UnidadLexica unidadPar_Cierr() {
    return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.Par_cier);     
  }  

  private UnidadLexica unidadAsignacion() {
    return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.Asignacion);     
  }

  private UnidadLexica unidadIgual_Igual() {
    return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.Igual_igual);     
  }

  private UnidadLexica unidadPuntoComa() {
    return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PuntoComa);     
  }    

  private UnidadLexica unidadAmpersand() {
    return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.Sep_seccion);     
  }    
  
  private UnidadLexica unidadEof() {
    return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.EOF);     
  }    

  private void error() {
    //System.err.println("("+filaActual+','+columnaActual+"):Caracter inexperado"); 
    errores.errorLexico(filaActual,columnaActual,lex.toString()); 
    System.exit(1);
  }

   public static void main(String arg[]) throws IOException {
     //Reader input = new InputStreamReader(new FileInputStream("input0_2.txt"));
     System.out.println("Ejecutando tiny0");
     System.out.println("Se ha leido el fichero: " + arg[0]);
     String ruta = "pruebas_tiny_0/";
     ruta += arg[0];
     Reader input = new InputStreamReader(new FileInputStream(ruta));
     AnalizadorLexicoTiny al = new AnalizadorLexicoTiny(input);
     UnidadLexica unidad;
     do {
       unidad = al.sigToken();
       System.out.println(unidad);
     }
     while (unidad.clase() != ClaseLexica.EOF);
    }
    
  public void fijaGestionErrores(GestionErroresTiny errores) {
    this.errores = errores;
   }
}