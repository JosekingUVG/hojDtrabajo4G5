package uvg;

public class DoublyLinkedList<E> extends AbstractList<E> {
    protected DoublyLinkedNode<E> head;
    protected DoublyLinkedNode<E> tail;
    
    public DoublyLinkedList() {
        head = null;
        tail = null;
    }
    
    @Override
    public void addFirst(E value) {
        head = new DoublyLinkedNode<>(value, head, null);
        if (tail == null) { // Si la lista estaba vacía
            tail = head;
        }
        count++;
    }
    
    @Override
    public void addLast(E value) {
        if (tail == null) { // Si la lista estaba vacía
            addFirst(value);
            return;
        }
        tail = new DoublyLinkedNode<>(value, null, tail);
        count++;
    }
    
    @Override
    public E getFirst() {
        if (head == null) throw new IllegalStateException("List is empty");
        return head.data;
    }
    
    @Override
    public E getLast() {
        if (tail == null) throw new IllegalStateException("List is empty");
        return tail.data;
    }
    
    @Override
    public E removeFirst() {
        if (head == null) throw new IllegalStateException("List is empty");
        E value = head.data;
        head = head.nextElement;
        if (head != null) {
            head.previousElement = null;
        } else { // Si la lista queda vacía
            tail = null;
        }
        count--;
        return value;
    }
    
    @Override
    public E removeLast() {
        if (tail == null) throw new IllegalStateException("List is empty");
        E value = tail.data;
        tail = tail.previousElement;
        if (tail != null) {
            tail.nextElement = null;
        } else { // Si la lista queda vacía
            head = null;
        }
        count--;
        return value;
    }
    
    @Override
    public void add(E value) {
        addLast(value);
    }
    
    @Override
    public E remove() {
        return removeLast();
    }
    
    @Override
    public E get() {
        return getLast();
    }
    
    @Override
    public boolean contains(E value) {
        DoublyLinkedNode<E> temp = head;
        while (temp != null) {
            if (temp.data.equals(value)) {
                return true;
            }
            temp = temp.nextElement;
        }
        return false;
    }

    @Override
    public E remove(E value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public int indexOf(E value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    @Override
    public int lastIndexOf(E value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lastIndexOf'");
    }

    @Override
    public E get(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public E set(int i, E o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public void add(int i, E o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public E remove(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
}
