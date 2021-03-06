/* ConstructorAST.java */
/* Generated By:JavaCC: Do not edit this line. ConstructorAST.java */
package c_ast_descendente;

import asint.TinyASint.ParamReales;
import asint.TinyASint.ParamFormales;
import asint.TinyASint.Else;
import asint.TinyASint.Exp;
import asint.TinyASint.Param;
import asint.TinyASint.ListaParam;
import asint.TinyASint.ListaCampos;
import asint.TinyASint.Dec;
import asint.TinyASint.SDec;
import asint.TinyASint.SInst;
import asint.TinyASint.OPDec;
import asint.TinyASint.Suma;
import asint.TinyASint.TipoVar;
import asint.TinyASint.TipoVar_array;
import asint.TinyASint.TipoVar_iden;
import asint.TinyASint.TipoVar_record;
import asint.TinyASint.Resta;
import asint.TinyASint.SDec_muchas;
import asint.TinyASint.SDec_una;
import asint.TinyASint.SInst_muchas;
import asint.TinyASint.SInst_una;
import asint.TinyASint.Mul;
import asint.TinyASint.Negativo;
import asint.TinyASint.NotOperation;
import asint.TinyASint.Nulo;
import asint.TinyASint.OPDec;
import asint.TinyASint.Div;
import asint.TinyASint.Else_muchos;
import asint.TinyASint.Entero;
import asint.TinyASint.Flecha;
import asint.TinyASint.IdenExp;
import asint.TinyASint.Igual_igual;
import asint.TinyASint.Inst;
import asint.TinyASint.ListaCampos_muchos;
import asint.TinyASint.ListaCampos_uno;
import asint.TinyASint.Lista_param_muchos;
import asint.TinyASint.Lista_param_uno;
import asint.TinyASint.LitExp;
import asint.TinyASint.Mayor_igual_que;
import asint.TinyASint.Mayor_que;
import asint.TinyASint.Menor_igual_que;
import asint.TinyASint.Menor_que;
import asint.TinyASint.Mod;
import asint.TinyASint.OrOperation;
import asint.TinyASint.ParamReales_muchos;
import asint.TinyASint.ParamReales_uno;
import asint.TinyASint.Param_amps;
import asint.TinyASint.Param_normal;
import asint.TinyASint.PointerAst;
import asint.TinyASint.Prog;
import asint.TinyASint.Punto;
import asint.TinyASint.AndOperation;
import asint.TinyASint.Array;
import asint.TinyASint.Bloque;
import asint.TinyASint.FalseExp;
import asint.TinyASint.TrueExp;
import asint.TinyASint.Campo;
import asint.TinyASint.Dec_proc;
import asint.TinyASint.Dec_type;
import asint.TinyASint.Dec_var;
import asint.TinyASint.Distinto_distinto;
import asint.TinyASint.Real;
import semops.SemOps;

public class ConstructorAST implements ConstructorASTConstants {
   private SemOps sem = new SemOps();

  final public Prog Ini() throws ParseException {Prog prog;
    prog = Programa();
    jj_consume_token(0);
{if ("" != null) return prog;}
    throw new Error("Missing return statement in function");
}

  final public Prog Programa() throws ParseException {OPDec sdec; SInst sinst;
    sdec = OPDec();
    sinst = SInst();
{if ("" != null) return sem.prog(sdec,sinst);}
    throw new Error("Missing return statement in function");
}

