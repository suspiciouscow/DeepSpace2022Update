package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.Robot;

public class GoToLevel3 extends CommandBase {

	public GoToLevel3() {
		requires(liftSubsystem);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void execute() {
		if (Robot.oi.coDriver.getRawButton(3)) {
			liftSubsystem.goToInch(83.5);
		} else {
			liftSubsystem.goToInch(75);
		}

	}
}
