
package uvg;
import java.util.ArrayList;


public class StackArrayList<E> implements Stack<E> {
    private ArrayList<E> arrayList;
    
    public StackArrayList() {
        arrayList = new ArrayList<>();
    }

    @Override
    public void push(E item) {
        arrayList.add(item);
    }
    @Override
    // Método para eliminar y devolver el elemento en la cima de la pila
    public E pop() {
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return arrayList.remove(arrayList.size() - 1);
    }
    @Override
    // Método para ver el elemento en la cima sin eliminarlo
    public E peek() {
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return arrayList.get(arrayList.size() - 1);
    }
    @Override
    // Método para obtener el tamaño de la pila
    public int size() {
        return arrayList.size();
    }
    @Override
    public boolean empty() {
        return arrayList.isEmpty();
    }
}
