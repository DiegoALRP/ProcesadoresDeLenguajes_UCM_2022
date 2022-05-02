package asint;

import asint.TinyASint.Suma;
import asint.TinyASint.VaribleExp;
import asint.TinyASint.Resta;
import asint.TinyASint.SDec_muchas;
import asint.TinyASint.SDec_una;
import asint.TinyASint.SInst_muchas;
import asint.TinyASint.SInst_una;
import asint.TinyASint.Mul;
import asint.TinyASint.Negativo;
import asint.TinyASint.NotOperation;
import asint.TinyASint.Div;
import asint.TinyASint.Entero;
import asint.TinyASint.Igual_igual;
import asint.TinyASint.Inst;
import asint.TinyASint.Mayor_igual_que;
import asint.TinyASint.Mayor_que;
import asint.TinyASint.Menor_igual_que;
import asint.TinyASint.Menor_que;
import asint.TinyASint.OrOperation;
import asint.TinyASint.Prog;
import asint.TinyASint.AndOperation;
import asint.TinyASint.BooleanExp;
import asint.TinyASint.Dec;
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
   public void procesa(BooleanExp exp) {}
   public void procesa(Entero exp) {}
   public void procesa(Real exp) {}
   public void procesa(Dec dec) {}
   public void procesa(SDec_muchas decs) {}
   public void procesa(SDec_una decs) {}
   public void procesa(SInst_muchas sInst_muchas) {}
   public void procesa(SInst_una sInst_una) {}
   public void procesa(Inst inst) {}
   public void procesa(Prog prog) {}
   public void procesa(VaribleExp varibleExp) {}
}
