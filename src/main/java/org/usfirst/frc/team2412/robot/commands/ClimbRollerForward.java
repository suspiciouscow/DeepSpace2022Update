package org.usfirst.frc.team2412.robot.commands;

public class ClimbRollerForward extends CommandBase {

	public ClimbRollerForward() {
		requires(ClimbRoller);
	}

	public void execute() {
		ClimbRoller.ClimbRollerForward();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}