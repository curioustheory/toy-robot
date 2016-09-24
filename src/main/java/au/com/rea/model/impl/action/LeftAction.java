package au.com.rea.model.impl.action;

import au.com.rea.model.Actionable;
import au.com.rea.model.Robot;
import au.com.rea.util.RobotCommandUtil.CommandAction;

public class LeftAction implements Actionable {

	public LeftAction() {
		super();
	}
	
	@Override
	public void action(Robot robot) {
		robot.turnLeft();
	}

	@Override
	public CommandAction getAction() {
		return CommandAction.LEFT;
	}
}
