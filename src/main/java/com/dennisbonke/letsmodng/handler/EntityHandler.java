package com.dennisbonke.letsmodng.handler;

import com.dennisbonke.letsmodng.LetsModNG;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;

import java.util.Random;

public class EntityHandler {

    public static void registerEntities(Class entityClass, String name){
        int entityID = EntityRegistry.findGlobalUniqueEntityId();
        long x = name.hashCode();
        Random random = new Random(x);
        int mainColor = random.nextInt() * 16777215;
        int subColor = random.nextInt() * 16777215;

        EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
        EntityRegistry.registerModEntity(entityClass, name, entityID, LetsModNG.instance, 64, 1, true);
        EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, mainColor, subColor));

    }
}
