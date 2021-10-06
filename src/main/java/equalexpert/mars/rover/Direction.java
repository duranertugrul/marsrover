package equalexpert.mars.rover;

public enum Direction {

    NORTH(0, 'N'),
    EAST(1, 'E'),
    SOUTH(2, 'S'),
    WEST(3, 'W');

    private final int value;
    private final char shortName;

    Direction(int value, char shortName){
        this.value = value;
        this.shortName = shortName;
    }

    public int getValue() {
        return value;
    }

    public char getShortName() { return shortName; }

}
