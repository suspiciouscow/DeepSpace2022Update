/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2412.robot;

import org.usfirst.frc.team2412.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import org.usfirst.frc.team2412.robot.commands.CommandBase2412;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

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
 *  - 3 test vision guidance sensors
 * 
 * CODRIVER - Arduino Due, first joystick with buttons:
 * ---------------
 * Intake cargo:
 *  - 1 out
 *  - 2 in
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
 * 
 * CODRIVER - Arduino Due, second joystick with dials:
 * ---------------
 * Intake position switch:
 *  - 1 unused, spare
 *  - 2 down
 *  - 3 floor
 *  - 4 cargo
 *  - 5 score
 *  - 6 stowed
 *  - 7 unused, spare
 *  - 8 unused, spare
 * ---------------
 *  * Manual switch (dial):
 *  - 9 unused, spare
 *  - 10 lift up/down
 *  - 11 intake rotation
 *  - 12 intake roller in/out
 *  - 13 climb up/down
 *  - 14 climb roller forwards/backwards
 *  - 15 unused, spare
 *  - 16 unused, spare
 */
public class OI {

	/** Joysticks: */
	// stick - the driver's joystick (port 0)
	// coDriverArduinoDialsPort - the part of the Arduino board that uses the (physical) buttons and switches, not the dials (port 1)
	// coDriverArduinoDialPort - the part of the Arduino board that uses the (physical) dials (port 2)

	public static int stickPort = 0;
	public static int coDriverArduinoButtonsPort = 1;
	public static int coDriverArduinoDialsPort = 2;

	public Joystick stick = new Joystick(stickPort);
	public Joystick coDriverArduinoButtons = new Joystick(coDriverArduinoButtonsPort);
	public Joystick coDriverArduinoDials = new Joystick(coDriverArduinoDialsPort);

	// Joystick axis for the manual joystick on the codriver board (coDriverArduinoDials)
	public static final int MANUAL_AXIS = 1;
	public static final int MANUAL_PORT = coDriverArduinoDialsPort;

	/** Button IDs */

	// Driver joystick (stick)
	public int buttonVisionGuidanceNumber = 1;
	public int buttonShiftingNumber = 2;
	public int buttonVisionGuidanceSensorTestNumber = 3;
	
	// coDriver - Arduino Due with buttons
	
	// Intake cargo button numbers
	public int buttonOutNumber = 1;
	public int buttonInNumber = 2;
	
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
	
	// coDriver - Arduino Due with dials

	// Intake button numbers for the preset angles
	public int buttonIntakeStowedAngleNumber = 6;
	public int buttonIntakeScoreAngleNumber = 5;
	public int buttonIntakeCargoAngleNumber = 4;
	public int buttonIntakeFloorAngleNumber = 3;
	public int buttonIntakeDownAngleNumber = 2;
	
	// Intake preset angle values - stowed is zero, increases going counterclockwise
	public static int intakeStowedAngle = 57;
	public static int intakeScoreAngle = 57;
	public static int intakeCargoAngle = 138;
	public static int intakeFloorAngle = 164;
	public static int intakeDownAngle = 172;

	// Buttons numbers for the manual dial
	public int manualNoneNumber = 9;
	public int manualLiftNumber = 10;
	public int manualIntakeRotateNumber = 11;
	public int manualIntakeInOutNumber = 12;
	public int manualClimbLiftNumber = 13;
	public int manualClimbRollerNumber = 14;

	/** Button instances */
	
 	// Driver joystick (stick) buttons
	public Button visionGuidance = new JoystickButton(stick, buttonVisionGuidanceNumber);
	public Button shiftHighButton = new JoystickButton(stick, buttonShiftingNumber);
	public Button visionGuidanceSensorTestButton = new JoystickButton(stick, buttonVisionGuidanceSensorTestNumber);
	
	// coDriver with physical buttons
	
	// Intake cargo buttons
	public Button buttonIn = new JoystickButton(coDriverArduinoButtons, buttonInNumber);
	public Button buttonOut = new JoystickButton(coDriverArduinoButtons, buttonOutNumber);
	
	// Intake hatch button
	public Button buttonOutIntake = new JoystickButton(coDriverArduinoButtons, buttonOutIntakeNumber);
	
	// Climb button (for rail deployment)
	public Button buttonDeploy = new JoystickButton(coDriverArduinoButtons, buttonDeployNumber);
	
