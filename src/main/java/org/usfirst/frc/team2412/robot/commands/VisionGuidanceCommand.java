package org.usfirst.frc.team2412.robot.commands;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.text.ParseException;

import org.usfirst.frc.team2412.robot.Robot;

public class VisionGuidanceCommand extends CommandBase {
    private static final int PORT = 1111;

    private DatagramSocket socket = null;
    private DatagramPacket packet;
    private byte[] receiveData = new byte[1024];

    private boolean targetsFound = false;

    // private boolean teleopHappened = false;

    public VisionGuidanceCommand() {
        requires(tempDriveBase);
    }

    @Override
    protected void initialize() {
        try {
            socket = new DatagramSocket(PORT);
            socket.setSoTimeout(20);
        } catch(SocketException e) {
            System.err.println("Could not create socket: ");
            e.printStackTrace();
        }
    }

    @Override
    protected void execute() {
        try {
            packet = new DatagramPacket(receiveData, receiveData.length);
            System.out.println("Receiving message...");
            socket.receive(packet);
            receiveData = packet.getData();
            String receiveString = (new String(receiveData)).trim();
            // System.out.println(receiveString.length());
            System.out.println(receiveString);
            
            // Parse the string into angle, distance, doextake, and targets found values.
            String[] visionData = receiveString.split(";");
            if(visionData.length != 4) {
            	throw new ParseException("Not the right number of values received!", visionData.length - 1);
            }
            
            double angle = Double.parseDouble(visionData[0]);
//            double distance = Double.parseDouble(visionData[1]);
//            boolean doextake = Boolean.parseBoolean(visionData[2]);
            targetsFound = Boolean.parseBoolean(visionData[3]);
            
            /*if(targetsFound) {
            	// angle = (Math.abs(angle) > 0.03) ? angle : 0;
                tempDriveBase.drive(-0.4, angle);
                System.out.println("Angle: " + angle);
            } else {
            	System.err.println("No targets found!");
            }*/
            
            receiveData = new byte[1024]; // Clear the data.
          } catch(SocketTimeoutException e) {
            System.err.println("Timed out waiting for raspberry pi data.");
          } catch(Exception e) {
            System.out.println("exception happened");
          }
    }

    @Override
    protected boolean isFinished() {
        return targetsFound;
    }

    @Override
    protected void end() {
        if(socket != null) {
            socket.close();
            System.out.println("Closing...");
        }
        System.out.println("Latency: " + (System.nanoTime() - Robot.startTime));
        Robot.startTime = System.nanoTime();
    }
}