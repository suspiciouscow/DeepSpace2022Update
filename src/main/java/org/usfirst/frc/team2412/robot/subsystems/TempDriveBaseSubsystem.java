package org.usfirst.frc.team2412.robot.subsystems;

import org.usfirst.frc.team2412.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class TempDriveBaseSubsystem extends Subsystem {
    private DifferentialDrive robotDrive = RobotMap.drive;

    @Override
    protected void initDefaultCommand() {
        // Drive with the joystick by default.
    }

    public void drive(double y, double turn) {
        robotDrive.arcadeDrive(y, turn, true);
    }

    public void drive(Joystick stick) {
        robotDrive.arcadeDrive(stick.getY(), -stick.getTwist()*0.8, true);
    }
}