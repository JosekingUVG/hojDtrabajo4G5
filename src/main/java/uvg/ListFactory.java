package uvg;

public class ListFactory {
    public <E> List<E> getList(String type) {
        if (type.equalsIgnoreCase("Singly")) {
            return new SinglyLinkedList<>(); // Usamos SinglyLinkedList genérica
        } else if (type.equalsIgnoreCase("Doubly")) {
            return new DoublyLinkedList<>(); // Usamos DoublyLinkedList genérica
        } else {
            throw new IllegalArgumentException("Tipo de lista no válido");
        }
    }
}
