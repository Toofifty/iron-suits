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

public class ArmorSetExo extends ItemArmor {

	private String name;
	
	private static Map installedModuleList = new HashMap();

	public ArmorSetExo(ArmorMaterial par1ArmorMaterial,
			int par2, int par3, String par4Str) {
		super(par1ArmorMaterial, par2, par3);
		armorModel = IronSuits.proxy.getArmorModel(par3);
		this.setCreativeTab(IronSuits.tabIronSuits);
		this.setMaxStackSize(1);
		this.material = par1ArmorMaterial;
		this.setUnlocalizedName(par4Str);
		this.setMaxDamage(par1ArmorMaterial.getDurability(par3));
		this.setFull3D();
		this.name = par4Str;
		par1ArmorMaterial.getDamageReductionAmount(par3);
		resourceLocation = new ResourceLocation(IronSuits.ID, "textures/models/armor/" + par4Str + ".png");

	}
	
	public static void addModule(String module, int function) {
		if (!installedModuleList.containsKey(module)) {
			System.out.println("Module added!");
			installedModuleList.put(module, function);
		}
	}
	
	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) {
		super.onUpdate(itemStack, world, entity, par4, par5);
		
		if (installedModuleList.containsKey("lowProtect")) {
			int i = (Integer) installedModuleList.get("lowProtect");
			this.moduleFunction(itemStack, entity, i);
		}
		
	}
	
	public void moduleFunction(ItemStack itemStack, Entity entity, int i) {
		switch(i) {
		case 0:
			itemStack.addEnchantment(Enchantment.protection, 1);
		}
	}
	
	public ResourceLocation resourceLocation;

	public ArmorMaterial material;

	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {
		return IronSuits.ID + ":textures/models/armor/" + this.name + ".png";
	}

	public ModelArmorBase armorModel = new ModelArmorBase(1.0F);

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving,
			ItemStack itemStack, int armorSlot) {

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
			return (ModelBiped)armorModel;
		}

		return null;
	}

	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(IronSuits.ID + ":" + this.name);
	}

}
