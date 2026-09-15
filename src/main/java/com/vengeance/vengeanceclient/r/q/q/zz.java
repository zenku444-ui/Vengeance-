/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.item.Items
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.util.hit.EntityHitResult
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.mixin.MinecraftClientAccessor;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.r.zg;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.Entity;
import net.minecraft.item.Items;
import net.minecraft.util.hit.HitResult;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.hit.EntityHitResult;

public class zz
extends zb {
    private final ze b = new ze("Switch Delay", 10.0, 100.0, 30.0, 1.0);
    private int c = -1;
    private boolean d = false;
    private long e = 0L;
    private boolean f = false;

    public zz() {
        super("Totem Hit", "Switches to sword when attacking with totem", za.a);
        this.a(new zg[]{this.b});
    }

    @EventHandler
    public void onTick(com.vengeance.vengeanceclient.p.p.q.za za2) {
        int n;
        Entity class_12972;
        HitResult ItemStackParticleEffect;
        boolean bl;
        if (this.d()) {
            return;
        }
        if (this.d && (double)(System.currentTimeMillis() - this.e) >= this.b.f()) {
            if (this.c != -1) {
                zz.a.player.getInventory().selectedSlot = this.c;
                this.c = -1;
            }
            this.d = false;
        }
        if ((bl = zz.a.options.attackKey.isPressed()) && !this.f && zz.a.player.getMainHandStack().getItem() == Items.TOTEM_OF_UNDYING && (ItemStackParticleEffect = zz.a.crosshairTarget) != null && ItemStackParticleEffect.getType() == HitResult.Type.ENTITY && (class_12972 = ((EntityHitResult)ItemStackParticleEffect).getEntity()) != null && (n = this.n()) != -1) {
            this.c = zz.a.player.getInventory().selectedSlot;
            zz.a.player.getInventory().selectedSlot = n;
            ((MinecraftClientAccessor)a).invokeDoAttack();
            this.e = System.currentTimeMillis();
            this.d = true;
        }
        this.f = bl;
    }

    private int n() {
        for (int i = 0; i < 9; ++i) {
            if (!zz.a.player.getInventory().getStack(i).isIn(ItemTags.SWORDS)) continue;
            return i;
        }
        return -1;
    }

    @Override
    public void c() {
        if (this.c != -1) {
            zz.a.player.getInventory().selectedSlot = this.c;
            this.c = -1;
        }
        this.d = false;
        this.f = false;
    }
}

