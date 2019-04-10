package org.usfirst.frc.team2412.robot.commands;

public class CloseLatch extends CommandBase {
	public CloseLatch() {
		requires(latchPneumatics);
	}

	public void execute() {
		latchPneumatics.closeLatch();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
