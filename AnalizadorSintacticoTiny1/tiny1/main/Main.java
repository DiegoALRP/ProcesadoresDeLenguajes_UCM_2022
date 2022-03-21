package main;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

import alex.AnalizadorLexicoTiny;
import asintCC.AnalizadorSintacticoTiny;
import asintCup.AnalizadorSintacticoTinyCup;

public class Main{
   public static void main(String[] args) throws Exception {
       if(args.length!=2){ System.out.println("Número de argumentos incorrectos");}
       else{
            if(args[1].equals("desc")){
                AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(new FileReader(args[0]));
                asint.Ini();
                System.out.println("OK desc");
            }
            else if(args[1].equals("asc")){
                Reader input = new InputStreamReader(new FileInputStream(args[0]));
                AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
                AnalizadorSintacticoTinyCup asint = new AnalizadorSintacticoTinyCup(alex);
                asint.parse();
                System.out.println("OK asc");
            }
        }
   }
}
