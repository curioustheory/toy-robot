package au.com.rea.model.impl;

import au.com.rea.model.Robot;

/**
 * 
 * @author Tony Wang
 *
 */
public class RobotImpl implements Robot {
	
	@Override
	public void place(int x, int y, RobotDirection robotDirection) {
		System.out.println("WALL-E says: ");
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveForward() {
		System.out.println("WALL-E says: \"moving forward.\"");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnRight() {
		System.out.println("WALL-E says: \"turning right.\"");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnLeft() {
		System.out.println("WALL-E says: \"turning left.\"");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reportStatus() {
		String status = "";
		// TODO Auto-generated method stub
		System.out.println("WALL-E says: \"" + status + " .\"");
	}

}
