package com.github.lineartom.lapisrail.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.github.lineartom.lapisrail.LapisRailMod;

@Mixin(AbstractMinecartEntity.class)
public abstract class MinecartMixin extends Entity {

    boolean last_power = false;
    public MinecartMixin(EntityType<?> entityType, World world) {
        super(entityType, world);
    }
	@Redirect(method = "moveOnRail", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    private boolean checkForNewPoweredRailTypes(BlockState state, Block block) {
        
        boolean power = state.isIn(LapisRailMod.TAG_POWERED_RAILS);
        if (power != last_power) {
            LapisRailMod.LOGGER.info(String.format("POWERDNESS %b", power));
            last_power = power;
        }

        return power;
    }
}
