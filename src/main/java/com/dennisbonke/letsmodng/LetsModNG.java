package com.dennisbonke.letsmodng;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = LetsModNG.modid, version = LetsModNG.version)
public class LetsModNG {

    public static final String modid = "letsmodng";
    public static final String version = "Alpha v0.1";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){

    }

    @EventHandler
    public void Init(FMLInitializationEvent event){

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
}