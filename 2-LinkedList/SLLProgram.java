public class SLLProgram {
    public static void main(String[] args) { 
        SinglyLinkedList<String> myList = new SinglyLinkedList<>();

        System.out.println(myList.getHead());
        System.out.println(myList.getTail());
        System.out.println(myList.size());

        myList.addToFront("a");
        System.out.println(myList.getHead().getData());
        System.out.println(myList.getTail().getData());
        System.out.println(myList.size());

        myList.addToBack("b");
        System.out.println(myList.getHead().getData());
        System.out.println(myList.getTail().getData());
        System.out.println(myList.size());
    }
}
