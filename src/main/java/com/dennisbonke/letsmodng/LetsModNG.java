package com.dennisbonke.letsmodng;

import com.dennisbonke.letsmodng.blocks.*;
import com.dennisbonke.letsmodng.crafting.RecipeRemover;
import com.dennisbonke.letsmodng.entity.EntityCyclops;
import com.dennisbonke.letsmodng.handler.CraftingHandler;
import com.dennisbonke.letsmodng.handler.EntityHandler;
import com.dennisbonke.letsmodng.handler.FuelHandler;
import com.dennisbonke.letsmodng.handler.GuiHandler;
import com.dennisbonke.letsmodng.items.*;
import com.dennisbonke.letsmodng.proxy.CommonProxy;
import com.dennisbonke.letsmodng.tileentity.TileEntityAlabasterOven;
import com.dennisbonke.letsmodng.worldgen.LetsModNGWorldGen;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = LetsModNG.modid, version = LetsModNG.version)
public class LetsModNG {
    //GeneralModStuff
    public static final String modid = "letsmodng";
    public static final String version = "Alpha v0.1";
    //WorldGen
    LetsModNGWorldGen eventWorldGen = new LetsModNGWorldGen();
    //CreativeTabs
    public static CreativeTabs letsmodngTab;
    //ToolMaterials
    public static Item.ToolMaterial TopazMaterial = EnumHelper.addToolMaterial("TopazMaterial", 2, 750, 6.0F, 2.0F, 10);

    @Mod.Instance(modid)
    public static LetsModNG instance;

    //Items
    //Ingots
    public static Item itemCopperIngot;
    public static Item itemTinIngot;
    public static Item itemLeadIngot;
    public static Item itemSilverIngot;
    //Fuels
    public static Item itemCoalCoke;
    public static Item itemTreePitch;
    //Gears
    public static Item itemWoodenGear;
    public static Item itemStoneGear;
    public static Item itemIronGear;
    //RandomShit
    public static Item itemIronDisc;
    public static Item itemIronWasher;
    public static Item itemTinCog;
    public static Item itemStaff;
    //DurableItems
    public static Item itemIronHammer;
    public static Item itemIronPunch;
    //Gems
    public static Item itemTopaz;
    //Blocks
    //Ores
    public static Block oreCopperOre;
    public static Block oreTinOre;
    public static Block oreLeadOre;
    public static Block oreSilverOre;
    public static Block oreTopazOre;
    //StorageBlocks
    public static Block blockCopperBlock;
    public static Block blockSilverBlock;
    public static Block blockTinBlock;
    public static Block blockLeadBlock;
    public static Block blockTopazBlock;
    //NiceStuff
    public static Block blockObsidianTable;
    //Tools
    //Topaz
    public static Item itemTopazSword;
    public static Item itemTopazAxe;
    public static Item itemTopazHoe;
    public static Item itemTopazShovel;
    public static Item itemTopazPickaxe;
    //Machiines
    public static Block blockAlabasterOvenIdle;
    public static Block blockAlabasterOvenActive;
    //GUI's
    public static final int guiIDAlabasterOven = 0;

