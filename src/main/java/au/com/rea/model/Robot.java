package au.com.rea.model;

/**
 * 
 * @author Tony Wang
 *
 */
public interface Robot {
	public void place(Position position);

	public void moveForward();

	public void turnRight();

	public void turnLeft();

	public void reportStatus();

	public int getId();

	public Position getPosition();
}
