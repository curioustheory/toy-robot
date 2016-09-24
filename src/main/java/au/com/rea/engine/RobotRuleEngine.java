package au.com.rea.engine;

import java.util.LinkedList;
import java.util.Queue;

import org.apache.log4j.Logger;

import au.com.rea.model.Actionable;
import au.com.rea.model.Robot;
import au.com.rea.model.TerrainData;
import au.com.rea.model.impl.RobotImpl;
import au.com.rea.util.RobotCommandUtil;
import au.com.rea.util.RobotCommandUtil.CommandAction;

/**
 * 
 * @author Tony Wang
 *
 */
public class RobotRuleEngine {
	private static RobotRuleEngine instance;
	private Logger logger = Logger.getLogger(RobotRuleEngine.class);
	private TerrainData terrainData = null;
	private Robot robot = null;

	// private constructor to prevent instantiation by other classes
	private RobotRuleEngine() {
		super();
	}

	// allows singleton object, only one robot
	public static RobotRuleEngine getInstance() {
		if (instance == null) {
			instance = new RobotRuleEngine();
		}
		return instance;
	}

	// create the table and the robot
	public void initialise(int tableWidth, int tableHeight) {
		terrainData = new TerrainData(tableWidth, tableHeight);
		robot = new RobotImpl(1, terrainData);
	}

	public void process(String action) {
		try {
			Queue<Actionable> actionQueue = new LinkedList<>();
			RobotCommandUtil.validCommandAndCreateAction(actionQueue, action);

			while (!actionQueue.isEmpty()) {

				Actionable doSomething = actionQueue.poll();
				// filter out all command before the PLACE command is issued
				if (robot.isPlaced() || doSomething.getAction() == CommandAction.PLACE) {
					doSomething.action(robot);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	public Robot getRobot() {
		return robot;
	}

	public TerrainData getTerrainData() {
		return terrainData;
	}
}
