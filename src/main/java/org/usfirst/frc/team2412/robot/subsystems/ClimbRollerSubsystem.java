package org.usfirst.frc.team2412.robot.subsystems;

import org.usfirst.frc.team2412.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimbRollerSubsystem extends Subsystem {

	private WPI_TalonSRX climbRoller1 = RobotMap.climbRoller1;
	
	@Override
	protected void initDefaultCommand() {
		// Ari is awesome

	}
	public void ClimbRollerForward() {
		//int rollerSpeed = 0.5;
		climbRoller1.set(0.5);

	}

	public void ClimbRollerReverese() {
		climbRoller1.set(-0.5);
	}
	public void ClimbRollerStop() {
		climbRoller1.set(0.0);
		System.out.println("released");
	}

}
