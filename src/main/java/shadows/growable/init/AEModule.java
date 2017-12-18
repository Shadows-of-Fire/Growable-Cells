package shadows.growable.init;

import appeng.api.AEApi;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import shadows.growable.GrowableCells;
import shadows.growable.block.BlockAppliedCellCrop;
import shadows.growable.item.ItemCellSeeds;

public class AEModule {

	public static final BlockAppliedCellCrop CROP_1K = new BlockAppliedCellCrop("crop_1k", AEApi.instance().definitions().items().cell1k().maybeItem().orElse(null));
	public static final BlockAppliedCellCrop CROP_4K = new BlockAppliedCellCrop("crop_4k", AEApi.instance().definitions().items().cell4k().maybeItem().orElse(null));
	public static final BlockAppliedCellCrop CROP_16K = new BlockAppliedCellCrop("crop_16k", AEApi.instance().definitions().items().cell16k().maybeItem().orElse(null));
	public static final BlockAppliedCellCrop CROP_64K = new BlockAppliedCellCrop("crop_64k", AEApi.instance().definitions().items().cell64k().maybeItem().orElse(null));
	public static final BlockAppliedCellCrop CROP_2_CUBED = new BlockAppliedCellCrop("crop_2_cubed", AEApi.instance().definitions().items().spatialCell2().maybeItem().orElse(null));
	public static final BlockAppliedCellCrop CROP_16_CUBED = new BlockAppliedCellCrop("crop_16_cubed", AEApi.instance().definitions().items().spatialCell16().maybeItem().orElse(null));
	public static final BlockAppliedCellCrop CROP_128_CUBED = new BlockAppliedCellCrop("crop_128_cubed", AEApi.instance().definitions().items().spatialCell128().maybeItem().orElse(null));

	public static final Item SEED_1K = new ItemCellSeeds<>(CROP_1K, "seed_1k");
	public static final Item SEED_4K = new ItemCellSeeds<>(CROP_4K, "seed_4k");
	public static final Item SEED_16K = new ItemCellSeeds<>(CROP_16K, "seed_16k");
	public static final Item SEED_64K = new ItemCellSeeds<>(CROP_64K, "seed_64k");
	public static final Item SEED_2_CUBED = new ItemCellSeeds<>(CROP_2_CUBED, "seed_2_cubed");
	public static final Item SEED_16_CUBED = new ItemCellSeeds<>(CROP_16_CUBED, "seed_16_cubed");
	public static final Item SEED_128_CUBED = new ItemCellSeeds<>(CROP_128_CUBED, "seed_128_cubed");

	public static void load() {
		GrowableCells.logger.info("Applied Energistics 2 support loaded.");
	}

	public static void loadRecipes() {
		ItemStack c1k = new ItemStack(AEApi.instance().definitions().items().cell1k().maybeItem().orElse(null));
		ItemStack c4k = new ItemStack(AEApi.instance().definitions().items().cell4k().maybeItem().orElse(null));
		ItemStack c16k = new ItemStack(AEApi.instance().definitions().items().cell16k().maybeItem().orElse(null));
		ItemStack c64k = new ItemStack(AEApi.instance().definitions().items().cell64k().maybeItem().orElse(null));
		ItemStack c2c = new ItemStack(AEApi.instance().definitions().items().spatialCell2().maybeItem().orElse(null));
		ItemStack c16c = new ItemStack(AEApi.instance().definitions().items().spatialCell16().maybeItem().orElse(null));
		ItemStack c128c = new ItemStack(AEApi.instance().definitions().items().spatialCell128().maybeItem().orElse(null));

		GrowableCells.HELPER.addShaped(SEED_1K, 3, 3, c1k, c1k, c1k, c1k, Items.BEETROOT_SEEDS, c1k, c1k, c1k, c1k);
		GrowableCells.HELPER.addShaped(SEED_4K, 3, 3, c4k, c4k, c4k, c4k, SEED_1K, c4k, c4k, c4k, c4k);
		GrowableCells.HELPER.addShaped(SEED_16K, 3, 3, c16k, c16k, c16k, c16k, SEED_4K, c16k, c16k, c16k, c16k);
		GrowableCells.HELPER.addShaped(SEED_64K, 3, 3, c64k, c64k, c64k, c64k, SEED_16K, c64k, c64k, c64k, c64k);
		GrowableCells.HELPER.addShaped(SEED_2_CUBED, 3, 3, c2c, c2c, c2c, c2c, Items.BEETROOT_SEEDS, c2c, c2c, c2c, c2c);
		GrowableCells.HELPER.addShaped(SEED_16_CUBED, 3, 3, c16c, c16c, c16c, c16c, SEED_2_CUBED, c16c, c16c, c16c, c16c);
		GrowableCells.HELPER.addShaped(SEED_128_CUBED, 3, 3, c128c, c128c, c128c, c128c, SEED_16_CUBED, c128c, c128c, c128c, c128c);
	}
}
