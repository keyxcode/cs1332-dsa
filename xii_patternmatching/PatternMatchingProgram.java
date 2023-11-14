package xii_patternmatching;

public class PatternMatchingProgram {
    public static void main(String[] args) {
        CharacterComparator comparator = new CharacterComparator();
        System.out.println(PatternMatching.boyerMoore("ABCD", "BAADBACCD", comparator));
        System.out.println(comparator.getComparisonCount());

        comparator = new CharacterComparator();
        System.out.println(PatternMatching.boyerMoore("abaa", "aaabbababbabaabaabbcaabaaaa", comparator));
        System.out.println(comparator.getComparisonCount());
    }
}
