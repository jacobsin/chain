package robot;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Collections;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static robot.RobotCommand.FORWARD;
import static robot.RobotCommand.RIGHT;


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
    public void originalCommands() {
        assertThat(robot.getCommands(), equalTo(Collections.<RobotCommand>emptyList()));
    }

    @Test
    public void newLocationAfterMoveToEast1() {
        robot.move("east 1");
        assertLocation(1, 0);
    }

    @Test
    public void commandsAfterMoveToEast1() {
        robot.move("east 1");
        assertThat(robot.getCommands(), equalTo(asList(RIGHT, FORWARD)));
    }

    @Test
    public void newLocationAfterMoveToWest2() {
        robot.move("west 2");
        assertLocation(-2, 0);
    }

    @Test
    public void commandsAfterMoveToWest2() {
        robot.move("west 2");
        assertThat(robot.getCommands(), equalTo(asList(RIGHT, RIGHT, RIGHT, FORWARD, FORWARD)));
    }

    @Test
    public void newLocationAfterMoveToNorth3() {
        robot.move("north 3");
        assertLocation(0, 3);
    }

    @Test
    public void commandsAfterMoveToNorth3() {
        robot.move("north 3");
        assertThat(robot.getCommands(), equalTo(asList(FORWARD, FORWARD, FORWARD)));
    }

    @Test
    public void newLocationAfterMoveToSouth4() {
        robot.move("south 4");
        assertLocation(0, -4);
    }

    @Test
    public void commandsAfterMoveToSouth4() {
        robot.move("south 4");
        assertThat(robot.getCommands(), equalTo(asList(RIGHT, RIGHT, FORWARD, FORWARD, FORWARD, FORWARD)));
    }

    private void assertLocation(int x, int y) {
        Point location = robot.getLocation();
        assertThat("location.x", location.getX(), is((double) x));
        assertThat("location.y", location.getY(), is((double) y));
    }

}
