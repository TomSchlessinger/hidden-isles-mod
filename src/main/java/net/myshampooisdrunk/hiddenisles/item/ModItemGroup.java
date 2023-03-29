package net.myshampooisdrunk.hiddenisles.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.text.Text;
import net.myshampooisdrunk.hiddenisles.HiddenIsles;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {


    public static ItemGroup HIDDENISLESTAB;

    static {
        HIDDENISLESTAB = FabricItemGroup.builder(new Identifier(HiddenIsles.MOD_ID, "hiddenislestab"))
                .displayName(Text.literal("Hidden Isles Item Group"))
                .icon(() -> new ItemStack(ModItems.PRIMORDIUM_INGOT)).build();
    }
}
