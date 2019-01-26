package org.usfirst.frc.team2412.robot.commands;

public class GoToHatchLevel2 extends CommandBase {

	public GoToHatchLevel2() {
		requires(liftSubsystem);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
	
	@Override
	protected void execute() {
		liftSubsystem.hatch2();
	}
}
