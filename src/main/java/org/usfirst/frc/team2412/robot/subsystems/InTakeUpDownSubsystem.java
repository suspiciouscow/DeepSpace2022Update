package org.usfirst.frc.team2412.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class InTakeUpDownSubsystem extends PIDSubsystem {

	// PID conversion and unit values
	// private double encoderNinetyDegreesRatio = 10; // This many encoder units = intake rotating by 90 degrees (a quarter revolution)
	// private double encoderOneDegreeRatio = encoderNinetyDegreesRatio / 90; // This many encoder units = intake rotating by 1 degree.
	// 													 // Harder to measure experimentally, but more convenient for setpoint values.
	public static final double MIN_SPEED = -0.7; // Min motor speed - used to restrict how fast the motor turns.
	public static final double MAX_SPEED = 0.7; // Max motor speed - used for default KP calculations.
	public static final double MAX_ERROR = 100; // Max angle error in degrees - used for default KP calculations.
	// // Default PID values
	private static final double DEFAULT_KP = MAX_SPEED / MAX_ERROR;
	private static final double DEFAULT_KI = 0.0;
	private static final double DEFAULT_KD = 0.0;
	
	// // Encoder for measuring angle (we may use a potentiometer instead).
	// private Encoder angleEncoder;
	// private int encoderChannelA = 9;
	// private int encoderChannelB = 10;
	
	// private DigitalInput limitSwitchUp = RobotMap.limitSwitchUp;
	// private DigitalInput limitSwitchDown = RobotMap.limitSwitchDown;
	// private WPI_VictorSPX armMotor1 = RobotMap.armMotor1;
	
	public InTakeUpDownSubsystem() {
		this(DEFAULT_KP, DEFAULT_KI, DEFAULT_KD);
	}

	public InTakeUpDownSubsystem(double KP, double KI, double KD) {
		super(KP, KI, KD);
		// angleEncoder = new Encoder(encoderChannelA, encoderChannelB);
	}
	
	@Override
	protected void initDefaultCommand() {

	}

	public void InTakeUp() {
		// armMotor1.set(0.5);
	}

	public void InTakeDown() {
		// armMotor1.set(-0.5);
	}

	public void InTakeStop() {
		// armMotor1.set(0.0);
	}

	public void InTakeAxisRotate(Joystick stick, int axis) {
		// armMotor1.set(stick.getRawAxis(axis));
	}

	public boolean limitSwitchUp() {
		// return limitSwitchUp.get();
		return false;
	}

	public boolean limitSwitchDown() {
		// return limitSwitchDown.get();
		return false;
	}

	@Override
	public double returnPIDInput() {
		// return angleEncoder.getDistance() / encoderOneDegreeRatio;
		return 0;
	}

	@Override
	public void usePIDOutput(double speed) {
		// armMotor1.set(speed);
	}
}
