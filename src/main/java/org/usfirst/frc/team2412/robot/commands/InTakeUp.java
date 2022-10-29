package org.usfirst.frc.team2412.robot.commands;

public class InTakeUp extends CommandBase2412 {
	public InTakeUp() {
		addRequirements(inTakeUpDown);
	}

	public void execute() {
		inTakeUpDown.InTakeUp();
	}

	public void end() {
		inTakeUpDown.InTakeStop();
	}

	@Override
	public boolean isFinished() {
		return false;
		// return !inTakeUpDown.limitSwitchUp();
	}
}
