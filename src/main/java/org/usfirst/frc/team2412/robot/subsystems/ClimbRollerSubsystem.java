package org.usfirst.frc.team2412.robot.subsystems;

import org.usfirst.frc.team2412.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimbRollerSubsystem extends Subsystem {

	//private WPI_TalonSRX climbRoller1 = RobotMap.climbRoller1;
	private VictorSP victorSP3 = RobotMap.victorSP3;
	
	@Override
	protected void initDefaultCommand() {
		// Ari is awesome

	}
	public void ClimbRollerForward() {
		double rollerSpeed = 0.5;
		//climbRoller1.set(0.5);
		victorSP3.set(rollerSpeed);
	}

	public void ClimbRollerReverese() {
		double rollerSpeed = -0.5;
		//climbRoller1.set(rollerSpeed);
		victorSP3.set(rollerSpeed);
	}
}
