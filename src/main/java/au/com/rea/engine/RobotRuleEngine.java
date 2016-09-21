package au.com.rea.engine;

/**
 * 
 * @author Tony Wang
 *
 */
public class RobotRuleEngine {
	private static RobotRuleEngine instance;
	
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
	
	// TODO: initialise robot with origin point, create table
	
}
