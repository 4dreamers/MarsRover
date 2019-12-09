import com.xingevents.marsrover.model.Plateau;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class PlateauTest
{
	private Plateau plateau;
	Plateau plateauWrongXY;
	private final int upperCornerX = 5;
	private final int upperCornerY = 5;
	private final int upperCornerXWrongValue = -1;
	private final int upperCornerYWrongValue = -1;

	@Before
	public void setup() throws Exception
	{
		plateau = new Plateau(upperCornerX, upperCornerY);
	}

	@Test
	public void plateauTestConstructor() throws Exception
	{
		Assert.assertEquals(plateau.getUpperXCorner(), 5 );
		Assert.assertEquals(plateau.getUpperYCorner(), 5 );
		Assert.assertEquals(plateau.getLowerXCorner(), 0 );
		Assert.assertEquals(plateau.getLowerYCorner(), 0 );
	}

	@Test(expected = IllegalArgumentException.class)
	public void plateauTestConstructorIllegalValues() throws Exception
	{
		Plateau plateauWrongXY = new Plateau(upperCornerXWrongValue, upperCornerYWrongValue);
		Plateau plateauWrongX = new Plateau(upperCornerXWrongValue, upperCornerY);
		Plateau plateauWrongY = new Plateau(upperCornerX, upperCornerYWrongValue);
	}

	@Test
	public void plateauTestConstructorOrderOfSettings() throws Exception
	{
		Plateau plateauOrderXY = new Plateau(5, 3);
		Assert.assertEquals(plateauOrderXY.getUpperXCorner(), 5 );
		Assert.assertEquals(plateauOrderXY.getUpperYCorner(), 3 );
	}

}