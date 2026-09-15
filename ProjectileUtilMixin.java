/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.projectile.ProjectileUtil
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.hit.EntityHitResult
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package com.vengeance.vengeanceclient.mixin;

import com.vengeance.vengeanceclient.r.q.q.zl;
import java.util.function.Predicate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.hit.EntityHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={ProjectileUtil.class})
public class ProjectileUtilMixin {
    @Inject(method={"raycast(Lnet/minecraft/entity/Entity;Lnet/minecraft/util/math/Vec3d;Lnet/minecraft/util/math/Vec3d;Lnet/minecraft/util/math/Box;Ljava/util/function/Predicate;D)Lnet/minecraft/util/hit/EntityHitResult;"}, at={@At(value="HEAD")})
    private static void onRaycastStart(Entity class_12972, Vec3d VanillaChestLootTableGenerator, Vec3d WallPlayerSkullBlock, Box Vec3i, Predicate<Entity> predicate, double d, CallbackInfoReturnable<EntityHitResult> callbackInfoReturnable) {
        zl.a(true);
    }

    @Inject(method={"raycast(Lnet/minecraft/entity/Entity;Lnet/minecraft/util/math/Vec3d;Lnet/minecraft/util/math/Vec3d;Lnet/minecraft/util/math/Box;Ljava/util/function/Predicate;D)Lnet/minecraft/util/hit/EntityHitResult;"}, at={@At(value="RETURN")})
    private static void onRaycastEnd(Entity class_12972, Vec3d VanillaChestLootTableGenerator, Vec3d WallPlayerSkullBlock, Box Vec3i, Predicate<Entity> predicate, double d, CallbackInfoReturnable<EntityHitResult> callbackInfoReturnable) {
        zl.a(false);
    }
}

