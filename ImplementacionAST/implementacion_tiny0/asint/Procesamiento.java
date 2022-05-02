package asint;

import asint.TinyASint.Suma;
import asint.TinyASint.VaribleExp;
import asint.TinyASint.Resta;
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
import asint.TinyASint.AndOperation;
import asint.TinyASint.BooleanExp;
import asint.TinyASint.Dec;
import asint.TinyASint.Distinto_distinto;
import asint.TinyASint.SDec_muchas ;
import asint.TinyASint.SDec_una;
import asint.TinyASint.SInst_muchas;
import asint.TinyASint.SInst_una;
import asint.TinyASint.Real;
import asint.TinyASint.Prog;

//Donde puedo procesar los diferentes tipos de nodos
public interface Procesamiento {
    void procesa(Suma exp);
    void procesa(Resta exp);
    void procesa(AndOperation exp);
    void procesa(OrOperation exp);
    void procesa(Mayor_que exp);
    void procesa(Menor_que exp);
    void procesa(Mayor_igual_que exp);
    void procesa(Menor_igual_que exp);
    void procesa(Igual_igual exp);
    void procesa(Distinto_distinto exp);
    void procesa(Mul exp);
    void procesa(Div exp);
    void procesa(Negativo exp);
    void procesa(NotOperation exp);
    void procesa(BooleanExp exp);
    void procesa(Entero exp);
    void procesa(Real exp);
    void procesa(Dec dec);
    void procesa(SDec_muchas decs);
    void procesa(SDec_una decs);
    void procesa(SInst_muchas sInst_muchas);
    void procesa(SInst_una sInst_una);
    void procesa(Inst inst);
    void procesa(Prog prog);
    void procesa(VaribleExp varibleExp);
}