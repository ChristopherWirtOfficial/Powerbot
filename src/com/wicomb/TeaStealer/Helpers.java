package com.wicomb.TeaStealer;

import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;

public class Helpers {
	public static boolean chance(double c) {
		int upper = (int)(100/c);
		
		return Random.nextInt(1, upper) == 1;
	}
	
	public static boolean isFull(ClientContext ctx) {
		return ctx.inventory.select().count() == 28;
	}
}
