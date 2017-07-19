package com.curioustheory.model.impl.action;

import com.curioustheory.exception.InvalidMovementException;
import com.curioustheory.model.Actionable;
import com.curioustheory.model.Movable;
import com.curioustheory.model.Position;
import com.curioustheory.model.Robot;
import com.curioustheory.util.RobotCommandUtil.CommandAction;

/**
 * Defines the instruction to place the robot
 * @author Tony Wang
 *
 */
public class PlaceAction implements Actionable {
	private Position position = null;

	/**
	 * Default constructor that takes in a new position
	 * 
	 * @param position
	 */
	public PlaceAction(Position position) {
		this.position = position;
	}

	@Override
	public void action(Movable movable) throws InvalidMovementException {
		if (movable instanceof Robot) {
			Robot robot = (Robot) movable;
			robot.place(position);	
		}
	}
	
	@Override
	public CommandAction getAction() {
		return CommandAction.PLACE;
	}
}
