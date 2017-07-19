package com.curioustheory.engine;

import org.junit.Test;

public class RobotRuleEngineTest {
	
	@Test
	public void testEngineProcess() {
		RobotRuleEngine engine = RobotRuleEngine.getInstance();
		engine.initialise(5, 5);
		
		String example_a = "PLACE 0,0,NORTH MOVE REPORT";
		engine.process(example_a);
		assert engine.getRobot().getPosition().toString().equals("0,1,NORTH");
		
		String example_b = "PLACE 0,0,NORTH LEFT REPORT";
		engine.process(example_b);
		assert engine.getRobot().getPosition().toString().equals("0,0,WEST");
		
		String example_c = "PLACE 1,2,EAST MOVE MOVE LEFT MOVE REPORT";
		engine.process(example_c);
		assert engine.getRobot().getPosition().toString().equals("3,3,NORTH");
	}
	
	@Test
	public void testNoPlacementProcess() {
		RobotRuleEngine engine = RobotRuleEngine.getInstance();
		engine.initialise(5, 5);
		
		String example_a = "MOVE MOVE RIGHT MOVE REPORT";
		engine.process(example_a);
		assert engine.getRobot().getPosition().toString().equals("0,0,NORTH");
	}
}
