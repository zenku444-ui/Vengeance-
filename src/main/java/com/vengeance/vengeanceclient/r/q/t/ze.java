/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Items
 *  net.minecraft.util.math.BlockPos
 */
package com.vengeance.vengeanceclient.r.q.t;

import com.vengeance.vengeanceclient.mixin.MinecraftClientAccessor;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import com.vengeance.vengeanceclient.utils.t.zd;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;

public final class ze
extends zb {
    private final com.vengeance.vengeanceclient.r.r.ze b = new com.vengeance.vengeanceclient.r.r.ze("Fall Distance", 3.0, 40.0, 8.0, 1.0);
    private final com.vengeance.vengeanceclient.r.r.za c = new com.vengeance.vengeanceclient.r.r.za("Pick Up", true);
    private int d;
    private int e;
    private int f = -1;
    private float g;
    private boolean h;

    public ze() {
        super("Auto MLG", "Places water before landing", -1, za.b);
        this.a(this.b, this.c);
    }

    @EventHandler
    private void onTick(com.vengeance.vengeanceclient.p.p.s.zd zd2) {
        if (this.d()) {
            return;
        }
        if (this.d == 0) {
            this.n();
        } else if (this.d == 1) {
            this.o();
        } else if (this.d == 2) {
            this.p();
        } else if (this.d == 3) {
            this.q();
        }
    }

    private void n() {
        if (ze.a.player.isOnGround()) {
            return;
        }
        if (ze.a.player.isTouchingWater()) {
            return;
        }
        if (ze.a.player.fallDistance < this.b.f()) {
            return;
        }
        if (!zd.b(Items.WATER_BUCKET)) {
            return;
        }
        this.f = ze.a.player.getInventory().selectedSlot;
        this.g = ze.a.player.getPitch();
        zd.a(Items.WATER_BUCKET);
        this.d = 1;
        this.e = 0;
        this.h = false;
    }

    private void o() {
        if (!this.h) {
            ze.a.player.setPitch(89.5f);
            this.h = true;
            return;
        }
        if (ze.a.player.isOnGround()) {
            this.d = 3;
            return;
        }
        int n = this.r();
        ++this.e;
        if (n > 2) {
            return;
        }
        if (this.e % 2 != 0) {
            return;
        }
        zd.a(Items.WATER_BUCKET);
        ((MinecraftClientAccessor)a).invokeDoItemUse();
        this.d = this.c.b() ? 2 : 3;
        this.e = 0;
    }

    private void p() {
        ++this.e;
        if (!ze.a.player.isOnGround() && !ze.a.player.isTouchingWater()) {
            return;
        }
        if (this.e < 3) {
            return;
        }
        zd.a(Items.BUCKET);
        ((MinecraftClientAccessor)a).invokeDoItemUse();
        this.d = 3;
    }

    private void q() {
        if (this.f >= 0) {
            ze.a.player.getInventory().selectedSlot = this.f;
        }
        if (this.h) {
            ze.a.player.setPitch(this.g);
        }
        this.d = 0;
        this.e = 0;
        this.f = -1;
        this.h = false;
    }

    @Override
    public void c() {
        this.q();
        super.c();
    }

    private int r() {
        if (this.d()) {
            return 6;
        }
        BlockPos class_23382 = ze.a.player.getBlockPos();
        for (int i = 1; i <= 6; ++i) {
            BlockPos class_23383 = class_23382.down(i);
            if (ze.a.world.getBlockState(class_23383).isAir()) continue;
            return i;
        }
        return 7;
    }
}

