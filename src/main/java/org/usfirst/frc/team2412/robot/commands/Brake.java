package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.RobotMap;

public class Brake extends CommandBase {

	public Brake() {
		requires(liftSubsystem);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void execute() {
		if (RobotMap.DEBUG_MODE) {
			System.out.println("Braking the robot.");
		}
		liftSubsystem.brake();
	}

	@Override
	protected void end() {
		if (RobotMap.DEBUG_MODE) {
			System.out.println("Stopping the braking of the robot.");
		}
		liftSubsystem.brakeEnd();
	}
}
