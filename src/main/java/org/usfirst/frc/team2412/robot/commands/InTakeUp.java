package org.usfirst.frc.team2412.robot.commands;

public class InTakeUp extends CommandBase {
	public InTakeUp() {
		requires(inTakeUpDown);
	}

	public void execute() {
		inTakeUpDown.InTakeUp();
	}

	public void end() {
		inTakeUpDown.InTakeStop();
	}

	@Override
	protected boolean isFinished() {
		return false;
		// return !inTakeUpDown.limitSwitchUp();
	}
}
