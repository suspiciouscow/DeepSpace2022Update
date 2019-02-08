package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.Robot;

public class GoToLevel1 extends CommandBase {

	public GoToLevel1() {
		requires(liftSubsystem);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void execute() {
		if (Robot.m_oi.coDriver.getRawButton(3)) {
			liftSubsystem.goToInch(27.5);
		} else {
			liftSubsystem.goToInch(19);
		}

	}
}
