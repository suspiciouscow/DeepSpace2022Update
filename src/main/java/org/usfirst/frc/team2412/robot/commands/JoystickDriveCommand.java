package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.Robot;

public class JoystickDriveCommand extends CommandBase {
    public JoystickDriveCommand() {
        requires(tempDriveBase);
    }

    @Override
    protected void execute() {
        tempDriveBase.drive(Robot.m_oi.stick);
    }
}