/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2412.robot;

import org.usfirst.frc.team2412.robot.commands.InTakeCargo;
import org.usfirst.frc.team2412.robot.commands.InTakeDown;
import org.usfirst.frc.team2412.robot.commands.InTakeUp;
import org.usfirst.frc.team2412.robot.commands.OutputCargo;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OperatorInterface {

	public Joystick coDriver = new Joystick(1);
	public Button buttonUp = new JoystickButton(coDriver, 2);
	public Button buttonDown = new JoystickButton(coDriver, 3);
	public Button buttonIn = new JoystickButton(coDriver, 4);
	public Button buttonOut = new JoystickButton(coDriver, 5);
	public OperatorInterface() {
		buttonUp.whenPressed(new InTakeUp());
		buttonDown.whenPressed(new InTakeDown());		
		buttonIn.whenPressed(new InTakeCargo());
		buttonOut.whenPressed(new OutputCargo());
	}
	
}
