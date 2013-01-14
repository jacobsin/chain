package chain;


public class NoSolutionFoundException extends RuntimeException {
    NoSolutionFoundException(String from, String to) {
        super(String.format("no solution found from (%s) to (%s)", from, to));
    }
}
