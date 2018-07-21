package structure;

public class StdListNode<E> {

    private E data = null;
    private StdListNode<E> next = null;

    public StdListNode() { }

    public StdListNode(E element) {
        data = element;
    }

    public StdListNode(StdListNode<E> node, E element) {
        next = node;
        data = element;
    }

    public E getData() { return data; }
    public void setData(E element) { data = element; }
    public StdListNode<E> getNext() { return next; }
    public void setNext(StdListNode<E> node) { next = node; }
    public void nullifyNext() { next = null; }
}