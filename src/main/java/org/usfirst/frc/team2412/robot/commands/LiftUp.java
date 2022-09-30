package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.RobotMap;

public class LiftUp extends CommandBase2412 {

	public LiftUp() {
		requires(liftSubsystem);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void execute() {
		if (RobotMap.DEBUG_MODE) {
			System.out.println("Lift up.");
		}
		liftSubsystem.liftUp();
	}

	protected void end() {
		liftSubsystem.liftStop();
	}
}
