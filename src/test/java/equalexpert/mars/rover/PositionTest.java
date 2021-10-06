package equalexpert.mars.rover;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PositionTest {

    private Position underTest;
    private final int x = 3;
    private final int y = 4;
    private final Direction direction = Direction.NORTH;

    @Before
    public void setup() {
        underTest = new Position(x, y, direction);
    }

    @Test
    public void shouldReturnInitialValues() {
        assertEquals(x, underTest.getX());
        assertEquals(y, underTest.getY());
        assertEquals(direction, underTest.getDirection());
    }

    @Test
    public void shouldReturnWestWhenTurnedToLeft() {
        underTest.turnToLeft();
        assertEquals(Direction.WEST, underTest.getDirection());
    }

    @Test
    public void shouldReturnSouthWhenTurnedToLeftTwice() {
        underTest.turnToLeft();
        underTest.turnToLeft();
        assertEquals(Direction.SOUTH, underTest.getDirection());
    }


    @Test
    public void shouldReturnEastWhenTurnedToRight() {
        underTest.turnToRight();
        assertEquals(Direction.EAST, underTest.getDirection());
    }

    @Test
    public void shouldReturnSouthWhenTurnedToRightTwice() {
        underTest.turnToRight();
        underTest.turnToRight();
        assertEquals(Direction.SOUTH, underTest.getDirection());
    }


    @Test
    public void shouldReturnIncreaseYWhenForward() {
        underTest.moveForward();
        int expectedY = y + 1;
        assertEquals(expectedY, underTest.getY());
    }

    @Test
    public void shouldReturnDecreaseYWhenForward() {
        underTest.moveBackward();
        int expectedY = y - 1;
        assertEquals(expectedY, underTest.getY());
    }


    @Test
    public void shouldReturnDecreaseXWhenTurnLeftAndMoveForward() {
        underTest.turnToLeft();
        underTest.moveForward();
        int expectedX = x - 1;
        assertEquals(expectedX, underTest.getX());
    }

    @Test
    public void shouldReturnIncreaseXWhenTurnLeftAndMoveForward() {
        underTest.turnToRight();
        underTest.moveForward();
        int expectedX = x + 1;
        assertEquals(expectedX, underTest.getX());
    }

    @Test
    public void shouldReturnIncreaseXWhenTurnLeftAndMoveBackward() {
        underTest.turnToLeft();
        underTest.moveBackward();
        int expectedX = x + 1;
        assertEquals(expectedX, underTest.getX());
    }

    @Test
    public void shouldReturnDecreaseXWhenTurnLeftAndMoveBackward() {
        underTest.turnToRight();
        underTest.moveBackward();
        int expectedX = x - 1;
        assertEquals(expectedX, underTest.getX());
    }

    @Test
    public void shouldReturnDecreaseYWhenTurnRightTwiceAndMoveBackward() {
        underTest.turnToRight();
        underTest.turnToRight();
        underTest.moveForward();
        int expectedY = y - 1;
        assertEquals(expectedY, underTest.getY());
    }

    @Test
    public void toStringShouldReturnXAndYAndDirection() {
        String expected = format("equalexpert.mars.rover.Position{x=%s, y=%s, direction=%s}", x,y, direction.getShortName());

        assertEquals( expected, underTest.toString());
    }

}
