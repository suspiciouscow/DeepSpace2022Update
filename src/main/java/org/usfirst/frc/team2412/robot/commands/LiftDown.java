package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.RobotMap;

public class LiftDown extends CommandBase {

	public LiftDown() {
		requires(liftSubsystem);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void execute() {
		if (RobotMap.DEBUG_MODE) {
			System.out.println("Lift down.");
		}
		liftSubsystem.liftDown();
	}

	protected void end() {
		liftSubsystem.liftStop();
	}
}
