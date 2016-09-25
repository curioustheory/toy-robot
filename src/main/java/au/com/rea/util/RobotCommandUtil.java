package au.com.rea.util;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

import au.com.rea.model.Actionable;
import au.com.rea.model.Position;
import au.com.rea.model.Position.Orientation;
import au.com.rea.model.impl.action.LeftAction;
import au.com.rea.model.impl.action.MoveAction;
import au.com.rea.model.impl.action.PlaceAction;
import au.com.rea.model.impl.action.ReportAction;
import au.com.rea.model.impl.action.RightAction;

/**
 * 
 * This RobotCommandUtil takes in a input string and validate the command and
 * then returns a queue with all the actionable objects
 * 
 * @author Tony Wang
 *
 */
public class RobotCommandUtil {
	private static Pattern patternWord = Pattern.compile("[A-Z]*");
	private static Pattern patternPosition = Pattern.compile("[0-9]*,[0-9]*,[A-Z]*");

	public enum CommandAction {
		PLACE, MOVE, LEFT, RIGHT, REPORT
	}

	public static Queue<Actionable> processCommandInput(String input) {
		Queue<Actionable> queue = new LinkedList<>();
		validCommandAndCreateAction(queue, input);
		return queue;
	}

	private static void validCommandAndCreateAction(Queue<Actionable> queue, String input) throws IllegalArgumentException {
		if (!input.isEmpty()) {
			if (input.startsWith(CommandAction.PLACE.name())) {
				String[] words = input.trim().split(" ", 3);
				if (patternWord.matcher(words[0].trim()).matches() && patternPosition.matcher(words[1].trim()).matches()) {
					queue.add(createAction(words[0], words[1]));
					if (words.length > 2) {
						validCommandAndCreateAction(queue, words[2].trim());
					}
				} else {
					throw new IllegalArgumentException("Unknown command: " + words[0] + " " + words[1]);
				}
			} else {
				String[] words = input.trim().split(" ", 2);
				if (patternWord.matcher(words[0].trim()).matches()) {
					queue.add(createAction(words[0], ""));
					if (words.length > 1) {
						validCommandAndCreateAction(queue, words[1].trim());
					}
				} else {
					throw new IllegalArgumentException("Unknown command: " + words[0]);
				}
			}
		}
	}

	private static Actionable createAction(String action, String args) throws IllegalArgumentException {
		switch (CommandAction.valueOf(action)) {
		case PLACE:
			// separate the coordinates
			String[] coord = args.split(",");
			Position position;
			try {
				int x = Integer.parseInt(coord[0]);
				int y = Integer.parseInt(coord[1]);
				Orientation o = Orientation.valueOf(coord[2]);
				position = new Position(x, y, o);
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException("Unknown command: " + coord[2]);
			}
			return new PlaceAction(position);
		case MOVE:
			return new MoveAction();
		case LEFT:
			return new LeftAction();
		case RIGHT:
			return new RightAction();
		case REPORT:
			return new ReportAction();
		}
		return null;
	}
}
