package au.com.rea.model.impl.action;

import au.com.rea.exception.InvalidMovementException;
import au.com.rea.model.Actionable;
import au.com.rea.model.Movable;
import au.com.rea.model.Robot;
import au.com.rea.util.RobotCommandUtil.CommandAction;

/**
 * Defines the instruction to move forward
 * 
 * @author Tony Wang
 *
 */
public class MoveAction implements Actionable {

	public MoveAction() {
		super();
	}

	@Override
	public void action(Movable movable) throws InvalidMovementException {
		if (movable instanceof Robot) {
			Robot robot = (Robot) movable;
			robot.moveForward();	
		}
	}

	@Override
	public CommandAction getAction() {
		return CommandAction.MOVE;
	}
}