	// Lift buttons
	public Button level1ButtonHatch = new JoystickButton(coDriverArduinoButtons, level1ButtonNumberHatch);
	public Button level2ButtonHatch = new JoystickButton(coDriverArduinoButtons, level2ButtonNumberHatch);
	public Button level3ButtonHatch = new JoystickButton(coDriverArduinoButtons, level3ButtonNumberHatch);

	public Button level1ButtonCargo = new JoystickButton(coDriverArduinoButtons, level1ButtonNumberCargo);
	public Button level2ButtonCargo = new JoystickButton(coDriverArduinoButtons, level2ButtonNumberCargo);
	public Button level3ButtonCargo = new JoystickButton(coDriverArduinoButtons, level3ButtonNumberCargo);
	
	// coDriver - Arduino Due with physical dials

	// Intake button numbers for the preset angles
	public Button buttonIntakeStowedAngle = new JoystickButton(coDriverArduinoDials, buttonIntakeStowedAngleNumber);
	public Button buttonIntakeScoreAngle = new JoystickButton(coDriverArduinoDials, buttonIntakeScoreAngleNumber);
	public Button buttonIntakeCargoAngle = new JoystickButton(coDriverArduinoDials, buttonIntakeCargoAngleNumber);
	public Button buttonIntakeFloorAngle = new JoystickButton(coDriverArduinoDials, buttonIntakeFloorAngleNumber);
	public Button buttonIntakeDownAngle = new JoystickButton(coDriverArduinoDials, buttonIntakeDownAngleNumber);

	// Buttons for the manual dial
	public Button buttonManualNone = new JoystickButton(coDriverArduinoDials, manualNoneNumber);
	public Button buttonManualLift = new JoystickButton(coDriverArduinoDials, manualLiftNumber);
	public Button buttonManualIntakeRotate = new JoystickButton(coDriverArduinoDials, manualIntakeRotateNumber);
	public Button buttonManualIntakeInOut = new JoystickButton(coDriverArduinoDials, manualIntakeInOutNumber);
	public Button buttonManualClimbLift = new JoystickButton(coDriverArduinoDials, manualClimbLiftNumber);
	public Button buttonManualClimbRoller = new JoystickButton(coDriverArduinoDials, manualClimbRollerNumber);


	public OI() {
		// Driver joystick (stick) commands
		shiftHighButton.whileHeld(new ShiftOtherGearCommand());
	

				CommandBase2412.driveBase.setDefaultCommand(new JoystickDriveCommand());

		// coDriver commands
		
		// Intake cargo commands
		buttonIn.whileHeld(new InTakeCargo());
		buttonIn.whenReleased(new HoldCargo());
		buttonOut.whileHeld(new OutputCargo());
		buttonOut.whenReleased(new InTakeStop());
		
		// Intake hatch commands
		buttonOutIntake.whileHeld(new PistonsOut());
		buttonOutIntake.whenReleased(new PistonsIn());
		
		// Climb command (for rail deployment)
		buttonDeploy.whenPressed(new DeployRailsSequence());
		buttonDeploy.whenReleased(new RetractRails());
		// Lift commands
		level1ButtonHatch.whenPressed(new GoToLevel(1, true));
		level2ButtonHatch.whenPressed(new GoToLevel(2, true));
		level3ButtonHatch.whenPressed(new GoToLevel(3, true));

		level1ButtonCargo.whenPressed(new GoToLevel(1, false));
		level2ButtonCargo.whenPressed(new GoToLevel(2, false));
		level3ButtonCargo.whenPressed(new GoToLevel(3, false));

		// Intake commands for the preset angles
		// buttonIntakeStowedAngle.whenPressed(new GoToIntakeAngle(intakeStowedAngle));
		// buttonIntakeStowedAngle.whenPressed(new InTakeStow());
		// buttonIntakeScoreAngle.whenPressed(new GoToIntakeAngle(intakeScoreAngle));
		// buttonIntakeCargoAngle.whenPressed(new GoToIntakeAngle(intakeCargoAngle));
		// buttonIntakeFloorAngle.whenPressed(new GoToIntakeAngle(intakeFloorAngle));
		// buttonIntakeDownAngle.whenPressed(new GoToIntakeAngle(intakeDownAngle));
		
		// Buttons for the manual lift
		buttonManualLift.whileHeld(new LiftAxisCommand()); 
		buttonManualIntakeRotate.whileHeld(new InTakeAxisRotate());
		buttonManualIntakeInOut.whileHeld(new InTakeInOutAxis());
		buttonManualIntakeInOut.whenReleased(new InTakeStop());
		buttonManualClimbLift.whileHeld(new ClimbLiftJoystick());
		buttonManualClimbRoller.whileHeld(new ClimbRollerAxis());

	}

}
