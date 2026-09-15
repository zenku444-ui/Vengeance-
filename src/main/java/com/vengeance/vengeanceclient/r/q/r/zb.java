/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Multimap
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.entity.effect.StatusEffectInstance
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.particle.ParticleEffect
 *  net.minecraft.particle.ParticleTypes
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.client.network.OtherClientPlayerEntity
 */
package com.vengeance.vengeanceclient.r.q.r;

import com.google.common.collect.Multimap;
import com.mojang.authlib.GameProfile;
import com.vengeance.vengeanceclient.r.za;
import java.util.UUID;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ItemConvertible;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.client.network.OtherClientPlayerEntity;

public class zb
extends com.vengeance.vengeanceclient.r.zb {
    private final com.vengeance.vengeanceclient.r.r.za b = new com.vengeance.vengeanceclient.r.r.za("Invincible", false);
    private final com.vengeance.vengeanceclient.r.r.za c = new com.vengeance.vengeanceclient.r.r.za("Critical Hits", true);
    private final com.vengeance.vengeanceclient.r.r.za d = new com.vengeance.vengeanceclient.r.r.za("Use Totem", false);
    private OtherClientPlayerEntity e;
    private float f = 20.0f;
    private long g = 0L;
    private int h = 0;

    public zb() {
        super("Fake Player", "Spawns a fake player for making configs (Only works in single player)", za.e);
        this.a(this.b, this.c, this.d);
    }

    @Override
    public void b() {
        super.b();
        this.q();
    }

    @Override
    public void c() {
        super.c();
        this.r();
    }

    @EventHandler
    private void onWorldChange(com.vengeance.vengeanceclient.p.p.u.za za2) {
        this.r();
    }

    @EventHandler
    private void onAttack(com.vengeance.vengeanceclient.p.p.s.za za2) {
        if (this.e == null || this.d()) {
            return;
        }
        if (za2.a() == this.e) {
            this.c(this.n());
        }
    }

    private boolean n() {
        if (zb.a.player == null) {
            return false;
        }
        boolean bl = zb.a.player.getVelocity().y < (double)-0.08f;
        boolean bl2 = zb.a.player.isSneaking();
        boolean bl3 = zb.a.player.isOnGround();
        boolean bl4 = zb.a.player.isUsingItem();
        boolean bl5 = zb.a.player.getVehicle() != null;
        boolean bl6 = zb.a.player.isTouchingWater();
        boolean bl7 = zb.a.player.isInLava();
        return bl && !bl2 && !bl3 && !bl4 && !bl5 && !bl6 && !bl7;
    }

    private void c(boolean bl) {
        float f;
        float f2;
        if (System.currentTimeMillis() - this.g < 500L) {
            return;
        }
        this.g = System.currentTimeMillis();
        ++this.h;
        boolean bl2 = false;
        if (this.d.b()) {
            if (this.b.b()) {
                if (this.h % 2 == 0) {
                    bl2 = true;
                }
            } else {
                f2 = 2.0f + (float)(Math.random() * 4.0);
                float f3 = f = bl ? f2 * 1.5f : f2;
                if (this.f - f <= 0.0f) {
                    bl2 = true;
                    this.f = 1.0f;
                }
            }
        }
        if (bl2) {
            this.p();
        }
        if (!this.b.b() && !bl2) {
            f2 = 2.0f + (float)(Math.random() * 4.0);
            f = bl ? f2 * 1.5f : f2;
            this.f = Math.max(0.0f, this.f - f);
        }
        this.d(bl);
        if (this.f <= 0.0f && !this.b.b()) {
            this.o();
        }
    }

    private void d(boolean bl) {
        double d;
        double d2;
        double d3;
        int n;
        if (this.e == null || zb.a.world == null) {
            return;
        }
        int n2 = bl ? 8 : 5;
        for (n = 0; n < n2; ++n) {
            d3 = (Math.random() - 0.5) * 0.5;
            d2 = Math.random() * 1.8;
            d = (Math.random() - 0.5) * 0.5;
            zb.a.world.addParticleClient((ParticleEffect)ParticleTypes.DAMAGE_INDICATOR, this.e.getX() + d3, this.e.getY() + d2, this.e.getZ() + d, 0.0, 0.0, 0.0);
        }
        if (bl && this.c.b()) {
            for (n = 0; n < 5; ++n) {
                d3 = (Math.random() - 0.5) * 0.8;
                d2 = Math.random() * 1.8;
                d = (Math.random() - 0.5) * 0.8;
                zb.a.world.addParticleClient((ParticleEffect)ParticleTypes.CRIT, this.e.getX() + d3, this.e.getY() + d2, this.e.getZ() + d, 0.0, 0.0, 0.0);
            }
        }
        if (bl && this.c.b()) {
            zb.a.world.playSound((Entity)zb.a.player, this.e.getBlockPos(), SoundEvents.ENTITY_PLAYER_ATTACK_CRIT, this.e.getSoundCategory(), 1.0f, 1.0f);
        } else {
            zb.a.world.playSound((Entity)zb.a.player, this.e.getBlockPos(), SoundEvents.ENTITY_PLAYER_HURT, this.e.getSoundCategory(), 1.0f, 1.0f);
        }
        this.e.hurtTime = 10;
    }

    private void o() {
        this.r();
        this.f = 20.0f;
        this.h = 0;
        new Thread(() -> {
            try {
                Thread.sleep(1000L);
                if (this.l()) {
                    this.q();
                }
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    private void p() {
        if (this.e == null || zb.a.world == null) {
            return;
        }
        this.e.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 1));
        this.e.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 800, 1));
        zb.a.world.playSound(null, this.e.getX(), this.e.getY(), this.e.getZ(), SoundEvents.ITEM_TOTEM_USE, this.e.getSoundCategory(), 1.0f, 1.0f);
        for (int i = 0; i < 30; ++i) {
            double d = (zb.a.world.random.nextDouble() - 0.5) * 2.0;
            double d2 = zb.a.world.random.nextDouble() * 2.0;
            double d3 = (zb.a.world.random.nextDouble() - 0.5) * 2.0;
            zb.a.world.addParticleClient((ParticleEffect)ParticleTypes.TOTEM_OF_UNDYING, this.e.getX() + d, this.e.getY() + d2, this.e.getZ() + d3, 0.0, 0.1, 0.0);
        }
        this.e.equipStack(EquipmentSlot.OFFHAND, new ItemStack((ItemConvertible)Items.TOTEM_OF_UNDYING));
        new Thread(() -> {
            try {
                Thread.sleep(500L);
                if (this.e != null) {
                    this.e.equipStack(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
                }
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    private void q() {
        if (this.d()) {
            return;
        }
        if (!a.isInSingleplayer()) {
            return;
        }
        if (this.e != null) {
            return;
        }
        GameProfile gameProfile = zb.a.player.getGameProfile();
        GameProfile gameProfile2 = new GameProfile(UUID.randomUUID(), gameProfile.name());
        gameProfile2.properties().putAll((Multimap)gameProfile.properties());
        OtherClientPlayerEntity SonicBoomParticle = new OtherClientPlayerEntity(zb.a.world, gameProfile2);
        SonicBoomParticle.copyPositionAndRotation((Entity)zb.a.player);
        SonicBoomParticle.setYaw(zb.a.player.getYaw());
        SonicBoomParticle.setPitch(zb.a.player.getPitch());
        for (EquipmentSlot class_13042 : EquipmentSlot.values()) {
            ItemStack class_17992 = zb.a.player.getEquippedStack(class_13042);
            if (class_17992.isEmpty()) continue;
            SonicBoomParticle.equipStack(class_13042, class_17992.copy());
        }
        zb.a.world.addEntity((Entity)SonicBoomParticle);
        this.e = SonicBoomParticle;
    }

    private void r() {
        if (this.e == null) {
            return;
        }
        if (!this.d()) {
            this.e.discard();
        }
        this.e = null;
    }
}

