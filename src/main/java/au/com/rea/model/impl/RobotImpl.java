package au.com.rea.model.impl;

import au.com.rea.model.Position;
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
	 * default constructor requires the position (x, y) coordinate and the orientation
	 * robot requires to have an identifier and a position
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
	 * a setter for position object
	 * 
	 * @param position
	 */
	public void place(Position position) {
		this.position = position;
	}

	@Override
	public void moveForward() {
		//TODO
	}

	@Override
	public void turnRight() {
		//TODO		
	}

	@Override
	public void turnLeft() {
		//TODO
	}

	@Override
	public void reportStatus() {
		System.out.println("WALL-E says: \"I am at (" + position.getX() + ", " + position.getY() + ") facing " + position.getOrientation() + ".\"");
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	/**
	 * 
	 * @return Position
	 */
	public Position getPosition() {
		return position;
	}
}
