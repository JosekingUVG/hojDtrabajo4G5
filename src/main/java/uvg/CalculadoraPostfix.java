package uvg;

public class CalculadoraPostfix {
    private static CalculadoraPostfix instancia; // Instancia única
    private Stack<Integer> md; 

    private CalculadoraPostfix(String stackType, String listType) { 
        this.md = StackFactory.getStack(stackType, listType); 
    }

    // Método para obtener la instancia con el tipo de stack deseado
    public static CalculadoraPostfix getInstance(String stackType, String listType) {
        if (instancia == null) {
            instancia = new CalculadoraPostfix(stackType, listType);
        }
        return instancia;
    }

    public int evaluarExpresion(String expresion) throws IllegalArgumentException, ArithmeticException {
        System.out.println("Evaluando expresión postfix: " + expresion);
        String[] tokens = expresion.split(" ");
        for (String token : tokens) {
            System.out.println("Procesando token: " + token);
            if (esNumero(token)) {
                int num = Integer.parseInt(token);
                System.out.println("  Es número: " + num);
                md.push(num);
            } else if (esOperador(token)) {
                System.out.println("  Es operador: " + token);
                procesarOperador(token);
            } else {
                throw new IllegalArgumentException("Token inválido: " + token);
            }
        }

        if (md.size() != 1) {
            throw new IllegalStateException("Expresión inválida, elementos sobrantes");
        }
        return md.pop();
    }

    private boolean esNumero(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean esOperador(String token) {
        return "+-*/".contains(token);
    }

    private void procesarOperador(String operador) {
        System.out.println("Procesando operador: " + operador);
        if (md.size() < 2) {
            throw new IllegalStateException("No hay suficientes operandos en la pila");
        }
        int b = md.pop();
        int a = md.pop();
        System.out.println("  Operandos: " + a + " " + operador + " " + b);

        
        switch (operador) {
            case "+":
                md.push(a + b);
                break;
            case "-":
                md.push(a - b);
                break;
            case "*":
                md.push(a * b);
                break;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("División por cero");
                }
                md.push(a / b);
                break;
            default:
                throw new IllegalArgumentException("Operador desconocido: " + operador);
        }
    }
}
