package com.dennisbonke.letsmodng.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

import java.util.Iterator;
import java.util.List;

public class RecipeRemover {

    public static void removeCraftingRecipe() {
        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();

        Iterator<IRecipe> remover = recipes.iterator();

        while (remover.hasNext()) {
            ItemStack itemstack = remover.next().getRecipeOutput();
            if (itemstack != null && itemstack.getItem() == Items.book) {
                remover.remove();
            } else if (itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.furnace)){
                remover.remove();
            } else if (itemstack != null && itemstack.getItem() == Items.stick){
                remover.remove();
            }
        }
    }

    /*public static void removeFurnaceRecipe(){
        List<IRecipe> recipes = FurnaceRecipes.smelting().getSmeltingList();

        Iterator<IRecipe> remover = recipes.iterator();

        while (remover.hasNext()) {
            ItemStack itemstack = remover.next().getRecipeOutput();
            if (itemstack != null && itemstack.getItem() == Items.book) {
                remover.remove();
            }
    }*/

}