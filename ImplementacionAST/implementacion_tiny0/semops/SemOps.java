package semops;

import asint.TinyASint;

public class SemOps extends TinyASint {
   public Exp exp(String op, Exp arg0, Exp arg1) {
       switch(op) {
           case "and": return andOperation(arg0,arg1);
           case "or": return orOperation(arg0,arg1);
           case "<": return menor_que(arg0, arg1);
           case "<=": return menor_igual_que(arg0, arg1);
           case ">=": return mayor_igual_que(arg0, arg1);
           case ">": return mayor_que(arg0, arg1);
           case "==":  return igual_igual(arg0, arg1);
           case "!=": return distinto_distinto(arg0, arg1);
           case "*": return mul(arg0,arg1);
           case "/": return div(arg0,arg1);
       }
       throw new UnsupportedOperationException("exp "+op);
   }  
     
}
