/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.AxeItem
 *  net.minecraft.item.Items
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.hit.EntityHitResult
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.mixin.MinecraftClientAccessor;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import com.vengeance.vengeanceclient.utils.t.zd;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Items;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.EntityHitResult;

public final class zs
extends zb {
    public static boolean b = false;
    private final ze c = new ze("CPS", 1.0, 20.0, 20.0, 1.0);
    private final ze d = new ze("Reaction Delay", 0.0, 250.0, 0.0, 5.0);
    private final ze e = new ze("Swap Delay", 0.0, 500.0, 50.0, 10.0);
    private final ze f = new ze("Attack Delay", 0.0, 500.0, 50.0, 10.0);
    private final ze g = new ze("Swap Back Delay", 0.0, 500.0, 100.0, 10.0);
    private final com.vengeance.vengeanceclient.r.r.za h = new com.vengeance.vengeanceclient.r.r.za("Revert Slot", true);
    private final com.vengeance.vengeanceclient.r.r.za i = new com.vengeance.vengeanceclient.r.r.za("Check Facing", true);
    private final com.vengeance.vengeanceclient.r.r.za j = new com.vengeance.vengeanceclient.r.r.za("Auto Stun", true);
    private final com.vengeance.vengeanceclient.r.r.za k = new com.vengeance.vengeanceclient.r.r.za("Disable if using item", true);
    private final com.vengeance.vengeanceclient.r.r.za l = new com.vengeance.vengeanceclient.r.r.za("Ignore Friends", false);
    private final com.vengeance.vengeanceclient.utils.s.zb m = new com.vengeance.vengeanceclient.utils.s.zb();
    private final com.vengeance.vengeanceclient.utils.s.zb n = new com.vengeance.vengeanceclient.utils.s.zb();
    private final com.vengeance.vengeanceclient.utils.s.zb o = new com.vengeance.vengeanceclient.utils.s.zb();
    private final com.vengeance.vengeanceclient.utils.s.zb p = new com.vengeance.vengeanceclient.utils.s.zb();
    private final com.vengeance.vengeanceclient.utils.s.zb q = new com.vengeance.vengeanceclient.utils.s.zb();
    private int r = -1;

    public zs() {
        super("Shield Breaker", "Automatically breaks the opponent's shield", -1, za.a);
        this.a(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.k, this.l, this.j);
    }

    private boolean n() {
        if (this.d() || zs.a.currentScreen != null) {
            return false;
        }
        if (!zd.a(AxeItem.class)) {
            return false;
        }
        if (zs.a.player.isUsingItem() && this.k.b()) {
            return false;
        }
        return this.m.a((long)(1000.0 / this.c.f()));
    }

    private PlayerEntity o() {
        HitResult ItemStackParticleEffect = zs.a.crosshairTarget;
        if (!(ItemStackParticleEffect instanceof EntityHitResult)) {
            return null;
        }
        EntityHitResult class_39662 = (EntityHitResult)ItemStackParticleEffect;
        Entity class_12972 = class_39662.getEntity();
        if (!(class_12972 instanceof PlayerEntity)) {
            return null;
        }
        ItemStackParticleEffect = (PlayerEntity)class_12972;
        if (com.vengeance.vengeanceclient.utils.q.za.c(ItemStackParticleEffect.getUuid()) && this.l.b()) {
            return null;
        }
        return ItemStackParticleEffect;
    }

    @EventHandler
    private void onTickEvent(com.vengeance.vengeanceclient.p.p.q.za za2) {
        boolean bl;
        boolean bl2;
        if (this.d()) {
            return;
        }
        PlayerEntity class_16572 = this.o();
        if (this.r != -1 && this.q.a(this.g.a())) {
            bl2 = false;
            if (class_16572 == null) {
                bl2 = true;
            } else {
                boolean bl3;
                bl = class_16572.isBlocking() && class_16572.isHolding(Items.SHIELD);
                boolean bl4 = bl3 = !this.i.b() || !com.vengeance.vengeanceclient.utils.t.zb.a(class_16572);
                if (!bl || !bl3) {
                    bl2 = true;
                }
            }
            if (bl2) {
                if (this.h.b()) {
                    zs.a.player.getInventory().selectedSlot = this.r;
                }
                this.r = -1;
                b = false;
                return;
            }
        }
        if (!this.n()) {
            return;
        }
        if (class_16572 == null) {
            return;
        }
        bl2 = class_16572.isBlocking() && class_16572.isHolding(Items.SHIELD);
        boolean bl5 = bl = !this.i.b() || !com.vengeance.vengeanceclient.utils.t.zb.a(class_16572);
        if (!bl2 || !bl) {
            if (!this.n.a(this.d.a() / 2)) {
                this.n.a();
            }
            return;
        }
        if (!(zs.a.player.getMainHandStack().getItem() instanceof AxeItem)) {
            if (this.n.a(this.d.a()) && this.o.a(this.e.a())) {
                b = true;
                if (this.r == -1) {
                    this.r = zs.a.player.getInventory().selectedSlot;
                }
                zd.b(AxeItem.class);
                this.p.a();
                this.o.a();
            }
            return;
        }
        if (this.p.a(this.f.a()) || this.r == -1) {
            ((MinecraftClientAccessor)a).invokeDoAttack();
            if (this.j.b()) {
                ((MinecraftClientAccessor)a).invokeDoAttack();
            }
            this.m.a();
            this.p.a();
            this.q.a();
            b = false;
        }
    }

    @Override
    public void c() {
        if (this.r != -1 && this.h.b()) {
            zs.a.player.getInventory().selectedSlot = this.r;
        }
        this.r = -1;
        b = false;
        super.c();
    }
}

