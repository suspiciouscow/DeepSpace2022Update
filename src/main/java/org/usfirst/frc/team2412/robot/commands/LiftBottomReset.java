package org.usfirst.frc.team2412.robot.commands;

public class LiftBottomReset extends CommandBase {

	public LiftBottomReset() {
		// TODO Auto-generated constructor stub
		requires(liftSubsystem);
	}
	
	public void execute() {
		liftSubsystem.resetBottom();
	}
	
	public boolean isFinished() {
		return true;
	}

}
