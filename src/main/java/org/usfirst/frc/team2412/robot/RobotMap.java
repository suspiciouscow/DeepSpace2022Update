/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2412.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;

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
	
	//some buttons for lifting
	
	
	
	
	//pulling test 2
	
	public static int[] liftMotorIndexes = {0,1};
	
	public static CANSparkMax[] liftMotors = {
			new CANSparkMax(liftMotorIndexes[0], MotorType.kBrushless),
			new CANSparkMax(liftMotorIndexes[1], MotorType.kBrushless)
	};
	
	public static DigitalInput liftBottomSwitch = new DigitalInput(0);
	public static DigitalInput liftTopSwitch = new DigitalInput(1);
	
	public static DoubleSolenoid brakeSolenoid = new DoubleSolenoid(1, 0);
}
