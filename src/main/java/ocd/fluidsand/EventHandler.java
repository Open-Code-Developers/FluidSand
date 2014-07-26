package ocd.fluidsand;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
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
}
