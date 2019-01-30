package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.subsystems.DriveBaseShifterSubsystem;
import org.usfirst.frc.team2412.robot.subsystems.TempDriveBaseSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class CommandBase extends Command {
    public static TempDriveBaseSubsystem tempDriveBase = new TempDriveBaseSubsystem();
    public static DriveBaseShifterSubsystem driveShifters = new DriveBaseShifterSubsystem();
    
    @Override
    protected boolean isFinished() {
        return false;
    }
}