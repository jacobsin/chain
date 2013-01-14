package chain

import org.apache.tools.ant.filters.StringInputStream
import org.junit.Test

class WordChainSolverAcceptanceTest {

  def solver = new WordChainSolver()
  def shouldFail = new GroovyTestCase().&shouldFail

  @Test
  def void invalidFromWord() {
    assert shouldFail {solver.solve("abc ito")} == "invalid from word (abc). Expression: dictionary.isValid(from)"
  }

  @Test
  def void invalidToWord() {
    assert shouldFail {solver.solve("run ito")} == "invalid to word (ito). Expression: dictionary.isValid(to)"
  }

  @Test
  def void invalidToWordLength() {
    assert shouldFail {solver.solve("it you")} == "invalid to word length (3), should be same length as from word (2). Expression: (from.length() == to.length())"
  }

  @Test
  def void solveWithZeroStep() {
    assert solver.solve("do to") == "do->to"
    assert solver.solve("do so") == "do->so"
    assert solver.solve("saw raw") == "saw->raw"
    assert solver.solve("saw saw") == "saw->saw"
  }

  @Test
  def void solveWithOneStep() {
    assert solver.solve("saw ran") == "saw->raw->ran"
  }

  @Test
  def void solveWithTwoSteps() {
    assert solver.solve("saw run") == "saw->raw->ran->run"
  }

  @Test
  def void solveMany() {
    def input = new StringInputStream("3\ndo to\nsaw ran\ntest easy\n")
    def buf = new ByteArrayOutputStream()
    def output = new PrintStream(buf)
    solver.solveMany(input, output)
    assert new String(buf.toByteArray()) == "do->to\nsaw->raw->ran\ntest->best->bast->east->easy\n"
  }

  @Test
  def void solveTestIsEasy() {
    assert solver.solve("test easy") == "test->best->bast->east->easy"
  }

  @Test
  def void solveTestIsGood() {
    assert solver.solve("test good") == "test->lest->lost->loot->foot->food->good"
  }

  @Test
  def void noSolutionFound() {
    assert shouldFail(NoSolutionFoundException) {solver.solve("solution existing")} == "no solution found from (solution) to (existing)"
  }
}
