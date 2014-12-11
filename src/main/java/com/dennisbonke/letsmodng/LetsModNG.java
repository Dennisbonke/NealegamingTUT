package com.dennisbonke.letsmodng;

import com.dennisbonke.letsmodng.blocks.CopperBlock;
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
import net.minecraft.item.ItemStack;

@Mod(modid = LetsModNG.modid, version = LetsModNG.version)
public class LetsModNG {

    public static final String modid = "letsmodng";
    public static final String version = "Alpha v0.1";

    public static CreativeTabs letsmodngTab;

    public static Item itemCopperIngot;

    public static Block oreCopperOre;
    public static Block blockCopperBlock;

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

        blockCopperBlock = new CopperBlock(Material.iron).setBlockName("CopperBlock");
        GameRegistry.registerBlock(blockCopperBlock, "CopperBlock");
    }

    @EventHandler
    public void Init(FMLInitializationEvent event){

        //Recipes
        GameRegistry.addRecipe(new ItemStack(blockCopperBlock), new Object[]{"CCC", "CCC", "CCC", 'C', itemCopperIngot});


        //Smelting
        GameRegistry.addSmelting(oreCopperOre, new ItemStack(itemCopperIngot), 0);

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
}