package robot;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static robot.RobotCommand.FORWARD;
import static robot.RobotCommand.RIGHT;

public class Robot {
    private Point location = new Point();
    private List<RobotCommand> commands = new ArrayList<RobotCommand>();

    public Point getLocation() {
        return location.getLocation();
    }

    public void move(String command) {
        Move move = Move.parse(command);

        if ("east".equals(move.getDirection())) commands.add(RIGHT);
        if ("west".equals(move.getDirection())) commands.addAll(asList(RIGHT, RIGHT, RIGHT));
        if ("south".equals(move.getDirection())) commands.addAll(asList(RIGHT, RIGHT));

        for (int i = 0; i < move.getSteps(); i++) {
             commands.add(FORWARD);
        }


        location.move(move.getX(), move.getY());
    }


    public List<RobotCommand> getCommands() {
        return commands;
    }
}
