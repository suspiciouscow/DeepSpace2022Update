package org.usfirst.frc.team2412.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.DigitalOutput;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.VictorSP;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

public class RobotMap {

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;

	public static boolean DEBUG_MODE = true;

	// Motor Can IDS

	public static int[] driveBaseMotorIDs = new int[] { 0, 1, 2, 3, 4, 5 };

	public static int CargoMotorID1 = 4;
	public static int armMotorID1 = 5;

	public static int climbRollerID1 = 6;
	public static int climbLiftID1 = 7;
	public static int climbLiftID2 = 8;

	// Solenoids

	public static int shifterID = 1;
	public static int shifterIDReverse = 2;
	public static int climbUp = 3;
	public static int climbDown = 4;

	// DriveBase

	public static CANSparkMax[] driveBaseMotors = new CANSparkMax[] {
			new CANSparkMax(driveBaseMotorIDs[0], MotorType.kBrushless),
			new CANSparkMax(driveBaseMotorIDs[1], MotorType.kBrushless),
			new CANSparkMax(driveBaseMotorIDs[2], MotorType.kBrushless),
			new CANSparkMax(driveBaseMotorIDs[3], MotorType.kBrushless),
			new CANSparkMax(driveBaseMotorIDs[4], MotorType.kBrushless),
			new CANSparkMax(driveBaseMotorIDs[5], MotorType.kBrushless) };

	public static SpeedControllerGroup leftSide = new SpeedControllerGroup(driveBaseMotors[0], driveBaseMotors[1],
			driveBaseMotors[2]);
	public static SpeedControllerGroup rightSide = new SpeedControllerGroup(driveBaseMotors[3], driveBaseMotors[4],
			driveBaseMotors[5]);

	public static DifferentialDrive drive = new DifferentialDrive(leftSide, rightSide);

	public static DoubleSolenoid shifter = new DoubleSolenoid(shifterID, shifterIDReverse);

	// Cargo
	public static WPI_VictorSPX cargoMotor1 = new WPI_VictorSPX(CargoMotorID1);
	// Arm for the whole InTake system
	public static WPI_VictorSPX armMotor1 = new WPI_VictorSPX(armMotorID1);
	// climb

	public static DoubleSolenoid climbPneumatics = new DoubleSolenoid(climbUp, climbDown);

	/*
	 * public static int climbRollerID1 = 1; public static WPI_TalonSRX climbRoller1
	 * = new WPI_TalonSRX(climbRollerID1);
	 * 
	 * public static WPI_TalonSRX climbLift1 = new WPI_TalonSRX(climbLiftID1);
	 * 
	 * public static int climbLiftID2 = 2; public static WPI_TalonSRX climbLift2 =
	 * new WPI_TalonSRX(climbLiftID2);
	 */
	public static int victorSPID0 = 0;
	public static VictorSP victorSP1 = new VictorSP(0);

	public static int victorSPID1 = 1;
	public static VictorSP victorSP2 = new VictorSP(1);

	public static int victorID2 = 2;
	public static VictorSP victorSP3 = new VictorSP(2);

	public static WPI_TalonSRX climbLift2 = new WPI_TalonSRX(climbLiftID2);

	public static DigitalInput limitSwitchUp = new DigitalInput(0);
	public static DigitalInput limitSwitchDown = new DigitalInput(1);

	public static int ultraSoundRadarID1 = 1;
	public static MaxBotixSonar ultraSoundRadar = new MaxBotixSonar(ultraSoundRadarID1);
	public static int[] liftMotorIndexes = { 0, 1 };

	public static CANSparkMax[] liftMotors = { new CANSparkMax(liftMotorIndexes[0], MotorType.kBrushless),
			new CANSparkMax(liftMotorIndexes[1], MotorType.kBrushless) };

	public static DigitalInput liftBottomSwitch = new DigitalInput(2);
	public static DigitalInput liftTopSwitch = new DigitalInput(3);

	public static DoubleSolenoid brakeSolenoid = new DoubleSolenoid(1, 0);
	public static int limitSwitchID1 = 0;
	public static DigitalInput limitSwitch1 = new DigitalInput(4);

	public static int ledID1 = 5;
	public static DigitalOutput led1 = new DigitalOutput(ledID1);

	// We might need to change the UltraSound to a limit switch
	public static DigitalInput limitSwitchClimbForward = new DigitalInput(1);
	public static DigitalInput limitSwitchClimbReverse = new DigitalInput(2);
}
