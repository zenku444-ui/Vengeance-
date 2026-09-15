/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.MovementType
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.world.World
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.block.BlockState
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.entity.EntityDimensions
 *  net.minecraft.entity.EntityPose
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package com.vengeance.vengeanceclient.mixin;

import com.vengeance.vengeanceclient.r.q.q.zl;
import com.vengeance.vengeanceclient.r.q.u.zm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={Entity.class})
public abstract class EntityMixin {
    @Shadow
    public abstract BlockPos getLandingPos();

    @Shadow
    public abstract boolean isOnGround();

    @Shadow
    public abstract World getEntityWorld();

    @Shadow
    protected abstract void fall(double var1, boolean var3, BlockState var4, BlockPos var5);

    @Shadow
    public abstract EntityDimensions getDimensions(EntityPose var1);

    @Inject(method={"isGlowing()Z"}, at={@At(value="HEAD")}, cancellable=true)
    private void onIsGlowing(CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        Entity class_12972;
        zm zm2 = zm.n();
        if (zm2 != null && zm2.l() && zm2.a(class_12972 = (Entity)this)) {
            callbackInfoReturnable.setReturnValue((Object)true);
        }
    }

    @Inject(method={"getTeamColorValue()I"}, at={@At(value="HEAD")})
    private void onGetTeamColorValue(CallbackInfoReturnable<Integer> callbackInfoReturnable) {
    }

    @Inject(method={"move(Lnet/minecraft/entity/MovementType;Lnet/minecraft/util/math/Vec3d;)V"}, at={@At(value="INVOKE", target="Lnet/minecraft/entity/Entity;isRemoved()Z")})
    private void onMove(MovementType class_13132, Vec3d VanillaChestLootTableGenerator, CallbackInfo callbackInfo) {
        if (this.getEntityWorld().isClient()) {
            BlockPos class_23382 = this.getLandingPos();
            BlockState class_26802 = this.getEntityWorld().getBlockState(class_23382);
            this.fall(VanillaChestLootTableGenerator.y, this.isOnGround(), class_26802, class_23382);
        }
    }

    @Inject(method={"getBoundingBox()Lnet/minecraft/util/math/Box;"}, at={@At(value="RETURN")}, cancellable=true)
    private void onGetBoundingBox(CallbackInfoReturnable<Box> callbackInfoReturnable) {
        float f;
        if (!zl.a()) {
            return;
        }
        Entity class_12972 = (Entity)this;
        MinecraftClient class_3102 = MinecraftClient.getInstance();
        if (class_3102.player != null && class_12972 instanceof PlayerEntity && class_12972 != class_3102.player && (f = com.vengeance.vengeanceclient.r.q.q.zm.o()) > 0.0f) {
            Box Vec3i = (Box)callbackInfoReturnable.getReturnValue();
            callbackInfoReturnable.setReturnValue((Object)Vec3i.expand((double)f));
        }
    }
}

