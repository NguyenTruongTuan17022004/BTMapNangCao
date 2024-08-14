package NangCaoVeMap.Bai2;

import java.util.HashMap;
import java.util.Map;

public class SubstringFrequency {
    public static void main(String[] args) {
        String input = "abcabc";
        int length = 2;

        Map<String, Integer> substringCounts = countSubstrings(input, length);
        for (Map.Entry<String, Integer> entry : substringCounts.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static Map<String, Integer> countSubstrings(String input, int length) {
        Map<String, Integer> substringCounts = new HashMap<>();
        int n = input.length();

        for (int i = 0; i <= n - length; i++) {
            String substring = input.substring(i, i + length);
            substringCounts.put(substring, substringCounts.getOrDefault(substring, 0) + 1);
        }

        return substringCounts;
    }
}

