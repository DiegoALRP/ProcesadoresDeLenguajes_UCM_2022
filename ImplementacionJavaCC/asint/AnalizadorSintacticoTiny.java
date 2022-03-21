/* Generated By:JavaCC: Do not edit this line. AnalizadorSintacticoTiny.java */
package asint;

public class AnalizadorSintacticoTiny implements AnalizadorSintacticoTinyConstants {

  final public void Ini() throws ParseException {
    Programa();
    jj_consume_token(0);
  }

  final public void Programa() throws ParseException {
    OPDec();
    SInst();
  }

  final public void OPDec() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case procedimiento:
    case var:
    case type:
      SDec();
      jj_consume_token(43);
      jj_consume_token(43);
      break;
    default:
      jj_la1[0] = jj_gen;

    }
  }

  final public void SDec() throws ParseException {
    Dec();
    RSDec();
  }

  final public void RSDec() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 44:
      jj_consume_token(44);
      Dec();
      RSDec();
      break;
    default:
      jj_la1[1] = jj_gen;

    }
  }

  final public void Dec() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case var:
      jj_consume_token(var);
      TipoVar();
      jj_consume_token(iden);
      break;
    case type:
      jj_consume_token(type);
      TipoVar();
      jj_consume_token(iden);
      break;
    case procedimiento:
      jj_consume_token(procedimiento);
      jj_consume_token(iden);
      jj_consume_token(45);
      ParamFormales();
      jj_consume_token(46);
      jj_consume_token(47);
      Bloque();
      jj_consume_token(48);
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void TipoVar() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ent:
      jj_consume_token(ent);
      break;
    case real:
      jj_consume_token(real);
      break;
    case bool:
      jj_consume_token(bool);
      break;
    case string:
      jj_consume_token(string);
      break;
    case iden:
      jj_consume_token(iden);
      break;
    case pointer:
      jj_consume_token(pointer);
      TipoVar();
      break;
    case array:
      jj_consume_token(array);
      jj_consume_token(49);
      jj_consume_token(numeroEntero);
      jj_consume_token(50);
      jj_consume_token(of);
      TipoVar();
      break;
    case record:
      jj_consume_token(record);
      jj_consume_token(47);
      ListaCampos();
      jj_consume_token(48);
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void ListaCampos() throws ParseException {
    Campo();
    RListaCampos();
  }

  final public void RListaCampos() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 44:
      jj_consume_token(44);
      Campo();
      RListaCampos();
      break;
    default:
      jj_la1[4] = jj_gen;

    }
  }

  final public void Campo() throws ParseException {
    TipoVar();
    jj_consume_token(iden);
  }

  final public void ParamFormales() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ent:
    case real:
    case bool:
    case string:
    case record:
    case array:
    case pointer:
    case iden:
      ListaParam();
      break;
    default:
      jj_la1[5] = jj_gen;

    }
  }

  final public void ListaParam() throws ParseException {
    Param();
    RListaParam();
  }

  final public void RListaParam() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 51:
      jj_consume_token(51);
      Param();
      RListaParam();
      break;
    default:
      jj_la1[6] = jj_gen;

    }
  }

  final public void Param() throws ParseException {
    TipoVar();
    RParam();
  }

  final public void RParam() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 43:
      jj_consume_token(43);
      jj_consume_token(iden);
      break;
    case iden:
      jj_consume_token(iden);
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Bloque() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case True:
    case False:
    case not:
    case Null:
    case procedimiento:
    case If:
    case While:
    case call:
    case New:
    case delete:
    case read:
    case write:
    case nl:
    case var:
    case type:
    case lit_cadena:
    case numeroEntero:
    case numeroReal:
    case iden:
    case 45:
    case 47:
    case 54:
    case 55:
      Programa();
      break;
    default:
      jj_la1[8] = jj_gen;

    }
  }

  final public void SInst() throws ParseException {
    Inst();
    RInst();
  }

  final public void RInst() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 44:
      jj_consume_token(44);
      Inst();
      RInst();
      break;
    default:
      jj_la1[9] = jj_gen;

    }
  }

  final public void Inst() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case True:
    case False:
    case not:
    case Null:
    case lit_cadena:
    case numeroEntero:
    case numeroReal:
    case iden:
    case 45:
    case 54:
    case 55:
      E0();
      jj_consume_token(52);
      E0();
      break;
    case If:
      jj_consume_token(If);
      E0();
      jj_consume_token(Then);
      SInst();
      Else();
      jj_consume_token(endif);
      break;
    case While:
      jj_consume_token(While);
      E0();
      jj_consume_token(Do);
      SInst();
      jj_consume_token(endwhile);
      break;
    case read:
      jj_consume_token(read);
      E0();
      break;
    case write:
      jj_consume_token(write);
      E0();
      break;
    case nl:
      jj_consume_token(nl);
      break;
    case New:
      jj_consume_token(New);
      E0();
      break;
    case delete:
      jj_consume_token(delete);
      E0();
      break;
    case call:
      jj_consume_token(call);
      jj_consume_token(iden);
      jj_consume_token(45);
      ParamRales();
      jj_consume_token(46);
      break;
    case 47:
      jj_consume_token(47);
      Bloque();
      jj_consume_token(48);
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Else() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Else:
      jj_consume_token(Else);
      SInst();
      break;
    default:
      jj_la1[11] = jj_gen;

    }
  }

  final public void ParamRales() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case True:
    case False:
    case not:
    case Null:
    case lit_cadena:
    case numeroEntero:
    case numeroReal:
    case iden:
    case 45:
    case 54:
    case 55:
      E0();
      RParamReales();
      break;
    default:
      jj_la1[12] = jj_gen;

    }
  }

  final public void RParamReales() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 51:
      jj_consume_token(51);
      E0();
      RParamReales();
      break;
    default:
      jj_la1[13] = jj_gen;

    }
  }

  final public void E0() throws ParseException {
    E1();
    RE0();
  }

  final public void RE0() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 53:
      jj_consume_token(53);
      E0();
      break;
    case 54:
      jj_consume_token(54);
      E1();
      break;
    default:
      jj_la1[14] = jj_gen;

    }
  }

  final public void E1() throws ParseException {
    E2();
    RE1();
  }

  final public void RE1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case and:
    case or:
      OP1AI();
      E2();
      RE1();
      break;
    default:
      jj_la1[15] = jj_gen;

    }
  }

  final public void E2() throws ParseException {
    E3();
    RE2();
  }

  final public void RE2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 56:
    case 57:
    case 58:
    case 59:
    case 60:
    case 61:
      OP2AI();
      E3();
      RE2();
      break;
    default:
      jj_la1[16] = jj_gen;

    }
  }

  final public void E3() throws ParseException {
    E4();
    RE3();
  }

  final public void RE3() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 55:
    case 62:
    case 63:
      OP3NA();
      E4();
      break;
    default:
      jj_la1[17] = jj_gen;

    }
  }

  final public void E4() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 54:
      jj_consume_token(54);
      E5();
      break;
    case not:
      jj_consume_token(not);
      E4();
      break;
    case True:
    case False:
    case Null:
    case lit_cadena:
    case numeroEntero:
    case numeroReal:
    case iden:
    case 45:
    case 55:
      E5();
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void E5() throws ParseException {
    E6();
    RE5();
  }

  final public void RE5() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 49:
    case 64:
    case 65:
      OP5A();
      RE5();
      break;
    default:
      jj_la1[19] = jj_gen;

    }
  }

  final public void E6() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 55:
      jj_consume_token(55);
      E6();
      break;
    case True:
    case False:
    case Null:
    case lit_cadena:
    case numeroEntero:
    case numeroReal:
    case iden:
    case 45:
      E7();
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void E7() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case True:
      jj_consume_token(True);
      break;
    case False:
      jj_consume_token(False);
      break;
    case numeroEntero:
      jj_consume_token(numeroEntero);
      break;
    case numeroReal:
      jj_consume_token(numeroReal);
      break;
    case lit_cadena:
      jj_consume_token(lit_cadena);
      break;
    case Null:
      jj_consume_token(Null);
      break;
    case 45:
      jj_consume_token(45);
      E0();
      jj_consume_token(46);
      break;
    case iden:
      jj_consume_token(iden);
      break;
    default:
      jj_la1[21] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void OP1AI() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case and:
      jj_consume_token(and);
      break;
    case or:
      jj_consume_token(or);
      break;
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void OP2AI() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 56:
      jj_consume_token(56);
      break;
    case 57:
      jj_consume_token(57);
      break;
    case 58:
      jj_consume_token(58);
      break;
    case 59:
      jj_consume_token(59);
      break;
    case 60:
      jj_consume_token(60);
      break;
    case 61:
      jj_consume_token(61);
      break;
    default:
      jj_la1[23] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void OP3NA() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 55:
      jj_consume_token(55);
      break;
    case 62:
      jj_consume_token(62);
      break;
    case 63:
      jj_consume_token(63);
      break;
    default:
      jj_la1[24] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void OP5A() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 49:
      jj_consume_token(49);
      E0();
      jj_consume_token(50);
      break;
    case 64:
      jj_consume_token(64);
      jj_consume_token(iden);
      break;
    case 65:
      jj_consume_token(65);
      jj_consume_token(iden);
      break;
    default:
      jj_la1[25] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  public AnalizadorSintacticoTinyTokenManager token_source;
  SimpleCharStream jj_input_stream;
  public Token token, jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[26];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static {
      jj_la1_0();
      jj_la1_1();
      jj_la1_2();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0x80000,0x0,0x80000,0xb0020e00,0x0,0xb0020e00,0x0,0x0,0x91d3000,0x0,0x9153000,0x400000,0x53000,0x0,0x0,0xc000,0x0,0x0,0x53000,0x0,0x43000,0x43000,0xc000,0x0,0x0,0x0,};
   }
   private static void jj_la1_1() {
      jj_la1_1 = new int[] {0x60,0x1000,0x60,0x400,0x1000,0x400,0x80000,0xc00,0xc0a7ff,0x1000,0xc0a79f,0x0,0xc02780,0x80000,0x600000,0x0,0x3f000000,0xc0800000,0xc02780,0x20000,0x802780,0x2780,0x0,0x3f000000,0xc0800000,0x20000,};
   }
   private static void jj_la1_2() {
      jj_la1_2 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x3,0x0,0x0,0x0,0x0,0x0,0x3,};
   }

  public AnalizadorSintacticoTiny(java.io.InputStream stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AnalizadorSintacticoTinyTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.InputStream stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
  }

  public AnalizadorSintacticoTiny(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AnalizadorSintacticoTinyTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
  }

  public AnalizadorSintacticoTiny(AnalizadorSintacticoTinyTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
  }

  public void ReInit(AnalizadorSintacticoTinyTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
  }

  final private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  final private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.Vector jj_expentries = new java.util.Vector();
  private int[] jj_expentry;
  private int jj_kind = -1;

  public ParseException generateParseException() {
    jj_expentries.removeAllElements();
    boolean[] la1tokens = new boolean[66];
    for (int i = 0; i < 66; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 26; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
          if ((jj_la1_2[i] & (1<<j)) != 0) {
            la1tokens[64+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 66; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.addElement(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.elementAt(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  final public void enable_tracing() {
  }

  final public void disable_tracing() {
  }

                                       }