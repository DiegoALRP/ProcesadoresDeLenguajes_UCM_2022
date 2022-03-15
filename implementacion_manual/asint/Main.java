package asint;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
   public static void main(String[] args) throws FileNotFoundException, IOException {
    String ruta = "pruebas_tiny_0/";
    ruta += args[0]; 
    Reader input = new InputStreamReader(new FileInputStream(ruta));
    AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(input);
    asint.Sp();
 }
}   
   
