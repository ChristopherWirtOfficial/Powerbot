package com.wicomb.scripts.os.TeaStealer.Tasks;

import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;

public class BusyTask extends Task {

	public BusyTask(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		busy = ctx.players.local().inMotion();
		return busy;
	}

	@Override
	public void execute() {
		System.out.println("In busy...?");
		Condition.sleep(Random.nextInt(100, 200));

	}

}
