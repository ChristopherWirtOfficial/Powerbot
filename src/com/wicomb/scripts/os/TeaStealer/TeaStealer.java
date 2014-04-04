package com.wicomb.scripts.os.TeaStealer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script.Manifest;
import org.powerbot.script.rt6.Skills;

import com.wicomb.scripts.os.TeaStealer.Tasks.BusyTask;
import com.wicomb.scripts.os.TeaStealer.Tasks.DropTask;
import com.wicomb.scripts.os.TeaStealer.Tasks.RandomTask;
import com.wicomb.scripts.os.TeaStealer.Tasks.StealTask;
import com.wicomb.scripts.os.TeaStealer.Tasks.Task;


@Manifest(name = "Wicomb's Tea Stealer", description = "Steals Tea and Drops/banks it",properties = "topic=90210;client=4;")
public class TeaStealer extends PollingScript<org.powerbot.script.rt4.ClientContext> implements PaintListener{
	
	long startTime = 0;
	int startLevel = 0;
	int startExp = 0;
	ArrayList<Task> tasks;
	Task busyTask = null; // This is used in cases like walking where I literally don't want anything to be done
	@Override
	public void start() {
		if(!ctx.game.loggedIn()) {
			System.out.println("Please start the script while logged in");
			ctx.controller.stop();
		}
		startTime = System.currentTimeMillis();
		startLevel = ctx.skills.levels()[Skills.THIEVING];
		startExp = ctx.skills.experiences()[Skills.THIEVING];
		tasks = new ArrayList<Task>();
		tasks.add(new BusyTask(ctx));
		tasks.add(new RandomTask(ctx));
		tasks.add(new DropTask(ctx));
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
		int currentLevel = ctx.skills.levels()[Skills.THIEVING];
		int currentExp = ctx.skills.experiences()[Skills.THIEVING];
		long elapsed = getTotalRuntime();
		int expGained = currentExp - startExp;
		if(elapsed == 0)
			elapsed = 1;
		int expPH = (int) (elapsed != 0 && expGained != 0 ? (expGained * (3600000d / elapsed))
			    : 0);
		
		
		Point o = new Point(280,240);
		String time = formatTime(elapsed);
		g.setColor(Color.CYAN);
		g.fillRect(o.x,o.y,235,95);
		g.setColor(Color.BLACK);
		g.drawString("Time running: "+time, o.x+10, o.y+20);
		g.drawString("Level: "+currentLevel+"("+(currentLevel-startLevel)+")", o.x+10, o.y+30);
		g.drawString("Experience Gained: "+(currentExp-startExp)+"("+(int)expPH+" xp/hr)", o.x+10, o.y+40);
	}
	public String formatTime(final long time) {
		  final int sec = (int) (time / 1000), h = sec / 3600, m = sec / 60 % 60, s = sec % 60;
		  return (h < 10 ? "0" + h : h) + ":" + (m < 10 ? "0" + m : m) + ":"
		    + (s < 10 ? "0" + s : s);
		 
	}
}
	