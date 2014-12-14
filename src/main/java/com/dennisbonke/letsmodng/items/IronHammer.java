package com.dennisbonke.letsmodng.items;

import com.dennisbonke.letsmodng.LetsModNG;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class IronHammer extends Item {

    public IronHammer(){
        super();
        this.maxStackSize = 1;
        this.setMaxDamage(64);
        this.setNoRepair();
        this.setCreativeTab(LetsModNG.letsmodngTab);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister){
        this.itemIcon = iconRegister.registerIcon(LetsModNG.modid + ":" + this.getUnlocalizedName().substring(5));
    }

}
