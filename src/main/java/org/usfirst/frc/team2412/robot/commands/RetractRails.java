package org.usfirst.frc.team2412.robot.commands;

public class RetractRails extends CommandBase {
	public RetractRails() {

		requires(climbPneumatics);
	}

	public void execute() {
		climbPneumatics.RetractRails();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
