package org.usfirst.frc.team2412.robot.subsystems;

import org.usfirst.frc.team2412.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftSubsystem extends Subsystem {

	TalonSRX[] liftMotors = RobotMap.liftMotors;
//	public int startingLocation;

	public LiftSubsystem() {
//		startingLocation = liftMotors[0].getSelectedSensorPosition();

	}

	@Override
	protected void initDefaultCommand() {

	}

	public void liftUp() {
		for (TalonSRX motor : liftMotors) {
			motor.set(ControlMode.PercentOutput, 0.5);
		}
	}

	public void liftDown() {
		for (TalonSRX motor : liftMotors) {
			motor.set(ControlMode.PercentOutput, -0.5);
		}
	}

	public void hatch1() {
//		PID(12);
	}

	public void hatch2() {

	}

	public void hatch3() {

	}

	public void cargo1() {

	}

	public void cargo2() {

	}

	public void cargo3() {

	}

//	private void PID(int targetValue) {
//		int currentLocation = liftMotors[0].getSelectedSensorPosition();
//		
//		
//		while(currentLocation - startingLocation != targetValue) {
//			if()
//		}
//	}
}
