package com.wicomb.TeaStealer;

import org.powerbot.script.Random;

public class Helpers {
	public static boolean chance(double c) {
		int upper = (int)(100/c);
		
		return Random.nextInt(1, upper) == 1;
	}
}
