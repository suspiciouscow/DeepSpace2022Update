package org.usfirst.frc.team2412.robot.subsystems;

import org.usfirst.frc.team2412.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HatchIntake extends Subsystem {
 private Solenoid PistonMoving = RobotMap.pistonface;

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	public void pistonUp()
	{
		PistonMoving.set(true);
	}
	
	public  void pistonDown()
	{
		PistonMoving.set(false);
	}
	}


