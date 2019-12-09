import com.xingevents.marsrover.controller.RoverControllerImpl;
import com.xingevents.marsrover.model.Plateau;
import com.xingevents.marsrover.model.Rover;
import com.xingevents.marsrover.utils.IConstants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.CharConversionException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class RoverControllerImplTest {

    private Plateau plateau;
    private Rover   rover;
    private RoverControllerImpl roverController;
    private char command;

    public RoverControllerImplTest(char command) {
        super();
        this.command = command;
    }

    @Before
    public void setUp() throws Exception {
        plateau = new Plateau(5, 5);
        rover   = new Rover(1,1,"N");
        roverController = new RoverControllerImpl(plateau, rover);
    }

    @Parameterized.Parameters
    public static Collection input(){
        return Arrays.asList('U', 'T', 'I', 'O');
    }

    @Test
    public void move() {
        roverController.move();
        Assert.assertEquals(rover.getPositionY(), 2);
        roverController.move();
        Assert.assertEquals(rover.getPositionX(), 1);
        rover.setCompassPosition(IConstants.WEST);
        roverController.move();
        Assert.assertEquals(rover.getPositionY(), 3);
        Assert.assertEquals(rover.getPositionX(), 0);
    }

    @Test
    public void turnLeft() {
        roverController.turnLeft();
        Assert.assertEquals(rover.getCompassPosition(), IConstants.WEST);
        roverController.turnLeft();
        Assert.assertEquals(rover.getCompassPosition(), IConstants.SOUTH);

    }

    @Test
    public void turnRight() {
        roverController.turnRight();
        Assert.assertEquals(rover.getCompassPosition(), IConstants.EAST);
        roverController.turnRight();
        Assert.assertEquals(rover.getCompassPosition(), IConstants.SOUTH);
    }

    @Test
    public void testProcessCommand() {
        roverController.processCommand('L');
        Assert.assertEquals(rover.getCompassPosition(), IConstants.WEST);
        roverController.processCommand('R');
        Assert.assertEquals(rover.getCompassPosition(), IConstants.NORTH);
        roverController.processCommand('M');
        Assert.assertEquals(rover.getPositionY(), 2);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongProcessCommand() {
        roverController.processCommand(command);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testOutOfBoundsProcessCommand() {
        rover.setPositionX(5);
        rover.setPositionY(5);
        rover.setCompassPosition(IConstants.NORTH);
        roverController.processCommand('M');
    }

    @Test
    public void testIsRoverAbleToMove() {
        Assert.assertTrue(roverController.isRoverAbleToMove());
        rover.setCompassPosition(IConstants.EAST);
        Assert.assertTrue(roverController.isRoverAbleToMove());
        rover.setCompassPosition(IConstants.WEST);
        Assert.assertTrue(roverController.isRoverAbleToMove());
        rover.setCompassPosition(IConstants.SOUTH);
        Assert.assertTrue(roverController.isRoverAbleToMove());
        rover.setPositionY(5);
        rover.setCompassPosition(IConstants.NORTH);
        Assert.assertFalse(roverController.isRoverAbleToMove());
    }

    @Test
    public void testExecuteCommands() throws CharConversionException {
       rover.setPositionX(1);
       rover.setPositionY(2);
       rover.setCompassPosition(IConstants.NORTH);
       String commandString = "LMLMLMLMM";
       roverController.executeCommands(commandString);
       Assert.assertEquals("1 3 N", rover.getPositionX() + " "
                                                + rover.getPositionY() + " "
                                                + rover.getCompassPosition() );
    }
}