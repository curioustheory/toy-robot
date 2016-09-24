package au.com.rea.model.impl;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import au.com.rea.exception.InvalidMovementException;
import au.com.rea.model.Position;
import au.com.rea.model.Position.Orientation;
import au.com.rea.model.Robot;
import au.com.rea.model.TerrainData;

public class RobotImplTest {
	private Robot robot = null;

	@Before
	public void setup() {
		robot = new RobotImpl(1, new TerrainData(5, 5));
	}

	@Test
	public void testPlace() {
		// placing robot with in normal range
		try {
			assert robot.getPosition().getX() == 0;
			assert robot.getPosition().getY() == 0;
			assert robot.getPosition().getOrientation() == Orientation.NORTH;

			Position newPosition = new Position(0, 1, Orientation.NORTH);
			robot.place(newPosition);

			assert robot.getPosition().getX() == 0;
			assert robot.getPosition().getY() == 1;
			assert robot.getPosition().getOrientation() == Orientation.NORTH;

			newPosition = new Position(4, 2, Orientation.SOUTH);
			robot.place(newPosition);

			assert robot.getPosition().getX() == 4;
			assert robot.getPosition().getY() == 2;
			assert robot.getPosition().getOrientation() == Orientation.SOUTH;
		} catch (InvalidMovementException e) {
			fail("Unexpected error!");
		}

		// placing robot outside of range
		try {
			robot.place(new Position(8, -1, Orientation.EAST));
			fail("Expected an InvalidMovementException to be thrown");
		} catch (InvalidMovementException e) {
			assert e.getMessage().equals("InvalidMovementException: Moving forward will result in death!");
		}
	}

	@Test
	public void testMoveForward() {
		try {
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
		} catch (InvalidMovementException e) {
			fail("Unexpected error!");
		}

		// test exception - crossing the boundary
		try {
			// check bottom boundary
			robot.place(new Position(0, 0, Orientation.SOUTH));
			robot.moveForward();
			fail("Expected an InvalidMovementException to be thrown");
		} catch (InvalidMovementException e) {
			assert e.getMessage().equals("InvalidMovementException: Moving forward will result in death!");
		}

		try {
			// check left boundary
			robot.place(new Position(0, 0, Orientation.WEST));
			robot.moveForward();
			fail("Expected an InvalidMovementException to be thrown");
		} catch (InvalidMovementException e) {
			assert e.getMessage().equals("InvalidMovementException: Moving forward will result in death!");
		}

		try {
			// check top boundary
			robot.place(new Position(4, 4, Orientation.NORTH));
			robot.moveForward();
			fail("Expected an InvalidMovementException to be thrown");
		} catch (InvalidMovementException e) {
			assert e.getMessage().equals("InvalidMovementException: Moving forward will result in death!");
		}

		try {
			// check right boundary
			robot.place(new Position(4, 4, Orientation.EAST));
			robot.moveForward();
			fail("Expected an InvalidMovementException to be thrown");
		} catch (InvalidMovementException e) {
			assert e.getMessage().equals("InvalidMovementException: Moving forward will result in death!");
		}
	}

	@Test
	public void testTurnRight() {
		try {
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
		} catch (InvalidMovementException e) {
			fail("Unexpected error!");
		}
	}

	@Test
	public void testTurnLeft() {
		try {
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
		} catch (InvalidMovementException e) {
			fail("Unexpected error!");
		}

	}

	@Test
	public void testReportStatus() {
		try {
			assert robot.reportStatus().equals("WALL-E says: \"I am at (0, 0) facing NORTH.\"");

			Position newPosition = new Position(2, 1, Orientation.EAST);
			robot.place(newPosition);

			assert robot.reportStatus().equals("WALL-E says: \"I am at (2, 1) facing EAST.\"");
		} catch (InvalidMovementException e) {
			fail("Unexpected error!");
		}

	}
}
