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
  def void solveTestIsEasy() {
    assert solver.solve("test\neasy") == "test\nbest\nbast\neast\neasy"
  }

  @Test
  def void noSolutionFound() {
    assert shouldFail(NoSolutionFoundException) {solver.solve("solution\nexisting")} == "no solution found from (solution) to (existing)"
  }
}
