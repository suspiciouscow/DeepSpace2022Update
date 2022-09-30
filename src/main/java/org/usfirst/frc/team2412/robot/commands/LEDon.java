package org.usfirst.frc.team2412.robot.commands;

public class LEDon extends CommandBase2412 {

	public LEDon() {
		requires(hatchSensors);
	}

	public void execute() {
		if (hatchSensors.input1()) {
			hatchSensors.LEDon();
		}
	}
}
