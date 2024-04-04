import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCountUsingHashMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        scanner.close();

        Map<String, Integer> wordCountMap = countWords(input);
        displayWordCount(wordCountMap);
    }

    public static Map<String, Integer> countWords(String input) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        String[] words = input.trim().split("\\s+");

        for (String word : words) {
            word = word.toLowerCase();

            word = word.replaceAll("[^a-zA-Z0-9]", "");

            if (!word.isEmpty()) {
                // Update word count in the HashMap
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        return wordCountMap;
    }

    public static void displayWordCount(Map<String, Integer> wordCountMap) {
        System.out.println("Word Counts:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("Total words: " + wordCountMap.size());
    }
}
