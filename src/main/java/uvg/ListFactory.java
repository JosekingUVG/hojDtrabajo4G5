package uvg;

public class ListFactory {
    public static List<Integer> getList(String type) {
        if (type.equalsIgnoreCase("simple")) {
            return new SinglyLinkedList<>();
        } else if (type.equalsIgnoreCase("doble")) {
            return new DoublyLinkedList<>();
        } else {
            throw new IllegalArgumentException("Tipo de lista no válido: " + type);
        }
    }
}
