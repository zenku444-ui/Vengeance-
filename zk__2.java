/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.opengl.GlStateManager
 *  net.minecraft.util.Formatting
 *  net.minecraft.entity.passive.PassiveEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.mob.HostileEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.scoreboard.Team
 *  net.minecraft.client.render.Frustum
 *  org.joml.Vector4d
 */
package com.vengeance.vengeanceclient.r.q.u;

import com.mojang.blaze3d.opengl.GlStateManager;
import com.vengeance.vengeanceclient.r.r.zd;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import com.vengeance.vengeanceclient.utils.w.zr;
import java.awt.Color;
import java.util.ArrayList;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.Formatting;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.scoreboard.Team;
import net.minecraft.client.render.Frustum;
import org.joml.Vector4d;

public class zk
extends zb {
    private final zd b = new zd("Targets", "Players", "Players", "Passives", "Hostiles", "All");
    private final com.vengeance.vengeanceclient.r.r.za c = new com.vengeance.vengeanceclient.r.r.za("Show Self", false);
    private final ze d = new ze("Range", 10.0, 200.0, 64.0, 5.0);
    private final com.vengeance.vengeanceclient.r.r.za e = new com.vengeance.vengeanceclient.r.r.za("Show Health", true);
    private final com.vengeance.vengeanceclient.r.r.za f = new com.vengeance.vengeanceclient.r.r.za("Show Armor", true);
    private final com.vengeance.vengeanceclient.r.r.za g = new com.vengeance.vengeanceclient.r.r.za("Show Weapon", true);
    private final com.vengeance.vengeanceclient.r.r.za h = new com.vengeance.vengeanceclient.r.r.za("Scale With Distance", true);
    private final ze i = new ze("Min Scale", 0.1, 2.0, 0.5, 0.1);
    private final ze j = new ze("Max Scale", 0.1, 3.0, 1.5, 0.1);
    private final com.vengeance.vengeanceclient.r.r.za k = new com.vengeance.vengeanceclient.r.r.za("Team Color", false);
    private final com.vengeance.vengeanceclient.r.r.zb l = new com.vengeance.vengeanceclient.r.r.zb("Border Color", new Color(255, 255, 255));
    private final com.vengeance.vengeanceclient.r.r.zb m = new com.vengeance.vengeanceclient.r.r.zb("Player Color", new Color(255, 255, 255));
    private final com.vengeance.vengeanceclient.r.r.zb n = new com.vengeance.vengeanceclient.r.r.zb("Passive Color", new Color(0, 255, 0));
    private final com.vengeance.vengeanceclient.r.r.zb o = new com.vengeance.vengeanceclient.r.r.zb("Hostile Color", new Color(255, 0, 0));

    public zk() {
        super("Nametags", "Displays nametags above entities", -1, za.d);
        this.a(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
    }

    @EventHandler
    private void onRender2D(com.vengeance.vengeanceclient.p.p.t.za za2) {
        if (this.d() || zk.a.world == null || zk.a.player == null) {
            return;
        }
        GlStateManager._disableDepthTest();
        com.vengeance.vengeanceclient.utils.w.r.za.c();
        for (Entity class_12972 : zk.a.world.getEntities()) {
            float f;
            float f2;
            Object object;
            Vec3d class_24322;
            if (!(class_12972 instanceof LivingEntity) || !this.b(class_12972)) continue;
            Box HorizontalFacingBlock = class_12972.getBoundingBox();
            Frustum class_46042 = zk.a.worldRenderer.getCapturedFrustum();
            if (class_46042 != null && !class_46042.isVisible(HorizontalFacingBlock)) continue;
            Vec3d WallPlayerSkullBlock = class_12972.getLerpedPos(a.getRenderTickCounter().getTickProgress(false));
            double d = WallPlayerSkullBlock.x;
            double d2 = WallPlayerSkullBlock.y;
            double d3 = WallPlayerSkullBlock.z;
            Box InfestedBlock = new Box(HorizontalFacingBlock.minX - class_12972.getX() + d - 0.05, HorizontalFacingBlock.minY - class_12972.getY() + d2, HorizontalFacingBlock.minZ - class_12972.getZ() + d3 - 0.05, HorizontalFacingBlock.maxX - class_12972.getX() + d + 0.05, HorizontalFacingBlock.maxY - class_12972.getY() + d2 + 0.1, HorizontalFacingBlock.maxZ - class_12972.getZ() + d3 + 0.05);
            Vec3d[] class_243Array = new Vec3d[]{new Vec3d(InfestedBlock.minX, InfestedBlock.minY, InfestedBlock.minZ), new Vec3d(InfestedBlock.minX, InfestedBlock.maxY, InfestedBlock.minZ), new Vec3d(InfestedBlock.maxX, InfestedBlock.minY, InfestedBlock.minZ), new Vec3d(InfestedBlock.maxX, InfestedBlock.maxY, InfestedBlock.minZ), new Vec3d(InfestedBlock.minX, InfestedBlock.minY, InfestedBlock.maxZ), new Vec3d(InfestedBlock.minX, InfestedBlock.maxY, InfestedBlock.maxZ), new Vec3d(InfestedBlock.maxX, InfestedBlock.minY, InfestedBlock.maxZ), new Vec3d(InfestedBlock.maxX, InfestedBlock.maxY, InfestedBlock.maxZ)};
            Vector4d vector4d = null;
            for (Vec3d class_24322 : class_243Array) {
                object = zr.a(class_24322);
                if (!(object.z > 0.0) || !(object.z < 1.0)) continue;
                if (vector4d == null) {
                    vector4d = new Vector4d(object.x, object.y, object.z, 0.0);
                }
                vector4d.x = Math.min(object.x, vector4d.x);
                vector4d.y = Math.min(object.y, vector4d.y);
                vector4d.z = Math.max(object.x, vector4d.z);
                vector4d.w = Math.max(object.y, vector4d.w);
            }
            if (vector4d == null) continue;
            float f3 = (float)vector4d.x;
            float f4 = (float)vector4d.y;
            float f5 = (float)vector4d.z;
            class_24322 = (LivingEntity)class_12972;
            object = class_12972.getName().getString();
            float f6 = class_24322.getHealth();
            float f7 = class_24322.getMaxHealth();
            float f8 = zk.a.player.distanceTo(class_12972);
            float f9 = 1.0f;
            if (this.h.b()) {
                float f10 = 5.0f;
                f2 = (float)this.d.f();
                f = Math.min(Math.max((f8 - f10) / (f2 - f10), 0.0f), 1.0f);
                f9 = (float)(this.j.f() - (double)f * (this.j.f() - this.i.f()));
            }
            String string = this.e.b() ? String.format(" %.1f", Float.valueOf(f6)) : "";
            f2 = 9.0f * f9;
            f = com.vengeance.vengeanceclient.utils.w.r.za.a((String)object, f2);
            float f11 = this.e.b() ? com.vengeance.vengeanceclient.utils.w.r.za.a(string, f2) : 0.0f;
            float f12 = f + f11;
            float f13 = 3.0f * f9;
            float f14 = f12 + f13 * 2.0f;
            float f15 = f2 + f13 * 2.0f;
            float f16 = f3 + (f5 - f3 - f14) / 2.0f;
            float f17 = f4 - f15 - 3.0f * f9;
            Color color = new Color(0, 0, 0, 180);
            Color color2 = this.a(class_12972);
            Color color3 = new Color(color2.getRed(), color2.getGreen(), color2.getBlue(), 200);
            com.vengeance.vengeanceclient.utils.w.r.za.a(f16, f17, f14, f15, 3.0f * f9, color);
            com.vengeance.vengeanceclient.utils.w.r.za.a(f16, f17, f14, f15, 3.0f * f9, 1.0f * f9, color3);
            float f18 = f16 + f13;
            float f19 = f17 + f13;
            Color color4 = new Color(255, 255, 255, 255);
            com.vengeance.vengeanceclient.utils.w.r.za.a((String)object, f18, f19, f2, color4);
            if (!this.e.b()) continue;
            float f20 = f6 / f7;
            Color color5 = f20 > 0.6f ? new Color(85, 255, 85, 255) : (f20 > 0.3f ? new Color(255, 255, 85, 255) : new Color(255, 85, 85, 255));
            com.vengeance.vengeanceclient.utils.w.r.za.a(string, f18 + f, f19, f2, color5);
        }
        com.vengeance.vengeanceclient.utils.w.r.za.e();
        this.a(za2);
        GlStateManager._enableDepthTest();
    }

    private void a(com.vengeance.vengeanceclient.p.p.t.za za2) {
        for (Entity class_12972 : zk.a.world.getEntities()) {
            EquipmentSlot class_13042;
            int n;
            float f;
            if (!(class_12972 instanceof PlayerEntity)) continue;
            PlayerEntity class_16572 = (PlayerEntity)class_12972;
            if (!this.b(class_12972)) continue;
            Box HorizontalFacingBlock = class_12972.getBoundingBox();
            Frustum class_46042 = zk.a.worldRenderer.getCapturedFrustum();
            if (class_46042 != null && !class_46042.isVisible(HorizontalFacingBlock)) continue;
            Vec3d VanillaChestLootTableGenerator = class_12972.getLerpedPos(a.getRenderTickCounter().getTickProgress(false));
            double d = VanillaChestLootTableGenerator.x;
            double d2 = VanillaChestLootTableGenerator.y;
            double d3 = VanillaChestLootTableGenerator.z;
            Box InfestedBlock = new Box(HorizontalFacingBlock.minX - class_12972.getX() + d - 0.05, HorizontalFacingBlock.minY - class_12972.getY() + d2, HorizontalFacingBlock.minZ - class_12972.getZ() + d3 - 0.05, HorizontalFacingBlock.maxX - class_12972.getX() + d + 0.05, HorizontalFacingBlock.maxY - class_12972.getY() + d2 + 0.1, HorizontalFacingBlock.maxZ - class_12972.getZ() + d3 + 0.05);
            Vec3d[] class_243Array = new Vec3d[]{new Vec3d(InfestedBlock.minX, InfestedBlock.minY, InfestedBlock.minZ), new Vec3d(InfestedBlock.minX, InfestedBlock.maxY, InfestedBlock.minZ), new Vec3d(InfestedBlock.maxX, InfestedBlock.minY, InfestedBlock.minZ), new Vec3d(InfestedBlock.maxX, InfestedBlock.maxY, InfestedBlock.minZ), new Vec3d(InfestedBlock.minX, InfestedBlock.minY, InfestedBlock.maxZ), new Vec3d(InfestedBlock.minX, InfestedBlock.maxY, InfestedBlock.maxZ), new Vec3d(InfestedBlock.maxX, InfestedBlock.minY, InfestedBlock.maxZ), new Vec3d(InfestedBlock.maxX, InfestedBlock.maxY, InfestedBlock.maxZ)};
            Vector4d vector4d = null;
            for (Vec3d WallPlayerSkullBlock : class_243Array) {
                Vec3d VanillaEntityLootTableGenerator = zr.a(WallPlayerSkullBlock);
                if (!(VanillaEntityLootTableGenerator.z > 0.0) || !(VanillaEntityLootTableGenerator.z < 1.0)) continue;
                if (vector4d == null) {
                    vector4d = new Vector4d(VanillaEntityLootTableGenerator.x, VanillaEntityLootTableGenerator.y, VanillaEntityLootTableGenerator.z, 0.0);
                }
                vector4d.x = Math.min(VanillaEntityLootTableGenerator.x, vector4d.x);
                vector4d.y = Math.min(VanillaEntityLootTableGenerator.y, vector4d.y);
                vector4d.z = Math.max(VanillaEntityLootTableGenerator.x, vector4d.z);
                vector4d.w = Math.max(VanillaEntityLootTableGenerator.y, vector4d.w);
            }
            if (vector4d == null) continue;
            float f2 = (float)vector4d.x;
            float f3 = (float)vector4d.y;
            float f4 = (float)vector4d.z;
            float f5 = zk.a.player.distanceTo(class_12972);
            float f6 = 1.0f;
            if (this.h.b()) {
                float f7 = 5.0f;
                float f8 = (float)this.d.f();
                f = Math.min(Math.max((f5 - f7) / (f8 - f7), 0.0f), 1.0f);
                f6 = (float)(this.j.f() - (double)f * (this.j.f() - this.i.f()));
            }
            String string = class_12972.getName().getString();
            String string2 = this.e.b() ? String.format(" %.1f", Float.valueOf(class_16572.getHealth())) : "";
            f = 9.0f * f6;
            float f9 = com.vengeance.vengeanceclient.utils.w.r.za.a(string, f);
            float f10 = this.e.b() ? com.vengeance.vengeanceclient.utils.w.r.za.a(string2, f) : 0.0f;
            float f11 = f9 + f10;
            float f12 = 3.0f * f6;
            float f13 = f11 + f12 * 2.0f;
            float f14 = f + f12 * 2.0f;
            float f15 = f2 + (f4 - f2 - f13) / 2.0f;
            float f16 = f3 - f14 - 3.0f * f6;
            float f17 = f16 - 18.0f * f6 - 2.0f * f6;
            float f18 = 16.0f * f6;
            float f19 = 2.0f * f6;
            ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
            if (this.g.b() && !class_16572.getMainHandStack().isEmpty()) {
                arrayList.add(class_16572.getMainHandStack());
            }
            if (this.f.b()) {
                EquipmentSlot[] class_1304Array = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
                int n2 = class_1304Array.length;
                for (n = 0; n < n2; ++n) {
                    class_13042 = class_1304Array[n];
                    ItemStack class_17992 = class_16572.getEquippedStack(class_13042);
                    if (class_17992.isEmpty()) continue;
                    arrayList.add(class_17992);
                }
            }
            if (arrayList.isEmpty()) continue;
            float f20 = (float)arrayList.size() * f18 + (float)(arrayList.size() - 1) * f19;
            float f21 = f2 + (f4 - f2 - f20) / 2.0f;
            za2.a().getMatrices().pushMatrix();
            za2.a().getMatrices().translate(f21, f17);
            za2.a().getMatrices().scale(f6, f6);
            for (n = 0; n < arrayList.size(); ++n) {
                class_13042 = (ItemStack)arrayList.get(n);
                float f22 = (float)n * (f18 + f19) / f6;
                za2.a().drawItem((ItemStack)class_13042, (int)f22, 0);
            }
            za2.a().getMatrices().popMatrix();
        }
    }

    private Color a(Entity class_12972) {
        Formatting Schema1483;
        LivingEntity class_13092;
        Team EmptyBlockView;
        if (this.k.b() && class_12972 instanceof LivingEntity && (EmptyBlockView = (class_13092 = (LivingEntity)class_12972).getScoreboardTeam()) != null && (Schema1483 = EmptyBlockView.getColor()) != null && Schema1483.getColorValue() != null) {
            return new Color(Schema1483.getColorValue());
        }
        if (class_12972 instanceof PlayerEntity) {
            return this.m.h();
        }
        if (class_12972 instanceof PassiveEntity) {
            return this.n.h();
        }
        if (class_12972 instanceof HostileEntity) {
            return this.o.h();
        }
        return this.l.h();
    }

    private boolean b(Entity class_12972) {
        if (class_12972 == zk.a.player && !this.c.b()) {
            return false;
        }
        if ((double)zk.a.player.distanceTo(class_12972) > this.d.f()) {
            return false;
        }
        return switch (this.b.a()) {
            case "Players" -> class_12972 instanceof PlayerEntity;
            case "Passives" -> class_12972 instanceof PassiveEntity;
            case "Hostiles" -> class_12972 instanceof HostileEntity;
            case "All" -> {
                if (class_12972 instanceof PlayerEntity || class_12972 instanceof PassiveEntity || class_12972 instanceof HostileEntity) {
                    yield true;
                }
                yield false;
            }
            default -> false;
        };
    }
}

