package com.dennisbonke.letsmodng;

import com.dennisbonke.letsmodng.blocks.*;
import com.dennisbonke.letsmodng.handler.FuelHandler;
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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
    public static Item itemCoalCoke;
    public static Item itemWoodenGear;
    public static Item itemStoneGear;
    public static Item itemIronGear;
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

        // Init Creativetab

        letsmodngTab = new CreativeTabs("letsmodng") {
            @Override
            public Item getTabIconItem() {
                return Item.getItemFromBlock(LetsModNG.oreCopperOre);
            }
        };

        // Init stuff
        // Ores
        oreCopperOre = new OreBlock(Material.rock).setBlockName("CopperOre");
        oreTinOre = new OreBlock(Material.rock).setBlockName("TinOre");
        oreLeadOre = new OreBlock(Material.rock).setBlockName("LeadOre");
        oreSilverOre = new OreBlock(Material.rock).setBlockName("SilverOre");

        // Blocks
        blockCopperBlock = new CopperBlock(Material.iron).setBlockName("CopperBlock");
        blockSilverBlock = new SilverBlock(Material.iron).setBlockName("SilverBlock");
        blockTinBlock = new TinBlock(Material.iron).setBlockName("TinBlock");
        blockLeadBlock = new LeadBlock(Material.iron).setBlockName("LeadBlock");

        // Items
        itemCopperIngot = new DBItems().setUnlocalizedName("CopperIngot");
        itemTinIngot = new DBItems().setUnlocalizedName("TinIngot");
        itemSilverIngot = new DBItems().setUnlocalizedName("SilverIngot");
        itemLeadIngot = new DBItems().setUnlocalizedName("LeadIngot");
        itemWoodenGear = new DBItems().setUnlocalizedName("WoodenGear");
        itemStoneGear = new DBItems().setUnlocalizedName("StoneGear");
        itemIronGear = new DBItems().setUnlocalizedName("IronGear");
        itemCoalCoke = new DBItems().setUnlocalizedName("CoalCoke");

        // Register Stuff
        // Ores
        GameRegistry.registerBlock(oreCopperOre, "CopperOre");
        GameRegistry.registerBlock(oreTinOre, "TinOre");
        GameRegistry.registerBlock(oreLeadOre, "LeadOre");
        GameRegistry.registerBlock(oreSilverOre, "SilverOre");

        // Blocks
        GameRegistry.registerBlock(blockCopperBlock, "CopperBlock");
        GameRegistry.registerBlock(blockSilverBlock, "SilverBlock");
        GameRegistry.registerBlock(blockTinBlock, "TinBlock");
        GameRegistry.registerBlock(blockLeadBlock, "LeadBlock");

        // Items
        GameRegistry.registerItem(itemCopperIngot, "CopperIngot");
        GameRegistry.registerItem(itemTinIngot, "TinIngot");
        GameRegistry.registerItem(itemSilverIngot, "SilverIngot");
        GameRegistry.registerItem(itemLeadIngot, "LeadIngot");
        GameRegistry.registerItem(itemWoodenGear, "WoodenGear");
        GameRegistry.registerItem(itemStoneGear, "StoneGear");
        GameRegistry.registerItem(itemIronGear, "IronGear");
        GameRegistry.registerItem(itemCoalCoke, "CoalCoke");

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
        GameRegistry.addRecipe(new ItemStack(itemWoodenGear), new Object[]{" W ", "W W", " W ", 'W', Items.stick});
        GameRegistry.addRecipe(new ItemStack(itemStoneGear), new Object[]{" S ", "SWS", " S ", 'S', Blocks.cobblestone, 'W', itemWoodenGear});
        GameRegistry.addRecipe(new ItemStack(itemIronGear), new Object[]{" I ", "ISI", " I ", 'I', Items.iron_ingot, 'S', itemStoneGear});
        GameRegistry.addShapelessRecipe(new ItemStack(oreCopperOre), new Object[]{itemCopperIngot, Blocks.cobblestone});
        GameRegistry.addShapelessRecipe(new ItemStack(itemCopperIngot, 9), new Object[]{blockCopperBlock});
        GameRegistry.addShapelessRecipe(new ItemStack(itemLeadIngot, 9), new Object[]{blockLeadBlock});
        GameRegistry.addShapelessRecipe(new ItemStack(itemSilverIngot, 9), new Object[]{blockSilverBlock});
        GameRegistry.addShapelessRecipe(new ItemStack(itemTinIngot, 9), new Object[]{blockTinBlock});


        //Smelting
        GameRegistry.addSmelting(oreCopperOre, new ItemStack(itemCopperIngot), 0);
        GameRegistry.addSmelting(oreTinOre, new ItemStack(itemTinIngot), 0);
        GameRegistry.addSmelting(oreSilverOre, new ItemStack(itemSilverIngot), 0);
        GameRegistry.addSmelting(oreLeadOre, new ItemStack(itemLeadIngot), 0);

        // FuelHandler
        GameRegistry.registerFuelHandler(new FuelHandler());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
}