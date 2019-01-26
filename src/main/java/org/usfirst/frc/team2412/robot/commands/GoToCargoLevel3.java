package org.usfirst.frc.team2412.robot.commands;

public class GoToCargoLevel3 extends CommandBase{

	public GoToCargoLevel3() {
		requires(liftSubsystem);
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
	
	@Override
	protected void execute() {
		liftSubsystem.goToInch(83.5);
	}
}
