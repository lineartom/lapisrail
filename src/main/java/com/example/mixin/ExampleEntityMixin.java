package com.example.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.example.ExampleMod;

@Mixin(AbstractMinecartEntity.class)
public abstract class ExampleEntityMixin extends Entity {

    boolean last_power = false;
    public ExampleEntityMixin(EntityType<?> entityType, World world) {
        super(entityType, world);
    }
	@Redirect(method = "moveOnRail", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z"))
    private boolean checkForNewPoweredRailTypes(BlockState state, Block block) {
        
        boolean power = state.isIn(ExampleMod.TAG_POWERED_RAILS);
        if (power != last_power) {
            ExampleMod.LOGGER.info(String.format("POWERDNESS %b", power));
            last_power = power;
        }

        return power;
    }
}
