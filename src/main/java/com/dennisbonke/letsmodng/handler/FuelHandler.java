package com.dennisbonke.letsmodng.handler;

import com.dennisbonke.letsmodng.LetsModNG;
import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.ItemStack;

public class FuelHandler implements IFuelHandler {

    @Override
    public int getBurnTime(ItemStack fuel) {

        if(fuel.getItem() == LetsModNG.itemCoalCoke) return 3200;
        if(fuel.getItem() == LetsModNG.itemTreePitch) return 800;

        return 0;
    }
}
