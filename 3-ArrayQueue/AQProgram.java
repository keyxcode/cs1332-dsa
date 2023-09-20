public class AQProgram {
    public static void main(String[] args) { 
        ArrayQueue<String> myQueue = new ArrayQueue<>();

        myQueue.enqueue("a");
        myQueue.enqueue("b");
        myQueue.printArray();
        
        myQueue.enqueue("a");
        myQueue.enqueue("b");
        myQueue.enqueue("a");
        myQueue.enqueue("b");
        myQueue.enqueue("a");
        myQueue.enqueue("b");
        myQueue.enqueue("a");
        myQueue.printArray();

        myQueue.enqueue("a");
        myQueue.enqueue("b");
        myQueue.printArray();
    }    
}
