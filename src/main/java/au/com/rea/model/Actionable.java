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
	 * Calls the action according to the CommandAction type
	 * 
	 * @param movable
	 * @throws InvalidMovementException
	 */
	public void action(Movable movable) throws InvalidMovementException;
	
	/**
	 * Get the CommandAction type
	 * @return CommandAction
	 */
	public CommandAction getAction();
	
}
