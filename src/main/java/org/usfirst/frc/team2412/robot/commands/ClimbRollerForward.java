package org.usfirst.frc.team2412.robot.commands;

public class ClimbRollerForward extends CommandBase {

	public ClimbRollerForward() {
		requires(climbRoller);
	}

	public void execute() {
		climbRoller.ClimbRollerForward();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		climbRoller.ClimbRollerStop();
	}
}