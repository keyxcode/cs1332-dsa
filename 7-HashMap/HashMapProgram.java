import java.util.Arrays;

public class HashMapProgram {
    public static void main(String[] args) {
        ExternalChainingHashMap<Integer, Integer> myMap = new ExternalChainingHashMap<>();

        myMap.put(13, 13);
        myMap.put(53, 53);
        myMap.put(15, 15);
        myMap.put(3, 3);
        myMap.put(17, 17);
        myMap.put(5, 5);
        myMap.put(19, 19);
        myMap.put(218, 218);
        System.out.println(Arrays.toString(myMap.getTable()));

        myMap.put(1, 1);
        System.out.println(Arrays.toString(myMap.getTable()));

        // myMap.remove(1);
        // System.out.println(Arrays.toString(myMap.getTable()));

        // myMap.put(24, 24);
        // System.out.println(Arrays.toString(myMap.getTable()));
        // myMap.put(2, 5);
        // System.out.println(Arrays.toString(myMap.getTable()));
        // myMap.put(54, 54);
        // System.out.println(myMap.getTable()[0].getNext());
    }    
}
