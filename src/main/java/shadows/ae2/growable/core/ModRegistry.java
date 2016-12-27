package shadows.ae2.growable.core;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ae2.growable.common.BlockSpatialCellCrop;
import shadows.ae2.growable.common.BlockStorageCellCrop;
import shadows.ae2.growable.common.ItemSpatialCellSeeds;
import shadows.ae2.growable.common.ItemStorageCellSeeds;


public class ModRegistry {

	public static BlockStorageCellCrop crop64k;
	public static ItemStorageCellSeeds seed64k;
	public static ItemStorageCellSeeds seed16k;
	public static BlockStorageCellCrop crop16k;
	public static ItemStorageCellSeeds seed4k;
	public static BlockStorageCellCrop crop4k;
	public static ItemStorageCellSeeds seed1k;
	public static BlockStorageCellCrop crop1k;
	public static ItemSpatialCellSeeds seed2c;
	public static ItemSpatialCellSeeds seed16c;
	public static ItemSpatialCellSeeds seed128c;
	public static BlockSpatialCellCrop crop2c;
	public static BlockSpatialCellCrop crop16c;
	public static BlockSpatialCellCrop crop128c;
	
	public static void init() {
		crop64k = new BlockStorageCellCrop("crop64k", "storage_cell_64k");
		seed64k = new ItemStorageCellSeeds("seed64k");
		crop16k = new BlockStorageCellCrop("crop16k", "storage_cell_16k");
		crop4k = new BlockStorageCellCrop("crop4k", "storage_cell_4k");
		crop1k = new BlockStorageCellCrop("crop1k", "storage_cell_1k");
		seed16k = new ItemStorageCellSeeds("seed16k");
		seed4k = new ItemStorageCellSeeds("seed4k");
		seed1k = new ItemStorageCellSeeds("seed1k");
		crop2c = new BlockSpatialCellCrop("crop2_cubed");
		crop16c = new BlockSpatialCellCrop("crop16_cubed");
		crop128c = new BlockSpatialCellCrop("crop128_cubed");
		seed2c = new ItemSpatialCellSeeds("seed2_cubed");
		seed16c = new ItemSpatialCellSeeds("seed16_cubed");
		seed128c = new ItemSpatialCellSeeds("seed128_cubed");
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
		seed2c.initModel();
		seed16c.initModel();
		seed128c.initModel();
		crop2c.initModel();
		crop16c.initModel();
		crop128c.initModel();
	}
	
	
}
