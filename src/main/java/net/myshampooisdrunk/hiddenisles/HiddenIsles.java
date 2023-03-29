package net.myshampooisdrunk.hiddenisles;

import net.fabricmc.api.ModInitializer;
import net.myshampooisdrunk.hiddenisles.block.ModBlocks;
import net.myshampooisdrunk.hiddenisles.client.render.ModRenderRegistry;
import net.myshampooisdrunk.hiddenisles.effects.ModStatusEffects;
import net.myshampooisdrunk.hiddenisles.entity.registry.EntityRegistry;
import net.myshampooisdrunk.hiddenisles.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class HiddenIsles implements ModInitializer {
	public static final String MOD_ID = "hiddenisles";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		GeckoLib.initialize();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModStatusEffects.registerEffects();
		ModRenderRegistry.init();
		EntityRegistry.init();
	}
}
