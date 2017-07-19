package com.curioustheory.engine;

import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.curioustheory.model.Actionable;
import com.curioustheory.model.Robot;
import com.curioustheory.model.TerrainData;
import com.curioustheory.model.impl.RobotImpl;
import com.curioustheory.util.RobotCommandUtil;
import com.curioustheory.util.RobotCommandUtil.CommandAction;

/**
 * A singleton object that acts as the controller of the application that
 * processes and coordinate all events
 * 
 * @author Tony Wang
 *
 */
public class RobotRuleEngine {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static RobotRuleEngine instance;
	private TerrainData terrainData = null;
	private Robot robot = null;

	/**
	 * private constructor to prevent instantiation by other classes
	 */
	private RobotRuleEngine() {
		super();
	}

	/**
	 * 
	 * Returns a singleton object of only one engine
	 * 
	 * @return instance
	 */
	public static RobotRuleEngine getInstance() {
		if (instance == null) {
			instance = new RobotRuleEngine();
		}
		return instance;
	}

	/**
	 * Initialise the environment by creating the table and the robot
	 * 
	 * @param tableWidth
	 * @param tableHeight
	 */
	public void initialise(int tableWidth, int tableHeight) {
		LOGGER.log(Level.INFO, "Initialising engine");
		terrainData = new TerrainData(tableWidth, tableHeight);
		LOGGER.log(Level.INFO, "Creating table size: " + tableWidth + " x " + tableHeight);
		robot = new RobotImpl(1, terrainData);
		LOGGER.log(Level.INFO, "Creating robot at: " + robot.getPosition().toString());
	}

	/**
	 * 
	 * @param action
	 */
	public void process(String input) {
		try {
			// process the input commands
			LOGGER.log(Level.INFO, "Processing user input: [" + input + "]");
			Queue<Actionable> actionQueue = RobotCommandUtil.processCommandInput(input);

			while (!actionQueue.isEmpty()) {
				Actionable doSomething = actionQueue.poll();
				// filter out all command before the PLACE command is issued
				if (robot.isPlaced() || doSomething.getAction() == CommandAction.PLACE) {
					LOGGER.log(Level.INFO, "Processing Command: " + doSomething.getAction().toString());
					doSomething.action(robot);
				}
			}
		} catch (Exception e) {
			// logs exception when something goes wrong
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Get the Robot object
	 * 
	 * @return robot
	 */
	public Robot getRobot() {
		return robot;
	}

	/**
	 * Get the terrain data object
	 * 
	 * @return terrainData
	 */
	public TerrainData getTerrainData() {
		return terrainData;
	}
}
