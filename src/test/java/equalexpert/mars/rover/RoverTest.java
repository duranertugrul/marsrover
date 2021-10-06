package equalexpert.mars.rover;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RoverTest {

    private Rover underTest;

    private final Direction direction = Direction.NORTH;
    private Position position;

    @Before
    public void setup() {
        position = new Position(3, 4, direction);
        underTest = new Rover(position);
    }

    @Test
    public void shouldReturnInitialValue() {
        assertEquals(underTest.getPosition().getX(), position.getX());
        assertEquals(underTest.getPosition().getY(), position.getY());
        assertEquals(underTest.getPosition().getDirection(), position.getDirection());
    }

    @Test
    public void shouldReturnIncreasedYWhenSingleCommandIsF() {
        int expectedY = position.getY() + 1;

        underTest.singleCommand('F');
        assertEquals(underTest.getPosition().getY(), expectedY);
    }

    @Test
    public void shouldReturnDecreasedYWhenSingleCommandIsB() {
        int expectedY = position.getY() - 1;

        underTest.singleCommand('B');
        assertEquals(underTest.getPosition().getY(), expectedY);
    }

    @Test
    public void shouldReturnWestDirectionWhenSingleCommandIsL() {
        underTest.singleCommand('L');
        assertEquals(underTest.getPosition().getDirection(), Direction.WEST);
    }

    @Test
    public void shouldReturnEastDirectionWhenSingleCommandIsR() {
        underTest.singleCommand('R');
        assertEquals(underTest.getPosition().getDirection(), Direction.EAST);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnEastDirectionWhenSingleCommandIsX() {
        underTest.singleCommand('X');
    }

    @Test
    public void shouldAbleToHaveMultipleCommands() {
        underTest.setPosition(new Position(4, 2, Direction.EAST));
        underTest.command("FLFFFRFLB");
        assertEquals(underTest.getPosition().getX(), 6);
        assertEquals(underTest.getPosition().getY(), 4);
        assertEquals(underTest.getPosition().getDirection(), Direction.NORTH);
    }
}
