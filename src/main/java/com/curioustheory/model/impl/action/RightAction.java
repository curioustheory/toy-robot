package com.curioustheory.model.impl.action;

import com.curioustheory.model.Actionable;
import com.curioustheory.model.Movable;
import com.curioustheory.model.Robot;
import com.curioustheory.util.RobotCommandUtil.CommandAction;

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
