package xi_divideconquersorts;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Your implementation of various divide & conquer sorting algorithms.
 */

public class Sorting {

    /**
     * Implement merge sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(n log n)
     * And a best case running time of: O(n log n)
     *
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     *
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     *
     * Hint: You may need to create a helper method that merges two arrays
     * back into the original T[] array. If two data are equal when merging,
     * think about which subarray you should pull from first.
     *
     * You may assume that the passed in array and comparator are both valid
     * and will not be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array to be sorted.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> T[] merge(T[] firstHalf, T[] secondHalf, Comparator<T> comparator) {
        int firstHalfLength = firstHalf.length;
        int secondHalfLength = secondHalf.length;
        int i = 0;
        int j = 0;

        T[] result = (T[])new Object[firstHalfLength + secondHalfLength];  

        while (i < firstHalfLength && j < secondHalfLength) {
            if (comparator.compare(firstHalf[i], secondHalf[j]) < 0) {
                result[i + j] = firstHalf[i];
                i += 1;
            } else {
                result[i + j] = secondHalf[j];
                j += 1;
            }
        }

        return result;
    }

    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // divide array in half
        int arrLength = arr.length;

        if (arrLength == 1) {
            return;
        }

        int midPoint = arrLength / 2;
        T[] firstHalf = Arrays.copyOfRange(arr, 0, midPoint - 1);
        T[] secondHalf = Arrays.copyOfRange(arr, midPoint, arrLength - 1);

        // meregeSort each half
        mergeSort(firstHalf, comparator);
        mergeSort(secondHalf, comparator);

        // merge two parts
        arr = merge(firstHalf, secondHalf, comparator);
    }

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(kn)
     * And a best case running time of: O(kn)
     *
     * Feel free to make an initial O(n) passthrough of the array to
     * determine k, the number of iterations you need.
     *
     * At no point should you find yourself needing a way to exponentiate a
     * number; any such method would be non-O(1). Think about how how you can
     * get each power of BASE naturally and efficiently as the algorithm
     * progresses through each digit.
     *
     * You may use an ArrayList or LinkedList if you wish, but it should only
     * be used inside radix sort and any radix sort helpers. Do NOT use these
     * classes with merge sort. However, be sure the List implementation you
     * choose allows for stability while being as efficient as possible.
     *
     * Do NOT use anything from the Math class except Math.abs().
     *
     * You may assume that the passed in array is valid and will not be null.
     *
     * @param arr The array to be sorted.
     */
    public static void lsdRadixSort(int[] arr) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    }
}
