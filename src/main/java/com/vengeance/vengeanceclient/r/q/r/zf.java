/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.item.ItemConvertible
 */
package com.vengeance.vengeanceclient.r.q.r;

import com.vengeance.vengeanceclient.mixin.MinecraftClientAccessor;
import com.vengeance.vengeanceclient.p.p.s.zd;
import com.vengeance.vengeanceclient.r.r.zc;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ItemConvertible;

public final class zf
extends zb {
    private final zc b = new zc("Pearl Charge Key", 72, true);
    private final ze c = new ze("Wind Delay", 0.0, 2000.0, 200.0, 1.0);
    private final ze d = new ze("Switch Delay", 0.0, 500.0, 50.0, 10.0);
    private final com.vengeance.vengeanceclient.utils.s.zb e = new com.vengeance.vengeanceclient.utils.s.zb();
    private final com.vengeance.vengeanceclient.utils.s.zb f = new com.vengeance.vengeanceclient.utils.s.zb();
    private boolean g = false;
    private boolean h = false;
    private int i = -1;
    private boolean j = false;

    public zf() {
        super("Pearl Catch", "Throws pearl then windcharge", -1, za.e);
        this.a(this.b, this.c, this.d);
        this.f().removeIf(zg2 -> zg2 instanceof zc && !zg2.equals(this.b));
    }

    @EventHandler
    private void onTickEvent(zd zd2) {
        if (this.d() || zf.a.currentScreen != null) {
            return;
        }
        boolean bl = com.vengeance.vengeanceclient.utils.r.za.b(this.b.e());
        if (bl && !this.g) {
            this.n();
        }
        if (this.h && this.e.a(this.c.a())) {
            this.o();
            this.h = false;
        }
        if (this.j && this.f.a(this.d.a())) {
            zf.a.player.getInventory().selectedSlot = this.i;
            this.j = false;
            this.i = -1;
        }
        this.g = bl;
    }

    private void n() {
        int n = this.p();
        if (n == -1) {
            return;
        }
        if (zf.a.player.getItemCooldownManager().isCoolingDown(new ItemStack((ItemConvertible)Items.ENDER_PEARL))) {
            return;
        }
        this.i = zf.a.player.getInventory().selectedSlot;
        zf.a.player.getInventory().selectedSlot = n;
        ((MinecraftClientAccessor)a).invokeDoItemUse();
        this.j = true;
        this.f.a();
        this.h = true;
        this.e.a();
    }

    private void o() {
        int n = this.q();
        if (n == -1) {
            return;
        }
        if (zf.a.player.getItemCooldownManager().isCoolingDown(new ItemStack((ItemConvertible)Items.WIND_CHARGE))) {
            return;
        }
        this.i = zf.a.player.getInventory().selectedSlot;
        zf.a.player.getInventory().selectedSlot = n;
        ((MinecraftClientAccessor)a).invokeDoItemUse();
        this.j = true;
        this.f.a();
    }

    private int p() {
        for (int i = 0; i < 9; ++i) {
            if (zf.a.player.getInventory().getStack(i).getItem() != Items.ENDER_PEARL) continue;
            return i;
        }
        return -1;
    }

    private int q() {
        for (int i = 0; i < 9; ++i) {
            if (zf.a.player.getInventory().getStack(i).getItem() != Items.WIND_CHARGE) continue;
            return i;
        }
        return -1;
    }

    @Override
    public void b() {
        this.g = false;
        this.h = false;
        this.i = -1;
        this.j = false;
        this.e.a();
        this.f.a();
        super.b();
    }

    @Override
    public void c() {
        this.h = false;
        super.c();
    }

    @Override
    public int e() {
        return -1;
    }
}

