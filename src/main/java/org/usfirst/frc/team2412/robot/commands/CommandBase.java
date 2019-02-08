package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.subsystems.DriveBaseShifterSubsystem;
import org.usfirst.frc.team2412.robot.subsystems.TempDriveBaseSubsystem;
import org.usfirst.frc.team2412.robot.subsystems.ClimbLiftSubsystem;
import org.usfirst.frc.team2412.robot.subsystems.ClimbPneumaticsSubsystem;
import org.usfirst.frc.team2412.robot.subsystems.ClimbRollerSubsystem;
import org.usfirst.frc.team2412.robot.subsystems.InTakeCargoSubsystem;
import org.usfirst.frc.team2412.robot.subsystems.InTakeHatchSubsystem;
import org.usfirst.frc.team2412.robot.subsystems.InTakeUpDownSubsystem;
import org.usfirst.frc.team2412.robot.subsystems.LiftSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class CommandBase extends Command {
    public static TempDriveBaseSubsystem tempDriveBase = new TempDriveBaseSubsystem();
    public static DriveBaseShifterSubsystem driveShifters = new DriveBaseShifterSubsystem();
    
    @Override
    protected boolean isFinished() {
        return false;
    }
	
	public static InTakeUpDownSubsystem inTakeUpDown = new InTakeUpDownSubsystem();
	public static InTakeCargoSubsystem inTakeCargo = new InTakeCargoSubsystem();
	public static InTakeHatchSubsystem inTakeHatch = new InTakeHatchSubsystem();
	public static ClimbPneumaticsSubsystem climbPneumatics = new ClimbPneumaticsSubsystem();
	public static ClimbRollerSubsystem climbRoller = new ClimbRollerSubsystem();
	public static ClimbLiftSubsystem climbLift = new ClimbLiftSubsystem();

	static LiftSubsystem liftSubsystem = new LiftSubsystem();
		

}
