/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2412.robot;

import org.usfirst.frc.team2412.robot.commands.ClimbLiftForward;
import org.usfirst.frc.team2412.robot.commands.ClimbLiftReverse;
import org.usfirst.frc.team2412.robot.commands.ClimbRollerForward;
import org.usfirst.frc.team2412.robot.commands.ClimbRollerReverse;
import org.usfirst.frc.team2412.robot.commands.DeployRails;
import org.usfirst.frc.team2412.robot.commands.InTakeCargo;
import org.usfirst.frc.team2412.robot.commands.InTakeDown;
import org.usfirst.frc.team2412.robot.commands.InTakeUp;
import org.usfirst.frc.team2412.robot.commands.OutputCargo;
import org.usfirst.frc.team2412.robot.commands.RetractRails;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public Joystick coDriver = new Joystick(1);
	//Change the pneumatics to motors using 62.5 gear turns
	public Button buttonArmUp = new JoystickButton(coDriver, 2);
	public Button buttonArmDown = new JoystickButton(coDriver, 3);
	public Button buttonIn = new JoystickButton(coDriver, 4);
	public Button buttonOut = new JoystickButton(coDriver, 5);
	public Button buttonDeploy = new JoystickButton(coDriver, 6);
	public Button buttonRelease = new JoystickButton(coDriver, 7);
	
	public Joystick climb = new Joystick(2);
	
	public Button buttonClimbUp = new JoystickButton(climb, 2);
	public Button buttonClimbDown = new JoystickButton(climb, 1);
	public Button buttonClimbRollerForward = new JoystickButton(climb, 2);
	public Button buttonClimbRollerReverse = new JoystickButton(climb, 3);
	public OI() {
		buttonArmUp.whileHeld(new InTakeUp());
		buttonArmDown.whileHeld(new InTakeDown());		
		buttonIn.whenPressed(new InTakeCargo());
		buttonOut.whenPressed(new OutputCargo());
		buttonDeploy.whenPressed(new DeployRails());
		buttonRelease.whenPressed(new RetractRails());
		buttonClimbUp.whileHeld(new ClimbLiftForward());
		buttonClimbDown.whileHeld(new ClimbLiftReverse());
		buttonClimbRollerForward.whileHeld(new ClimbRollerForward());
		buttonClimbRollerReverse.whileHeld(new ClimbRollerReverse());
	}
}