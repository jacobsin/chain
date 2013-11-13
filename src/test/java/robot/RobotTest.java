package robot;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;


public class RobotTest {

    private Robot robot;

    @Before
    public void before() {
        robot = new Robot();
    }

    @Test
    public void originalLocation() {
        assertLocation(0, 0);
    }

    @Test
    public void newLocationAfterMoveToEast1() {
        robot.move("east 1");
        assertLocation(1, 0);
    }

    @Test
    public void newLocationAfterMoveToWest2() {
        robot.move("west 2");
        assertLocation(-2, 0);
    }

    @Test
    public void newLocationAfterMoveToNorth3() {
        robot.move("north 3");
        assertLocation(0, 3);
    }

    @Test
    public void newLocationAfterMoveToSouth4() {
        robot.move("south 4");
        assertLocation(0, -4);
    }

    private void assertLocation(int x, int y) {
        Point location = robot.getLocation();
        Assert.assertThat("location.x", location.getX(), Is.is((double) x));
        Assert.assertThat("location.y", location.getY(), Is.is((double) y));
    }

}
