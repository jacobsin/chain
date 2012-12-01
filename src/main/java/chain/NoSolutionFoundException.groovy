package chain


class NoSolutionFoundException extends RuntimeException {
  NoSolutionFoundException(String from, String to) {
    super("no solution found from (${from}) to (${to})")
  }
}
