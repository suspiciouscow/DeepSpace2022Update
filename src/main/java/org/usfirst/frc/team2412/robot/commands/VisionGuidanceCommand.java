package org.usfirst.frc.team2412.robot.commands;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class VisionGuidanceCommand extends CommandBase {
    private static final int PORT = 1111;

    private DatagramSocket socket = null;
    private DatagramPacket packet;
    private byte[] receiveData = new byte[1024];

    // private boolean teleopHappened = false;

    public VisionGuidanceCommand() {
        requires(tempDriveBase);
    }

    @Override
    protected void initialize() {
        try {
            socket = new DatagramSocket(PORT);
        } catch(SocketException e) {
            System.err.println("Could not create socket: ");
            e.printStackTrace();
        }
    }

    @Override
    protected void execute() {
        // tempDriveBase.drive(Robot.m_oi.stick);
        try {
            packet = new DatagramPacket(receiveData, receiveData.length);
            System.out.println("Receiving message...");
            socket.receive(packet);
    
            receiveData = packet.getData();
            String receiveString = (new String(receiveData)).trim();
            // System.out.println(receiveString.length());
            System.out.println(receiveString);
    
            receiveData = new byte[1024]; // Clear the data.
          } catch(Exception e) {
            System.out.println("exception happened");
          }
    }

    @Override
    protected void end() {
        if(socket != null) {
            socket.close();
            System.out.println("Closing...");
        }
    }
}