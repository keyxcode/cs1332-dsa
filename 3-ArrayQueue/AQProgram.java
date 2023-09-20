public class AQProgram {
    public static void main(String[] args) { 
        ArrayQueue<String> myQueue = new ArrayQueue<>();

        myQueue.enqueue("a");
        myQueue.enqueue("b");

        System.out.println(myQueue.size());
        System.out.println(myQueue.getBackingArray());
    }    
}
