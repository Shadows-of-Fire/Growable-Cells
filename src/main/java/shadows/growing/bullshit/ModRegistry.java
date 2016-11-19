package shadows.growing.bullshit;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModRegistry {

	public static BlockAECrops crop64k;
	public static ItemCropSeeds itemMESeed;
	public static ItemCropSeeds16k itemMESeed16k;
	public static BlockAECrops16k crop16k;
	public static ItemCropSeeds4k itemMESeed4k;
	public static BlockAECrops4k crop4k;
	public static ItemCropSeeds1k itemMESeed1k;
	public static BlockAECrops1k crop1k;
	
	public static void init() {
		crop64k = new BlockAECrops();
		itemMESeed = new ItemCropSeeds();
		crop16k = new BlockAECrops16k();
		crop4k = new BlockAECrops4k();
		crop1k = new BlockAECrops1k();
		itemMESeed16k = new ItemCropSeeds16k();
		itemMESeed4k = new ItemCropSeeds4k();
		itemMESeed1k = new ItemCropSeeds1k();
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels(){
		itemMESeed.initModel();
		crop64k.initModel();
		crop16k.initModel();
		crop4k.initModel();
		crop1k.initModel();
		itemMESeed16k.initModel();
		itemMESeed4k.initModel();
		itemMESeed1k.initModel();
	}
	
	
}
