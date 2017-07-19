package com.curioustheory.model.impl.action;

import com.curioustheory.exception.InvalidMovementException;
import com.curioustheory.model.Actionable;
import com.curioustheory.model.Movable;
import com.curioustheory.model.Robot;
import com.curioustheory.util.RobotCommandUtil;

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
	public RobotCommandUtil.CommandAction getAction() {
		return RobotCommandUtil.CommandAction.MOVE;
	}
}
