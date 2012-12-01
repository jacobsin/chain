package chain


class WordChain {

  def dictionary = new NaiveDictionary()

  def solve(String from, String to) {
    validate(from, to)
    def solved = doSolve(from, to)
    if (solved) return solved
    throw new NoSolutionFoundException(from, to)
  }

  List<String> doSolve(String from, String to) {
    def comparison = new WordComparison(from, to)
    if (comparison.differenceCount < 2) {
      return [from, to]
    } else {
      def nextSteps = findNextSteps(comparison)
      for (String nextStep : nextSteps) {
        def solved = doSolve(nextStep, to)
        if (solved) {
          solved.add(0, from)
          return solved
        }
      }
      return null
    }
  }

  def findNextSteps(WordComparison comparison) {
    dictionary.find(comparison.nextStepPatterns).findAll {it != comparison.word1}
  }

  void validate(String from, String to) {
    assert dictionary.isValid(from), "invalid from word (${from})"
    assert dictionary.isValid(to), "invalid to word (${to})"
    assert from.length() == to.length(), "invalid to word length (${to.length()}), should be same length as from word (${from.length()})"
  }

}

class WordComparison {
  def differenceCount = 0
  def nextStepPatterns = []
  String word1
  String word2

  WordComparison(word1, word2) {
    this.word1 = word1
    this.word2 = word2
    compare()
  }

  def compare() {
    [word1.toCharArray(), word2.toCharArray()].transpose().eachWithIndex{it, i->
      if (it[0] != it[1]) {
        differenceCount++

        def nextStepPattern = new StringBuilder(word1)
        nextStepPattern.setCharAt(i, '.' as char)
        nextStepPatterns << nextStepPattern.toString()
      }
    }
  }
}