package org.usfirst.frc.team2412.robot.subsystems;

import org.usfirst.frc.team2412.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
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

	public boolean limitSwitchUp() {
		return limitSwitchUp.get();
	}

	public boolean limitSwitchDown() {
		return limitSwitchDown.get();
	}
}
