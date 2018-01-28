/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3407.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3407.robot.driveInput.DriveInput;
import org.usfirst.frc.team3407.robot.driveInput.TankDirective;
import org.usfirst.frc.team3407.robot.subsystems.DriveSubsystem;

/**
 * An Drive command that
 */
public class DriveInputDriveCommand extends Command {
	
	private DriveSubsystem drive;
	private DriveInput driveInput;
	
	public DriveInputDriveCommand(DriveSubsystem drive, DriveInput driveInput) {
		this.drive = drive;
		this.driveInput = driveInput;
		
		// Depends on the drive subsystem
		requires(drive);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		log("initialize", null);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		TankDirective tankDirective = (driveInput == null) ? null : driveInput.getTankDirective();
		log("execute", "tankDirective=" + tankDirective);
		if (tankDirective == null) {
			drive.stop();
		}
		else {
			drive.drive(tankDirective.getLeftSpeed(), tankDirective.getRightSpeed());
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		log("isFinished", "false");
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		log("end", null);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		log("interrupted", null);
	}
	
	protected void log(String method, String message) {
		StringBuilder buffer = new StringBuilder();
		buffer.append(getClass().getName()).append(".").append(method).append("()");
		if (message != null) {
			buffer.append(": ").append(message);
		}
		System.out.println(buffer.toString());		
	}
}
