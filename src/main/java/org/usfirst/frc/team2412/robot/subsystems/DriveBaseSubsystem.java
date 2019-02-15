package org.usfirst.frc.team2412.robot.subsystems;

import org.usfirst.frc.team2412.robot.RobotMap;
import org.usfirst.frc.team2412.robot.commands.JoystickDriveCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveBaseSubsystem extends Subsystem {
	private DifferentialDrive robotDrive = RobotMap.drive;

	@Override
	protected void initDefaultCommand() {
		// Drive with the joystick by default.
		setDefaultCommand(new JoystickDriveCommand());
	}

	public void drive(double y, double turn) {
		robotDrive.arcadeDrive(y, turn, true);
	}

	public void drive(Joystick stick) {
		robotDrive.arcadeDrive(-stick.getY(), -stick.getRawAxis(4) * 0.8, true);
	}
}