package com.wicomb.scripts.os.TeaStealer.Tasks;

import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;

import com.wicomb.scripts.os.TeaStealer.Constants;
import com.wicomb.scripts.os.TeaStealer.Helpers;
public class BankTask extends Task {

	public BankTask(ClientContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return Helpers.isFull(ctx);
	}

	@Override
	public void execute() {
		if(ctx.bank.opened()) {
			// Change this if expanded to things like Master Farmer (Though probably won't bank for that)
			ctx.bank.depositInventory();
		}
		Item bankStall= ctx.bank.select().shuffle().poll();
		System.out.println(ctx.players.local().tile().distanceTo(Constants.bankTile));
		if(ctx.players.local().tile().distanceTo(Constants.bankTile) < 4) {
			System.out.println("Banking");
		} else {
			System.out.println("Moving!");
			ctx.movement.step(Constants.bankTile.derive(Random.nextInt(0, 4),0));
		}
	}

}
