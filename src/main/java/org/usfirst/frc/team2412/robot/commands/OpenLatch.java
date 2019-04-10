package org.usfirst.frc.team2412.robot.commands;

public class OpenLatch extends CommandBase {
	public OpenLatch() {
		requires(latchPneumatics);
	}

	public void execute() {
		latchPneumatics.openLatch();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
