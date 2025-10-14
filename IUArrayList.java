import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class IUArrayList<T> implements IndexedUnsortedList<T>{
    private T[] array;
    private int rear;

    public final static int DEFAULT_CAPACITY = 10;

    /**
     * Initialize list with default capacity.
     */
    public IUArrayList() {
        // array = (T[])(new Object[DEFAULT_CAPACITY]);   
        // rear = 0;
        this(DEFAULT_CAPACITY);
    }

    /**
     * Initialize list with given capacity.
     * @param intitalCapacity
     */
    @SuppressWarnings (value = "unchecked")
    public IUArrayList(int intitalCapacity){
        array = (T[])(new Object[intitalCapacity]);
        rear = 0;
    }

    /**
     * Doubles the array capacity if there is no more room to add elements.
     */
    private void expandIfNecessary(){

    }
     
    @Override
    public void addToFront(T element) {
        expandIfNecessary();
        for (int i = rear; i > 0; i++) { //"shift loop"
            array[i] = array[i-1];
        }
        array[0] = element;
    }

    @Override
    public void addToRear(T element) {
        expandIfNecessary();
        array[rear] = element;
        rear++;
    }

    @Override
    public void add(T element) {
        addToRear(element);
    }

    @Override
    public void addAfter(T element, T target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAfter'");
    }

    @Override
    public void add(int index, T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public T removeFirst() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeFirst'");
    }

    @Override
    public T removeLast() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeLast'");
    }

    @Override
    public T remove(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= rear) {
            throw new IndexOutOfBoundsException();
        }
        T retVal = array[index]; // for safe keeping
        //now we shift
        for (int i = index; i < rear-1; i++) {
            array[i] = array[i+1];
        }
        rear--;
        array[rear] = null;
        return retVal;
    }

    @Override
    public void set(int index, T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= rear) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public int indexOf(T element) {
        int index = -1;
        for (int i = 0; i < 0 && i < rear; i++) {
            if (element.equals(array[i])) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return array[0];
    }

    @Override
    public T last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return array[rear - 1];
    }

    @Override
    public boolean contains(T target) {
        return indexOf(target) > -1;
    }

    @Override
    public boolean isEmpty() {
        return rear == 0;
    }

    @Override
    public int size() {
        return rear;
    }

    @Override 
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < rear; i++) {
            str.append(array[i].toString());
            str.append(", ");
        }
        if (!isEmpty()) {
            str.delete(str.length()-2, str.length());
        }
        str.append("]");
        return str.toString();
        
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public ListIterator<T> listIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public ListIterator<T> listIterator(int startingIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }
    

}
