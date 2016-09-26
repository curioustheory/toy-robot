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
public class RightAction implements Actionable {

	/**
	 * Default constructor
	 */
	public RightAction() {
		super();
	}

	@Override
	public void action(Movable movable) {
		if (movable instanceof Robot) {
			Robot robot = (Robot) movable;
			robot.turnRight();	
		}
	}

	@Override
	public CommandAction getAction() {
		return CommandAction.RIGHT;
	}
}
