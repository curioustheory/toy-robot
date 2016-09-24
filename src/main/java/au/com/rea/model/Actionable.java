package au.com.rea.model;

import au.com.rea.exception.InvalidMovementException;
import au.com.rea.util.RobotCommandUtil.CommandAction;

public interface Actionable {
	
	public void action(Robot robot) throws InvalidMovementException;
	public CommandAction getAction();
	
}
