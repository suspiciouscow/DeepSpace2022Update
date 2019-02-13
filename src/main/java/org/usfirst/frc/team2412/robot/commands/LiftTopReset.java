package org.usfirst.frc.team2412.robot.commands;

public class LiftTopReset extends CommandBase {

	public LiftTopReset() {
		requires(liftSubsystem);
	}
	
	public void execute() {
		liftSubsystem.resetTop();
	}
	
	public boolean isFinished() {
		return true;
	}

}
