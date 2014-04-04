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
		override = false;
	}
	
	@Override
	public boolean activate() {
		return !ctx.objects.select().id(Constants.TEASTALL).isEmpty() && !Helpers.isFull(ctx);
	}
	
	@Override
	public void execute() {
		long start = System.currentTimeMillis();
		System.out.println("Steal");
		GameObject stall = ctx.objects.poll();
		Condition.sleep(Random.getDelay());
		if(stall.inViewport()) {
			if(Helpers.chance(20)) {
				ctx.camera.turnTo(stall);
			}
			stall.hover();
			stall.interact("Steal-from");
			Condition.sleep(Random.nextInt(1500, 2000));
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
