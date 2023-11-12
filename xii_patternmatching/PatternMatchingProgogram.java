package xii_patternmatching;

import java.util.Map;

public class PatternMatchingProgogram {
    public static void main(String[] args) {
        Map<Character, Integer> table = PatternMatching.buildLastTable("octocat");
        System.out.println(table);
        System.out.println(table.get("yo"));
    }
}
