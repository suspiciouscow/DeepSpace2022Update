package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.Robot;

public class JoystickDriveCommand extends CommandBase {
	public JoystickDriveCommand() {
		requires(driveBase);
	}

	@Override
	protected void execute() {
		driveBase.drive(Robot.m_oi.stick);
	}
}