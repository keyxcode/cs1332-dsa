import java.util.NoSuchElementException;

/**
 * Your implementation of a ExternalChainingHashMap.
 */
public class ExternalChainingHashMap<K, V> {

    /*
     * The initial capacity of the ExternalChainingHashMap when created with the
     * default constructor.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

    /*
     * The max load factor of the ExternalChainingHashMap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final double MAX_LOAD_FACTOR = 0.67;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private ExternalChainingMapEntry<K, V>[] table;
    private int size;

    /**
     * Constructs a new ExternalChainingHashMap with an initial capacity of INITIAL_CAPACITY.
     */
    public ExternalChainingHashMap() {
        //DO NOT MODIFY THIS METHOD!
        table = (ExternalChainingMapEntry<K, V>[]) new ExternalChainingMapEntry[INITIAL_CAPACITY];
    }

    /**
     * Adds the given key-value pair to the map. If an entry in the map
     * already has this key, replace the entry's value with the new one
     * passed in.
     *
     * In the case of a collision, use external chaining as your resolution
     * strategy. Add new entries to the front of an existing chain, but don't
     * forget to check the entire chain for duplicate keys first.
     *
     * If you find a duplicate key, then replace the entry's value with the new
     * one passed in. When replacing the old value, replace it at that position
     * in the chain, not by creating a new entry and adding it to the front.
     *
     * Before actually adding any data to the HashMap, you should check to
     * see if the table would violate the max load factor if the data was
     * added. Resize if the load factor (LF) is greater than max LF (it is
     * okay if the load factor is equal to max LF). For example, let's say
     * the table is of length 5 and the current size is 3 (LF = 0.6). For
     * this example, assume that no elements are removed in between steps.
     * If another entry is attempted to be added, before doing anything else,
     * you should check whether (3 + 1) / 5 = 0.8 is larger than the max LF.
     * It is, so you would trigger a resize before you even attempt to add
     * the data or figure out if it's a duplicate. Be careful to consider the
     * differences between integer and double division when calculating load
     * factor.
     *
     * When regrowing, resize the length of the backing table to
     * (2 * old length) + 1. You should use the resizeBackingTable method to do so.
     *
     * @param key   The key to add.
     * @param value The value to add.
     * @return null if the key was not already in the map. If it was in the
     *         map, return the old value associated with it.
     * @throws java.lang.IllegalArgumentException If key or value is null.
     */
    private int currentLoadFactor() {
        return size / table.length;
    }

    private int getCompressedHash(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        return key.hashCode() % table.length;
    }

    private ExternalChainingMapEntry<K, V> get(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
                
        int compressedHash = getCompressedHash(key);

        ExternalChainingMapEntry<K, V> curr = table[compressedHash];
        while (curr != null) {
            if (curr.getKey() == key) {
                return curr;
            }
        }
 
        return null;
    }

    public V put(K key, V value) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (key == null || value == null) {
            throw new IllegalArgumentException();
        }

        int compressedHash = key.hashCode() % table.length;
        ExternalChainingMapEntry<K, V> entry = new ExternalChainingMapEntry<>(key, value);

        // hashed index is null
        if (table[compressedHash] == null) {
            size += 1;
            if (currentLoadFactor() > MAX_LOAD_FACTOR) {
                resizeBackingTable(2 * table.length + 1);
                compressedHash = key.hashCode() % table.length;
            }
            
            table[compressedHash] = entry;
            return null;
        }

        // hashed index is not null
        ExternalChainingMapEntry<K, V> curr = table[compressedHash];

        while (curr != null) {
            // key already exists in the table
            if (curr.getValue().equals(value)) {
                V oldValue = curr.getValue();
                curr.setValue(value);
                return oldValue;
            }

            curr = curr.getNext();
        }
        
        // key doesn't exist in the table
        size += 1;
        if (currentLoadFactor() > MAX_LOAD_FACTOR) {
            resizeBackingTable(2 * table.length + 1);
            compressedHash = key.hashCode() % table.length;
        }
        table[compressedHash] = entry;
        return null;
    }

    /**
     * Removes the entry with a matching key from the map.
     *
     * @param key The key to remove.
     * @return The value associated with the key.
     * @throws java.lang.IllegalArgumentException If key is null.
     * @throws java.util.NoSuchElementException   If the key is not in the map.
     */
    public V remove(K key) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (key == null) {
            throw new IllegalArgumentException();
        }

        ExternalChainingMapEntry<K, V> entry = get(key);
        
        // key not in the map
        if (entry == null) {
            throw new NoSuchElementException();
        }

        // key is in the map
        size -= 1;
        int compressedHash = getCompressedHash(key);
        ExternalChainingMapEntry<K, V> curr = table[compressedHash];

        // entry is the only the chain
        if (curr.getNext() == null) {
            table[compressedHash] = null;
        }

        // entry is the first in the chain
        if (curr == entry) {
            table[compressedHash] = curr.getNext();
        }

        // entry is found later in the chain
        while (curr.getNext() != null) {
            if (curr.getNext() == entry) {
                curr.setNext(curr.getNext().getNext());
                break;
            }
        }

        return entry.getValue();
    }

    /**
     * Helper method stub for resizing the backing table to length.
     *
     * This method should be called in put() if the backing table needs to
     * be resized.
     *
     * You should iterate over the old table in order of increasing index and
     * add entries to the new table in the order in which they are traversed.
     *
     * Since resizing the backing table is working with the non-duplicate
     * data already in the table, you won't need to explicitly check for
     * duplicates.
     *
     * Hint: You cannot just simply copy the entries over to the new table.
     *
     * @param Length The new length of the backing table.
     */
    private void resizeBackingTable(int length) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    }

    /**
     * Returns the table of the map.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The table of the map.
     */
    public ExternalChainingMapEntry<K, V>[] getTable() {
        // DO NOT MODIFY THIS METHOD!
        return table;
    }

    /**
     * Returns the size of the map.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the map.
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}