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
 * 
 * BUTTONS:
 * 
 * DRIVER:
 * ---------------
 *  - 1 vision guidance
 *  - 2 shift to low gear
 * 
 * CODRIVER - Arduino Due:
 * ---------------
 * Intake cargo:
 *  - 1 in
 *  - 2 out
 * 
 * Intake hatch:
 *  - 3 out
 * --------------
 * Climb:
 *  - 4 rail deploy
 * --------------
 * Lift:
 *  - 5 level 1 hatch
 *  - 6 level 2 hatch
 *  - 7 level 3 hatch
 *  - 8 level 1 cargo
 *  - 9 level 2 cargo
 *  - 10 level 3 cargo
 * --------------
 * Manual switch (dial):
 *  - 11 none
 *  - 12 lift up/down
 *  - 13 intake rotation
 *  - 14 intake roller in/out
 *  - 15 climb up/down
 *  - 16 climb roller forwards/backwards
 * 
 * CODRIVER - eStop board:
 * ---------------
 * Intake position switch - not fully used because we don't have an intake angle sensor yet:
 *  - 1 intake up, originally storage
 *  - 2 intake down, originally vertical
 *  - 3 unused, cargo angle
 *  - 4 unused, horizontal
 *  - 5 unused, spare
 */
public class OI {

	/** Joysticks: */
	// stick - the driver's joystick (port 0)
	// coDriverArduino - the part of the Arduino board that uses the Arduino (port 1)
	// coDriverEStop - the part of the Arduino board that uses the EStop robotics board (port 2)

	public int stickPort = 0;
	public int coDriverArduinoPort = 1;
	public int coDriverEStopPort = 2;

	public Joystick stick = new Joystick(stickPort);
	public Joystick coDriverArduino = new Joystick(coDriverArduinoPort);
	public Joystick coDriverEStop = new Joystick(coDriverEStopPort);

	// Joystick axis for the manual joystick on the codriver board
	public static final int MANUAL_AXIS = 1;

	/** Button IDs */

	// Driver joystick (stick)
	public int buttonVisionGuidanceNumber = 1;
	public int buttonShiftingNumber = 2;
	
	// coDriver - Arduino Due
	
	/*
	// Intake button numbers for the preset angles
	public int buttonIntakeStowedAngleNumber = 1;
	public int buttonIntakeVerticalAngleNumber = 2;
	public int buttonIntakeCargoAngleNumber = 3;
	public int buttonIntakeHorizontalAngleNumber = 4;
	public int buttonIntakeSpareAngleNumber = 5;
	
	// Intake preset angle values - stowed is zero, increases going counterclockwise
	public int intakeStowedAngle = 0;
	public int intakeVerticalAngle = 10;
	public int intakeCargoAngle = 55;
	public int intakeHorizontalAngle = 100;
	public int intakeSpareAngle = 0;
	*/

	// Intake cargo button numbers
	public int buttonInNumber = 1;
	public int buttonOutNumber = 2;
	
	// Intake hatch button numbers
	public int buttonOutIntakeNumber = 3;
	
	// Climb button numbers (for rail deployment)
	public int buttonDeployNumber = 4;
	
	// Lift button numbers
	public int level1ButtonNumberHatch = 5;
	public int level2ButtonNumberHatch = 6;
	public int level3ButtonNumberHatch = 7;

	public int level1ButtonNumberCargo = 8;
	public int level2ButtonNumberCargo = 9;
	public int level3ButtonNumberCargo = 10;

	// Buttons numbers for the manual dial
	public int manualNoneNumber = 11;
	public int manualLiftNumber = 12;
	public int manualIntakeRotateNumber = 13;
	public int manualIntakeInOutNumber = 14;
	public int manualClimbLiftNumber = 15;
	public int manualClimbRollerNumber = 16;

	// coDriver - estop robotics board

	// Intake button numbers for rotating up and down
	public int buttonIntakeUpNumber = 1;
	public int buttonIntakeDownNumber = 2;

	/** Button instances */
	
 	// Driver joystick (stick) buttons
	public Button visionGuidance = new JoystickButton(stick, buttonVisionGuidanceNumber);
	public Button shiftHighButton = new JoystickButton(stick, buttonShiftingNumber);
	
	/*
	// Intake button numbers for the preset angles
	public Button buttonIntakeStowedAngle = new JoystickButton(coDriver, buttonIntakeStowedAngleNumber);
	public Button buttonIntakeVerticalAngle = new JoystickButton(coDriver, buttonIntakeVerticalAngleNumber);
	public Button buttonIntakeCargoAngle = new JoystickButton(coDriver, buttonIntakeCargoAngleNumber);
	public Button buttonIntakeHorizontalAngle = new JoystickButton(coDriver, buttonIntakeHorizontalAngleNumber);
	public Button buttonIntakeSpareAngle = new JoystickButton(coDriver, buttonIntakeSpareAngleNumber);
	*/

