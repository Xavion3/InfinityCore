package com.gmail.mcrayjason.infinitycore.compatibility;

import com.gmail.mcrayjason.infinitycore.InfinityCore;
import com.gmail.mcrayjason.infinitycore.helpers.LogHelper;
import com.gmail.mcrayjason.infinitycore.init.ModItems;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;
import gregtech.api.GregTech_API;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import thaumcraft.api.ItemApi;

import java.io.IOException;


public class CrossModCompat
{
    public static void sendIMCMessages()
    {
        if (Loader.isModLoaded("Thaumcraft")) {
            sendThaumcraftIMC();
        }
        if (Loader.isModLoaded("ChickenChunks")) {
            gregifyChickenchunks();
        }
        if (Loader.isModLoaded("NotEnoughItems")) {
            hideNEIItems();
        }
        if (Loader.isModLoaded("HardcoreEnderExpansion")) {
            sendHEEIMC();
        }
    }

    public static void hideNEIItems()
    {
        try {
        String data = Resources.toString(Resources.getResource(InfinityCore.class, "/minetweaker/InfinityCore.zs"), Charsets.UTF_8);
        NBTTagCompound nbtData = new NBTTagCompound();
        nbtData.setString("name", "InfinityCore.zs");
        nbtData.setString("content", data);
        FMLInterModComms.sendMessage("MineTweaker3", "addMineTweakerScript", nbtData);
    }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public static void gregifyChickenchunks()
    {
        LogHelper.info("ChickenChunks Detected. Gregifying recipes");
        try {
            String data = Resources.toString(Resources.getResource(InfinityCore.class, "/minetweaker/ChickenChunks.zs"), Charsets.UTF_8);
            NBTTagCompound nbtData = new NBTTagCompound();
            nbtData.setString("name", "ChickenChunks.zs");
            nbtData.setString("content", data);
            FMLInterModComms.sendMessage("MineTweaker3", "addMineTweakerScript", nbtData);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public static void sendThaumcraftIMC()
        {
            LogHelper.info("Adding Clusters to GregTech ores");
            // Our Clusters
            // Aluminium Clusters
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Aluminium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 0 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Aluminium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 0 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Aluminium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 0 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Aluminium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 0 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Aluminium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 0 + ",1.0");
            // Beryllium Clusters
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Beryllium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 1 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Beryllium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 1 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Beryllium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 1 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Beryllium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 1 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Beryllium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 1 + ",1.0");
            // Cobalt Clusters
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Cobalt, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 2 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Cobalt, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 2 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Cobalt, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 2 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Cobalt, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 2 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Cobalt, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 2 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Cobaltite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 2 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Cobaltite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 2 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Cobaltite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 2 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Cobaltite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 2 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Cobaltite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 2 + ",1.0");
            // Iridium Clusters
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Iridium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 3 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Iridium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 3 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Iridium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 3 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Iridium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 3 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Iridium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 3 + ",1.0");
            // Molybdenum Clusters
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Molybdenum, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 4 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Molybdenum, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 4 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Molybdenum, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 4 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Molybdenum, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 4 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Molybdenum, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 4 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Molybdenite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 4 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Molybdenite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 4 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Molybdenite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 4 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Molybdenite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 4 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Molybdenite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 4 + ",1.0");
            // Naquadah Clusters
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Naquadah, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 0 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Naquadah, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 5 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Naquadah, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 5 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Naquadah, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 5 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Naquadah, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 5 + ",1.0");
            // Neodymium Clusters
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Neodymium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 6 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Neodymium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 6 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Neodymium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 6 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Neodymium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 6 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Neodymium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 6 + ",1.0");
            // Nickel Clusters
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Nickel, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 7 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Nickel, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 7 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Nickel, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 7 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Nickel, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 7 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Nickel, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 7 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Garnierite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 7 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Garnierite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 7 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Garnierite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 7 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Garnierite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 7 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Garnierite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 7 + ",1.0");
            // Palladium Clusters
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Palladium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 8 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Palladium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 8 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Palladium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 8 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Palladium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 8 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Palladium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 8 + ",1.0");
            // Platinum Clusters
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Platinum, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 9 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Platinum, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 9 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Platinum, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 9 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Platinum, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 9 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Platinum, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 9 + ",1.0");
            // Thorium Clusters
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Thorium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 10 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Thorium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 10 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Thorium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 10 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Thorium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 10 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Thorium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 10 + ",1.0");
            // Tungsten Clusters
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Tungsten, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 11 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Tungsten, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 11 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Tungsten, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 11 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Tungsten, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 11 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Tungsten, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 11 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Tungstate, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 11 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Tungstate, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 11 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Tungstate, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 11 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Tungstate, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 11 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Tungstate, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 11 + ",1.0");
            // Uranium 235 Clusters
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Uranium235, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 12 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Uranium235, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 12 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Uranium235, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 12 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Uranium235, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 12 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Uranium235, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 12 + ",1.0");
            // Uranium 238 Clusters
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Uranium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 13 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Uranium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 13 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Uranium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 13 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Uranium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 13 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Uranium, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 13 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Uraninite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 13 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Uraninite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 13 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Uraninite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 13 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Uraninite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 13 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Uraninite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 13 + ",1.0");
            // Zinc Clusters
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Zinc, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 14 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Zinc, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 14 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Zinc, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 14 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Zinc, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 14 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Zinc, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 14 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Sphalerite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 14 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Sphalerite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 14 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Sphalerite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 14 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Sphalerite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 14 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Sphalerite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 14 + ",1.0");
            // Cassiterite Cluster
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Cassiterite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 15 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Cassiterite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 15 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Cassiterite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 15 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Cassiterite, 1L).getItemDamage() + "," + Item.getIdFromItem(ModItems.itemCluster) + "," + 15 + ",1.0");


            // Thaumcraft Clusters
            ItemStack tcCluster = ItemApi.getItem("itemNugget", 0);
            // Iron Clusters
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Iron, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 16 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Iron, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 16 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Iron, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 16 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Iron, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 16 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Iron, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 16 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.BrownLimonite, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 16 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.BrownLimonite, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 16 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.BrownLimonite, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 16 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.BrownLimonite, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 16 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.BrownLimonite, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 16 + ",1.0");
            // Gold Clusters
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Gold, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 31 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Gold, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 31 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Gold, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 31 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Iron, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 31 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Gold, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 31 + ",1.0");
            // Gold Clusters
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Silver, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 19 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Silver, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 19 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Silver, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 19 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Silver, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 19 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Silver, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 19 + ",1.0");
            // Tin Clusters
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Tin, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 18 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Tin, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 18 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Tin, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 18 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Tin, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 18 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Tin, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 18 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Cassiterite, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 18 + ",2.0");
            // Lead Clusters
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Lead, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 20 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Lead, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 20 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Lead, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 20 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Lead, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 20 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Lead, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 20 + ",1.0");
            // Copper Clusters
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Copper, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 17 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Copper, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 17 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Copper, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 17 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Copper, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 17 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Copper, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 17 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Tetrahedrite, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 17 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Tetrahedrite, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 17 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Tetrahedrite, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 17 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Tetrahedrite, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 17 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Tetrahedrite, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 17 + ",1.0");
            // Cinnabar Clusters
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Cinnabar, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 21 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Cinnabar, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 21 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Cinnabar, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 21 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Cinnabar, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 21 + ",1.0");
            FMLInterModComms.sendMessage("Thaumcraft", "nativeCluster", Block.getIdFromBlock(GregTech_API.sBlockOres1) + "," + GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Cinnabar, 1L).getItemDamage() + "," + Item.getIdFromItem(tcCluster.getItem()) + "," + 21 + ",1.0");
        }

    public static void sendHEEIMC() {
        FMLInterModComms.sendMessage("HardcoreEnderExpansion", "HEE:DragonEssence:AddRecipe", "{\"input\":{\"id\":\"InfinityCore:dormantEgg\"}, \"output\":{\"id\":\"dragon_egg\"}, \"cost\": 150}");
    }
}


