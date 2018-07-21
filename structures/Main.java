import structure.StdArrayList;
import structure.StdLinkedList;

public class Main {
    public static void main(String[] args) {
        StdLinkedList<String> linkedlist = new StdLinkedList<>();
        linkedlist.add("pez1");
        linkedlist.add("pez1ffff");

        System.out.println(linkedlist.toString());
        System.out.println(linkedlist.length());
        System.out.println("--------------------------------");


        System.out.println(linkedlist.getLast());
        System.out.println(linkedlist.length());
        System.out.println("--------------------------------");
    }
}