package com.dennisbonke.letsmodng.blocks;

import com.dennisbonke.letsmodng.LetsModNG;
import com.dennisbonke.letsmodng.tileentity.TileEntityObsidianTable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ObsidianTable extends BlockContainer {

    public ObsidianTable(Material material) {
        super(material);

        this.setHardness(2.0F);
        this.setResistance(5.0F);
        this.setBlockBounds(0F, 0F, 0F, 1F, 0.75F, 1F);
        this.setCreativeTab(LetsModNG.letsmodngTab);
    }

    public int getRenderType(){
        return -1;
    }

    public boolean isOpaqueCube(){
        return false;
    }

    public boolean renderAsNormalBlock(){
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2) {
        return new TileEntityObsidianTable();
    }
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        this.blockIcon = iconRegister.registerIcon(LetsModNG.modid + ":" + this.getUnlocalizedName().substring(5));
    }
}