	// Intake cargo buttons
	public Button buttonIn = new JoystickButton(coDriverArduino, buttonInNumber);
	public Button buttonOut = new JoystickButton(coDriverArduino, buttonOutNumber);
	
	// Intake hatch button
	public Button buttonOutIntake = new JoystickButton(coDriverArduino, buttonOutIntakeNumber);
	
	// Climb button (for rail deployment)
	public Button buttonDeploy = new JoystickButton(coDriverArduino, buttonDeployNumber);
	
	// Lift buttons
	public Button level1ButtonHatch = new JoystickButton(coDriverArduino, level1ButtonNumberHatch);
	public Button level2ButtonHatch = new JoystickButton(coDriverArduino, level2ButtonNumberHatch);
	public Button level3ButtonHatch = new JoystickButton(coDriverArduino, level3ButtonNumberHatch);

	public Button level1ButtonCargo = new JoystickButton(coDriverArduino, level1ButtonNumberCargo);
	public Button level2ButtonCargo = new JoystickButton(coDriverArduino, level2ButtonNumberCargo);
	public Button level3ButtonCargo = new JoystickButton(coDriverArduino, level3ButtonNumberCargo);

	// Buttons for the manual dial
	public Button buttonManualNone = new JoystickButton(coDriverArduino, manualNoneNumber);
	public Button buttonManualLift = new JoystickButton(coDriverArduino, manualLiftNumber);
	public Button buttonManualIntakeRotate = new JoystickButton(coDriverArduino, manualIntakeRotateNumber);
	public Button buttonManualIntakeInOut = new JoystickButton(coDriverArduino, manualIntakeInOutNumber);
	public Button buttonManualClimbLift = new JoystickButton(coDriverArduino, manualClimbLiftNumber);
	public Button buttonManualClimbRoller = new JoystickButton(coDriverArduino, manualClimbRollerNumber);

	// Buttons for rotating the intake up and down
	public Button buttonIntakeUp = new JoystickButton(coDriverEStop, buttonIntakeUpNumber);
	public Button buttonIntakeDown = new JoystickButton(coDriverEStop, buttonIntakeDownNumber);

	public OI() {
		// Driver joystick (stick) commands
		visionGuidance.whileHeld(new VisionGuidanceCommand2());
		shiftHighButton.whileHeld(new ShiftOtherGearCommand());

		// coDriver commands
		
		/*
		// Intake commands for the preset angles
		buttonIntakeStowedAngle.whenPressed(new GoToIntakeAngle(intakeStowedAngle));
		buttonIntakeVerticalAngle.whenPressed(new GoToIntakeAngle(intakeVerticalAngle));
		buttonIntakeCargoAngle.whenPressed(new GoToIntakeAngle(intakeCargoAngle));
		buttonIntakeHorizontalAngle.whenPressed(new GoToIntakeAngle(intakeHorizontalAngle));
		buttonIntakeSpareAngle.whenPressed(new GoToIntakeAngle(intakeSpareAngle));
		*/
		
		// Intake cargo commands
		buttonIn.whileHeld(new InTakeCargo());
		buttonIn.whenReleased(new InTakeStop());
		buttonOut.whileHeld(new OutputCargo());
		buttonOut.whenReleased(new InTakeStop());
		
		// Intake hatch commands
		buttonOutIntake.whileHeld(new PistonsOut());
		buttonOutIntake.whenReleased(new PistonsIn());
		
		// Climb command (for rail deployment)
		buttonDeploy.whenPressed(new DeployRailsSequence());

		// Lift commands
		level1ButtonHatch.whenPressed(new GoToLevel(1, true));
		level2ButtonHatch.whenPressed(new GoToLevel(2, true));
		level3ButtonHatch.whenPressed(new GoToLevel(3, true));

		level1ButtonCargo.whenPressed(new GoToLevel(1, false));
		level2ButtonCargo.whenPressed(new GoToLevel(2, false));
		level3ButtonCargo.whenPressed(new GoToLevel(3, false));

		// Buttons for the manual lift
		buttonManualLift.whileHeld(new LiftAxisCommand()); 
		buttonManualIntakeRotate.whileHeld(new InTakeAxisRotate());
		buttonManualIntakeInOut.whileHeld(new InTakeInOutAxis());
		buttonManualIntakeInOut.whenReleased(new InTakeStop());
		buttonManualClimbLift.whileHeld(new ClimbLiftJoystick());
		buttonManualClimbRoller.whileHeld(new ClimbRollerAxis());

		// Buttons for rotating intake up and down
		buttonIntakeUp.whileHeld(new InTakeUp());
		buttonIntakeDown.whileHeld(new InTakeDown());
	}

}
