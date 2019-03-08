package org.usfirst.frc.team2412.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimbRollerSubsystem extends Subsystem {

//	private VictorSP victorSP3 = RobotMap.victorSP3;

	@Override
	protected void initDefaultCommand() {

	}

	public void ClimbRollerForward() {
//		double rollerSpeed = 0.75;
		// climbRoller1.set(0.75);
//		victorSP3.set(rollerSpeed);
	}

	public void ClimbRollerReverese() {
//		double rollerSpeed = -0.75;
		// climbRoller1.set(rollerSpeed);
//		victorSP3.set(rollerSpeed);
	}

	public void ClimbRollerStop() {
//		victorSP3.set(0.0);
		System.out.println("stopped");
	}
	
	public void ClimbRollerAxis(Joystick stick, int axis) {
//		victorSP3.set(stick.getRawAxis(axis));
	}

}
