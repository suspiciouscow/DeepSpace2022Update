package org.usfirst.frc.team2412.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc.team2412.robot.RobotMap;
import org.usfirst.frc.team2412.robot.commands.LiftBottomReset;
import org.usfirst.frc.team2412.robot.commands.LiftTopReset;

public class Robot extends TimedRobot {

	OI oi = new OI();

	LiftBottomReset liftBottomReset = new LiftBottomReset();
	boolean liftBottomResetHeld = false;
	LiftTopReset liftTopReset = new LiftTopReset();
	boolean liftTopResetHeld = false;

	int counter = 0;

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		if (counter++ % 50 == 0) {
			System.out.println("Hello, world!");
		}

		if (RobotMap.liftBottomSwitch.get() && !liftBottomResetHeld) {
			liftBottomReset.execute();
			liftBottomResetHeld = true;
		} else if (!RobotMap.liftBottomSwitch.get()) {
			liftBottomResetHeld = false;
		}

		if (RobotMap.liftTopSwitch.get() && !liftTopResetHeld) {
			liftTopReset.execute();
			liftTopResetHeld = true;
		} else if (!RobotMap.liftTopSwitch.get()) {
			liftTopResetHeld = false;
		}
	}

}
