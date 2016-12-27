package shadows.ae2.growable.core;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ae2.growable.common.BlockAECrops;
import shadows.ae2.growable.common.ItemCropSeeds;


public class ModRegistry {

	public static BlockAECrops crop64k;
	public static ItemCropSeeds seed64k;
	public static ItemCropSeeds seed16k;
	public static BlockAECrops crop16k;
	public static ItemCropSeeds seed4k;
	public static BlockAECrops crop4k;
	public static ItemCropSeeds seed1k;
	public static BlockAECrops crop1k;
	
	public static void init() {
		crop64k = new BlockAECrops("crop64k", "storage_cell_64k");
		seed64k = new ItemCropSeeds("seed64k");
		crop16k = new BlockAECrops("crop16k", "storage_cell_16k");
		crop4k = new BlockAECrops("crop4k", "storage_cell_4k");
		crop1k = new BlockAECrops("crop1k", "storage_cell_1k");
		seed16k = new ItemCropSeeds("seed16k");
		seed4k = new ItemCropSeeds("seed4k");
		seed1k = new ItemCropSeeds("seed1k");
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels(){
		seed64k.initModel();
		crop64k.initModel();
		crop16k.initModel();
		crop4k.initModel();
		crop1k.initModel();
		seed16k.initModel();
		seed4k.initModel();
		seed1k.initModel();
	}
	
	
}
