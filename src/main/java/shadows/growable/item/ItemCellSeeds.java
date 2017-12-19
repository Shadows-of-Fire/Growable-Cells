package shadows.growable.item;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import shadows.growable.GrowableCells;
import shadows.growable.block.IGrowableCell;
import shadows.placebo.Placebo;
import shadows.placebo.client.IHasModel;
import shadows.placebo.interfaces.IPostInitUpdate;

public class ItemCellSeeds<T extends Block & IGrowableCell> extends ItemSeeds implements IHasModel, IPostInitUpdate {

	private final T crop;

	public ItemCellSeeds(T crop, String name) {
		super(crop, Blocks.FARMLAND);
		setRegistryName(GrowableCells.MODID, name);
		setUnlocalizedName(GrowableCells.MODID + "." + name);
		setCreativeTab(CreativeTabs.MATERIALS);
		this.crop = crop;
		GrowableCells.INFO.getItemList().add(this);
		Placebo.UPDATES.add(this);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		crop.setSeed(this);
	}
}
