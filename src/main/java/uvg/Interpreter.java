package uvg;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Interpreter {

    // Método para convertir una expresión infix a postfix
    public static String infixToPostfix(String infix) {
        System.out.println("Convirtiendo infix: " + infix);
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            
            // Ignorar espacios en blanco
            if (Character.isWhitespace(ch)) {
                continue;
            }

            // Si es un operando (número o letra)
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch).append(" ");
            }

            // Si es un paréntesis de apertura
            else if (ch == '(') {
                stack.push(ch);
            } 
            // Si es un paréntesis de cierre
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop(); // Eliminar '('
            } 
            // Si es un operador
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(ch);
            }
        }

        // Vaciar la pila restante
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        String result = postfix.toString().trim();
        System.out.println("Resultado postfix: " + result);
        return result;

    }

    // Método para obtener la precedencia de los operadores
    private static int precedence(char op) {
        switch (op) {
            case '+': case '-':
                return 1;
            case '*': case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }

    // Método para leer expresiones desde un archivo con ruta absoluta dinámica
    public static List<String> readFile(String filePath) {
        List<String> expressions = new ArrayList<>();
        
        // Obtener la ruta absoluta
        File file = new File(filePath);
        String absolutePath = file.getAbsolutePath();
        System.out.println("Buscando archivo en: " + absolutePath);

        if (!file.exists()) {
            System.out.println("Error: No se encontró el archivo en " + absolutePath);
            return expressions; // Retorna lista vacía
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                expressions.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        }

        // Imprimir contenido del archivo para depuración
        System.out.println("Contenido del archivo:");
        for (String line : expressions) {
            System.out.println(line);
        }

        return expressions;
    }
}
