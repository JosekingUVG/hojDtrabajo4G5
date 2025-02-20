package uvg;

public class SinglyLinkedList<E> extends AbstractList<E> {
    protected Node<E> head;
    
    public SinglyLinkedList() {
        head = null;
    }
    
    @Override
    public void addFirst(E value) {
        head = new Node<>(value, head);
        count++;
    }
    
    @Override
    public void addLast(E value) {
        if (head == null) {
            addFirst(value);
            return;
        }
        Node<E> temp = head;
        while (temp.next() != null) {
            temp = temp.next();
        }
        temp.setNext(new Node<>(value));
        count++;
    }
    
    @Override
    public E getFirst() {
        if (head == null) throw new IllegalStateException("List is empty");
        return head.value();
    }
    
    @Override
    public E getLast() {
        if (head == null) throw new IllegalStateException("List is empty");
        Node<E> temp = head;
        while (temp.next() != null) {
            temp = temp.next();
        }
        return temp.value();
    }
    
    @Override
    public E removeFirst() {
        if (head == null) throw new IllegalStateException("List is empty");
        E value = head.value();
        head = head.next();
        count--;
        return value;
    }
    
    @Override
    public E removeLast() {
        if (head == null) throw new IllegalStateException("List is empty");
        if (head.next() == null) {
            return removeFirst();
        }
        Node<E> temp = head;
        while (temp.next().next() != null) {
            temp = temp.next();
        }
        E value = temp.next().value();
        temp.setNext(null);
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
        Node<E> temp = head;
        while (temp != null) {
            if (temp.value().equals(value)) {
                return true;
            }
            temp = temp.next();
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
