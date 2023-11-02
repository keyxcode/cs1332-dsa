package test;
import static org.junit.Assert.assertArrayEquals;

import java.util.Comparator;

import org.junit.Test;

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
        x_iterativesorts.Sorting.bubbleSort(intArray, new AscendingComparator());
        assertArrayEquals(intArray, new Integer[] {0,1,2,3,4,5});
    }

    @Test
    public void SelectionSortTest() {
        Integer[] intArray = {0,2,1,3,4,5}; 
        x_iterativesorts.Sorting.selectionSort(intArray, new AscendingComparator());
        assertArrayEquals(intArray, new Integer[] {0,1,2,3,4,5});
    }

    @Test
    public void InsertionSortTest() {
        Integer[] intArray = {0,4,1,3,2,5}; 
        x_iterativesorts.Sorting.insertionSort(intArray, new AscendingComparator());
        assertArrayEquals(intArray, new Integer[] {0,1,2,3,4,5});
    }

    @Test
    public void MergeSortTest() {
        Integer[] intArray = {0,4,1,3,2,5}; 
        xi_divideconquersorts.Sorting.mergeSort(intArray, new AscendingComparator());
        assertArrayEquals(intArray, new Integer[] {0,1,2,3,4,5});
    }    
}
