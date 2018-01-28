package org.usfirst.frc.team3407.robot.driveInput;

import java.util.concurrent.TimeUnit;

public class TankHeading {
	
	private TankDirective 	directive;
	private long			duration;
	private TimeUnit		durationUnit;
	
	public TankHeading(TankDirective.TankManeuver maneuver, long duration, TimeUnit durationUnit) {
		super();
		this.directive = new TankDirective(maneuver);
		this.duration = duration;
		this.durationUnit = durationUnit;
	}

	public TankHeading(TankDirective directive, long duration, TimeUnit durationUnit) {
		super();
		this.directive = directive;
		this.duration = duration;
		this.durationUnit = durationUnit;
	}

	public TankDirective getDirective() {
		return directive;
	}

	public long getDuration() {
		return duration;
	}

	public TimeUnit getDurationUnit() {
		return durationUnit;
	}
}
