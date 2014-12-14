package com.dennisbonke.letsmodng.items;

import com.dennisbonke.letsmodng.LetsModNG;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSpade;

public class TopazShovel extends ItemSpade{
    public TopazShovel(ToolMaterial p_i45353_1_) {
        super(p_i45353_1_);
        this.setCreativeTab(LetsModNG.letsmodngTab);
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister){
        this.itemIcon = iconRegister.registerIcon(LetsModNG.modid + ":" + this.getUnlocalizedName().substring(5));
    }
}
