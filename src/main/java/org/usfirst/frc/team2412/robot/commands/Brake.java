package org.usfirst.frc.team2412.robot.commands;

public class Brake extends CommandBase{

	public Brake() {
		// TODO Auto-generated constructor stub
		requires(liftSubsystem);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
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
