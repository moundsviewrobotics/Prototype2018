package org.usfirst.frc.team3407.robot.driveInput;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class NetworkTableDriveInput implements DriveInput {
	
	public static final String		LEFT_SPEED_KEY = "leftSpeed";
	public static final String		RIGHT_SPEED_KEY = "rightSpeed";
	public static final String		COMPLETE_KEY = "complete";
	
	private NetworkTable table;
	
	public NetworkTableDriveInput(NetworkTable table) {
		this.table = table;
	}

	public NetworkTableDriveInput(String tablePath) {
		this(NetworkTableInstance.create().getTable(tablePath));
	}

	@Override
	public TankDirective getTankDirective() {
		return new TankDirective(table.getEntry(LEFT_SPEED_KEY).getDouble(0.0), table.getEntry(RIGHT_SPEED_KEY).getDouble(0.0));
	}

	@Override
	public boolean isComplete() {
		return table.getEntry(COMPLETE_KEY).getBoolean(false);
	}
}
