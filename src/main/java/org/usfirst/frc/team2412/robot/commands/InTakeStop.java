package org.usfirst.frc.team2412.robot.commands;

public class InTakeStop extends CommandBase2412 {
	public InTakeStop() {
		addRequirements(inTakeCargo);
	}

	public void execute() {
		inTakeCargo.InTakeStop();
	}
}