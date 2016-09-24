package au.com.rea.model.impl.action;

import au.com.rea.model.Actionable;
import au.com.rea.model.Robot;
import au.com.rea.util.RobotCommandUtil.CommandAction;

public class RightAction implements Actionable {

	public RightAction() {
		super();
	}

	@Override
	public void action(Robot robot) {
		robot.turnRight();
	}

	@Override
	public CommandAction getAction() {
		return CommandAction.RIGHT;
	}
}
