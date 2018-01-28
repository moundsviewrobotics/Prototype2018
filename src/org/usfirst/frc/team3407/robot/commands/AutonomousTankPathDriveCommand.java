package org.usfirst.frc.team3407.robot.commands;

import java.util.concurrent.TimeUnit;

import org.usfirst.frc.team3407.robot.driveInput.TankDirective.TankManeuver;
import org.usfirst.frc.team3407.robot.driveInput.TankHeading;
import org.usfirst.frc.team3407.robot.driveInput.TankPathDriveInput;
import org.usfirst.frc.team3407.robot.subsystems.DriveSubsystem;

public class AutonomousTankPathDriveCommand extends DriveInputDriveCommand {
	
	public enum TankPath {
		
		DRIVE_FORWARD(new TankHeading[] {
				new TankHeading(TankManeuver.FORWARD, 400, TimeUnit.MILLISECONDS),	
		}),

		DRIVE_TO_SWITCH(new TankHeading[] {
				new TankHeading(TankManeuver.FORWARD, 300, TimeUnit.MILLISECONDS),	
				new TankHeading(TankManeuver.LEFT, 200, TimeUnit.MILLISECONDS),	
				new TankHeading(TankManeuver.FORWARD, 300, TimeUnit.MILLISECONDS),	
		});
		
		protected TankHeading[] path;
		private TankPath(TankHeading[] path) {
			this.path = path;
		}
	}
	
	public AutonomousTankPathDriveCommand(DriveSubsystem drive, TankPath tankPath) {
		super(drive, new TankPathDriveInput(tankPath.path));
	}
}
