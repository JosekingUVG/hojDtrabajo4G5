package uvg;

public class Main {
    public static void main(String[] args) {
        // Probar con una lista simplemente enlazada (SinglyLinkedList)
        System.out.println("Probando StackList con SinglyLinkedList:");
        StackList<Integer> stackSingly = new StackList<>("Singly");

        stackSingly.push(10);
        stackSingly.push(20);
        stackSingly.push(30);
        System.out.println("Peek: " + stackSingly.peek()); // Esperado: 30
        System.out.println("Tamaño: " + stackSingly.size()); // Esperado: 3
        System.out.println("Pop: " + stackSingly.pop()); // Esperado: 30
        System.out.println("Tamaño después de pop: " + stackSingly.size()); // Esperado: 2
        System.out.println("Vacío: " + stackSingly.empty()); // Esperado: false

        // Probar con una lista doblemente enlazada (DoublyLinkedList)
        System.out.println("\nProbando StackList con DoublyLinkedList:");
        StackList<Integer> stackDoubly = new StackList<>("Doubly");

        stackDoubly.push(100);
        stackDoubly.push(200);
        stackDoubly.push(300);
        System.out.println("Peek: " + stackDoubly.peek()); // Esperado: 300
        System.out.println("Tamaño: " + stackDoubly.size()); // Esperado: 3
        System.out.println("Pop: " + stackDoubly.pop()); // Esperado: 300
        System.out.println("Tamaño después de pop: " + stackDoubly.size()); // Esperado: 2
        System.out.println("Vacío: " + stackDoubly.empty()); // Esperado: false
    }
}
