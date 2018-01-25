/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3407.robot.commands;

import edu.wpi.first.wpilibj.command.Command;



import org.usfirst.frc.team3407.robot.Robot;
import org.usfirst.frc.team3407.robot.driveInput.DriveInput;
import org.usfirst.frc.team3407.robot.driveInput.JoystickDriveInput;
import org.usfirst.frc.team3407.robot.driveInput.TankDirective;
import org.usfirst.frc.team3407.robot.subsystems.DriveSubsystem;

/**
 * An Drive command that
 */
public class DriveCommand extends Command {
	
	private DriveInput driveInput = new JoystickDriveInput(0, 1);
	private DriveSubsystem drive;
	
	public DriveCommand(DriveSubsystem drive) {
		this.drive = drive;
		
		// Use requires() here to declare subsystem dependencies
		requires(drive);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		TankDirective tankDirective = (driveInput == null) ? null : driveInput.getTankDirective();
		System.out.println("DriveCommand: tankDirective=" + tankDirective);
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
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
