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
 * CODRIVER:
 * ---------------
 * Intake position switch:
 *  - 1 storage
 *  - 2 vertical
 *  - 3 cargo angle
 *  - 4 horizontal
 *  - 5 spare
 * 
 * Intake cargo:
 *  - 6 in
 *  - 7 out
 * 
 * Intake hatch:
 *  - 8 out
 * --------------
 * Climb:
 *  - 9 rail deploy
 * --------------
 * Lift:
 *  - 10 level 1 hatch
 *  - 11 level 2 hatch
 *  - 12 level 3 hatch
 *  - 13 level 1 cargo
 *  - 14 level 2 cargo
 *  - 15 level 3 cargo
 * --------------
 * Manual switch (dial):
 *  - 16 none
 *  - 17 lift up/down
 *  - 18 intake rotation
 *  - 19 intake roller in/out
 *  - 20 climb up/down
 *  - 21 climb roller forwards/backwards
 */
public class OI {

	/** Joysticks: */
	// stick - the driver's joystick (port 0)
	// coDriver - the codriver board (port 1)

	public int stickPort = 0;
	public int coDriverPort = 1;

	public Joystick stick = new Joystick(0);
	public Joystick coDriver = new Joystick(coDriverPort);

	// Joystick axis for the manual joystick on the codriver board
	public static final int MANUAL_AXIS = 1;

	/** Button IDs */

	// Driver joystick (stick)
	public int buttonVisionGuidanceNumber = 1;
	public int buttonShiftingNumber = 2;
	
	// coDriver
	
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
	
	// Intake cargo button numbers
	public int buttonInNumber = 6;
	public int buttonOutNumber = 7;
	
	// Intake hatch button numbers
	public int buttonOutIntakeNumber = 8;
	
	// Climb button numbers (for rail deployment)
	public int buttonDeployNumber = 9;
	
	// Lift button numbers
	public int level1ButtonNumberHatch = 10;
	public int level2ButtonNumberHatch = 11;
	public int level3ButtonNumberHatch = 12;

	public int level1ButtonNumberCargo = 13;
	public int level2ButtonNumberCargo = 14;
	public int level3ButtonNumberCargo = 15;

	// Buttons numbers for the manual dial
	public int manualNoneNumber = 16;
	public int manualLiftNumber = 17;
	public int manualIntakeRotateNumber = 18;
	public int manualIntakeInOutNumber = 19;
	public int manualClimbLiftNumber = 20;
	public int manualClimbRollerNumber = 21;

	/** Button instances */
	
 	// Driver joystick (stick) buttons
	public Button visionGuidance = new JoystickButton(stick, buttonVisionGuidanceNumber);
	public Button shiftHighButton = new JoystickButton(stick, buttonShiftingNumber);
	
	// Intake button numbers for the preset angles
	public Button buttonIntakeStowedAngle = new JoystickButton(coDriver, buttonIntakeStowedAngleNumber);
	public Button buttonIntakeVerticalAngle = new JoystickButton(coDriver, buttonIntakeVerticalAngleNumber);
	public Button buttonIntakeCargoAngle = new JoystickButton(coDriver, buttonIntakeCargoAngleNumber);
	public Button buttonIntakeHorizontalAngle = new JoystickButton(coDriver, buttonIntakeHorizontalAngleNumber);
	public Button buttonIntakeSpareAngle = new JoystickButton(coDriver, buttonIntakeSpareAngleNumber);

	// Intake cargo buttons
	public Button buttonIn = new JoystickButton(coDriver, buttonInNumber);
	public Button buttonOut = new JoystickButton(coDriver, buttonOutNumber);
	
	// Intake hatch button
	public Button buttonOutIntake = new JoystickButton(coDriver, buttonOutIntakeNumber);
	
	// Climb button (for rail deployment)
	public Button buttonDeploy = new JoystickButton(coDriver, buttonDeployNumber);
	
	// Lift buttons
	public Button level1ButtonHatch = new JoystickButton(coDriver, level1ButtonNumberHatch);
	public Button level2ButtonHatch = new JoystickButton(coDriver, level2ButtonNumberHatch);
	public Button level3ButtonHatch = new JoystickButton(coDriver, level3ButtonNumberHatch);

	public Button level1ButtonCargo = new JoystickButton(coDriver, level1ButtonNumberCargo);
	public Button level2ButtonCargo = new JoystickButton(coDriver, level2ButtonNumberCargo);
	public Button level3ButtonCargo = new JoystickButton(coDriver, level3ButtonNumberCargo);

	// Buttons for the manual dial
	public Button buttonManualNone = new JoystickButton(coDriver, manualNoneNumber);
	public Button buttonManualLift = new JoystickButton(coDriver, manualLiftNumber);
	public Button buttonManualIntakeRotate = new JoystickButton(coDriver, manualIntakeRotateNumber);
	public Button buttonManualIntakeInOut = new JoystickButton(coDriver, manualIntakeInOutNumber);
	public Button buttonManualClimbLift = new JoystickButton(coDriver, manualClimbLiftNumber);
	public Button buttonManualClimbRoller = new JoystickButton(coDriver, manualClimbRollerNumber);

	public OI() {
		// Driver joystick (stick) commands
		visionGuidance.whileHeld(new VisionGuidanceCommand2());
		shiftHighButton.whileHeld(new ShiftOtherGearCommand());

		// coDriver commands
		
		// Intake commands for the preset angles
		buttonIntakeStowedAngle.whenPressed(new GoToIntakeAngle(intakeStowedAngle));
		buttonIntakeVerticalAngle.whenPressed(new GoToIntakeAngle(intakeVerticalAngle));
		buttonIntakeCargoAngle.whenPressed(new GoToIntakeAngle(intakeCargoAngle));
		buttonIntakeHorizontalAngle.whenPressed(new GoToIntakeAngle(intakeHorizontalAngle));
		buttonIntakeSpareAngle.whenPressed(new GoToIntakeAngle(intakeSpareAngle));
		
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
	}

}
