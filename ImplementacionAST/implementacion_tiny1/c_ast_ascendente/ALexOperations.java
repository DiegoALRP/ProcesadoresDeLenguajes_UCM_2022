package c_ast_ascendente;
import ClaseLexica;

public class ALexOperations {
  private AnalizadorLexicoTiny alex;
  public ALexOperations(AnalizadorLexicoTiny alex) {
   this.alex = alex;   
  }
  public UnidadLexica unidadEntero() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.ENT, "int"); 
  }
  public UnidadLexica unidadReal() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.REAL, "real"); 
  }
  public UnidadLexica unidadBool() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.BOOL, "bool"); 
  }
  public UnidadLexica unidadTrue() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.TRUE, "true"); 
  }
  public UnidadLexica unidadFalse() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.FALSE, "false"); 
  }
  public UnidadLexica unidadAnd() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.AND, "and"); 
  }
  public UnidadLexica unidadOr() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.OR, "or"); 
  }
  public UnidadLexica unidadNot() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.NOT, "not"); 
  }
  public UnidadLexica unidadString() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.STRING, "string"); 
  }
  public UnidadLexica unidadNull() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.NULL, "null"); 
  }
  public UnidadLexica unidadProcedimiento() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.PROCEDIMIENTO, "proc"); 
  }
  public UnidadLexica unidadIf() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.IF, "if"); 
  }
  public UnidadLexica unidadThen() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.THEN, "then"); 
  }
  public UnidadLexica unidadElse() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.ELSE, "else"); 
  }
  public UnidadLexica unidadEndIf() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.ENDIF, "endif"); 
  }
  public UnidadLexica unidadWhile() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.WHILE, "while"); 
  }
  public UnidadLexica unidadDo() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.DO, "do"); 
  }
  public UnidadLexica unidadEndWhile() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.ENDWHILE, "endwhile"); 
  }
  public UnidadLexica unidadCall() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.CALL, "call"); 
  }
  public UnidadLexica unidadRecord() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.RECORD, "record"); 
  }
  public UnidadLexica unidadArray() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.ARRAY, "array"); 
  }
  public UnidadLexica unidadOf() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.OF, "of"); 
  }
  public UnidadLexica unidadPointer() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.POINTER, "pointer"); 
  }
  public UnidadLexica unidadNew() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.NEW, "new"); 
  }
  public UnidadLexica unidadDelete() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.DELETE, "delete"); 
  }
  public UnidadLexica unidadRead() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.READ, "read"); 
  }
  public UnidadLexica unidadWrite() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.WRITE, "write"); 
  }
  public UnidadLexica unidadNl() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.NL, "nl"); 
  }
  public UnidadLexica unidadVar() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.VAR, "var"); 
  }
  public UnidadLexica unidadType() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.TYPE, "type"); 
  }
  public UnidadLexica unidadId() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.IDEN,alex.lexema());
  }
  
   public UnidadLexica unidadLitCadena() {
      return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.LIT_CADENA, alex.lexema());
   }
   
   
  public UnidadLexica unidadNumEnt() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.NUM_ENTERO,alex.lexema()); 
  } 
  public UnidadLexica unidadNumReal() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.NUM_REAL,alex.lexema()); 
  } 
  public UnidadLexica unidadMas() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.MAS, "+"); 
  } 
  public UnidadLexica unidadMenos() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.MENOS, "-"); 
  } 
  public UnidadLexica unidadMul() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.POR, "*"); 
  }
  public UnidadLexica unidadDiv() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.DIV, "/"); 
  }
  public UnidadLexica unidadMod() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.MOD, "%"); 
  }
  public UnidadLexica unidadCorcheteApertura() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.CORCHE_APER, "{"); 
  }
  public UnidadLexica unidadCorcheteCierre() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.CORCHE_CIER, "}"); 
  }
  public UnidadLexica unidadCorcheRectApertura() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.CORCHE_RECT_APER, "["); 
  }
  public UnidadLexica unidadCorcheRectCierre() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.CORCHE_RECT_CIER, "]"); 
  }
  public UnidadLexica unidadParAper() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.PAR_APER, "("); 
  } 
  public UnidadLexica unidadParCier() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.PAR_CIER, ")"); 
  } 
  public UnidadLexica unidadIgual() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.IGUAL, "="); 
  } 
  public UnidadLexica unidadIgualIgual() {
      return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.IGUAL_IGUAL, "=="); 
  }

  public UnidadLexica unidadMenor() {
	   return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.MENOR, "<");
  }
  public UnidadLexica unidadMayor() {
	  return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.MAYOR, ">");
   }

   public UnidadLexica unidadMayorIgual() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.MAYOR_IGUAL, ">=");
   }

   public UnidadLexica unidadMenorIgual() {
	  return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.MENOR_IGUAL, "<=");
   }

  public UnidadLexica unidadDistinto() {
	 return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.DISTINTO, "!=");
  }
  public UnidadLexica unidadComa() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.COMA, ","); 
   } 
   public UnidadLexica unidadSepSeccion() {
      return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.SEP_SECCION, "&&"); 
    }
   public UnidadLexica unidadEof() {
     return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.EOF, "<EOF>"); 
   }

   public UnidadLexica unidadAmpersand() {
      return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.AMPERSAND, "&"); 
   }
   public UnidadLexica unidadPuntoComa() {
      return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.PUNTO_COMA, ";"); 
   }
   public UnidadLexica unidadFlecha() {
      return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.FLECHA, "->"); 
   }
   public UnidadLexica unidadPunto() {
      return new UnidadLexica(alex.fila(), alex.columna(),ClaseLexica.PUNTO, "."); 
   }
  /*public void error() {
    System.err.println("***"+alex.fila()+" Caracter inexperado: "+alex.lexema());
  }*/


}
