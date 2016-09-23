package au.com.rea.model.impl;

import au.com.rea.exception.InvalidMovementException;
import au.com.rea.model.Position;
import au.com.rea.model.Position.Orientation;
import au.com.rea.model.Robot;
import au.com.rea.model.TerrainData;

/**
 * robot object that only has 1 move and 90 degree turn
 * 
 * @author Tony Wang
 *
 */
public class RobotImpl implements Robot {
	private final int STEP_SIZE = 1;
	private final int TURNING_DEGREE = 90;
	private final int CIRCLE = 360;
	private int id = 0;
	private Position position = null;
	private TerrainData terrainData = null;

	/**
	 * default constructor requires the position (x, y) coordinate and the
	 * orientation robot requires to have an identifier and a position
	 * 
	 * @param id
	 * @param position
	 */
	public RobotImpl(int id, TerrainData terrainData) {
		this.id = id;
		this.position = new Position();
		this.terrainData = terrainData;
	}

	private boolean isInBoundary(Position position) {
		return position.getX() < terrainData.getWidth() && position.getY() < terrainData.getHeight() && position.getX() > 0 && position.getY() > 0;
	}

	@Override
	/**
	 * a setter for position object to update the position
	 * 
	 * @param position
	 */
	public void place(Position position) throws InvalidMovementException {
		if (isInBoundary(position)) {
			this.position = position;
		} else {
			throw new InvalidMovementException("InvalidMovementException: Moving forward will result in death!");
		}
	}

	@Override
	/**
	 * moves the robot by one step
	 */
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
	/**
	 * turn the robot by 90 degrees to the right
	 */
	public void turnRight() {
		position.setOrientation(Orientation.getInstance((position.getOrientation().getDegree() + TURNING_DEGREE) % CIRCLE));
	}

	@Override
	/**
	 * turn the robot by 90 degrees to the left
	 */
	public void turnLeft() {
		// add 360 to offset the negative value because of counter clockwise
		// rotation
		position.setOrientation(Orientation.getInstance((position.getOrientation().getDegree() - TURNING_DEGREE + CIRCLE) % CIRCLE));
	}

	@Override
	/**
	 * returns a string that indicate the position
	 * 
	 * @returns String
	 */
	public String reportStatus() {
		return "WALL-E says: \"I am at (" + position.getX() + ", " + position.getY() + ") facing " + position.getOrientation() + ".\"";
	}

	@Override
	/**
	 * get the robot id
	 */
	public int getId() {
		return id;
	}

	@Override
	/**
	 * return the position object
	 * 
	 * @return Position
	 */
	public Position getPosition() {
		return position;
	}
}
