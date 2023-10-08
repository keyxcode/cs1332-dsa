import java.util.Arrays;

public class HashMapProgram {
    public static void main(String[] args) {
        ExternalChainingHashMap<Integer, Integer> myMap = new ExternalChainingHashMap<>();

        myMap.getTable()[5] = new ExternalChainingMapEntry<Integer,Integer>(5, 5);
        System.out.println(Arrays.toString(myMap.getTable()));
        System.out.println(myMap.get(5));

        myMap.put(0, 0);
        myMap.put(1, 1);
        myMap.put(2, 2);
        myMap.put(3, 3);
        myMap.put(4, 4);
        myMap.put(6, 6);
        myMap.put(7, 7);
        myMap.put(8, 8);
        System.out.println(Arrays.toString(myMap.getTable()));

        myMap.put(9, 9);
        myMap.put(10, 10);
        myMap.put(11, 11);
        myMap.put(12, 12);
        System.out.println(Arrays.toString(myMap.getTable()));

        myMap.remove(1);
        System.out.println(Arrays.toString(myMap.getTable()));

        myMap.put(24, 24);
        System.out.println(Arrays.toString(myMap.getTable()));
        myMap.put(2, 5);
        System.out.println(Arrays.toString(myMap.getTable()));
        myMap.put(54, 54);
        System.out.println(Arrays.toString(myMap.getTable()));
        System.out.println(myMap.get(54).getNext());
    }    
}
