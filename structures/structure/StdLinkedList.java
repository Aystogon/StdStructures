package structure;

public class StdLinkedList<E> {

    private int size = 0;
    private StdListNode<E> head = null;
    private StdListNode<E> tail = null;


    public void add(E element) {

        StdListNode<E> newNode = new StdListNode<>(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public void setFirst(E element) {

        if (head == null) { return; }
        StdListNode<E> newNode = new StdListNode<>(head, element);
        head = newNode;
        size++;
    }

    public void deleteLast() {

        if (head == null) { return; }
        if (head == tail) { 
            head = null; 
            tail = null; 
            return; 
        }
        StdListNode<E> iterator = head;
        while (iterator.getNext() != tail) {
            iterator = iterator.getNext();
        }
        iterator.nullifyNext();;
        tail = iterator;
        size--;
    }

    public void deleteFirst() {

        if (head == null) { return; }
        if (head == tail) { 
            head = null; 
            tail = null; 
            return; 
        }
        head = head.getNext();
        size--;
    }

    public void delete(int index) {
        if (index < 0 || index > size) { return; }
        StdListNode<E> iterator = head;
        while (index > 1) {
            iterator = iterator.getNext();
            index--;
        }
        iterator.setNext(iterator.getNext().getNext());
        tail = iterator.getNext();
        size--;
    }

    public E get(int index) {

        if (index < 0 || index > size) { return null; }
        StdListNode<E> iterator = head;
        while (index > 0) {
            iterator = iterator.getNext();
            index--;
        }
        return iterator.getData();
    }

    public int length() { return size; }
    
    public E getFirst() { return head.getData(); }

    public E getLast() { return tail.getData(); }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder(); 
        StdListNode<E> iterator = head;
        if (iterator == null) { return ""; }
        while (iterator != null) {
            sb.append("[" + iterator.getData().toString() + "]->");
            iterator = iterator.getNext();
        }
        sb.append("null");
        return sb.toString();
    }
}