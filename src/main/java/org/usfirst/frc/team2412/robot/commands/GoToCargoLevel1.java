package org.usfirst.frc.team2412.robot.commands;

public class GoToCargoLevel1 extends CommandBase{

	public GoToCargoLevel1() {
		requires(liftSubsystem);
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
	
	@Override
	protected void execute() {
		liftSubsystem.cargo1();
	}
}
