package com.dennisbonke.letsmodng.container;

import com.dennisbonke.letsmodng.tileentity.TileEntityAlabasterOven;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;

public class ContainerAlabasterOven extends Container{

    private TileEntityAlabasterOven alabasterOven;

    public int lastBurnTime;
    public int lastCurrentItemBurnTime;
    public int lastCookTime;

    public ContainerAlabasterOven(InventoryPlayer inventory, TileEntityAlabasterOven tileentity){
        this.alabasterOven = tileentity;

        this.addSlotToContainer(new Slot(tileentity, 0, 56, 35));
        this.addSlotToContainer(new Slot(tileentity, 1, 8, 62));
        this.addSlotToContainer(new SlotFurnace(inventory.player, tileentity, 2, 116, 35));

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 9; j++){
                this.addSlotToContainer(new Slot(inventory, j + i*9 + 9, 8 + j*18, 94 + i*18));
            }
        }

        for (int i = 0; i < 9; i++){
            this.addSlotToContainer(new Slot(inventory, i, 8 + i*18, 142));
        }
    }

    public void addCraftingToCrafters(ICrafting icrafting){
        super.addCraftingToCrafters(icrafting);
        icrafting.sendProgressBarUpdate(this, 0, this.alabasterOven.cookTime);
        icrafting.sendProgressBarUpdate(this, 1, this.alabasterOven.burnTime);
        icrafting.sendProgressBarUpdate(this, 2, this.alabasterOven.currentItemBurnTime);
    }

    public void detectAndSendChanges(){
        super.detectAndSendChanges();
        for (int i = 0; i < this.crafters.size(); i++){
            ICrafting icrafting = (ICrafting) this.crafters.get(i);

            if (this.lastCookTime != this.alabasterOven.cookTime){
                icrafting.sendProgressBarUpdate(this, 0, this.alabasterOven.cookTime);
            }

            if (this.lastBurnTime != this.alabasterOven.burnTime){
                icrafting.sendProgressBarUpdate(this, 1, this.alabasterOven.burnTime);
            }

            if (this.lastCurrentItemBurnTime != this.alabasterOven.currentItemBurnTime){
                icrafting.sendProgressBarUpdate(this, 2, this.alabasterOven.currentItemBurnTime);
            }
        }

        this.lastCookTime = this.alabasterOven.cookTime;
        this.lastBurnTime = this.alabasterOven.burnTime;
        this.lastCurrentItemBurnTime = this.alabasterOven.currentItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int slot, int newValue){

    }






    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {
        return true;
    }
}
