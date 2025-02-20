package uvg;

public class StackList<E> implements Stack<E> {
    private List<E> list;

    // Constructor que recibe una lista generada por ListFactory
    public StackList(List<E> list) {
        this.list = list;
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
