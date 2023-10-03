import java.util.Arrays;

public class MinHeapProgram {
    public static void main(String[] args) { 
        MinHeap<Integer> myHeap = new MinHeap<>();
        
        myHeap.add(0);
        myHeap.add(1);
        myHeap.add(2);
        myHeap.add(4);
        myHeap.add(3);
        myHeap.add(5);
        myHeap.add(7);
        myHeap.add(6);
        myHeap.add(8);
        myHeap.add(9);
        myHeap.add(10);

        myHeap.remove();
        
        System.out.println(Arrays.toString(myHeap.getBackingArray()));
        System.out.println(myHeap.size());
    }    
}
