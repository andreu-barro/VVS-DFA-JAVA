package es.udc.vvs.dfa.util;

/**
 * This class represents a particular generic list.
 *
 * @author {andreu.barro, manoel.folgueira, uxia.ponte.villaverde}@udc.es
 * @param <T>
 */
public class GenList<T> {

    private int size = 0;
    private int buffer = 1;
    private int pointer = -1;
    private Object[] list = null;

    public GenList() {}

    public GenList(int buffer) {
        if (buffer>=0)
            this.buffer = buffer;
    }

    /**
     * Getter for the buffer attribute.
     *
     * @return the buffer
     */
    public int getBuffer() {
        return buffer;
    }

    /**
     * Getter for the size attribute.
     *
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Adds some T object to the tail.
     *
     * @param obj
     */
    public void add(T obj) {
        pointer++;
        if (pointer == size) {
            size += buffer;
            if (list == null) {
                list = new Object[size];
            } else {
                Object[] newBufferedList = new Object[size];
                System.arraycopy(list, 0, newBufferedList, 0, size-buffer);
                list = newBufferedList;
            }
        }
        list[pointer] = (Object) obj;
    }

    /**
     * Removes the nth element.
     *
     * @param n the nth position (0-based)
     */
    public void remove(int n) {
        if (n > pointer) { return; }

        for (int i = n + 1; i <= pointer; i++) {
            list[i - 1] = list[i];
        }

        pointer--;
        if ((size - buffer - 1) == pointer) {
            size -= buffer;
            if (size == 0) {
                list = null;
            } else {
                Object[] newBufferedList = new Object[size];
                System.arraycopy(list, 0, newBufferedList, 0, size);
                list = newBufferedList;
            }
        }
    }

    /**
     * Gets the nth T object.
     *
     * @param n the nth position (0-based)
     * @return T object
     */
    public T get(int n) {
        return (T) list[n];
    }

    /**
     * Getter for the list attribute.
     *
     * @return the list
     */
    public Object[] getArray() {
        // we should not reference private mutable objects to the outside.
        return list;
    }

    /**
     * Searchs for a T object and returns the one inside this list.
     *
     * @param obj a T object to compare
     * @return the T object inside the list which fullfils the equals comparison
     * with the given object obj.
     *
     * This is done this way because we (may) want "partial" comparison defined
     * in equals not including all the attributes of the T object.
     *
     * For example, a Transition comparison where we do not care about the end
     * state, just the beginning state and the symbol.
     *
     * Do not forget to override equals/hashCode methods of the T class.
     */
    public T getExistingObject(T obj) {
        for (int i = 0; i <= pointer; i++) {
            if (((T) list[i]).equals(obj)) {
                return ((T) list[i]);
            }
        }
        return null;
    }

    /**
     * You can use this feature (if visible) when using buffer > 1 and want to
     * get rid of leftover positions.
     */
    private void clearNulls() {
        int i;
        for (i = size - 1; i > pointer; i--) {
        }
        Object[] aux = new Object[i + 1];
        System.arraycopy(list, 0, aux, 0, i + 1);
        list = aux;
    }

    @Override
    public String toString() {
        if (list == null) { return ""; }
        if (buffer > 1) { clearNulls(); }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= pointer; i++) {
            stringBuilder.append((T) list[i]).append(", ");
        }

        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }

}
