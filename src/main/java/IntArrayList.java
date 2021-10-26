import java.util.Arrays;

public class IntArrayList<T> implements IntList<T> {


    private Object[] array = new Object[10];
    private int size = 0;


    @Override
    public void add(T element) {
        increaseArray();
        array[size] = element;
        size++;

    }

    @Override
    public boolean add(int index, T element) {
        increaseArray();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
        return true;

    }

    @Override
    public void clear() {
        array = new Object[10];
        size = 0;

    }

    @Override
    public T get(int index) {
        chekIndex(index);
        return (T) array[index];
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(int index) {
        chekIndex(index);
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
        size--;
        return true;

    }

    @Override
    public boolean removeByElement(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return remove(i);
            }

        }
        return false;
    }

    @Override
    public boolean set(int index, T element) {
        remove(index);
        add(index, element);
        return true;
    }


    @Override
    public int size() {
        return size;
    }


    @Override
    public Object[] toArray() {
        for (Object toArray : array) {

        }
        return array;
    }

    private void chekIndex(int index) {
        if (index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException();
        }
    }
    private void increaseArray(){
        if (size >= array.length) {
            array = Arrays.copyOf(array,array.length * 2);
        }
    }
}
