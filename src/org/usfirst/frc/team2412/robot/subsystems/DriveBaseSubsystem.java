package org.usfirst.frc.team2412.robot.subsystems;

import org.usfirst.frc.team2412.robot.RobotMap;


import edu.wpi.first.wpilibj.Joystick;	
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveBaseSubsystem {
	
	private DifferentialDrive robotDrive = RobotMap.drive;
	
	public void drive(Joystick stick) {
		robotDrive.arcadeDrive(stick.getY(), -stick.getTwist()*0.8, true);
	}
}
