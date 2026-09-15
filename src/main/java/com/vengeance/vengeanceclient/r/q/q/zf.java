/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.entity.Entity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.potion.Potion
 *  net.minecraft.component.type.PotionContentsComponent
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.component.DataComponentTypes
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.mixin.MinecraftClientAccessor;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import java.util.ArrayList;
import java.util.List;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.component.DataComponentTypes;

public final class zf
extends zb {
    private static final ze b = new ze("Health Threshold", 1.0, 20.0, 10.0, 0.5);
    private static final ze c = new ze("Throw Cooldown", 50.0, 1000.0, 250.0, 50.0);
    private static final ze d = new ze("Rotation Speed", 1.0, 20.0, 10.0, 0.5);
    private static final ze e = new ze("Swap Delay", 0.0, 200.0, 50.0, 10.0);
    private static final ze f = new ze("Min Player Distance", 0.0, 10.0, 0.0, 0.5);
    private static final com.vengeance.vengeanceclient.r.r.za g = new com.vengeance.vengeanceclient.r.r.za("Require On Ground", true);
    private final com.vengeance.vengeanceclient.utils.s.zb h = new com.vengeance.vengeanceclient.utils.s.zb();
    private final com.vengeance.vengeanceclient.utils.s.zb i = new com.vengeance.vengeanceclient.utils.s.zb();
    private final List<Integer> j = new ArrayList<Integer>();
    private int k = -1;
    private float l = 0.0f;
    private boolean m = false;
    private boolean n = false;
    private float o = 0.0f;
    private float p = 0.0f;

    public zf() {
        super("Auto Pot", "Automatically throws health potions when health is low", -1, za.a);
        this.a(b, c, d, e, f, g);
    }

    @EventHandler
    private void onTickEvent(com.vengeance.vengeanceclient.p.p.q.za za2) {
        if (this.d() || zf.a.currentScreen != null || zf.a.player.isUsingItem()) {
            return;
        }
        if (this.n) {
            if (this.i.a(e.a())) {
                this.p();
            }
            return;
        }
        if (this.m) {
            this.n();
            return;
        }
        if (this.s()) {
            if (!this.t()) {
                return;
            }
            this.r();
            if (this.j.isEmpty()) {
                return;
            }
            if (this.k == -1) {
                this.k = zf.a.player.getInventory().selectedSlot;
                this.l = zf.a.player.getPitch();
            }
            this.a(89.9f);
        }
    }

    private void a(float f) {
        this.m = true;
        this.o = f;
        this.p = 0.0f;
    }

    private void n() {
        if (d.b() <= 1.0f) {
            zf.a.player.setPitch(this.o);
            this.m = false;
            if (this.o == 89.9f) {
                this.o();
            } else {
                zf.a.player.getInventory().selectedSlot = this.k;
                this.q();
            }
        } else {
            float f = (d.b() - 1.0f) * 0.2f;
            this.p += f;
            if (this.p >= 1.0f) {
                zf.a.player.setPitch(this.o);
                this.m = false;
                if (this.o == 89.9f) {
                    this.o();
                } else {
                    zf.a.player.getInventory().selectedSlot = this.k;
                    this.q();
                }
            } else {
                zf.a.player.setPitch(MathHelper.lerp((float)this.p, (float)this.l, (float)this.o));
            }
        }
    }

    private void o() {
        if (e.a() <= 0) {
            this.p();
        } else {
            this.n = true;
            this.i.a();
        }
    }

    private void p() {
        zf.a.player.getInventory().selectedSlot = this.j.get(0);
        ((MinecraftClientAccessor)a).invokeDoItemUse();
        this.n = false;
        this.a(this.l);
    }

    private void q() {
        this.k = -1;
        this.l = 0.0f;
        this.p = 0.0f;
        this.n = false;
        this.j.clear();
    }

    private void r() {
        this.j.clear();
        for (int i = 0; i < 9; ++i) {
            if (!this.a(zf.a.player.getInventory().getStack(i))) continue;
            this.j.add(i);
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
        if (class_18442.potion().isPresent()) {
            RegistryEntry class_68802 = (RegistryEntry)class_18442.potion().get();
            return ((Potion)class_68802.value()).getEffects().stream().anyMatch(class_12932 -> class_12932.getEffectType().equals(StatusEffects.INSTANT_HEALTH));
        }
        return class_18442.customEffects().stream().anyMatch(class_12932 -> class_12932.getEffectType().equals(StatusEffects.INSTANT_HEALTH));
    }

    @Override
    public void b() {
        this.q();
        this.h.a();
        this.i.a();
        super.b();
    }

    @Override
    public void c() {
        if (this.k != -1) {
            zf.a.player.getInventory().selectedSlot = this.k;
            zf.a.player.setPitch(this.l);
        }
        this.q();
        super.c();
    }

    private boolean s() {
        return zf.a.player.getHealth() <= b.b() && this.h.a(c.a());
    }

    private boolean t() {
        if (f.b() > 0.0f && this.u()) {
            return false;
        }
        return !g.b() || zf.a.player.isOnGround();
    }

    private boolean u() {
        if (zf.a.world == null) {
            return false;
        }
        double d = f.b();
        return zf.a.world.getPlayers().stream().anyMatch(TrackedPosition -> TrackedPosition != zf.a.player && (double)zf.a.player.distanceTo((Entity)TrackedPosition) < d);
    }

    @Override
    public int e() {
        return -1;
    }
}

