package equalexpert.mars.rover;

public class Position {
    private int x;
    private int y;
    private Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void changeDirectionLeft(int directionStep) {
        int directions = Direction.values().length;
        int index = (directions + direction.getValue() + directionStep) % Direction.values().length;
        this.direction = Direction.values()[index];
    }

    public void turnToLeft() {
        changeDirectionLeft(-1);
    }

    public void turnToRight() {
        changeDirectionLeft(1);
    }

    private void move(int directionStep) {
        switch (direction) {
            case NORTH:
                y = y + directionStep;
                break;
            case EAST:
                x = x + directionStep;
                break;
            case SOUTH:
                y = y - directionStep;
                break;
            case WEST:
                x = x - directionStep;
                break;
        }
    }

    public void moveForward() {
        move(1);
    }

    public void moveBackward() {
        move(-1);
    }

    @Override
    public String toString() {
        return "equalexpert.mars.rover.Position{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction.getShortName() +
                '}';
    }
}
