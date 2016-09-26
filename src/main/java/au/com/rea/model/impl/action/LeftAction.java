package au.com.rea.model.impl.action;

import au.com.rea.model.Actionable;
import au.com.rea.model.Movable;
import au.com.rea.model.Robot;
import au.com.rea.util.RobotCommandUtil.CommandAction;

/**
 * Defines the instruction to turn left
 * 
 * @author Tony Wang
 *
 */
public class LeftAction implements Actionable {

	/**
	 * Default constructor
	 */
	public LeftAction() {
		super();
	}
	
	@Override
	public void action(Movable movable) {
		if (movable instanceof Robot) {
			Robot robot = (Robot) movable;
			robot.turnLeft();	
		}
	}

	@Override
	public CommandAction getAction() {
		return CommandAction.LEFT;
	}
}
