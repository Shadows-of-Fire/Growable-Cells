package shadows.growable.core;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Optional;

@SuppressWarnings("deprecation")
public class RecipeManager {

	@Optional.Method(modid = "appliedenergistics2")
	public static void initAE() {
		RecipeHelper.addOldShaped(new ItemStack(ModRegistry.seed1k), "111", "1M1", "111", '1', Item.getByNameOrId("appliedenergistics2:storage_cell_4k"), 'M', Items.MELON_SEEDS);
		RecipeHelper.addOldShaped(new ItemStack(ModRegistry.seed4k), "222", "2K2", "222", '2', Item.getByNameOrId("appliedenergistics2:storage_cell_16k"), 'K', ModRegistry.seed1k);
		RecipeHelper.addOldShaped(new ItemStack(ModRegistry.seed16k), "333", "3E3", "333", '3', Item.getByNameOrId("appliedenergistics2:storage_cell_64k"), 'E', ModRegistry.seed4k);
		RecipeHelper.addOldShaped(new ItemStack(ModRegistry.seed64k), "444", "4S4", "444", '4', Items.NETHER_STAR, 'S', ModRegistry.seed16k);
		RecipeHelper.addOldShaped(new ItemStack(ModRegistry.seed2c), "111", "1M1", "111", '1', Item.getByNameOrId("appliedenergistics2:spatial_storage_cell_16_cubed"), 'M', Items.PUMPKIN_SEEDS);
		RecipeHelper.addOldShaped(new ItemStack(ModRegistry.seed16c), "222", "2K2", "222", '2', Item.getByNameOrId("appliedenergistics2:spatial_storage_cell_128_cubed"), 'K', ModRegistry.seed2c);
		RecipeHelper.addOldShaped(new ItemStack(ModRegistry.seed128c), "444", "4S4", "444", '4', Items.NETHER_STAR, 'S', ModRegistry.seed16c);
	}

	@Optional.Method(modid = "refinedstorage")
	public static void initRS() {
		com.raoulvdberge.refinedstorage.RSItems.STORAGE_DISK.setContainerItem(com.raoulvdberge.refinedstorage.RSItems.STORAGE_HOUSING);
		RecipeHelper.addOldShaped(new ItemStack(ModRegistry.seedr1k), "111", "1M1", "111", '1', new ItemStack(com.raoulvdberge.refinedstorage.RSItems.STORAGE_DISK, 1, 1), 'M', Items.WHEAT_SEEDS);
		RecipeHelper.addOldShaped(new ItemStack(ModRegistry.seedr4k), "222", "2K2", "222", '2', new ItemStack(com.raoulvdberge.refinedstorage.RSItems.STORAGE_DISK, 1, 2), 'K', ModRegistry.seedr1k);
		RecipeHelper.addOldShaped(new ItemStack(ModRegistry.seedr16k), "333", "3E3", "333", '3', new ItemStack(com.raoulvdberge.refinedstorage.RSItems.STORAGE_DISK, 1, 3), 'E', ModRegistry.seedr4k);
		RecipeHelper.addOldShaped(new ItemStack(ModRegistry.seedr64k), "444", "4S4", "444", '4', Items.NETHER_STAR, 'S', ModRegistry.seedr16k);
		for (int i = 0; i < 4; i++) {
			RecipeHelper.addSmallShapeless(new ItemStack(com.raoulvdberge.refinedstorage.RSItems.STORAGE_PART, 1, i), new IngredientRSDisk(i));
		}

	}

}
