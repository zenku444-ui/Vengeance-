/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.mixin.MinecraftClientAccessor;
import com.vengeance.vengeanceclient.p.p.s.zd;
import com.vengeance.vengeanceclient.r.r.zc;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public final class zad
extends zb {
    private final zc b = new zc("Key", 86, true);
    private final ze c = new ze("Delay (ms)", 10.0, 500.0, 150.0, 25.0);
    private boolean d;
    private long e;
    private za f = za.a;

    public zad() {
        super("Xbow cart", "Rail \u2192 TNT cart \u2192 F&S \u2192 crossbow", -1, com.vengeance.vengeanceclient.r.za.a);
        this.a(this.b, this.c);
    }

    @EventHandler
    private void onTick(zd zd2) {
        if (this.d() || zad.a.currentScreen != null) {
            return;
        }
        boolean bl = com.vengeance.vengeanceclient.utils.r.za.b(this.b.e());
        long l = System.currentTimeMillis();
        if (bl && !this.d && this.f == za.a) {
            this.f = za.b;
            this.e = l;
        }
        this.d = bl;
        int n = this.c.a();
        switch (this.f.ordinal()) {
            case 0: {
                break;
            }
            case 1: {
                if (l - this.e < (long)n) break;
                if (this.n()) {
                    ((MinecraftClientAccessor)a).invokeDoItemUse();
                }
                this.f = za.c;
                this.e = l;
                break;
            }
            case 2: {
                if (l - this.e < (long)n) break;
                if (this.a(Items.TNT_MINECART)) {
                    ((MinecraftClientAccessor)a).invokeDoItemUse();
                }
                this.f = za.d;
                this.e = l;
                break;
            }
            case 3: {
                if (l - this.e < (long)n) break;
                if (this.a(Items.FLINT_AND_STEEL)) {
                    ((MinecraftClientAccessor)a).invokeDoItemUse();
                }
                this.f = za.e;
                this.e = l;
                break;
            }
            case 4: {
                if (l - this.e < (long)n) break;
                this.a(Items.CROSSBOW);
                this.f = za.a;
            }
        }
    }

    private boolean n() {
        for (int i = 0; i < 9; ++i) {
            Item class_17922;
            ItemStack class_17992 = zad.a.player.getInventory().getStack(i);
            if (class_17992.isEmpty() || (class_17922 = class_17992.getItem()) != Items.RAIL && class_17922 != Items.POWERED_RAIL && class_17922 != Items.DETECTOR_RAIL && class_17922 != Items.ACTIVATOR_RAIL) continue;
            zad.a.player.getInventory().selectedSlot = i;
            return true;
        }
        return false;
    }

    private boolean a(Item class_17922) {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = zad.a.player.getInventory().getStack(i);
            if (class_17992.isEmpty() || class_17992.getItem() != class_17922) continue;
            zad.a.player.getInventory().selectedSlot = i;
            return true;
        }
        return false;
    }

    @Override
    public void b() {
        this.d = false;
        this.f = za.a;
        super.b();
    }

    @Override
    public void c() {
        this.f = za.a;
        super.c();
    }

    private enum za {
        a, b, c, d, e
    }
}

