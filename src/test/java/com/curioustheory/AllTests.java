package com.curioustheory;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.curioustheory.engine.RobotRuleEngineTest;
import com.curioustheory.model.impl.RobotImplTest;
import com.curioustheory.util.RobotCommandUtilTest;

@RunWith(Suite.class)
@SuiteClasses({ RobotImplTest.class, RobotCommandUtilTest.class, RobotRuleEngineTest.class })
public class AllTests {

}
