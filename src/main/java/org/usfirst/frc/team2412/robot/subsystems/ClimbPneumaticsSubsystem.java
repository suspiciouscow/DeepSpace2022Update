package org.usfirst.frc.team2412.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbPneumaticsSubsystem extends SubsystemBase {

	// private DoubleSolenoid climbPneumatics = RobotMap.climbPneumatics;

	public void DeployRails() {
		// climbPneumatics.set(DoubleSolenoid.Value.kForward);
		System.out.println("Deploy");
	}

	public void RetractRails() {
		// climbPneumatics.set(DoubleSolenoid.Value.kReverse);
		System.out.println("Retract");
	}
}