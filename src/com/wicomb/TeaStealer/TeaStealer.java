package com.wicomb.TeaStealer;

import java.awt.Graphics;
import java.util.ArrayList;

import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script.Manifest;


@Manifest(name = "Wicomb's Tea Stealer", description = "Steals Tea and Drops/banks it",properties = "topic=90210;client=4;")
public class TeaStealer extends PollingScript<org.powerbot.script.rt4.ClientContext> implements PaintListener{
	
	ArrayList<Task> tasks;
	Task busyTask = null; // This is used in cases like walking where I literally don't want anything to be done
	@Override
	public void start() {
		tasks = new ArrayList<Task>();
		tasks.add(new BusyTask(ctx));
		tasks.add(new RandomTask(ctx));
		tasks.add(new BankTask(ctx));
		tasks.add(new StealTask(ctx));
		System.out.println("Script started");
	}
	
	@Override
	public void poll() {
		if(busyTask != null && busyTask.busy == false) {
			busyTask = null;
		} else {
			for(Task t : tasks) {
				
				if(this.busyTask == null && t.busy) this.busyTask = t;
				
				if(t.activate() && (this.busyTask == null || t.override || this.busyTask == t)) {
					t.execute();
				}
			}
		}
	}


	@Override
	public void repaint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(340,200, 100, 50);
	}
	
	
}
	