import java.util.*;

public class WordFrequency {

    public static Map<String, Integer> countWords(String text) {
        String[] words = text.split("\\s+");
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase().replaceAll("^[\\p{Punct}]+|[\\p{Punct}]+$", "");
            if (word.isEmpty()) continue;
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        return new TreeMap<>(freq);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a block of text:");
        String text = scanner.nextLine();

        Map<String, Integer> sorted = countWords(text);
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}