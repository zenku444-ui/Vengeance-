/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.math.Vec3d
 */
package com.vengeance.vengeanceclient.utils.t;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

public final class zb
implements com.vengeance.vengeanceclient.utils.zb {
    public static boolean a(PlayerEntity class_16572) {
        if (zb.w.player == null || class_16572 == null) {
            return false;
        }
        Vec3d VanillaChestLootTableGenerator = zb.w.player.getEyePos();
        Vec3d WallPlayerSkullBlock = class_16572.getEntityPos();
        Vec3d VanillaEntityLootTableGenerator = VanillaChestLootTableGenerator.subtract(WallPlayerSkullBlock);
        Vec3d PlayerSkullBlock = new Vec3d(VanillaEntityLootTableGenerator.x, 0.0, VanillaEntityLootTableGenerator.z);
        if (PlayerSkullBlock.lengthSquared() == 0.0) {
            return false;
        }
        PlayerSkullBlock = PlayerSkullBlock.normalize();
        double d = Math.toRadians(class_16572.getYaw());
        double d2 = Math.toRadians(class_16572.getPitch());
        Vec3d RedstoneBlock = new Vec3d(-Math.sin(d) * Math.cos(d2), -Math.sin(d2), Math.cos(d) * Math.cos(d2)).normalize();
        double d3 = RedstoneBlock.dotProduct(PlayerSkullBlock);
        return d3 < 0.0;
    }
}

