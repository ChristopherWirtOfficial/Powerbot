package com.wicomb.TeaStealer;

import java.awt.Graphics;
import java.util.ArrayList;

import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script.Manifest;


@Manifest(name = "Wicomb's Tea Stealer", description = "Steals Tea and Drops/banks it",properties = "topic=90210;client=4;")
public class TeaStealer extends PollingScript<org.powerbot.script.rt4.ClientContext> implements PaintListener{
	
	ArrayList<Task> tasks;
	@Override
	public void start() {
		tasks = new ArrayList<Task>();
		tasks.add(new DropTask(ctx));
		tasks.add(new StealTask(ctx));
		System.out.println("Script started");
	}
	
	@Override
	public void poll() {
		for(Task t : tasks) {
			if(t.activate()) {
				t.execute();
			}
		}
	}


	@Override
	public void repaint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(340,200, 100, 50);
	}
	
	
}
	