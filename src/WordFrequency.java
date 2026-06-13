import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a block of text:");
        String text = scanner.nextLine();

        String[] words = text.split("\\s+");

        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty()) continue;
            word = word.toLowerCase().replaceAll("^[\\p{Punct}]+|[\\p{Punct}]+$", "");
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        TreeMap<String, Integer> sorted = new TreeMap<>(freq);

        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}