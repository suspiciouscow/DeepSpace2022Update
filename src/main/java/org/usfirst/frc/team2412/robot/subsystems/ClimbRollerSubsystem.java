package org.usfirst.frc.team2412.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbRollerSubsystem extends SubsystemBase {

	// private VictorSP victorSP3 = RobotMap.victorSP3;

	public void ClimbRollerForward() {
		// double rollerSpeed = 0.75;
		// climbRoller1.set(0.75);
		// victorSP3.set(rollerSpeed);
	}

	public void ClimbRollerReverese() {
		// double rollerSpeed = -0.75;
		// climbRoller1.set(rollerSpeed);
		// victorSP3.set(rollerSpeed);
	}

	public void ClimbRollerStop() {
		// victorSP3.set(0.0);
		System.out.println("released");
	}
	
	public void ClimbRollerAxis(Joystick stick, int axis) {
		// double throttleSpeed = stick.getRawAxis(axis) * 1.1;
		// if(throttleSpeed < 0) {
		// 	victorSP3.set(Math.min(throttleSpeed, -1));
		// } else {
		// 	victorSP3.set(Math.min(throttleSpeed, 1));
		// }
	}

}
