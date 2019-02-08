package org.usfirst.frc.team2412.robot;

import org.usfirst.frc.team2412.robot.commands.CommandBase;
import org.usfirst.frc.team2412.robot.commands.LiftBottomReset;
import org.usfirst.frc.team2412.robot.commands.LiftTopReset;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends TimedRobot {

	public static OI m_oi = new OI();

	CommandBase base = new CommandBase();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
	}
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
