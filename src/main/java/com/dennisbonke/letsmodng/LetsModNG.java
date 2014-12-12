package com.dennisbonke.letsmodng;

import com.dennisbonke.letsmodng.blocks.*;
import com.dennisbonke.letsmodng.items.DBItems;
import com.dennisbonke.letsmodng.worldgen.LetsModNGWorldGen;
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

    LetsModNGWorldGen eventWorldGen = new LetsModNGWorldGen();

    public static CreativeTabs letsmodngTab;

    public static Item itemCopperIngot;
    public static Item itemTinIngot;
    public static Item itemLeadIngot;
    public static Item itemSilverIngot;

    public static Block oreCopperOre;
    public static Block oreTinOre;
    public static Block oreLeadOre;
    public static Block oreSilverOre;

    public static Block blockCopperBlock;
    public static Block blockSilverBlock;
    public static Block blockTinBlock;
    public static Block blockLeadBlock;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){

        letsmodngTab = new CreativeTabs("letsmodng") {
            @Override
            public Item getTabIconItem() {
                return Item.getItemFromBlock(LetsModNG.oreCopperOre);
            }
        };

        // Items
        itemCopperIngot = new DBItems().setUnlocalizedName("CopperIngot");
        GameRegistry.registerItem(itemCopperIngot, "CopperIngot");

        itemTinIngot = new DBItems().setUnlocalizedName("TinIngot");
        GameRegistry.registerItem(itemTinIngot, "TinIngot");

        itemSilverIngot = new DBItems().setUnlocalizedName("SilverIngot");
        GameRegistry.registerItem(itemSilverIngot, "SilverIngot");

        itemLeadIngot = new DBItems().setUnlocalizedName("LeadIngot");
        GameRegistry.registerItem(itemLeadIngot, "LeadIngot");

        // Ores
        oreCopperOre = new OreBlock(Material.rock).setBlockName("CopperOre");
        GameRegistry.registerBlock(oreCopperOre, "CopperOre");

        oreTinOre = new OreBlock(Material.rock).setBlockName("TinOre");
        GameRegistry.registerBlock(oreTinOre, "TinOre");

        oreLeadOre = new OreBlock(Material.rock).setBlockName("LeadOre");
        GameRegistry.registerBlock(oreLeadOre, "LeadOre");

        oreSilverOre = new OreBlock(Material.rock).setBlockName("SilverOre");
        GameRegistry.registerBlock(oreSilverOre, "SilverOre");

        // Blocks
        blockCopperBlock = new CopperBlock(Material.iron).setBlockName("CopperBlock");
        GameRegistry.registerBlock(blockCopperBlock, "CopperBlock");

        blockSilverBlock = new SilverBlock(Material.iron).setBlockName("SilverBlock");
        GameRegistry.registerBlock(blockSilverBlock, "SilverBlock");

        blockTinBlock = new TinBlock(Material.iron).setBlockName("TinBlock");
        GameRegistry.registerBlock(blockTinBlock, "TinBlock");

        blockLeadBlock = new LeadBlock(Material.iron).setBlockName("LeadBlock");
        GameRegistry.registerBlock(blockLeadBlock, "LeadBlock");

        // Spawn
        GameRegistry.registerWorldGenerator(eventWorldGen, 0);
    }

    @EventHandler
    public void Init(FMLInitializationEvent event){

        //Recipes
        GameRegistry.addRecipe(new ItemStack(blockCopperBlock), new Object[]{"CCC", "CCC", "CCC", 'C', itemCopperIngot});
        GameRegistry.addRecipe(new ItemStack(blockTinBlock), new Object[]{"TTT", "TTT", "TTT", 'T', itemTinIngot});
        GameRegistry.addRecipe(new ItemStack(blockSilverBlock), new Object[]{"SSS", "SSS", "SSS", 'S', itemSilverIngot});
        GameRegistry.addRecipe(new ItemStack(blockLeadBlock), new Object[]{"LLL", "LLL", "LLL", 'L', itemLeadIngot});


        //Smelting
        GameRegistry.addSmelting(oreCopperOre, new ItemStack(itemCopperIngot), 0);
        GameRegistry.addSmelting(oreTinOre, new ItemStack(itemTinIngot), 0);
        GameRegistry.addSmelting(oreSilverOre, new ItemStack(itemSilverIngot), 0);
        GameRegistry.addSmelting(oreLeadOre, new ItemStack(itemLeadIngot), 0);

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
}