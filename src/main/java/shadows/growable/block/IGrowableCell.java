package shadows.growable.block;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public interface IGrowableCell {

	void setSeed(Item seed);

	ItemStack getCell();

}
