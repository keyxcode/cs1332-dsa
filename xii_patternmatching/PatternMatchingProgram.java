package xii_patternmatching;

import java.util.Map;

public class PatternMatchingProgram {
    public static void main(String[] args) {
        CharacterComparator comparator = new CharacterComparator();

        System.out.println(PatternMatching.boyerMoore("ABCD", "BAADBACCD", comparator));
        System.out.println(comparator.getComparisonCount());
    }
}
