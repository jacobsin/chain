package chain;


import org.junit.Assert;

public class WordChainSolver {

    private NaiveDictionary dictionary = new NaiveDictionary();

    public String solve(String input) {
        String[] parsed = input.split("\n");
        String from = parsed[0];
        String to = parsed[1];
        validate(from, to);
        throw new NoSolutionFoundException(from, to);
    }

    private void validate(String from, String to) {
        Assert.assertTrue("invalid from word (" + from + ")", dictionary.isValid(from));
    }

}

