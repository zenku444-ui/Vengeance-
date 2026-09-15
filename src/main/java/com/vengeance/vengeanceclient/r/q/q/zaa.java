/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Hand
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.entity.passive.PassiveEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.decoration.EndCrystalEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.AxeItem
 *  net.minecraft.item.Item
 *  net.minecraft.block.Blocks
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.block.BlockState
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.util.hit.EntityHitResult
 *  net.minecraft.entity.Tameable
 *  net.minecraft.entity.projectile.WindChargeEntity
 *  org.lwjgl.glfw.GLFW
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.mixin.MinecraftClientAccessor;
import com.vengeance.vengeanceclient.r.q.r.zh;
import com.vengeance.vengeanceclient.r.r.zd;
import com.vengeance.vengeanceclient.r.r.zf;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import java.lang.runtime.SwitchBootstraps;
import java.util.Objects;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.Hand;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.block.Blocks;
import net.minecraft.util.hit.HitResult;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.entity.Tameable;
import net.minecraft.entity.projectile.WindChargeEntity;
import org.lwjgl.glfw.GLFW;

public final class zaa
extends zb {
    public static final zf b = new zf("Sword Threshold", 0.1, 1.0, 0.9, 0.95, 0.01);
    public static final zf c = new zf("Axe Threshold", 0.1, 1.0, 0.9, 0.95, 0.01);
    public static final zf d = new zf("Axe Post Delay", 1.0, 500.0, 120.0, 120.0, 0.5);
    public static final zf e = new zf("Reaction Time", 1.0, 350.0, 20.0, 95.0, 0.5);
    public static final zf f = new zf("Miss Chance", 0.0, 100.0, 0.0, 0.0, 1.0);
    public static final zd g = new zd("Cooldown Mode", "Smart", "Smart", "Strict", "None");
    public static final zd h = new zd("Criticals", "Strict", "None", "Strict");
    public static final com.vengeance.vengeanceclient.r.r.za i = new com.vengeance.vengeanceclient.r.r.za("No Passive", true);
    public static final com.vengeance.vengeanceclient.r.r.za j = new com.vengeance.vengeanceclient.r.r.za("No Invisible", true);
    public static final com.vengeance.vengeanceclient.r.r.za k = new com.vengeance.vengeanceclient.r.r.za("No Crystals", true);
    public static final com.vengeance.vengeanceclient.r.r.za l = new com.vengeance.vengeanceclient.r.r.za("Ignore Shields", false);
    public static final com.vengeance.vengeanceclient.r.r.za m = new com.vengeance.vengeanceclient.r.r.za("Only Sword or Axe", true);
    public static final com.vengeance.vengeanceclient.r.r.za n = new com.vengeance.vengeanceclient.r.r.za("Only Mouse Hold", false);
    public static final com.vengeance.vengeanceclient.r.r.za o = new com.vengeance.vengeanceclient.r.r.za("Disable on Load", false);
    public static final com.vengeance.vengeanceclient.r.r.za p = new com.vengeance.vengeanceclient.r.r.za("Same Player", false);
    private final com.vengeance.vengeanceclient.utils.s.zb s = new com.vengeance.vengeanceclient.utils.s.zb();
    private final com.vengeance.vengeanceclient.utils.s.zb t = new com.vengeance.vengeanceclient.utils.s.zb();
    private final com.vengeance.vengeanceclient.utils.s.zb u = new com.vengeance.vengeanceclient.utils.s.zb();
    public boolean q = false;
    private boolean v = false;
    private long x = 0L;
    private float y = 0.0f;
    private float z = 0.0f;
    private Entity aa;
    private String ab = null;

    public zaa() {
        super("Trigger Bot", "Makes you automatically attack once aimed at a target", -1, za.a);
        this.a(b, c, d, e, f, g, h, i, k, l, j, n, m, o, p);
    }

    @EventHandler
    private void onWorldChangeEvent(com.vengeance.vengeanceclient.p.p.u.za za2) {
        if (o.b() && this.l()) {
            this.a();
        }
    }

    @EventHandler
    private void handleInputEvent(com.vengeance.vengeanceclient.p.p.q.za za2) {
        if (this.d()) {
            return;
        }
        assert (zaa.a.player != null);
        if (zaa.a.player.isUsingItem()) {
            return;
        }
        if (zaa.a.currentScreen != null) {
            return;
        }
        this.aa = zaa.a.targetedEntity;
        if (this.aa == null) {
            return;
        }
        if (!this.r()) {
            return;
        }
        if (n.b() && GLFW.glfwGetMouseButton((long)a.getWindow().getHandle(), (int)0) != 1) {
            return;
        }
        if (!this.a(this.aa)) {
            return;
        }
        if (l.b()) {
            PlayerEntity class_16572;
            Item class_17922 = zaa.a.player.getMainHandStack().getItem();
            Object object = this.aa;
            if (object instanceof PlayerEntity && com.vengeance.vengeanceclient.utils.t.zb.a(class_16572 = (PlayerEntity)object) && zaa.a.player.getMainHandStack().isIn(ItemTags.SWORDS)) {
                return;
            }
        }
        if (this.aa != null && !this.aa.getUuidAsString().equals(this.ab)) {
            this.ab = this.aa.getUuidAsString();
        }
        if (!this.v) {
            long l;
            this.v = true;
            this.u.a();
            switch (g.a()) {
                case "Smart": {
                    double d = zaa.a.player.distanceTo(this.aa);
                    double d2 = 3.0;
                    double d3 = d < d2 / 2.0 ? 0.66 : 1.0;
                    l = (long)com.vengeance.vengeanceclient.utils.s.za.a(e.c(), e.d());
                    l *= (long)d3;
                    break;
                }
                case "None": {
                    l = 0L;
                    break;
                }
                default: {
                    l = (long)com.vengeance.vengeanceclient.utils.s.za.a(e.c(), e.d());
                }
            }
            this.x = l;
        }
        if (this.v && this.u.a(this.x, true)) {
            if (h.a().equals("Strict")) {
                boolean bl;
                boolean bl2 = bl = zaa.a.player.isClimbing() || zaa.a.player.isTouchingWater() || zaa.a.player.isSubmergedInWater() || zaa.a.world.getBlockState(zaa.a.player.getBlockPos()).isOf(Blocks.COBWEB);
                if (bl) {
                    if (this.q() && this.a(this.aa) && this.b(this.aa)) {
                        this.n();
                        this.v = false;
                    }
                } else if (!zaa.a.player.isOnGround() && !zaa.a.player.isClimbing()) {
                    if (this.o() && (double)zaa.a.player.getAttackCooldownProgress(0.0f) >= b.c() && this.a(this.aa) && this.b(this.aa)) {
                        this.n();
                        this.v = false;
                    }
                } else if (this.q() && this.a(this.aa) && this.b(this.aa)) {
                    this.n();
                    this.v = false;
                }
            } else if (this.q() && this.a(this.aa) && this.b(this.aa)) {
                this.n();
                this.v = false;
            }
        }
    }

    private boolean b(Entity class_12972) {
        if (!p.b()) {
            return true;
        }
        if (class_12972 == null) {
            return false;
        }
        if (this.ab == null || this.t.a(3000L, false)) {
            this.ab = class_12972.getUuidAsString();
            this.t.a();
            return true;
        }
        return class_12972.getUuidAsString().equals(this.ab);
    }

    private boolean o() {
        if (zaa.a.player == null) {
            return false;
        }
        return !zaa.a.player.isOnGround() && !zaa.a.player.isClimbing() && !zaa.a.player.isInLava() && !zaa.a.player.hasStatusEffect(StatusEffects.BLINDNESS) && zaa.a.player.fallDistance > (double)0.065f && zaa.a.player.getVehicle() == null;
    }

    private boolean p() {
        if (zaa.a.player == null || zaa.a.world == null) {
            return false;
        }
        String string = h.a();
        if (string.equals("None")) {
            return false;
        }
        if (zaa.a.player.hasStatusEffect(StatusEffects.LEVITATION) || zaa.a.player.hasStatusEffect(StatusEffects.SLOW_FALLING) || zaa.a.player.hasStatusEffect(StatusEffects.BLINDNESS)) {
            return false;
        }
        HitResult ItemStackParticleEffect = zaa.a.crosshairTarget;
        if (!(ItemStackParticleEffect instanceof EntityHitResult)) {
            return false;
        }
        EntityHitResult class_39662 = (EntityHitResult)ItemStackParticleEffect;
        Entity targetEntity = class_39662.getEntity();
        if (targetEntity != this.aa || !this.a(targetEntity)) {
            return false;
        }
        if (zaa.a.player.isTouchingWater() || zaa.a.player.isInLava() || zaa.a.player.isSubmergedInWater() || zaa.a.player.isClimbing()) {
            return false;
        }
        BlockState class_26802 = zaa.a.world.getBlockState(zaa.a.player.getBlockPos());
        if (class_26802.isOf(Blocks.COBWEB) || class_26802.isOf(Blocks.SWEET_BERRY_BUSH) || class_26802.isOf(Blocks.VINE) || class_26802.isOf(Blocks.SCAFFOLDING) || class_26802.isOf(Blocks.SLIME_BLOCK) || class_26802.isOf(Blocks.HONEY_BLOCK) || class_26802.isOf(Blocks.POWDER_SNOW)) {
            return false;
        }
        boolean bl = (double)zaa.a.player.getAttackCooldownProgress(0.0f) >= b.c();
        return string.equals("Strict") && bl && this.o();
    }

    private boolean q() {
        if (this.p()) {
            return false;
        }
        assert (zaa.a.player != null);
        Item class_17922 = zaa.a.player.getMainHandStack().getItem();
        float f = zaa.a.player.getAttackCooldownProgress(0.0f);
        if (class_17922 instanceof AxeItem) {
            if (!this.q) {
                this.z = (float)com.vengeance.vengeanceclient.utils.s.za.a(c.c(), c.d());
                this.y = (float)com.vengeance.vengeanceclient.utils.s.za.a(d.c(), d.d());
                this.q = true;
            }
            if (f >= this.z) {
                if (this.s.a((long)this.y, true)) {
                    this.q = false;
                    return true;
                }
            } else {
                this.s.a();
            }
            return false;
        }
        float f2 = (float)com.vengeance.vengeanceclient.utils.s.za.a(b.c(), b.d());
        return f >= f2;
    }

    private boolean r() {
        if (!m.b()) {
            return true;
        }
        assert (zaa.a.player != null);
        Item class_17922 = zaa.a.player.getMainHandStack().getItem();
        return class_17922 instanceof AxeItem || zaa.a.player.getMainHandStack().isIn(ItemTags.SWORDS);
    }

    public void n() {
        if (f.c() > 0.0 && Math.random() * 100.0 < f.c()) {
            zaa.a.player.swingHand(Hand.MAIN_HAND);
        } else {
            ((MinecraftClientAccessor)a).invokeDoAttack();
        }
        if (p.b() && this.aa != null) {
            this.ab = this.aa.getUuidAsString();
            this.t.a();
        }
        this.q = false;
    }

    public boolean a(Entity class_12972) {
        boolean bl;
        PlayerEntity class_16572;
        if (class_12972 == zaa.a.player || class_12972 == zaa.a.cameraEntity || !class_12972.isAlive()) {
            return false;
        }
        if (class_12972 instanceof PlayerEntity && com.vengeance.vengeanceclient.utils.q.za.c((class_16572 = (PlayerEntity)class_12972).getUuid())) {
            return false;
        }
        if (zh.a(class_12972)) {
            return false;
        }
        if (class_12972 instanceof WindChargeEntity) {
            return false;
        }
        if (class_12972 instanceof EndCrystalEntity && k.b()) {
            return false;
        }
        if (class_12972 instanceof Tameable) {
            return false;
        }
        if (class_12972 instanceof PassiveEntity && i.b()) {
            return false;
        }
        bl = !j.b() || !class_12972.isInvisible();
        return bl;
    }

    @Override
    public void b() {
        this.s.a();
        this.u.a();
        this.v = false;
        this.q = false;
        super.b();
    }

    @Override
    public void c() {
        this.s.a();
        this.u.a();
        this.v = false;
        this.q = false;
        super.c();
    }
}

