package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.RobotMap;

public class LiftDown extends CommandBase2412 {

	public LiftDown() {
		addRequirements(liftSubsystem);
	}

	@Override
	public boolean isFinished() {
		return false;
	}

	@Override
	public void execute() {
		if (RobotMap.DEBUG_MODE) {
			System.out.println("Lift down.");
		}
		liftSubsystem.liftDown();
	}

	public void end() {
		liftSubsystem.liftStop();
	}
}
