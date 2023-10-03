import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

     /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MinHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    private T[] getExtendedArray() {
        int currentCapacity = backingArray.length;
        int newCapacity = currentCapacity * 2;
        T[] newArray = (T[]) new Comparable[newCapacity];

        for (int i = 0; i < currentCapacity; i++) {
            newArray[i] = backingArray[i];
        }

        return newArray;
    }

    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException();
        }

        if (backingArray.length == size + 1) {
            backingArray = getExtendedArray();
        }

        size += 1;
        backingArray[size] = data;
        int currDataIdx = size;

        while (currDataIdx > 1) {
            int parentIdx = currDataIdx / 2;
            
            if (backingArray[parentIdx].compareTo(data) < 0) {
                break;
            }

            T temp = backingArray[parentIdx];
            backingArray[parentIdx] = data;
            backingArray[currDataIdx] = temp;

            currDataIdx = parentIdx;
        }
    }

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0) {
            throw new NoSuchElementException();
        }

        T data = backingArray[1];
        T replacement = backingArray[size];
        backingArray[1] = replacement;
        backingArray[size] = null;
        size -= 1;

        int currDataIdx = 1;
        while (currDataIdx * 2 <= size) {
            int child1Idx = currDataIdx * 2;
            int child2Idx = currDataIdx * 2 + 1;
            T child1 = backingArray[child1Idx];
            T child2 = backingArray[child2Idx];
            
            int smallerChildIdx;
            if (child2 == null || child1.compareTo(child2) < 0) {
                smallerChildIdx = child1Idx;
            } else {
                smallerChildIdx = child2Idx;
            } 
            
            if (replacement.compareTo(backingArray[smallerChildIdx]) < 0) {
                break;
            }

            T temp = backingArray[smallerChildIdx];
            backingArray[smallerChildIdx] = replacement;
            backingArray[currDataIdx] = temp;

            currDataIdx = smallerChildIdx;
        }

        return data;
    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}