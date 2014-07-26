package ocd.fluidsand;

import akka.dispatch.SaneRejectedExecutionHandler;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = FluidSand.MODID, name = FluidSand.NAME, version = "1.0", useMetadata = true)
public class FluidSand
{
	public static final String MODID = "fluidsand";
	public static final String NAME = "FluidSand";
	
	@Mod.EventHandler
	public void preinit(FMLPreInitializationEvent e)
	{
		MinecraftForge.EVENT_BUS.register(EventHandler.INSTANCE);
		
		Fluids.preinit();
		Blocks.preinit();
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent e)
	{
		Fluids.init();
	}
	
	@Mod.EventHandler
	public void postinit(FMLPostInitializationEvent e)
	{
		/*for (BiomeGenBase biome: BiomeGenBase.getBiomeGenArray()) if (biome != null)
		{
			System.out.println(biome);
			if (biome.topBlock == net.minecraft.init.Blocks.sand)
			{
				if (biome.field_150604_aj == 1) biome.topBlock = Blocks.blockFluidRedSand;
				else biome.topBlock = Blocks.blockFluidSand;
				
				biome.field_150604_aj = 7;
			}
			//biome.theBiomeDecorator.sandGen = new WorldGenSand(Blocks.blockFluidSand, 7);
			//biome.theBiomeDecorator.gravelGen = new WorldGenSand(Blocks.blockFluidGravel, 6);
		}*/
	}
}
