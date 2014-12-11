package com.dennisbonke.letsmodng;

import com.dennisbonke.letsmodng.blocks.CopperOre;
import com.dennisbonke.letsmodng.items.DBItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod(modid = LetsModNG.modid, version = LetsModNG.version)
public class LetsModNG {

    public static final String modid = "letsmodng";
    public static final String version = "Alpha v0.1";

    public static CreativeTabs letsmodngTab;

    public static Item itemCopperIngot;

    public static Block oreCopperOre;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){

        letsmodngTab = new CreativeTabs("letsmodng") {
            @Override
            public Item getTabIconItem() {
                return Item.getItemFromBlock(LetsModNG.oreCopperOre);
            }
        };
        itemCopperIngot = new DBItems().setUnlocalizedName("CopperIngot");
        GameRegistry.registerItem(itemCopperIngot, "CopperIngot");

        oreCopperOre = new CopperOre(Material.rock).setBlockName("CopperOre");
        GameRegistry.registerBlock(oreCopperOre, "CopperOre");

    }

    @EventHandler
    public void Init(FMLInitializationEvent event){

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
}