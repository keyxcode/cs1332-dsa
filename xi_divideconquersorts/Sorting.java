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
    public static <T> void merge(T[] arr, T[] left, T[] right, Comparator<T> comparator) {
        int leftLength = left.length;
        int rightLength = right.length;
        int i = 0;
        int j = 0;

        while (i < leftLength && j < rightLength) {
            if (comparator.compare(left[i], right[j]) <= 0) {
                arr[i + j] = left[i];
                i += 1;
            } else {
                arr[i + j] = right[j];
                j += 1;
            }
        }

        while (i < leftLength) {
            arr[i + j] = left[i];
            i += 1;
        }

        while (j < rightLength) {
            arr[i + j] = right[j];
            j += 1;
        }
    }

    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // divide array in half
        int arrLength = arr.length;

        if (arrLength < 2) {
            return;
        }

        int midPoint = arrLength / 2;
        // copyOfRange to is non-inclusive
        T[] left = Arrays.copyOfRange(arr, 0, midPoint);
        T[] right = Arrays.copyOfRange(arr, midPoint, arrLength);

        // meregeSort each half
        mergeSort(left, comparator);
        mergeSort(right, comparator);

        // merge two parts
        merge(arr, left, right, comparator);
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
        // find the number with the max number of digits
        int maxAbs = Math.abs(arr[0]);
        int arrLength = arr.length;

        for (int i = 1; i < arrLength; i++) {
            if (Math.abs(arr[i]) > maxAbs) {
                maxAbs = Math.abs(arr[i]);
            }
        }
        System.out.println(maxAbs);

        // find out how many digits (k) that number has
        int k = 0;
        while (maxAbs > 0) {
            maxAbs /= 10;
            k += 1;
        }
        System.out.println(k);

        // initiate buckets
        int BUCKETS_LENGTH = 19;
        LinkedList<Integer>[] buckets = new LinkedList[BUCKETS_LENGTH];
        for (int i = 0; i < BUCKETS_LENGTH; i++) {
            buckets[i] = new LinkedList<>();
        }
        
        // queue up each digit
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < arrLength; j++) {
                int digit = arr[j] % 10;
                buckets[digit + 9].add(arr[j]);
            }
        }

        System.out.println(Arrays.toString(buckets));
    }
}
