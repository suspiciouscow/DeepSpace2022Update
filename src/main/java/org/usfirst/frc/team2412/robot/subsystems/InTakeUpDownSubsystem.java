package org.usfirst.frc.team2412.robot.subsystems;

import org.usfirst.frc.team2412.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class InTakeUpDownSubsystem extends Subsystem {

	private WPI_TalonSRX armMotor1 = RobotMap.armMotor1;
	private DigitalInput limitSwitchUp = RobotMap.limitSwitchUp;
	private DigitalInput limitSwitchDown = RobotMap.limitSwitchDown;

	@Override
	protected void initDefaultCommand() {
		// Ari is Awesome!
		// The previous comment will NOT crash this computer

	}

	public void InTakeUp() {
		armMotor1.set(0.5);
	}

	public void InTakeDown() {
		armMotor1.set(-0.5);
	}
//Ari is the best!
//Tim is lying when he says adding comments won't help


		public boolean limitSwitchUp() {
		return limitSwitchUp.get();
		
	}
	public boolean limitSwitchDown() {
		return limitSwitchDown.get();
	}
}

