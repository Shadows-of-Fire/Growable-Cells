package shadows.growable.common;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.growable.GrowableCells;
import shadows.growable.core.ConfigFile;
import shadows.growable.core.ModRegistry;

public class BlockStorageCellCrop extends BlockCrops {
	public String drops;

	public BlockStorageCellCrop(String regname, String dropname) {
		setUnlocalizedName(GrowableCells.MODID + "." + regname);
		setRegistryName(regname);
		ModRegistry.BLOCKS.add(this);
		ModRegistry.ITEMS.add(new ItemBlock(this).setRegistryName(getRegistryName()));
		drops = dropname;
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
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
	protected Item getSeed() {
		return Item.getByNameOrId("growablecells:seed" + drops.substring(13));
	}

	@Override
	protected Item getCrop() {
		return Item.getByNameOrId("appliedenergistics2:" + drops); // storage_cell_64k
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return ConfigFile.allowBonemeal;
	}

	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

	@Override
	public java.util.List<ItemStack> getDrops(net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		java.util.List<ItemStack> ret = new ArrayList<ItemStack>();
		if (fortune != 25) ret.add(new ItemStack(this.getSeed()));
		int age = getAge(state);

		if (age >= getMaxAge()) {
			ret.add(new ItemStack(this.getCrop()));
			if (world.getBlockState(pos.down(2)).getBlock() == Block.getBlockFromName("appliedenergistics2:fluix_block") && ConfigFile.extraFromFluix) {
				ret.add(new ItemStack(this.getSeed()));
			} else if (world.getBlockState(pos.down(2)).getBlock() == Block.getBlockFromName("appliedenergistics2:quartz_block") && ConfigFile.extraFromCertus) {
				ret.add(new ItemStack(this.getCrop()));
			}
		}

		return ret;
	}
}