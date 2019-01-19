package org.usfirst.frc.team2412.robot.commands;

public class InTakeCargo extends CommandBase {
	public InTakeCargo()
	{ 
		requires(InTakeCargo);
		
		}
	public void execute()
	{ 
		InTakeCargo.InTakeCargo();
		}
	@Override protected boolean isFinished()
	{ 
		return true;
		}
}
