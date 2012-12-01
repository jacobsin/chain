package chain


class WordChain {

  def dictionary = new NaiveDictionary()

  def solve(String from, String to) {
    validate(from, to)
    doSolve(from, to)
  }

  def doSolve(String from, String to) {
    if (difference(from, to) < 2) {
      return [from, to]
    }
    throw new NoSolutionFoundException(from, to)
  }

  def difference(String string1, String string2) {
    [string1.toCharArray(), string2.toCharArray()].transpose().count{
      it[0] != it[1] ? 1 : 0
    }
  }

  void validate(String from, String to) {
    assert dictionary.isValid(from), "invalid from word (${from})"
    assert dictionary.isValid(to), "invalid to word (${to})"
    assert from.length() == to.length(), "invalid to word length (${to.length()}), should be same length as from word (${from.length()})"
  }

}

class NoSolutionFoundException extends RuntimeException {
  NoSolutionFoundException(String from, String to) {
    super("no solution found from (${from}) to (${to})")
  }
}
