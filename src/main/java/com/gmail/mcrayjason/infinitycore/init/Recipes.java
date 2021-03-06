package com.gmail.mcrayjason.infinitycore.init;

import chylex.hee.block.BlockEnderGoo;
import com.gmail.mcrayjason.infinitycore.helpers.LogHelper;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import crazypants.enderio.EnderIO;
import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import ic2.api.item.IC2Items;
import magicbees.item.types.ResourceType;
import magicbees.main.Config;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import pneumaticCraft.common.block.Blockss;
import pneumaticCraft.common.item.Itemss;
import scala.tools.nsc.backend.icode.Primitives;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigItems;

import java.util.Iterator;
import java.util.List;

public class Recipes {
    @SuppressWarnings("RedundantArrayCreation")

    private static InfusionRecipe dormantEggInfusion;
    private static InfusionRecipe magicCatalystInfusion;
    private static InfusionRecipe fuelCatalystInfusion;
    private static InfusionRecipe dobCatalystInfusion;
    private static InfusionRecipe dragonEggInfusion;

    private static ItemStack shardAir = ItemApi.getItem("itemShard", 0);
    private static ItemStack shardFire = ItemApi.getItem("itemShard", 1);
    private static ItemStack shardWater = ItemApi.getItem("itemShard", 2);
    private static ItemStack shardEarth = ItemApi.getItem("itemShard", 3);
    private static ItemStack shardOrder = ItemApi.getItem("itemShard", 4);
    private static ItemStack shardEntropy = ItemApi.getItem("itemShard", 5);
    private static ItemStack shardBalanced = ItemApi.getItem("itemShard", 6);

