package shadows.ae2.growable.common;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ae2.growable.AE2Growable;

public class ItemCropSeeds extends ItemSeeds{
	public ItemCropSeeds(String regname) {
		super(Block.getBlockFromName("growablecells:crop" + regname.substring(4)), Blocks.FARMLAND);
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
