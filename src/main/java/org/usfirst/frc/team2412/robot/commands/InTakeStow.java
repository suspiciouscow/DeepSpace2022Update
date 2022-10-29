package org.usfirst.frc.team2412.robot.commands;

public class InTakeStow extends CommandBase2412 {
	public InTakeStow() {
		addRequirements(inTakeUpDown);
	}

	public void execute() {
		inTakeUpDown.InTakeHold();
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
