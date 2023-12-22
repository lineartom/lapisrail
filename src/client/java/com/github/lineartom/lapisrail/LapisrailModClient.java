package com.github.lineartom.lapisrail;

import com.github.lineartom.lapisrail.LapisRailMod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class LapisrailModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(LapisRailMod.LAPISRAIL, RenderLayer.getCutout());
    }
}
