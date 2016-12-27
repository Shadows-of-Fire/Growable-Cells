package shadows.ae2.growable.common;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ae2.growable.AE2Growable;
import shadows.ae2.growable.core.ConfigFile;
import shadows.ae2.growable.core.ModRegistry;

public class BlockAECrops extends BlockCrops{
	public String drops;
	
	public BlockAECrops(String regname, String dropname) {
		setUnlocalizedName(AE2Growable.MODID + "." + regname);
		setRegistryName(regname);
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this), getRegistryName());
		drops = dropname;
	}
	@Override
	protected Item getSeed() {
		return Item.getByNameOrId("growablecells:seed" + drops.substring(13));
	}
	@Override
	protected Item getCrop() {
		return Item.getByNameOrId("appliedenergistics2:" + drops); //storage_cell_64k
	}
	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state){
	return ConfigFile.allowBonemeal;
	}
	@SideOnly(Side.CLIENT)
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
    @Override
    public java.util.List<ItemStack> getDrops(net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        java.util.List<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this.getSeed()));
        int age = getAge(state);

        if (age >= getMaxAge())
        {
        ret.add(new ItemStack(this.getCrop()));
        }
        
        return ret;
    }
}