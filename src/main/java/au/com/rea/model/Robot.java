package au.com.rea.model;

/**
 * 
 * @author Tony Wang
 *
 */
public interface Robot {
	public enum RobotDirection {NORTH, SOUTH, EAST, WEST}
	public void place(int x, int y, RobotDirection robotDirection);
	public void moveForward();
	public void turnRight();
	public void turnLeft();
	public void reportStatus();
}
