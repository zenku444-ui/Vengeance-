/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.passive.PassiveEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.AxeItem
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.entity.Tameable
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.mixin.MinecraftClientAccessor;
import com.vengeance.vengeanceclient.p.p.s.zd;
import com.vengeance.vengeanceclient.r.q.r.zh;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.entity.Tameable;

public final class ze
extends zb {
    private final com.vengeance.vengeanceclient.r.r.ze b = new com.vengeance.vengeanceclient.r.r.ze("Min Fall Distance", 1.0, 10.0, 3.0, 0.5);
    private final com.vengeance.vengeanceclient.r.r.ze c = new com.vengeance.vengeanceclient.r.r.ze("Attack Delay", 0.0, 500.0, 100.0, 10.0);
    private final com.vengeance.vengeanceclient.r.r.ze d = new com.vengeance.vengeanceclient.r.r.ze("Density Threshold", 1.0, 20.0, 7.0, 0.5);
    private final com.vengeance.vengeanceclient.r.r.za e = new com.vengeance.vengeanceclient.r.r.za("Target Players", true);
    private final com.vengeance.vengeanceclient.r.r.za f = new com.vengeance.vengeanceclient.r.r.za("Target Mobs", false);
    private final com.vengeance.vengeanceclient.r.r.za g = new com.vengeance.vengeanceclient.r.r.za("Stun Slam", false);
    private final com.vengeance.vengeanceclient.r.r.za h = new com.vengeance.vengeanceclient.r.r.za("Only Axe", false);
    private final com.vengeance.vengeanceclient.r.r.za i = new com.vengeance.vengeanceclient.r.r.za("Auto Switch Mace", true);
    private final com.vengeance.vengeanceclient.r.r.za j = new com.vengeance.vengeanceclient.r.r.za("Stay On Mace", false);
    private final com.vengeance.vengeanceclient.utils.s.zb k = new com.vengeance.vengeanceclient.utils.s.zb();
    private int l = -1;
    private double m = -1.0;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private int q = 0;

    public ze() {
        super("Auto Mace", "Automatically attacks with mace", -1, za.a);
        this.a(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
    }

    @EventHandler
    private void preMotion(zd zd2) {
        if (this.d()) {
            return;
        }
        this.n();
        this.o();
    }

    private void n() {
        boolean bl = ze.a.player.isOnGround();
        boolean bl2 = ze.a.player.getVelocity().y < -0.1;
        boolean bl3 = ze.a.player.getVelocity().y > 0.1;
        double d = ze.a.player.getY();
        if (bl) {
            if (this.n) {
                this.v();
            }
            if (this.l != -1 && !this.j.b()) {
                this.b(this.l);
                this.l = -1;
            }
            return;
        }
        if (bl3 && this.p) {
            this.p = false;
            this.m = d;
        }
        if (!this.n) {
            this.n = true;
            this.m = d;
            this.o = false;
            this.p = false;
            this.q = 0;
        } else if (bl2 && this.m != -1.0 && d > this.m) {
            this.m = d;
        }
    }

    private void o() {
        double d;
        if (!this.n || ze.a.player.getVelocity().y >= -0.1) {
            return;
        }
        double d2 = d = this.m == -1.0 ? 0.0 : Math.max(0.0, this.m - ze.a.player.getY());
        if (d < (double)this.b.b()) {
            return;
        }
        Entity class_12972 = ze.a.targetedEntity;
        if (!this.b(class_12972) || com.vengeance.vengeanceclient.utils.q.za.c(class_12972.getUuid())) {
            return;
        }
        if (this.g.b()) {
            this.a(class_12972, d);
        }
        if (!this.g.b() || this.o || this.q == 0) {
            this.a(class_12972);
        }
    }

    private void a(Entity class_12972, double d) {
        PlayerEntity class_16572;
        boolean bl;
        boolean bl2 = bl = class_12972 instanceof PlayerEntity && (class_16572 = (PlayerEntity)class_12972).isHolding(Items.SHIELD) && class_16572.isBlocking();
        if (this.h.b() && !this.a(ze.a.player.getMainHandStack())) {
            return;
        }
        if (bl && d > (double)this.b.b() && !this.o && this.q == 0) {
            if (this.l == -1) {
                this.l = ze.a.player.getInventory().selectedSlot;
            }
            this.q = 1;
        }
        if (this.q == 1) {
            int n;
            int n2 = n = this.h.b() ? ze.a.player.getInventory().selectedSlot : this.p();
            if (n != -1) {
                ze.a.player.getInventory().selectedSlot = n;
                ((MinecraftClientAccessor)a).invokeDoAttack();
            }
            this.q = 2;
        } else if (this.q == 2) {
            this.r();
            this.o = true;
            this.q = 0;
        }
    }

    private void a(Entity class_12972) {
        double d;
        if (this.p) {
            return;
        }
        double d2 = d = this.m == -1.0 ? 0.0 : Math.max(0.0, this.m - ze.a.player.getY());
        if (!this.q()) {
            if (this.l == -1) {
                this.l = ze.a.player.getInventory().selectedSlot;
            }
            if (this.i.b()) {
                this.a(d);
            } else {
                this.r();
            }
        } else if (this.i.b()) {
            this.a(d);
        }
        if (this.q() && this.k.a((long)this.c.f(), true)) {
            ((MinecraftClientAccessor)a).invokeDoAttack();
            this.p = true;
        }
    }

    private boolean b(Entity class_12972) {
        if (class_12972 == null || class_12972 == ze.a.player || class_12972 == ze.a.cameraEntity) {
            return false;
        }
        if (!(class_12972 instanceof LivingEntity)) {
            return false;
        }
        LivingEntity class_13092 = (LivingEntity)class_12972;
        if (!class_13092.isAlive() || class_13092.isDead()) {
            return false;
        }
        if (zh.a(class_12972)) {
            return false;
        }
        if (class_12972 instanceof PlayerEntity) {
            return this.e.b();
        }
        if (!this.f.b()) {
            return false;
        }
        return !(class_12972 instanceof PassiveEntity) && !(class_12972 instanceof Tameable);
    }

    private int p() {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = ze.a.player.getInventory().getStack(i);
            if (!this.a(class_17992)) continue;
            return i;
        }
        return -1;
    }

    private boolean a(ItemStack class_17992) {
        return class_17992.getItem() instanceof AxeItem;
    }

    private boolean q() {
        return ze.a.player.getMainHandStack().getItem() == Items.MACE;
    }

    private void r() {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = ze.a.player.getInventory().getStack(i);
            if (class_17992.getItem() != Items.MACE) continue;
            ze.a.player.getInventory().selectedSlot = i;
            return;
        }
    }

    private void a(double d) {
        int n;
        boolean bl = d >= this.d.f();
        int n2 = n = bl ? this.s() : this.t();
        if (n == -1) {
            n = this.u();
        }
        if (n != -1) {
            ze.a.player.getInventory().selectedSlot = n;
        }
    }

    private int s() {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = ze.a.player.getInventory().getStack(i);
            if (class_17992.getItem() != Items.MACE || !this.b(class_17992)) continue;
            return i;
        }
        return -1;
    }

    private int t() {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = ze.a.player.getInventory().getStack(i);
            if (class_17992.getItem() != Items.MACE || !this.c(class_17992)) continue;
            return i;
        }
        return -1;
    }

    private int u() {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = ze.a.player.getInventory().getStack(i);
            if (class_17992.getItem() != Items.MACE) continue;
            return i;
        }
        return -1;
    }

    private boolean b(ItemStack class_17992) {
        return class_17992.getEnchantments().getEnchantments().stream().anyMatch(class_68802 -> class_68802.getIdAsString().contains("density"));
    }

    private boolean c(ItemStack class_17992) {
        return class_17992.getEnchantments().getEnchantments().stream().anyMatch(class_68802 -> class_68802.getIdAsString().contains("breach"));
    }

    private void b(int n) {
        if (n >= 0 && n < 9) {
            ze.a.player.getInventory().selectedSlot = n;
        }
    }

    private void v() {
        this.n = false;
        this.m = -1.0;
        this.o = false;
        this.p = false;
        this.q = 0;
    }

    @Override
    public void b() {
        this.l = -1;
        this.m = -1.0;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = 0;
        this.k.a();
    }

    @Override
    public void c() {
        if (this.l != -1) {
            this.b(this.l);
        }
        this.w();
    }

    private void w() {
        this.l = -1;
        this.m = -1.0;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = 0;
        this.k.a();
    }
}

