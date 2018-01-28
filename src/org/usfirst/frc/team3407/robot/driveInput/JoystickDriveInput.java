package org.usfirst.frc.team3407.robot.driveInput;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID;

public class JoystickDriveInput implements DriveInput {
	
	private Joystick left;
	private Joystick right;
	
	public JoystickDriveInput(Joystick left, Joystick right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public TankDirective getTankDirective() {		
		return new TankDirective(left.getY(GenericHID.Hand.kRight), right.getY(GenericHID.Hand.kRight));
	}

	@Override
	public boolean isComplete() {
		// Always provide input 
		return false;
	}
}
