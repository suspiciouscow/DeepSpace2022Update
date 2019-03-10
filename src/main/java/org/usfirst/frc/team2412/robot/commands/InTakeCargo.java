package org.usfirst.frc.team2412.robot.commands;

public class InTakeCargo extends CommandBase {
	public InTakeCargo() {
		requires(inTakeCargo);
	}

	public void execute() {
		inTakeCargo.InTakeCargo();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		inTakeCargo.HoldCargo();
	}
}
