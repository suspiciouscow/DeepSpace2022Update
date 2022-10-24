package org.usfirst.frc.team2412.robot.subsystems;

import edu.wpi.first.wpilibj2.command.subsystem;

public class ClimbLatchSubsystem extends SubsystemBase {

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