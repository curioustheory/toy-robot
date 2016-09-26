package au.com.rea.model.impl.action;

import au.com.rea.exception.InvalidMovementException;
import au.com.rea.model.Actionable;
import au.com.rea.model.Movable;
import au.com.rea.model.Position;
import au.com.rea.model.Robot;
import au.com.rea.util.RobotCommandUtil.CommandAction;

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
