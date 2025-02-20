package uvg;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Seleccione el tipo de Stack (Vector, ArrayList, List): ");
        String stackType = scanner.nextLine();
        
        String listType = "";
        if (stackType.equalsIgnoreCase("List")) {
            System.out.println("Seleccione el tipo de List (SinglyLinkedList, DoublyLinkedList, ArrayList): ");
            listType = scanner.nextLine();
        }

        Stack stack = StackFactory.getStack(stackType, listType);
        
        // Ahora puedes usar `stack` con push, pop, etc.
        stack.push(10);
        System.out.println("Elemento en la cima: " + stack.peek());
    }
}
