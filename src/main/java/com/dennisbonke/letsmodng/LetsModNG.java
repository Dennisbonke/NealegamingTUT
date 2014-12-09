package com.dennisbonke.letsmodng;

import com.dennisbonke.letsmodng.items.DBItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

@Mod(modid = LetsModNG.modid, version = LetsModNG.version)
public class LetsModNG {

    public static final String modid = "letsmodng";
    public static final String version = "Alpha v0.1";

    public static Item itemCopperIngot;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){

        itemCopperIngot = new DBItems().setUnlocalizedName("CopperIngot");
        GameRegistry.registerItem(itemCopperIngot, "CopperIngot");

    }

    @EventHandler
    public void Init(FMLInitializationEvent event){

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
}