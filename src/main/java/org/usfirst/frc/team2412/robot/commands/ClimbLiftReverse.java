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
		return true;
	}
	/*@Override
	protected boolean isFinished() {
		return ClimbLift.limitSwitchClimbReverse();
	}
	*/
}
