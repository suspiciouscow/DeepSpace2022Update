package org.usfirst.frc.team2412.robot.subsystems;

import org.usfirst.frc.team2412.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftSubsystem extends Subsystem {

	
	
	//As of right now lift has changed their design 4+ times, so... Idk what to do
	
	
	TalonSRX[] liftMotors = RobotMap.liftMotors; // Motors from RobotMap

	public LiftSubsystem() {

	}

	@Override
	protected void initDefaultCommand() {

	}

	public void liftUp() {
		for (TalonSRX motor : liftMotors) { // Turns each motor to 50% of its speed (hopefully upward)
			motor.set(ControlMode.PercentOutput, 0.5);
		}
	}

	public void liftDown() {
		for (TalonSRX motor : liftMotors) { // Turns each motor to 50% of its speed (hopefully downward)
			motor.set(ControlMode.PercentOutput, -0.5);
		}
	}

	//These will use a PID (loop? idk what exactly it is) to quickly get the lift to the best position
	
	public void hatch1() {

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
}
