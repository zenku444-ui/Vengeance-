/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.Identifier
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.registry.Registries
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.r.q.r.zh;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import java.util.stream.StreamSupport;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.registry.Registries;

public final class zt
extends zb {
    private final com.vengeance.vengeanceclient.r.r.za b = new com.vengeance.vengeanceclient.r.r.za("Target Players Only", true);
    private final com.vengeance.vengeanceclient.r.r.za c = new com.vengeance.vengeanceclient.r.r.za("Ignore Friends", true);
    private final ze d = new ze("Lunge Strength", 0.0, 10.0, 5.0, 0.1);
    private final ze e = new ze("Lock Range", 1.0, 256.0, 64.0, 1.0);
    private final ze f = new ze("Charge Ticks", 1.0, 40.0, 10.0, 1.0);
    private int g = 0;
    private Entity h;

    public zt() {
        super("SpearKill", "Locks and lunges with spear while using it", za.a);
        this.a(this.b, this.c, this.d, this.e, this.f);
    }

    @EventHandler
    private void onHandleInput(com.vengeance.vengeanceclient.p.p.q.za za2) {
        LivingEntity class_13092;
        Entity class_12972;
        if (this.d() || zt.a.currentScreen != null) {
            return;
        }
        if (!zt.a.options.useKey.isPressed() || !this.o()) {
            this.p();
            return;
        }
        ++this.g;
        if (this.h == null || !this.h.isAlive()) {
            this.h = this.n();
        }
        if (!((class_12972 = this.h) instanceof LivingEntity) || !(class_13092 = (LivingEntity)class_12972).isAlive()) {
            return;
        }
        if (!this.c((Entity)class_13092)) {
            this.h = null;
            return;
        }
        this.a((Entity)class_13092);
        if (this.g >= this.f.a()) {
            class_12972 = Vec3d.fromPolar((float)zt.a.player.getPitch(), (float)zt.a.player.getYaw());
            zt.a.player.setSprinting(true);
            zt.a.player.setVelocity(class_12972.multiply(this.d.f()));
        }
    }

    private void a(Entity class_12972) {
        Vec3d VanillaChestLootTableGenerator = zt.a.player.getEyePos();
        Vec3d WallPlayerSkullBlock = class_12972.getBoundingBox().getCenter();
        Vec3d VanillaEntityLootTableGenerator = WallPlayerSkullBlock.subtract(VanillaChestLootTableGenerator).normalize();
        float f = (float)(Math.toDegrees(Math.atan2(VanillaEntityLootTableGenerator.z, VanillaEntityLootTableGenerator.x)) - 90.0);
        float f2 = (float)(-Math.toDegrees(Math.asin(VanillaEntityLootTableGenerator.y)));
        zt.a.player.setYaw(MathHelper.wrapDegrees((float)f));
        zt.a.player.setHeadYaw(MathHelper.wrapDegrees((float)f));
        zt.a.player.setPitch(MathHelper.clamp((float)f2, (float)-89.0f, (float)89.0f));
    }

    private Entity n() {
        LivingEntity class_13092;
        Entity class_12974 = zt.a.targetedEntity;
        if (class_12974 instanceof LivingEntity && this.c((Entity)(class_13092 = (LivingEntity)class_12974))) {
            return class_13092;
        }
        return StreamSupport.stream(zt.a.world.getEntities().spliterator(), false).filter(class_12972 -> class_12972 instanceof LivingEntity).filter(this::c).filter(class_12972 -> class_12972.squaredDistanceTo((Entity)zt.a.player) <= this.e.f() * this.e.f()).max((class_12972, class_12973) -> Double.compare(this.b((Entity)class_12972), this.b((Entity)class_12973))).orElse(null);
    }

    private double b(Entity class_12972) {
        Vec3d VanillaChestLootTableGenerator = zt.a.player.getEyePos();
        Vec3d WallPlayerSkullBlock = zt.a.player.getRotationVec(1.0f).normalize();
        Vec3d VanillaEntityLootTableGenerator = class_12972.getBoundingBox().getCenter().subtract(VanillaChestLootTableGenerator).normalize();
        double d = WallPlayerSkullBlock.dotProduct(VanillaEntityLootTableGenerator);
        double d2 = VanillaChestLootTableGenerator.squaredDistanceTo(class_12972.getBoundingBox().getCenter()) * 5.0E-4;
        return d - d2;
    }

    private boolean c(Entity class_12972) {
        if (!(class_12972 instanceof LivingEntity)) {
            return false;
        }
        if (class_12972 == zt.a.player || !class_12972.isAlive()) {
            return false;
        }
        if (class_12972.distanceTo((Entity)zt.a.player) > this.e.b()) {
            return false;
        }
        if (this.b.b() && !(class_12972 instanceof PlayerEntity)) {
            return false;
        }
        if (class_12972 instanceof PlayerEntity) {
            PlayerEntity class_16572 = (PlayerEntity)class_12972;
            if (zh.a((Entity)class_16572)) {
                return false;
            }
            if (this.c.b() && com.vengeance.vengeanceclient.utils.q.za.c(class_16572.getUuid())) {
                return false;
            }
        }
        return true;
    }

    private boolean o() {
        return this.a(zt.a.player.getMainHandStack()) || this.a(zt.a.player.getOffHandStack());
    }

    private boolean a(ItemStack class_17992) {
        if (class_17992 == null || class_17992.isEmpty()) {
            return false;
        }
        Identifier class_29602 = Registries.ITEM.getId((Object)class_17992.getItem());
        if (class_29602 == null) {
            return false;
        }
        String string = class_29602.getPath();
        return string.equals("spear") || string.endsWith("_spear") || string.contains("spear");
    }

    private void p() {
        this.g = 0;
        this.h = null;
    }

    @Override
    public void c() {
        this.p();
    }
}

