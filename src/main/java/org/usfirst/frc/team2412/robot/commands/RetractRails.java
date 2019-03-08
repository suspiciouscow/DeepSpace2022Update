package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.RobotMap;

public class RetractRails extends CommandBase {
	public RetractRails() {
		requires(climbPneumatics);
	}

	public void execute() {
		climbPneumatics.RetractRails();
		RobotMap.CLIMB_MODE = false;
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
