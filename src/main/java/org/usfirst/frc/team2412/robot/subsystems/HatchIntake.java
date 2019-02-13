package org.usfirst.frc.team2412.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HatchIntake extends Subsystem {
	int up = 4;
	int down = 0;
	DoubleSolenoid upDown = new DoubleSolenoid(up, down);

	@Override
	protected void initDefaultCommand() {

	}

	public void pistonUp() {
		upDown.set(DoubleSolenoid.Value.kForward);
	}

	public void pistonDown() {
		upDown.set(DoubleSolenoid.Value.kReverse);
	}
}
