package asint;

import asint.TinyASint.Suma;
import asint.TinyASint.TipoBool;
import asint.TinyASint.TipoEntero;
import asint.TinyASint.TipoReal;
import asint.TinyASint.TipoString;
import asint.TinyASint.TipoVar_array;
import asint.TinyASint.TipoVar_iden;
import asint.TinyASint.TipoVar_pointer;
import asint.TinyASint.TipoVar_record;
import asint.TinyASint.TrueExp;
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
import asint.TinyASint.Else_ninguno;
import asint.TinyASint.Entero;
import asint.TinyASint.FalseExp;
import asint.TinyASint.Flecha;
import asint.TinyASint.IdenExp;
import asint.TinyASint.Igual_igual;
import asint.TinyASint.Inst;
import asint.TinyASint.Inst_asig;
import asint.TinyASint.Inst_bloque;
import asint.TinyASint.Inst_call;
import asint.TinyASint.Inst_delete;
import asint.TinyASint.Inst_if;
import asint.TinyASint.Inst_new;
import asint.TinyASint.Inst_nl;
import asint.TinyASint.Inst_read;
import asint.TinyASint.Inst_while;
import asint.TinyASint.Inst_write;
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
import asint.TinyASint.ParamReales_ninguno;
import asint.TinyASint.ParamReales_uno;
import asint.TinyASint.Param_amps;
import asint.TinyASint.Param_normal;
import asint.TinyASint.PointerAst;
import asint.TinyASint.Prog_con_decs;
import asint.TinyASint.Prog_sin_decs;
import asint.TinyASint.Punto;
import asint.TinyASint.AndOperation;
import asint.TinyASint.Array;
import asint.TinyASint.Bloque;
import asint.TinyASint.Bloque_con;
import asint.TinyASint.Bloque_sin;
import asint.TinyASint.Campo;
import asint.TinyASint.Dec_proc;
import asint.TinyASint.Dec_type;
import asint.TinyASint.Dec_var;
import asint.TinyASint.Distinto_distinto;
import asint.TinyASint.Real;

//Procesamiento por defecto, donde no se hace anda
public class ProcesamientoPorDefecto implements Procesamiento {
   public void procesa(Suma exp) {}
   public void procesa(Resta exp) {}
   public void procesa(AndOperation exp) {}
   public void procesa(OrOperation exp) {}
   public void procesa(Mayor_que exp) {}
   public void procesa(Menor_que exp) {}
   public void procesa(Mayor_igual_que exp) {}
   public void procesa(Menor_igual_que exp) {}
   public void procesa(Igual_igual exp) {}
   public void procesa(Distinto_distinto exp) {}
   public void procesa(Mul exp) {}
   public void procesa(Div exp) {}
   public void procesa(Negativo exp) {}
   public void procesa(NotOperation exp) {}
   public void procesa(Entero exp) {}
   public void procesa(Real exp) {}
   public void procesa(SDec_muchas decs) {}
   public void procesa(SDec_una decs) {}
   public void procesa(SInst_muchas sInst_muchas) {}
   public void procesa(SInst_una sInst_una) {}
   public void procesa(Inst inst) {}
   public void procesa(Prog_sin_decs prog_sin_decs) {}
   public void procesa(Prog_con_decs prog_con_decs) {}
   public void procesa(Punto punto) {}
   public void procesa(Flecha flecha) {}
   public void procesa(PointerAst pointerAst) {}
   public void procesa(IdenExp idenExp) {}
   public void procesa(LitExp litExp) {}
   public void procesa(Nulo nulo) {}
   public void procesa(Mod mod) {}
   public void procesa(TipoVar_iden tipoVar_iden) {}
   public void procesa(TipoVar_pointer tipoVar_pointer) {}
   public void procesa(Else_muchos else_muchos) {}
   public void procesa(ParamReales_muchos paramReales_muchos) {}
   public void procesa(ParamReales_uno paramReales_uno) {}
   public void procesa(Array array) {}
   public void procesa(TipoVar_record tipoVar_record) {}
   public void procesa(TipoVar_array tipoVar_array) {}
   public void procesa(ListaCampos_muchos listaCampos_muchos) {}
   public void procesa(ListaCampos_uno listaCampos_uno) {}
   public void procesa(Campo campo) {}
   public void procesa(Dec_proc dec_proc) {}
   public void procesa(Dec_type dec_type) {}
   public void procesa(Dec_var dec_var) {}
   public void procesa(Lista_param_muchos lista_param_muchos) {}
   public void procesa(Lista_param_uno lista_param_uno) {}
   public void procesa(Param_amps param_amps) {}
   public void procesa(Param_normal param_normal) {}
   public void procesa(Bloque bloque) {}
   public void procesa(OPDec opDec) {}
   public void procesa(TipoEntero tipoEntero) {}
	public void procesa(TipoReal tipoReal) {}
	public void procesa(TipoBool tipoBool) {}
   public void procesa(TipoString tipoString) {}
   public void procesa(TrueExp trueExp) {}
	public void procesa(FalseExp falseExp){}
	public void procesa(ParamReales_ninguno paramReales_ninguno) {}
	public void procesa(Else_ninguno else_ninguno) {}
	public void procesa(Bloque_con bloque_con) {}
   public void procesa(Bloque_sin bloque_sin) {}
   public void procesa(Inst_asig inst_asig) {}
   public void procesa(Inst_if inst_if) {  }
   public void procesa(Inst_while inst_while) {}
   public void procesa(Inst_read inst_read) {}
   public void procesa(Inst_write inst_write) {}
   public void procesa(Inst_nl inst_nl) {}
   public void procesa(Inst_new inst_new) {}
   public void procesa(Inst_delete inst_delete) {}
   public void procesa(Inst_call inst_call) {}
   public void procesa(Inst_bloque inst_bloque) {}
}
