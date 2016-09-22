package au.com.rea.model.impl;

import au.com.rea.model.Position;
import au.com.rea.model.Position.Orientation;
import au.com.rea.model.Robot;

/**
 * 
 * @author Tony Wang
 *
 */
public class RobotImpl implements Robot {
	private int id = 0;
	private Position position = null;
	
	/**
	 * default constructor requires the position (x, y) coordinate and the
	 * orientation robot requires to have an identifier and a position
	 * 
	 * @param id
	 * @param position
	 */
	public RobotImpl(int id, Position position) {
		this.id = id;
		this.position = position;
	}

	@Override
	/**
	 * a setter for position object to update the position
	 * 
	 * @param position
	 */
	public void place(Position position) {
		this.position = position;
	}

	@Override
	/**
	 * moves the robot by one step
	 */
	public void moveForward() {
		switch (position.getOrientation()) {
		case NORTH:
			position.setY(position.getY() + 1);
			break;
		case EAST:
			position.setX(position.getX() + 1);
			break;
		case SOUTH:
			position.setY(position.getY() - 1);
			break;
		case WEST:
			position.setX(position.getX() - 1);
			break;
		}
	}

	@Override
	/**
	 * turn the robot by 90 degrees to the right
	 */
	public void turnRight() {
		position.setOrientation(Orientation.getInstance((position.getOrientation().getDegree() + 90) % 360));
	}

	@Override
	/**
	 * turn the robot by 90 degrees to the left
	 */
	public void turnLeft() {
		// add 360 to offset the negative value because of counter clockwise rotation
		position.setOrientation(Orientation.getInstance((position.getOrientation().getDegree() - 90 + 360) % 360));
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
