package org.usfirst.frc.team2412.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.math.controller.PIDController;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import org.usfirst.frc.team2412.robot.RobotMap;

public class InTakeUpDownSubsystem extends PIDSubsystem {

	// PID conversion and unit values
	// private double potentiometerAngleRange = 350; // This is the range of angles that the potentiometer can produce,
													// regardless of the actual angles intake will be at.
	// private double potentiometerAngleOffset = 0; // The angle offset to add to the potentiometer's angle value.

	public static final double MIN_SPEED = -0.7; // Min motor speed - used to restrict how fast the moto.r turns.
	public static final double MAX_SPEED = 0.7; // Max motor speed - used for default KP calculations.
	public static final double MAX_ERROR = 350; // Max angle error in degrees - used for default KP calculations.

	// Default PID values
	private static final double DEFAULT_KP = MAX_SPEED / MAX_ERROR;
	private static final double DEFAULT_KI = 0.0;
	private static final double DEFAULT_KD = 0.0;
	
	// Constructor need

	public static final PIDController controller;
	private static final double DEFAULT_KinitialPosition = 0;

	// Potentiometer for measuring angle
	// private AnalogPotentiometer potentiometer;
	// private int potentiometerID = 1;
	
	// private DigitalInput limitSwitchUp = RobotMap.limitSwitchUp;
	// private DigitalInput limitSwitchDown = RobotMap.limitSwitchDown;
	private WPI_VictorSPX armMotor1 = RobotMap.armMotor1;
	
	public InTakeUpDownSubsystem() {
		this(new PIDController(DEFAULT_KP, DEFAULT_KI, DEFAULT_KD), DEFAULT_KinitialPosition);
		
	}

	public InTakeUpDownSubsystem(PIDController controller, double initialPosition) {
		super(controller, initialPosition);
		// potentiometer = new AnalogPotentiometer(potentiometerID, potentiometerAngleRange, potentiometerAngleOffset);
	}

	public void InTakeUp() {
		armMotor1.set(0.5);
	}

	public void InTakeDown() {
		armMotor1.set(0.5);
	}

	public void InTakeStop() {
		armMotor1.set(0.0);
	}

	public void InTakeHold() {
		armMotor1.set(0.1);
	}

	public void InTakeAxisRotate(Joystick stick, int axis) {
		armMotor1.set(-stick.getRawAxis(axis));
	}

	public boolean limitSwitchUp() {
		return false;
		// return limitSwitchUp.get();
	}

	public boolean limitSwitchDown() {
		return false;
		// return limitSwitchDown.get();
	}

	public double returnPIDInput() {
		//return potentiometer.get();
		return 0;
	}

	public void usePIDOutput(double speed) {
		armMotor1.set(-speed);
	}

	public double getPIDresult() {
		//return getController().calculate(); // TO FIGURE OUT
		return controller.calculate(getMeasurement());
		// P * error + I * totalError + D * (error - prevError) + feedForward
	}

	@Override
	protected double getMeasurement() {
		return 0;
	}

	@Override 
	protected void useOutput(double d1, double d2) {
		return;
	}

	public PIDController getPIDController() {
		return controller;
	}

}
