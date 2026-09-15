/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Items
 *  net.minecraft.client.gui.screen.ingame.InventoryScreen
 */
package com.vengeance.vengeanceclient.r.q.t;

import com.vengeance.vengeanceclient.p.p.s.zd;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.utils.zc;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.item.Items;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;

public final class zb
extends com.vengeance.vengeanceclient.r.zb {
    private static final com.vengeance.vengeanceclient.r.r.za b = new com.vengeance.vengeanceclient.r.r.za("Inventory Switch", true);
    private static final ze c = new ze("Totem Slot", 1.0, 9.0, 9.0, 1.0);
    private static final com.vengeance.vengeanceclient.r.r.za d = new com.vengeance.vengeanceclient.r.r.za("Health Switch", false);
    private static final ze e = new ze("Health Threshold", 1.0, 20.0, 15.0, 0.5);
    private int f = -1;

    public zb() {
        super("Auto Double Hand", "Automatically switches to totem based on conditions", -1, za.b);
        this.a(b, c, d, e);
    }

    @EventHandler
    private void onTick(zd zd2) {
        if (this.d()) {
            return;
        }
        boolean bl = this.n();
        boolean bl2 = this.p();
        if (bl && !bl2) {
            this.q();
        } else if (!bl && bl2 && this.f != -1) {
            this.r();
        }
    }

    private boolean n() {
        if (this.d()) {
            return false;
        }
        if (b.b() && zb.a.currentScreen instanceof InventoryScreen) {
            return true;
        }
        return d.b() && this.o();
    }

    private boolean o() {
        if ((double)zb.a.player.getHealth() > e.f()) {
            return false;
        }
        if (zb.a.player.isUsingItem()) {
            return false;
        }
        return !zc.a(zb.a.player.getMainHandStack());
    }

    private boolean p() {
        if (this.d()) {
            return false;
        }
        int n = zb.a.player.getInventory().selectedSlot;
        if (this.f != -1 && n == c.a() - 1) {
            return true;
        }
        return zb.a.player.getInventory().getStack(n).getItem() == Items.TOTEM_OF_UNDYING;
    }

    private void q() {
        if (this.d()) {
            return;
        }
        int n = this.s();
        if (n == -1 && b.b() && zb.a.currentScreen instanceof InventoryScreen) {
            n = c.a() - 1;
        }
        if (n != -1) {
            this.f = zb.a.player.getInventory().selectedSlot;
            zb.a.player.getInventory().selectedSlot = n;
        }
    }

    private void r() {
        if (this.d()) {
            return;
        }
        zb.a.player.getInventory().selectedSlot = this.f;
        this.f = -1;
    }

    private int s() {
        if (this.d()) {
            return -1;
        }
        for (int i = 0; i < 9; ++i) {
            if (zb.a.player.getInventory().getStack(i).getItem() != Items.TOTEM_OF_UNDYING) continue;
            return i;
        }
        return -1;
    }

    @Override
    public void c() {
        if (!this.d() && this.f != -1) {
            zb.a.player.getInventory().selectedSlot = this.f;
            this.f = -1;
        }
        super.c();
    }
}

