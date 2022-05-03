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

    public static class Mod extends ExpMultiplicativa {
        public Mod(Exp arg0, Exp arg1) {
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
    public static abstract class Acceso extends ExpBin{
        public Acceso(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        
        @Override
        public int prioridad() {
            return 5;
        }
        
    }

    public static class Flecha extends Op5A {
        public Flecha(Exp E5, StringLocalizado iden) {
            super(E5, iden);
        }
        public void procesa(Procesamiento p) {
           p.procesa(this); 
        }     
    }
    public abstract static class Op5A extends Exp{
        private Exp E5;
        private StringLocalizado iden;
        public Op5A(Exp E5, StringLocalizado iden){
            this.E5 = E5;
            this.iden = iden;
        }
        public Exp e5(){return E5;}
        public StringLocalizado iden(){return iden;}
        public int prioridad() {
			return 5;
		}    
    }
    public static class Punto extends Op5A {
        public Punto(Exp E5, StringLocalizado iden) {
            super(E5, iden);
        }
        public void procesa(Procesamiento p) {
           p.procesa(this); 
        }
    }
    
    public static class Array extends Acceso{ 
        public Array(Exp arg0, Exp arg1) {
            super(arg0,arg1);
        }
        public void procesa(Procesamiento p) {
           p.procesa(this); 
        }    
    }
    //E6
    
    public static class PointerAst extends ExpUn {
        public PointerAst(Exp arg0) {
            super(arg0);
        }
        public final int prioridad() {
            return 6;
        }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    
    //E7
    public static class BooleanExp extends Exp{
        private String booleanString;
        public BooleanExp(String arg0) {
            this.booleanString = arg0;
        }
        public String val() {return booleanString;}
        @Override
        public int prioridad() {
            return 7;
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
            return 7;
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
            return 7;
        }
        @Override
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    
    public static class IdenExp extends Exp {
        private StringLocalizado var;
        public IdenExp(StringLocalizado arg0) {
            this.var = arg0;
        }

        public StringLocalizado var() {return var;}
        
        @Override
        public int prioridad() {
            return 7;
        }
        @Override
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }

    public static class LitExp extends Exp {
        private StringLocalizado var;
        public LitExp(StringLocalizado arg0) {
            this.var = arg0;
        }

        public StringLocalizado var() {return var;}
        
        @Override
        public int prioridad() {
            return 7;
        }
        @Override
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }

    public static class Nulo extends Exp {
        public Nulo() {
        }

        @Override
        public int prioridad() {
            return 7;
        }
        @Override
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }



    //
    public static abstract class Dec {
        public Dec() {
        }
        public abstract void procesa(Procesamiento p);
    }
    
    public static class Dec_var extends Dec {
        private TipoVar tipo;
        private StringLocalizado var;
        public Dec_var(TipoVar tipo, StringLocalizado var){
            super();
            this.tipo=tipo;
            this.var=var;
        }
        public TipoVar tipo(){return tipo;}
        public StringLocalizado var(){return var;}
        @Override
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }

    public static class Dec_type extends Dec{
        private TipoVar tipo;
        private StringLocalizado var;
        public Dec_type(TipoVar tipo, StringLocalizado var){
            super();
            this.tipo=tipo;
            this.var=var;
        }
        public TipoVar tipo(){return tipo;}
        public StringLocalizado var(){return var;}
        @Override
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    public static class Dec_proc extends Dec {
        private StringLocalizado iden;
        private ParamFormales params;
        private Bloque bloque;
        public Dec_proc(StringLocalizado iden, ParamFormales params, Bloque bloque){
            super();
            this.iden=iden;
            this.params=params;
            this.bloque = bloque;
        }
        public StringLocalizado iden(){return iden;}
        public ParamFormales params() { return this.params; }
        public Bloque bloque() { return this.bloque; }
        @Override
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }

    public static class ParamFormales {
        private ListaParam list;
        public ParamFormales(ListaParam list){
            this.list=list;
        }
        public ListaParam list(){return list;}
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }

    public static abstract class ListaParam {
        public ListaParam() {

        }
        public abstract void procesa(Procesamiento p);
    }

    public static class Lista_param_muchos extends ListaParam {
        private ListaParam listaParam;
        private Param param;
        public Lista_param_muchos(ListaParam listaParam, Param param) {
            this.listaParam = listaParam;
            this.param = param;
        }
        public ListaParam listaParam() { return this.listaParam; }
        public Param param() { return this.param; }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
        
    }
    public static class Lista_param_uno extends ListaParam {
        private Param param;
        public Lista_param_uno(Param param) {
            this.param = param;
        }
        public Param param() { return this.param; }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    
    public static abstract class Param {
        public Param() {
        }
        public abstract void procesa(Procesamiento p);
    }

    public static class Param_amps extends Param {
        private TipoVar rparamah;
        private StringLocalizado iden;
        public Param_amps(TipoVar rparamah, StringLocalizado iden) {
            this.rparamah = rparamah;
            this.iden = iden;
        }
        public TipoVar tipo() { return rparamah; }
        public StringLocalizado iden() { return this.iden; }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    public static class Param_normal extends Param {
         private TipoVar rparamah;
        private StringLocalizado iden;
        public Param_normal(TipoVar rparamah, StringLocalizado iden) {
            this.rparamah = rparamah;
            this.iden = iden;
        }
        public TipoVar tipo() { return rparamah; }
        public StringLocalizado iden() { return this.iden; }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    
    public static class TipoVar {
        private String tipo;
        public TipoVar(String tipo){
            this.tipo=tipo;
        }
        public String tipo(){return tipo;}
        public void procesa(Procesamiento p) {
           p.procesa(this); 
        }     
    }
    public static class TipoVar_iden extends TipoVar {
        private StringLocalizado subtipo;
        public TipoVar_iden(StringLocalizado subtipo){
            super(subtipo.s);
            this.subtipo=subtipo;
        }
        public StringLocalizado iden(){ return subtipo;}
        public void procesa(Procesamiento p) {
           p.procesa(this); 
        }     
    }
     public static class TipoVar_pointer extends TipoVar {
        private TipoVar subtipo;
        public TipoVar_pointer(TipoVar subtipo){
            super("pointer");
            this.subtipo=subtipo;
        }
        public TipoVar subtipo(){return subtipo;}
        public void procesa(Procesamiento p) {
           p.procesa(this); 
        }     
    }

     public static class TipoVar_array extends TipoVar {
        private TipoVar subtipo;
        private StringLocalizado tam;
        public TipoVar_array(StringLocalizado tam,TipoVar subtipo){
            super("array");
            this.subtipo=subtipo;
            this.tam=tam;
        }
        public TipoVar subtipo(){return subtipo;}
        public StringLocalizado tam(){return tam;}
        public void procesa(Procesamiento p) {
           p.procesa(this); 
        }     
    }
     public static class TipoVar_record extends TipoVar {
        private ListaCampos campos;
        public TipoVar_record(ListaCampos campos){
            super("record");
            this.campos = campos;
        }
        public ListaCampos campos(){return campos;}
        public void procesa(Procesamiento p) {
           p.procesa(this); 
        }     
    }
    public static abstract class ListaCampos{
        public abstract void procesa(Procesamiento p);
    }

    public static class ListaCampos_uno extends ListaCampos{
        private Campo campo;
        public ListaCampos_uno(Campo campo){
            this.campo = campo;
        }
        public Campo campo(){return campo;}
        @Override
        public void procesa(Procesamiento p){
            p.procesa(this);
        }
    }

    public static class ListaCampos_muchos extends ListaCampos{
        private Campo campo;
        private ListaCampos campos;
        public ListaCampos_muchos(ListaCampos campos,Campo campo){
            this.campo = campo;
            this.campos =  campos;
        }
        public Campo campo(){return campo;}
        public ListaCampos lista_campos(){return campos;}
        public void procesa(Procesamiento p){
            p.procesa(this);
        }
    }

    public static class Campo{
        private TipoVar tipo;
        private StringLocalizado ide;
        public Campo(TipoVar tipo, StringLocalizado ide){
            this.tipo=tipo;
            this.ide=ide;
        }
        public TipoVar tipo(){return tipo;}
        public StringLocalizado ide(){return ide;}
        public void procesa(Procesamiento p){
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
        private OPDec sdec;
        private SInst sinst;
       public Prog(OPDec decs, SInst sinst) {
           this.sdec = decs;
            this.sinst = sinst;
	    }
        public OPDec opdec(){return sdec;}
        public SInst sinst(){return sinst;}
	    public void procesa(Procesamiento p){
           p.procesa(this);
       }
    }

    public static class OPDec{
        private SDec  sdec;
        public OPDec(SDec sdec){
            this.sdec = sdec;
        }
        public SDec sdec(){return sdec;}
	    public void procesa(Procesamiento p){
           p.procesa(this);
       }
    }

    public static class Bloque {
        private Prog programa;
        public Bloque(Prog programa) {
            this.programa = programa;
        }
        public Prog programa() { return this.programa; }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }

    public static abstract class Inst {
        public Inst() {
        }
        public abstract void procesa(Procesamiento p);
    }
    public static class Inst_asig extends Inst {
        private Exp exp1;
        private Exp exp2;
        public Inst_asig(Exp exp1, Exp exp2) {
            this.exp1 = exp1;
            this.exp2 = exp2;
        }
        public Exp exp1() { return this.exp1; }
        public Exp exp2() { return this.exp2; }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    public static class Inst_if extends Inst {
        private Exp exp0;
        private SInst sInst;
        private Else elsee;
        public Inst_if(Exp exp0, SInst sInst, Else elsee) {
            this.exp0 = exp0;
            this.sInst = sInst;
            this.elsee = elsee;
        }
        public Exp exp0() { return this.exp0; } 
        public SInst sInst() { return this.sInst; }
        public Else elsee() { return this.elsee; }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    public static class Inst_while extends Inst {
        private Exp exp0;
        private SInst sInst;
        public Inst_while(Exp exp0, SInst sInst) {
            this.exp0 = exp0;
            this.sInst = sInst;
        }
        public Exp exp0() { return this.exp0; }
        public SInst sInst() {return this.sInst; }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    public static class Inst_read extends Inst {
        private Exp exp0;
        public Inst_read(Exp exp0) {
            this.exp0 = exp0;
        }
        public Exp exp0() { return this.exp0; }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    public static class Inst_write extends Inst {
        private Exp exp0;
        public Inst_write(Exp exp0) {
            this.exp0 = exp0;
        }
        public Exp exp0() { return this.exp0; }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    public static class Inst_nl extends Inst {
        private String nl;
        public Inst_nl(String nl) {
            this.nl = nl;
        }
        public String nl() { return this.nl; }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    public static class Inst_new extends Inst {
        private Exp exp0;
        public Inst_new(Exp exp0) {
            this.exp0 = exp0;
        }
        public Exp exp0() { return this.exp0; }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    public static class Inst_delete extends Inst {
        private Exp exp0;
        public Inst_delete(Exp exp0) {
            this.exp0 = exp0;
        }
        public Exp exp0() { return this.exp0; }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    public static class Inst_call extends Inst {
        private StringLocalizado iden;
        private ParamReales paramReales;
        public Inst_call(StringLocalizado iden, ParamReales paramReales) {
            this.iden = iden;
            this.paramReales = paramReales;
        }
        public StringLocalizado iden() { return this.iden; }
        public ParamReales paramReales() { return this.paramReales; }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    public static class Inst_bloque extends Inst {
        private Bloque bloque;
        public Inst_bloque(Bloque bloque) {
            this.bloque = bloque;
        }
        public Bloque bloque() { return this.bloque; } 
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

    public static abstract class Else {
        public Else() {
        }
        public abstract void procesa(Procesamiento p);
    }
    public static class Else_muchos extends Else {
        private SInst sInst;
        public Else_muchos(SInst sInst) {
            this.sInst = sInst;
        }
        public SInst sinst() {return this.sInst;}
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }

    public static abstract class ParamReales {
        public ParamReales() {
        }
        public abstract void procesa(Procesamiento p);
    }

    public static class ParamReales_uno extends ParamReales {
        private Exp exp0;
        public ParamReales_uno(Exp exp0) {
            this.exp0 = exp0;
        }
        public Exp exp0() { return this.exp0; }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    public static class ParamReales_muchos extends ParamReales {
        private ParamReales paramReales;
        private Exp exp0;
        public ParamReales_muchos(ParamReales paramReales, Exp exp0) {
            this.paramReales = paramReales;
            this.exp0 = exp0;
        }
        public ParamReales paramReales() { return this.paramReales; }
        public Exp exp0() { return this.exp0; }
        public void procesa(Procesamiento p) {
            p.procesa(this);
        }
    }
    
    
    // Constructoras
   
   public Prog prog(OPDec decs, SInst sinst){
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
    public Exp mod(Exp arg0, Exp arg1){
        return new Mod(arg0,arg1);
    }
    public Exp negativoOperation(Exp arg0) {
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
    public Exp lit_cadena(StringLocalizado arg0) {
        return new LitExp(arg0);
    }
    public Exp identificador(StringLocalizado arg) {
        return new IdenExp(arg);
    }
    public Exp flecha(Exp arg0, StringLocalizado arg1){
        return new Flecha(arg0, arg1);
    }
    public Exp punto(Exp arg0, StringLocalizado arg1){
        return new Punto(arg0, arg1);
    }
    public Exp array_op(Exp arg0, Exp arg1){
        return new Array(arg0, arg1);
    }
    public Exp pointer_ast(Exp arg0){
        return new PointerAst(arg0);
    }
    public TipoVar tipoVar(String tipo){
        return new TipoVar(tipo);
    }
    public TipoVar tipoVar_iden(StringLocalizado subtipo){
        return new TipoVar_iden(subtipo);
    }
    public TipoVar tipoVar_pointer(TipoVar sub){
        return new TipoVar_pointer(sub); 
    } 
    public TipoVar tipoVar_array(StringLocalizado tam,TipoVar subtipo){
        return new TipoVar_array(tam, subtipo);
    }
    public TipoVar tipoVar_record(ListaCampos campos){
        return new TipoVar_record(campos);
    }
    public SDec sdec_una(Dec dec) {
        return new SDec_una(dec);
    }
    public SDec sdec_muchas(SDec decs, Dec dec) {
        return new SDec_muchas(decs,dec);
    }
    public SInst sinst_uno(Inst inst){
        return new SInst_una(inst);
    }
    public SInst sinst_muchos(SInst sinst, Inst inst){
        return new SInst_muchas(sinst, inst);
    }
    public StringLocalizado str(String s, int fila, int col) {
        return new StringLocalizado(s,fila,col);
    }
    public Else else_muchos(SInst sInst) {
        return new Else_muchos(sInst);
    }
    public ParamReales param_reales_uno(Exp exp0) {
        return new ParamReales_uno(exp0);
    }
    public ParamReales param_reales_muchos(ParamReales paramReales, Exp exp0) {
        return new ParamReales_muchos(paramReales, exp0);
    }
    public Dec dec_var(TipoVar tipo, StringLocalizado var){
        return new Dec_var(tipo, var);
    }
    public Dec dec_type(TipoVar tipo, StringLocalizado var){
        return new Dec_type(tipo, var);
    }
    public Dec dec_proc(StringLocalizado iden, ParamFormales params, Bloque bloque){
        return new Dec_proc(iden, params, bloque);
    }

    public ParamFormales param_formales(ListaParam list){
        return new ParamFormales(list);
    }


    public Campo campo(TipoVar tipo, StringLocalizado ide){
        return new Campo(tipo, ide);
    }

    public ListaCampos listaCampos_uno(Campo campo){
        return new ListaCampos_uno(campo);
    }
    
    public ListaCampos listaCampos_muchos(ListaCampos campos, Campo campo){
        return new ListaCampos_muchos(campos, campo);
    }

    public Inst inst_asig(Exp exp1, Exp exp2) {
        return new Inst_asig(exp1, exp2);
    }
    public Inst inst_if(Exp exp0, SInst sInst, Else elsee) {
        return new Inst_if(exp0, sInst, elsee);
    }
    public Inst inst_while(Exp exp0, SInst sInst) {
        return new Inst_while(exp0, sInst);
    }
    public Inst inst_read(Exp exp0) {
        return new Inst_read(exp0);
    }
    public Inst inst_write(Exp exp0) {
        return new Inst_write(exp0);
    }
    public Inst inst_nl(String nl) {
        return new Inst_nl(nl);
    }
    public Inst inst_new(Exp exp0) {
        return new Inst_new(exp0);
    }
    public Inst inst_delete(Exp exp0) {
        return new Inst_delete(exp0);
    }
    public Inst inst_call(StringLocalizado iden, ParamReales paramReales) {
        return new Inst_call(iden, paramReales);
    }
    public Inst inst_bloque(Bloque bloque) {
        return new Inst_bloque(bloque);
    }
    public OPDec opdec(SDec sdec){
        return new OPDec(sdec);
    }
    public Bloque bloque(Prog programa){
        return new Bloque(programa);
    }

    public ListaParam lista_param_uno(Param param){
        return new Lista_param_uno(param);
    }
    public ListaParam lista_param_muchos(ListaParam listaParam, Param param){
        return new Lista_param_muchos(listaParam, param);
    }  
    public Param param_amps(TipoVar rparamah, StringLocalizado iden){
        return new Param_amps(rparamah, iden);
    } 
    public Param param_normal(TipoVar rparamah, StringLocalizado iden){
        return new Param_normal(rparamah,iden);
    } 
	public Nulo nulo() {
        return new Nulo();
    }

}
