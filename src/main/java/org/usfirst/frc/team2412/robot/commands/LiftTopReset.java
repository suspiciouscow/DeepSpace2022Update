package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.RobotMap;

public class LiftTopReset extends CommandBase2412 {

	public LiftTopReset() {
		addRequirements(liftSubsystem);
	}

	public void execute() {
		if (RobotMap.DEBUG_MODE) {
			System.out.println("Lift has reset to the top.");
		}
		liftSubsystem.resetTop();
	}

	public boolean isFinished() {
		return true;
	}

}
