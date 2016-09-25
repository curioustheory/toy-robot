package au.com.rea.model.impl.action;

import au.com.rea.exception.InvalidMovementException;
import au.com.rea.model.Actionable;
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
	public void action(Robot robot) throws InvalidMovementException {
		robot.moveForward();
	}

	@Override
	public CommandAction getAction() {
		return CommandAction.MOVE;
	}
}
