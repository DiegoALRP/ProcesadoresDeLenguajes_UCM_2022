package procesamientos;

import asint.TinyASint.Prog_con_decs;
import asint.TinyASint.Prog_sin_decs;
import asint.TinyASint.Punto;
import asint.TinyASint.Suma;
import asint.TinyASint.TipoBool;
import asint.TinyASint.TipoEntero;
import asint.TinyASint.TipoReal;
import asint.TinyASint.TipoString;
import asint.TinyASint.TipoVar_array;
import asint.TinyASint.Resta;
import asint.TinyASint.Mul;
import asint.TinyASint.Div;
import asint.TinyASint.Else_muchos;
import asint.TinyASint.Else_ninguno;
import asint.TinyASint.Dec_proc;
import asint.TinyASint.SDec_muchas;
import asint.TinyASint.SDec_una;
import asint.TinyASint.Dec_type;
import asint.TinyASint.Dec_var;
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
import asint.TinyASint.SInst_muchas;
import asint.TinyASint.SInst_una;
import asint.TinyASint.AndOperation;
import asint.TinyASint.Array;
import asint.TinyASint.Bloque_con;
import asint.TinyASint.Bloque_sin;
import asint.TinyASint.OrOperation;
import asint.TinyASint.ParamFormales_con;
import asint.TinyASint.ParamFormales_sin;
import asint.TinyASint.ParamReales_muchos;
import asint.TinyASint.ParamReales_uno;
import asint.TinyASint.Param_amps;
import asint.TinyASint.Param_normal;
import asint.TinyASint.PointerAst;
import asint.TinyASint.Mayor_que;
import asint.TinyASint.Menor_que;
import asint.TinyASint.Mod;
import asint.TinyASint.Mayor_igual_que;
import asint.TinyASint.Menor_igual_que;
import asint.TinyASint.Igual_igual;
import asint.TinyASint.Distinto_distinto;
import asint.TinyASint.Negativo;
import asint.TinyASint.NotOperation;
import asint.TinyASint.Nulo;
import asint.TinyASint.OPDec;
import asint.TinyASint.Campo;
import asint.TinyASint.Entero;
import asint.TinyASint.Real;
import asint.TinyASint.TipoVar_iden;
import asint.TinyASint.TipoVar_pointer;
import asint.TinyASint.TipoVar_record;
import asint.TinyASint.TrueExp;


import asint.ProcesamientoPorDefecto;
import asint.TinyASint.Exp;
import asint.TinyASint.FalseExp;
import asint.TinyASint.Flecha;
import asint.TinyASint.IdenExp;


public class Impresion extends ProcesamientoPorDefecto {
    
    public Impresion() {
    }
	
     public void procesa(Prog_sin_decs prog) { 
         prog.sinst().procesa(this);
	 }
 public void procesa(Prog_con_decs prog) {
	 prog.opdec().procesa(this);
	 System.out.println("&&");
	 prog.sinst().procesa(this);
 }
    public void procesa(OPDec op){
    	op.sdec().procesa(this);
		System.out.println();
    }

	public void procesa(SDec_una sdec){
    	sdec.dec().procesa(this);
	}  
	
   public void procesa(SDec_muchas sdec){
    	sdec.decs().procesa(this);
    	System.out.println(";");
      	sdec.dec().procesa(this);
	}   
   
	public void procesa(Dec_type dec){
		System.out.print("type ");
		dec.tipo().procesa(this);
		System.out.print(" ");
		System.out.print(dec.var());
	}
	
	public void procesa(Dec_var dec){
		System.out.print("var ");
		dec.tipo().procesa(this);
		System.out.print(" ");
		System.out.print(dec.var());
	}  
	
	public void procesa(Dec_proc dec){
		System.out.print("proc ");
		System.out.print(dec.iden());
		System.out.print(" (");
        if(dec.params()!=null){
		    dec.params().procesa(this);
        }
		System.out.print(") {");
		System.out.println();
		dec.bloque().procesa(this);
		System.out.print("}");
	}   
	public void procesa(TipoVar_iden tipo){
		System.out.print(tipo.iden());
	}
	
	public void procesa(TipoVar_pointer tipo){
		System.out.print("pointer ");
      	tipo.subtipo().procesa(this);
	}  

	public void procesa(TipoVar_array tipo){
		System.out.print("array");
		System.out.print("["+tipo.tam()+"] ");
      	System.out.print("of ");
      	tipo.subtipo().procesa(this);
	}  

	public void procesa(Lista_param_uno param){
		param.param().procesa(this);
	} 

	public void procesa(Lista_param_muchos param){
		param.listaParam().procesa(this);
        System.out.print(", ");
		param.param().procesa(this);
	} 

    public void procesa(ParamFormales_con params){
        params.listaParam().procesa(this);
    }
    public void procesa(ParamFormales_sin params) {

    }

    public void procesa(TipoVar_record tipo){
        System.out.print("record");
        System.out.println("{");
        tipo.campos().procesa(this);
        System.out.println();
        System.out.print("}");
    }
    
