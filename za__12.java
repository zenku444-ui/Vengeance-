/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.item.FireworkRocketItem
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 */
package com.vengeance.vengeanceclient.r.q.s;

import com.vengeance.vengeanceclient.mixin.MinecraftClientAccessor;
import com.vengeance.vengeanceclient.p.p.s.zc;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.FireworkRocketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public final class za
extends zb {
    private final com.vengeance.vengeanceclient.r.r.za b = new com.vengeance.vengeanceclient.r.r.za("Only When Flying", true);
    private final com.vengeance.vengeanceclient.r.r.za c = new com.vengeance.vengeanceclient.r.r.za("Respect Gapples", true);
    private final com.vengeance.vengeanceclient.r.r.za d = new com.vengeance.vengeanceclient.r.r.za("Respect Armor", true);
    private final com.vengeance.vengeanceclient.r.r.za e = new com.vengeance.vengeanceclient.r.r.za("Auto Switch Back", true);
    private final ze f = new ze("Switch Back Delay", 25.0, 1000.0, 100.0, 25.0);
    private final com.vengeance.vengeanceclient.utils.s.zb g = new com.vengeance.vengeanceclient.utils.s.zb();
    private boolean h = false;
    private boolean i = false;
    private int j = -1;
    private long k = 0L;
    private boolean l = false;

    public za() {
        super("Auto Firework", "Automatically uses firework rockets while elytra flying", -1, com.vengeance.vengeanceclient.r.za.c);
        this.a(this.b, this.c, this.d, this.e, this.f);
    }

    @EventHandler
    private void onItemUse(zc zc2) {
        if (this.l) {
            zc2.c();
            this.l = false;
        }
    }

    @EventHandler
    private void onTickEvent(com.vengeance.vengeanceclient.p.p.q.za za2) {
        if (this.d()) {
            return;
        }
        if (za.a.currentScreen != null) {
            return;
        }
        boolean bl = za.a.options.useKey.isPressed();
        if (!this.h && bl && this.o() && this.n()) {
            this.k = System.currentTimeMillis();
            this.l = true;
            this.t();
        }
        if (this.i && this.g.a(this.f.a())) {
            this.u();
        }
        this.h = bl;
    }

    private boolean n() {
        return System.currentTimeMillis() - this.k > 200L;
    }

    private boolean o() {
        if (!this.q()) {
            return false;
        }
        if (this.b.b() && !this.p()) {
            return false;
        }
        if (this.r()) {
            return false;
        }
        return this.s() != -1;
    }

    private boolean p() {
        try {
            return (Boolean)za.a.player.getClass().getMethod("isGliding", new Class[0]).invoke((Object)za.a.player, new Object[0]);
        }
        catch (Throwable throwable) {
            try {
                return (Boolean)za.a.player.getClass().getMethod("isFallFlying", new Class[0]).invoke((Object)za.a.player, new Object[0]);
            }
            catch (Throwable throwable2) {
                return false;
            }
        }
    }

    private boolean q() {
        ItemStack class_17992 = za.a.player.getEquippedStack(EquipmentSlot.CHEST);
        if (!class_17992.isOf(Items.ELYTRA)) {
            return false;
        }
        return class_17992.getMaxDamage() == 0 || class_17992.getDamage() < class_17992.getMaxDamage() - 1;
    }

    private boolean r() {
        if (this.c.b() && (this.a(za.a.player.getMainHandStack()) || this.a(za.a.player.getOffHandStack()))) {
            return true;
        }
        return this.d.b() && (this.b(za.a.player.getMainHandStack()) || this.b(za.a.player.getOffHandStack()));
    }

    private boolean a(ItemStack class_17992) {
        return class_17992.getItem() == Items.GOLDEN_APPLE || class_17992.getItem() == Items.ENCHANTED_GOLDEN_APPLE;
    }

    private boolean b(ItemStack class_17992) {
        String string = class_17992.getItem().toString().toLowerCase();
        return string.contains("helmet") || string.contains("chestplate") || string.contains("leggings") || string.contains("boots");
    }

    private int s() {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = za.a.player.getInventory().getStack(i);
            if (!(class_17992.getItem() instanceof FireworkRocketItem)) continue;
            return i;
        }
        return -1;
    }

    private void t() {
        int n = this.s();
        if (n == -1) {
            return;
        }
        this.j = za.a.player.getInventory().selectedSlot;
        za.a.player.getInventory().selectedSlot = n;
        ((MinecraftClientAccessor)a).invokeDoItemUse();
        if (this.e.b()) {
            if (this.f.a() > 0) {
                this.i = true;
                this.g.a();
            } else {
                za.a.player.getInventory().selectedSlot = this.j;
            }
        }
    }

    private void u() {
        if (this.j != -1) {
            za.a.player.getInventory().selectedSlot = this.j;
        }
        this.i = false;
        this.j = -1;
    }

    @Override
    public void b() {
        super.b();
    }

    @Override
    public void c() {
        super.c();
        this.i = false;
        this.j = -1;
    }
}

