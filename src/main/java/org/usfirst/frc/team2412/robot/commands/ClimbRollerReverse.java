package org.usfirst.frc.team2412.robot.commands;

public class ClimbRollerReverse extends CommandBase {

	public ClimbRollerReverse() {
		requires(ClimbRoller);
	}

	public void execute() {
		ClimbRoller.ClimbRollerReverese();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}