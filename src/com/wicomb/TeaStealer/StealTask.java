package com.wicomb.TeaStealer;

import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Movement;

public class StealTask extends Task {

	public StealTask(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean activate() {
		return !ctx.objects.select().id(Constants.TEASTALL).isEmpty();
	}
	
	@Override
	public void execute() {
		GameObject stall = ctx.objects.poll();
		Condition.sleep(Random.getDelay());
		if(stall.inViewport()) {
			stall.hover();
			stall.interact("Steal-from");
		} else {
			ctx.camera.turnTo(stall);
			if(stall.inViewport()) {
				return;
			} else {
				ctx.movement.step(stall);
				return;
			}
		}
	}
}
