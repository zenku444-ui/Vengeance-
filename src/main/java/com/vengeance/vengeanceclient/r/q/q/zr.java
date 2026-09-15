/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Hand
 *  net.minecraft.item.Item
 *  net.minecraft.item.Items
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.util.hit.BlockHitResult
 */
package com.vengeance.vengeanceclient.r.q.q;

import net.minecraft.util.Hand;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.hit.BlockHitResult;

public class zr {
    public void a(MinecraftClient class_3102) {
        if (class_3102.player == null || class_3102.world == null || class_3102.interactionManager == null) {
            return;
        }
        int n = this.a(class_3102, Items.RESPAWN_ANCHOR);
        int n2 = this.a(class_3102, Items.GLOWSTONE);
        if (n == -1 || n2 == -1) {
            return;
        }
        HitResult ItemStackParticleEffect = class_3102.crosshairTarget;
        if (!(ItemStackParticleEffect instanceof BlockHitResult)) {
            return;
        }
        BlockHitResult class_39652 = (BlockHitResult)ItemStackParticleEffect;
        class_3102.player.getInventory().selectedSlot = n;
        class_3102.interactionManager.interactBlock(class_3102.player, Hand.MAIN_HAND, class_39652);
        class_3102.player.getInventory().selectedSlot = n2;
        float f = class_3102.player.getPitch();
        float f2 = class_3102.player.getYaw();
        class_3102.player.setPitch(80.0f);
        BlockPos class_23382 = class_3102.player.getBlockPos();
        BlockHitResult class_39653 = new BlockHitResult(new Vec3d((double)class_23382.getX() + 0.5, (double)class_23382.getY(), (double)class_23382.getZ() + 0.5), Direction.UP, class_23382, false);
        class_3102.interactionManager.interactBlock(class_3102.player, Hand.MAIN_HAND, class_39653);
        class_3102.player.setPitch(f);
        class_3102.player.setYaw(f2);
    }

    private int a(MinecraftClient class_3102, Item class_17922) {
        for (int i = 0; i < 9; ++i) {
            if (!class_3102.player.getInventory().getStack(i).isOf(class_17922)) continue;
            return i;
        }
        return -1;
    }
}

