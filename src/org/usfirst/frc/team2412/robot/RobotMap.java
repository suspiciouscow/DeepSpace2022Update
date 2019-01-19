/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2412.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
 
public class RobotMap {
	
	public static int[] motorIDs = new int[] {
			0,
			1,
			2,
			3,
			4,
			5
	};
	public static WPI_TalonSRX[] talons = new WPI_TalonSRX[]{
			new WPI_TalonSRX(motorIDs[0]),
			new WPI_TalonSRX(motorIDs[1]),
			new WPI_TalonSRX(motorIDs[2]),
			new WPI_TalonSRX(motorIDs[3]),
			new WPI_TalonSRX(motorIDs[4]),
			new WPI_TalonSRX(motorIDs[5])
		};
	
	public static SpeedControllerGroup leftSide = new SpeedControllerGroup(talons[0], talons[2], talons[4]);
	public static SpeedControllerGroup rightSide = new SpeedControllerGroup(talons[1], talons[3], talons[5]);
	
	public static DifferentialDrive drive = new DifferentialDrive(leftSide, rightSide);
	public static Joystick stick = new Joystick(0);
}
