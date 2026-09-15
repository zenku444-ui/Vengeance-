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
import com.vengeance.vengeanceclient.r.r.zc;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import java.security.SecureRandom;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public final class zh
extends zb {
    private final zc b = new zc("Web Key", 90, false);
    private final ze c = new ze("Web Count", 1.0, 10.0, 3.0, 1.0);
    private final ze d = new ze("Click Delay (MS)", 10.0, 200.0, 50.0, 10.0);
    private final com.vengeance.vengeanceclient.r.r.za e = new com.vengeance.vengeanceclient.r.r.za("Randomize Delay", true);
    private final com.vengeance.vengeanceclient.r.r.za f = new com.vengeance.vengeanceclient.r.r.za("Auto Switch Back", true);
    private final com.vengeance.vengeanceclient.utils.s.zb g = new com.vengeance.vengeanceclient.utils.s.zb();
    private final SecureRandom h = new SecureRandom();
    private boolean i = false;
    private boolean j = false;
    private int k = -1;
    private int l = 0;
    private int m = 0;
    private boolean n = false;

    public zh() {
        super("Auto Web", "Hold keybind to place cobwebs quickly", -1, za.b);
        this.a(this.b, this.c, this.d, this.e, this.f);
        this.f().removeIf(zg2 -> zg2 instanceof zc && !zg2.equals(this.b));
    }

    @EventHandler
    private void onTickEvent(zd zd2) {
        if (zh.a.player == null || zh.a.world == null) {
            return;
        }
        boolean bl = com.vengeance.vengeanceclient.utils.r.za.b(this.b.e());
        if (bl && !this.i) {
            this.n();
        } else if (!bl && this.i) {
            this.o();
        }
        this.i = bl;
        if (!this.j) {
            return;
        }
        long l = this.d.a();
        if (this.e.b()) {
            l = this.h.nextLong(l / 2L, l * 2L);
        }
        if (!this.g.a(l)) {
            return;
        }
        if (!this.n) {
            int n = this.p();
            if (n == -1) {
                this.o();
                return;
            }
            this.k = zh.a.player.getInventory().selectedSlot;
            zh.a.player.getInventory().selectedSlot = n;
            this.n = true;
            this.g.a();
            return;
        }
        if (this.l < this.m) {
            ((MinecraftClientAccessor)a).invokeDoItemUse();
            ++this.l;
            this.g.a();
        } else {
            this.o();
        }
    }

    private void n() {
        if (this.j) {
            return;
        }
        int n = this.p();
        if (n == -1) {
            return;
        }
        this.j = true;
        this.l = 0;
        this.m = this.c.a();
        this.n = false;
        this.g.a();
    }

    private void o() {
        if (!this.j) {
            return;
        }
        if (this.f.b() && this.k != -1) {
            zh.a.player.getInventory().selectedSlot = this.k;
        }
        this.j = false;
        this.k = -1;
        this.l = 0;
        this.n = false;
    }

    private int p() {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = zh.a.player.getInventory().getStack(i);
            if (class_17992.isEmpty() || class_17992.getItem() != Items.COBWEB) continue;
            return i;
        }
        return -1;
    }

    @Override
    public void b() {
        this.i = false;
        this.j = false;
        this.k = -1;
        this.l = 0;
        this.n = false;
        super.b();
    }

    @Override
    public void c() {
        if (this.j) {
            this.o();
        }
        super.c();
    }

    @Override
    public int e() {
        return -1;
    }
}

