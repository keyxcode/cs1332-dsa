package xi_divideconquersorts;

import java.util.Arrays;
import java.util.Comparator;

public class SortingProgram {
    public static void main(String[] args) {
        class AscendingComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer a, Integer b)
            {
                return a.compareTo(b);
            }
        }
        
        // Integer[] intArray = {4,0,1}; 
        // Sorting.mergeSort(intArray, new AscendingComparator());
        // System.out.print(Arrays.toString(intArray));

        int[] intArray2 = {4,0,1,52,111,-3,-9876}; 
        int[] intArray3 = {}; 
        Sorting.lsdRadixSort(intArray3);
        System.out.println(Arrays.toString(intArray2));
    }
}
