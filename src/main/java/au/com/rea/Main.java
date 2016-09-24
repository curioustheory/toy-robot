package au.com.rea;

import java.util.Scanner;

import au.com.rea.engine.RobotRuleEngine;

/**
 * This is the main class for the application to run
 * 
 * @author Tony Wang
 *
 */
public class Main {
	
	public Main() {
		super();
	}
	
	public void start() {
		boolean exit = true;
		Scanner scanner = new Scanner(System.in);
		
		printHeader();
		RobotRuleEngine engine = RobotRuleEngine.getInstance();
		engine.initialise(5, 5);

		do {
			System.out.println("Your wish is my command: ");
			String action = scanner.nextLine();
			
			if(action.equals("QUIT")){
				exit = false;
				scanner.close();
				printTail();
			} else {
				engine.process(action);	
			}
			System.out.println();
		} while (exit);
	}
	
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
		System.out.println("| 2. USE THE ROBOT COMMAND (NOT CASE SENSITIVE)                                                         |");
		System.out.println("| 3. ???                                                                                                |");
		System.out.println("| 4. HAVE FUN!                                                                                          |");
		System.out.println("|-------------------------------------------------------------------------------------------------------|");
		System.out.println("| ROBOT COMMAND:                                                                                        |");
		System.out.println("| PLACE X,Y,F 	- Place the robot at (x, y) facing the direction NORTH, EAST, SOUTH or WEST.            |");
		System.out.println("| MOVE          - Move one step towards the direction the robot is facing.                              |");
		System.out.println("| LEFT          - Turn the robot to the left.                                                           |");
		System.out.println("| RIGHT         - Turn the robot to the right.                                                          |");
		System.out.println("| REPORT        - Report the position of the robot.                                                     |");
		System.out.println("| QUIT        	- Send the poor robot to the junk yard.                                                 |");
		System.out.println("|-------------------------------------------------------------------------------------------------------|");
	}
	
	private void printTail() {
		System.out.println("Was I a bad robot? Good Bye Master...");
		System.out.println("|-------------------------------------------------------------------------------------------------------|");
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.start();
	}
}
