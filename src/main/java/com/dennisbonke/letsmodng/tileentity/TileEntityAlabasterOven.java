package com.dennisbonke.letsmodng.tileentity;

import net.minecraft.tileentity.TileEntity;

public class TileEntityAlabasterOven extends TileEntity{

    private String localizedName;

    public void setGuiDisplayName(String displayName) {
        this.localizedName = displayName;
    }
}
