public interface IntList<T> {
    void add(T element);
    boolean add(int index, T element);
    void clear();
    T get(int index);
    boolean isEmpty();
    boolean remove(int index);
    boolean removeByElement(T element);
    boolean set(int index, T element);
    int size();
    Object[] toArray();
}
