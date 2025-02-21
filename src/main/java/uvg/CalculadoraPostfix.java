package uvg;

public class CalculadoraPostfix {
    private static CalculadoraPostfix instancia; //esto hace una instancia única 
    private Stack<Integer> md; 

    private CalculadoraPostfix() { //constructor privado
        this.md = new StackVector<>();
    }
    // Método estático para obtener la única instancia o crearla si no existe
    // ahora ya se deberá de utilizar este método en lugar de crearlo de la forma tradicional
    //ejemplo: CalculadoraPostfix calculadora = CalculadoraPostfix.getInstance();
    //int resultado = calculadora.evaluarExpresion("3 4 + 2 *"); 
    public static CalculadoraPostfix getInstance() {
        if (instancia == null) {
            instancia = new CalculadoraPostfix();
        }
        return instancia;
    }

    public int evaluarExpresion(String expresion) throws IllegalArgumentException, ArithmeticException {
        String[] tokens = expresion.split(" ");
        for (String token : tokens) {
            if (esNumero(token)) {
                md.push(Integer.parseInt(token));
            } else if (esOperador(token)) {
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
        if (md.size() < 2) {
            throw new IllegalStateException("No hay suficientes operandos en la pila");
        }
        int b = md.pop();
        int a = md.pop();
        
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
                    throw new ArithmeticException("División por cero"); // Aseguramos que se lance la excepción
                }
                md.push(a / b);
                break;
            default:
                throw new IllegalArgumentException("Operador desconocido: " + operador);
        }
    }

}