package me.toofifty.ironsuits.common;

import me.toofifty.ironsuits.model.ModelArmor;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {
	
	public void init() {
		MinecraftForge.EVENT_BUS.register(new TickHandler());
		
	}
	
	public void registerRenderInformation() {
		
	}
	
	public ModelArmor getArmorModel(int id) {
		return null;
	}

}
