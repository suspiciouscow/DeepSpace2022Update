/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2412.robot;

import org.usfirst.frc.team2412.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	public Joystick stick = new Joystick(0);
	public Joystick coDriver = new Joystick(1);
	//Change the pneumatics to motors using 62.5 gear turns
	public Button buttonArmUp = new JoystickButton(coDriver, 1);
	public Button buttonArmDown = new JoystickButton(coDriver, 2);
	public Button buttonIn = new JoystickButton(coDriver, 4);
	public Button buttonOut = new JoystickButton(coDriver, 5);
	public Button buttonDeploy = new JoystickButton(coDriver, 6);
	public Button buttonRelease = new JoystickButton(coDriver, 7);
	public Button buttonClimbUp = new JoystickButton(coDriver, 8);
	public Button buttonClimbDown = new JoystickButton(coDriver, 9);
	public Button buttonClimbRollerForward = new JoystickButton(coDriver, 10);
	public Button buttonClimbRollerReverse = new JoystickButton(coDriver, 11);

	public Button trigger = new JoystickButton(stick, 1);
	public Button shiftHighButton = new JoystickButton(stick, 2);

	public OI() {
		buttonArmUp.whileHeld(new InTakeUp());
		buttonArmDown.whileHeld(new InTakeDown());		
		buttonIn.whileHeld(new InTakeCargo());
		buttonIn.whenReleased(new InTakeStop());
		buttonOut.whileHeld(new OutputCargo());
		buttonOut.whenReleased(new InTakeStop());
		buttonDeploy.whenPressed(new DeployRails());
		buttonRelease.whenPressed(new RetractRails());
		buttonClimbUp.whileHeld(new ClimbLiftForward());
		buttonClimbDown.whileHeld(new ClimbLiftReverse());
		buttonClimbRollerForward.whileHeld(new ClimbRollerForward());
		buttonClimbRollerReverse.whileHeld(new ClimbRollerReverse());

		trigger.whileHeld(new VisionGuidanceCommand());
		shiftHighButton.whileHeld(new ShiftHighGearCommand());
		liftUpButton.whileHeld(new LiftUp());
		liftDownButton.whileHeld(new LiftDown());
		
//		hatch1Button.whenPressed(new GoToHatchLevel1());
//		hatch2Button.whenPressed(new GoToHatchLevel2());
//		hatch3Button.whenPressed(new GoToHatchLevel3());
//		
//		cargo1Button.whenPressed(new GoToCargoLevel1());
//		cargo2Button.whenPressed(new GoToCargoLevel2());
//		cargo3Button.whenPressed(new GoToCargoLevel3());
		
		level1.whenPressed(new GoToLevel1());
		level2.whenPressed(new GoToLevel2());
		level3.whenPressed(new GoToLevel3());
		
		brakeButton.whenPressed(new Brake());
	}
	int coDriverPort = 1;
	int liftUpButtonNumber = 1;
	int liftDownButtonNumber = 2;
	
	//hatch buttons
	
//	int hatch1ButtonNumber = 3;
//	int hatch2ButtonNumber = 4;
//	int hatch3ButtonNumber = 5;
//	
//	int cargo1ButtonNumber = 6;
//	int cargo2ButtonNumber = 7;
//	int cargo3ButtonNumber = 8;
	
	int brakeButtonNumber = 9;
	
	//// CREATING BUTTONS
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	
	
	public Button liftUpButton = new JoystickButton(coDriver, liftUpButtonNumber);
	public Button liftDownButton = new JoystickButton(coDriver, liftDownButtonNumber);
	
//	public Button hatch1Button = new JoystickButton(coDriver, hatch1ButtonNumber);
//	public Button hatch2Button = new JoystickButton(coDriver, hatch2ButtonNumber);
//	public Button hatch3Button = new JoystickButton(coDriver, hatch3ButtonNumber);
//	
//	public Button cargo1Button = new JoystickButton(coDriver, cargo1ButtonNumber);
//	public Button cargo2Button = new JoystickButton(coDriver, cargo2ButtonNumber);
//	public Button cargo3Button = new JoystickButton(coDriver, cargo3ButtonNumber);
//	
	
	
	public Button level1 = new JoystickButton(coDriver, 0);
	public Button level2 = new JoystickButton(coDriver, 1);
	public Button level3 = new JoystickButton(coDriver, 2);
	
	public Button hatchCargoSwitch = new JoystickButton(coDriver, 3);
	
	public Button brakeButton = new JoystickButton(coDriver, brakeButtonNumber);
	
	
	
}
