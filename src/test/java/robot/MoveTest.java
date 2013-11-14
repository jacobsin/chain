package robot;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class MoveTest {

    @Test
    public void parseFromCommandString() {
        Move move = Move.parse("east 1");

        assertThat(move.getDirection(), equalTo("east"));
        assertThat(move.getSteps(), equalTo(1));
    }
}
