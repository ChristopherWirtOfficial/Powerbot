package com.wicomb.TeaStealer;

import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

public class RandomTask extends Task {

	public RandomTask(ClientContext ctx) {
		super(ctx);
		override = true;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return Helpers.chance(1);
	}

	@Override
	public void execute() {
		// Literally just start looking at random shit
		System.out.println("Randoming");
		GameObject o = ctx.objects.select().shuffle().poll();
		ctx.camera.turnTo(o); 
		Condition.sleep(Random.nextInt(200,500));
	}

}
