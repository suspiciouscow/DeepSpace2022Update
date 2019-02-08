package org.usfirst.frc.team2412.robot.commands;

public class InTakeUp extends CommandBase {
	public InTakeUp() {
		requires(inTakeUpDown);

	}

	public void execute() {
		inTakeUpDown.InTakeUp();
		System.out.println("Alt f4");
	}
	public void end() {
	inTakeUpDown.InTakeStop();
}

	@Override
	protected boolean isFinished() {
		return !inTakeUpDown.limitSwitchUp();
	}
}
