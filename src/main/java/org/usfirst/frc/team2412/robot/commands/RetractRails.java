package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.RobotMap;

public class RetractRails extends CommandBase2412 {
	public RetractRails() {
		addRequirements(climbPneumatics);
	}

	public void execute() {
		climbPneumatics.RetractRails();
		RobotMap.CLIMB_MODE = false;
	}

	@Override
	public boolean isFinished() {
		return true;
	}
}
