/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.world.World
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.Identifier
 *  net.minecraft.util.hit.EntityHitResult
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.RegistryKeys
 *  net.minecraft.item.MaceItem
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.mixin.MinecraftClientAccessor;
import com.vengeance.vengeanceclient.r.q.q.zs;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import com.vengeance.vengeanceclient.utils.t.zc;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.world.World;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.item.MaceItem;

public final class zg
extends zb {
    private final ze b = new ze("Switch Delay", 10.0, 100.0, 30.0, 1.0);
    private final com.vengeance.vengeanceclient.r.r.za c = new com.vengeance.vengeanceclient.r.r.za("Only on ground", true);
    private final com.vengeance.vengeanceclient.r.r.za d = new com.vengeance.vengeanceclient.r.r.za("Silent Swap", true);
    private int e = -1;
    private boolean f = false;
    private long g = 0L;
    private boolean h = false;

    public zg() {
        super("Breach Swap", "Switches to a Breach enchanted mace when attacking", za.a);
        this.a(this.b, this.c, this.d);
    }

    @EventHandler
    public void onAttack(com.vengeance.vengeanceclient.p.p.s.za za2) {
        if (this.d() || this.h) {
            return;
        }
        if (this.c.b() && !zg.a.player.isOnGround()) {
            return;
        }
        if (zs.b) {
            return;
        }
        if (!(za2.a() instanceof LivingEntity)) {
            return;
        }
        int n = this.n();
        if (n == -1) {
            return;
        }
        if (this.e == -1) {
            this.e = zg.a.player.getInventory().selectedSlot;
        }
        if (this.d.b()) {
            int n2 = zg.a.player.getInventory().selectedSlot;
            zg.a.player.getInventory().selectedSlot = n;
            this.h = true;
            ((MinecraftClientAccessor)a).invokeDoAttack();
            this.h = false;
            zg.a.player.getInventory().selectedSlot = n2;
        } else {
            zg.a.player.getInventory().selectedSlot = n;
            this.h = true;
            ((MinecraftClientAccessor)a).invokeDoAttack();
            this.h = false;
            this.f = true;
            this.g = System.currentTimeMillis();
        }
    }

    @EventHandler
    public void onTick(com.vengeance.vengeanceclient.p.p.q.za za2) {
        int n;
        EntityHitResult class_39662;
        HitResult ItemStackParticleEffect;
        if (this.d()) {
            return;
        }
        if (zs.b) {
            return;
        }
        if (this.f && (double)(System.currentTimeMillis() - this.g) >= this.b.f()) {
            if (this.e != -1) {
                zg.a.player.getInventory().selectedSlot = this.e;
                this.e = -1;
            }
            this.f = false;
        }
        if (zg.a.options.attackKey.isPressed() && (ItemStackParticleEffect = zg.a.crosshairTarget) instanceof EntityHitResult && (class_39662 = (EntityHitResult)ItemStackParticleEffect).getEntity() instanceof LivingEntity && (n = this.n()) != -1) {
            if (this.e == -1) {
                this.e = zg.a.player.getInventory().selectedSlot;
            }
            if (this.d.b()) {
                int n2 = zg.a.player.getInventory().selectedSlot;
                zg.a.player.getInventory().selectedSlot = n;
                ((MinecraftClientAccessor)a).invokeDoAttack();
                zg.a.player.getInventory().selectedSlot = n2;
            } else {
                zg.a.player.getInventory().selectedSlot = n;
                ((MinecraftClientAccessor)a).invokeDoAttack();
                this.g = System.currentTimeMillis();
                this.f = true;
            }
        }
    }

    private int n() {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = zg.a.player.getInventory().getStack(i);
            Item class_17922 = class_17992.getItem();
            if (!(class_17922 instanceof MaceItem) || !this.a(class_17992)) continue;
            return i;
        }
        return -1;
    }

    private boolean a(ItemStack class_17992) {
        RegistryKey class_53212 = RegistryKey.of((RegistryKey)RegistryKeys.ENCHANTMENT, (Identifier)Identifier.of((String)"minecraft", (String)"breach"));
        return zc.a(class_17992, (World)zg.a.world, (RegistryKey<Enchantment>)class_53212);
    }

    @Override
    public void c() {
        if (this.e != -1) {
            zg.a.player.getInventory().selectedSlot = this.e;
            this.e = -1;
        }
        this.f = false;
        this.h = false;
    }
}

