package org.usfirst.frc.team2412.robot.subsystems;

import org.usfirst.frc.team2412.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimbLiftSubsystem extends Subsystem {

	private WPI_TalonSRX climbLift1 = RobotMap.climbLift1;
	private WPI_TalonSRX climbLift2 = RobotMap.climbLift2;
	
	protected void initDefaultCommand() {
		// Ari is awesome

	}
	public void ClimbLiftForward() {
		double LiftSpeed = 0.5;
		climbLift1.set(LiftSpeed);
		climbLift2.set(LiftSpeed);
		
	}
	public void ClimbLiftReverse() {
		double LiftSpeed = -0.5;
		climbLift1.set(LiftSpeed);
		climbLift2.set(LiftSpeed);
	}
}