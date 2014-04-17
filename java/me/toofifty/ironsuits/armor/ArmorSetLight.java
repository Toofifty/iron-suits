package me.toofifty.ironsuits.armor;

import java.util.HashMap;
import java.util.Map;

import me.toofifty.ironsuits.common.IronSuits;
import me.toofifty.ironsuits.model.ModelArmorBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorSetLight extends ArmorBase {

	public ArmorSetLight(ArmorMaterial par1ArmorMaterial,
			int par2, int par3, String par4Str) {
		super(par1ArmorMaterial, par2, par3, par4Str, par3 + 4);

	}

}
