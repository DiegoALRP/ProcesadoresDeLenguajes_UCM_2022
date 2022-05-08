package procesamientos;

import asint.TinyASint.Prog;
import asint.TinyASint.Suma;
import asint.TinyASint.TipoBool;
import asint.TinyASint.TipoEntero;
import asint.TinyASint.TipoReal;
import asint.TinyASint.TrueExp;
import asint.TinyASint.Resta;
import asint.TinyASint.Mul;
import asint.TinyASint.Div;
import asint.TinyASint.Dec;
import asint.TinyASint.SDec_muchas;
import asint.TinyASint.SDec_una;
import asint.TinyASint.VaribleExp;
import asint.TinyASint.Inst;
import asint.TinyASint.SInst_muchas;
import asint.TinyASint.SInst_una;
import asint.TinyASint.AndOperation;
import asint.TinyASint.OrOperation;
import asint.TinyASint.Mayor_que;
import asint.TinyASint.Menor_que;
import asint.TinyASint.Mayor_igual_que;
import asint.TinyASint.Menor_igual_que;
import asint.TinyASint.Igual_igual;
import asint.TinyASint.Distinto_distinto;
import asint.TinyASint.Negativo;
import asint.TinyASint.NotOperation;
import asint.TinyASint.Entero;
import asint.TinyASint.Real;
import asint.ProcesamientoPorDefecto;
import asint.TinyASint.Exp;
import asint.TinyASint.FalseExp;


public class Impresion extends ProcesamientoPorDefecto {
    
    public Impresion() {
    }
    public void procesa(Prog prog) {
        prog.sdec().procesa(this);
        System.out.println();
        System.out.println("&&");
        prog.sinst().procesa(this); //procesa la expresion
        System.out.println();
    }  

   public void procesa(SDec_muchas sdec){
    	sdec.decs().procesa(this);
    	System.out.println(";");
      	sdec.dec().procesa(this);
	}   
   
	public void procesa(SDec_una sdec){
    	sdec.dec().procesa(this);
	}  

    public void procesa(Dec dec) {
    	dec.tipo().procesa(this);
        System.out.print(" = " + dec.var());
    }

    public void procesa(Inst inst){
        System.out.print(inst.var() + " = ");
        inst.exp().procesa(this);
    }

    public void procesa(SInst_muchas sinst){
        sinst.sinst().procesa(this);
        System.out.println(";");
        sinst.inst().procesa(this);
    }

    public void procesa(SInst_una sinst){
        sinst.inst().procesa(this);
    }

   public void procesa(Suma exp) {
      imprime_arg(exp.arg0(),1); 
      System.out.print(" + ");
      imprime_arg(exp.arg1(),0);       
   }
   public void procesa(Resta exp) {
      imprime_arg(exp.arg0(),1); 
      System.out.print(" - ");
      imprime_arg(exp.arg1(),1);       
   }

   public void procesa(AndOperation exp) {
      imprime_arg(exp.arg0(),1); 
      System.out.print(" and ");
      imprime_arg(exp.arg1(),2);       
   }
   public void procesa(OrOperation exp) {
      imprime_arg(exp.arg0(),1); 
      System.out.print(" or ");
      imprime_arg(exp.arg1(),2);       
   }
   public void procesa(Mayor_que exp) {
      imprime_arg(exp.arg0(),2); 
      System.out.print(" > ");
      imprime_arg(exp.arg1(),3);       
   }
   public void procesa(Menor_que exp) {
      imprime_arg(exp.arg0(),2); 
      System.out.print(" < ");
      imprime_arg(exp.arg1(),3);       
   }
   public void procesa(Mayor_igual_que exp) {
      imprime_arg(exp.arg0(),2); 
      System.out.print(" >= ");
      imprime_arg(exp.arg1(),3);       
   }

   public void procesa(Menor_igual_que exp) {
      imprime_arg(exp.arg0(),2); 
      System.out.print(" <= ");
      imprime_arg(exp.arg1(),3);       
   }

   public void procesa(Igual_igual exp) {
      imprime_arg(exp.arg0(),2); 
      System.out.print(" == ");
      imprime_arg(exp.arg1(),3);       
   }
   public void procesa(Distinto_distinto exp) {
      imprime_arg(exp.arg0(),2); 
      System.out.print(" != ");
      imprime_arg(exp.arg1(),3);       
   }

   public void procesa(Mul exp) {
      imprime_arg(exp.arg0(),4); 
      System.out.print(" * ");
      imprime_arg(exp.arg1(),4);       
   }
   public void procesa(Div exp) {
      imprime_arg(exp.arg0(),4); 
      System.out.print(" / ");
      imprime_arg(exp.arg1(),4);       
   }
   public void procesa(NotOperation exp) {
      System.out.print(" not ");
      exp.arg0().procesa(this);       
   }
   public void procesa(Negativo exp) {
      System.out.print(" - ");
      exp.arg0().procesa(this);       
   }
   public void procesa(TrueExp exp){
      System.out.print("true");
   }
   public void procesa(FalseExp exp){
      System.out.print("false");
   }
   public void procesa(Entero exp) {
      System.out.print(exp.num());     
   }
   public void procesa(Real exp) {
      System.out.print(exp.num());     
   }
   public void procesa(VaribleExp exp) {
      System.out.print(exp.var());     
   }

   public void procesa(TipoEntero tipoEntero) {
      System.out.print("int");
   }
   public void procesa(TipoReal tipoReal) {
       System.out.print("real");
   }
   public void procesa(TipoBool tipoBool) {
       System.out.print("bool");
   }

   //Metodo auxiliar
   private void imprime_arg(Exp arg, int p) {
       if (arg.prioridad() < p) {
           System.out.print("(");
           arg.procesa(this);
           System.out.print(")");
       }
       else {
           arg.procesa(this);
       }
   }
}   

            