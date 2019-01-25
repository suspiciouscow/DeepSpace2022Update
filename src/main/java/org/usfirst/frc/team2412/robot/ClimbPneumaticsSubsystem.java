package org.usfirst.frc.team2412.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimbPneumaticsSubsystem extends Subsystem {

	private DoubleSolenoid climbPneumatics = RobotMap.climbPneumatics;
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	public void DeployRails() {	
		climbPneumatics.set(DoubleSolenoid.Value.kForward);
	}
	public void RetractRails() {
		climbPneumatics.set(DoubleSolenoid.Value.kReverse);
	}
	
	
	}