package org.usfirst.frc.team2412.robot.subsystems;

import org.usfirst.frc.team2412.robot.commands.ClimbLiftJoystick;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimbLiftSubsystem extends Subsystem {

//	private MaxBotixSonar ultraSoundRadar = RobotMap.ultraSoundRadar;
//	private DigitalInput limitSwitchClimbForward = RobotMap.limitSwitchClimbForward;
//	private DigitalInput limitSwitchClimbReverse = RobotMap.limitSwitchClimbReverse;
//	private VictorSP victorSP1 = RobotMap.victorSP1;
//	private VictorSP victorSP2 = RobotMap.victorSP2;

	protected void initDefaultCommand() {
		// setDefaultCommand(new ClimbLiftJoystick());
	}

	public void ClimbLiftForward() {
		System.out.println("foward" + System.currentTimeMillis() % 1000);
//		double LiftSpeed = 0.5;
//		victorSP1.set(LiftSpeed);
//		victorSP2.set(LiftSpeed);
	}

	public void ClimbLiftReverse() {
		System.out.println("reverse");
//		double LiftSpeed = -0.5;
//		victorSP1.set(LiftSpeed);
//		victorSP2.set(LiftSpeed);
	}

	public void ClimbLiftStop() {
		System.out.println("Released");
//		double LiftSpeed = 0.0;
//		victorSP1.set(LiftSpeed);
//		victorSP2.set(LiftSpeed);
	}

	public void ClimbLiftJoystick(Joystick stick, int axis) {
		System.out.println("Climb lift joystick...");
//		double LiftSpeed = stick.getRawAxis(axis);
//		victorSP1.set(LiftSpeed);
//		victorSP1.set(LiftSpeed);
	}

	public double ultraSoundRadar() {
		return 0;
//		return ultraSoundRadar.getInches();
	}

	public boolean limitSwitchClimbReverse() {
		return false;
//		return limitSwitchClimbReverse.get();
	}

	public boolean limitSwitchClimbForward() {
		return false;
//		return limitSwitchClimbForward.get();
	}
}