package org.usfirst.frc.team2412.robot.commands;

public class InTakeUp extends CommandBase {
	public InTakeUp()
	{ 
		requires(InTakeUpDown);
		
		}
	public void execute()
	{ 
		InTakeUpDown.InTakeUp();
		}
	@Override protected boolean isFinished() 
	{ 
		return true;
		}
}
