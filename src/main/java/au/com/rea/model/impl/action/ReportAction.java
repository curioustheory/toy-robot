package au.com.rea.model.impl.action;

import au.com.rea.model.Actionable;
import au.com.rea.model.Robot;
import au.com.rea.util.RobotCommandUtil.CommandAction;

/**
 * Defines the instruction to report the status
 * 
 * @author Tony Wang
 *
 */
public class ReportAction implements Actionable {

	/**
	 * Default constructor
	 */
	public ReportAction() {
		super();
	}

	@Override
	public void action(Robot robot) {
		System.out.println(robot.reportStatus());
	}
	
	@Override
	public CommandAction getAction() {
		return CommandAction.REPORT;
	}
}
