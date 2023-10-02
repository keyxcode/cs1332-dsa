import java.util.Arrays;

public class MinHeapProgram {
    public static void main(String[] args) { 
        MinHeap<Integer> myHeap = new MinHeap<>();
        
        myHeap.add(0);
        myHeap.add(0);
        myHeap.add(0);
        myHeap.add(0);
        myHeap.add(0);
        myHeap.add(0);
        myHeap.add(0);
        myHeap.add(0);
        myHeap.add(0);
        myHeap.add(0);
        System.out.println(Arrays.toString(myHeap.getBackingArray()));
        System.out.println(myHeap.size());

        myHeap.add(0);
        myHeap.add(0);
        System.out.println(Arrays.toString(myHeap.getBackingArray()));
        System.out.println(myHeap.size());

        myHeap.add(0);
        System.out.println(Arrays.toString(myHeap.getBackingArray()));
        System.out.println(myHeap.size());
    }    
}
