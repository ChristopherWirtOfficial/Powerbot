package com.wicomb.TeaStealer;

import java.awt.Graphics;
import org.powerbot.script.Condition;
import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Random;
import org.powerbot.script.Script.Manifest;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Item;


@Manifest(name = "Wicomb's Tea Stealer", description = "Steals Tea and Drops/banks it",properties = "topic=90210;client=4;")
public class TeaStealer extends PollingScript<org.powerbot.script.rt4.ClientContext> implements PaintListener{
	
	
	public TeaStealer() {
		getExecQueue(State.START).offer(new Runnable() {
			 
	        @Override
	        public void run() {
	            System.out.println("Script started");
	        }
	    });
	} 
	
	
	@Override
	public void poll() {
		Condition.sleep(Random.getDelay());
		
		if(ctx.inventory.select().count() == 28) {
			System.out.println("FULL!!!!");
			for(Item i : ctx.inventory.select().id(1979)) {
				Condition.sleep(Random.getDelay());
				i.interact("Drop");
			}
		}
		//Condition.sleep(Random.getDelay());
		if(ctx.objects.select().id(635).within(5).isEmpty()) {
			Condition.sleep(Random.getDelay());
		} else {
			
			for(final GameObject stall : ctx.objects) {
				System.out.println("Found!");
				Condition.sleep(Random.getDelay());
				stall.hover();
				Condition.sleep(Random.getDelay());
				stall.click();
				Condition.sleep(1500);
			}
		}
		// TODO Auto-generated method stub
		
	}


	@Override
	public void repaint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(340,200, 100, 50);
	}
	
	
}
	