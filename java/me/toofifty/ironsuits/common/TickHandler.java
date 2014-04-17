package me.toofifty.ironsuits.common;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;

public class TickHandler {
	
	public TickHandler() {
	}

	@SubscribeEvent
	public void onTick(TickEvent event) {
		//IronSuits.rotator += 0.01F;
		IronSuits.rotator += 0.5F;
		if (IronSuits.rotator > 360) IronSuits.rotator -= 360;
	}
}
