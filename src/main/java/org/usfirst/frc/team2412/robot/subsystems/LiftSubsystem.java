package org.usfirst.frc.team2412.robot.subsystems;

import org.usfirst.frc.team2412.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;


public class LiftSubsystem extends Subsystem {

	TalonSRX[] liftMotors = RobotMap.liftMotors;	
	
	public LiftSubsystem() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	public void liftUp() {
		
	}
	
	public void liftDown() {
		
	}

}
