package com.dennisbonke.letsmodng.gui;

import com.dennisbonke.letsmodng.tileentity.TileEntityAlabasterOven;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiAlabasterOven extends GuiContainer{

    public TileEntityAlabasterOven alabasterOven;

    public GuiAlabasterOven(InventoryPlayer inventoryPlayer, TileEntityAlabasterOven entity) {
        super(ContainerAlabasterOven(inventoryPlayer, entity));

        this.alabasterOven = entity;
    }


    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {

    }
}
