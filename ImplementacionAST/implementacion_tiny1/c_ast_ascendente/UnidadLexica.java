package c_ast_ascendente;

import asint.TinyASint.StringLocalizado;
import java_cup.runtime.Symbol;

public class UnidadLexica extends Symbol {
   public UnidadLexica(int fila, int col, int clase, String lexema) {
     super(clase,null);
     value = new StringLocalizado(lexema,fila,col);
   }
   public int clase () {return sym;}
   public StringLocalizado lexema() {return (StringLocalizado)value;}
   public String toString() {
       StringLocalizado lexema = (StringLocalizado)value;
       return "[clase="+clase2string(sym)+",lexema="+lexema+",fila="+lexema.fila()+",col="+lexema.col()+"]";
   }
   private String clase2string(int clase) {
       switch(clase) {
         case ClaseLexica.AMPERSAND: return "AMPERSAND";
         case ClaseLexica.AND: return "AND";
         case ClaseLexica.ARRAY: return "ARRAY";
         case ClaseLexica.BOOL: return "BOOL";
         case ClaseLexica.CALL: return "CALL";
         case ClaseLexica.COMA: return "COMA";
         case ClaseLexica.CORCHE_APER: return "CORCHE_APER";
         case ClaseLexica.CORCHE_CIER: return "CORCHE_CIER";
         case ClaseLexica.CORCHE_RECT_APER: return "CORCHE_RECT_APER";
         case ClaseLexica.CORCHE_RECT_CIER : return "CORCHE_RECT_CIER";
         case ClaseLexica.DELETE : return "DELETE";
         case ClaseLexica.DISTINTO : return "DISTINTO";
         case ClaseLexica.SEP_SECCION : return "SEP_SECCION";
         case ClaseLexica.POR : return "POR";
         case ClaseLexica.LIT_CADENA : return "LIT_CADENA";
         case ClaseLexica.WRITE : return "WRITE";
         case ClaseLexica.NOT : return "NOT";
         case ClaseLexica.IGUAL : return "IGUAL";
         case ClaseLexica.IGUAL_IGUAL : return "IGUAL_IGUAL";
         case ClaseLexica.RECORD : return "RECORD";
         case ClaseLexica.TYPE : return "TYPE";
         case ClaseLexica.OR : return "OR";
         case ClaseLexica.PROCEDIMIENTO : return "PROCEDIMIENTO";
         case ClaseLexica.DIV : return "DIV";
         case ClaseLexica.IF : return "IF";
         case ClaseLexica.PUNTO_COMA : return "PUNTO_COMA";
         case ClaseLexica.PUNTO : return "PUNTO";
         case ClaseLexica.ENDWHILE : return "ENDWHILE";
         case ClaseLexica.ENDIF : return "ENDIF";
         case ClaseLexica.ENT: return "ENT";
         case ClaseLexica.REAL : return "REAL";
         case ClaseLexica.OF : return "OF";
         //case ClaseLexica.EOF : return "EOF";
         case ClaseLexica.TRUE : return "TRUE";
         case ClaseLexica.FALSE : return "FALSE";
         case ClaseLexica.NEW : return "NEW";
         case ClaseLexica.MENOR : return "MENOR";
         case ClaseLexica.MENOR_IGUAL : return "MENOR_IGUAL";
         case ClaseLexica.MAYOR: return "MAYOR";
         case ClaseLexica.MAYOR_IGUAL : return "MAYOR_IGUAL";
         case ClaseLexica.MENOS : return "MENOS";
         case ClaseLexica.MAS : return "MAS";
         case ClaseLexica.MOD : return "MOD";
         case ClaseLexica.NULL : return "NULL";
         case ClaseLexica.FLECHA : return "FLECHA";
         case ClaseLexica.NUM_ENTERO : return "NUM_ENTERO";
         case ClaseLexica.NUM_REAL: return "NUM_REAL";
         case ClaseLexica.ELSE : return "ELSE";
         case ClaseLexica.WHILE : return "WHILE";
         case ClaseLexica.IDEN : return "IDEN";
         case ClaseLexica.NL : return "NL";
         case ClaseLexica.READ : return "READ";
         case ClaseLexica.POINTER : return "POINTER";
         case ClaseLexica.STRING : return "STRING";
         case ClaseLexica.THEN : return "THEN";
         case ClaseLexica.DO : return "DO";
         case ClaseLexica.VAR : return "VAR";
         case ClaseLexica.PAR_CIER : return "PAR_CIER";
         case ClaseLexica.PAR_APER : return "PAR_APER";
         default: return "?";               
       }
      }
}
