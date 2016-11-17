package me.toofifty.ironsuits.item;

import me.toofifty.ironsuits.common.IronSuits;
import net.minecraft.item.Item;

public class ISItem extends Item {

    public ISItem(String name) {
        setCreativeTab(IronSuits.tabIronSuits);
        setUnlocalizedName(name);
        setRegistryName(name);
    }



}
