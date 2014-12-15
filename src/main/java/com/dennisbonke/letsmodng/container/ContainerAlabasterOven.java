package com.dennisbonke.letsmodng.container;

import com.dennisbonke.letsmodng.tileentity.TileEntityAlabasterOven;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerAlabasterOven extends Container{

    private TileEntityAlabasterOven alabasterOven;

    public ContainerAlabasterOven(InventoryPlayer inventory, TileEntityAlabasterOven tileentity){
        this.alabasterOven = tileentity;
    }


    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return false;
    }
}
