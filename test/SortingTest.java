package test;
import static org.junit.Assert.assertArrayEquals;

import java.util.Comparator;

import org.junit.Test;

import x_iterativesorts.Sorting;

public class SortingTest {
    class AscendingComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b)
        {
            return a.compareTo(b);
        }
    }

    @Test
    public void BubbleSortTest() {
        Integer[] intArray = {0,2,1,3,4,5}; 
        Sorting.bubbleSort(intArray, new AscendingComparator());
        assertArrayEquals(intArray, new Integer[] {0,1,2,3,4,5});
    }
}
