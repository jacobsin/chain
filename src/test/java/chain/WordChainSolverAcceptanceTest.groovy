package chain

import org.junit.Test

class WordChainSolverAcceptanceTest {

  def solver = new WordChainSolver()
  def shouldFail = new GroovyTestCase().&shouldFail

  @Test
  def void invalidFromWord() {
    assert shouldFail {solver.solve("abc\nito")} == "invalid from word (abc). Expression: dictionary.isValid(from)"
  }

  @Test
  def void invalidToWord() {
    assert shouldFail {solver.solve("run\nito")} == "invalid to word (ito). Expression: dictionary.isValid(to)"
  }

  @Test
  def void invalidToWordLength() {
    assert shouldFail {solver.solve("it\nyou")} == "invalid to word length (3), should be same length as from word (2). Expression: (from.length() == to.length())"
  }

  @Test
  def void solveWithZeroStep() {
    assert solver.solve("do\nto") == "do\nto"
    assert solver.solve("do\nso") == "do\nso"
    assert solver.solve("saw\nraw") == "saw\nraw"
    assert solver.solve("saw\nsaw") == "saw\nsaw"
  }

  @Test
  def void solveWithOneStep() {
    assert solver.solve("saw\nran") == "saw\nraw\nran"
  }

  @Test
  def void solveWithTwoSteps() {
    assert solver.solve("saw\nrun") == "saw\nraw\nran\nrun"
  }

  @Test
  def void solveTestIsEasy() {
    assert solver.solve("test\neasy") == "test\nbest\nbast\neast\neasy"
  }

  @Test
  def void solveTestIsGood() {
    assert solver.solve("test\ngood") == "test\nlest\nlost\nloot\nfoot\nfood\ngood"
  }

  @Test
  def void noSolutionFound() {
    assert shouldFail(NoSolutionFoundException) {solver.solve("solution\nexisting")} == "no solution found from (solution) to (existing)"
  }
}
