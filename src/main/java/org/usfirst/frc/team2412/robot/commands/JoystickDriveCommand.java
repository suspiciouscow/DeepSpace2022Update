package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.Robot;

public class JoystickDriveCommand extends CommandBase {
    public JoystickDriveCommand() {
        requires(tempDriveBase);
    }
    private double turnPower = 0.8;
    @Override
    protected void execute() {
        double throttleVal = (Robot.m_oi.stick.getThrottle()-1)/-2.0;
        tempDriveBase.drive(Robot.m_oi.stick.getY()*throttleVal,Robot.m_oi.stick.getTwist()*turnPower*throttleVal);
    }
}   