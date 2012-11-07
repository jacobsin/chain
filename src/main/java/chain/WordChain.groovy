package chain


class WordChain {

  def solve(String from, String to) {
    validate(from, to)
  }

  void validate(String from, String to) {
    assert from.length() == to.length(), "invalid to word length (${to.length()}), should be same length as from word (${from.length()})"
  }
}
