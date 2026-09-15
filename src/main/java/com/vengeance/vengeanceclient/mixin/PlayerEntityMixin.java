/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.block.BlockState
 *  net.minecraft.client.MinecraftClient
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package com.vengeance.vengeanceclient.mixin;

import com.vengeance.vengeanceclient.VengeanceClient;
import com.vengeance.vengeanceclient.r.q.s.zc;
import com.vengeance.vengeanceclient.r.q.t.zk;
import java.util.Optional;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={PlayerEntity.class})
public class PlayerEntityMixin {
    @Inject(method={"getBlockBreakingSpeed(Lnet/minecraft/block/BlockState;)F"}, at={@At(value="RETURN")}, cancellable=true)
    private void modifyBlockBreakingSpeed(BlockState class_26802, CallbackInfoReturnable<Float> callbackInfoReturnable) {
        if (VengeanceClient.INSTANCE == null) {
            return;
        }
        Optional<zk> optional = VengeanceClient.INSTANCE.getModuleManager().a(zk.class);
        if (optional.isEmpty()) {
            return;
        }
        zk zk2 = optional.get();
        if (!zk2.l()) {
            return;
        }
        PlayerEntity class_16572 = (PlayerEntity)(Object)this;
        if (class_16572 != MinecraftClient.getInstance().player) {
            return;
        }
        float f = ((Float)callbackInfoReturnable.getReturnValue()).floatValue() * zk2.n();
        callbackInfoReturnable.setReturnValue(Float.valueOf(f));
    }

    @Inject(method={"attack(Lnet/minecraft/entity/Entity;)V"}, at={@At(value="TAIL")})
    private void keepSprintTail(Entity class_12972, CallbackInfo callbackInfo) {
        PlayerEntity class_16572;
        if (VengeanceClient.INSTANCE == null) {
            return;
        }
        Optional<zc> optional = VengeanceClient.INSTANCE.getModuleManager().a(zc.class);
        if (optional.isPresent() && optional.get().l() && (class_16572 = (PlayerEntity)(Object)this) == MinecraftClient.getInstance().player) {
            class_16572.setSprinting(true);
        }
    }
}

