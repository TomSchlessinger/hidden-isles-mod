package net.myshampooisdrunk.hiddenisles.client.keybinding;


import org.lwjgl.glfw.GLFW;

import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.StickyKeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.LiteralText;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class HiddenIslesClient implements ClientModInitializer {
    public static KeyBinding ability;

    @Override
    public void onInitializeClient() {
        System.out.println("client init");
        ability = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.hiddenisles.ability",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                "category.hiddenisles.keys"
        ));

    }
}
