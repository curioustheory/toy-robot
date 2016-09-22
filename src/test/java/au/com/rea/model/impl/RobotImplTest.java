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
		// test east
		Position newPosition = new Position(3, 3, Orientation.EAST);
		robot.place(newPosition);
		robot.moveForward();
		
		assert robot.getPosition().getX() == 4;
		assert robot.getPosition().getY() == 3;
		assert robot.getPosition().getOrientation() == Orientation.EAST;

		// test north
		newPosition = new Position(3, 3, Orientation.NORTH);
		robot.place(newPosition);
		robot.moveForward();
		
		assert robot.getPosition().getX() == 3;
		assert robot.getPosition().getY() == 4;
		assert robot.getPosition().getOrientation() == Orientation.NORTH;

		// test west
		newPosition = new Position(3, 3, Orientation.WEST);
		robot.place(newPosition);
		robot.moveForward();
		
		assert robot.getPosition().getX() == 2;
		assert robot.getPosition().getY() == 3;
		assert robot.getPosition().getOrientation() == Orientation.WEST;

		// test south
		newPosition = new Position(3, 3, Orientation.SOUTH);
		robot.place(newPosition);
		robot.moveForward();
		
		assert robot.getPosition().getX() == 3;
		assert robot.getPosition().getY() == 2;
		assert robot.getPosition().getOrientation() == Orientation.SOUTH;
	}

	@Test
	public void testTurnRight() {
		// test east
		Position newPosition = new Position(3, 3, Orientation.EAST);
		robot.place(newPosition);
		robot.turnRight();
		
		assert robot.getPosition().getX() == 3;
		assert robot.getPosition().getY() == 3;
		assert robot.getPosition().getOrientation() == Orientation.SOUTH;

		// test north
		newPosition = new Position(3, 3, Orientation.NORTH);
		robot.place(newPosition);
		robot.turnRight();
		
		assert robot.getPosition().getX() == 3;
		assert robot.getPosition().getY() == 3;
		assert robot.getPosition().getOrientation() == Orientation.EAST;

		// test west
		newPosition = new Position(3, 3, Orientation.WEST);
		robot.place(newPosition);
		robot.turnRight();
		
		assert robot.getPosition().getX() == 3;
		assert robot.getPosition().getY() == 3;
		assert robot.getPosition().getOrientation() == Orientation.NORTH;

		// test south
		newPosition = new Position(3, 3, Orientation.SOUTH);
		robot.place(newPosition);
		robot.turnRight();
		
		assert robot.getPosition().getX() == 3;
		assert robot.getPosition().getY() == 3;
		assert robot.getPosition().getOrientation() == Orientation.WEST;
	}

	@Test
	public void testTurnLeft() {
		// test east
		Position newPosition = new Position(3, 3, Orientation.EAST);
		robot.place(newPosition);
		robot.turnLeft();
		
		assert robot.getPosition().getX() == 3;
		assert robot.getPosition().getY() == 3;
		assert robot.getPosition().getOrientation() == Orientation.NORTH;

		// test north
		newPosition = new Position(3, 3, Orientation.NORTH);
		robot.place(newPosition);
		robot.turnLeft();
		
		assert robot.getPosition().getX() == 3;
		assert robot.getPosition().getY() == 3;
		assert robot.getPosition().getOrientation() == Orientation.WEST;

		// test west
		newPosition = new Position(3, 3, Orientation.WEST);
		robot.place(newPosition);
		robot.turnLeft();
		
		assert robot.getPosition().getX() == 3;
		assert robot.getPosition().getY() == 3;
		assert robot.getPosition().getOrientation() == Orientation.SOUTH;

		// test south
		newPosition = new Position(3, 3, Orientation.SOUTH);
		robot.place(newPosition);
		robot.turnLeft();
		
		assert robot.getPosition().getX() == 3;
		assert robot.getPosition().getY() == 3;
		assert robot.getPosition().getOrientation() == Orientation.EAST;
	}

	@Test
	public void testReportStatus() {
		assert robot.reportStatus().equals("WALL-E says: \"I am at (0, 0) facing NORTH.\"");
		
		Position newPosition = new Position(2, 1, Orientation.EAST);
		robot.place(newPosition);

		assert robot.reportStatus().equals("WALL-E says: \"I am at (2, 1) facing EAST.\"");
	}
	
	@Test
	public void testBoundary() {
		fail("Not yet implemented");
	}

}
