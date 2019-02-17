package org.usfirst.frc.team2412.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;

import org.usfirst.frc.team2412.robot.RobotMap;
import org.usfirst.frc.team2412.robot.commands.JoystickDriveCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveBaseSubsystem extends PIDSubsystem {
	private DifferentialDrive robotDrive = RobotMap.drive;

	// Diameter of the wheel, in cm.
	private static double WHEEL_DIAMETER = 6 * 2.54; // Convert from 6 inches to cm.

	// Circumference of the wheel.
	private static double wheelCircumference = WHEEL_DIAMETER * Math.PI;

	// Rotations to centimeters conversion.
	private static double rotationsToCentimeters = wheelCircumference; // 1 rotation of the wheel = robot travels one
																		// circumference (may need to change this).

	// Initial encoder values.
	private double startingValueLeft = 0;
	private double startingValueRight = 0;

	// Spark Max motors that we will use to read encoders from.
	private CANSparkMax leftMiddleMax = RobotMap.driveBaseMotors[1];
	private CANSparkMax rightMiddleMax = RobotMap.driveBaseMotors[4];

	// Spark Max encoder instances.
	private CANEncoder leftEncoder = leftMiddleMax.getEncoder();
	private CANEncoder rightEncoder = rightMiddleMax.getEncoder();

	// Angle to turn to.
	private double turnAngle = 0;

	// Default P value for turning.
	private static double DEFAULT_KP_TURNING = 2;
	private double currentKpTurning = DEFAULT_KP_TURNING; // The default members are static because they stay the same
															// for all instances, the current PID value members aren't
															// because they can vary from instance to instance.
															// Note that this variable name uses camelCase because
															// it is not a constant.

	// Default PID values for driving.
	private static double DEFAULT_KP_DRIVING = 1 / (50 / wheelCircumference); // The maximum distance in wheel rotations
																				// will be 50 cm (because that's when
																				// this command will start), divided by
																				// the wheel's circumference.
	private static double DEFAULT_KI_DRIVING = 0;
	private static double DEFAULT_KD_DRIVING = 0;

	public DriveBaseSubsystem() {
		super(DEFAULT_KP_DRIVING, DEFAULT_KI_DRIVING, DEFAULT_KD_DRIVING);
	}

	@Override
	protected void initDefaultCommand() {
		// Drive with the joystick by default.
		setDefaultCommand(new JoystickDriveCommand());
	}

	public void drive(double y, double turn) {
		robotDrive.arcadeDrive(y, turn, true);
	}

	public void drive(Joystick stick) {
		robotDrive.arcadeDrive(stick.getY(), Math.pow(-stick.getTwist() * 0.8, 3), true);
	}

	// Methods for resetting and retrieving encoder values.
	public double getRawLeftEncoderValue() {
		return leftEncoder.getPosition();
	}

	public double getLeftEncoderValue() {
		return getRawLeftEncoderValue() - startingValueLeft;
	}

	public void resetLeftEncoder() {
		startingValueLeft = getRawLeftEncoderValue();
	}

	public double getRawRightEncoderValue() {
		return rightEncoder.getPosition();
	}

	public double getRightEncoderValue() {
		return getRawRightEncoderValue() - startingValueRight;
	}

	public void resetRightEncoder() {
		startingValueRight = getRawRightEncoderValue();
	}

	// Methods implemented for PIDSubsystem.
	@Override
	public double returnPIDInput() {
		return getRightEncoderValue();
	}

	@Override
	protected void usePIDOutput(double output) {
		// Turning will be added later.
		// double angleError = turnAngle - getAngle();
		// double turn = -currentKpTurning * angleError / 90;
		drive(-output, 0); // We might not have to negate the output...
	}

	public void setTurningKp(double currentKp) {
		this.currentKpTurning = currentKp;
	}
}