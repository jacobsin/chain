package chain

import org.junit.Test


class WordChainIOTest {
  def io = new WordChainIO()
  def shouldFail = new GroovyTestCase().&shouldFail

  @Test
  void parse() {
    assert io.parse("from to") == [from: "from", to: "to"]
  }

  @Test
  def void parseWithSpaces() {
    assert io.parse("from  to") == [from: "from", to: "to"]
  }

  @Test
  def void parseFailsForOneWord() {
    assert shouldFail {io.parse("from")} == "1 words found, expecting exactly 2 expected:<2> but was:<1>"
  }

  @Test
  def void parseFailsForThreeWords() {
    assert shouldFail {io.parse("from to more")} == "3 words found, expecting exactly 2 expected:<2> but was:<3>"
  }

  @Test
  def void format() {
    assert io.format(["from", "step1", "step2", "to"]) == "from->step1->step2->to"
  }
}
