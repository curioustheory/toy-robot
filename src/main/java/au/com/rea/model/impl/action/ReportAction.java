package au.com.rea.model.impl.action;

import au.com.rea.model.Actionable;
import au.com.rea.model.Robot;
import au.com.rea.util.RobotCommandUtil.CommandAction;

public class ReportAction implements Actionable {

	public ReportAction() {
		super();
	}

	@Override
	public void action(Robot robot) {
		robot.reportStatus();
	}
	
	@Override
	public CommandAction getAction() {
		return CommandAction.REPORT;
	}
}
