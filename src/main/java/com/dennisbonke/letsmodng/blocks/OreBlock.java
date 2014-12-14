package com.dennisbonke.letsmodng.blocks;

import com.dennisbonke.letsmodng.LetsModNG;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

import java.util.Random;

public class OreBlock extends Block{
    public OreBlock(Material material) {
        super(material);

        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setStepSound(soundTypeStone);
        this.setCreativeTab(LetsModNG.letsmodngTab);
    }

    public Item getItemDropped(int i, Random random, int j){
        return this == LetsModNG.oreTopazOre ? LetsModNG.itemTopaz : Item.getItemFromBlock(this);
    }

    public int quantityDropped(Random random){
        return this == LetsModNG.oreTopazOre ? 4 + random.nextInt(5) : 1;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        this.blockIcon = iconRegister.registerIcon(LetsModNG.modid + ":" + this.getUnlocalizedName().substring(5));
    }
}
