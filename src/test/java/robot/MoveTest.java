package robot;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

public class MoveTest {

    @Test
    public void parseFromCommandString() {
        Move move = Move.parse("east 1");

        Assert.assertThat(move.getDirection(), IsEqual.equalTo("east"));
        Assert.assertThat(move.getSteps(), IsEqual.equalTo(1));
    }
}
