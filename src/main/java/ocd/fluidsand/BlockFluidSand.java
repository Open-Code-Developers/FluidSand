package ocd.fluidsand;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFluidSand extends BlockFluidFinite
{
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	public BlockFluidSand(Fluid fluid, Material mat)
	{
		super(fluid, mat);
		
		setBlockName(fluidName);
		setBlockTextureName("fluidsand:" + fluidName);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta)
	{
		return side < 2 ? icons[0] : icons[1];
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		icons = new IIcon[]
				{
					register.registerIcon(textureName + "_still"),
					register.registerIcon(textureName + "_flow")
				};
	}
	
	@Override
	public boolean isReplaceable(IBlockAccess world, int x, int y, int z)
	{
		return true;
	}
	
	//TODO workaround, remove when forge fixes the vanilla hardcode
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		super.updateTick(world, x, y, z, rand);
		
		//System.out.println("tick");
		
		for (EntityLivingBase entity: (List<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class,
				AxisAlignedBB.getBoundingBox(x - 1, y - 2, z - 1, x + 1, y + 1, z + 1)))
		{
			//System.out.println(entity);
			if (isInside(entity)) entity.attackEntityFrom(DamageSource.inWall, 2);
		}
	}
	
	private boolean isInside(EntityLivingBase entity)
	{
		double d0 = entity.posY + (double)entity.getEyeHeight();
        int i = MathHelper.floor_double(entity.posX);
        int j = MathHelper.floor_float((float)MathHelper.floor_double(d0));
        int k = MathHelper.floor_double(entity.posZ);
        Block block = entity.worldObj.getBlock(i, j, k);

        if (block == this)
        {
            double filled = ((BlockFluidSand)block).getFilledPercentage(entity.worldObj, i, j, k);
            
            return d0 < (double)(j + filled);
        }
        else
        {
            return false;
        }
	}
}
