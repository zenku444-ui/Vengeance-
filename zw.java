/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.registry.tag.ItemTags
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.r.r.zc;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.ItemTags;

public final class zw
extends zb {
    private final zc b = new zc("Hotswap Key", 1, false);
    private final ze c = new ze("Swap Delay (MS)", 0.0, 1000.0, 150.0, 25.0);
    private final com.vengeance.vengeanceclient.r.r.za d = new com.vengeance.vengeanceclient.r.r.za("Switch Back", true);
    private final com.vengeance.vengeanceclient.utils.s.zb e = new com.vengeance.vengeanceclient.utils.s.zb();
    private boolean f = false;
    private boolean g = false;
    private int h = -1;

    public zw() {
        super("Sword Hotswap", "Swaps to shield only if holding a sword when RMB is pressed", -1, za.a);
        this.a(this.b, this.c, this.d);
        this.f().removeIf(zg2 -> zg2 instanceof zc && !zg2.equals(this.b));
    }

    @EventHandler
    private void onTickEvent(com.vengeance.vengeanceclient.p.p.q.za za2) {
        if (this.d() || zw.a.player == null) {
            return;
        }
        boolean bl = com.vengeance.vengeanceclient.utils.r.za.b(this.b.e());
        if (bl && !this.g) {
            this.n();
        }
        if (!bl && this.g && this.d.b() && this.h != -1) {
            if (zw.a.player.getInventory().selectedSlot == this.p()) {
                zw.a.player.getInventory().selectedSlot = this.h;
            }
            this.h = -1;
            this.f = false;
        }
        this.g = bl;
        if (this.f && this.e.a(this.c.a())) {
            this.o();
            this.f = false;
        }
    }

    private void n() {
        ItemStack class_17992 = zw.a.player.getMainHandStack();
        if (!this.a(class_17992)) {
            return;
        }
        int n = this.p();
        if (n == -1) {
            return;
        }
        this.h = zw.a.player.getInventory().selectedSlot;
        this.f = true;
        this.e.a();
    }

    private void o() {
        int n = this.p();
        if (n != -1) {
            zw.a.player.getInventory().selectedSlot = n;
        }
    }

    private int p() {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = zw.a.player.getInventory().getStack(i);
            if (class_17992.getItem() != Items.SHIELD) continue;
            return i;
        }
        return -1;
    }

    private boolean a(ItemStack class_17992) {
        if (class_17992.isEmpty()) {
            return false;
        }
        return class_17992.isIn(ItemTags.SWORDS);
    }

    @Override
    public int e() {
        return -1;
    }

    @Override
    public void b() {
        super.b();
        this.f = false;
        this.g = false;
        this.h = -1;
    }

    @Override
    public void c() {
        super.c();
        this.f = false;
        this.g = false;
        this.h = -1;
    }
}

