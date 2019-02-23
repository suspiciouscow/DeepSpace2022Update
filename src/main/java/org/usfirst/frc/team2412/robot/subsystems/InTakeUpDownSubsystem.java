package org.usfirst.frc.team2412.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import org.usfirst.frc.team2412.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class InTakeUpDownSubsystem extends Subsystem {

	private DigitalInput limitSwitchUp = RobotMap.limitSwitchUp;
	private DigitalInput limitSwitchDown = RobotMap.limitSwitchDown;
	private WPI_VictorSPX armMotor1 = RobotMap.armMotor1;

	@Override
	protected void initDefaultCommand() {

	}

	public void InTakeUp() {
		armMotor1.set(0.5);
	}

	public void InTakeDown() {
		armMotor1.set(-0.5);
	}

	public void InTakeStop() {
		armMotor1.set(0.0);
	}

	public void InTakeAxisRotate(Joystick stick, int axis) {
		armMotor1.set(stick.getRawAxis(axis));
	}

	public boolean limitSwitchUp() {
		return limitSwitchUp.get();
	}

	public boolean limitSwitchDown() {
		return limitSwitchDown.get();
	}
}
