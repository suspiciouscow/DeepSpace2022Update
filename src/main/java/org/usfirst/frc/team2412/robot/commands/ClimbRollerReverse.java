package org.usfirst.frc.team2412.robot.commands;

public class ClimbRollerReverse extends CommandBase2412 {

	public ClimbRollerReverse() {
		requires(climbRoller);
	}

	public void execute() {
		climbRoller.ClimbRollerReverese();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		climbRoller.ClimbRollerStop();
	}
}