package org.usfirst.frc.team2412.robot.commands;

public class InTakeCargo extends CommandBase2412 {
	public InTakeCargo() {
		addRequirements(inTakeCargo);
	}

	public void execute() {
		inTakeCargo.InTakeCargo();
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