    public void procesa(Param_amps param_amps) {
        param_amps.tipo().procesa(this);
        System.out.print("& " + param_amps.iden());
    }
    public void procesa(Param_normal param_normal) {
        param_normal.tipo().procesa(this);
        System.out.print(" "+param_normal.iden());
    }

    public void procesa(Bloque_con bloque) {
        bloque.programa().procesa(this);
        System.out.println();
    }

    public void procesa(Bloque_sin bloque) {
        System.out.println();
    }

    public void procesa(Inst_asig inst_asig) {
        inst_asig.exp1().procesa(this);
        System.out.print(" = ");
        inst_asig.exp2().procesa(this);
    }
    public void procesa(Inst_if inst_if) {
       System.out.print("if ");
       inst_if.exp0().procesa(this);
       System.out.println(" then ");
       inst_if.sInst().procesa(this);
       System.out.println();
       inst_if.elsee().procesa(this);
       System.out.println();
       System.out.print(" endif");
    }

	public void procesa(Else_muchos _else) {
        System.out.println("else");
		_else.sinst().procesa(this);
	}
    public void procesa(Else_ninguno else_ninguno) {
        
    }
	public void procesa(Inst_write inst_write) {
		System.out.print("write ");
        inst_write.exp0().procesa(this);
	}
    public void procesa(Inst_while inst_while) {
        System.out.print("while ");
        inst_while.exp0().procesa(this);
        System.out.print(" do ");
        System.out.println();
        inst_while.sInst().procesa(this);
        System.out.println();
        System.out.print("endwhile");
    }
    public void procesa(Inst_read inst_read) {
        System.out.print("read ");
        inst_read.exp0().procesa(this);
        //System.out.println();
    }
    public void procesa(Inst_nl inst_nl) {
        System.out.print("nl");
    }
    public void procesa(Inst_new inst_new) {
        System.out.print("new ");
        inst_new.exp0().procesa(this);
        //System.out.println();
    }
    public void procesa(Inst_delete inst_delete) {
        System.out.print("delete ");
        inst_delete.exp0().procesa(this);
        //System.out.println();
    }
    public void procesa(Inst_call inst_call) {
        System.out.print("call ");
        System.out.print(inst_call.iden());
        System.out.print(" (");
        inst_call.paramReales().procesa(this);
        System.out.print(") ");
        //System.out.println();
    }
    public void procesa(Inst_bloque inst_bloque) {
        System.out.println("{");
        inst_bloque.bloque().procesa(this);
        System.out.println("}");
    }

   public void procesa(ListaCampos_uno campo) {
    	campo.campo().procesa(this);
   }

   public void procesa(ListaCampos_muchos campo) {
		campo.lista_campos().procesa(this);
		System.out.println(";");
    	campo.campo().procesa(this);
   }

    public void procesa(Campo campo) {
    	campo.tipo().procesa(this);
		System.out.print(" ");
		System.out.print(campo.ide());
   }

    //ParamReales
    public void procesa(ParamReales_muchos paramReales_muchos) {
        paramReales_muchos.paramReales().procesa(this);
        System.out.print(", ");
        paramReales_muchos.exp0().procesa(this);
        //System.out.println();
    }
    public void procesa(ParamReales_uno paramReales_uno) {
        paramReales_uno.exp0().procesa(this);
        //System.out.println();
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
   public void procesa(Mod mod) {
       imprime_arg(mod.arg0(), 4);
       System.out.print(" % ");
       imprime_arg(mod.arg1(), 4);
   }
   public void procesa(NotOperation exp) {
      System.out.print(" not ");
      exp.arg0().procesa(this);       
   }
   public void procesa(Negativo exp) {
      System.out.print(" - ");
      exp.arg0().procesa(this);       
   }

   public void procesa(Array array) {
       array.arg0().procesa(this);
       System.out.print("[");
       array.arg1().procesa(this);
       System.out.print("] ");
   }
   public void procesa(Punto punto) {
       punto.e5().procesa(this);
       System.out.print( "." + punto.iden());
   }
   public void procesa(Flecha flecha) {
       flecha.e5().procesa(this);
       System.out.print("->" + flecha.iden());
   }

   public void procesa(PointerAst pointerAst) {
       System.out.print("* " + pointerAst.arg0());
   }

   public void procesa(TrueExp exp) {
      System.out.print("true");     
   }
   public void procesa(FalseExp exp) {
      System.out.print("false");     
   }
   public void procesa(Entero exp) {
      System.out.print(exp.num());     
   }
   public void procesa(Real exp) {
      System.out.print(exp.num());
   }
   public void procesa(LitExp litExp) {
       System.out.print(litExp.var());
   }
   public void procesa(IdenExp idenExp) {
       System.out.print(idenExp.var());
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
    public void procesa(TipoString tipoString) {
        System.out.print("string");
    }
   
    //Nulo
    public void procesa(Nulo nulo) {
        System.out.print("null");
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

            