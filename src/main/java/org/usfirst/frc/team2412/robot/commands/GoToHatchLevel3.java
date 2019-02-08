package org.usfirst.frc.team2412.robot.commands;

public class GoToHatchLevel3 extends CommandBase {

	public GoToHatchLevel3() {
		requires(liftSubsystem);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
	
	@Override
	protected void execute() {
		liftSubsystem.goToInch(75);
	}
}
