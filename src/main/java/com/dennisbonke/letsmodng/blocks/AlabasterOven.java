package com.dennisbonke.letsmodng.blocks;

import com.dennisbonke.letsmodng.LetsModNG;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class AlabasterOven extends BlockContainer{

    private final boolean isActive;

    @SideOnly(Side.CLIENT)
    private IIcon iconFront;

    @SideOnly(Side.CLIENT)
    private IIcon iconTop;

    public AlabasterOven(boolean isActive){
        super(Material.iron);

        this.isActive = isActive;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        this.blockIcon = iconRegister.registerIcon(LetsModNG.modid + ":" + "AlabasterOvenSide");
        this.iconFront = iconRegister.registerIcon(LetsModNG.modid + ":" +(this.isActive ? "AlabasterOvenFrontOn" : "AlabasterOvenFrontOff"));
        this.iconTop = iconRegister.registerIcon(LetsModNG.modid + ":" + "AlabasterOvenTop");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata){
        return metadata == 0 && side == 3 ? this.iconFront : (side == metadata ? this.iconFront : this.blockIcon);
    }




    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return null;
    }
}
