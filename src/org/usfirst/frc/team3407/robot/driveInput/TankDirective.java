package org.usfirst.frc.team3407.robot.driveInput;

public class TankDirective {
	
	private double leftSpeed;
	private double rightSpeed;
	
	public TankDirective(double leftSpeed, double rightSpeed) {
		this.leftSpeed = leftSpeed;
		this.rightSpeed = rightSpeed;
	}
	
	public double getLeftSpeed() {
		return leftSpeed;
	}
	
	public double getRightSpeed() {
		return rightSpeed;
	}
	
	public String toString() {
		return "{left=" + leftSpeed + ",right=" + rightSpeed + "}";
	}
}
