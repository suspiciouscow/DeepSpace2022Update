package org.usfirst.frc.team2412.robot.subsystems;

import org.usfirst.frc.team2412.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class InTakeUpDownSubsystem extends Subsystem {

	private DoubleSolenoid upDown = RobotMap.upDown;
	@Override
	protected void initDefaultCommand() {
		//Ari is Awesome!
		//Ari is actually going to program something
	
		
	}
	public void InTakeUp() {upDown.set(DoubleSolenoid.Value.kForward);}
	public void InTakeDown() {upDown.set(DoubleSolenoid.Value.kReverse);}
	
}
