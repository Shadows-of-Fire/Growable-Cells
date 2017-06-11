package shadows.growable.common;

import java.util.ArrayList;
import java.util.Random;

import javax.annotation.Nullable;

import com.raoulvdberge.refinedstorage.api.storage.StorageDiskType;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.API;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.growable.AE2Growable;
import shadows.growable.core.ConfigFile;

public class BlockRefinedCellCrop extends BlockCrops {
	public ItemStack drops;
	public String regnames;

	public BlockRefinedCellCrop(String regname, ItemStack drop) {
		setUnlocalizedName(AE2Growable.MODID + "." + regname);
		setRegistryName(regname);
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this), getRegistryName());
		regnames = regname;
		drops = drop;
	}

	public ItemStack dropCell(ItemStack stack) {
		return API.instance().getDefaultStorageDiskBehavior().initDisk(StorageDiskType.ITEMS, stack);
	}

	@Override
	protected Item getSeed() {
		return Item.getByNameOrId("growablecells:seed" + regnames.substring(4));
	}

	@Override
	@Nullable
	protected Item getCrop() {
		return drops.getItem();
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return ConfigFile.allowBonemeal;
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (this.isMaxAge(state)) {
			world.setBlockState(pos, this.getDefaultState());
			for (ItemStack stack : this.getDrops(world, pos, state, 25)) {
				spawnAsEntity(world, pos, stack);
			}
			return true;
		}
		return false;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return this.isMaxAge(state) ? null : this.getSeed();
	}

	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0,
				new ModelResourceLocation(getRegistryName(), "inventory"));
	}

	@Override
	public java.util.List<ItemStack> getDrops(net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state,
			int fortune) {
		java.util.List<ItemStack> ret = new ArrayList<ItemStack>();
		if (fortune != 25)
			ret.add(new ItemStack(this.getSeed()));
		int age = getAge(state);

		if (age >= getMaxAge()) {
			ret.add(dropCell(drops));

			if (world.getBlockState(pos.down(2)).getBlock() == Blocks.PURPUR_BLOCK && ConfigFile.extraFromPurpur) {
				ret.add(new ItemStack(this.getSeed()));
			} else if (world.getBlockState(pos.down(2)).getBlock() == Blocks.QUARTZ_BLOCK
					&& ConfigFile.extraFromQuartz) {
				ret.add(dropCell(drops));
			}
		}
		for (ItemStack stack : ret) {
			if (stack.isEmpty())
				stack.setCount(1);
		}
		return ret;
	}
}
