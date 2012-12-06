package chain


class WordChainSolver {

  WordChainIO io = new WordChainIO()
  Dictionary dictionary
  Set<String> visited = []

  def solve(String input) {
    def parsed = io.parse(input)
    io.format(solve(parsed.from, parsed.to))
  }

  def solve(String from, String to) {
    initialise(from.length())
    validate(from, to)
    def solved = doSolve(new WordChain(from, to))
    if (solved) {
      solved.optimize()
      println solved
      return solved.toList()
    }
    throw new NoSolutionFoundException(from, to)
  }

  void initialise(int length) {
//    dictionary = new NaiveDictionary()
    dictionary = new ScowlDictionary(length)
  }

  WordChain doSolve(WordChain chain) {
    println "solving ${chain}"
    visited.add(chain.from)
    if (chain.differenceCount < 2) {
      return chain
    } else {
      def nextSteps = findNextSteps(chain)
      for (WordChain nextStep : nextSteps) {
        def solved = doSolve(nextStep)
        if (solved) {
          return solved << chain.from
        }
      }
      return null
    }
  }

  def findNextSteps(WordChain chain) {
    dictionary.find(chain.nextStepPatterns)
        .findAll {!visited.contains(it)}
        .collect {new WordChain(it, chain.to)}
        .sort {it.differenceCount}
  }

  void validate(String from, String to) {
    assert from.length() == to.length(), "invalid to word length (${to.length()}), should be same length as from word (${from.length()})"
    assert dictionary.isValid(from), "invalid from word (${from})"
    assert dictionary.isValid(to), "invalid to word (${to})"
  }

}

