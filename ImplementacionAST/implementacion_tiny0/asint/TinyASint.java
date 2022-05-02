package asint;

public class TinyASint {
    
    public static abstract class Exp  {
        public Exp() {
        }
        public abstract int prioridad();
        public abstract void procesa(Procesamiento procesamiento); //Manera genera de procesar la sintaxis
    }
    
    public static class StringLocalizado {

        private String s;
        private int fila;
        private int col;

        public StringLocalizado(String s, int fila, int col) {
            this.s = s;
            this.fila = fila;
            this.col = col;
        }

        public int fila() {return fila;}
        public int col() {return col;}
        public String toString() {
            return s;
        }

        public boolean equals(Object o) {
            return (o == this) || ((o instanceof StringLocalizado) && (((StringLocalizado)o).s.equals(s)));
        }

        public int hashCode() {
            return s.hashCode();
        }
  }

    
    private static abstract class ExpBin extends Exp {
        private Exp arg0;
        private Exp arg1;
        public Exp arg0() {return arg0;}
        public Exp arg1() {return arg1;}
        public ExpBin(Exp arg0, Exp arg1) {
            super();
            this.arg0 = arg0;
            this.arg1 = arg1;
        }
    }

    //E0
    private static abstract class ExpAditiva extends ExpBin {
        public ExpAditiva(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        public final int prioridad() {
            return 0;
        }
    }
    public static class Suma extends ExpAditiva {
        public Suma(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        public void procesa(Procesamiento p) {
           p.procesa(this); 
        }     
    }
    public static class Resta extends ExpAditiva {
        public Resta(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        public void procesa(Procesamiento p) {
           p.procesa(this); 
        }     
    }

    //E1
    private static abstract class OP1AI extends ExpBin {

