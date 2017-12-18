package shadows.growable.block;

import java.util.Random;

import appeng.api.AEApi;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
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

public class BlockAppliedCellCrop extends BlockCrops implements IGrowableCell {

	private final StackPrimer drop;
	private Item seed;

	public BlockAppliedCellCrop(String name, Item drop) {
		setRegistryName(GrowableCells.MODID, name);
		setUnlocalizedName(GrowableCells.MODID + "." + name);
		GrowableCells.INFO.getBlockList().add(this);
		this.drop = new StackPrimer(drop);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!this.isMaxAge(state)) return false;
		
		world.setBlockState(pos, this.getDefaultState());
		
		spawnAsEntity(world, pos, getCell());
		if (ConfigFile.extraFromFluix && AEApi.instance().definitions().blocks().fluixBlock().isSameAs(world, pos.down(2))) {
			spawnAsEntity(world, pos, new ItemStack(getSeed()));
		} else if (ConfigFile.extraFromCertus && AEApi.instance().definitions().blocks().quartzBlock().isSameAs(world, pos.down(2))) {
			spawnAsEntity(world, pos, getCell());
		}
		
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return ConfigFile.allowBonemeal;
	}

	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		drops.add(new ItemStack(getSeed()));
		int age = getAge(state);

		if (age >= getMaxAge()) {
			drops.add(getCell());
			if (ConfigFile.extraFromFluix && AEApi.instance().definitions().blocks().fluixBlock().isSameAs(world, pos.down(2))) {
				drops.add(new ItemStack(getSeed()));
			} else if (ConfigFile.extraFromCertus && AEApi.instance().definitions().blocks().quartzBlock().isSameAs(world, pos.down(2))) {
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
		if(this.seed != null) throw new UnsupportedOperationException("Seed has already been set for " + getRegistryName());
		this.seed = seed;
	}
	
	@Override
	public ItemStack getCell() {
		return drop.genStack();
	}
}