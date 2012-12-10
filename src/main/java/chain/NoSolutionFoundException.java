package chain;


public class NoSolutionFoundException extends RuntimeException {
    public NoSolutionFoundException(String from, String to) {
        super("no solution found from (" + from + ") to (" + to + ")");
    }
}
