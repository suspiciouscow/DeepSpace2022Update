package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.RobotMap;

public class LiftUp extends CommandBase2412 {

	public LiftUp() {
		addRequirements(liftSubsystem);
	}

	@Override
	public boolean isFinished() {
		return false;
	}

	@Override
	public void execute() {
		if (RobotMap.DEBUG_MODE) {
			System.out.println("Lift up.");
		}
		liftSubsystem.liftUp();
	}

	public void end() {
		liftSubsystem.liftStop();
	}
}
