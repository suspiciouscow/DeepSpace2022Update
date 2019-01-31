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
	
	int coDriverPort = 1;
	int liftUpButtonNumber = 1;
	int liftDownButtonNumber = 2;
	
	//hatch buttons
	
	int hatch1ButtonNumber = 3;
	int hatch2ButtonNumber = 4;
	int hatch3ButtonNumber = 5;
	
	int cargo1ButtonNumber = 6;
	int cargo2ButtonNumber = 7;
	int cargo3ButtonNumber = 8;
	
	int brakeButtonNumber = 9;
	
	//// CREATING BUTTONS
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	
	
	public Joystick coDriver = new Joystick(coDriverPort);
	public Button liftUpButton = new JoystickButton(coDriver, liftUpButtonNumber);
	public Button liftDownButton = new JoystickButton(coDriver, liftDownButtonNumber);
	
	public Button hatch1Button = new JoystickButton(coDriver, hatch1ButtonNumber);
	public Button hatch2Button = new JoystickButton(coDriver, hatch2ButtonNumber);
	public Button hatch3Button = new JoystickButton(coDriver, hatch3ButtonNumber);
	
	public Button cargo1Button = new JoystickButton(coDriver, cargo1ButtonNumber);
	public Button cargo2Button = new JoystickButton(coDriver, cargo2ButtonNumber);
	public Button cargo3Button = new JoystickButton(coDriver, cargo3ButtonNumber);
	
	public Button brakeButton = new JoystickButton(coDriver, brakeButtonNumber);
	
	
	public OI() {
		liftUpButton.whileHeld(new LiftUp());
		liftDownButton.whileHeld(new LiftDown());
		
		hatch1Button.whenPressed(new GoToHatchLevel1());
		hatch2Button.whenPressed(new GoToHatchLevel2());
		hatch3Button.whenPressed(new GoToHatchLevel3());
		
		cargo1Button.whenPressed(new GoToCargoLevel1());
		cargo2Button.whenPressed(new GoToCargoLevel2());
		cargo3Button.whenPressed(new GoToCargoLevel3());
		
		brakeButton.whenPressed(new Brake());
	}
}
