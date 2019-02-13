package org.usfirst.frc.team2412.robot.commands;

public class LiftBottomReset extends CommandBase {

	public LiftBottomReset() {
		requires(liftSubsystem);
	}

	public void execute() {
		liftSubsystem.resetBottom();
	}

	public boolean isFinished() {
		return true;
	}

}
