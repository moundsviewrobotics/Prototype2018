/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3407.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import org.usfirst.frc.team3407.robot.commands.DriveCommand;

/**
 * A Drive subsystem that  .... 
 */
public class DriveSubsystem extends Subsystem {

	private DifferentialDrive drive;
	
	public DriveSubsystem(SpeedController leftMotor, SpeedController rightMotor) {
		drive = new DifferentialDrive(leftMotor, rightMotor);		
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new DriveCommand(this));
	}
	
	public void stop() {
		drive.tankDrive(0, 0);
	}
	
	public void drive(double leftSpeed, double rightSpeed) {
		drive.tankDrive(leftSpeed, rightSpeed);
	}	
}
