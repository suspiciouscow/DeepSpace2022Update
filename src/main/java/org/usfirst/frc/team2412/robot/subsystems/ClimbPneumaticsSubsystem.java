package org.usfirst.frc.team2412.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimbPneumaticsSubsystem extends Subsystem {

//	private DoubleSolenoid climbPneumatics = RobotMap.climbPneumatics;

	@Override
	protected void initDefaultCommand() {
	}

	public void DeployRails() {
//		climbPneumatics.set(DoubleSolenoid.Value.kForward);
		System.out.println("Deploy");
	}

	public void RetractRails() {
//		climbPneumatics.set(DoubleSolenoid.Value.kReverse);
		System.out.println("Retract");
	}
}