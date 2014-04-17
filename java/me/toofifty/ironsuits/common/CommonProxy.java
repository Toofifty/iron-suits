package me.toofifty.ironsuits.common;

import me.toofifty.ironsuits.model.ModelArmorBase;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {
	
	public void init() {
		MinecraftForge.EVENT_BUS.register(new TickHandler());
		
	}
	
	public void registerRenderInformation() {
		
	}
	
	public ModelArmorBase getArmorModel(int id) {
		return null;
	}

}
