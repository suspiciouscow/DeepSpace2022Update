package org.usfirst.frc.team2412.robot.commands;

public class InTakeStop extends CommandBase {
	public InTakeStop() {
		requires(inTakeCargo);
	}

	public void execute() {
		inTakeCargo.InTakeStop();
	}
}