package equalexpert.mars.rover;

public class Rover {

    private Position position;

    public Rover(final Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(final Position position) {
        this.position = position;
    }

    public void singleCommand(final char command) {
        switch (command){
            case 'F':
                position.moveForward();
                break;
            case 'B':
                position.moveBackward();
                break;
            case 'L':
                position.turnToLeft();
                break;
            case 'R':
                position.turnToRight();
                break;
            default:
                throw new IllegalArgumentException("Command " + command + " is unknown.");
        }
    }

    public void command(final String commands) {
        for (final char command :commands.toCharArray()) {
            singleCommand(command);
        }
    }
}
