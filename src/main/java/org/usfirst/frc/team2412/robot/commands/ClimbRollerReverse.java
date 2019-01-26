package org.usfirst.frc.team2412.robot.commands;

public class ClimbRollerReverse extends CommandBase {

	public ClimbRollerReverse() {
		requires(climbRoller);
	}

	public void execute() {
		climbRoller.ClimbRollerReverese();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}