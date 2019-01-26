package org.usfirst.frc.team2412.robot.commands;

public class GoToHatchLevel1 extends CommandBase {

	public GoToHatchLevel1() {
		requires(liftSubsystem);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
	
	@Override
	protected void execute() {
		liftSubsystem.goToInch(19);
	}
}