  final public OPDec OPDec() throws ParseException {SDec sdec;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case procedimiento:
    case var:
    case type:{
      sdec = SDec();
      jj_consume_token(43);
      jj_consume_token(43);
{if ("" != null) return sem.opdec(sdec);}
      break;
      }
    default:
      jj_la1[0] = jj_gen;
{if ("" != null) return null;}
    }
    throw new Error("Missing return statement in function");
}

  final public SDec SDec() throws ParseException {Dec dec; SDec resul;
    dec = Dec();
    resul = RSDec(sem.sdec_una(dec));
{if ("" != null) return resul;}
    throw new Error("Missing return statement in function");
}

  final public SDec RSDec(SDec decah) throws ParseException {SDec resul; Dec dec;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 44:{
      jj_consume_token(44);
      dec = Dec();
      resul = RSDec(sem.sdec_muchas(decah, dec));
{if ("" != null) return resul;}
      break;
      }
    default:
      jj_la1[1] = jj_gen;
{if ("" != null) return decah;}
    }
    throw new Error("Missing return statement in function");
}

  final public Dec Dec() throws ParseException {TipoVar tipo; Token t; ParamFormales param; Bloque bloq;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case var:{
      jj_consume_token(var);
      tipo = TipoVar();
      t = jj_consume_token(iden);
{if ("" != null) return sem.dec_var(tipo, sem.str(t.image, t.beginLine, t.beginColumn));}
      break;
      }
    case type:{
      jj_consume_token(type);
      tipo = TipoVar();
      t = jj_consume_token(iden);
{if ("" != null) return sem.dec_type(tipo,sem.str(t.image, t.beginLine, t.beginColumn) );}
      break;
      }
    case procedimiento:{
      jj_consume_token(procedimiento);
      t = jj_consume_token(iden);
      jj_consume_token(45);
      param = ParamFormales();
      jj_consume_token(46);
      jj_consume_token(47);
      bloq = Bloque();
      jj_consume_token(48);
{if ("" != null) return sem.dec_proc( sem.str(t.image, t.beginLine, t.beginColumn),param, bloq);}
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
}

  final public TipoVar TipoVar() throws ParseException {Token t; TipoVar tipo; ListaCampos campos;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case ent:{
      jj_consume_token(ent);
{if ("" != null) return sem.tipoEntero();}
      break;
      }
    case real:{
      jj_consume_token(real);
{if ("" != null) return sem.tipoReal();}
      break;
      }
    case bool:{
      jj_consume_token(bool);
{if ("" != null) return sem.tipoBool();}
      break;
      }
    case string:{
      jj_consume_token(string);
{if ("" != null) return sem.tipoString();}
      break;
      }
    case iden:{
      t = jj_consume_token(iden);
{if ("" != null) return sem.tipoVar_iden(sem.str(t.image, t.beginLine, t.beginColumn));}
      break;
      }
    case pointer:{
      jj_consume_token(pointer);
      tipo = TipoVar();
{if ("" != null) return  sem.tipoVar_pointer(tipo);}
      break;
      }
    case array:{
      jj_consume_token(array);
      jj_consume_token(49);
      t = jj_consume_token(numeroEntero);
      jj_consume_token(50);
      jj_consume_token(of);
      tipo = TipoVar();
{if ("" != null) return sem.tipoVar_array( sem.str(t.image, t.beginLine, t.beginColumn), tipo);}
      break;
      }
    case record:{
      jj_consume_token(record);
      jj_consume_token(47);
      campos = ListaCampos();
      jj_consume_token(48);
{if ("" != null) return sem.tipoVar_record(campos);}
      break;
      }
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
}

  final public ListaCampos ListaCampos() throws ParseException {Campo campo; ListaCampos resul;
    campo = Campo();
    resul = RListaCampos(sem.listaCampos_uno(campo));
{if ("" != null) return resul;}
    throw new Error("Missing return statement in function");
}

  final public ListaCampos RListaCampos(ListaCampos rlistacampoah0) throws ParseException {Campo campo; ListaCampos resul;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 44:{
      jj_consume_token(44);
      campo = Campo();
      resul = RListaCampos(sem.listaCampos_muchos(rlistacampoah0,campo));
{if ("" != null) return resul;}
      break;
      }
    default:
      jj_la1[4] = jj_gen;
{if ("" != null) return rlistacampoah0;}
    }
    throw new Error("Missing return statement in function");
}

  final public Campo Campo() throws ParseException {Token t; TipoVar tipo;
    tipo = TipoVar();
    t = jj_consume_token(iden);
{if ("" != null) return sem.campo(tipo,sem.str(t.image, t.beginLine, t.beginColumn));}
    throw new Error("Missing return statement in function");
}

  final public ParamFormales ParamFormales() throws ParseException {ListaParam lista;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case ent:
    case real:
    case bool:
    case string:
    case record:
    case array:
    case pointer:
    case iden:{
      lista = ListaParam();
{if ("" != null) return sem.paramFormales_con(lista);}
      break;
      }
    default:
      jj_la1[5] = jj_gen;
{if ("" != null) return sem.paramFormales_sin();}
    }
    throw new Error("Missing return statement in function");
}

  final public ListaParam ListaParam() throws ParseException {Param paramah; ListaParam resul;
    paramah = Param();
    resul = RListaParam(sem.lista_param_uno(paramah));
{if ("" != null) return resul;}
    throw new Error("Missing return statement in function");
}

  final public ListaParam RListaParam(ListaParam paramah0) throws ParseException {ListaParam resul;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 51:{
      jj_consume_token(51);
      resul = RListaParam(sem.lista_param_muchos(paramah0,Param()));
{if ("" != null) return resul;}
      break;
      }
    default:
      jj_la1[6] = jj_gen;
{if ("" != null) return paramah0;}
    }
    throw new Error("Missing return statement in function");
}

  final public Param Param() throws ParseException {TipoVar rparamah; Param resul;
    rparamah = TipoVar();
    resul = RParam(rparamah);
{if ("" != null) return resul;}
    throw new Error("Missing return statement in function");
}

  final public Param RParam(TipoVar rparamah) throws ParseException {Token t;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 43:{
      jj_consume_token(43);
      t = jj_consume_token(iden);
{if ("" != null) return sem.param_amps(rparamah,sem.str(t.image, t.beginLine, t.beginColumn));}
      break;
      }
    case iden:{
      t = jj_consume_token(iden);
{if ("" != null) return sem.param_normal(rparamah,sem.str(t.image, t.beginLine, t.beginColumn));}
      break;
      }
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
}

  final public Bloque Bloque() throws ParseException {Prog resultado;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
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
    case 55:{
      resultado = Programa();
{if ("" != null) return sem.bloque_con(resultado);}
      break;
      }
    default:
      jj_la1[8] = jj_gen;
{if ("" != null) return sem.bloque_sin();}
    }
    throw new Error("Missing return statement in function");
}

  final public SInst SInst() throws ParseException {Inst inst; SInst resultado;
    inst = Inst();
    resultado = RInst(sem.sinst_uno(inst));
{if ("" != null) return resultado;}
    throw new Error("Missing return statement in function");
}

  final public SInst RInst(SInst rinstH) throws ParseException {Inst inst; SInst rinst;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 44:{
      jj_consume_token(44);
      inst = Inst();
      rinst = RInst(sem.sinst_muchos(rinstH, inst));
{if ("" != null) return rinst;}
      break;
      }
    default:
      jj_la1[9] = jj_gen;
{if ("" != null) return rinstH;}
    }
    throw new Error("Missing return statement in function");
}

  final public Inst Inst() throws ParseException {Exp exp0, exp01, exp02; SInst sinst; Else elsee; ParamReales paramReales; Token t; Bloque bloque;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
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
    case 55:{
      exp01 = E0();
      jj_consume_token(52);
      exp02 = E0();
{if ("" != null) return sem.inst_asig(exp01, exp02);}
      break;
      }
    case If:{
      jj_consume_token(If);
      exp0 = E0();
      jj_consume_token(Then);
      sinst = SInst();
      elsee = Else();
      jj_consume_token(endif);
{if ("" != null) return sem.inst_if(exp0, sinst, elsee);}
      break;
      }
    case While:{
      jj_consume_token(While);
      exp0 = E0();
      jj_consume_token(Do);
      sinst = SInst();
      jj_consume_token(endwhile);
{if ("" != null) return sem.inst_while(exp0, sinst);}
      break;
      }
    case read:{
      jj_consume_token(read);
      exp0 = E0();
{if ("" != null) return sem.inst_read(exp0);}
      break;
      }
    case write:{
      jj_consume_token(write);
      exp0 = E0();
{if ("" != null) return sem.inst_write(exp0);}
      break;
      }
    case nl:{
      jj_consume_token(nl);
{if ("" != null) return sem.inst_nl();}
      break;
      }
    case New:{
      jj_consume_token(New);
      exp0 = E0();
{if ("" != null) return sem.inst_new(exp0);}
      break;
      }
    case delete:{
      jj_consume_token(delete);
      exp0 = E0();
{if ("" != null) return sem.inst_delete(exp0);}
      break;
      }
    case call:{
      jj_consume_token(call);
      t = jj_consume_token(iden);
      jj_consume_token(45);
      paramReales = ParamReales();
      jj_consume_token(46);
{if ("" != null) return sem.inst_call(sem.str(t.image, t.beginLine, t.beginColumn), paramReales);}
      break;
      }
    case 47:{
      jj_consume_token(47);
      bloque = Bloque();
      jj_consume_token(48);
{if ("" != null) return sem.inst_bloque(bloque);}
      break;
      }
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
}

  final public Else Else() throws ParseException {SInst sinst;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case Else:{
      jj_consume_token(Else);
      sinst = SInst();
{if ("" != null) return sem.else_muchos(sinst);}
      break;
      }
    default:
      jj_la1[11] = jj_gen;
{if ("" != null) return sem.else_ninguno();}
    }
    throw new Error("Missing return statement in function");
}

  final public ParamReales ParamReales() throws ParseException {ParamReales resultado; Exp exp0;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
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
    case 55:{
      exp0 = E0();
      resultado = RParamReales(sem.param_reales_uno(exp0));
{if ("" != null) return resultado;}
      break;
      }
    default:
      jj_la1[12] = jj_gen;
{if ("" != null) return sem.param_reales_ninguno();}
    }
    throw new Error("Missing return statement in function");
}

  final public ParamReales RParamReales(ParamReales rpaH) throws ParseException {Exp exp0; ParamReales resultado;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 51:{
      jj_consume_token(51);
      exp0 = E0();
      resultado = RParamReales(sem.param_reales_muchos(rpaH, exp0));
{if ("" != null) return resultado;}
      break;
      }
    default:
      jj_la1[13] = jj_gen;

{if ("" != null) return rpaH;}
    }
    throw new Error("Missing return statement in function");
}

  final public Exp E0() throws ParseException {Exp exp1, resultado;
    exp1 = E1();
    resultado = RE0(exp1);
{if ("" != null) return resultado;}
    throw new Error("Missing return statement in function");
}

  final public Exp RE0(Exp expH) throws ParseException {Exp exp0; Exp exp1; String operation;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 53:{
      jj_consume_token(53);
      exp0 = E0();
{if ("" != null) return sem.suma(expH, exp0);}
      break;
      }
    case 54:{
      jj_consume_token(54);
      exp1 = E1();
{if ("" != null) return sem.resta(expH, exp1);}
      break;
      }
    default:
      jj_la1[14] = jj_gen;
{if ("" != null) return expH;}
    }
    throw new Error("Missing return statement in function");
}

  final public Exp E1() throws ParseException {Exp exp2, resultado;
    exp2 = E2();
    resultado = RE1(exp2);
{if ("" != null) return resultado;}
    throw new Error("Missing return statement in function");
}

  final public Exp RE1(Exp expH) throws ParseException {String operation; Exp exp2, resultado;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case and:
    case or:{
      operation = OP1AI();
      exp2 = E2();
      resultado = RE1(sem.exp(operation, expH, exp2));
{if ("" != null) return resultado;}
      break;
      }
    default:
      jj_la1[15] = jj_gen;
{if ("" != null) return expH;}
    }
    throw new Error("Missing return statement in function");
}

  final public Exp E2() throws ParseException {Exp exp3, resultado;
    exp3 = E3();
    resultado = RE2(exp3);
{if ("" != null) return resultado;}
    throw new Error("Missing return statement in function");
}

  final public Exp RE2(Exp expH) throws ParseException {String operation; Exp exp3, resultado;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 56:
    case 57:
    case 58:
    case 59:
    case 60:
    case 61:{
      operation = OP2AI();
      exp3 = E3();
      resultado = RE2(sem.exp(operation, expH, exp3));
{if ("" != null) return resultado;}
      break;
      }
    default:
      jj_la1[16] = jj_gen;
{if ("" != null) return expH;}
    }
    throw new Error("Missing return statement in function");
}

  final public Exp E3() throws ParseException {Exp exp4, resultado;
    exp4 = E4();
    resultado = RE3(exp4);
{if ("" != null) return resultado;}
    throw new Error("Missing return statement in function");
}

  final public Exp RE3(Exp expH) throws ParseException {String operation; Exp exp4;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 55:
    case 62:
    case 63:{
      operation = OP3NA();
      exp4 = E4();
{if ("" != null) return sem.exp(operation, expH, exp4);}
      break;
      }
    default:
      jj_la1[17] = jj_gen;
{if ("" != null) return expH;}
    }
    throw new Error("Missing return statement in function");
}

  final public Exp E4() throws ParseException {Exp exp4, exp5;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 54:{
      jj_consume_token(54);
      exp5 = E5();
{if ("" != null) return sem.negativoOperation(exp5);}
      break;
      }
    case not:{
      jj_consume_token(not);
      exp4 = E4();
{if ("" != null) return sem.notOperation(exp4) ;}
      break;
      }
    case True:
    case False:
    case Null:
    case lit_cadena:
    case numeroEntero:
    case numeroReal:
    case iden:
    case 45:
    case 55:{
      exp5 = E5();
{if ("" != null) return exp5;}
      break;
      }
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
}

  final public Exp E5() throws ParseException {Exp exp6, resultado;
    exp6 = E6();
    resultado = RRE5(exp6);
{if ("" != null) return resultado;}
    throw new Error("Missing return statement in function");
}

  final public Exp RRE5(Exp rre5H) throws ParseException {Exp re5, resultado;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 49:
    case 64:
    case 65:{
      re5 = RE5(rre5H);
      resultado = RRE5(re5);
{if ("" != null) return resultado;}
      break;
      }
    default:
      jj_la1[19] = jj_gen;
{if ("" != null) return rre5H;}
    }
    throw new Error("Missing return statement in function");
}

  final public Exp RE5(Exp expH) throws ParseException {String operation; Exp exp0; Token t;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 49:{
      jj_consume_token(49);
      exp0 = E0();
      jj_consume_token(50);
{if ("" != null) return sem.array_op(expH, exp0);}
      break;
      }
    case 64:
    case 65:{
      operation = OP5A();
      t = jj_consume_token(iden);
{if ("" != null) return sem.exp_acc(operation, expH, sem.str(t.image, t.beginLine, t.beginColumn));}
      break;
      }
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
}

  final public Exp E6() throws ParseException {Exp exp6, exp7;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 55:{
      jj_consume_token(55);
      exp6 = E6();
{if ("" != null) return sem.pointer_ast(exp6);}
      break;
      }
    case True:
    case False:
    case Null:
    case lit_cadena:
    case numeroEntero:
    case numeroReal:
    case iden:
    case 45:{
      exp7 = E7();
{if ("" != null) return exp7;}
      break;
      }
    default:
      jj_la1[21] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
}

  final public Exp E7() throws ParseException {Token t; Exp exp0;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case True:{
      jj_consume_token(True);
{if ("" != null) return sem.true_exp();}
      break;
      }
    case False:{
      jj_consume_token(False);
{if ("" != null) return sem.false_exp();}
      break;
      }
    case numeroEntero:{
      t = jj_consume_token(numeroEntero);
{if ("" != null) return sem.entero(sem.str(t.image, t.beginLine, t.beginColumn));}
      break;
      }
    case numeroReal:{
      t = jj_consume_token(numeroReal);
{if ("" != null) return sem.real(sem.str(t.image, t.beginLine, t.beginColumn));}
      break;
      }
    case lit_cadena:{
      t = jj_consume_token(lit_cadena);
{if ("" != null) return sem.lit_cadena(sem.str(t.image, t.beginLine, t.beginColumn));}
      break;
      }
    case Null:{
      jj_consume_token(Null);
{if ("" != null) return sem.nulo();}
      break;
      }
    case 45:{
      jj_consume_token(45);
      exp0 = E0();
      jj_consume_token(46);
{if ("" != null) return exp0;}
      break;
      }
    case iden:{
      t = jj_consume_token(iden);
{if ("" != null) return sem.identificador(sem.str(t.image, t.beginLine, t.beginColumn));}
      break;
      }
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
}

  final public String OP1AI() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case and:{
      jj_consume_token(and);
{if ("" != null) return "and";}
      break;
      }
    case or:{
      jj_consume_token(or);
{if ("" != null) return "or";}
      break;
      }
    default:
      jj_la1[23] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
}

  final public String OP2AI() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 56:{
      jj_consume_token(56);
{if ("" != null) return ">";}
      break;
      }
    case 57:{
      jj_consume_token(57);
{if ("" != null) return "<";}
      break;
      }
    case 58:{
      jj_consume_token(58);
{if ("" != null) return "<=";}
      break;
      }
    case 59:{
      jj_consume_token(59);
{if ("" != null) return ">=";}
      break;
      }
    case 60:{
      jj_consume_token(60);
{if ("" != null) return "==";}
      break;
      }
    case 61:{
      jj_consume_token(61);
{if ("" != null) return "!=";}
      break;
      }
    default:
      jj_la1[24] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
}

  final public String OP3NA() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 55:{
      jj_consume_token(55);
{if ("" != null) return "*";}
      break;
      }
    case 62:{
      jj_consume_token(62);
{if ("" != null) return "/";}
      break;
      }
    case 63:{
      jj_consume_token(63);
{if ("" != null) return "%";}
      break;
      }
    default:
      jj_la1[25] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
}

  final public String OP5A() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case 64:{
      jj_consume_token(64);
{if ("" != null) return ".";}
      break;
      }
    case 65:{
      jj_consume_token(65);
{if ("" != null) return "->";}
      break;
      }
    default:
      jj_la1[26] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
}

  /** Generated Token Manager. */
  public ConstructorASTTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[27];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static {
	   jj_la1_init_0();
	   jj_la1_init_1();
	   jj_la1_init_2();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0x80000,0x0,0x80000,0xb0020e00,0x0,0xb0020e00,0x0,0x0,0x91d3000,0x0,0x9153000,0x400000,0x53000,0x0,0x0,0xc000,0x0,0x0,0x53000,0x0,0x0,0x43000,0x43000,0xc000,0x0,0x0,0x0,};
	}
	private static void jj_la1_init_1() {
	   jj_la1_1 = new int[] {0x60,0x1000,0x60,0x400,0x1000,0x400,0x80000,0xc00,0xc0a7ff,0x1000,0xc0a79f,0x0,0xc02780,0x80000,0x600000,0x0,0x3f000000,0xc0800000,0xc02780,0x20000,0x20000,0x802780,0x2780,0x0,0x3f000000,0xc0800000,0x0,};
	}
	private static void jj_la1_init_2() {
	   jj_la1_2 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x3,0x3,0x0,0x0,0x0,0x0,0x0,0x3,};
	}

  /** Constructor with InputStream. */
  public ConstructorAST(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ConstructorAST(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new ConstructorASTTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public ConstructorAST(java.io.Reader stream) {
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new ConstructorASTTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new ConstructorASTTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public ConstructorAST(ConstructorASTTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ConstructorASTTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 27; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
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


/** Get the next Token. */
  final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[66];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 27; i++) {
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
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  private boolean trace_enabled;

/** Trace enabled. */
  final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
