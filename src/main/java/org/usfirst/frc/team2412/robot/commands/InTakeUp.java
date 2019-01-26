package org.usfirst.frc.team2412.robot.commands;

public class InTakeUp extends CommandBase {
	public InTakeUp() {
		requires(inTakeUpDown);

	}

	public void execute() {
		inTakeUpDown.InTakeUp();
	}

	@Override
	protected boolean isFinished() {
		return inTakeUpDown.limitSwitchUp();
	}
}
