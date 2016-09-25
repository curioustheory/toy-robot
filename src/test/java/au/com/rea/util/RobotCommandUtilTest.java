package au.com.rea.util;

import static org.junit.Assert.fail;

import java.util.Queue;

import org.junit.Test;

import au.com.rea.model.Actionable;
import au.com.rea.util.RobotCommandUtil.CommandAction;

public class RobotCommandUtilTest {

	@Test
	public void testNormalInput() {
		String input = "    MOVE  PLACE 0,2,NORTH RIGHT    MOVE REPORT   ";

		try {
			Queue<Actionable> queue = RobotCommandUtil.processCommandInput(input);
			assert queue.poll().getAction() == CommandAction.MOVE;
			assert queue.poll().getAction() == CommandAction.PLACE;
			assert queue.poll().getAction() == CommandAction.RIGHT;
			assert queue.poll().getAction() == CommandAction.MOVE;
			assert queue.poll().getAction() == CommandAction.REPORT;
		} catch (IllegalArgumentException e) {
			fail("Unexpected error!");
		}
	}

	@Test
	public void testNormalSingleInput() {
		String input = "REPORT";

		try {
			Queue<Actionable> queue = RobotCommandUtil.processCommandInput(input);
			assert queue.poll().getAction() == CommandAction.REPORT;
		} catch (IllegalArgumentException e) {
			fail("Unexpected error!");
		}
	}

	@Test
	public void testBadPlacePosition() {
		String input = "PLACE 0,2,huids RIGHT    MOVE REPORT   ";

		try {
			Queue<Actionable> queue = RobotCommandUtil.processCommandInput(input);
			assert queue.poll().getAction() == CommandAction.REPORT;
			fail("Expected an IllegalArgumentException to be thrown");
		} catch (IllegalArgumentException e) {
			assert e.getMessage().equals("Unknown command: PLACE 0,2,huids");
		}
	}

	@Test
	public void testBadSyntax() {
		String input = "0,2,NORTH RIGHT    MOVE REPORT   ";

		try {
			Queue<Actionable> queue = RobotCommandUtil.processCommandInput(input);
			assert queue.poll().getAction() == CommandAction.REPORT;
			fail("Expected an IllegalArgumentException to be thrown");
		} catch (IllegalArgumentException e) {
			assert e.getMessage().equals("Unknown command: 0,2,NORTH");
		}
	}
}
