package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.RobotMap;

public class LiftBottomReset extends CommandBase {

	public LiftBottomReset() {
		requires(liftSubsystem);
	}

	public void execute() {
		if (RobotMap.DEBUG_MODE) {
			System.out.println("Lift has reset to the bottom.");
		}
		liftSubsystem.resetBottom();
	}

	public boolean isFinished() {
		return true;
	}

}
