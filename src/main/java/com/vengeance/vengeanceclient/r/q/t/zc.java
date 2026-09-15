/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.block.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.block.BlockState
 *  net.minecraft.fluid.FluidState
 *  net.minecraft.fluid.Fluids
 *  net.minecraft.util.hit.BlockHitResult
 */
package com.vengeance.vengeanceclient.r.q.t;

import com.vengeance.vengeanceclient.mixin.MinecraftClientAccessor;
import com.vengeance.vengeanceclient.p.p.s.zd;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.hit.HitResult;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.hit.BlockHitResult;

public final class zc
extends zb {
    private static final ze b = new ze("Cooldown MS", 50.0, 2000.0, 250.0, 1.0);
    private static final ze c = new ze("SwitchBack MS", 0.0, 500.0, 75.0, 1.0);
    private final com.vengeance.vengeanceclient.utils.s.zb d = new com.vengeance.vengeanceclient.utils.s.zb();
    private final com.vengeance.vengeanceclient.utils.s.zb e = new com.vengeance.vengeanceclient.utils.s.zb();
    private int f = -1;
    private boolean g = false;

    public zc() {
        super("Auto Drain", "Swap to empty bucket and pick up water when aiming at a source", -1, za.b);
        this.a(b, c);
    }

    @EventHandler
    private void onTickEvent(zd zd2) {
        if (this.d() || zc.a.currentScreen != null || zc.a.world == null) {
            return;
        }
        if (this.g) {
            if (c.a() <= 0 || this.e.a(c.a())) {
                if (this.f != -1) {
                    zc.a.player.getInventory().selectedSlot = this.f;
                }
                this.f = -1;
                this.g = false;
            }
            return;
        }
        if (!this.d.a(b.a())) {
            return;
        }
        HitResult ItemStackParticleEffect = zc.a.crosshairTarget;
        if (!(ItemStackParticleEffect instanceof BlockHitResult)) {
            return;
        }
        BlockHitResult class_39652 = (BlockHitResult)ItemStackParticleEffect;
        BlockPos blockPos = this.a(class_39652);
        if (blockPos == null) {
            return;
        }
        if (this.o()) {
            return;
        }
        int n = this.n();
        if (n == -1) {
            return;
        }
        this.f = zc.a.player.getInventory().selectedSlot;
        zc.a.player.getInventory().selectedSlot = n;
        ((MinecraftClientAccessor)a).invokeDoItemUse();
        this.g = true;
        this.e.a();
        this.d.a();
    }

    private boolean a(FluidState class_36102) {
        return class_36102 != null && class_36102.getFluid() == Fluids.WATER && class_36102.isStill();
    }

    private int n() {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = zc.a.player.getInventory().getStack(i);
            if (class_17992.isEmpty() || class_17992.getItem() != Items.BUCKET) continue;
            return i;
        }
        return -1;
    }

    private boolean o() {
        Box HorizontalFacingBlock = zc.a.player.getBoundingBox();
        int n = (int)Math.floor(HorizontalFacingBlock.minX);
        int n2 = (int)Math.floor(HorizontalFacingBlock.minY);
        int n3 = (int)Math.floor(HorizontalFacingBlock.minZ);
        int n4 = (int)Math.floor(HorizontalFacingBlock.maxX);
        int n5 = (int)Math.floor(HorizontalFacingBlock.maxY);
        int n6 = (int)Math.floor(HorizontalFacingBlock.maxZ);
        for (int i = n; i <= n4; ++i) {
            for (int j = n2; j <= n5; ++j) {
                for (int k = n3; k <= n6; ++k) {
                    if (!zc.a.world.getBlockState(new BlockPos(i, j, k)).isOf(Blocks.COBWEB)) continue;
                    return true;
                }
            }
        }
        return false;
    }

    private BlockPos a(BlockHitResult class_39652) {
        BlockPos class_23382 = class_39652.getBlockPos();
        BlockState class_26802 = zc.a.world.getBlockState(class_23382);
        if (class_26802.getBlock() == Blocks.WATER && this.a(zc.a.world.getFluidState(class_23382))) {
            return class_23382;
        }
        BlockPos class_23383 = class_23382.offset(class_39652.getSide());
        BlockState class_26803 = zc.a.world.getBlockState(class_23383);
        if (class_26803.getBlock() == Blocks.WATER && this.a(zc.a.world.getFluidState(class_23383))) {
            return class_23383;
        }
        return null;
    }

    @Override
    public void c() {
        super.c();
        if (this.g && this.f != -1 && zc.a.player != null) {
            zc.a.player.getInventory().selectedSlot = this.f;
        }
        this.f = -1;
        this.g = false;
    }
}

