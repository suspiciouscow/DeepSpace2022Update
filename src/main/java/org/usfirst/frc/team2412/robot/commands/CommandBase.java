package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.subsystems.TempDriveBaseSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class CommandBase extends Command {
    public static TempDriveBaseSubsystem tempDriveBase = new TempDriveBaseSubsystem();
    
    @Override
    protected boolean isFinished() {
        return false;
    }
}