package com.wicomb.scripts.os.TeaStealer.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

import com.wicomb.scripts.os.TeaStealer.Constants;
import com.wicomb.scripts.os.TeaStealer.Helpers;

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
