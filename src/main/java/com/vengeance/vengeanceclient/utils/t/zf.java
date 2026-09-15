/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.RaycastContext
 *  net.minecraft.world.RaycastContext$FluidHandling
 *  net.minecraft.world.RaycastContext$ShapeType
 *  net.minecraft.util.hit.BlockHitResult
 */
package com.vengeance.vengeanceclient.utils.t;

import com.vengeance.vengeanceclient.utils.zb;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.util.hit.BlockHitResult;

public final class zf
implements zb {
    public static boolean a(BlockPos class_23382, double d) {
        Vec3d VanillaChestLootTableGenerator;
        Vec3d WallPlayerSkullBlock;
        if (zf.w.player == null || zf.w.world == null) {
            return false;
        }
        Vec3d VanillaEntityLootTableGenerator = zf.w.player.getCameraPosVec(1.0f);
        BlockHitResult class_39652 = zf.w.world.raycast(new RaycastContext(VanillaEntityLootTableGenerator, WallPlayerSkullBlock = VanillaEntityLootTableGenerator.add((VanillaChestLootTableGenerator = zf.w.player.getRotationVec(1.0f)).multiply(d)), RaycastContext.class_3960.OUTLINE, RaycastContext.class_242.NONE, (Entity)zf.w.player));
        return class_39652 != null && class_39652.getBlockPos().equals((Object)class_23382);
    }

    private zf() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

