package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.OI;
import org.usfirst.frc.team2412.robot.Robot;

public class ClimbLiftJoystick extends CommandBase2412 {

	public ClimbLiftJoystick() {
		addRequirements(climbLift);
	}

	public void execute() {
		climbLift.ClimbLiftJoystick(Robot.m_oi.coDriverArduinoButtons, OI.MANUAL_AXIS);
	}

	@Override
	public boolean isFinished() {
		return false;
		// return climbLift.limitSwitchClimbForward();
	}
	public void end() {
		climbLift.ClimbLiftStop();
	}
}
