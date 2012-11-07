package chain

import org.junit.Test


class WordChainTest {

  def wordChain = new WordChain()
  def shouldFail = new GroovyTestCase().&shouldFail

  @Test
  def void invalidToWordLength() {
    assert shouldFail {wordChain.solve("it", "you")} == "invalid to word length (3), should be same length as from word (2). Expression: (from.length() == to.length())"
  }

  @Test
  def void solveOneStep() {
    assert wordChain.solve("do", "to") == ["do", "to"]
    assert wordChain.solve("do", "so") == ["do", "so"]
  }
}
