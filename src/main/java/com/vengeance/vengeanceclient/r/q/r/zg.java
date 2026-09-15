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

public final class zg
extends zb {
    private final zc b = new zc("Pearl Key", 80, true);
    private final ze c = new ze("Throw Delay", 100.0, 5000.0, 1000.0, 50.0);
    private final ze d = new ze("Switch Delay", 0.0, 500.0, 50.0, 10.0);
    private final com.vengeance.vengeanceclient.utils.s.zb e = new com.vengeance.vengeanceclient.utils.s.zb();
    private final com.vengeance.vengeanceclient.utils.s.zb f = new com.vengeance.vengeanceclient.utils.s.zb();
    private boolean g = false;
    private int h = -1;
    private boolean i = false;

    public zg() {
        super("Pearl Key", "Automatically throws ender pearls when hotkey is pressed", -1, za.e);
        this.a(this.b, this.c, this.d);
        this.f().removeIf(zg2 -> zg2 instanceof zc && !zg2.equals(this.b));
    }

    @EventHandler
    private void onTickEvent(zd zd2) {
        if (this.d() || zg.a.currentScreen != null) {
            return;
        }
        boolean bl = com.vengeance.vengeanceclient.utils.r.za.b(this.b.e());
        if (bl && !this.g && this.e.a(this.c.a(), false)) {
            this.n();
            this.e.a();
        }
        if (this.i && this.f.a(this.d.a())) {
            zg.a.player.getInventory().selectedSlot = this.h;
            this.i = false;
            this.h = -1;
        }
        this.g = bl;
    }

    private void n() {
        int n = this.o();
        if (n == -1) {
            return;
        }
        if (zg.a.player.getItemCooldownManager().isCoolingDown(new ItemStack((ItemConvertible)Items.ENDER_PEARL))) {
            return;
        }
        this.h = zg.a.player.getInventory().selectedSlot;
        zg.a.player.getInventory().selectedSlot = n;
        if (zg.a.interactionManager != null) {
            ((MinecraftClientAccessor)a).invokeDoItemUse();
        }
        this.i = true;
        this.f.a();
    }

    private int o() {
        for (int i = 0; i < 9; ++i) {
            if (zg.a.player.getInventory().getStack(i).getItem() != Items.ENDER_PEARL) continue;
            return i;
        }
        return -1;
    }

    @Override
    public void b() {
        this.g = false;
        this.h = -1;
        this.i = false;
        this.e.a();
        this.f.a();
        super.b();
    }

    @Override
    public void c() {
        super.c();
    }

    @Override
    public int e() {
        return -1;
    }
}

