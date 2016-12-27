package shadows.ae2.growable.common;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ae2.growable.AE2Growable;
import shadows.ae2.growable.core.ModRegistry;

public class ItemCropSeeds extends ItemSeeds{
	public ItemCropSeeds(String regname) {
		super(ModRegistry.crop64k, Blocks.FARMLAND);
		setUnlocalizedName(AE2Growable.MODID + "." + regname);
		setRegistryName(regname);
		GameRegistry.register(this);
		this.setCreativeTab(CreativeTabs.MATERIALS);
	}
	
	
	@SideOnly(Side.CLIENT)
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
	
	
	
}
