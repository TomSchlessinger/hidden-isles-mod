package net.myshampooisdrunk.hiddenisles.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.myshampooisdrunk.hiddenisles.HiddenIsles;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.myshampooisdrunk.hiddenisles.item.ModItemGroup;

public class ModBlocks {
    public static final Block PRIMORDIUM_ORE = registerBlock("primordium_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool()), ModItemGroup.HIDDENISLESTAB);
    public static final Block PRISTINIUM_ORE = registerBlock("pristinium_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool()), ModItemGroup.HIDDENISLESTAB);
    public static final Block COORDIUM_ORE = registerBlock("coordium_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool()), ModItemGroup.HIDDENISLESTAB);
    public static final Block TROCELLATE_ORE = registerBlock("trocellate_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool()), ModItemGroup.HIDDENISLESTAB);
    public static final Block DOMDECON_ORE = registerBlock("domdecon_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool()), ModItemGroup.HIDDENISLESTAB);
    public static final Block ASCONDELLUM_ORE = registerBlock("ascondellum_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool()), ModItemGroup.HIDDENISLESTAB);
    public static final Block ARCONLON_ORE = registerBlock("arconlon_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(6f).requiresTool()), ModItemGroup.HIDDENISLESTAB);



    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(HiddenIsles.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(block));
        return Registry.register(Registries.ITEM, new Identifier(HiddenIsles.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        HiddenIsles.LOGGER.info("Registering ModBlocks for " + HiddenIsles.MOD_ID);
    }
}