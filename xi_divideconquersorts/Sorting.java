package xi_divideconquersorts;
import java.util.Comparator;
import java.util.LinkedList;

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
    private static <T> void merge(T[] arr, T[] left, T[] right, Comparator<T> comparator) {
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

    private static <T> T[] copyOfRange(T[] arr, int start, int end) {
        // end is non-inclusive
        // assume that start and end are valid numbers

        T[] newArr = (T[]) new Object[end - start];

        for (int i = start; i < end; i++) {
            newArr[i - start] = arr[i];
        }

        return newArr;
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
        T[] left = copyOfRange(arr, 0, midPoint);
        T[] right = copyOfRange(arr, midPoint, arrLength);

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
        // the reasoning behind minNegAbs is that Math.abs(Integer.MIN_VALUE) returns the MIN_VALUE itself
        int minNegAbs = -Math.abs(arr[0]);
        int arrLength = arr.length;

        for (int i = 0; i < arrLength; i++) {
            // cannot take absolute value of Integer.MIN_VALUE
            int currentNegAbs = -Math.abs(arr[i]);
            if (currentNegAbs < minNegAbs) {
                minNegAbs = currentNegAbs;
            }
        }

        // find out how many digits (k) that number has
        int k = 0;
        while (minNegAbs != 0) {
            minNegAbs /= 10;
            k += 1;
        }

        // initialize array of buckets
        int BUCKETS_LENGTH = 19;
        LinkedList<Integer>[] buckets = new LinkedList[BUCKETS_LENGTH];
        for (int i = 0; i < BUCKETS_LENGTH; i++) {
            buckets[i] = new LinkedList<>();
        }
         
        // sort each digit
        int divider = 1;
        for (int i = 0; i < k; i++) {
            // queue up number in their bucket
            for (int num : arr) {
                int digit = (num / divider) % 10;
                // +9 to compensate for negative digits 
                buckets[digit + 9].add(num);
            }

            // unload the buckets
            int idx = 0;
            for (LinkedList<Integer> bucket : buckets) {
                while (!bucket.isEmpty()) {      
                    arr[idx] = bucket.removeFirst();
                    idx += 1;   
                }
            }

            divider *= 10;
        }
    }
}