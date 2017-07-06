package shadows.growable.common;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.growable.GrowableCells;
import shadows.growable.core.ModRegistry;

public class ItemModSeeds extends ItemSeeds {
	public ItemModSeeds(Block crop, String regname) {
		super(crop, Blocks.FARMLAND);
		setUnlocalizedName(GrowableCells.MODID + "." + regname);
		setRegistryName(regname);
		ModRegistry.ITEMS.add(this);
		this.setCreativeTab(CreativeTabs.MATERIALS);
	}

	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
