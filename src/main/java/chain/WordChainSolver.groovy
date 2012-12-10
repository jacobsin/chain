package chain


class WordChainSolver {

  def dictionary  = new NaiveDictionary()

  def solve(String input) {
    def parsed = input.split('\n')
    def from = parsed[0]
    def to = parsed[1]
    validate(from, to)
    throw new NoSolutionFoundException(from, to)
  }

  void validate(String from, String to) {
    assert dictionary.isValid(from), "invalid from word (${from})"
  }

}

