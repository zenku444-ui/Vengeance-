/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.Registries
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.r.zg;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;

public final class zu
extends zb {
    private final ze b = new ze("Switch Back Delay", 0.0, 200.0, 30.0, 1.0);
    private int c = -1;
    private int d = -1;
    private long e = 0L;
    private boolean f = false;
    private boolean g = false;

    public zu() {
        super("Auto Lunge", "Swaps to a lunge spear on left click then switches back", za.a);
        this.a(new zg[]{this.b});
    }

    @EventHandler
    private void onHandleInput(com.vengeance.vengeanceclient.p.p.q.za za2) {
        if (this.d()) {
            this.o();
            this.g = false;
            return;
        }
        if (this.f && System.currentTimeMillis() - this.e >= (long)this.b.a()) {
            if (this.c >= 0 && this.c < 9 && zu.a.player.getInventory().selectedSlot == this.d) {
                zu.a.player.getInventory().selectedSlot = this.c;
            }
            this.o();
        }
        boolean bl = zu.a.options.attackKey.isPressed();
        if (zu.a.currentScreen != null || !bl || this.g) {
            this.g = bl;
            return;
        }
        this.g = true;
        int n = this.n();
        if (n == -1) {
            return;
        }
        int n2 = zu.a.player.getInventory().selectedSlot;
        if (n2 == n) {
            return;
        }
        this.c = n2;
        this.d = n;
        zu.a.player.getInventory().selectedSlot = n;
        this.e = System.currentTimeMillis();
        this.f = true;
    }

    private int n() {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = zu.a.player.getInventory().getStack(i);
            if (!this.a(class_17992) || !this.b(class_17992)) continue;
            return i;
        }
        return -1;
    }

    private boolean a(ItemStack class_17992) {
        if (class_17992 == null || class_17992.isEmpty()) {
            return false;
        }
        Identifier class_29602 = Registries.ITEM.getId(class_17992.getItem());
        if (class_29602 == null) {
            return false;
        }
        String string = class_29602.getPath();
        return string.equals("spear") || string.endsWith("_spear") || string.contains("spear");
    }

    private boolean b(ItemStack class_17992) {
        return class_17992.getEnchantments().getEnchantments().stream().anyMatch(class_68802 -> {
            String string = class_68802.getIdAsString().toLowerCase();
            return string.contains("lunge") || string.contains("lung");
        });
    }

    private void o() {
        this.c = -1;
        this.d = -1;
        this.e = 0L;
        this.f = false;
    }

    @Override
    public void c() {
        this.o();
        this.g = false;
    }
}

