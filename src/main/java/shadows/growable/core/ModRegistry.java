package shadows.growable.core;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.growable.common.BlockRefinedCellCrop;
import shadows.growable.common.BlockSpatialCellCrop;
import shadows.growable.common.BlockStorageCellCrop;
import shadows.growable.common.ItemModSeeds;

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

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	public static final List<Item> ITEMS = new ArrayList<Item>();
	public static final List<IRecipe> RECIPES = RecipeHelper.RECIPES;

	@Optional.Method(modid = "appliedenergistics2")
	public static void initAE() {
		crop1k = new BlockStorageCellCrop("crop1k", "storage_cell_1k");
		crop4k = new BlockStorageCellCrop("crop4k", "storage_cell_4k");
		crop16k = new BlockStorageCellCrop("crop16k", "storage_cell_16k");
		crop64k = new BlockStorageCellCrop("crop64k", "storage_cell_64k");
		seed1k = new ItemModSeeds(crop1k, "seed1k");
		seed4k = new ItemModSeeds(crop4k, "seed4k");
		seed16k = new ItemModSeeds(crop16k, "seed16k");
		seed64k = new ItemModSeeds(crop64k, "seed64k");
		crop2c = new BlockSpatialCellCrop("crop2_cubed");
		crop16c = new BlockSpatialCellCrop("crop16_cubed");
		crop128c = new BlockSpatialCellCrop("crop128_cubed");
		seed2c = new ItemModSeeds(crop2c, "seed2_cubed");
		seed16c = new ItemModSeeds(crop16c, "seed16_cubed");
		seed128c = new ItemModSeeds(crop128c, "seed128_cubed");
	}

	@Optional.Method(modid = "refinedstorage")
	public static void initRS() {
		cropr1k = new BlockRefinedCellCrop("cropr1k", new ItemStack(com.raoulvdberge.refinedstorage.RSItems.STORAGE_DISK, 1, 0));
		cropr4k = new BlockRefinedCellCrop("cropr4k", new ItemStack(com.raoulvdberge.refinedstorage.RSItems.STORAGE_DISK, 1, 1));
		cropr16k = new BlockRefinedCellCrop("cropr16k", new ItemStack(com.raoulvdberge.refinedstorage.RSItems.STORAGE_DISK, 1, 2));
		cropr64k = new BlockRefinedCellCrop("cropr64k", new ItemStack(com.raoulvdberge.refinedstorage.RSItems.STORAGE_DISK, 1, 3));
		seedr1k = new ItemModSeeds(cropr1k, "seedr1k");
		seedr4k = new ItemModSeeds(cropr4k, "seedr4k");
		seedr16k = new ItemModSeeds(cropr16k, "seedr16k");
		seedr64k = new ItemModSeeds(cropr64k, "seedr64k");

	}

	@SideOnly(Side.CLIENT)
	public static void initModels() {
		if (Loader.isModLoaded("appliedenergistics2")) {
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

		if (Loader.isModLoaded("refinedstorage")) {
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

	@SubscribeEvent
	public void onItemRegistry(RegistryEvent.Register<Item> e) {
		e.getRegistry().registerAll(ITEMS.toArray(new Item[0]));
	}

	@SubscribeEvent
	public void onBlockRegistry(RegistryEvent.Register<Block> e) {
		e.getRegistry().registerAll(BLOCKS.toArray(new Block[0]));
	}

	@SubscribeEvent
	public void onRecipeRegistry(RegistryEvent.Register<IRecipe> e) {
		e.getRegistry().registerAll(RECIPES.toArray(new IRecipe[0]));
	}

	@Optional.Method(modid = "refinedstorage")
	@SubscribeEvent
	public void onItemClick(RightClickItem e) {
		ItemStack s = e.getItemStack();
		if (s.getItem() == com.raoulvdberge.refinedstorage.RSItems.STORAGE_DISK) {
			if (e.getEntityPlayer().isSneaking() && com.raoulvdberge.refinedstorage.apiimpl.storage.StorageDiskItem.getStored(s.getTagCompound()) == 0) {
				s.shrink(1);
				if (!e.getEntityPlayer().addItemStackToInventory(new ItemStack(com.raoulvdberge.refinedstorage.RSItems.STORAGE_HOUSING)))
					Block.spawnAsEntity(e.getWorld(), e.getPos(), new ItemStack(com.raoulvdberge.refinedstorage.RSItems.STORAGE_HOUSING));
				if (!e.getEntityPlayer().addItemStackToInventory(new ItemStack(com.raoulvdberge.refinedstorage.RSItems.STORAGE_PART, 1, s.getMetadata())))
					Block.spawnAsEntity(e.getWorld(), e.getPos(), new ItemStack(com.raoulvdberge.refinedstorage.RSItems.STORAGE_PART, 1, s.getMetadata()));
			}
		}
	}

}
