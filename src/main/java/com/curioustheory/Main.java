package com.curioustheory;

import java.io.IOException;
import java.util.Scanner;

import com.curioustheory.engine.RobotRuleEngine;
import com.curioustheory.util.RobotLogger;

/**
 * This is the main class for the application to run
 * 
 * @author Tony Wang
 *
 */
public class Main {

	/**
	 * Default constructor
	 */
	public Main() {
		super();
	}

	/**
	 * Start the user input listening and rule processing
	 */
	public void start() {
		// setup logging
		try {
			RobotLogger.setup();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Problems with creating the log files");
		}

		boolean exit = true;
		Scanner scanner = new Scanner(System.in);
		printHeader();
		RobotRuleEngine engine = RobotRuleEngine.getInstance();
		// create a 5 x 5 table
		engine.initialise(5, 5);

		do {
			// listens for the next user input
			System.out.print("Your wish is my command: ");
			String input = scanner.nextLine();

			// terminate the application when the user enters QUIT
			if (input.equals("QUIT")) {
				exit = false;
				scanner.close();
				printTail();
			} else {
				// process the user input
				engine.process(input);
			}
			System.out.println();
		} while (exit);
	}

	/**
	 * Display a header and instruction
	 */
	private void printHeader() {
		System.out.println("|=======================================================================================================|");
		System.out.println("|                                                                                                       |");
		System.out.println("|                                                                                                       |");
		System.out.println("|                                                                                                       |");
		System.out.println("|            WELCOME TO THE TOY ROBOT SIMULATOR - A PLACE WHERE TOY ROBOT CAN FEEL SAFE                 |");
		System.out.println("|                                                                                                       |");
		System.out.println("|                                                                                                       |");
		System.out.println("|                                                                                                       |");
		System.out.println("|=======================================================================================================|");
		System.out.println("| INSTRUCTIONS:                                                                                         |");
		System.out.println("| 1. PLACE THE ROBOT ANYWHERE ON THE TABLE                                                              |");
		System.out.println("| 2. USE THE ROBOT COMMAND (CASE SENSITIVE)                                                             |");
		System.out.println("| 3. ???                                                                                                |");
		System.out.println("| 4. HAVE FUN!                                                                                          |");
		System.out.println("|-------------------------------------------------------------------------------------------------------|");
		System.out.println("| ROBOT COMMAND:                                                                                        |");
		System.out.println("| PLACE X,Y,F 	- Place the robot at (x, y) facing the direction NORTH, EAST, SOUTH or WEST.            |");
		System.out.println("| MOVE          - Move one step towards the direction the robot is facing.                              |");
		System.out.println("| LEFT          - Turn the robot to the left.                                                           |");
		System.out.println("| RIGHT         - Turn the robot to the right.                                                          |");
		System.out.println("| REPORT        - Report the position of the robot.                                                     |");
		System.out.println("| QUIT        	- Send the poor robot to the junk yard and quit the application.                        |");
		System.out.println("|-------------------------------------------------------------------------------------------------------|");
	}

	/**
	 * Display the tail when the program quit
	 */
	private void printTail() {
		System.out.println();
		System.out.println("WALL-E says: \"Was I a bad robot?\"");
		System.out.println("WALL-E says: \"Look at all the history we have had. I wrote it all down for you... (./" + RobotLogger.FILE_NAME + ")\"");
		System.out.println("WALL-E says: \"Good Bye Master...\"");
		System.out.println("|-------------------------------------------------------------------------------------------------------|");
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.start();
	}
}
