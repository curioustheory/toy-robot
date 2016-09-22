package au.com.rea.model.impl;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import au.com.rea.model.Position;
import au.com.rea.model.Position.Orientation;
import au.com.rea.model.Robot;

public class RobotImplTest {
	private Robot robot = null;
	
	@Before
	public void setup() {
		robot = new RobotImpl(1, new Position());
	}
	
	@Test
	public void testPlace() {
		assert robot.getPosition().getX() == 0;
		assert robot.getPosition().getY() == 0;
		assert robot.getPosition().getOrientation() == Orientation.NORTH;
	
		Position newPosition = new Position(5, 7, Orientation.SOUTH);
		robot.place(newPosition);
		
		assert robot.getPosition().getX() == 5;
		assert robot.getPosition().getY() == 7;
		assert robot.getPosition().getOrientation() == Orientation.SOUTH;
	}

	@Test
	public void testMoveForward() {
		fail("Not yet implemented");
	}

	@Test
	public void testTurnRight() {
		fail("Not yet implemented");
	}

	@Test
	public void testTurnLeft() {
		fail("Not yet implemented");
	}

	@Test
	public void testReportStatus() {
		fail("Not yet implemented");
	}

}
