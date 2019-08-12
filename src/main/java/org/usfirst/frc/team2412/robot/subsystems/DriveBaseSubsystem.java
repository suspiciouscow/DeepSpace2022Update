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
		// robotDrive.arcadeDrive(stick.getY(), Math.pow(-stick.getTwist() * 0.8, 3), true);
		robotDrive.arcadeDrive(((RobotMap.SAFE_MODE)?Math.min(Math.max(stick.getY(),-0.5), 0.5):0.7*stick.getY()),-1* ((RobotMap.SAFE_MODE)?Math.min(Math.max(((stick.getRawButton(6))?stick.getX():stick.getTwist()),-0.50), 0.5):stick.getTwist()*0.5), true);
	}
}