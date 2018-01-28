package org.usfirst.frc.team3407.robot.driveInput;

public class TankPathDriveInput implements DriveInput {
	
	private TankHeading[] tankPath;
	
	private long 	startTime = 0;
	private int		index = 0;
	private long 	pathDuration = 0;

	public TankPathDriveInput(TankHeading[] tankPath) {
		this.tankPath = (tankPath == null) ? new TankHeading[0] : tankPath;
	}
	
	public boolean isStarted() {
		return (startTime > 0);
	}
	
	public void start() {
		startTime = System.currentTimeMillis();
	}

	@Override
	public TankDirective getTankDirective() {
		long currentTime = System.currentTimeMillis();
		
		TankDirective directive = null;
		if (isStarted()) {
			long currentDuration = (currentTime - startTime) - pathDuration;
			System.out.println("TankPathDriveInput.getTankDirective(): duration=" + currentDuration);
			while(index < tankPath.length) {
				TankHeading heading = tankPath[index];
				long headingDurationMillis = heading.getDurationUnit().toMillis(heading.getDuration());
				System.out.println("TankPathDriveInput.getTankDirective(): index=" + index + " headingDuration=" + 
						headingDurationMillis + " pathDuration=" + pathDuration);
				if (currentDuration < headingDurationMillis) {
					directive = heading.getDirective();
					break;
				}
				pathDuration += headingDurationMillis;
				index++;
			}			
		}
		
		return directive;
	}

	@Override
	public boolean isComplete() {
		System.out.println("TankPathDriveInput.isComplete(): index=" + index + " pathLength=" + tankPath.length);
		return (index >= tankPath.length);
	}
}
