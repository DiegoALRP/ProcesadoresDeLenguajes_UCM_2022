package procesamientos;

import asint.TinyASint.Suma;
import asint.TinyASint.Resta;
import asint.TinyASint.Mul;
import asint.TinyASint.Div;
import asint.TinyASint.Dec; 
import asint.TinyASint.SDec;  
import asint.TinyASint.SDec_muchas;
import asint.TinyASint.SDec_una;
import asint.TinyASint.Prog;  
import asint.ProcesamientoPorDefecto;
import java.util.HashMap;

class Valores extends HashMap<String,Double> {}//<String, Object>

//TODO
public class Evaluacion extends ProcesamientoPorDefecto {
    //Estados
   private Valores valores;
   private double resul;
   public Evaluacion() {
       valores = new Valores();
   }

   public void procesa(Prog prog)  {
       prog.sdec().procesa(this);
       prog.sinst().procesa(this);
   }

   public void procesa(SDec_muchas decs) {//hmm
       decs.dec().procesa(this);
       decs.decs().procesa(this);
   }

   public void procesa(SDec_una decs) {
       decs.dec().procesa(this);
   }

   public void procesa(Dec dec) {//inst
       if (valores.containsKey(dec.var().toString())) {
          throw new RuntimeException("Constante ya definida "+dec.var()+
                                        ".Fila: "+dec.var().fila()+", col: "+dec.var().col());
       }
        else {//hmmm eso solo seria tipos, como lo tiene el profe seria valores
           valores.put(dec.id().toString(), Double.valueOf(dec.val().toString()).doubleValue());
        }   
   }
   
   public void procesa(Suma exp) {
       exp.arg0().procesa(this);
       double v0 = resul;
       exp.arg1().procesa(this);
       resul += v0;
   }
   public void procesa(Resta exp) {
       exp.arg0().procesa(this);
       double v0 = resul;
       exp.arg1().procesa(this);
       resul = v0 - resul;
   }
   public void procesa(Mul exp) {
       exp.arg0().procesa(this);
       double v0 = resul;
       exp.arg1().procesa(this);
       resul *= v0;
   }
   public void procesa(Div exp) {
       exp.arg0().procesa(this);
       double v0 = resul;
       exp.arg1().procesa(this);
       resul = v0 / resul;
   }
   public void procesa(Id exp) {
       Double val = valores.get(exp.id().toString());
       if (val == null)
          throw new RuntimeException("Constante no definida:"+exp.id().toString()+
                                    ". Fila: "+exp.id().fila()+", col: "+exp.id().col());
       else 
         resul = val; 
   }
   public void procesa(Num exp) {
       resul = Double.valueOf(exp.num().toString()).doubleValue();
   }
}   
 
