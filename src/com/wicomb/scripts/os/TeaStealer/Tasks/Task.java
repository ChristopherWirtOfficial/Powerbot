package com.wicomb.scripts.os.TeaStealer.Tasks;

import org.powerbot.script.rt4.ClientAccessor;
import org.powerbot.script.rt4.ClientContext;

public abstract class Task extends ClientAccessor {
	
	// Override means "I don't care if it's busy, this needs to happen"
	// Should be determined in the activate method, otherwise it can never happen..
	// SHOULD ONLY BE USED IN CASES WHERE A REACTION IS IMPERITIVE
	public boolean override = false;
	public boolean busy = false;
	public boolean done = false;

	public Task(ClientContext ctx){
	super(ctx);
	}
	
	public abstract boolean activate();
	
	public abstract void execute();
	
}