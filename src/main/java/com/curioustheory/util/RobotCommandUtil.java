package com.curioustheory.util;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

import com.curioustheory.model.Actionable;
import com.curioustheory.model.Position;
import com.curioustheory.model.impl.action.LeftAction;
import com.curioustheory.model.impl.action.MoveAction;
import com.curioustheory.model.impl.action.PlaceAction;
import com.curioustheory.model.impl.action.ReportAction;
import com.curioustheory.model.impl.action.RightAction;

/**
 * 
 * This RobotCommandUtil takes in a input string and validate the command and
 * then returns a queue with all the actionable objects
 * 
 * @author Tony Wang
 *
 */
public class RobotCommandUtil {
	// checks the command patter that only takes in capital letters
	private static Pattern patternWord = Pattern.compile("[A-Z]*");
	// checks the position pattern that takes in a number folowed by a comma then another number then another comma then capital letters 
	private static Pattern patternPosition = Pattern.compile("[0-9]*,[0-9]*,[A-Z]*");

	/**
	 * CommandAction type that defines all available command for the robot
	 * 
	 * @author Tony Wang
	 *
	 */
	public enum CommandAction {
		PLACE, MOVE, LEFT, RIGHT, REPORT
	}

	/**
	 * Return a list of actionable commands that has been processed
	 * 
	 * @param input user commands
	 * @return queue
	 */
	public static Queue<Actionable> processCommandInput(String input) {
		Queue<Actionable> queue = new LinkedList<>();
		validCommandAndCreateAction(queue, input);
		return queue;
	}

	/**
	 * 
	 * The is a recursive string parser and validator to check if the input has the correct format and then add it to the queue 
	 * 
	 * @param queue
	 * @param input
	 * @throws IllegalArgumentException
	 */
	private static void validCommandAndCreateAction(Queue<Actionable> queue, String input) throws IllegalArgumentException {
		if (!input.isEmpty()) {
			// check PLACE command to take in additional argument
			if (input.startsWith(CommandAction.PLACE.name())) {
				// separate the input into 3 segments
				String[] words = input.trim().split(" ", 3);
				// check if the first segment is correct and the associated argument is correct
				if (patternWord.matcher(words[0].trim()).matches() && patternPosition.matcher(words[1].trim()).matches()) {
					queue.add(createAction(words[0], words[1]));
					if (words.length > 2) {
						// send the last segment to be validated again recursively
						validCommandAndCreateAction(queue, words[2].trim());
					}
				} else {
					throw new IllegalArgumentException("Unknown command: " + words[0] + " " + words[1]);
				}
			// check every other commands
			} else {
				// separate the input into 2 segments
				String[] words = input.trim().split(" ", 2);
				if (patternWord.matcher(words[0].trim()).matches()) {
					queue.add(createAction(words[0], ""));
					if (words.length > 1) {
						// send the last segment to be validated again recursively
						validCommandAndCreateAction(queue, words[1].trim());
					}
				} else {
					throw new IllegalArgumentException("Unknown command: " + words[0]);
				}
			}
		}
	}

	/**
	 * Checks the command and map it to an actionable object
	 * 
	 * @param action user action
	 * @param args additional argument for the action
	 * @return Actionable
	 * @throws IllegalArgumentException
	 */
	private static Actionable createAction(String action, String args) throws IllegalArgumentException {
		switch (CommandAction.valueOf(action)) {
		case PLACE:
			// separate the coordinates
			String[] coord = args.split(",");
			Position position;
			try {
				int x = Integer.parseInt(coord[0]);
				int y = Integer.parseInt(coord[1]);
				Position.Orientation o = Position.Orientation.valueOf(coord[2]);
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
