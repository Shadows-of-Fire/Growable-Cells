package shadows.ae2.growable.core;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeManager {

	public static void initRecipes(){
		GameRegistry.addRecipe(new ItemStack(ModRegistry.itemMESeed1k), new Object[] {"111", "1M1", "111", '1', Item.getByNameOrId("appliedenergistics2:storage_cell_4k"), 'M', Items.MELON_SEEDS});
		GameRegistry.addRecipe(new ItemStack(ModRegistry.itemMESeed4k), new Object[] {"222", "2K2", "222", '2', Item.getByNameOrId("appliedenergistics2:storage_cell_16k"), 'K', ModRegistry.itemMESeed1k});
		GameRegistry.addRecipe(new ItemStack(ModRegistry.itemMESeed16k), new Object[] {"333", "3E3", "333", '3', Item.getByNameOrId("appliedenergistics2:storage_cell_64k"), 'E', ModRegistry.itemMESeed4k});
		GameRegistry.addRecipe(new ItemStack(ModRegistry.itemMESeed), new Object[] {"444", "4S4", "444", '4', Items.NETHER_STAR, 'S', ModRegistry.itemMESeed16k});
	}
}
