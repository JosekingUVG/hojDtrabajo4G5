package uvg;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Prueba de Listas Enlazadas ===");
        
        // Prueba con la lista simplemente enlazada
        System.out.println("\n📌 Probando SinglyLinkedList:");
        List<Integer> singlyList = new SinglyLinkedList<>();
        singlyList.addFirst(10);
        singlyList.addLast(20);
        singlyList.addLast(30);
        System.out.println("Primer elemento: " + singlyList.getFirst()); // 10
        System.out.println("Último elemento: " + singlyList.getLast());  // 30
        System.out.println("Eliminando primero: " + singlyList.removeFirst()); // 10
        System.out.println("Nuevo primer elemento: " + singlyList.getFirst());  // 20
        
        // Prueba con la lista doblemente enlazada
        System.out.println("\n📌 Probando DoublyLinkedList:");
        List<String> doublyList = new DoublyLinkedList<>();
        doublyList.addFirst("Hola");
        doublyList.addLast("Mundo");
        doublyList.addLast("!");
        System.out.println("Primer elemento: " + doublyList.getFirst()); // Hola
        System.out.println("Último elemento: " + doublyList.getLast());  // !
        System.out.println("Eliminando último: " + doublyList.removeLast()); // !
        System.out.println("Nuevo último elemento: " + doublyList.getLast());  // Mundo
    }
}
