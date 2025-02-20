package uvg;

public abstract class AbstractList<E> implements List<E> {
    protected int count;
    
    public AbstractList() {
        count = 0;
    }
    
    @Override
    public boolean isEmpty() {
        return count == 0;
    }
    
    @Override
    public int size() {
        return count;
    }
    
    @Override
    public void clear() {
        count = 0;
    }
}
