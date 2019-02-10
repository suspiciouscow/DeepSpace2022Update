package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.Robot;

public class GoToLevel extends CommandBase {

	public int level;

	public GoToLevel(int level) {
		this.level = level;
		requires(liftSubsystem);
	}

	protected boolean isFinished() {
		return true;
	}

	protected void execute() {
		if (Robot.m_oi.coDriver.getRawButton(3)) {
			liftSubsystem.goToInch(27.5 + (level - 1) * 28);
		} else {
			liftSubsystem.goToInch(19 + (level - 1) * 28);
		}
	}
}
