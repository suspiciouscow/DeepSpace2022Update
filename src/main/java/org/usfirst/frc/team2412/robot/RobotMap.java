/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2412.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;

	public static int[] driveBaseMotorIDs = new int[] {
		0, 1, 2, 3
	};

	public static CANSparkMax[] driveBaseMotors = new CANSparkMax[] {
		new CANSparkMax(driveBaseMotorIDs[0], MotorType.kBrushless),
		new CANSparkMax(driveBaseMotorIDs[1], MotorType.kBrushless),
		new CANSparkMax(driveBaseMotorIDs[2], MotorType.kBrushless),
		new CANSparkMax(driveBaseMotorIDs[3], MotorType.kBrushless)
	};

	public static SpeedControllerGroup leftSide = new SpeedControllerGroup(driveBaseMotors[0], driveBaseMotors[1]);
	public static SpeedControllerGroup rightSide = new SpeedControllerGroup(driveBaseMotors[2], driveBaseMotors[3]);

	public static DifferentialDrive drive = new DifferentialDrive(leftSide, rightSide);
	
	public static int shifterID = 6;
	public static int shifterIDReverse = 2;
	
	public static DoubleSolenoid shifter = new DoubleSolenoid(shifterID, shifterIDReverse);
}

