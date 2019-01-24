package org.usfirst.frc.team2412.robot.triggers;

import edu.wpi.first.wpilibj.buttons.Trigger;

public class MultipleButtons extends Trigger {
	private Trigger[] triggers;
	
	public MultipleButtons(Trigger ...triggers) {
		this.triggers = triggers;
	}
	
	@Override
	public boolean get() {
		for(Trigger trig : triggers) {
			if(!trig.get()) {
				return false;
			}
		}
		return true;
	}

}
