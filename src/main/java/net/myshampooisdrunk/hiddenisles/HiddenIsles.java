package net.myshampooisdrunk.hiddenisles;

import net.fabricmc.api.ModInitializer;
import net.myshampooisdrunk.hiddenisles.block.ModBlocks;
import net.myshampooisdrunk.hiddenisles.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HiddenIsles implements ModInitializer {
	public static final String MOD_ID = "hiddenisles";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

	}
}
