package org.usfirst.frc.team2412.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HatchIntake extends SubsystemBase {
//  private Solenoid PistonMoving = RobotMap.pistonface;

	@Override
	protected void initDefaultCommand() {

	}
	public void pistonUp()
	{
		// PistonMoving.set(false);
	}
	
	public  void pistonDown()
	{
		// PistonMoving.set(true);
	}
}
