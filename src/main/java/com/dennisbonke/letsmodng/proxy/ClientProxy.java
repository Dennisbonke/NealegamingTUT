package com.dennisbonke.letsmodng.proxy;

import com.dennisbonke.letsmodng.LetsModNG;
import com.dennisbonke.letsmodng.renderer.ItemRenderObsidianTable;
import com.dennisbonke.letsmodng.renderer.RenderObsidianTable;
import com.dennisbonke.letsmodng.tileentity.TileEntityObsidianTable;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy{

    public void registerRenderThings(){
        //Obsidian Table
        TileEntitySpecialRenderer render = new RenderObsidianTable();
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityObsidianTable.class, render);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(LetsModNG.blockObsidianTable), new ItemRenderObsidianTable(render, new TileEntityObsidianTable()));

    }

    public void registerTileEntitySpecialRenderer(){

    }
}