    @SidedProxy(clientSide = "com.dennisbonke.letsmodng.proxy.ClientProxy", serverSide = "com.dennisbonke.letsmodng.proxy.CommonProxy")
    public static CommonProxy dennisProxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){

        //InitCreativetab
        letsmodngTab = new CreativeTabs("letsmodng") {
            @Override
            public Item getTabIconItem() {
                return Item.getItemFromBlock(LetsModNG.oreCopperOre);
            }
        };
        //InitStuff
        //Ores
        oreCopperOre = new OreBlock(Material.rock).setBlockName("CopperOre");
        oreTinOre = new OreBlock(Material.rock).setBlockName("TinOre");
        oreLeadOre = new OreBlock(Material.rock).setBlockName("LeadOre");
        oreSilverOre = new OreBlock(Material.rock).setBlockName("SilverOre");
        oreTopazOre = new OreBlock(Material.rock).setBlockName("TopazOre");
        //Blocks
        //StorageBlocks
        blockCopperBlock = new CopperBlock(Material.iron).setBlockName("CopperBlock");
        blockSilverBlock = new SilverBlock(Material.iron).setBlockName("SilverBlock");
        blockTinBlock = new TinBlock(Material.iron).setBlockName("TinBlock");
        blockLeadBlock = new LeadBlock(Material.iron).setBlockName("LeadBlock");
        blockTopazBlock = new TopazBlock(Material.iron).setBlockName("TopazBlock");
        //NiceStuff
        blockObsidianTable = new ObsidianTable(Material.rock).setBlockName("ObsidianTable");
        //Items
        //Ingots
        itemCopperIngot = new DBItems().setUnlocalizedName("CopperIngot");
        itemTinIngot = new DBItems().setUnlocalizedName("TinIngot");
        itemSilverIngot = new DBItems().setUnlocalizedName("SilverIngot");
        itemLeadIngot = new DBItems().setUnlocalizedName("LeadIngot");
        //Gears
        itemWoodenGear = new DBItems().setUnlocalizedName("WoodenGear");
        itemStoneGear = new DBItems().setUnlocalizedName("StoneGear");
        itemIronGear = new DBItems().setUnlocalizedName("IronGear");
        //Fuels
        itemCoalCoke = new DBItems().setUnlocalizedName("CoalCoke");
        itemTreePitch = new DBItems().setUnlocalizedName("TreePitch");
        //RandomShit
        itemIronWasher = new DBItems().setUnlocalizedName("IronWasher");
        itemIronDisc = new DBItems().setUnlocalizedName("IronDisc");
        itemTinCog = new DBItems().setUnlocalizedName("TinCog");
        itemStaff = new DBItems().setUnlocalizedName("Staff");
        //Gems
        itemTopaz = new DBItems().setUnlocalizedName("Topaz");
        //DurableItems
        itemIronHammer = new IronHammer().setUnlocalizedName("IronHammer");
        itemIronPunch = new IronPunch().setUnlocalizedName("IronPunch");
        //Tools
        //Topaz
        itemTopazSword = new TopazSword(TopazMaterial).setUnlocalizedName("TopazSword");
        itemTopazAxe = new TopazAxe(TopazMaterial).setUnlocalizedName("TopazAxe");
        itemTopazShovel = new TopazShovel(TopazMaterial).setUnlocalizedName("TopazShovel");
        itemTopazHoe = new TopazHoe(TopazMaterial).setUnlocalizedName("TopazHoe");
        itemTopazPickaxe = new TopazPickaxe(TopazMaterial).setUnlocalizedName("TopazPickaxe");
        // Machines
        blockAlabasterOvenIdle = new AlabasterOven(false).setBlockName("AlabasterOvenIdle").setCreativeTab(LetsModNG.letsmodngTab).setHardness(3.5F);
        blockAlabasterOvenActive = new AlabasterOven(true).setBlockName("AlabasterOvenActive").setLightLevel(0.625F).setHardness(3.5F);

        //RegisterStuff
        //Ores
        GameRegistry.registerBlock(oreCopperOre, "CopperOre");
        GameRegistry.registerBlock(oreTinOre, "TinOre");
        GameRegistry.registerBlock(oreLeadOre, "LeadOre");
        GameRegistry.registerBlock(oreSilverOre, "SilverOre");
        GameRegistry.registerBlock(oreTopazOre, "TopazOre");
        //Blocks
        //StorageBlocks
        GameRegistry.registerBlock(blockCopperBlock, "CopperBlock");
        GameRegistry.registerBlock(blockSilverBlock, "SilverBlock");
        GameRegistry.registerBlock(blockTinBlock, "TinBlock");
        GameRegistry.registerBlock(blockLeadBlock, "LeadBlock");
        GameRegistry.registerBlock(blockTopazBlock, "TopazBlock");
        //NiceStuff
        GameRegistry.registerBlock(blockObsidianTable, "ObsidianTable");
        //Items
        //Ingots
        GameRegistry.registerItem(itemCopperIngot, "CopperIngot");
        GameRegistry.registerItem(itemTinIngot, "TinIngot");
        GameRegistry.registerItem(itemSilverIngot, "SilverIngot");
        GameRegistry.registerItem(itemLeadIngot, "LeadIngot");
        //Gears
        GameRegistry.registerItem(itemWoodenGear, "WoodenGear");
        GameRegistry.registerItem(itemStoneGear, "StoneGear");
        GameRegistry.registerItem(itemIronGear, "IronGear");
        //Fuels
        GameRegistry.registerItem(itemCoalCoke, "CoalCoke");
        GameRegistry.registerItem(itemTreePitch, "TreePitch");
        //RandomShit
        GameRegistry.registerItem(itemStaff, "Staff");
        GameRegistry.registerItem(itemTinCog, "TinCog");
        GameRegistry.registerItem(itemIronWasher, "IronWasher");
        GameRegistry.registerItem(itemIronDisc, "IronDisc");
        //DurableItems
        GameRegistry.registerItem(itemIronHammer, "IronHammer");
        GameRegistry.registerItem(itemIronPunch, "IronPunch");
        //Gems
        GameRegistry.registerItem(itemTopaz, "Topaz");
        //Tools
        //Topaz
        GameRegistry.registerItem(itemTopazAxe, "TopazAxe");
        GameRegistry.registerItem(itemTopazHoe, "TopazHoe");
        GameRegistry.registerItem(itemTopazShovel, "TopazShovel");
        GameRegistry.registerItem(itemTopazSword, "TopazSword");
        GameRegistry.registerItem(itemTopazPickaxe, "TopazPickaxe");
        //Machines
        GameRegistry.registerBlock(blockAlabasterOvenIdle, "AlabasterOvenIdle");
        GameRegistry.registerBlock(blockAlabasterOvenActive, "AlabasterOvenActive");
        //WorldGen
        GameRegistry.registerWorldGenerator(eventWorldGen, 0);
        //Renderers
        dennisProxy.registerRenderThings();

    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event){

        //CraftingHandler
        FMLCommonHandler.instance().bus().register(new CraftingHandler());
        //GUIHandler
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        //FuelHandler
        GameRegistry.registerFuelHandler(new FuelHandler());
        //Entities
        EntityHandler.registerMonsters(EntityCyclops.class, "Cyclops");
        //TileEntities
        GameRegistry.registerTileEntity(TileEntityAlabasterOven.class, "AlabasterOven");
        //Recipes
        //Remover/Changer
        RecipeRemover.removeCraftingRecipe();
        //RecipeRemover.removeFurnaceRecipe();
        //Shaped
        //StorageBlocks
        GameRegistry.addRecipe(new ItemStack(blockCopperBlock), new Object[]{"CCC", "CCC", "CCC", 'C', itemCopperIngot});
        GameRegistry.addRecipe(new ItemStack(blockTinBlock), new Object[]{"TTT", "TTT", "TTT", 'T', itemTinIngot});
        GameRegistry.addRecipe(new ItemStack(blockSilverBlock), new Object[]{"SSS", "SSS", "SSS", 'S', itemSilverIngot});
        GameRegistry.addRecipe(new ItemStack(blockLeadBlock), new Object[]{"LLL", "LLL", "LLL", 'L', itemLeadIngot});
        GameRegistry.addRecipe(new ItemStack(blockTopazBlock), new Object[]{"TTT", "TTT", "TTT", 'T', itemTopaz});
        //DurableItems
        GameRegistry.addRecipe(new ItemStack(itemIronHammer), new Object[]{"III", "ISI", " S ", 'I', Items.iron_ingot, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(itemIronPunch), new Object[]{" I ", " C ", " S ", 'I', Items.iron_ingot, 'C', Blocks.cobblestone, 'S', Items.stick});
        //Gears
        GameRegistry.addRecipe(new ItemStack(itemWoodenGear), new Object[]{" W ", "W W", " W ", 'W', Items.stick});
        GameRegistry.addRecipe(new ItemStack(itemStoneGear), new Object[]{" S ", "SWS", " S ", 'S', Blocks.cobblestone, 'W', itemWoodenGear});
        GameRegistry.addRecipe(new ItemStack(itemIronGear), new Object[]{" I ", "ISI", " I ", 'I', Items.iron_ingot, 'S', itemStoneGear});
        //RandomShit
        GameRegistry.addRecipe(new ItemStack(itemTinCog), new Object[]{" T ", "TIT", " T ", 'T', itemTinIngot, 'I', Items.iron_ingot});
        GameRegistry.addRecipe(new ItemStack(Items.book), new Object[]{"LLL", "PPP", "LLL", 'L', Items.leather, 'P', Items.paper});
        GameRegistry.addRecipe(new ItemStack(Blocks.furnace), new Object[]{"SSS", "S S", "SSS", 'S', Blocks.stone});
        GameRegistry.addRecipe(new ItemStack(Items.stick, 6), new Object[]{"X", "X", "X", 'X', Blocks.planks});
        //NiceStuff
        GameRegistry.addRecipe(new ItemStack(blockObsidianTable), new Object[]{"IOI", "OOO", "IOI", 'I', Blocks.iron_block, 'O', Blocks.obsidian});
        //Shapeless
        //Test
        GameRegistry.addShapelessRecipe(new ItemStack(oreCopperOre), new Object[]{itemCopperIngot, Blocks.cobblestone});
        //StorageBlocks
        GameRegistry.addShapelessRecipe(new ItemStack(itemCopperIngot, 9), new Object[]{blockCopperBlock});
        GameRegistry.addShapelessRecipe(new ItemStack(itemLeadIngot, 9), new Object[]{blockLeadBlock});
        GameRegistry.addShapelessRecipe(new ItemStack(itemSilverIngot, 9), new Object[]{blockSilverBlock});
        GameRegistry.addShapelessRecipe(new ItemStack(itemTinIngot, 9), new Object[]{blockTinBlock});
        GameRegistry.addShapelessRecipe(new ItemStack(itemTopaz, 9), new Object[]{blockTopazBlock});
        //Shaped
        //Tools
        //Topaz
        GameRegistry.addRecipe(new ItemStack(itemTopazAxe), new Object[]{"TT ", "TS ", " S ", 'T', itemTopaz, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(itemTopazHoe), new Object[]{"TT ", " S ", " S ", 'T', itemTopaz, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(itemTopazPickaxe), new Object[]{"TTT", " S ", " S ", 'T', itemTopaz, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(itemTopazShovel), new Object[]{" T ", " S ", " S ", 'T', itemTopaz, 'S', Items.stick});
        GameRegistry.addRecipe(new ItemStack(itemTopazSword), new Object[]{" T ", " T ", " S ", 'T', itemTopaz, 'S', Items.stick});
        //Machines
        GameRegistry.addRecipe(new ItemStack(blockAlabasterOvenIdle), new Object[]{"STS", "TFT", "STS", 'S', Blocks.stone, 'T', itemTinIngot, 'F', Blocks.furnace});
        //UseDurableItems
        GameRegistry.addRecipe(new ItemStack(itemIronDisc, 4), new Object[]{"IH", 'I', Items.iron_ingot, 'H', new ItemStack(itemIronHammer, 1, OreDictionary.WILDCARD_VALUE)});
        GameRegistry.addRecipe(new ItemStack(itemIronWasher), new Object[]{"DP", 'D', itemIronDisc, 'P', new ItemStack(itemIronPunch, 1, OreDictionary.WILDCARD_VALUE)});
        //Smelting
        //Ingots
        GameRegistry.addSmelting(oreCopperOre, new ItemStack(itemCopperIngot), 0);
        GameRegistry.addSmelting(oreTinOre, new ItemStack(itemTinIngot), 0);
        GameRegistry.addSmelting(oreSilverOre, new ItemStack(itemSilverIngot), 0);
        GameRegistry.addSmelting(oreLeadOre, new ItemStack(itemLeadIngot), 0);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
}