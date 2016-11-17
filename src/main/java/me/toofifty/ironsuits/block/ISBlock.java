package me.toofifty.ironsuits.block;

import me.toofifty.ironsuits.common.IronSuits;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ISBlock extends Block {

    public ISBlock(Material mat, String name) {
        super(mat);
        setCreativeTab(IronSuits.tabIronSuits);
        setRegistryName(IronSuits.ID, name);
        setUnlocalizedName(name);
    }

}
