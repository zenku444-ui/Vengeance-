/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.decoration.EndCrystalEntity
 *  net.minecraft.item.AxeItem
 *  net.minecraft.item.Item
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.util.hit.EntityHitResult
 *  net.minecraft.item.MaceItem
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.mixin.MinecraftClientAccessor;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.r.zg;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.util.hit.HitResult;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.item.MaceItem;

public class zx
extends zb {
    private final ze b = new ze("Switch Delay", 10.0, 100.0, 30.0, 1.0);
    private int c = -1;
    private boolean d = false;
    private long e = 0L;
    private boolean f = false;

    public zx() {
        super("Sword Swap", "Switches to sword when attacking with any non-axe/mace item", za.a);
        this.a(new zg[]{this.b});
    }

    @EventHandler
    public void onTick(com.vengeance.vengeanceclient.p.p.q.za za2) {
        boolean bl;
        if (this.d()) {
            return;
        }
        if (this.d && (double)(System.currentTimeMillis() - this.e) >= this.b.f()) {
            if (this.c != -1) {
                zx.a.player.getInventory().selectedSlot = this.c;
                this.c = -1;
            }
            this.d = false;
        }
        if ((bl = zx.a.options.attackKey.isPressed()) && !this.f) {
            int n;
            Entity class_12972;
            HitResult ItemStackParticleEffect;
            Item class_17922 = zx.a.player.getMainHandStack().getItem();
            boolean bl2 = class_17922 instanceof AxeItem;
            boolean bl3 = class_17922 instanceof MaceItem;
            boolean bl4 = zx.a.player.getMainHandStack().isIn(ItemTags.SWORDS);
            if (!(bl2 || bl3 || bl4 || (ItemStackParticleEffect = zx.a.crosshairTarget) == null || ItemStackParticleEffect.getType() != HitResult.Type.ENTITY || (class_12972 = ((EntityHitResult)ItemStackParticleEffect).getEntity()) == null || class_12972 instanceof EndCrystalEntity || (n = this.n()) == -1)) {
                this.c = zx.a.player.getInventory().selectedSlot;
                zx.a.player.getInventory().selectedSlot = n;
                ((MinecraftClientAccessor)a).invokeDoAttack();
                this.e = System.currentTimeMillis();
                this.d = true;
            }
        }
        this.f = bl;
    }

    private int n() {
        for (int i = 0; i < 9; ++i) {
            if (!zx.a.player.getInventory().getStack(i).isIn(ItemTags.SWORDS)) continue;
            return i;
        }
        return -1;
    }

    @Override
    public void c() {
        if (this.c != -1) {
            zx.a.player.getInventory().selectedSlot = this.c;
            this.c = -1;
        }
        this.d = false;
        this.f = false;
    }
}

