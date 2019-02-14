package org.usfirst.frc.team2412.robot;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team2412.robot.commands.CommandBase;
import org.usfirst.frc.team2412.robot.commands.LiftBottomReset;
import org.usfirst.frc.team2412.robot.commands.LiftTopReset;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {

	public static OI m_oi;

	CommandBase base = new CommandBase();

	public static long startTime = 0;

	public static DigitalOutput LED;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();

		Thread visionThread = new Thread(() -> {
			System.out.println("In thread");
			UsbCamera camera = new UsbCamera("Microsoft Lifecam", "/dev/video0");
			CameraServer.getInstance().addCamera(camera);
			camera.setResolution(640, 480);

			CvSink cvSink = CameraServer.getInstance().getVideo();
			CvSource outputStream = CameraServer.getInstance().putVideo("UsbCamera", 640, 480);

			Mat mat = new Mat();

			while (!Thread.interrupted()) {
				if (cvSink.grabFrame(mat) == 0) {
					outputStream.notifyError(cvSink.getError());
					continue;
				}
				Imgproc.cvtColor(mat, mat, Imgproc.COLOR_RGB2GRAY);
				outputStream.putFrame(mat);
			}
		});
		visionThread.setDaemon(true);
		visionThread.start();
		LED = new DigitalOutput(0);
		LED.set(false);
	}

	LiftBottomReset liftBottomReset = new LiftBottomReset();
	boolean liftBottomResetHeld = false;
	LiftTopReset liftTopReset = new LiftTopReset();
	boolean liftTopResetHeld = false;

	int counter = 0;

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		if (counter++ % 50 == 0) {
			System.out.println("Hello, world!");
		}

		if (RobotMap.liftBottomSwitch.get() && !liftBottomResetHeld) {
			liftBottomReset.execute();
			liftBottomResetHeld = true;
		} else if (!RobotMap.liftBottomSwitch.get()) {
			liftBottomResetHeld = false;
		}

		if (RobotMap.liftTopSwitch.get() && !liftTopResetHeld) {
			liftTopReset.execute();
			liftTopResetHeld = true;
		} else if (!RobotMap.liftTopSwitch.get()) {
			liftTopResetHeld = false;
		}
		
		
		PowerDistributionPanel powerPanel = RobotMap.powerPanel;
		
		double[] ids = new double[15];
		double[] power = new double[15];
		
		for(int i = 0; i<15; i++) {
			ids[i] = i+1;
			power[i] = powerPanel.getCurrent(i);
		}
		
		
		SmartDashboard.putNumberArray("Amps", power);
		SmartDashboard.putNumberArray("IDs", ids);
	}

}
