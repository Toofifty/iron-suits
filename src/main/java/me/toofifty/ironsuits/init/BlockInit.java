package me.toofifty.ironsuits.init;

import me.toofifty.ironsuits.block.ISBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockInit {

    public static Block oreCopper;

    public static void init() {

        oreCopper = new ISBlock(Material.ROCK, "copper_ore");

    }

    public static void render() {

        registerBlock(oreCopper);

    }

    private static void registerBlock(Block block) {

        GameRegistry.register(block);
        ItemBlock item = new ItemBlock(block);
        item.setRegistryName(block.getRegistryName());
        GameRegistry.register(item);


    }

    public static void registerRenders() {

        registerRender(oreCopper);

    }

    public static void registerRender(Block block) {

        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0,
                new ModelResourceLocation(block.getRegistryName(), "inventory"));

    }

}
