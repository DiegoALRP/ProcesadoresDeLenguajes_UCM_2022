package alex;

public class ALexOperations {
  private AnalizadorLexicoTiny alex;
  public ALexOperations(AnalizadorLexicoTiny alex) {
   this.alex = alex;   
  }
  public UnidadLexica unidadEntero() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.ENT); 
  }
  public UnidadLexica unidadReal() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.REAL); 
  }
  public UnidadLexica unidadBool() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.BOOL); 
  }
  public UnidadLexica unidadTrue() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.TRUE); 
  }
  public UnidadLexica unidadFalse() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.FALSE); 
  }
  public UnidadLexica unidadAnd() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.AND); 
  }
  public UnidadLexica unidadOr() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.OR); 
  }
  public UnidadLexica unidadNot() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.NOT); 
  }
  public UnidadLexica unidadString() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.STRING); 
  }
  public UnidadLexica unidadNull() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.NULL); 
  }
  public UnidadLexica unidadProcedimiento() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PROCEDIMIENTO); 
  }
  public UnidadLexica unidadIf() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.IF); 
  }
  public UnidadLexica unidadThen() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.THEN); 
  }
  public UnidadLexica unidadElse() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.ELSE); 
  }
  public UnidadLexica unidadEndIf() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.ENDIF); 
  }
  public UnidadLexica unidadWhile() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.WHILE); 
  }
  public UnidadLexica unidadDo() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.DO); 
  }
  public UnidadLexica unidadEndWhile() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.ENDWHILE); 
  }
  public UnidadLexica unidadCall() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.CALL); 
  }
  public UnidadLexica unidadRecord() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.RECORD); 
  }
  public UnidadLexica unidadArray() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.ARRAY); 
  }
  public UnidadLexica unidadOf() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.OF); 
  }
  public UnidadLexica unidadPointer() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.POINTER); 
  }
  public UnidadLexica unidadNew() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.NEW); 
  }
  public UnidadLexica unidadDelete() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.DELETE); 
  }
  public UnidadLexica unidadRead() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.READ); 
  }
  public UnidadLexica unidadWrite() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.WRITE); 
  }
  public UnidadLexica unidadNl() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.Nl); 
  }
  public UnidadLexica unidadVar() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.VAR); 
  }
  public UnidadLexica unidadType() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.TYPE); 
  }
  public UnidadLexica unidadId() {
     return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(),ClaseLexica.IDEN,alex.lexema());
  }
  
   public UnidadLexica unidadLitCadena() {
      return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(),ClaseLexica.LIT_CADENA, alex.lexema());
   }
   
   
  public UnidadLexica unidadNumEnt() {
     return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(),ClaseLexica.ENT,alex.lexema()); 
  } 
  public UnidadLexica unidadNumReal() {
     return new UnidadLexicaMultivaluada(alex.fila(), alex.columna(),ClaseLexica.REAL,alex.lexema()); 
  } 
  public UnidadLexica unidadMas() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MAS); 
  } 
  public UnidadLexica unidadMenos() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOS); 
  } 
  public UnidadLexica unidadMul() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.POR); 
  }
  public UnidadLexica unidadDiv() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.DIV); 
  }
  public UnidadLexica unidadMod() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MOD); 
  }
  public UnidadLexica unidadCorcheteApertura() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.CORCHE_APER); 
  }
  public UnidadLexica unidadCorcheteCierre() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.CORCHE_CIER); 
  }
  public UnidadLexica unidadCorcheRectApertura() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.CORCHE_RECT_APER); 
  }
  public UnidadLexica unidadCorcheRectCierre() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.CORCHE_RECT_CIER); 
  }
  public UnidadLexica unidadParAper() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PAR_APER); 
  } 
  public UnidadLexica unidadParCier() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PAR_CIER); 
  } 
  public UnidadLexica unidadIgual() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.IGUAL); 
  } 
  public UnidadLexica unidadIgualIgual() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.IGUAL_IGUAL); 
  }

  public UnidadLexica unidadMenor() {
	   return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOR);
  }
  public UnidadLexica unidadMayor() {
	  return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MAYOR);
   }

   public UnidadLexica unidadMayorIgual() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MAYOR_IGUAL);
   }

   public UnidadLexica unidadMenorIgual() {
	  return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.MENOR_IGUAL);
   }

  public UnidadLexica unidadDistinto() {
	 return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.DISTINTO);
  }
  public UnidadLexica unidadComa() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.COMA); 
   } 
   public UnidadLexica unidadSepSeccion() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.SEP_SECCION); 
    }
   public UnidadLexica unidadEof() {
     return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.EOF); 
   }

   public UnidadLexica unidadAmpersand() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.AMPERSAND); 
   }
   public UnidadLexica unidadPuntoComa() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PUNTO_COMA); 
   }
   public UnidadLexica unidadFlecha() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.FLECHA); 
   }
   public UnidadLexica unidadPunto() {
      return new UnidadLexicaUnivaluada(alex.fila(), alex.columna(),ClaseLexica.PUNTO); 
   }
  public void error() {
    System.err.println("***"+alex.fila()+" Caracter inexperado: "+alex.lexema());
  }


}
