package org.usfirst.frc.team2412.robot.commands;

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
		liftSubsystem.brake();
	}

	@Override
	protected void end() {
		liftSubsystem.brakeEnd();
	}
}
