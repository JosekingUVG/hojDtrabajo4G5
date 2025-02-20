package uvg;

public class ListFactory {
    public static List getList(String type) {
        if (type.equalsIgnoreCase("SinglyLinkedList")) {
            return new SinglyLinkedList();
        } else if (type.equalsIgnoreCase("DoublyLinkedList")) {
            return new DoublyLinkedList();
        }
                return null; 
    }
}

