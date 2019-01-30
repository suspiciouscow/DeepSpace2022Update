package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.*;
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
		System.out.println("released");
		// return oi.buttonClimbUp.get();
		return false;
	}

	@Override
	protected void end() {
		climbLift.ClimbLiftStop();
	}
}
