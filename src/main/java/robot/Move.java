package robot;

public class Move {
    private String direction;
    private int steps;
    private int x = 0;
    private int y = 0;

    static Move parse(String command) {
        String[] tokens = command.split(" ");
        return new Move(tokens[0], Integer.parseInt(tokens[1]));
    }

    Move(String direction, int steps) {
        this.direction = direction;
        this.steps = steps;
        setXAndY(direction, steps);
    }

    private void setXAndY(String direction, int steps) {
        if ("east".equals(direction)) x = 1;
        if ("west".equals(direction)) x = -1;
        if ("north".equals(direction)) y = 1;
        if ("south".equals(direction)) y = -1;

        x = x * steps;
        y = y * steps;
    }

    String getDirection() {
        return direction;
    }

    int getSteps() {
        return steps;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
