package com.wicomb.TeaStealer;

import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;

public class DropTask extends Task {

	public DropTask(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return Helpers.isFull(ctx);
	}

	@Override
	public void execute() {
		System.out.println("Drop");
		for(Item i : ctx.inventory.select().id(Constants.TEA_ITEM)) {
				i.interact("Drop");
				Condition.sleep(Random.getDelay());
		}
	}
}
