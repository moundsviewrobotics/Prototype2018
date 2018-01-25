package org.usfirst.frc.team3407.robot.driveInput;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID;

public class JoystickDriveInput implements DriveInput {
	
	private Joystick left;
	private Joystick right;
	
	public JoystickDriveInput(int leftPort, int rightPort) {
		left = new Joystick(leftPort);
		right = new Joystick(rightPort);
	}
	
	@Override
	public TankDirective getTankDirective() {		
		return new TankDirective(left.getY(GenericHID.Hand.kRight), right.getY(GenericHID.Hand.kRight));
	}

}
