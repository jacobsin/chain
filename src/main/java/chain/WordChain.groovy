package chain


class WordChain {

  Dictionary dictionary

  def solve(String from, String to) {
    initialise(from.length())
    validate(from, to)
    def solved = doSolve(from, to)
    if (solved) return solved
    throw new NoSolutionFoundException(from, to)
  }

  void initialise(int length) {
    dictionary = new NaiveDictionary()
//    dictionary = new ScowlDictionary(length)
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
    assert from.length() == to.length(), "invalid to word length (${to.length()}), should be same length as from word (${from.length()})"
    assert dictionary.isValid(from), "invalid from word (${from})"
    assert dictionary.isValid(to), "invalid to word (${to})"
  }

}

