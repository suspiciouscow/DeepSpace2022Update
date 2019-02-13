package org.usfirst.frc.team2412.robot.commands;

public class LiftUp extends CommandBase {

	public LiftUp() {
		requires(liftSubsystem);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void execute() {
		liftSubsystem.liftUp();
	}
}
