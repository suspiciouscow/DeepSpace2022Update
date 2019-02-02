package org.usfirst.frc.team2412.robot.commands;

public class ClimbLiftForward extends CommandBase {


	// OI oi = new OI();
	public ClimbLiftForward() {
		requires(climbLift);
	}

	public void execute() {
		climbLift.ClimbLiftForward();
		System.out.println("held");
	}

	@Override
	protected boolean isFinished() {
		double distance = climbLift.ultraSoundRadar();
		System.out.println(distance);
		return climbLift.ultraSoundRadar()>19;
	}

	@Override
	protected void end() {
		System.out.println("released");
		climbLift.ClimbLiftStop();
	//This will stop when the ultrasoundradar when it gets to 19 inches.
	}
}
