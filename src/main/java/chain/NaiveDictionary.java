package chain;


import java.util.Arrays;
import java.util.List;

public class NaiveDictionary {

    private List<String> validWords = Arrays.asList(
            "at",
            "do",
            "it",
            "so",
            "to",
            "law",
            "ran",
            "raw",
            "row",
            "run",
            "saw",
            "you",
            "easy",
            "good",
            "test",
            "solution",
            "existing"
    );

    public boolean isValid(String word) {
        return validWords.contains(word);
    }
}
