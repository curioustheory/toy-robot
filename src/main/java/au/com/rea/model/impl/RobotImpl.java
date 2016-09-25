package au.com.rea.model.impl;

import au.com.rea.exception.InvalidMovementException;
import au.com.rea.model.Position;
import au.com.rea.model.Position.Orientation;
import au.com.rea.model.Robot;
import au.com.rea.model.TerrainData;

/**
 * Robot object that only has step size of one move and 90 degree turn
 * 
 * @author Tony Wang
 *
 */
public class RobotImpl extends Robot {
	private final int STEP_SIZE = 1;
	private final int TURNING_DEGREE = 90;
	private final int CIRCLE = 360;

	/**
	 * Default constructor requires the position (x, y) coordinate and the
	 * orientation. Robot requires to have an identifier and the terrain data.
	 * A default position will be created at the origin (0, 0, NORTH)
	 * 
	 * @param id to identify the robot
	 * @param terrainData a terrain data so the robot knows their surrounding
	 */
	public RobotImpl(int id, TerrainData terrainData) {
		this.id = id;
		this.position = new Position();
		this.terrainData = terrainData;
	}

	/**
	 * Checks the terrain to see if the position is inside its boundary  
	 *  
	 * @param position defines the location and orientation of the robot
	 * @return boolean true if the position is inside the terrain boundary
	 */
	private boolean isInBoundary(Position position) {
		return position.getX() < terrainData.getWidth() && position.getY() < terrainData.getHeight() && position.getX() >= 0 && position.getY() >= 0;
	}

	@Override
	public void place(Position position) throws InvalidMovementException {
		// validate the position whether it is in bound
		if (isInBoundary(position)) {
			this.position = position;
			this.placed = true;
		} else {
			throw new InvalidMovementException("InvalidMovementException: Moving forward will result in death!");
		}
	}

	@Override
	public void moveForward() throws InvalidMovementException {
		Position newPosition = null;
		
		switch (position.getOrientation()) {
		case NORTH:
			newPosition = new Position(position.getX(), position.getY() + STEP_SIZE, Orientation.NORTH);
			break;
		case EAST:
			newPosition = new Position(position.getX() + STEP_SIZE, position.getY(), Orientation.EAST);
			break;
		case SOUTH:
			newPosition = new Position(position.getX(), position.getY() - STEP_SIZE, Orientation.SOUTH);
			break;
		case WEST:
			newPosition = new Position(position.getX() - STEP_SIZE, position.getY(), Orientation.WEST);
			break;
		}
		place(newPosition);
	}

	@Override
	public void turnRight() {
		// turn in a clockwise rotation by the degree amount
		position.setOrientation(Orientation.getInstance((position.getOrientation().getDegree() + TURNING_DEGREE) % CIRCLE));
	}

	@Override
	public void turnLeft() {
		// add 360 to offset the negative value because of counter clockwise rotation
		position.setOrientation(Orientation.getInstance((position.getOrientation().getDegree() - TURNING_DEGREE + CIRCLE) % CIRCLE));
	}

	@Override
	public String reportStatus() {
		return "WALL-E says: \"I am at (" + position.getX() + ", " + position.getY() + ") facing " + position.getOrientation() + ".\"";
	}
}
