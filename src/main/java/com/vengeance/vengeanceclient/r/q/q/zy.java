/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.potion.Potion
 *  net.minecraft.component.type.PotionContentsComponent
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.component.DataComponentTypes
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.mixin.MinecraftClientAccessor;
import com.vengeance.vengeanceclient.r.r.zc;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import java.util.ArrayList;
import java.util.List;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.component.DataComponentTypes;

public final class zy
extends zb {
    private static final zc b = new zc("Throw Key", 71, false);
    private static final ze c = new ze("Throw Delay", 50.0, 1000.0, 250.0, 50.0);
    private static final ze d = new ze("Health Threshold", 1.0, 20.0, 10.0, 0.5);
    private static final com.vengeance.vengeanceclient.r.r.za e = new com.vengeance.vengeanceclient.r.r.za("Multi Throw", true);
    private static final ze f = new ze("Pot Delay", 50.0, 500.0, 150.0, 25.0);
    private static final com.vengeance.vengeanceclient.r.r.za g = new com.vengeance.vengeanceclient.r.r.za("Auto Switch Back", true);
    private static final com.vengeance.vengeanceclient.r.r.za h = new com.vengeance.vengeanceclient.r.r.za("Look Down", true);
    private final com.vengeance.vengeanceclient.utils.s.zb i = new com.vengeance.vengeanceclient.utils.s.zb();
    private final com.vengeance.vengeanceclient.utils.s.zb j = new com.vengeance.vengeanceclient.utils.s.zb();
    private final List<Integer> k = new ArrayList<Integer>();
    private int l = -1;
    private float m = 0.0f;
    private boolean n = false;
    private boolean o = false;
    private int p = 0;
    private int q = 0;

    public zy() {
        super("Throw Pot", "Throws instant health potions based on health levels", -1, za.a);
        this.a(b, c, d, e, f, g, h);
        this.f().removeIf(zg2 -> zg2 instanceof zc && !zg2.equals(b));
    }

    @EventHandler
    private void onTickEvent(com.vengeance.vengeanceclient.p.p.q.za za2) {
        if (this.d()) {
            return;
        }
        boolean bl = com.vengeance.vengeanceclient.utils.r.za.b(b.e());
        if (bl && !this.n && !this.o && this.i.a(c.a()) && zy.a.player.getHealth() <= d.b()) {
            this.n();
            this.i.a();
        }
        this.n = bl;
        if (this.o && this.j.a(f.a()) && this.q < this.p) {
            this.o();
        }
        if (this.o && this.q >= this.p && this.i.a(100L)) {
            this.p();
        }
    }

    private void n() {
        this.q();
        if (this.k.isEmpty()) {
            return;
        }
        if (this.l == -1) {
            this.l = zy.a.player.getInventory().selectedSlot;
        }
        if (h.b()) {
            this.m = zy.a.player.getPitch();
            zy.a.player.setPitch(89.9f);
        }
        this.p = e.b() ? Math.min(3, this.k.size()) : 1;
        this.q = 0;
        this.o = true;
        this.j.a();
    }

    private void o() {
        int n;
        zy.a.player.getInventory().selectedSlot = n = this.k.get(this.q % this.k.size()).intValue();
        ((MinecraftClientAccessor)a).invokeDoItemUse();
        ++this.q;
        this.j.a();
    }

    private void p() {
        if (g.b() && this.l != -1) {
            zy.a.player.getInventory().selectedSlot = this.l;
        }
        if (h.b()) {
            zy.a.player.setPitch(this.m);
        }
        this.o = false;
        this.p = 0;
        this.q = 0;
    }

    private void q() {
        this.k.clear();
        for (int i = 0; i < 9; ++i) {
            if (!this.a(zy.a.player.getInventory().getStack(i))) continue;
            this.k.add(i);
        }
    }

    private boolean a(ItemStack class_17992) {
        if (class_17992.getItem() != Items.SPLASH_POTION) {
            return false;
        }
        PotionContentsComponent class_18442 = (PotionContentsComponent)class_17992.get(DataComponentTypes.POTION_CONTENTS);
        if (class_18442 == null) {
            return false;
        }
        if (class_18442.comp_2378().isPresent()) {
            RegistryEntry class_68802 = (RegistryEntry)class_18442.comp_2378().get();
            return ((Potion)class_68802.comp_349()).getEffects().stream().anyMatch(class_12932 -> class_12932.getEffectType().equals((Object)StatusEffects.INSTANT_HEALTH));
        }
        return class_18442.comp_2380().stream().anyMatch(class_12932 -> class_12932.getEffectType().equals((Object)StatusEffects.INSTANT_HEALTH));
    }

    @Override
    public void b() {
        this.n = false;
        this.l = -1;
        this.m = 0.0f;
        this.o = false;
        this.p = 0;
        this.q = 0;
        this.k.clear();
        this.i.a();
        this.j.a();
        super.b();
    }

    @Override
    public void c() {
        if (g.b() && this.l != -1) {
            zy.a.player.getInventory().selectedSlot = this.l;
        }
        if (h.b()) {
            zy.a.player.setPitch(this.m);
        }
        this.k.clear();
        this.l = -1;
        this.m = 0.0f;
        this.n = false;
        this.o = false;
        this.p = 0;
        this.q = 0;
        super.c();
    }

    @Override
    public int e() {
        return -1;
    }
}

