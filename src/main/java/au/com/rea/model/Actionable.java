package au.com.rea.model;

import au.com.rea.exception.InvalidMovementException;
import au.com.rea.util.RobotCommandUtil.CommandAction;

/**
 * An interface to allow the robot to take in actions 
 * 
 * @author Tony Wang
 *
 */
public interface Actionable {
	/**
	 * Calls the robot action according to the CommandAction type
	 * 
	 * @param robot
	 * @throws InvalidMovementException
	 */
	public void action(Robot robot) throws InvalidMovementException;
	
	/**
	 * Get the CommandAction type
	 * @return CommandAction
	 */
	public CommandAction getAction();
	
}
