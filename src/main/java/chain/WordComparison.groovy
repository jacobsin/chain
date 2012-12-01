package chain


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
