package com.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PoweredRailBlock;
import net.minecraft.block.enums.RailShape;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("tutorial");
	//public static final Block LAPIS_RAIL  = new PoweredRailBlock(FabricBlockSettings.copy(Blocks.POWERED_RAIL));
	public static final Block LAPIS_RAIL = new LapisRailBlock(AbstractBlock.Settings.create().noCollision().strength(0.7f).sounds(BlockSoundGroup.METAL));

    public static final TagKey<Block> TAG_POWERED_RAILS = TagKey.of(
            RegistryKeys.BLOCK, new Identifier("tutorial", "powered_rails")
    );

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		Registry.register(Registries.BLOCK, new Identifier("tutorial", "lapis_rail"), LAPIS_RAIL);
        Registry.register(Registries.ITEM, new Identifier("tutorial", "lapis_rail"), new BlockItem(LAPIS_RAIL, new FabricItemSettings()));
		
	}
}