package org.usfirst.frc.team2412.robot.commands;

public class ClimbLiftReverse extends CommandBase {

	public ClimbLiftReverse() {
		requires(climbLift);
	}

	public void execute() {
		climbLift.ClimbLiftReverse();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		climbLift.ClimbLiftStop();
	}
}
