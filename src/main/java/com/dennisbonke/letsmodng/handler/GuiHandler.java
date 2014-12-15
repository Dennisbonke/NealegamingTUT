package com.dennisbonke.letsmodng.handler;

import com.dennisbonke.letsmodng.LetsModNG;
import com.dennisbonke.letsmodng.container.ContainerAlabasterOven;
import com.dennisbonke.letsmodng.gui.GuiAlabasterOven;
import com.dennisbonke.letsmodng.tileentity.TileEntityAlabasterOven;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler{

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

        if(entity != null){
            switch(ID){
                case LetsModNG.guiIDAlabasterOven:
                    if(entity instanceof TileEntityAlabasterOven){
                        return new ContainerAlabasterOven(player.inventory, (TileEntityAlabasterOven) entity);
                    }
                    return null;
            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

        if(entity != null){
            switch(ID){
                case LetsModNG.guiIDAlabasterOven:
                if(entity instanceof TileEntityAlabasterOven){
                    return new GuiAlabasterOven(player.inventory, (TileEntityAlabasterOven) entity);
                }
                return null;
            }
        }
        return null;
    }
}
