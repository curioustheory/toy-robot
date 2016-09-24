package au.com.rea;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import au.com.rea.engine.RobotRuleEngineTest;
import au.com.rea.model.impl.RobotImplTest;
import au.com.rea.util.RobotCommandUtilTest;

@RunWith(Suite.class)
@SuiteClasses({ RobotImplTest.class, RobotCommandUtilTest.class, RobotRuleEngineTest.class })
public class AllTests {

}
