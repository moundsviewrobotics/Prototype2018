/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3407.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	private static final int DRIVE_TRAIN_LEFT_MOTOR_A = 0;
	private static final int DRIVE_TRAIN_LEFT_MOTOR_B = 1;
	private static final int DRIVE_TRAIN_RIGHT_MOTOR_A = 2;
	private static final int DRIVE_TRAIN_RIGHT_MOTOR_B = 3;

	public static SpeedController DRIVE_TRAIN_LEFT_SPEED_CONTROLLER =
			new SpeedControllerGroup(new Victor(DRIVE_TRAIN_LEFT_MOTOR_A), new Victor(DRIVE_TRAIN_LEFT_MOTOR_B));
	public static SpeedController DRIVE_TRAIN_RIGHT_SPEED_CONTROLLER =
			new SpeedControllerGroup(new Victor(DRIVE_TRAIN_RIGHT_MOTOR_A), new Victor(DRIVE_TRAIN_RIGHT_MOTOR_B));
}
