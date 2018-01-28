package org.usfirst.frc.team3407.robot.driveInput;

public class TankDirective {
	
	public enum TankManeuver {

		FORWARD(0.5, 0.5),
		REVERSE(-0.5, -0.5),
		LEFT(-0.5, 0.5),
		RIGHT(0.5, -0.5);

		private double leftSpeed;
		private double rightSpeed;
		private TankManeuver(double leftSpeed, double rightSpeed) {
			this.leftSpeed = leftSpeed;
			this.rightSpeed = rightSpeed;
		}
	}

	private double leftSpeed;
	private double rightSpeed;
	
	public TankDirective(TankManeuver maneuver) {
		this(maneuver.leftSpeed, maneuver.rightSpeed);
	}

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
