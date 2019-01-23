package org.usfirst.frc.team2412.robot.subsystems;

import org.usfirst.frc.team2412.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class InTakeUpDownSubsystem extends Subsystem {

	private WPI_TalonSRX armMotor1 = RobotMap.armMotor1;
	@Override
	protected void initDefaultCommand() {
		//Ari is Awesome!
	
		
	}
	public void InTakeUp() {armMotor1.set(0.5);}
	public void InTakeDown() {armMotor1.set(-0.5);}
	
	
}
