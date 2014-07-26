package ocd.fluidsand;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraftforge.fluids.BlockFluidBase;
import cpw.mods.fml.common.registry.GameRegistry;

public class Blocks
{
	public static Material materialFluidSand = new MaterialLiquid(MapColor.sandColor);
	public static Material materialFluidRedSand = new MaterialLiquid(MapColor.dirtColor);

	public static BlockFluidBase blockFluidSand;
	public static BlockFluidBase blockFluidRedSand;
	public static BlockFluidBase blockFluidGravel;
	
	public static void preinit()
	{
		blockFluidSand = new BlockFluidSand(Fluids.fluidSand, materialFluidSand);
		GameRegistry.registerBlock(blockFluidSand, "sand");
		
		blockFluidRedSand = new BlockFluidSand(Fluids.fluidRedSand, materialFluidRedSand);
		GameRegistry.registerBlock(blockFluidRedSand, "red_sand");
		
		blockFluidGravel = new BlockFluidSand(Fluids.fluidGravel, materialFluidSand);
		GameRegistry.registerBlock(blockFluidGravel, "gravel");
	}
}
