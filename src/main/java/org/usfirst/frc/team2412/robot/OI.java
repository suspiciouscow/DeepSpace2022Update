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

	// Joysticks

	public int coDriverPort = 1;

	public Joystick stick = new Joystick(0);
	public Joystick coDriver = new Joystick(coDriverPort);

	// Button IDs

	// Driver
	public int buttonOutIntakeNumber = 0;

	// coDriver

	public int buttonArmUpNumber = 1;
	public int buttonArmDownNumber = 2;
	public int buttonInNumber = 3;
	public int buttonOutNumber = 4;
	public int hatchCargoSwitchNumber = 7;

	public int buttonDeployNumber = 5;
	public int buttonReleaseNumber = 6;
	public int buttonClimbUpNumber = 8;
	public int buttonClimbDownNumber = 9;
	public int buttonClimbRollerForwardNumber = 10;
	public int buttonClimbRollerReverseNumber = 11;

	public int brakeButtonNumber = 12;

	public int liftUpButtonNumber = 13;
	public int liftDownButtonNumber = 14;
	public int level1ButtonNumber = 15;
	public int level2ButtonNumber = 16;
	public int level3ButtonNumber = 17;

	// Buttons

	// Intake
	public Button buttonOutIntake = new JoystickButton(stick, buttonOutIntakeNumber);
	public Button buttonArmUp = new JoystickButton(coDriver, buttonArmUpNumber);
	public Button buttonArmDown = new JoystickButton(coDriver, buttonArmDownNumber);
	public Button buttonIn = new JoystickButton(coDriver, buttonInNumber);
	public Button buttonOut = new JoystickButton(coDriver, buttonOutNumber);

	public Button hatchCargoSwitch = new JoystickButton(coDriver, hatchCargoSwitchNumber);

	// Climb
	public Button buttonClimbUp = new JoystickButton(coDriver, buttonClimbUpNumber);
	public Button buttonClimbDown = new JoystickButton(coDriver, buttonClimbDownNumber);
	public Button buttonClimbRollerForward = new JoystickButton(coDriver, buttonClimbRollerForwardNumber);
	public Button buttonClimbRollerReverse = new JoystickButton(coDriver, buttonClimbRollerReverseNumber);
	public Button buttonDeploy = new JoystickButton(coDriver, buttonDeployNumber);
	public Button buttonRelease = new JoystickButton(coDriver, buttonReleaseNumber);

	// Drive
	public Button trigger = new JoystickButton(stick, 1);
	public Button shiftHighButton = new JoystickButton(stick, 2);
	public Button brakeButton = new JoystickButton(coDriver, brakeButtonNumber);

	// Lift
	public Button liftUpButton = new JoystickButton(coDriver, liftUpButtonNumber);
	public Button liftDownButton = new JoystickButton(coDriver, liftDownButtonNumber);
	public Button level1Button = new JoystickButton(coDriver, level1ButtonNumber);
	public Button level2Button = new JoystickButton(coDriver, level2ButtonNumber);
	public Button level3Button = new JoystickButton(coDriver, level3ButtonNumber);

	public OI() {
		buttonArmUp.whileHeld(new InTakeUp());
		buttonArmDown.whileHeld(new InTakeDown());
		buttonIn.whileHeld(new InTakeCargo());
		buttonIn.whenReleased(new InTakeStop());
		buttonOut.whileHeld(new OutputCargo());
		buttonOut.whenReleased(new InTakeStop());
		buttonOutIntake.whileHeld(new PistonsOut());
		buttonOutIntake.whenReleased(new PistonsIn());

		buttonDeploy.whenPressed(new DeployRails());
		buttonRelease.whenPressed(new RetractRails());
		buttonClimbUp.whileHeld(new ClimbLiftForward());
		buttonClimbDown.whileHeld(new ClimbLiftReverse());
		buttonClimbRollerForward.whileHeld(new ClimbRollerForward());
		buttonClimbRollerReverse.whileHeld(new ClimbRollerReverse());

		brakeButton.whenPressed(new Brake());
		trigger.whileHeld(new VisionGuidanceCommand());
		shiftHighButton.whileHeld(new ShiftHighGearCommand());

		liftUpButton.whileHeld(new LiftUp());
		liftDownButton.whileHeld(new LiftDown());

		level1Button.whenPressed(new GoToLevel(1));
		level2Button.whenPressed(new GoToLevel(2));
		level3Button.whenPressed(new GoToLevel(3));

		// trigger.whileHeld(new VisionGuidanceCommand());
		// trigger.whenPressed(new TimeLatencyCommand());
	}

}
