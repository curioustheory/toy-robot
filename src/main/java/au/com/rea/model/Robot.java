package au.com.rea.model;

import au.com.rea.exception.InvalidMovementException;

/**
 * 
 * @author Tony Wang
 *
 */
public interface Robot {
	public void place(Position position) throws InvalidMovementException;

	public void moveForward() throws InvalidMovementException;

	public void turnRight();

	public void turnLeft();

	public String reportStatus();

	public int getId();

	public Position getPosition();
}
