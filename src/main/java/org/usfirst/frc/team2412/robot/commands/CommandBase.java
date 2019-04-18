package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.subsystems.DriveBaseShifterSubsystem;
import org.usfirst.frc.team2412.robot.subsystems.DriveBaseSubsystem;
import org.usfirst.frc.team2412.robot.subsystems.ClimbLiftSubsystem;
import org.usfirst.frc.team2412.robot.subsystems.ClimbPneumaticsSubsystem;
import org.usfirst.frc.team2412.robot.subsystems.ClimbRollerSubsystem;
import org.usfirst.frc.team2412.robot.subsystems.InTakeCargoSubsystem;
import org.usfirst.frc.team2412.robot.subsystems.InTakeUpDownSubsystem;
import org.usfirst.frc.team2412.robot.subsystems.LiftSubsystem;
import org.usfirst.frc.team2412.robot.subsystems.HatchIntake;
import org.usfirst.frc.team2412.robot.subsystems.HatchSensors;

import edu.wpi.first.wpilibj.command.Command;

public class CommandBase extends Command {
	public static DriveBaseSubsystem driveBase = new DriveBaseSubsystem();
	public static DriveBaseShifterSubsystem driveShifters = new DriveBaseShifterSubsystem();
	public static InTakeUpDownSubsystem inTakeUpDown = new InTakeUpDownSubsystem(0.02, 0, 0);
	public static InTakeCargoSubsystem inTakeCargo = new InTakeCargoSubsystem();
	public static ClimbPneumaticsSubsystem climbPneumatics = new ClimbPneumaticsSubsystem();
	public static ClimbRollerSubsystem climbRoller = new ClimbRollerSubsystem();
	public static ClimbLiftSubsystem climbLift = new ClimbLiftSubsystem();
	public static LiftSubsystem liftSubsystem = new LiftSubsystem();
	public static HatchIntake pistonMove = new HatchIntake();
	public static HatchSensors hatchSensors = new HatchSensors();
	
	@Override
	protected boolean isFinished() {
		return false;
	}
}
