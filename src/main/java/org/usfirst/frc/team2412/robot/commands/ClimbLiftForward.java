package org.usfirst.frc.team2412.robot.commands;

public class ClimbLiftForward extends CommandBase {

	public ClimbLiftForward() {
		requires(climbLift);
	}

	public void execute() {
		climbLift.ClimbLiftForward();
	}

	@Override
	protected boolean isFinished() {
		//return climbLift.ultraSoundRadar()>19;
	//This will stop when the ultrasoundradar when it gets to 19 inches.
		return climbLift.limitSwitchClimbForward();
	}
}
