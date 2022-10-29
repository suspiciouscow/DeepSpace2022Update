package org.usfirst.frc.team2412.robot.commands;

public class OutputCargo extends CommandBase2412 {
	public OutputCargo() {
		addRequirements(inTakeCargo);
	}

	public void execute() {
		inTakeCargo.OutputCargo();
	}

	@Override
	public boolean isFinished() {
		return true;
	}
}
