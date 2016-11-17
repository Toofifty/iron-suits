package me.toofifty.ironsuits.init;

import me.toofifty.ironsuits.common.IronSuits;
import me.toofifty.ironsuits.item.ISItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemInit {

    public static Item ingotCopper;

    public static void init() {

        ingotCopper = new ISItem("copper_ingot");

    }

    public static void register() {

        GameRegistry.register(ingotCopper);

    }

    public static void registerRenders() {

        registerRender(ingotCopper);

    }

    private static void registerRender(Item item) {

        System.out.println(item.getRegistryName());

        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
                new ModelResourceLocation(item.getRegistryName(), "inventory"));

    }

}
