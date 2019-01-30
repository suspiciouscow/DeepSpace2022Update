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
		System.out.println("foward"+System.currentTimeMillis()%1000);
		double LiftSpeed = 0.5;
		climbLift1.set(LiftSpeed);
		climbLift2.set(LiftSpeed);
		
	}
	public void ClimbLiftReverse() {
		System.out.println("reverse");
		double LiftSpeed = -0.5;
		climbLift1.set(LiftSpeed);
		climbLift2.set(LiftSpeed);
	}

	public void ClimbLiftStop() {
		System.out.println("Released");
		double LiftSpeed = 0.0;
		climbLift1.set(LiftSpeed);
		climbLift2.set(LiftSpeed);
	}
}