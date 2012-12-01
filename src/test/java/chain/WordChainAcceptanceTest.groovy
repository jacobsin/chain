package chain

import org.junit.Test

class WordChainAcceptanceTest {

  def wordChain = new WordChain()
  def shouldFail = new GroovyTestCase().&shouldFail

  @Test
  def void invalidFromWord() {
    assert shouldFail {wordChain.solve("abc", "ito")} == "invalid from word (abc). Expression: dictionary.isValid(from)"
  }

  @Test
  def void invalidToWord() {
    assert shouldFail {wordChain.solve("it", "ito")} == "invalid to word (ito). Expression: dictionary.isValid(to)"
  }

  @Test
  def void invalidToWordLength() {
    assert shouldFail {wordChain.solve("it", "you")} == "invalid to word length (3), should be same length as from word (2). Expression: (from.length() == to.length())"
  }

  @Test
  def void solveWithZeroStep() {
    assert wordChain.solve("do", "to") == ["do", "to"]
    assert wordChain.solve("do", "so") == ["do", "so"]
    assert wordChain.solve("saw", "raw") == ["saw", "raw"]
    assert wordChain.solve("saw", "saw") == ["saw", "saw"]
  }

  @Test
  def void solveWithOneStep() {
    assert wordChain.solve("saw", "ran") == ["saw", "raw", "ran"]
  }

  @Test
  def void noSolutionFound() {
    assert shouldFail {assert wordChain.solve("it", "do")} == "no solution found from (it) to (do)"
  }
}
