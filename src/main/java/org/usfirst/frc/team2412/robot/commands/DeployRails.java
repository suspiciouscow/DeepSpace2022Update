package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.RobotMap;

public class DeployRails extends CommandBase {
	public DeployRails() {
		requires(climbPneumatics);
	}

	public void execute() {
		climbPneumatics.DeployRails();
		System.out.println("Deploying rails...");
		RobotMap.CLIMB_MODE = true;
		System.out.println("Climb mode: " + RobotMap.CLIMB_MODE);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
