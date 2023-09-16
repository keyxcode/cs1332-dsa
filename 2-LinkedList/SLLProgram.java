public class SLLProgram {
    public static void main(String[] args) { 
        SinglyLinkedList<String> myList = new SinglyLinkedList<>();

        System.out.println(myList);

        myList.addToFront("a");
        System.out.println(myList);

        myList.addToBack("b");
        System.out.println(myList);

        myList.addToBack("c");
        System.out.println(myList);

        myList.removeFromBack();
        System.out.println(myList);
    }
}
