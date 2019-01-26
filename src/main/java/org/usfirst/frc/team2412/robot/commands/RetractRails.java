package org.usfirst.frc.team2412.robot.commands;

public class RetractRails extends CommandBase {
	public RetractRails() {
		
	requires(ClimbPneumatics); }
	
	public void execute()
	{
		ClimbPneumatics.RetractRails();
	}
	@Override protected boolean isFinished()
	{
		return true;
	}
}
