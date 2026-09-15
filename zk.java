/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Hand
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.block.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Position
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.hit.BlockHitResult
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.Hand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.hit.BlockHitResult;

public class zk
extends zb {
    private static final double b = 0.05;
    private static final double c = 0.13;
    private static final double d = 0.26;

    public zk() {
        super("Hit Cob", "Places cobweb at player feet when you hit them (DO NOT USE ITS BEING TESTED)", za.a);
    }

    @EventHandler
    private void onAttack(com.vengeance.vengeanceclient.p.p.s.za za2) {
        BlockPos class_23382;
        Entity class_12972;
        if (this.d() || !((class_12972 = za2.a()) instanceof PlayerEntity)) {
            return;
        }
        PlayerEntity class_16572 = (PlayerEntity)class_12972;
        int n = this.n();
        if (n == -1) {
            return;
        }
        BlockPos class_23383 = class_16572.getBlockPos();
        if (zk.a.world.getBlockState(class_23383).getBlock() == Blocks.COBWEB) {
            return;
        }
        if (zk.a.world.getBlockState(class_23383).getBlock() == Blocks.WATER) {
            return;
        }
        double d = zk.a.player.getEntityPos().distanceTo(Vec3d.ofCenter((Vec3i)class_23383));
        if (d > 4.5) {
            return;
        }
        double d2 = Math.hypot(class_16572.getVelocity().x, class_16572.getVelocity().z);
        Vec3d VanillaChestLootTableGenerator = class_16572.getEntityPos().subtract(zk.a.player.getEntityPos()).normalize();
        double d3 = d2 < 0.05 ? (zk.a.player.isSprinting() ? 1.8 : 1.2) : (d2 < 0.13 ? (zk.a.player.isSprinting() ? 1.5 : 1.0) : (d2 < 0.26 ? (zk.a.player.isSprinting() ? 1.2 : 0.8) : (zk.a.player.isSprinting() ? 1.0 : 0.7)));
        Vec3d WallPlayerSkullBlock = class_16572.getEntityPos().add(VanillaChestLootTableGenerator.multiply(d3));
        BlockPos class_23384 = BlockPos.ofFloored((Position)WallPlayerSkullBlock);
        if (zk.a.world.getBlockState(class_23384).getBlock() == Blocks.COBWEB) {
            return;
        }
        if (zk.a.world.getBlockState(class_23384).getBlock() == Blocks.WATER) {
            return;
        }
        if (!zk.a.world.getBlockState(class_23384).isAir()) {
            class_23384 = class_23383;
        }
        if (zk.a.world.getBlockState(class_23382 = class_23384.down()).isAir()) {
            return;
        }
        if (zk.a.player.getEntityPos().distanceTo(Vec3d.ofCenter((Vec3i)class_23384)) > 4.5) {
            return;
        }
        int n2 = zk.a.player.getInventory().selectedSlot;
        float f = zk.a.player.getYaw();
        float f2 = zk.a.player.getPitch();
        Vec3d VanillaEntityLootTableGenerator = Vec3d.ofCenter((Vec3i)class_23382).add(0.0, 0.5, 0.0);
        float[] fArray = this.a(VanillaEntityLootTableGenerator);
        zk.a.player.setYaw(fArray[0]);
        zk.a.player.setPitch(fArray[1]);
        zk.a.player.getInventory().selectedSlot = n;
        BlockHitResult class_39652 = new BlockHitResult(VanillaEntityLootTableGenerator, Direction.UP, class_23382, false);
        if (zk.a.interactionManager != null) {
            zk.a.interactionManager.interactBlock(zk.a.player, Hand.MAIN_HAND, class_39652);
        }
        zk.a.player.getInventory().selectedSlot = n2;
        zk.a.player.setYaw(f);
        zk.a.player.setPitch(f2);
    }

    private int n() {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = zk.a.player.getInventory().getStack(i);
            if (class_17992.isEmpty() || class_17992.getItem() != Items.COBWEB) continue;
            return i;
        }
        return -1;
    }

    private float[] a(Vec3d VanillaChestLootTableGenerator) {
        Vec3d WallPlayerSkullBlock = VanillaChestLootTableGenerator.subtract(zk.a.player.getEyePos());
        double d = Math.sqrt(WallPlayerSkullBlock.x * WallPlayerSkullBlock.x + WallPlayerSkullBlock.z * WallPlayerSkullBlock.z);
        float f = (float)Math.toDegrees(Math.atan2(WallPlayerSkullBlock.z, WallPlayerSkullBlock.x)) - 90.0f;
        float f2 = (float)(-Math.toDegrees(Math.atan2(WallPlayerSkullBlock.y, d)));
        return new float[]{MathHelper.wrapDegrees((float)f), MathHelper.clamp((float)f2, (float)-89.0f, (float)89.0f)};
    }
}

