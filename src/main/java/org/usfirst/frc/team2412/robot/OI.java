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

	public Joystick climb = new Joystick(2);

	// Joystick axis for the manual joystick on the codriver board
	public static final int MANUAL_AXIS = 1;

	// Button IDs

	// Driver
	public int buttonOutIntakeNumber = 3; // Changed from 0 to 3

	// coDriver

	public int buttonArmUpNumber = 1;
	public int buttonArmDownNumber = 2;
	public int buttonInNumber = 12;
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
	public int level1ButtonNumberHatch = 7; // Changed from 15 to 7
	public int level2ButtonNumberHatch = 8; // Changed from 16 to 8
	public int level3ButtonNumberHatch = 9; // Changed from 17 to 9

	public int level1ButtonNumberCargo = 17; // Changed from
	public int level2ButtonNumberCargo = 18; // Changed from // fix these
	public int level3ButtonNumberCargo = 19; // Changed from

	public int liftBottomResetButtonNumber = 7; // Timothy make sure these values are ok.
	public int liftTopResetButtonNumber = 8;

	// Buttons for the manual dial
	
	public int manualNoneNumber = 11;
	public int manualLiftNumber = 12;
	public int manualIntakeRotateNumber = 13;
	public int manualIntakeInOutNumber = 14;
	public int manualClimbLiftNumber = 15;
	public int manualClimbRollerNumber = 16;

	// Buttons

	// Intake
	public Button buttonOutIntake = new JoystickButton(stick, buttonOutIntakeNumber);
	public Button buttonArmUp = new JoystickButton(coDriver, buttonArmUpNumber);
	public Button buttonArmDown = new JoystickButton(coDriver, buttonArmDownNumber);
	public Button buttonIn = new JoystickButton(coDriver, buttonInNumber);
	public Button buttonOut = new JoystickButton(coDriver, buttonOutNumber);

	// Drive
	public Button trigger = new JoystickButton(stick, 1);
	public Button shiftHighButton = new JoystickButton(stick, 2);
	// public Button brakeButton = new JoystickButton(coDriver, brakeButtonNumber);

	// Lift
	public Button liftUpButton = new JoystickButton(coDriver, liftUpButtonNumber);
	public Button liftDownButton = new JoystickButton(coDriver, liftDownButtonNumber);
	public Button level1ButtonHatch = new JoystickButton(coDriver, level1ButtonNumberHatch);
	public Button level2ButtonHatch = new JoystickButton(coDriver, level2ButtonNumberHatch);
	public Button level3ButtonHatch = new JoystickButton(coDriver, level3ButtonNumberHatch);

	public Button level1ButtonCargo = new JoystickButton(coDriver, level1ButtonNumberCargo);
	public Button level2ButtonCargo = new JoystickButton(coDriver, level2ButtonNumberCargo);
	public Button level3ButtonCargo = new JoystickButton(coDriver, level3ButtonNumberCargo);

	public Button liftBottomResetButton = new JoystickButton(climb, liftBottomResetButtonNumber);
	public Button liftTopResetButton = new JoystickButton(climb, liftTopResetButtonNumber);

	// Climb
	public Button buttonDeploy = new JoystickButton(climb, buttonDeployNumber);
	public Button buttonRelease = new JoystickButton(climb, buttonReleaseNumber);
	public Button buttonClimbUp = new JoystickButton(climb, 3);
	public Button buttonClimbDown = new JoystickButton(climb, 4);
	public Button buttonClimbRollerForward = new JoystickButton(climb, 5);
	public Button buttonClimbRollerReverse = new JoystickButton(climb, 6);

	// Manual buttons

	public Button buttonManualNone = new JoystickButton(coDriver, manualNoneNumber);
	public Button buttonManualLift = new JoystickButton(coDriver, manualLiftNumber);
	public Button buttonManualIntakeRotate = new JoystickButton(coDriver, manualIntakeRotateNumber);
	public Button buttonManualIntakeInOut = new JoystickButton(coDriver, manualIntakeInOutNumber);
	public Button buttonManualClimbLift = new JoystickButton(coDriver, manualClimbLiftNumber);
	public Button buttonManualClimbRoller = new JoystickButton(coDriver, manualClimbRollerNumber);

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
		trigger.whileHeld(new VisionGuidanceCommand2());
		shiftHighButton.whileHeld(new ShiftOtherGearCommand());

		liftUpButton.whileHeld(new LiftUp());
		liftDownButton.whileHeld(new LiftDown());

		level1ButtonHatch.whenPressed(new GoToLevel(1, true));
		level2ButtonHatch.whenPressed(new GoToLevel(2, true));
		level3ButtonHatch.whenPressed(new GoToLevel(3, true));

		level1ButtonCargo.whenPressed(new GoToLevel(1, false));
		level2ButtonCargo.whenPressed(new GoToLevel(2, false));
		level3ButtonCargo.whenPressed(new GoToLevel(3, false));

		liftBottomResetButton.whenPressed(new LiftBottomReset());
		liftTopResetButton.whenPressed(new LiftTopReset());
		
		// trigger.whileHeld(new VisionGuidanceCommand());
		// trigger.whenPressed(new TimeLatencyCommand());

		buttonManualLift.whileHeld(new LiftAxisCommand()); 
		buttonManualIntakeRotate.whileHeld(new InTakeAxisRotate());
		
		buttonManualClimbLift.whileHeld(new ClimbLiftJoystick());
		buttonManualClimbRoller.whileHeld(new ClimbRollerAxis());
	}

}
