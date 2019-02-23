package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.OI;
import org.usfirst.frc.team2412.robot.Robot;
import org.usfirst.frc.team2412.robot.RobotMap;

public class ClimbLiftJoystick extends CommandBase {

	public ClimbLiftJoystick() {
		requires(climbLift);
	}

	public void execute() {
		// If we're not in climb mode and the climb up/down manual mode is selected, climb with the codriver joystick.
		if(!RobotMap.CLIMB_MODE && Robot.m_oi.getManualMode(OI.MANUAL_MODE.CLIMBUPDOWN)) {
			climbLift.ClimbLiftJoystick(Robot.m_oi.coDriver, Robot.m_oi.MANUAL_AXIS);
		} else if(RobotMap.CLIMB_MODE)
		System.out.println("Climb Joystick");
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
