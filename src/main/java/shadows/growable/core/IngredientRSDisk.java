package shadows.growable.core;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

public class IngredientRSDisk extends Ingredient {

	private final int meta;

	public IngredientRSDisk(int meta) {
		this.meta = meta;
	}

	@Override
	public boolean apply(ItemStack s) {
		if (s.getItem() == com.raoulvdberge.refinedstorage.RSItems.STORAGE_DISK && s.getMetadata() == meta && com.raoulvdberge.refinedstorage.apiimpl.storage.StorageDiskItem.getStored(s.getTagCompound()) == 0) {
			return true;
		}

		return false;
	}

}
