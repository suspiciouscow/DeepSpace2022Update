package org.usfirst.frc.team2412.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

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
	public static boolean CLIMB_MODE = false; // If the codriver has pressed the rail deploy button or not
	
	public static PowerDistributionPanel powerPanel = new PowerDistributionPanel(11);

	// Motor Can IDS

	public static int[] driveBaseMotorIDs = new int[] {
		/*-----Front Of Robot-----*/
		/*Left side*//* Right Side*/
		 1,            			 6,
		 2,            			 5,
		 3,            			 4,
		/*------Back Of Robot-----*/
	 };

	public static int CargoMotorID1 = 9;
	public static int armMotorID1 = 10;

	// public static int climbLiftID1 = 7;
	// public static int climbLiftID2 = 8;

	// Solenoids

	public static int shifterID = 1;
	public static int climbUp = 0;
	public static int climbDown = 7;
	public static int latchIn = 2;
	public static int latchOut = 3;

	// DriveBase

	public static CANSparkMax[] driveBaseMotors = new CANSparkMax[] {
			new CANSparkMax(driveBaseMotorIDs[0], MotorType.kBrushless),
			new CANSparkMax(driveBaseMotorIDs[1], MotorType.kBrushless),
			new CANSparkMax(driveBaseMotorIDs[2], MotorType.kBrushless),
			new CANSparkMax(driveBaseMotorIDs[3], MotorType.kBrushless),
			new CANSparkMax(driveBaseMotorIDs[4], MotorType.kBrushless),
			new CANSparkMax(driveBaseMotorIDs[5], MotorType.kBrushless) };

	//Differential Drive
	public static SpeedControllerGroup leftSide = new SpeedControllerGroup(driveBaseMotors[0], driveBaseMotors[2],
			driveBaseMotors[4]);
	public static SpeedControllerGroup rightSide = new SpeedControllerGroup(driveBaseMotors[1], driveBaseMotors[3],
			driveBaseMotors[5]);

	public static DifferentialDrive drive = new DifferentialDrive(leftSide, rightSide);
	//Drive Shifters
	public static Solenoid shifter = new Solenoid(shifterID);

	// Cargo
	public static WPI_VictorSPX cargoMotor1 = new WPI_VictorSPX(CargoMotorID1);
	// Arm for the whole InTake system
	public static WPI_VictorSPX armMotor1 = new WPI_VictorSPX(armMotorID1);

	// climb
	public static DoubleSolenoid climbPneumatics = new DoubleSolenoid(climbUp, climbDown);
	public static DoubleSolenoid latchPneumatics = new DoubleSolenoid(latchIn, latchOut);

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

	public static DigitalInput limitSwitchUp = new DigitalInput(0);
	public static DigitalInput limitSwitchDown = new DigitalInput(1);

	// public static int ultraSoundRadarID1 = 1;
	// public static MaxBotixSonar ultraSoundRadar = new MaxBotixSonar(ultraSoundRadarID1);
	public static int[] liftMotorIndexes = { 7, 8};

	public static CANSparkMax[] liftMotors = { new CANSparkMax(liftMotorIndexes[0], MotorType.kBrushless),
			new CANSparkMax(liftMotorIndexes[1], MotorType.kBrushless) };

	public static DigitalInput liftBottomSwitch = new DigitalInput(2);
	public static DigitalInput liftTopSwitch = new DigitalInput(3);

	public static int limitSwitchID1 = 0;
	public static DigitalInput limitSwitch1 = new DigitalInput(4);

	public static int ledID1 = 5;
	public static DigitalOutput led1 = new DigitalOutput(ledID1);

	// We might need to change the UltraSound to a limit switch
	public static DigitalInput limitSwitchClimbForward = new DigitalInput(6);
	public static DigitalInput limitSwitchClimbReverse = new DigitalInput(7);

	public static int pistontube = 6;
	public static Solenoid pistonface = new Solenoid(pistontube);
}
