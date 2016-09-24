package au.com.rea.model.impl.action;

import au.com.rea.exception.InvalidMovementException;
import au.com.rea.model.Actionable;
import au.com.rea.model.Position;
import au.com.rea.model.Robot;
import au.com.rea.util.RobotCommandUtil.CommandAction;

public class PlaceAction implements Actionable {
	private Position position = null;

	public PlaceAction(Position position) {
		this.position = position;
	}

	@Override
	public void action(Robot robot) throws InvalidMovementException {
		robot.place(position);
	}
	
	@Override
	public CommandAction getAction() {
		return CommandAction.PLACE;
	}
}