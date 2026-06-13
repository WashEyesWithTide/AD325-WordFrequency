import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import src.WordFrequency;

public class WordFrequencyTest {

    // ---------- Regular cases ----------

    @Test
    public void testSimpleSentence() {
        Map<String, Integer> result = WordFrequency.countWords("The quick brown fox jumps over the lazy dog");
        assertEquals(2, result.get("the"));
        assertEquals(1, result.get("quick"));
        assertEquals(1, result.get("fox"));
        assertEquals(9, result.size());
    }

    @Test
    public void testCaseInsensitivity() {
        Map<String, Integer> result = WordFrequency.countWords("Apple apple APPLE aPpLe");
        assertEquals(4, result.get("apple"));
        assertEquals(1, result.size());
    }

    @Test
    public void testPunctuationStripping() {
        Map<String, Integer> result = WordFrequency.countWords("Hello, world! Hello again.");
        assertEquals(2, result.get("hello"));
        assertEquals(1, result.get("world"));
        assertEquals(1, result.get("again"));
        assertFalse(result.containsKey("hello,"));
        assertFalse(result.containsKey("world!"));
    }

    // ---------- Edge cases ----------

    @Test
    public void testEmptyString() {
        Map<String, Integer> result = WordFrequency.countWords("");
        assertTrue(result.isEmpty());
    }

    @Test
    public void testOnlyPunctuationAndWhitespace() {
        Map<String, Integer> result = WordFrequency.countWords("... !! -- ,, ?? ");
        assertTrue(result.isEmpty());
    }

    @Test
    public void testInternalPunctuationPreserved() {
        Map<String, Integer> result = WordFrequency.countWords("don't stop well-known things, don't!");
        // Internal apostrophes/hyphens are kept; only leading/trailing punctuation is stripped
        assertEquals(2, result.get("don't"));
        assertEquals(1, result.get("well-known"));
        assertEquals(1, result.get("stop"));
        assertEquals(1, result.get("things"));
    }
}