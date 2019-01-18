package org.usfirst.frc.team2412.robot.commands;

public class InTakeDown extends CommandBase {
	public InTakeDown()
	{ 
		requires(InTakeUpDown);
		
		}
	public void execute()
	{ 
		InTakeUpDown.InTakeDown();
		}
	@Override protected boolean isFinished() 
	{ 
		return true;
		}
}
