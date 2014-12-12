package com.dennisbonke.letsmodng.worldgen;

import com.dennisbonke.letsmodng.LetsModNG;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class LetsModNGWorldGen implements IWorldGenerator{

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId) {
            case 0:
                //Generate our surface world
                generateSurface(world, random, chunkX*16, chunkZ*16);

            case -1:
                //Generate our nether world
                generateNether(world, random, chunkX * 16, chunkZ * 16);

            case 1:
                //Generate our end world
                generateEnd(world, random, chunkX * 16, chunkZ * 16);
        }
    }

    private void generateEnd(World world, Random random, int x, int z) {
    }

    private void generateNether(World world, Random random, int x, int z) {
    }

    private void generateSurface(World world, Random random, int x, int z) {
        //this.addOreSpawn(LetsModNG.oreWhatever, world, random, x=blockXPos, z=blockZPos, maxX, maxZ, maxVeinSize, chancetospawn, minY, maxY)
        this.addOreSpawn(LetsModNG.oreCopperOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 38, 100);
        this.addOreSpawn(LetsModNG.oreTinOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 38, 100);
        this.addOreSpawn(LetsModNG.oreSilverOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 38, 100);
        this.addOreSpawn(LetsModNG.oreLeadOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 38, 100);
    }

    private void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY) {
        for(int i = 0; i < chanceToSpawn; i++){
            int posX = blockXPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(maxZ);
            (new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
        }
    }
}
