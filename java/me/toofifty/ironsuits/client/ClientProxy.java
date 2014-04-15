package me.toofifty.ironsuits.client;

import me.toofifty.ironsuits.common.CommonProxy;
import me.toofifty.ironsuits.common.IronSuits;
import me.toofifty.ironsuits.model.ModelExoBoots;
import me.toofifty.ironsuits.model.ModelExoChest;
import me.toofifty.ironsuits.model.ModelExoHelmet;
import me.toofifty.ironsuits.model.ModelExoLegs;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
	
	public void registerRenderInformation() {
		
	}
	
	private static final ModelExoHelmet exoHelmet = new ModelExoHelmet(1.0F);
	private static final ModelExoChest exoChest = new ModelExoChest(1.0F);
	private static final ModelExoLegs exoLegs = new ModelExoLegs(1.0F);
	private static final ModelExoBoots exoBoots = new ModelExoBoots(1.0F);
	
	@Override
	public ModelBiped getArmorModel(int id) {
		switch (id) {
		case 0:
			return exoHelmet;
		case 1:
			return exoChest;
		case 2:
			return exoLegs;
		case 3:
			return exoBoots;
		}
		return exoHelmet;
	}

}
