package com.wicomb.scripts.os.TeaStealer.Tasks;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;

import com.wicomb.scripts.os.TeaStealer.Constants;
import com.wicomb.scripts.os.TeaStealer.Helpers;

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
		}
	}
}
