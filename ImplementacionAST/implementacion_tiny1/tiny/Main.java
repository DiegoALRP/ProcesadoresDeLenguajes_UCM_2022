package tiny;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import asint.TinyASint.Prog;
import procesamientos.Impresion;

public class Main {
    
    public static void main(String[] args) throws Exception {

		System.out.println("Ejecutando tiny0");
		System.out.println("Se ha leido el fichero: " + args[0]);
		String ruta = "pruebas_tiny_0/";
		ruta += args[0];

		Prog prog = null;
		prog = ejecuta_descendente_manual(ruta);
		prog.procesa(new Impresion());
    }

	private static Prog ejecuta_descendente_manual(String in) throws Exception {
		
		Reader input = new InputStreamReader(new FileInputStream(in));
		c_ast_descendente.ConstructorAST constructorast = new c_ast_descendente.ConstructorAST(input);
		return constructorast.Ini();
	}
}


