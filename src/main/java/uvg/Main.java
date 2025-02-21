package uvg;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Preguntar el tipo de Stack
        String stackType;
        while (true) {
            System.out.println("Elija el tipo de Stack (arraylist, vector, list): ");
            stackType = scanner.nextLine().toLowerCase();
            
            if (stackType.equals("list")) {
                System.out.println("¿Desea una lista simple o doble? (simple/doble): ");
                String listType = scanner.nextLine().toLowerCase();
                
                if (listType.equals("simple") || listType.equals("doble")) {
                    // Keep stackType as "list" and pass listType separately
                    break;
                } else {
                    System.out.println("Opción inválida, intente de nuevo.");
                }
            } else if (stackType.equals("arraylist") || stackType.equals("vector")) {
                break;
            } else {
                System.out.println("Opción inválida, intente de nuevo.");
            }
        }

        // Crear instancia de la calculadora
        // Handle stack type and list type separately
        String listTypeParam = "";
        if (stackType.equals("list")) {
            System.out.println("¿Desea una lista simple o doble? (simple/doble): ");
            listTypeParam = scanner.nextLine().toLowerCase();
        }
        CalculadoraPostfix calculadora = CalculadoraPostfix.getInstance(stackType, listTypeParam);

        // Leer expresiones infix del archivo
        String filePath = "src/main/java/uvg/lista.txt";
        
        // Ruta absoluta dinámica
        File file = new File(filePath);
        System.out.println("Buscando archivo en: " + file.getAbsolutePath());

        if (!file.exists()) {
            System.out.println("Error: No se encontró el archivo en " + file.getAbsolutePath());
            return;
        }

        List<String> infixExpressions = Interpreter.readFile(filePath);

        // Convertir cada expresión a postfix y evaluar
        for (String infix : infixExpressions) {
            String postfix = "";
            try {
                postfix = Interpreter.infixToPostfix(infix);
                int resultado = calculadora.evaluarExpresion(postfix);
                System.out.println("Infix: " + infix);
                System.out.println("Postfix: " + postfix);
                System.out.println("Resultado: " + resultado);
                System.out.println("--------------------");
            } catch (Exception e) {
                System.out.println("Error al evaluar expresión:");
                System.out.println("  Infix: " + infix);
                System.out.println("  Postfix: " + postfix);
                System.out.println("  Error: " + e.getMessage());
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}
