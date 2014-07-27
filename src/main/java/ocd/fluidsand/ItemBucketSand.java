package ocd.fluidsand;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import net.minecraftforge.fluids.Fluid;

public class ItemBucketSand extends ItemBucket
{
	Fluid fluid;
	
	public ItemBucketSand(Fluid fluid)
	{
		super(Blocks.stone);
		
		setContainerItem(Items.bucket);
		maxStackSize = 1;
		setMaxDamage(7);
		setCreativeTab(CreativeTabs.tabMisc);
	}

}
