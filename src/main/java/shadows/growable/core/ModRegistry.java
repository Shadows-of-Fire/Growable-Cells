package shadows.growable.core;



import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.LoaderExceptionModCrash;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.growable.common.BlockRefinedCellCrop;
import shadows.growable.common.BlockSpatialCellCrop;
import shadows.growable.common.BlockStorageCellCrop;
import shadows.growable.common.ItemModSeeds;
import net.minecraftforge.fml.common.Optional;


public class ModRegistry {

	public static BlockStorageCellCrop crop64k;
	public static ItemModSeeds seed64k;
	public static ItemModSeeds seed16k;
	public static BlockStorageCellCrop crop16k;
	public static ItemModSeeds seed4k;
	public static BlockStorageCellCrop crop4k;
	public static ItemModSeeds seed1k;
	public static BlockStorageCellCrop crop1k;
	public static ItemModSeeds seed2c;
	public static ItemModSeeds seed16c;
	public static ItemModSeeds seed128c;
	public static BlockSpatialCellCrop crop2c;
	public static BlockSpatialCellCrop crop16c;
	public static BlockSpatialCellCrop crop128c;
	public static BlockRefinedCellCrop cropr1k;
	public static BlockRefinedCellCrop cropr4k;
	public static BlockRefinedCellCrop cropr16k;
	public static BlockRefinedCellCrop cropr64k;
	public static ItemModSeeds seedr1k;
	public static ItemModSeeds seedr4k;
	public static ItemModSeeds seedr16k;
	public static ItemModSeeds seedr64k;
	
	@Optional.Method(modid="appliedenergistics2")
	public static void initAE() {
		crop64k = new BlockStorageCellCrop("crop64k", "storage_cell_64k");
		seed64k = new ItemModSeeds("seed64k");
		crop16k = new BlockStorageCellCrop("crop16k", "storage_cell_16k");
		crop4k = new BlockStorageCellCrop("crop4k", "storage_cell_4k");
		crop1k = new BlockStorageCellCrop("crop1k", "storage_cell_1k");
		seed16k = new ItemModSeeds("seed16k");
		seed4k = new ItemModSeeds("seed4k");
		seed1k = new ItemModSeeds("seed1k");
		crop2c = new BlockSpatialCellCrop("crop2_cubed");
		crop16c = new BlockSpatialCellCrop("crop16_cubed");
		crop128c = new BlockSpatialCellCrop("crop128_cubed");
		seed2c = new ItemModSeeds("seed2_cubed");
		seed16c = new ItemModSeeds("seed16_cubed");
		seed128c = new ItemModSeeds("seed128_cubed");
		}
	
	@Optional.Method(modid="refinedstorage")
	public static void initRS() {
		cropr1k = new BlockRefinedCellCrop("cropr1k", new ItemStack(com.raoulvdberge.refinedstorage.RSItems.STORAGE_DISK, 1, 0));
		cropr4k = new BlockRefinedCellCrop("cropr4k", new ItemStack(com.raoulvdberge.refinedstorage.RSItems.STORAGE_DISK, 1, 1));
		cropr16k = new BlockRefinedCellCrop("cropr16k", new ItemStack(com.raoulvdberge.refinedstorage.RSItems.STORAGE_DISK, 1, 2));
		cropr64k = new BlockRefinedCellCrop("cropr64k", new ItemStack(com.raoulvdberge.refinedstorage.RSItems.STORAGE_DISK, 1, 3));
		seedr1k = new ItemModSeeds("seedr1k");
		seedr4k = new ItemModSeeds("seedr4k");
		seedr16k = new ItemModSeeds("seedr16k");
		seedr64k = new ItemModSeeds("seedr64k");
		
		}
	@SideOnly(Side.CLIENT)
	public static void initModels(){
		if (Loader.isModLoaded("appliedenergistics2"))
		{
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
		
		if (Loader.isModLoaded("refinedstorage")){
		cropr1k.initModel();
		cropr4k.initModel();
		cropr16k.initModel();
		cropr64k.initModel();
		seedr1k.initModel();
		seedr4k.initModel();
		seedr16k.initModel();
		seedr64k.initModel();
		}
	}
	
	
}
