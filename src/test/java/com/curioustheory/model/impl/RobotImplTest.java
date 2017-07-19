package com.curioustheory.model.impl;

import static org.junit.Assert.fail;

import com.curioustheory.exception.InvalidMovementException;
import com.curioustheory.model.Position;
import com.curioustheory.model.Robot;
import org.junit.Before;
import org.junit.Test;

import com.curioustheory.model.TerrainData;

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
			assert robot.getPosition().getOrientation() == Position.Orientation.NORTH;

			Position newPosition = new Position(0, 1, Position.Orientation.NORTH);
			robot.place(newPosition);

			assert robot.getPosition().getX() == 0;
			assert robot.getPosition().getY() == 1;
			assert robot.getPosition().getOrientation() == Position.Orientation.NORTH;

			newPosition = new Position(4, 2, Position.Orientation.SOUTH);
			robot.place(newPosition);

			assert robot.getPosition().getX() == 4;
			assert robot.getPosition().getY() == 2;
			assert robot.getPosition().getOrientation() == Position.Orientation.SOUTH;
		} catch (InvalidMovementException e) {
			fail("Unexpected error!");
		}

		// placing robot outside of range
		try {
			robot.place(new Position(8, -1, Position.Orientation.EAST));
			fail("Expected an InvalidMovementException to be thrown");
		} catch (InvalidMovementException e) {
			assert e.getMessage().equals("InvalidMovementException: Moving forward will result in death!");
		}
	}

	@Test
	public void testMoveForward() {
		try {
			// test east
			Position newPosition = new Position(3, 3, Position.Orientation.EAST);
			robot.place(newPosition);
			robot.moveForward();

			assert robot.getPosition().getX() == 4;
			assert robot.getPosition().getY() == 3;
			assert robot.getPosition().getOrientation() == Position.Orientation.EAST;

			// test north
			newPosition = new Position(3, 3, Position.Orientation.NORTH);
			robot.place(newPosition);
			robot.moveForward();

			assert robot.getPosition().getX() == 3;
			assert robot.getPosition().getY() == 4;
			assert robot.getPosition().getOrientation() == Position.Orientation.NORTH;

			// test west
			newPosition = new Position(3, 3, Position.Orientation.WEST);
			robot.place(newPosition);
			robot.moveForward();

			assert robot.getPosition().getX() == 2;
			assert robot.getPosition().getY() == 3;
			assert robot.getPosition().getOrientation() == Position.Orientation.WEST;

			// test south
			newPosition = new Position(3, 3, Position.Orientation.SOUTH);
			robot.place(newPosition);
			robot.moveForward();

			assert robot.getPosition().getX() == 3;
			assert robot.getPosition().getY() == 2;
			assert robot.getPosition().getOrientation() == Position.Orientation.SOUTH;
		} catch (InvalidMovementException e) {
			fail("Unexpected error!");
		}

		// test exception - crossing the boundary
		try {
			// check bottom boundary
			robot.place(new Position(0, 0, Position.Orientation.SOUTH));
			robot.moveForward();
			fail("Expected an InvalidMovementException to be thrown");
		} catch (InvalidMovementException e) {
			assert e.getMessage().equals("InvalidMovementException: Moving forward will result in death!");
		}

		try {
			// check left boundary
			robot.place(new Position(0, 0, Position.Orientation.WEST));
			robot.moveForward();
			fail("Expected an InvalidMovementException to be thrown");
		} catch (InvalidMovementException e) {
			assert e.getMessage().equals("InvalidMovementException: Moving forward will result in death!");
		}

		try {
			// check top boundary
			robot.place(new Position(4, 4, Position.Orientation.NORTH));
			robot.moveForward();
			fail("Expected an InvalidMovementException to be thrown");
		} catch (InvalidMovementException e) {
			assert e.getMessage().equals("InvalidMovementException: Moving forward will result in death!");
		}

		try {
			// check right boundary
			robot.place(new Position(4, 4, Position.Orientation.EAST));
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
			Position newPosition = new Position(3, 3, Position.Orientation.EAST);
			robot.place(newPosition);
			robot.turnRight();

			assert robot.getPosition().getX() == 3;
			assert robot.getPosition().getY() == 3;
			assert robot.getPosition().getOrientation() == Position.Orientation.SOUTH;

			// test north
			newPosition = new Position(3, 3, Position.Orientation.NORTH);
			robot.place(newPosition);
			robot.turnRight();

			assert robot.getPosition().getX() == 3;
			assert robot.getPosition().getY() == 3;
			assert robot.getPosition().getOrientation() == Position.Orientation.EAST;

			// test west
			newPosition = new Position(3, 3, Position.Orientation.WEST);
			robot.place(newPosition);
			robot.turnRight();

			assert robot.getPosition().getX() == 3;
			assert robot.getPosition().getY() == 3;
			assert robot.getPosition().getOrientation() == Position.Orientation.NORTH;

			// test south
			newPosition = new Position(3, 3, Position.Orientation.SOUTH);
			robot.place(newPosition);
			robot.turnRight();

			assert robot.getPosition().getX() == 3;
			assert robot.getPosition().getY() == 3;
			assert robot.getPosition().getOrientation() == Position.Orientation.WEST;
		} catch (InvalidMovementException e) {
			fail("Unexpected error!");
		}
	}

	@Test
	public void testTurnLeft() {
		try {
			// test east
			Position newPosition = new Position(3, 3, Position.Orientation.EAST);
			robot.place(newPosition);
			robot.turnLeft();

			assert robot.getPosition().getX() == 3;
			assert robot.getPosition().getY() == 3;
			assert robot.getPosition().getOrientation() == Position.Orientation.NORTH;

			// test north
			newPosition = new Position(3, 3, Position.Orientation.NORTH);
			robot.place(newPosition);
			robot.turnLeft();

			assert robot.getPosition().getX() == 3;
			assert robot.getPosition().getY() == 3;
			assert robot.getPosition().getOrientation() == Position.Orientation.WEST;

			// test west
			newPosition = new Position(3, 3, Position.Orientation.WEST);
			robot.place(newPosition);
			robot.turnLeft();

			assert robot.getPosition().getX() == 3;
			assert robot.getPosition().getY() == 3;
			assert robot.getPosition().getOrientation() == Position.Orientation.SOUTH;

			// test south
			newPosition = new Position(3, 3, Position.Orientation.SOUTH);
			robot.place(newPosition);
			robot.turnLeft();

			assert robot.getPosition().getX() == 3;
			assert robot.getPosition().getY() == 3;
			assert robot.getPosition().getOrientation() == Position.Orientation.EAST;
		} catch (InvalidMovementException e) {
			fail("Unexpected error!");
		}

	}

	@Test
	public void testReportStatus() {
		try {
			assert robot.reportStatus().equals("WALL-E says: \"I am at (0, 0) facing NORTH.\"");

			Position newPosition = new Position(2, 1, Position.Orientation.EAST);
			robot.place(newPosition);

			assert robot.reportStatus().equals("WALL-E says: \"I am at (2, 1) facing EAST.\"");
		} catch (InvalidMovementException e) {
			fail("Unexpected error!");
		}

	}
}
