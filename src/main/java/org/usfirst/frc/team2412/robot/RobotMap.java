/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2412.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

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
	
	//Cargo
	public static int CargoMotorID1 = 1;
	public static WPI_TalonSRX cargoMotor1 = new WPI_TalonSRX(CargoMotorID1);
	//Arm for the whole InTake system
	public static int armMotorID1 = 1;
	public static WPI_TalonSRX armMotor1 = new WPI_TalonSRX(armMotorID1);
	//climb
	public static int climbUp = 0;
	public static int climbDown = 1;
	public static DoubleSolenoid climbPneumatics = new DoubleSolenoid(climbUp, climbDown);	

	public static int climbRollerID1 = 1;
	public static WPI_TalonSRX climbRoller1 = new WPI_TalonSRX(climbRollerID1);

	public static int climbLiftID1 = 1;
	public static WPI_TalonSRX climbLift1 = new WPI_TalonSRX(climbLiftID1);

	public static int climbLiftID2 = 2;
	public static WPI_TalonSRX climbLift2 = new WPI_TalonSRX(climbLiftID2);
	
	public static int ultraSoundRadarID1 = 1;
	public static MaxBotixSonar ultraSoundRadar = new MaxBotixSonar (ultraSoundRadarID1);

	//We might need to change the UltraSound to a limit switch
	public static DigitalInput limitSwitchClimbForward = new DigitalInput(1);
	public static DigitalInput limitSwitchClimbReverse = new DigitalInput(2);
	}
	 
