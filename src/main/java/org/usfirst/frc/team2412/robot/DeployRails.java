package org.usfirst.frc.team2412.robot;

import org.usfirst.frc.team2412.robot.commands.CommandBase;

public class DeployRails extends CommandBase {
	public DeployRails() {
		
	requires(ClimbPneumatics); }
	
	public void execute()
	{
		ClimbPneumatics.DeployRails();
	}
	@Override protected boolean isFinished()
	{
		return true;
	}
}
