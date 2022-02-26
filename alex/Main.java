package alex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
   public static void main(String[] args) throws FileNotFoundException, IOException {
     //Reader input = new InputStreamReader(new FileInputStream("input.txt"));
     System.out.println("Ejecutando tiny1");
     System.out.println("Se ha leido el fichero: " + args[0]);
     String ruta = "pruebas_tiny_1/";
     ruta += args[0];
     Reader input = new InputStreamReader(new FileInputStream(ruta));
     AnalizadorLexicoTiny al = new AnalizadorLexicoTiny(input);
     UnidadLexica unidad;
     do {
       unidad = al.yylex();
       System.out.println(unidad);
     }
     while (unidad.clase() != ClaseLexica.EOF);
    }        
} 
