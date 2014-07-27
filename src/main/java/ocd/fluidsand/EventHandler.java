package ocd.fluidsand;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventHandler
{
	public static final EventHandler INSTANCE = new EventHandler();
	
	@SubscribeEvent
	public void createEntity(EntityJoinWorldEvent event)
	{
		Entity entity = event.entity;
		
		if (!(entity instanceof EntityFallingBlock)) return;
		EntityFallingBlock falling = (EntityFallingBlock) entity;
		
		if (falling.func_145805_f() instanceof ITileEntityProvider) return;
		Block block = falling.func_145805_f();
		
		if (block == net.minecraft.init.Blocks.sand)
		{
			Block toPlace = Blocks.blockFluidSand;
			if (falling.field_145814_a == 1) toPlace = Blocks.blockFluidRedSand;
			
			event.world.setBlock(MathHelper.floor_double(falling.posX),
						MathHelper.floor_double(falling.posY),
						MathHelper.floor_double(falling.posZ),
						toPlace, 7, 3);
		}
		else if (block == net.minecraft.init.Blocks.gravel)
		{
			event.world.setBlock(MathHelper.floor_double(falling.posX),
						MathHelper.floor_double(falling.posY),
						MathHelper.floor_double(falling.posZ),
						Blocks.blockFluidGravel, 7, 3);
		}
	}
	
	@SubscribeEvent
	public void fillBucket(FillBucketEvent event)
	{
		if (event.target.typeOfHit != MovingObjectPosition.MovingObjectType.BLOCK) return;
		
		Block block = event.world.getBlock(event.target.blockX, event.target.blockY, event.target.blockZ);
		int meta = event.world.getBlockMetadata(event.target.blockX, event.target.blockY, event.target.blockZ);
		
		if (event.current.getItem() == net.minecraft.init.Items.bucket)
		{
			if (block == Blocks.blockFluidSand)
			{
				event.result = new ItemStack(Items.itemBucketSand, 1, meta);
				event.setResult(Result.ALLOW);
				return;
			}
			if (block == Blocks.blockFluidRedSand)
			{
				event.result = new ItemStack(Items.itemBucketRedSand, 1, meta);
				event.setResult(Result.ALLOW);
				return;
			}
			if (block == Blocks.blockFluidGravel)
			{
				event.result = new ItemStack(Items.itemBucketGravel, 1, meta);
				event.setResult(Result.ALLOW);
				return;
			}
		}
		
		if (event.current.getItemDamage() == 0) return;
		
		if (event.current.getItem() == Items.itemBucketSand)
		{
			
		}
		if (event.current.getItem() == Items.itemBucketRedSand)
		{
			
		}
		if (event.current.getItem() == Items.itemBucketGravel)
		{
			
		}
	}
}
