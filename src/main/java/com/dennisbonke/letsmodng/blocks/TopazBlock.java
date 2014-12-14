package com.dennisbonke.letsmodng.blocks;

import com.dennisbonke.letsmodng.LetsModNG;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class TopazBlock extends Block {
    public TopazBlock(Material material) {
        super(material);

        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setStepSound(soundTypeMetal);
        this.setCreativeTab(LetsModNG.letsmodngTab);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        this.blockIcon = iconRegister.registerIcon(LetsModNG.modid + ":" + this.getUnlocalizedName().substring(5));
    }
}
