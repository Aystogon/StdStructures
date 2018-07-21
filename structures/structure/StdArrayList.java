package structure;

public class StdArrayList<E> {

    private int pointer = 0;
    private Object[] array = new Object[5];

    public void add(E element) {
        array[pointer] = element;
        pointer++;
        ensureCapacity();
    }

    /**
     * returns the element at the given index
     * @param index the index of the element to retrieve.
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index > pointer) { return null; }
        return (E)array[index];
    }

    /**
     * removes the element at the given index.
     * @param index the index of the element to delete.
     */
    public void delete(int index) {
        if (index < 0 || index > pointer) { return; }
        array[index] = null;
        for (int i = index; i < pointer - 1; i++) {
            array[index] = array[index + 1];
        }
        pointer--;
    }

    /**
     * Overwrites the given index with the given element.
     * @param element the item to use at the given index.
     * @param index the index of the element to retrieve.
     */
    public void set(E element, int index) {
        if (index < 0 || index > pointer) { return; }
        array[index] = element;
    }

    /**
     * Clears all elements in the array.
     */
    public void clear() {
        array = new Object[10];
        pointer = 0;
    }

    /**
     * Sets the capacity of the underlying array 
     * to the current amount of elements + 1.
     */
    public int trim() {
        Object[] newArr = new Object[pointer + 1];
        for (int i = 0; i < pointer; i++) {
            newArr[i] = array[i];
        }
        int trimmed = array.length - pointer;
        array = newArr;
        return trimmed;
    }

    /**
     * Checks for the given element inside the array
     * @param element element to check for.
     */
    public boolean contains(E element) {
        for (int i = 0; i < pointer; i++) {
            if (array[i] == element) { 
                return true;
            }
        }
        return false;
    }

    /**
     * Checks the array for the given element
     * and returns the index if found.
     * @param element the item to search for.
     */
    public int indexOf(E element) {
        for (int i = 0; i < pointer; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Returns the size of the array,
     */
    public int size() { return pointer; }
    
    /**
     * ensures that the array has room for more elements.
     */
    private void ensureCapacity() {
        if (pointer < array.length) { return; }
        Object[] newArr = new Object[array.length * 3 / 2 + 1];
        for (int i = 0; i < array.length; i++) {
            newArr[i] = array[i];
        }
        array = newArr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pointer; i++) {
            sb.append("[" + array[i].toString() + "]");
        }
        return sb.toString();
    }
}