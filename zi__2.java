/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 */
package com.vengeance.vengeanceclient.r.q.t;

import com.vengeance.vengeanceclient.mixin.MinecraftClientAccessor;
import com.vengeance.vengeanceclient.p.p.s.zd;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.r.zg;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class zi
extends zb {
    private final ze b = new ze("Place Delay", 0.0, 100.0, 20.0, 5.0);
    private boolean c = false;
    private int d = 0;
    private int e = -1;
    private float f = 0.0f;
    private float g = 0.0f;
    private long h = 0L;
    private boolean i = false;

    public zi() {
        super("Cover Up", "Rotates down, places 2 cobwebs, and rotates back", -1, za.b);
        this.a(new zg[]{this.b});
    }

    @Override
    public void b() {
        if (this.d()) {
            this.a(false);
            return;
        }
        int n = this.o();
        if (n == -1) {
            this.a(false);
            return;
        }
        this.e = zi.a.player.getInventory().selectedSlot;
        this.f = zi.a.player.getYaw();
        this.g = zi.a.player.getPitch();
        this.c = true;
        this.d = 0;
        this.h = System.currentTimeMillis();
        this.i = false;
        zi.a.player.setYaw(this.f);
        zi.a.player.setPitch(89.5f);
    }

    @Override
    public void c() {
        if (!this.d() && this.e != -1) {
            zi.a.player.getInventory().selectedSlot = this.e;
            zi.a.player.setYaw(this.f);
            zi.a.player.setPitch(this.g);
        }
        this.c = false;
        this.d = 0;
        this.e = -1;
        this.i = false;
    }

    @EventHandler
    private void onTick(zd zd2) {
        if (this.d() || !this.c) {
            return;
        }
        if (!this.i) {
            this.i = true;
            return;
        }
        if ((double)(System.currentTimeMillis() - this.h) < this.b.f()) {
            return;
        }
        if (this.d < 2) {
            this.n();
            ++this.d;
            this.h = System.currentTimeMillis();
        } else {
            this.a(false);
        }
    }

    private void n() {
        int n = this.o();
        if (n == -1) {
            this.a(false);
            return;
        }
        zi.a.player.getInventory().selectedSlot = n;
        ((MinecraftClientAccessor)a).invokeDoItemUse();
    }

    private int o() {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = zi.a.player.getInventory().getStack(i);
            if (class_17992.getItem() != Items.COBWEB) continue;
            return i;
        }
        return -1;
    }
}

