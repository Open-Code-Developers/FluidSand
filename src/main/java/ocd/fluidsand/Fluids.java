package ocd.fluidsand;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class Fluids
{
	public static Fluid fluidSand;
	public static Fluid fluidRedSand;
	public static Fluid fluidGravel;
	
	public static void preinit()
	{
		fluidSand = new Fluid("sand").setDensity(1500);
		FluidRegistry.registerFluid(fluidSand);
		
		fluidRedSand = new Fluid("red_sand").setDensity(1500);
		FluidRegistry.registerFluid(fluidRedSand);
		
		fluidGravel = new Fluid("gravel").setDensity(1500);
		FluidRegistry.registerFluid(fluidGravel);
	}
	
	public static void init()
	{
		fluidSand.setIcons(Blocks.blockFluidSand.getBlockTextureFromSide(1),
				Blocks.blockFluidSand.getBlockTextureFromSide(2));
		
		fluidRedSand.setIcons(Blocks.blockFluidRedSand.getBlockTextureFromSide(1),
				Blocks.blockFluidRedSand.getBlockTextureFromSide(2));
		
		fluidGravel.setIcons(Blocks.blockFluidGravel.getBlockTextureFromSide(1),
				Blocks.blockFluidGravel.getBlockTextureFromSide(2));
	}
}
