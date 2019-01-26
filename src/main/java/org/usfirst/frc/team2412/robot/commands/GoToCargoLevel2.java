package org.usfirst.frc.team2412.robot.commands;

public class GoToCargoLevel2 extends CommandBase{

	public GoToCargoLevel2() {
		requires(liftSubsystem);
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
	
	@Override
	protected void execute() {
		liftSubsystem.cargo2();
	}
}
