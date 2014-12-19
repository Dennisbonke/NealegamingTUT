package com.dennisbonke.letsmodng.gui;

import com.dennisbonke.letsmodng.LetsModNG;
import com.dennisbonke.letsmodng.container.ContainerAlabasterOven;
import com.dennisbonke.letsmodng.tileentity.TileEntityAlabasterOven;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiAlabasterOven extends GuiContainer{

    public static final ResourceLocation bground = new ResourceLocation(LetsModNG.modid + ":" + "textures/gui/GuiAlabasterOven.png");

    public TileEntityAlabasterOven alabasterOven;

    public GuiAlabasterOven(InventoryPlayer inventoryPlayer, TileEntityAlabasterOven entity) {
        super(new ContainerAlabasterOven(inventoryPlayer, entity));

        this.alabasterOven = entity;

        this.xSize = 176;
        this.ySize = 166;
    }


    public void drawGuiContainerForegroundLayer(int par1, int par2){
        String name = "Alabaster Oven";

        this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("Container.inventory", new Object[0]), 118, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
        GL11.glColor4f(1F, 1F, 1F, 1F);

        Minecraft.getMinecraft().getTextureManager().bindTexture(bground);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        if (this.alabasterOven.isBurning()){
            int k = this.alabasterOven.getBurnTimeRemainingScaled(40);
            int j = 40 - k;
            drawTexturedModalRect(guiLeft + 29, guiTop + 65, 176, 0, 40 - j, 10);
        }

        int k = this.alabasterOven.getCookProgressScaled(24);
        drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 10, k + 1, 16);
    }
}
