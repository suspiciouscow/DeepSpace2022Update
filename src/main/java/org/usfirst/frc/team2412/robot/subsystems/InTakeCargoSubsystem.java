package org.usfirst.frc.team2412.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class InTakeCargoSubsystem extends Subsystem {

	// RESEARCH TALONSRX CAPABILITIES AND EDUCATE THE TEAM
	// private WPI_VictorSPX CargoMotor1 = RobotMap.cargoMotor1;

	@Override
	protected void initDefaultCommand() {
	}

	// CHANGE MOTOR SPEED TO CONSTANTS
	public void InTakeCargo() {
		// CargoMotor1.set(1);
	}

	public void OutputCargo() {
		// CargoMotor1.set(-1);
	}

	public void InTakeStop() {
		// CargoMotor1.set(0.0);
	}
	
	public void InTakeCargoAxis(Joystick stick, int axis) {
		// CargoMotor1.set(stick.getRawAxis(axis));
	}
}
