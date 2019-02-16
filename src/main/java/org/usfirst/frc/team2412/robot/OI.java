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
import org.usfirst.frc.team2412.robot.commands.GoToLevel;
import org.usfirst.frc.team2412.robot.commands.InTakeCargo;
import org.usfirst.frc.team2412.robot.commands.InTakeDown;
import org.usfirst.frc.team2412.robot.commands.InTakeStop;
import org.usfirst.frc.team2412.robot.commands.InTakeUp;
import org.usfirst.frc.team2412.robot.commands.LiftDown;
import org.usfirst.frc.team2412.robot.commands.LiftUp;
import org.usfirst.frc.team2412.robot.commands.OutputCargo;
import org.usfirst.frc.team2412.robot.commands.PistonsIn;
import org.usfirst.frc.team2412.robot.commands.PistonsOut;
import org.usfirst.frc.team2412.robot.commands.RetractRails;
import org.usfirst.frc.team2412.robot.commands.ShiftHighGearCommand;
import org.usfirst.frc.team2412.robot.commands.VisionGuidanceCommand;

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
	public int buttonOutIntakeNumber = 3; // Changed from 0 to 3

	// coDriver

	public int buttonArmUpNumber = 1;
	public int buttonArmDownNumber = 2;
	public int buttonInNumber = 3;
	public int buttonOutNumber = 4;

	// Climb buttons - on a separate joystick

	public int buttonDeployNumber = 1; // Changed from 5 to 1
	public int buttonReleaseNumber = 2; // Changed from 6 to 2
	public int buttonClimbUpNumber = 3; // Changed from 7 to 3
	public int buttonClimbDownNumber = 4; // Changed from 8 to 4
	public int buttonClimbRollerForwardNumber = 5; // Changed from 10 to 5
	public int buttonClimbRollerReverseNumber = 6; // Changed from 11 to 6

	// public int brakeButtonNumber = 12;

	// Lift buttons - on the codriver

	public int liftUpButtonNumber = 5; // Changed from 13 to 5
	public int liftDownButtonNumber = 6; // Changed from 14 to 6
	public int level1ButtonNumber = 7; // Changed from 15 to 7
	public int level2ButtonNumber = 8; // Changed from 16 to 8
	public int level3ButtonNumber = 9; // Changed from 17 to 9
	public int hatchCargoSwitchNumber = 10; // Changed from 7 to 10

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
	// public Button brakeButton = new JoystickButton(coDriver, brakeButtonNumber);

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

		// brakeButton.whenPressed(new Brake());
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
