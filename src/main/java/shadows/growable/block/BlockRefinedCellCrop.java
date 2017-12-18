package shadows.growable.block;

import java.util.Random;

import com.raoulvdberge.refinedstorage.api.storage.StorageDiskType;
import com.raoulvdberge.refinedstorage.apiimpl.API;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import shadows.growable.GrowableCells;
import shadows.growable.init.ConfigFile;
import shadows.placebo.util.StackPrimer;

public class BlockRefinedCellCrop extends BlockCrops implements IGrowableCell {

	private final StackPrimer drop;
	private Item seed;

	public BlockRefinedCellCrop(String name, StackPrimer drop) {
		setRegistryName(GrowableCells.MODID, name);
		setUnlocalizedName(GrowableCells.MODID + "." + name);
		GrowableCells.INFO.getBlockList().add(this);
		this.drop = drop;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return ConfigFile.allowBonemeal;
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!this.isMaxAge(state)) return false;

		world.setBlockState(pos, this.getDefaultState());
		spawnAsEntity(world, pos, drop.genStack());
		if (ConfigFile.extraFromPurpur && world.getBlockState(pos.down(2)).getBlock() == Blocks.PURPUR_BLOCK) {
			spawnAsEntity(world, pos, new ItemStack(getSeed()));
		} else if (ConfigFile.extraFromQuartz && world.getBlockState(pos.down(2)).getBlock() == Blocks.QUARTZ_BLOCK) {
			spawnAsEntity(world, pos, drop.genStack());
		}

		return true;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return this.isMaxAge(state) ? null : getSeed();
	}

	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		drops.add(new ItemStack(getSeed()));

		if (isMaxAge(state)) {
			drops.add(getCell());
			if (ConfigFile.extraFromPurpur && world.getBlockState(pos.down(2)).getBlock() == Blocks.PURPUR_BLOCK) {
				drops.add(new ItemStack(getSeed()));
			} else if (ConfigFile.extraFromQuartz && world.getBlockState(pos.down(2)).getBlock() == Blocks.QUARTZ_BLOCK) {
				drops.add(getCell());
			}
		}
	}

	@Override
	protected Item getSeed() {
		return seed;
	}

	@Override
	public void setSeed(Item seed) {
		if (this.seed != null) throw new UnsupportedOperationException("Seed has already been set for " + getRegistryName());
		this.seed = seed;
	}

	@Override
	public ItemStack getCell() {
		return API.instance().getDefaultStorageDiskBehavior().initDisk(StorageDiskType.ITEMS, drop.genStack());
	}
}