        public OP1AI(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        public int prioridad() {
            return 1;
        }
    }
    public static class AndOperation extends OP1AI {
        public AndOperation(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    public static class OrOperation extends OP1AI {
        public OrOperation(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    
    //E2
    private static abstract class OP2AI extends ExpBin {

        public OP2AI(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        public int prioridad() {
            return 2;
        }
    }
    public static class Mayor_que extends OP2AI {
        public Mayor_que(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    public static class Menor_que extends OP2AI {
        public Menor_que(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    public static class Mayor_igual_que extends OP2AI {
        public Mayor_igual_que(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    public static class Menor_igual_que extends OP2AI {
        public Menor_igual_que(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    public static class Igual_igual extends OP2AI {
        public Igual_igual(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    public static class Distinto_distinto extends OP2AI {
        public Distinto_distinto(Exp arg0, Exp arg1) {
            super(arg0, arg1);
        }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }

    //E3
    private static abstract class ExpMultiplicativa extends ExpBin {
        public ExpMultiplicativa(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        public final int prioridad() {
            return 3;
        }
    }
    public static class Mul extends ExpMultiplicativa {
        public Mul(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        public void procesa(Procesamiento p) {
           p.procesa(this); 
        }     
    }
    public static class Div extends ExpMultiplicativa {
        public Div(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        public void procesa(Procesamiento p) {
           p.procesa(this); 
        }     
    }

    private static abstract class ExpUn extends Exp {
        private Exp arg0;
        public Exp arg0() {return arg0;}
        public ExpUn(Exp arg0) {
            super();
            this.arg0 = arg0;
        }
    }
    //E4
    public static class Negativo extends ExpUn {
        public Negativo(Exp arg0) {
            super(arg0);
        }
        public final int prioridad() {
            return 4;
        }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    public static class NotOperation extends ExpUn {
        public NotOperation(Exp arg0) {
            super(arg0);
        }
        public final int prioridad() {
            return 4;
        }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }

    //E5
    public static class BooleanExp extends Exp{
        private String booleanString;//solo string??
        public BooleanExp(String arg0) {
            this.booleanString = arg0;//solo string??
        }
        public String val() {return booleanString;}
        @Override
        public int prioridad() {
            return 5;
        }
        @Override
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    
    public static class Entero extends Exp {
        
        private StringLocalizado num_entero;
        
        public Entero(StringLocalizado arg0) {
            this.num_entero = arg0;
        }

        public StringLocalizado num() {return num_entero;}
        
        @Override
        public int prioridad() {
            return 5;
        }

        @Override
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    public static class Real extends Exp {
        private StringLocalizado num_real;
        public Real(StringLocalizado arg0) {
            this.num_real = arg0;
        }

        public StringLocalizado num() {return num_real;}
        
        @Override
        public int prioridad() {
            return 5;
        }
        @Override
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    
    public static class VaribleExp extends Exp {
        private StringLocalizado var;
        public VaribleExp(StringLocalizado arg0) {
            this.var = arg0;
        }

        public StringLocalizado var() {return var;}
        
        @Override
        public int prioridad() {
            return 5;
        }
        @Override
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }

    public static class Dec  {
        private String tipo;
        private StringLocalizado var;
        public Dec(String tipo, StringLocalizado var) {
            this.tipo = tipo;
            this.var = var;
        }
        public String tipo() {return tipo;}
        public StringLocalizado var() {return var;}
        public void procesa(Procesamiento p) {
           p.procesa(this); 
        }     
    }
    public static abstract class SDec {
       public SDec() {
       }
       public abstract void procesa(Procesamiento p);
    }
    public static class SDec_una extends SDec {
       private Dec dec; 
       public SDec_una(Dec dec) {
          super();
          this.dec = dec;
       }   
       public Dec dec() {return dec;}
       public void procesa(Procesamiento p) {
           p.procesa(this); 
        }     
    }
    public static class SDec_muchas extends SDec {
       private Dec dec;
       private SDec decs;
       public SDec_muchas(SDec sdec, Dec dec) {
          super();
          this.dec = dec;
          this.decs = sdec;
       }
       public Dec dec() {return dec;}
       public SDec decs() {return decs;}
       public void procesa(Procesamiento p) {
           p.procesa(this); 
        }     
    }
    public static class Prog {
        SDec sdec;
        SInst sinst;
       public Prog(SDec decs, SInst sinst) {
           this.sdec = decs;
            this.sinst = sinst;
	    }
        public SDec sdec(){return sdec;}
        public SInst sinst(){return sinst;}
	public void procesa(Procesamiento p){
           p.procesa(this);
       }
    }

    public static class Inst {
        private StringLocalizado var;
        private Exp exp;
        public Inst(StringLocalizado var, Exp exp){
            this.var=var;
            this.exp=exp;
        }
        public StringLocalizado var(){return var;}
        public Exp exp(){ return exp;}
        public void procesa(Procesamiento p) {
           p.procesa(this); 
        }  
    }

    public static abstract class SInst {
       public SInst() {
       }
       public abstract void procesa(Procesamiento p);
    }
    public static class SInst_una extends SInst {
       private Inst inst; 
       public SInst_una(Inst inst) {
          super();
          this.inst = inst;
       }   
       public Inst inst() {return inst;}
       public void procesa(Procesamiento p) {
           p.procesa(this); 
        }     
    }
    public static class SInst_muchas extends SInst {
       private Inst inst;
       private SInst sinst;
       public SInst_muchas(SInst sinst, Inst inst) {
          super();
          this.inst = inst;
          this.sinst = sinst;
       }
       public Inst inst() {return inst;}
       public SInst sinst() {return sinst;}
       public void procesa(Procesamiento p) {
           p.procesa(this); 
        }     
    }
    
     // Constructoras    
   
   public Prog prog(SDec decs, SInst sinst){
       return new Prog(decs,sinst);
   }
    
    public Exp suma(Exp arg0, Exp arg1) {
        return new Suma(arg0,arg1);
    }
    public Exp resta(Exp arg0, Exp arg1) {
        return new Resta(arg0,arg1);
    }
    public Exp andOperation(Exp arg0, Exp arg1) {
        return new AndOperation(arg0, arg1);
    }
    public Exp orOperation(Exp arg0, Exp arg1) {
        return new OrOperation(arg0, arg1);
    }
    public Exp mayor_que(Exp arg0, Exp arg1) {
        return new Mayor_que(arg0, arg1);
    }
    public Exp menor_que(Exp arg0, Exp arg1) {
        return new Menor_que(arg0, arg1);
    }
    public Exp mayor_igual_que(Exp arg0, Exp arg1) {
        return new Mayor_igual_que(arg0, arg1);
    }
    public Exp menor_igual_que(Exp arg0, Exp arg1) {
        return new Menor_igual_que(arg0, arg1);
    }
    public Exp igual_igual(Exp arg0, Exp arg1) {
        return new Igual_igual(arg0, arg1);
    }
    public Exp distinto_distinto(Exp arg0, Exp arg1) {
        return new Distinto_distinto(arg0, arg1);
    }
    public Exp mul(Exp arg0, Exp arg1) {
        return new Mul(arg0,arg1);
    }
    public Exp div(Exp arg0, Exp arg1) {
        return new Div(arg0,arg1);
    }
    public Exp nevativoOperation(Exp arg0) {
        return new Negativo(arg0);
    }
    public Exp notOperation(Exp arg0) {
        return new NotOperation(arg0);
    }
    public Exp booleanExp(String arg0) {
        return new BooleanExp(arg0);
    }
    public Exp entero(StringLocalizado arg0) {
        return new Entero(arg0);
    }
    public Exp real(StringLocalizado arg0) {
        return new Real(arg0);
    }
    public Exp var(StringLocalizado arg0) {
        return new VaribleExp(arg0);
    }
    public Dec dec(String tipo, StringLocalizado var) {
        return new Dec(tipo,var);
    }
    public SDec sdec_una(Dec dec) {
        return new SDec_una(dec);
    }
    public SDec sdec_muchas(SDec decs, Dec dec) {
        return new SDec_muchas(decs,dec);
    }
    public Inst inst(StringLocalizado var, Exp exp){
        return new Inst(var, exp);
    }
    public SInst sinst_una(Inst inst){
        return new SInst_una(inst);
    }
    public SInst sinst_muchas(SInst sinst, Inst inst){
        return new SInst_muchas(sinst, inst);
    }
    public StringLocalizado str(String s, int fila, int col) {
        return new StringLocalizado(s,fila,col);
    }
}
