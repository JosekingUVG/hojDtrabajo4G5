package uvg;
import java.util.Vector; 

public class StackVector<E> implements Stack<E>{
    private Vector<E> stack;

    public StackVector() {
        stack = new Vector<>();
    }
    

    @Override
    public void push(E item) {
        //  Agregar un elemento al final de la lista
        stack.add(item);
    }


    @Override
    public E pop() {  
     // Eliminar el último elemento de la lista si no está vacia. 
     if (stack.isEmpty() == true) {
        throw new IllegalStateException("La pila está vacia.");
    }else{
        return stack.remove(stack.size() - 1); 
    }
      
    }

    @Override
    public E peek() {
        // Debe retornar el ultimo elemento de la lista si no está vacia. 
        if (stack.isEmpty() == true) {
            throw new IllegalStateException("La pila está vacia.");
            
        } else {
            return stack.get(stack.size() - 1);
        }
    }

    @Override
    public boolean empty() {
        // Retorna true si y solo si está vacia
        return stack.isEmpty();
        
    }

    @Override
    public int size() {
        // Retorna el tamaño de la lista
        return stack.size();

    }
    
}
