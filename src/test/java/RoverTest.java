import com.xingevents.marsrover.model.Plateau;

import com.xingevents.marsrover.model.Rover;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized;

import java.io.CharConversionException;

@RunWith(JUnit4.class)
public class RoverTest
{
	private Rover rover;
	private final int roverXPosition = 1;
	private final int roverYPosition = 2;
	private final String roverCompassPosition = "N";
	private final int roverXWrongValue = -1;
	private final int roverYWrongValue = -2;
	private final String roverWrongCompassPosition = "T";


	@Before
	public void setup() throws Exception
	{
		rover = new Rover(roverXPosition, roverYPosition, roverCompassPosition);
	}

	@Test
	public void roverTestConstructor() throws Exception
	{
		Assert.assertEquals(rover.getPositionX(), 1 );
		Assert.assertEquals(rover.getPositionY(), 2 );
		Assert.assertEquals(rover.getCompassPosition(), "N" );

	}

	@Test(expected = IllegalArgumentException.class)
	public void roverTestConstructorWrongXYValues() throws Exception
	{
		Rover roverWrongXY = new Rover(roverXWrongValue, roverYWrongValue, roverCompassPosition);
	}

	@Test(expected = CharConversionException.class)
	public void roverTestConstructorWrongCompassValue() throws Exception
	{
		Rover roverWrongCompass = new Rover(roverXPosition, roverYPosition, roverWrongCompassPosition);
	}

	@Test
	public void roverTestConstructorOrderOfSettings() throws Exception
	{
		Rover roverOrderXY = new Rover(5, 3, "W");
		Assert.assertEquals(roverOrderXY.getPositionX(), 5 );
		Assert.assertEquals(roverOrderXY.getPositionY(), 3 );
	}

}