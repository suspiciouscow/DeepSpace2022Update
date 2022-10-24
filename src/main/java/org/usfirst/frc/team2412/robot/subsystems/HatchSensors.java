package org.usfirst.frc.team2412.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HatchSensors extends SubsystemBase {

	public HatchSensors() {

	}

	public boolean input1() {
		return false;
		// return RobotMap.limitSwitch1.get();
	}

	public void LEDon() {
		// RobotMap.led1.set(true);
	}

}
