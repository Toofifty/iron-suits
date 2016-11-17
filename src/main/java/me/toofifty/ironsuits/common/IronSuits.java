package me.toofifty.ironsuits.common;

import me.toofifty.ironsuits.block.ISBlock;
import me.toofifty.ironsuits.init.BlockInit;
import me.toofifty.ironsuits.init.ItemInit;
import me.toofifty.ironsuits.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = IronSuits.ID, name = IronSuits.NAME, version = IronSuits.VERSION)
public class IronSuits {

    @Mod.Instance(value = IronSuits.ID)
    public static IronSuits instance;

    @SidedProxy(clientSide = "me.toofifty.ironsuits.proxy.ClientProxy", serverSide = "me.toofifty.ironsuits.proxy.ServerProxy")
    public static CommonProxy proxy;

    public static final String ID = "ironsuits";
    public static final String VERSION = "1.10-0.1";
    public static final String NAME = "Toofifty's Iron Suits";

    // Creative Tab
    public static CreativeTabs tabIronSuits;

    /**
     * Blocks
     */
    public static Block oreCopper;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        ItemInit.init();
        ItemInit.register();

        BlockInit.init();
        BlockInit.render();

    }

    @Mod.EventHandler
    public void initialize(FMLInitializationEvent event) {

        proxy.init();

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

}
