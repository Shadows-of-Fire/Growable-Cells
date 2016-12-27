package shadows.ae2.growable.core;


import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeManager {

	public static void initRecipes(){
		GameRegistry.addRecipe(new ItemStack(ModRegistry.seed1k), "111", "1M1", "111", '1', Item.getByNameOrId("appliedenergistics2:storage_cell_4k"), 'M', Items.MELON_SEEDS);
		GameRegistry.addRecipe(new ItemStack(ModRegistry.seed4k), "222", "2K2", "222", '2', Item.getByNameOrId("appliedenergistics2:storage_cell_16k"), 'K', ModRegistry.seed1k);
		GameRegistry.addRecipe(new ItemStack(ModRegistry.seed16k), "333", "3E3", "333", '3', Item.getByNameOrId("appliedenergistics2:storage_cell_64k"), 'E', ModRegistry.seed4k);
		GameRegistry.addRecipe(new ItemStack(ModRegistry.seed64k), "444", "4S4", "444", '4', Items.NETHER_STAR, 'S', ModRegistry.seed16k);
		GameRegistry.addRecipe(new ItemStack(ModRegistry.seed2c), "111", "1M1", "111", '1', Item.getByNameOrId("appliedenergistics2:spatial_storage_cell_16_cubed"), 'M', Items.PUMPKIN_SEEDS);
		GameRegistry.addRecipe(new ItemStack(ModRegistry.seed16c), "222", "2K2", "222", '2', Item.getByNameOrId("appliedenergistics2:spatial_storage_cell_128_cubed"), 'K', ModRegistry.seed2c);
		GameRegistry.addRecipe(new ItemStack(ModRegistry.seed128c), "444", "4S4", "444", '4', Items.NETHER_STAR, 'S', ModRegistry.seed16c);
	}
}
