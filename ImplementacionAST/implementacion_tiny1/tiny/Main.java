package tiny;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import asint.TinyASint.Prog;
import c_ast_ascendente.AnalizadorLexico;
import procesamientos.Impresion;

public class Main {
    
    public static void main(String[] args) throws Exception {

		if (args.length != 2) {
			System.out.println("No se ha introducido correctamente los argumentos");
			System.out.println("Uso: <op> <filepath>");
			System.out.println("OP: asc y desc");
		}

		System.out.println("Ejecutando tiny0");
		System.out.println("Se ha leido el fichero: " + args[1]);
		System.out.println("Se ha seleccionado la opcion: " + args[0]);

		//String ruta = "pruebas_tiny_1/";
		//ruta += args[0];
		String op  = args[0];
		String ruta = args[1];

		Prog prog = null;
		if (op.equals("desc")) {
			prog = ejecuta_descendente(ruta);
			prog.procesa(new Impresion());
		}
		else if (op.equals("asc")) {
			prog = ejecuta_ascendente(ruta);
			prog.procesa(new Impresion());
		}
		else {
			System.out.println("No existe la opcion " + op);
			System.out.println("Las opciones son: asc y desc");
		}
    }

	private static Prog ejecuta_descendente(String in) throws Exception {
		
		Reader input = new InputStreamReader(new FileInputStream(in));
		c_ast_descendente.ConstructorAST constructorast = new c_ast_descendente.ConstructorAST(input);
		return constructorast.Ini();
	}

	private static Prog ejecuta_ascendente(String in) throws Exception {
		Reader input = new InputStreamReader(new FileInputStream(in));
		AnalizadorLexico alex = new AnalizadorLexico(input);
		c_ast_ascendente.ConstructorAST constructorast = new c_ast_ascendente.ConstructorAST(alex);
		return (Prog)constructorast.parse().value;
	}
}


