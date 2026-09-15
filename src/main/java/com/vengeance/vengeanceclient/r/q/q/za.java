/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.AxeItem
 *  net.minecraft.item.Item
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.hit.EntityHitResult
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.r.q.r.zh;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.hit.EntityHitResult;

public class za
extends zb {
    private final ze b = new ze("FOV", 10.0, 180.0, 90.0, 1.0);
    private final ze c = new ze("Range", 1.0, 10.0, 5.0, 0.1);
    private final ze d = new ze("Speed", 1.0, 15.0, 10.0, 0.5);
    private final com.vengeance.vengeanceclient.r.r.za e = new com.vengeance.vengeanceclient.r.r.za("Target Players", true);
    private final com.vengeance.vengeanceclient.r.r.za f = new com.vengeance.vengeanceclient.r.r.za("Target Mobs", false);
    private final com.vengeance.vengeanceclient.r.r.za g = new com.vengeance.vengeanceclient.r.r.za("Weapons Only", false);
    private final com.vengeance.vengeanceclient.r.r.za h = new com.vengeance.vengeanceclient.r.r.za("Through Walls", false);
    private final com.vengeance.vengeanceclient.r.r.za i = new com.vengeance.vengeanceclient.r.r.za("Ignore Blocks", true);
    private final com.vengeance.vengeanceclient.r.r.za j = new com.vengeance.vengeanceclient.r.r.za("Only Outside Hitbox", true);
    private Entity k = null;
    private long l = 0L;

    public za() {
        super("Aim Assist", "Gives you assistance on your aim", com.vengeance.vengeanceclient.r.za.a);
        this.a(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
    }

    @EventHandler
    private void onRender3D(com.vengeance.vengeanceclient.p.p.t.zb zb2) {
        if (this.d()) {
            return;
        }
        if (this.g.b() && !this.o()) {
            return;
        }
        if (za.a.currentScreen != null) {
            return;
        }
        if (za.a.crosshairTarget != null && za.a.crosshairTarget.getType() == HitResult.Type.BLOCK && za.a.options.attackKey.isPressed()) {
            return;
        }
        if (this.i.b() && za.a.crosshairTarget != null && za.a.crosshairTarget.getType() == HitResult.Type.BLOCK) {
            return;
        }
        this.k = this.n();
        if (this.k != null) {
            if (!this.h.b() && !za.a.player.canSee(this.k)) {
                return;
            }
            if (this.j.b() && this.b(this.k)) {
                return;
            }
            Vec3d VanillaChestLootTableGenerator = this.c(this.k);
            float[] fArray = this.a(VanillaChestLootTableGenerator);
            this.b(fArray[0], fArray[1]);
        }
    }

    private Entity n() {
        if (this.d()) {
            return null;
        }
        Entity class_12972 = null;
        double d = Double.MAX_VALUE;
        for (Entity class_12973 : za.a.world.getEntities()) {
            double d2;
            Vec3d VanillaChestLootTableGenerator;
            float[] fArray;
            double d3;
            double d4;
            if (!this.a(class_12973) || (d4 = (double)za.a.player.distanceTo(class_12973)) > (double)this.c.b() || !((d3 = this.a((fArray = this.a(VanillaChestLootTableGenerator = this.c(class_12973)))[0], fArray[1])) <= (double)this.b.b() / 2.0) || !((d2 = d4 + d3 * 2.0) < d)) continue;
            d = d2;
            class_12972 = class_12973;
        }
        return class_12972;
    }

    private boolean a(Entity class_12972) {
        PlayerEntity class_16572;
        if (class_12972 == null || class_12972 == za.a.player || !(class_12972 instanceof LivingEntity)) {
            return false;
        }
        LivingEntity class_13092 = (LivingEntity)class_12972;
        if (!class_13092.isAlive() || class_13092.isDead()) {
            return false;
        }
        if (zh.a(class_12972)) {
            return false;
        }
        if (class_12972 instanceof PlayerEntity && com.vengeance.vengeanceclient.utils.q.za.c((class_16572 = (PlayerEntity)class_12972).getUuid())) {
            return false;
        }
        return class_12972 instanceof PlayerEntity ? this.e.b() : this.f.b();
    }

    private boolean b(Entity class_12972) {
        EntityHitResult class_39662;
        HitResult ItemStackParticleEffect = za.a.crosshairTarget;
        return ItemStackParticleEffect instanceof EntityHitResult && (class_39662 = (EntityHitResult)ItemStackParticleEffect).getEntity() == class_12972;
    }

    private Vec3d c(Entity class_12972) {
        return new Vec3d(class_12972.getX(), class_12972.getEyeY(), class_12972.getZ());
    }

    private float[] a(Vec3d VanillaChestLootTableGenerator) {
        Vec3d WallPlayerSkullBlock = VanillaChestLootTableGenerator.subtract(za.a.player.getEyePos());
        double d = Math.sqrt(WallPlayerSkullBlock.x * WallPlayerSkullBlock.x + WallPlayerSkullBlock.z * WallPlayerSkullBlock.z);
        float f = (float)Math.toDegrees(Math.atan2(WallPlayerSkullBlock.z, WallPlayerSkullBlock.x)) - 90.0f;
        float f2 = (float)(-Math.toDegrees(Math.atan2(WallPlayerSkullBlock.y, d)));
        return new float[]{MathHelper.wrapDegrees((float)f), MathHelper.clamp((float)f2, (float)-89.0f, (float)89.0f)};
    }

    private double a(float f, float f2) {
        float f3 = MathHelper.wrapDegrees((float)(f - za.a.player.getYaw()));
        float f4 = f2 - za.a.player.getPitch();
        return Math.sqrt(f3 * f3 + f4 * f4);
    }

    private void b(float f, float f2) {
        long l = System.currentTimeMillis();
        if (this.l == 0L) {
            this.l = l;
            return;
        }
        float f3 = (float)(l - this.l) / 1000.0f;
        this.l = l;
        if (f3 < 0.001f || f3 > 0.1f) {
            return;
        }
        float f4 = za.a.player.getYaw();
        float f5 = za.a.player.getPitch();
        float f6 = this.a(f4, f, f3 * (this.d.b() / 10.0f));
        float f7 = this.a(f5, f2, f3 * (this.d.b() / 10.0f));
        za.a.player.setYaw(f6);
        za.a.player.setPitch(MathHelper.clamp((float)f7, (float)-89.0f, (float)89.0f));
    }

    private float a(float f, float f2, float f3) {
        float f4 = 1.70158f;
        float f5 = f4 + 1.0f;
        f3 = MathHelper.clamp((float)f3, (float)0.0f, (float)1.0f);
        float f6 = 1.0f - (float)Math.pow(1.0f - f3, 3.0);
        return f + MathHelper.wrapDegrees((float)(f2 - f)) * (1.0f + f5 * (float)Math.pow(f6 - 1.0f, 3.0) + f4 * (float)Math.pow(f6 - 1.0f, 2.0));
    }

    private boolean o() {
        if (za.a.player == null) {
            return false;
        }
        if (za.a.player.getMainHandStack().isEmpty()) {
            return false;
        }
        Item class_17922 = za.a.player.getMainHandStack().getItem();
        return class_17922 instanceof AxeItem || za.a.player.getMainHandStack().isIn(ItemTags.SWORDS);
    }

    @Override
    public void b() {
        super.b();
        this.l = System.currentTimeMillis();
    }

    @Override
    public void c() {
        super.c();
        this.k = null;
    }
}

