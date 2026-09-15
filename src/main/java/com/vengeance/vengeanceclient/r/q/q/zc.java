/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.RaycastContext
 *  net.minecraft.world.RaycastContext$FluidHandling
 *  net.minecraft.world.RaycastContext$ShapeType
 *  net.minecraft.util.hit.BlockHitResult
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.mixin.MinecraftClientAccessor;
import com.vengeance.vengeanceclient.r.r.zg;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.util.hit.BlockHitResult;

public final class zc
extends zb {
    private final com.vengeance.vengeanceclient.r.r.za b = new com.vengeance.vengeanceclient.r.r.za("Auto Switch", true);
    private boolean c = false;
    private BlockPos d = null;
    private int e = -1;
    private int f = 0;
    private boolean g = false;
    private boolean h = false;

    public zc() {
        super("Auto Cart", "Places TNT minecarts on rails when shooting arrows", -1, za.a);
        this.a(new zg[]{this.b});
    }

    @EventHandler
    private void onTickEvent(com.vengeance.vengeanceclient.p.p.q.za za2) {
        if (this.d()) {
            return;
        }
        if (zc.a.player.isUsingItem() && zc.a.player.getActiveItem().getItem() == Items.BOW) {
            if (!this.c) {
                this.n();
            }
        } else if (this.c && !zc.a.player.isUsingItem() && this.f == 0) {
            this.f = 1;
        }
        if (!this.c) {
            return;
        }
        if (this.f == 1) {
            this.q();
            this.f = 2;
        } else if (this.f == 2) {
            this.r();
            this.o();
        }
    }

    private void n() {
        if (this.c) {
            return;
        }
        if (zc.a.player.getMainHandStack().getItem() != Items.BOW) {
            return;
        }
        BlockPos class_23382 = this.s();
        if (class_23382 == null) {
            return;
        }
        this.d = class_23382;
        this.c = true;
        this.f = 0;
        this.e = zc.a.player.getInventory().selectedSlot;
    }

    private void o() {
        if (!this.c) {
            return;
        }
        if (this.b.b() && this.e != -1) {
            zc.a.player.getInventory().selectedSlot = this.e;
        }
        this.p();
    }

    private void p() {
        this.c = false;
        this.d = null;
        this.e = -1;
        this.f = 0;
        this.g = false;
        this.h = false;
    }

    private void q() {
        if (this.g) {
            return;
        }
        int n = this.u();
        if (n == -1) {
            return;
        }
        zc.a.player.getInventory().selectedSlot = n;
        ((MinecraftClientAccessor)a).invokeDoItemUse();
        this.g = true;
    }

    private void r() {
        if (this.h) {
            this.o();
            return;
        }
        int n = this.t();
        if (n == -1) {
            return;
        }
        zc.a.player.getInventory().selectedSlot = n;
        ((MinecraftClientAccessor)a).invokeDoItemUse();
        this.h = true;
    }

    private BlockPos s() {
        Vec3d VanillaChestLootTableGenerator;
        Vec3d WallPlayerSkullBlock;
        HitResult ItemStackParticleEffect = zc.a.crosshairTarget;
        if (ItemStackParticleEffect == null) {
            return null;
        }
        if (ItemStackParticleEffect.getType() == HitResult.Type.BLOCK) {
            BlockHitResult class_39652 = (BlockHitResult)ItemStackParticleEffect;
            return class_39652.getBlockPos().offset(class_39652.getSide());
        }
        if (ItemStackParticleEffect.getType() == HitResult.Type.ENTITY) {
            return zc.a.player.getBlockPos().add(0, 1, 0);
        }
        Vec3d VanillaEntityLootTableGenerator = zc.a.player.getCameraPosVec(1.0f);
        BlockHitResult class_39653 = zc.a.world.raycast(new RaycastContext(VanillaEntityLootTableGenerator, WallPlayerSkullBlock = VanillaEntityLootTableGenerator.add((VanillaChestLootTableGenerator = zc.a.player.getRotationVec(1.0f)).multiply(5.0)), RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, zc.a.player));
        if (class_39653 != null) {
            return class_39653.getBlockPos().offset(class_39653.getSide());
        }
        return zc.a.player.getBlockPos().add(0, 1, 0);
    }

    private int t() {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = zc.a.player.getInventory().getStack(i);
            if (class_17992.isEmpty() || class_17992.getItem() != Items.TNT_MINECART) continue;
            return i;
        }
        return -1;
    }

    private int u() {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = zc.a.player.getInventory().getStack(i);
            if (class_17992.isEmpty() || !this.a(class_17992.getItem())) continue;
            return i;
        }
        return -1;
    }

    private boolean a(Item class_17922) {
        return class_17922 == Items.RAIL || class_17922 == Items.POWERED_RAIL || class_17922 == Items.DETECTOR_RAIL || class_17922 == Items.ACTIVATOR_RAIL;
    }

    @Override
    public void b() {
        this.p();
    }

    @Override
    public void c() {
        if (this.c) {
            this.o();
        }
    }
}

