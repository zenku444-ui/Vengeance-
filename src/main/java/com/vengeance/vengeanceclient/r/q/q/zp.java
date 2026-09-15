/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.block.BlockState
 *  net.minecraft.util.hit.BlockHitResult
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.mixin.MinecraftClientAccessor;
import com.vengeance.vengeanceclient.p.p.s.zd;
import com.vengeance.vengeanceclient.r.r.zc;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.hit.HitResult;
import net.minecraft.block.BlockState;
import net.minecraft.util.hit.BlockHitResult;

public final class zp
extends zb {
    private final zc b = new zc("Lava Key", 76, false);
    private final ze c = new ze("Restore Delay", 1.0, 20.0, 2.0, 1.0);
    private boolean d = false;
    private int e = -1;
    private int f = 0;
    private boolean g = false;
    private boolean h = false;
    private int i = 0;

    public zp() {
        super("Key Lava", "Places lava bucket and picks it back up in a 2-tick cycle", -1, za.a);
        this.a(this.b, this.c);
        this.f().removeIf(zg2 -> zg2 instanceof zc && !zg2.equals(this.b));
    }

    @EventHandler
    private void onTickEvent(zd zd2) {
        if (this.d() || !this.l()) {
            return;
        }
        if (zp.a.currentScreen != null) {
            return;
        }
        boolean bl = com.vengeance.vengeanceclient.utils.r.za.b(this.b.e());
        if (bl && !this.d) {
            this.n();
        } else if (!bl && this.d) {
            this.o();
        }
        this.d = bl;
        if (this.d && !this.g) {
            this.p();
        }
        if (this.h) {
            if (this.i <= 0) {
                this.r();
                this.h = false;
            } else {
                --this.i;
            }
        }
    }

    private void n() {
        this.e = zp.a.player.getInventory().selectedSlot;
        this.f = 0;
        this.g = false;
    }

    private void o() {
        if (this.e != -1 && !this.h) {
            zp.a.player.getInventory().selectedSlot = this.e;
        }
        this.e = -1;
        this.f = 0;
        this.g = false;
        this.h = false;
        this.i = 0;
    }

    private void p() {
        HitResult ItemStackParticleEffect = zp.a.crosshairTarget;
        if (!(ItemStackParticleEffect instanceof BlockHitResult)) {
            return;
        }
        BlockHitResult class_39652 = (BlockHitResult)ItemStackParticleEffect;
        BlockPos blockPos = class_39652.getBlockPos();
        BlockState class_26802 = zp.a.world.getBlockState(blockPos);
        if (class_26802.isAir()) {
            return;
        }
        if (this.f == 0) {
            if (this.a(Items.LAVA_BUCKET)) {
                ((MinecraftClientAccessor)a).invokeDoItemUse();
                ++this.f;
            }
        } else if (this.f == 1) {
            ((MinecraftClientAccessor)a).invokeDoItemUse();
            this.q();
            this.g = true;
        }
    }

    private void q() {
        if (this.e != -1) {
            this.h = true;
            this.i = this.c.a();
        }
    }

    private boolean a(Item class_17922) {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = zp.a.player.getInventory().getStack(i);
            if (class_17992.isEmpty() || class_17992.getItem() != class_17922) continue;
            zp.a.player.getInventory().selectedSlot = i;
            return true;
        }
        return false;
    }

    private void r() {
        if (this.e != -1) {
            zp.a.player.getInventory().selectedSlot = this.e;
        }
    }

    @Override
    public void b() {
        this.d = false;
        this.e = -1;
        this.f = 0;
        this.g = false;
        this.h = false;
        this.i = 0;
        super.b();
    }

    @Override
    public void c() {
        this.o();
        super.c();
    }

    @Override
    public int e() {
        return -1;
    }
}

