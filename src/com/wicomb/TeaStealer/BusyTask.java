package com.wicomb.TeaStealer;

import org.powerbot.script.rt4.ClientContext;

public class BusyTask extends Task {

	public BusyTask(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		busy = ctx.players.local().inMotion();
		return false;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
