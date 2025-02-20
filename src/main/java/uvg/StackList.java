package uvg;

public class StackList<E> implements Stack<E> {
    private List<E> list;

    public StackList(String type) {
        ListFactory factory = new ListFactory();
        this.list = factory.getList(type); // El tipo genérico se maneja dentro de la fábrica
    }

    @Override
    public void push(E item) {
        list.addLast(item);
    }

    @Override
    public E pop() {
        if (list.isEmpty()) {
            throw new IllegalStateException("La pila está vacía.");
        }
        return list.removeLast();
    }

    @Override
    public E peek() {
        if (list.isEmpty()) {
            throw new IllegalStateException("La pila está vacía.");
        }
        return list.getLast();
    }

    @Override
    public boolean empty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}
