package robot;

import java.awt.*;

public class Robot {
    private Point location = new Point();

    public Point getLocation() {
        return location.getLocation();
    }

    public void move(String command) {
        Move move = Move.parse(command);
        location.move(move.getX(), move.getY());
    }

}
