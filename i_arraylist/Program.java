public class Program {
 
    public static void main(String[] args) { 
        ArrayList<String> myList = new ArrayList<>();
        
        myList.addToFront("a");
        myList.addToBack("b");
        myList.addToBack("c"); 
        for(int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        myList.removeFromBack();
        myList.removeFromFront();
        for(int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
    }
 
}