package me.toofifty.ironsuits.armor;

import me.toofifty.ironsuits.common.IronSuits;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorSetExo extends ItemArmor {

	public ArmorSetExo(ArmorMaterial par1ArmorMaterial,
			int par2, int par3, String par4Str) {
		super(par1ArmorMaterial, par2, par3);
		this.setCreativeTab(IronSuits.tabIronSuits);
		this.setMaxStackSize(1);
		this.material = par1ArmorMaterial;
		this.setUnlocalizedName(par4Str);
		this.setMaxDamage(par1ArmorMaterial.getDurability(par3));
		par1ArmorMaterial.getDamageReductionAmount(par3);

	}

	public ArmorMaterial material;

	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {
		return IronSuits.ID + ":textures/models/armor/" + this.getUnlocalizedName().substring(5).replace(".name", "") + ".png";
	}

	ModelBiped armorModel = new ModelBiped();

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving,
			ItemStack itemStack, int armorSlot) {
		if (itemStack != null) {
			if (itemStack.getItem() instanceof ArmorSetExo) {
				armorModel = IronSuits.proxy.getArmorModel(armorSlot);
			}
		}

		if (armorModel != null) {
			armorModel.bipedHead.showModel = armorSlot == 0;
			armorModel.bipedHeadwear.showModel = armorSlot == 0;
			armorModel.bipedBody.showModel = armorSlot == 1 || armorSlot == 2;
			armorModel.bipedRightArm.showModel = armorSlot == 1;
			armorModel.bipedLeftArm.showModel = armorSlot == 1;
			armorModel.bipedRightLeg.showModel = armorSlot == 2
					|| armorSlot == 3;
			armorModel.bipedLeftLeg.showModel = armorSlot == 2
					|| armorSlot == 3;

			armorModel.isSneak = entityLiving.isSneaking();
			armorModel.isRiding = entityLiving.isRiding();
			armorModel.isChild = entityLiving.isChild();
			armorModel.heldItemRight = entityLiving.getHeldItem() != null ? 1
					: 0;
			if (entityLiving instanceof EntityPlayer) {
				armorModel.aimedBow = ((EntityPlayer) entityLiving)
						.getItemInUseDuration() > 2;
			}
			return armorModel;
		}

		return null;
	}

	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(IronSuits.ID + ":" + this.getUnlocalizedName().substring(5).replace(".name", ""));
	}

}
