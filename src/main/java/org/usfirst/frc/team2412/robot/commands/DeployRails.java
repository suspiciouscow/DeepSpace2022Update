package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.RobotMap;

public class DeployRails extends CommandBase2412 {
	public DeployRails() {
		addRequirements(climbPneumatics);
	}

	public void execute() {
		climbPneumatics.DeployRails();
		RobotMap.CLIMB_MODE = true;
	}

	@Override
	public boolean isFinished() {
		return true;
	}
}
