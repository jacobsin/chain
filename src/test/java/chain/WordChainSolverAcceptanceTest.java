package chain;

import junit.framework.Assert;
import org.junit.Test;

public class WordChainSolverAcceptanceTest {

    WordChainSolver solver = new WordChainSolver();

    @Test
    public void invalidFromWord() {
        try {
            solver.solve("abc\nito");
            Assert.fail("should have failed");
        } catch (AssertionError e) {
            Assert.assertEquals("invalid from word (abc)", e.getMessage());
        }
    }

    @Test
    public void solveTestIsEasy() {
        Assert.assertEquals("test\nbest\nbast\neast\neasy", solver.solve("test\neasy"));
    }

    @Test
    public void noSolutionFound() {
        try {
            solver.solve("solution\nexisting");
            Assert.fail("should have failed");
        } catch (NoSolutionFoundException e) {
            Assert.assertEquals("no solution found from (solution) to (existing)", e.getMessage());
        }
    }
}