    public static void registerRecipes() {
        // Crafting Recipes
        // Blocks
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.pneumaticCasing),
                "ppp", "pwp", "ppp",
                'p', "plateIronCompressed", 'w', "craftingToolWrench"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.pneumaticCasingAdvanced),
                "pPp", "PwP", "pPp",
                'p', "plateIronCompressed", 'P', new ItemStack(Itemss.plastic, 1, 4), 'w', "craftingToolWrench"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.pneumaticHull),
                "wPw", "tCt",
                'w', "plateWroughtIron", 'P', new ItemStack(ModItems.itemMaterial, 1, 2), 't', new ItemStack(Blockss.pressureTube, 1, 0), 'C', new ItemStack(ModBlocks.pneumaticCasing)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.pneumaticHullAdvanced),
                "pPp", "tCt",
                'p', "platePlastic", 'P', new ItemStack(Itemss.plastic, 1, 4), 't', new ItemStack(Blockss.advancedPressureTube, 1, 0), 'C', new ItemStack(ModBlocks.pneumaticCasingAdvanced)));

        // Items
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.itemMaterial, 1, 0),
                "fws",
                's', "craftingToolSaw", 'w', "plateWood", 'f', "craftingToolFile"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemMaterial, 9, 1),
                "ingotEnderiumBase"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(EnderIO.itemPowderIngot, 1, 6),
                "nnn", "nnn", "nnn",
                'n', "nuggetEnderiumBase"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.droneFrame),
                "rer", "mcm", "Srs",
                'r', new ItemStack(Itemss.turbineRotor), 'e', "oc:eeprom", 'm', "oc:ram2", 'c', "oc:droneCase1", 'S', new ItemStack(ModItems.itemMaterial, 1, 6), 's', "craftingToolScrewdriver"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.droneFrame),
                "rer", "mcm", "srS",
                'r', new ItemStack(Itemss.turbineRotor), 'e', "oc:eeprom", 'm', "oc:ram2", 'c', "oc:droneCase1", 'S', new ItemStack(ModItems.itemMaterial, 1, 6), 's', "craftingToolScrewdriver"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.itemMaterial, 1, 13),
                "f  ", " c ",
                'f', "craftingToolFile", 'c', "cobblestone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.itemMaterial, 1, 14),
                "f  ", " s ",
                'f', "craftingToolFile", 's', "sandstone"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.itemMaterial, 1, 15),
                "f  ", " h ",
                'f', "craftingToolFile", 'h', new ItemStack(Blocks.hardened_clay)));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemMaterial, 1, 16),
                "toolPot", "listAllwater"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemMaterial, 1, 22),
                "gemCertusQuartz", "crystalFluix", "gemRuby", "gemSapphire", "gemGreenSapphire", new ItemStack(Items.diamond), "gemOlivine", "gemEmerald", "gemLapis"));
        GameRegistry.addRecipe(new ItemStack(ModItems.itemCatalyst, 1, 2),
                "p", "s", "r",
                'p', IC2Items.getItem("plantBall"), 'r', IC2Items.getItem("resin"), 's', GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.itemMaterial, 1, 24),
                "h p",
                'h', "craftingToolHardHammer", 'p', "plateElectricalSteel"));

        // Special Reuse Recipes
        GameRegistry.addRecipe(new ShapedOreRecipe(ItemApi.getItem("itemWandCap", 3), // Copper Wand Cap (remove original via Minetweaker script)
                " o ", "tOH",
                'o', "roundCopper", 't', ConfigItems.itemThaumonomicon.setContainerItem(ConfigItems.itemThaumonomicon), 'O', "ringCopper", 'H', "craftingToolHardHammer"));

        // GregTech Processing Recipes
        GT_Values.RA.addAssemblerRecipe(new ItemStack(ModItems.itemMaterial, 8, 2), ItemList.Circuit_Integrated.getWithDamage(0L, 8L), new ItemStack(ModBlocks.pneumaticCasing), 50, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack(ModItems.itemMaterial, 4, 2), new ItemStack(Itemss.plastic, 4, 4), new ItemStack(ModBlocks.pneumaticCasingAdvanced), 50, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack(ModBlocks.pneumaticCasing), new ItemStack(Blockss.pressureTube, 2), Materials.Plastic.getMolten(288), new ItemStack(ModBlocks.pneumaticHull), 50, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack(ModBlocks.pneumaticCasingAdvanced), new ItemStack(Blockss.advancedPressureTube, 2), Materials.Plastic.getMolten(288), new ItemStack(ModBlocks.pneumaticHullAdvanced), 50, 16);
        GT_Values.RA.addAssemblerRecipe(new ItemStack(ModItems.droneFrame), new ItemStack(Itemss.printedCircuitBoard), Materials.Plastic.getMolten(144), new ItemStack(Itemss.drone), 600, 120);
        GT_Values.RA.addAssemblerRecipe(new ItemStack(ModItems.droneFrame), GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L), Materials.Plastic.getMolten(144), new ItemStack(Itemss.logisticsDrone), 200, 30);
        // Chromic Platinum (Precious Metal Intermediate)
        GT_Values.RA.addAlloySmelterRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 1L), new ItemStack(ModItems.itemMaterial, 2, 19), 100, 60);
        GT_Values.RA.addAlloySmelterRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Chrome, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 1L), new ItemStack(ModItems.itemMaterial, 2, 19), 100, 60);
        GT_Values.RA.addAlloySmelterRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Chrome, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Platinum, 1L), new ItemStack(ModItems.itemMaterial, 2, 19), 100, 60);
        GT_Values.RA.addAlloySmelterRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Platinum, 1L), new ItemStack(ModItems.itemMaterial, 2, 19), 100, 60);

        GT_Values.RA.addFormingPressRecipe(new ItemStack(ModItems.itemMaterial, 1, 11), GT_OreDictUnificator.get(OrePrefixes.foil, Materials.AnnealedCopper, 2L), new ItemStack(Itemss.emptyPCB, 1, 100), 200, 60);

        GT_Values.RA.addChemicalRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 1L), Materials.Tin.getMolten(288), Materials.EnderiumBase.getMolten(576), null, 100, 300);
        // Precious Metal Catalyst
        GT_Values.RA.addChemicalRecipe(new ItemStack(ModItems.itemMaterial, 1, 19), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmiridium, 1L), Materials.Electrum.getMolten(288L), null, new ItemStack(ModItems.itemCatalyst, 1, 6), 1200);

        GT_Values.RA.addChemicalBathRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 1L), Materials.Epoxid.getMolten(144), new ItemStack(ModItems.itemMaterial, 1, 11), null, null, new int[] { 10000 }, 400, 10);

        //Alloy Catalyst
        GT_Values.RA.addMixerRecipe(new ItemStack(ModItems.itemMaterial, 1, 20), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedAlloy, 1L), new ItemStack(ModItems.itemMaterial, 1, 21), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L), null, null, new ItemStack(ModItems.itemCatalyst, 1, 3), 100, 8);
        //Lesser Catalyst
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zinc, 1L), Materials.Cupronickel.getMolten(288L), null, new ItemStack(ModItems.itemCatalyst, 1, 5), 100, 8);
        //Greater Catalyst
        GT_Values.RA.addMixerRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1L), null, null, new ItemStack(ModItems.itemCatalyst, 1, 7), 100, 16);

        //Crystalline Seed Grow
        if (Loader.isModLoaded("HardcoreEnderExpansion")) {
        GT_Values.RA.addAutoclaveRecipe(new ItemStack(ModItems.itemMaterial, 1, 22), new FluidStack(BlockEnderGoo.fluid, 2000), new ItemStack(ModItems.itemCatalyst, 1, 4), 1500, 6000, 60); }
        else {
                GT_Values.RA.addAutoclaveRecipe(new ItemStack(ModItems.itemMaterial, 1, 22), Materials.Enderium.getMolten(2000L), new ItemStack(ModItems.itemCatalyst, 1, 4), 1500, 6000, 60);
        }

        //Electrical Steel Item Casing
        GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Casing.get(0L), Materials.ElectricalSteel.getMolten(72), new ItemStack(ModItems.itemMaterial, 1, 24), 16, 8);
        GT_Values.RA.addAlloySmelterRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 2L), ItemList.Shape_Mold_Casing.get(0L), new ItemStack(ModItems.itemMaterial, 3, 24), 128, 16);
        GT_Values.RA.addCutterRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 1L), Materials.Water.getFluid(4),new ItemStack(ModItems.itemMaterial, 2, 24), null, 100, 16);
        GT_Values.RA.addCutterRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 1L), GT_ModHandler.getDistilledWater(3L),new ItemStack(ModItems.itemMaterial, 2, 24), null, 100, 16);
        GT_Values.RA.addCutterRecipe(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.ElectricalSteel, 1L), Materials.Lubricant.getFluid(1),new ItemStack(ModItems.itemMaterial, 2, 24), null, 50, 16);
        GT_Values.RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 1L), ItemList.Shape_Extruder_Casing.get(0L), new ItemStack(ModItems.itemMaterial, 2, 24), 32, 48);

        // Flesh Leather, Leather
        if (Loader.isModLoaded("VeganOption")){
            GT_ModHandler.addCompressionRecipe(GT_ModHandler.getModItem("VeganOption", "rottenPlants", 8, 0), new ItemStack(ModItems.itemMaterial, 1, 25));
            GT_Values.RA.addAlloySmelterRecipe(new ItemStack(ModItems.itemMaterial, 1, 25),GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RockSalt, 16L), new ItemStack(Items.leather), 200, 16);
        }

        // Dimensional Alloy
        GT_Values.RA.addBlastRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Enderium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Naquadah, 1L), null, null, new ItemStack(ModItems.itemMaterial, 2, 26), null, 10800, 120, 5400);
        GT_Values.RA.addVacuumFreezerRecipe(new ItemStack(ModItems.itemMaterial, 1, 26), new ItemStack(ModItems.itemMaterial, 1, 27), 588);
        GT_Values.RA.addBenderRecipe(new ItemStack(ModItems.itemMaterial, 1, 27), new ItemStack(ModItems.itemMaterial, 1, 28), 98, 24);

        // Smelting Recipes
        GameRegistry.addSmelting(new ItemStack(ModItems.itemCluster, 1, 1), (GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Beryllium, 2L)), 0F);
        GameRegistry.addSmelting(new ItemStack(ModItems.itemCluster, 1, 2), (GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 2L)), 0F);
        GameRegistry.addSmelting(new ItemStack(ModItems.itemCluster, 1, 4), (GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Molybdenum, 2L)), 0F);
        GameRegistry.addSmelting(new ItemStack(ModItems.itemCluster, 1, 7), (GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Nickel, 2L)), 0F);
        GameRegistry.addSmelting(new ItemStack(ModItems.itemCluster, 1, 9), (GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Platinum, 2L)), 0F);
        GameRegistry.addSmelting(new ItemStack(ModItems.itemCluster, 1, 10), (GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Thorium, 2L)), 0F);
        GameRegistry.addSmelting(new ItemStack(ModItems.itemCluster, 1, 12), (GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Uranium235, 2L)), 0F);
        GameRegistry.addSmelting(new ItemStack(ModItems.itemCluster, 1, 13), (GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Uranium, 2L)), 0F);
        GameRegistry.addSmelting(new ItemStack(ModItems.itemCluster, 1, 14), (GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Zinc, 2L)), 0F);
        GameRegistry.addSmelting(new ItemStack(ModItems.itemCluster, 1, 15), (GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 4L)), 0F);
        GameRegistry.addSmelting(new ItemStack(ModItems.itemCluster, 1, 17), (GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Lithium, 2L)), 0F);
        GameRegistry.addSmelting(new ItemStack(ModItems.itemCluster, 1, 18), (GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Manganese, 2L)), 0F);
        GameRegistry.addSmelting(new ItemStack(ModItems.itemCluster, 1, 19), (GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Antimony, 2L)), 0F);
        if (Loader.isModLoaded("HardcoreEnderExpansion")) {
            GameRegistry.addSmelting(new ItemStack(ModItems.itemCluster, 1, 20), (new ItemStack(chylex.hee.init.ItemList.endium_ingot, 2)), 0F);
        }
        GameRegistry.addSmelting(new ItemStack(ModItems.itemCluster, 1, 21), (GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Yellorium, 2L)), 0F);
        GameRegistry.addSmelting(new ItemStack(ModItems.itemCluster, 1, 22), (GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Desh, 2L)), 0F);
    }

    public static void registerThaumcraftRecipes() {
        ItemStack dragonChunk = Config.miscResources.getStackForType(ResourceType.DRAGON_CHUNK);
        ItemStack falseLifeEssence = Config.miscResources.getStackForType(ResourceType.ESSENCE_FALSE_LIFE);
        ItemStack dustObsidian = GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L);
        ItemStack enderEye = new ItemStack(Items.ender_eye);
        ItemStack dustNaquadria = GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadria, 1L);

        dormantEggInfusion = ThaumcraftApi.addInfusionCraftingRecipe("IT_DraconicInfusion", new ItemStack(ModItems.dormantEgg), 15, new AspectList().add(Aspect.ELDRITCH, 32).add(Aspect.BEAST, 16).add(Aspect.MAGIC, 16).add(Aspect.LIFE, 8).add(Aspect.DARKNESS, 16).add(Aspect.FLIGHT, 16).add(Aspect.WEATHER, 16), new ItemStack(Items.egg), new ItemStack[]{ falseLifeEssence, dragonChunk, dragonChunk, dragonChunk, dragonChunk, dragonChunk, dragonChunk, dragonChunk, dragonChunk});
        magicCatalystInfusion = ThaumcraftApi.addInfusionCraftingRecipe("IT_CatalystMagic", new ItemStack(ModItems.itemCatalyst, 1, 0), 12, new AspectList().add(Aspect.ORDER, 15).add(Aspect.GREED, 15).add(Aspect.FLIGHT, 50).add(Aspect.getAspect("nebrisum"), 15).add(Aspect.MAGIC, 15), shardBalanced, new ItemStack[] { shardAir, shardFire, shardWater, shardEarth, shardOrder, shardEntropy, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Thaumium, 1L) });
        fuelCatalystInfusion = ThaumcraftApi.addInfusionCraftingRecipe("IT_CatalystFuel", new ItemStack(ModItems.itemCatalyst, 1, 1), 12, new AspectList().add(Aspect.FIRE, 15).add(Aspect.ENERGY, 15).add(Aspect.EXCHANGE, 15), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.OilHeavy, 1L), new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lignite, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Coal, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Uranium235, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Naquadah, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L) } );
        dobCatalystInfusion = ThaumcraftApi.addInfusionCraftingRecipe("IT_CatalystDOB", new ItemStack(ModBlocks.blockCatalyst), 15, new AspectList(), new ItemStack(Blocks.dragon_egg), new ItemStack[] {new ItemStack(ModItems.itemCatalyst, 1, 0), new ItemStack(ModItems.itemCatalyst, 1, 1), new ItemStack(ModItems.itemCatalyst, 1, 2), new ItemStack(ModItems.itemCatalyst, 1, 3), new ItemStack(ModItems.itemCatalyst, 1, 4), new ItemStack(ModItems.itemCatalyst, 1, 5), new ItemStack(ModItems.itemCatalyst, 1, 6), new ItemStack(ModItems.itemCatalyst, 1, 7)} );
        if (!Loader.isModLoaded("HardcoreEnderExpansion")) {
            dragonEggInfusion = ThaumcraftApi.addInfusionCraftingRecipe("IT_DraconicInfusion", new ItemStack(Blocks.dragon_egg), 10, new AspectList().add(Aspect.ELDRITCH, 24).add(Aspect.BEAST, 12).add(Aspect.MAGIC, 12).add(Aspect.LIFE, 6).add(Aspect.DARKNESS, 12).add(Aspect.FLIGHT, 12).add(Aspect.WEATHER, 12), new ItemStack(ModItems.dormantEgg), new ItemStack[]{ dustObsidian, enderEye, dustObsidian, dustNaquadria, dustObsidian, enderEye, dustObsidian, dustNaquadria });
        }
    }

    public static void addResearches() {
        if (Loader.isModLoaded("HardcoreEnderExpansion")) {
            new ResearchItem("IT_DraconicInfusion", "MAGICBEES", new AspectList().add(Aspect.ELDRITCH, 8).add(Aspect.BEAST, 4).add(Aspect.MAGIC, 4).add(Aspect.LIFE, 2).add(Aspect.DARKNESS, 4).add(Aspect.FLIGHT, 4).add(Aspect.WEATHER, 4), 1, 1, 2, new ItemStack(ModItems.dormantEgg))
                    .setPages(new ResearchPage("it.researchPage.draconicInfusion.1"), new ResearchPage(dormantEggInfusion))
                    .setHidden()
                    .setItemTriggers(new ItemStack(Blocks.dragon_egg))
                    .setParents("MB_EssenceLife")
                    .setParentsHidden("GT_MAGICABSORB2")
                    .setConcealed()
                    .setSpecial()
                    .registerResearchItem();
        } else {
            new ResearchItem("IT_DraconicInfusion", "MAGICBEES", new AspectList().add(Aspect.ELDRITCH, 8).add(Aspect.BEAST, 4).add(Aspect.MAGIC, 4).add(Aspect.LIFE, 2).add(Aspect.DARKNESS, 4).add(Aspect.FLIGHT, 4).add(Aspect.WEATHER, 4), 1, 1, 2, new ItemStack(ModItems.dormantEgg))
                    .setPages(new ResearchPage("it.researchPage.draconicInfusion.1"), new ResearchPage(dormantEggInfusion), new ResearchPage(dragonEggInfusion))
                    .setHidden()
                    .setItemTriggers(new ItemStack(Blocks.dragon_egg))
                    .setParents("MB_EssenceLife")
                    .setParentsHidden("GT_MAGICABSORB2")
                    .setConcealed()
                    .setSpecial()
                    .registerResearchItem();
        }

        new ResearchItem("IT_CatalystMagic", "MAGICBEES", new AspectList().add(Aspect.ORDER, 5).add(Aspect.GREED, 5).add(Aspect.FLIGHT, 5).add(Aspect.getAspect("nebrisum"), 5), 3, -3, 3, new ItemStack(ModItems.itemCatalyst, 1, 0))
                .setPages(new ResearchPage("it.researchPage.magicCatalyst.1"), new ResearchPage(magicCatalystInfusion))
                .setHidden()
                .setParentsHidden("INFUSION")
                .setItemTriggers(shardAir).setItemTriggers(shardEarth).setItemTriggers(shardFire).setItemTriggers(shardWater).setItemTriggers(shardOrder).setItemTriggers(shardEntropy).setItemTriggers(shardBalanced)
                .setConcealed()
                .registerResearchItem();

        new ResearchItem("IT_CatalystFuel", "MAGICBEES", new AspectList().add(Aspect.FIRE, 5).add(Aspect.ENERGY, 5).add(Aspect.EXCHANGE, 5), 5, -3, 3, new ItemStack(ModItems.itemCatalyst, 1, 1))
                .setPages(new ResearchPage("it.researchPage.fuelCatalyst.1"), new ResearchPage(fuelCatalystInfusion))
                .setHidden()
                .setParentsHidden("INFUSION")
                .setItemTriggers(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lignite, 1L), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Lignite, 1L)).setItemTriggers(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L), GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Coal, 1L)).setItemTriggers(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Uranium, 1L)).setItemTriggers(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Naquadah, 1L)).setItemTriggers(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L)).setItemTriggers(new ItemStack(Items.redstone))
                .setConcealed()
                .registerResearchItem();

        new ResearchItem("IT_CatalystDOB", "MAGICBEES", new AspectList().add(Aspect.ORDER, 10).add(Aspect.GREED, 10).add(Aspect.FLIGHT, 10).add(Aspect.getAspect("nebrisum"), 10).add(Aspect.FIRE, 10).add(Aspect.ENERGY, 10).add(Aspect.EXCHANGE, 10), 4, -5, 3, new ItemStack(ModBlocks.blockCatalyst))
                .setPages(new ResearchPage("it.researchPage.dobCatalyst.1"), new ResearchPage(dobCatalystInfusion))
                .setParents("IT_CatalystFuel", "IT_CatalystMagic")
                .setSpecial()
                .registerResearchItem();
    }

    public static void removeCraftingRecipes() {
        removeRecipe(Itemss.drone);
        removeRecipe(Itemss.logisticsDrone);
        removeRecipe(Blocks.dragon_egg);
        }

    @SuppressWarnings("unchecked")
    private static void removeRecipe(Item output){
            int recipesRemoved = 0;

        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
        Iterator<IRecipe> remover = recipes.iterator();

        while (remover.hasNext()) {
            ItemStack itemstack = remover.next().getRecipeOutput();

            if (itemstack != null && itemstack.getItem() == output && itemstack.getTagCompound() == null){
                remover.remove();
                recipesRemoved++;
            }
        }
            LogHelper.info("Removed %d recipes for %s", recipesRemoved, Item.itemRegistry.getNameForObject(output));
    }

    @SuppressWarnings("unchecked")
    private static void removeRecipe(Block output) {
            int recipesRemoved = 0;

        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
        Iterator<IRecipe> remover = recipes.iterator();

        while (remover.hasNext()) {
            ItemStack itemstack = remover.next().getRecipeOutput();

            if (itemstack != null && itemstack.getItem() == Item.getItemFromBlock(output) && itemstack.getTagCompound() == null){
                remover.remove();
                recipesRemoved++;
            }
        }
            LogHelper.info("Removed %d recipes for %s", recipesRemoved, Block.blockRegistry.getNameForObject(output));
    }
}


