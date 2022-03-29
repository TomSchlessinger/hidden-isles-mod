package net.myshampooisdrunk.hiddenisles.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.myshampooisdrunk.hiddenisles.HiddenIsles;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup HIDDENISLESTAB = FabricItemGroupBuilder.build(new Identifier(HiddenIsles.MOD_ID, "hiddenislestab"),
            () -> new ItemStack(ModItems.PRIMORDIUM_CLUSTER));
}
