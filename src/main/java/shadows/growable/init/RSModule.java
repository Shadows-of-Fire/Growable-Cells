package shadows.growable.init;

import com.raoulvdberge.refinedstorage.RSItems;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import shadows.growable.GrowableCells;
import shadows.growable.block.BlockRefinedCellCrop;
import shadows.growable.item.ItemCellSeeds;
import shadows.placebo.util.StackPrimer;

public class RSModule {

	public static final BlockRefinedCellCrop REFINED_CROP_1K = new BlockRefinedCellCrop("refined_crop_1k", new StackPrimer(RSItems.STORAGE_DISK, 1, 0));
	public static final BlockRefinedCellCrop REFINED_CROP_4K = new BlockRefinedCellCrop("refined_crop_4k", new StackPrimer(RSItems.STORAGE_DISK, 1, 1));
	public static final BlockRefinedCellCrop REFINED_CROP_16K = new BlockRefinedCellCrop("refined_crop_16k", new StackPrimer(RSItems.STORAGE_DISK, 1, 2));
	public static final BlockRefinedCellCrop REFINED_CROP_64K = new BlockRefinedCellCrop("refined_crop_64k", new StackPrimer(RSItems.STORAGE_DISK, 1, 3));
	public static final Item REFINED_SEED_1K = new ItemCellSeeds<>(REFINED_CROP_1K, "refined_seed_1k");
	public static final Item REFINED_SEED_4K = new ItemCellSeeds<>(REFINED_CROP_4K, "refined_seed_4k");
	public static final Item REFINED_SEED_16K = new ItemCellSeeds<>(REFINED_CROP_16K, "refined_seed_16k");
	public static final Item REFINED_SEED_64K = new ItemCellSeeds<>(REFINED_CROP_64K, "refined_seed_64k");

	public static void load() {
		GrowableCells.logger.info("Refined Storage support loaded.");
	}

	public static void loadRecipes() {
		ItemStack c1k = new ItemStack(RSItems.STORAGE_DISK, 1, 0);
		ItemStack c4k = new ItemStack(RSItems.STORAGE_DISK, 1, 1);
		ItemStack c16k = new ItemStack(RSItems.STORAGE_DISK, 1, 2);
		ItemStack c64k = new ItemStack(RSItems.STORAGE_DISK, 1, 3);

		GrowableCells.HELPER.addShaped(REFINED_SEED_1K, 3, 3, c1k, c1k, c1k, c1k, Items.BEETROOT_SEEDS, c1k, c1k, c1k, c1k);
		GrowableCells.HELPER.addShaped(REFINED_SEED_4K, 3, 3, c4k, c4k, c4k, c4k, REFINED_SEED_1K, c4k, c4k, c4k, c4k);
		GrowableCells.HELPER.addShaped(REFINED_SEED_16K, 3, 3, c16k, c16k, c16k, c16k, REFINED_SEED_4K, c16k, c16k, c16k, c16k);
		GrowableCells.HELPER.addShaped(REFINED_SEED_64K, 3, 3, c64k, c64k, c64k, c64k, REFINED_SEED_16K, c64k, c64k, c64k, c64k);
	}
}
