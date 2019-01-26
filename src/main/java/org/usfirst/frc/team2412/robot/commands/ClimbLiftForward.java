package org.usfirst.frc.team2412.robot.commands;

public class ClimbLiftForward extends CommandBase {

	public ClimbLiftForward() {
		requires(climbLift);
	}

	public void execute() {
		climbLift.ClimbLiftReverse();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
