package org.usfirst.frc.team2412.robot.subsystems;

import org.usfirst.frc.team2412.robot.RobotMap;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftSubsystem extends Subsystem {

	// other vars that are useful

	double inchOffset = 19; // this is the offset for the lift, as it doesnt go lower than the top hatch,
							// and this makes the robot go to x inches above the ground

	double topLimit = 130; // this will prevent the robot from going too high

	double encoderOffset = 0;

	// inches
	double outputGearRadius = 0.75;
	double outputGearCircumference = outputGearRadius * 2 * Math.PI;
	double pullyRatio = 1; // one inch on string moves the lift up x inches

	// rotations
	double gearboxRatio = 9.52; // how many motor rotations are one output rotation

	double motorRotationsToInches = outputGearCircumference * pullyRatio / gearboxRatio;

	CANSparkMax liftMotorLeader = RobotMap.liftMotors[0]; // Motors from RobotMap
	CANPIDController PIDController = liftMotorLeader.getPIDController();
	CANEncoder motorEncoder = liftMotorLeader.getEncoder();

	double P = 0.11; //.11
	double P_safe = 0.0155;
	double I = 0;
	double D = 0;

	double lastSetpoint = 0;

	public LiftSubsystem() {
		PIDController.setP((RobotMap.SAFE_MODE)?P_safe:P);
		PIDController.setI(I);
		PIDController.setD(D);
		PIDController.setOutputRange(-1d/((RobotMap.SAFE_MODE)?2d:1d), 1d/((RobotMap.SAFE_MODE)?2d:1d));
		resetBottom();
		if (RobotMap.DEBUG_MODE) {
			System.out.println(encoderOffset);
			System.out.println(getPosition() + encoderOffset);
		}
	}

	@Override
	protected void initDefaultCommand() {
		
	}

	public double getRotationsFromInch(double inches) {
		return inches / motorRotationsToInches;
	}

	public double getPosition() {
		return motorEncoder.getPosition();
	}

	public double getError() {
		return lastSetpoint - getPosition();
	}

	private void setReference(double setpoint, ControlType type) {
		PIDController.setReference(setpoint, type);
		lastSetpoint = setpoint;
	}

	public void liftUp() {
		System.out.println(getPosition() + encoderOffset);
		if (getPosition() + encoderOffset > topLimit) {
			liftMotorLeader.set(0);
			resetTop();
			if (RobotMap.DEBUG_MODE) {
				System.out.println("Top of lift reached; stopping...");
			}
			return;
		}
		liftMotorLeader.set(0.5);
		System.out.println("Lifted Up");
	}

	public void liftDown() {
		System.out.println(getPosition() + encoderOffset);
		if (getPosition() + encoderOffset < 1) {
			liftMotorLeader.set(0);
			resetBottom();
			if (RobotMap.DEBUG_MODE) {
				System.out.println("Bottom of lift reached; stopping...");
			}
			return;
		}
		liftMotorLeader.set(-0.5);
		System.out.println("Lifted Down");
	}

	public void liftStop() {
		liftMotorLeader.set(0.0);
	}

	public void goToInch(double inches) {
		if (RobotMap.DEBUG_MODE) {
			System.out.println("Lift is going to " + inches + " inches from the ground.");
		}
		setReference(getRotationsFromInch(inches - inchOffset) + encoderOffset, ControlType.kPosition);
	}

	public void resetBottom() {
		encoderOffset = -getPosition();
		// setReference(encoderOffset, ControlType.kPosition);
	}

	public void resetTop() {
		encoderOffset = topLimit - getPosition();
		// setReference(topLimit - encoderOffset, ControlType.kPosition);
	}

	public double getInches() {
		return inchOffset * motorRotationsToInches * (getPosition() + encoderOffset);
	}

	public void liftAxisPID(double axisVal, double min, double max, double deadzone, boolean map) {
		if (map) {
			double mappedVal = map(axisVal, min, max, 0, topLimit);
			setReference(mappedVal, ControlType.kPosition);
		} else {
			if (axisVal > (min + max + deadzone / 2) || axisVal < (min + max - deadzone / 2)) {
				liftMotorLeader.set(map(axisVal,min,max,-0.5,0.5));
			}
		}
	}

	public void liftAxis(double axisVal) {
		liftMotorLeader.set(axisVal);
	}

	public double map(double value, double min, double max, double newMin, double newMax) {
		return ((value - min) / (max - min)) * (topLimit - newMin) + newMin;
	}
}
