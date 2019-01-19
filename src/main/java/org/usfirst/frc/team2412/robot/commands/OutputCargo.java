package org.usfirst.frc.team2412.robot.commands;

public class OutputCargo extends CommandBase {
	public OutputCargo()
	{ 
		requires(InTakeCargo);
		
		}
	public void execute()
	{ 
		InTakeCargo.OutputCargo();
		}
	@Override protected boolean isFinished() 
	{ 
		return true;
		}

}
