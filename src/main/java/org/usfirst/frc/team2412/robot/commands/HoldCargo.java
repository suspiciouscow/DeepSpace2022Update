package org.usfirst.frc.team2412.robot.commands;

public class HoldCargo extends CommandBase2412 {
	public HoldCargo() {
		requires(inTakeCargo);
	}

	public void execute() {
		inTakeCargo.HoldCargo();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
