package com.wicomb.TeaStealer;

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
		Condition.sleep(Random.nextInt(400, 600));
		return false;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
