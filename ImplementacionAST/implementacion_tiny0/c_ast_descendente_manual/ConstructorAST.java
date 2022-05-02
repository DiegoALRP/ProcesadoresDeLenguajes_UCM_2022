package c_ast_descendente_manual;

import java.io.IOException;
import java.io.Reader;
import asint.TinyASint.Prog;
import asint.TinyASint.SDec;
import asint.TinyASint.Dec;
import asint.TinyASint.Exp;
import asint.TinyASint.SInst;
import asint.TinyASint.Inst;
import semops.SemOps;

public class ConstructorAST {

		private UnidadLexica anticipo;
		private AnalizadorLexico alex;
		private GestionErrores errores;
		private SemOps sem;
	 
		public ConstructorAST (Reader input) throws IOException {
				errores = new GestionErrores();
				alex = new AnalizadorLexico(input,errores);
				sigToken();
				sem = new SemOps();
		}

		public Prog Init() {
				Prog prog = Programa();
				empareja(ClaseLexica.EOF);
				return prog;
		}
	 
	 private Prog Programa() {
		 switch(anticipo.clase()) {
				case Entero: case Real: case Bool:   
					SDec dec = SDec();
					empareja(ClaseLexica.Sep_seccion);
					SInst inst = SInst();
					return sem.prog(dec,inst);
				default: 
					errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
					ClaseLexica.Bool, ClaseLexica.Entero, ClaseLexica.Real);     
					return null;
	 }
	 }
	 
	 private Dec Dec(){
			switch(anticipo.clase()) {
				case Real: case Bool: case Entero:
					String tipo =  Tipo();
					UnidadLexica tkvar = anticipo;
					empareja(ClaseLexica.Variable);
					return sem.dec(tipo,sem.str(tkvar.lexema(),tkvar.fila(),tkvar.columna()));
					default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
							ClaseLexica.Bool, ClaseLexica.Entero, ClaseLexica.Real);
						return null;
			}
	 }

	 private SDec SDec(){
		 switch(anticipo.clase()) {
			 case Real: case Bool: case Entero:
				Dec dec = Dec();
				return RSDec(sem.sdec_una(dec));
			 default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
				ClaseLexica.Bool, ClaseLexica.Entero, ClaseLexica.Real);
				return null;
		 }
	 }
	private SDec RSDec(SDec decah){
		switch(anticipo.clase()) {
			case PuntoComa:
				empareja(ClaseLexica.PuntoComa);
				Dec dec = Dec();
				return RSDec(sem.sdec_muchas(decah,dec));
			case Sep_seccion:
				return decah;
			 default:
			 	errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
				ClaseLexica.PuntoComa,ClaseLexica.Sep_seccion);
				return null;
		 }
	 }


	 private String Tipo(){
		switch(anticipo.clase()) {
			case Real:
				empareja(ClaseLexica.Real);
				return "real";
			case Bool:
				empareja(ClaseLexica.Bool);
				return "bool";
			case Entero:
				empareja(ClaseLexica.Entero);
				return "int";
			default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
				ClaseLexica.Bool, ClaseLexica.Entero, ClaseLexica.Real);
				return "?";
		}

	}

	 private Inst Inst(){
			switch(anticipo.clase()) {
				case Variable:
					UnidadLexica tkvar = anticipo;
					empareja(ClaseLexica.Variable);
					empareja(ClaseLexica.Asignacion);
					Exp exp = E0();
					return sem.inst(sem.str(tkvar.lexema(),tkvar.fila(),tkvar.columna()), exp);
				default:
					errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
					ClaseLexica.Variable);
					return null;
			}
	 }
	 
	 private SInst SInst(){
		 switch(anticipo.clase()) {
				case Variable:
					Inst inst= Inst();
					return RSInst(sem.sinst_una(inst));
				default:
					errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
					ClaseLexica.Variable);
										return null;
		 }
	 }

		private SInst RSInst(SInst instah){
			switch(anticipo.clase()) {
			 case PuntoComa:
			 empareja(ClaseLexica.PuntoComa);
				Inst inst = Inst();
				return RSInst(sem.sinst_muchas(instah,inst));
			case EOF:
				return instah;
			 default:  errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
																			ClaseLexica.PuntoComa,ClaseLexica.EOF);
										return null;
		 }
		}

	private Exp E0() {
		
		switch(anticipo.clase()) {
			case Menos: case Not: case Par_aper: case True: case False: case NumeroEntero: case NumeroReal: case Variable:
				Exp exp1 = E1();
				return RE0(exp1);
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), 
				ClaseLexica.Menos, ClaseLexica.Not, ClaseLexica.Par_aper, ClaseLexica.True, ClaseLexica.False,
				ClaseLexica.NumeroEntero, ClaseLexica.NumeroReal);

				return null;
		}
	}

	private Exp RE0(Exp expH) {

		switch(anticipo.clase()) {
			case Mas:
				empareja(ClaseLexica.Mas);
				return sem.suma(expH, E0());
			case Menos:
				empareja(ClaseLexica.Menos);
				return sem.resta(expH, E1());
			case Par_cier: case PuntoComa: case EOF:
				return expH;
			default: 
				errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(),
				ClaseLexica.Menos, ClaseLexica.Not);
				return null;
		}
	}

	private Exp E1() {
		switch(anticipo.clase()) {
			case Menos: case Not: case Par_aper: case True: case False: case NumeroEntero: case NumeroReal: case Variable:
				Exp exp2 = E2();
				return RE1(exp2);
			default: errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(),
				ClaseLexica.Menos, ClaseLexica.Not, ClaseLexica.Par_aper, ClaseLexica.True,
				ClaseLexica.False, ClaseLexica.NumeroEntero, ClaseLexica.NumeroReal);
				return null;
		}
	}

	private Exp RE1(Exp expH) {
		switch(anticipo.clase()) {
			case And:case Or:
				String op = Op1AI();
				Exp exp2 = E2();
				return RE1(sem.exp(op, expH, exp2));
			case Par_cier: case Mas: case Menos: case PuntoComa: case EOF:
				return expH;
			default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
				ClaseLexica.And,ClaseLexica.Or,ClaseLexica.Mas,ClaseLexica.Menos);
				return null;
		}
	}

	private Exp E2() {

		switch(anticipo.clase()) {
			case Menos:case Not: case Par_aper: case True: case False: case NumeroEntero: case NumeroReal: case Variable:
				Exp exp3 = E3(); // RE2.ah = E3.a
				return RE2(exp3); //E2.a = RE2
			default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
				ClaseLexica.Menos,ClaseLexica.Not, ClaseLexica.Par_aper, ClaseLexica.True, ClaseLexica.False, 
				ClaseLexica.NumeroEntero, ClaseLexica.NumeroReal);
				return null;
		}
	}

	private Exp RE2(Exp expH) {

		switch(anticipo.clase()) {
			case Menor: case Mayor: case Mayor_igual: case Menor_igual: case Igual_igual: case Distinto:
				String op = Op2AI();
				Exp exp3 = E3();
				return RE2(sem.exp(op, expH, exp3));
			case Par_cier: case Mas: case Menos: case PuntoComa: case And: case Or: case EOF:
				return expH;
			default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
				ClaseLexica.And,ClaseLexica.Or,ClaseLexica.Mas,ClaseLexica.Menos,
				ClaseLexica.Menor,ClaseLexica.Mayor, ClaseLexica.Mayor_igual, ClaseLexica.Menor_igual, 
				ClaseLexica.Igual_igual, ClaseLexica.Distinto);
				return null;
		}
	}

	private Exp E3() {

		switch(anticipo.clase()) {
			case Menos:case Not: case Par_aper: case True: case False: case NumeroEntero: case NumeroReal: case Variable:
					Exp exp4 = E4();
			 	return RE3(exp4);
			default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
				ClaseLexica.Menos,ClaseLexica.Not, ClaseLexica.Mas, ClaseLexica.And, ClaseLexica.Or,
				ClaseLexica.Menor,ClaseLexica.Mayor, ClaseLexica.Mayor_igual, ClaseLexica.Menor_igual, 
				ClaseLexica.Igual_igual, ClaseLexica.Distinto, ClaseLexica.Par_aper, ClaseLexica.True,
				ClaseLexica.False, ClaseLexica.NumeroEntero, ClaseLexica.NumeroReal);
				return null;
		}
	}

	private Exp RE3(Exp expH) {

		switch(anticipo.clase()) {
			case Por:case Div:
				String op = Op3NA();
				Exp exp4 = E4();
				return sem.exp(op, expH, exp4);
			case Par_cier: case Mas: case Menos: case PuntoComa: case And: case Or: 
			case Menor: case Mayor: case Mayor_igual: case Menor_igual: case Igual_igual: case Distinto:case EOF:
				return expH;
			default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
				ClaseLexica.And,ClaseLexica.Or,ClaseLexica.Mas,ClaseLexica.Menos,
				ClaseLexica.Menor,ClaseLexica.Mayor, ClaseLexica.Mayor_igual, ClaseLexica.Menor_igual, 
				ClaseLexica.Igual_igual, ClaseLexica.Distinto, ClaseLexica.Por, ClaseLexica.Div);
				return null;
		}
	}

	private Exp E4() {
		switch(anticipo.clase()) {
			case Not:
				empareja(ClaseLexica.Not);
				Exp exp4 = E4();
				return sem.notOperation(exp4);
			case Menos:
				empareja(ClaseLexica.Menos);
				Exp exp5 = E5();
				return sem.nevativoOperation(exp5);
			case Par_aper: case True: case False: case NumeroEntero: case NumeroReal: case Variable:
				return E5();
			default: errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
				ClaseLexica.Menos,ClaseLexica.Not, ClaseLexica.Mas, ClaseLexica.And, ClaseLexica.Or,
				ClaseLexica.Menor,ClaseLexica.Mayor, ClaseLexica.Mayor_igual, ClaseLexica.Menor_igual, 
				ClaseLexica.Igual_igual, ClaseLexica.Distinto, ClaseLexica.Por, ClaseLexica.Div,
				ClaseLexica.Par_aper, ClaseLexica.True, ClaseLexica.False, ClaseLexica.NumeroEntero,
				ClaseLexica.NumeroReal);
				return null;
		}  
	}

	private Exp E5() {
		switch(anticipo.clase()) {
			case Par_aper:
				empareja(ClaseLexica.Par_aper);
				Exp exp = E0(); 
				empareja(ClaseLexica.Par_cier);
				return exp;
			case False:
				//UnidadLexica tkfalse = anticipo;//directamente string?? hace falta tenerlo localizado??
				empareja(ClaseLexica.False);
				return sem.booleanExp("false");//sem.str("false", tkfalse.fila(), tkfalse.columna()));
			case NumeroEntero:
				UnidadLexica tkentero = anticipo;
				empareja(ClaseLexica.NumeroEntero);
				return sem.entero(sem.str(tkentero.lexema(), tkentero.fila(), tkentero.columna()));
			case NumeroReal:
				UnidadLexica tkreal = anticipo;
				empareja(ClaseLexica.NumeroReal);
				return sem.real(sem.str(tkreal.lexema(), tkreal.fila(), tkreal.columna()));
			case True:
				//UnidadLexica tktrue = anticipo;//directamente string??
				empareja(ClaseLexica.True);
				return sem.booleanExp("true");//sem.str("true", tktrue.fila(), tktrue.columna()));
			case Variable:
				UnidadLexica tkvar = anticipo;
				empareja(ClaseLexica.Variable);
				return sem.var(sem.str(tkvar.lexema(), tkvar.fila(), tkvar.columna()));
			default: 
				errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(),
				ClaseLexica.Menos,ClaseLexica.Not, ClaseLexica.Mas, ClaseLexica.And, ClaseLexica.Or,
				ClaseLexica.Menor,ClaseLexica.Mayor, ClaseLexica.Mayor_igual, ClaseLexica.Menor_igual, 
				ClaseLexica.Igual_igual, ClaseLexica.Distinto, ClaseLexica.Por, ClaseLexica.Div,
				ClaseLexica.Par_aper, ClaseLexica.NumeroReal, ClaseLexica.NumeroEntero, ClaseLexica.True,
				ClaseLexica.False);
				return null;
		}
	}

	private String Op1AI() {
		switch(anticipo.clase()) {
			case And:
				empareja(ClaseLexica.And);
				return "and";
			case Or:
				empareja(ClaseLexica.Or);
				return "or";
			default:
				errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(), 
				ClaseLexica.And, ClaseLexica.Or);
				return "?";
		}
	}

	private String Op2AI() {

		switch(anticipo.clase()) {
			case Menor:
				empareja(ClaseLexica.Menor);
				return "<";
			case Mayor:
				empareja(ClaseLexica.Mayor);
				return ">";
			case Menor_igual:
				empareja(ClaseLexica.Menor_igual);
				return "<=";
			case Mayor_igual:
				empareja(ClaseLexica.Mayor_igual);
				return ">=";
			case Igual_igual:
				empareja(ClaseLexica.Igual_igual);
				return "==";
			case Distinto:
				empareja(ClaseLexica.Distinto);
				return "!=";
			default: 
				errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(), 
				ClaseLexica.Menor, ClaseLexica.Mayor, ClaseLexica.Menor_igual, ClaseLexica.Mayor_igual, 
				ClaseLexica.Igual_igual, ClaseLexica.Distinto);
				return "?";
		}
	}

	private String Op3NA() {
		switch(anticipo.clase()) {
			case Por:
				empareja(ClaseLexica.Por);
				return "*";
			case Div:
				empareja(ClaseLexica.Div);
				return "/";
			default:  
				errores.errorSintactico(anticipo.fila(),anticipo.columna(),anticipo.clase(), 
				ClaseLexica.Por, ClaseLexica.Div);
				return "?";
		}
	}
	 
	//Otros
	private void empareja(ClaseLexica claseEsperada) {
		if (anticipo.clase() == claseEsperada) sigToken();
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
