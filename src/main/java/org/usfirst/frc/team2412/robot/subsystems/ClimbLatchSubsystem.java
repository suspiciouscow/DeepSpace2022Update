package org.usfirst.frc.team2412.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimbLatchSubsystem extends Subsystem {

	// private DoubleSolenoid latchPneumatics = RobotMap.latchPneumatics;

	@Override
	protected void initDefaultCommand() {
	}

	public void openLatch() {
		// latchPneumatics.set(DoubleSolenoid.Value.kForward);
	}

	public void closeLatch() {
		// latchPneumatics.set(DoubleSolenoid.Value.kReverse);
	}
}