package com.curioustheory.model.impl.action;

import com.curioustheory.model.Actionable;
import com.curioustheory.model.Movable;
import com.curioustheory.model.Robot;
import com.curioustheory.util.RobotCommandUtil.CommandAction;

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
	public void action(Movable movable) {
		if (movable instanceof Robot) {
			Robot robot = (Robot) movable;
			System.out.println(robot.reportStatus());	
		}
	}
	
	@Override
	public CommandAction getAction() {
		return CommandAction.REPORT;
	}
}
