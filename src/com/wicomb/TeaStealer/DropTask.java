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
		return ctx.inventory.select().count() == 28;
	}

	@Override
	public void execute() {
		while(!ctx.inventory.select().id(Constants.TEA_ITEM).isEmpty())
		for(Item i : ctx.inventory.select().id(Constants.TEA_ITEM)) {
			Condition.sleep(Random.getDelay());
			i.interact("Drop");
		}
	}

}
