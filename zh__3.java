/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Formatting
 *  net.minecraft.entity.passive.PassiveEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.mob.HostileEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.scoreboard.Team
 *  net.minecraft.client.render.Frustum
 *  org.joml.Vector4d
 */
package com.vengeance.vengeanceclient.r.q.u;

import com.vengeance.vengeanceclient.r.r.zd;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import com.vengeance.vengeanceclient.utils.w.zr;
import java.awt.Color;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.Formatting;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.scoreboard.Team;
import net.minecraft.client.render.Frustum;
import org.joml.Vector4d;

public class zh
extends zb {
    private final zd b = new zd("Targets", "Players", "Players", "Passives", "Hostiles", "All");
    private final com.vengeance.vengeanceclient.r.r.za c = new com.vengeance.vengeanceclient.r.r.za("Show Self", false);
    private final ze d = new ze("Range", 10.0, 200.0, 64.0, 5.0);
    private final zd e = new zd("Box Mode", "Full", "Full", "Corners", "Rounded");
    private final com.vengeance.vengeanceclient.r.r.za f = new com.vengeance.vengeanceclient.r.r.za("Box", true);
    private final ze g = new ze("Box Expand", 0.0, 2.0, 0.0, 0.05);
    private final ze h = new ze("Round Radius", 0.0, 10.0, 3.0, 0.5);
    private final com.vengeance.vengeanceclient.r.r.za i = new com.vengeance.vengeanceclient.r.r.za("Box Fill", false);
    private final ze j = new ze("Fill Opacity", 0.0, 255.0, 80.0, 5.0);
    private final com.vengeance.vengeanceclient.r.r.za k = new com.vengeance.vengeanceclient.r.r.za("Health Bar", true);
    private final com.vengeance.vengeanceclient.r.r.za l = new com.vengeance.vengeanceclient.r.r.za("Team Color", false);
    private final com.vengeance.vengeanceclient.r.r.zb m = new com.vengeance.vengeanceclient.r.r.zb("Box Color", new Color(255, 255, 255));
    private final com.vengeance.vengeanceclient.r.r.zb n = new com.vengeance.vengeanceclient.r.r.zb("Player Color", new Color(255, 255, 255));
    private final com.vengeance.vengeanceclient.r.r.zb o = new com.vengeance.vengeanceclient.r.r.zb("Passive Color", new Color(0, 255, 0));
    private final com.vengeance.vengeanceclient.r.r.zb p = new com.vengeance.vengeanceclient.r.r.zb("Hostile Color", new Color(255, 0, 0));

    public zh() {
        super("2D ESP", "Draws 2D boxes around entities", -1, za.d);
        this.a(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p);
    }

    @EventHandler
    private void onRender2D(com.vengeance.vengeanceclient.p.p.t.za za2) {
        if (this.d() || zh.a.world == null || zh.a.player == null) {
            return;
        }
        com.vengeance.vengeanceclient.utils.w.r.za.c();
        for (Entity class_12972 : zh.a.world.getEntities()) {
            float f;
            float f2;
            float f3;
            Object object;
            if (!(class_12972 instanceof LivingEntity) || !this.b(class_12972)) continue;
            Box HorizontalFacingBlock = class_12972.getBoundingBox();
            Frustum class_46042 = zh.a.worldRenderer.getCapturedFrustum();
            if (class_46042 != null && !class_46042.isVisible(HorizontalFacingBlock)) continue;
            Vec3d VanillaChestLootTableGenerator = class_12972.getLerpedPos(a.getRenderTickCounter().getTickProgress(false));
            double d = VanillaChestLootTableGenerator.x;
            double d2 = VanillaChestLootTableGenerator.y;
            double d3 = VanillaChestLootTableGenerator.z;
            Box InfestedBlock = new Box(HorizontalFacingBlock.minX - class_12972.getX() + d - 0.05 - this.g.f(), HorizontalFacingBlock.minY - class_12972.getY() + d2 - this.g.f(), HorizontalFacingBlock.minZ - class_12972.getZ() + d3 - 0.05 - this.g.f(), HorizontalFacingBlock.maxX - class_12972.getX() + d + 0.05 + this.g.f(), HorizontalFacingBlock.maxY - class_12972.getY() + d2 + 0.1 + this.g.f(), HorizontalFacingBlock.maxZ - class_12972.getZ() + d3 + 0.05 + this.g.f());
            Vec3d[] class_243Array = new Vec3d[]{new Vec3d(InfestedBlock.minX, InfestedBlock.minY, InfestedBlock.minZ), new Vec3d(InfestedBlock.minX, InfestedBlock.maxY, InfestedBlock.minZ), new Vec3d(InfestedBlock.maxX, InfestedBlock.minY, InfestedBlock.minZ), new Vec3d(InfestedBlock.maxX, InfestedBlock.maxY, InfestedBlock.minZ), new Vec3d(InfestedBlock.minX, InfestedBlock.minY, InfestedBlock.maxZ), new Vec3d(InfestedBlock.minX, InfestedBlock.maxY, InfestedBlock.maxZ), new Vec3d(InfestedBlock.maxX, InfestedBlock.minY, InfestedBlock.maxZ), new Vec3d(InfestedBlock.maxX, InfestedBlock.maxY, InfestedBlock.maxZ)};
            Vector4d vector4d = null;
            for (Vec3d WallPlayerSkullBlock : class_243Array) {
                object = zr.a(WallPlayerSkullBlock);
                if (!(((Vec3d)object).z > 0.0) || !(((Vec3d)object).z < 1.0)) continue;
                if (vector4d == null) {
                    vector4d = new Vector4d(((Vec3d)object).x, ((Vec3d)object).y, ((Vec3d)object).z, 0.0);
                }
                vector4d.x = Math.min(((Vec3d)object).x, vector4d.x);
                vector4d.y = Math.min(((Vec3d)object).y, vector4d.y);
                vector4d.z = Math.max(((Vec3d)object).x, vector4d.z);
                vector4d.w = Math.max(((Vec3d)object).y, vector4d.w);
            }
            if (vector4d == null) continue;
            float f4 = (float)vector4d.x;
            float f5 = (float)vector4d.y;
            float f6 = (float)vector4d.z;
            float f7 = (float)vector4d.w;
            object = this.a(class_12972);
            if (this.i.b()) {
                int n = this.j.a();
                Color color = new Color(0, 0, 0, n);
                com.vengeance.vengeanceclient.utils.w.r.za.a(f4, f5, f6 - f4, f7 - f5, color);
            }
            if (this.f.b()) {
                float f8 = 1.0f;
                float f9 = 0.5f;
                if (this.e.a().equals("Full")) {
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f4 - f8, f5, f9 + f8, f7 - f5 + f8, Color.BLACK);
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f4 - f8, f5 - f8, f6 - f4 + f8, f9 + f8, Color.BLACK);
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f6 - f9, f5, f9 + f8, f7 - f5 + f8, Color.BLACK);
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f4 - f8, f7 - f9, f6 - f4 + f8, f9 + f8, Color.BLACK);
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f4 - f9, f5, f9, f7 - f5, (Color)object);
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f4, f7 - f9, f6 - f4, f9, (Color)object);
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f4, f5 - f9, f6 - f4, f9, (Color)object);
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f6 - f9, f5, f9, f7 - f5, (Color)object);
                } else if (this.e.a().equals("Rounded")) {
                    f3 = (float)this.h.f();
                    f2 = f6 - f4;
                    f = f7 - f5;
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f4 - 1.0f, f5 - 1.0f, f2 + 2.0f, f + 2.0f, f3, 1.5f, Color.BLACK);
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f4, f5, f2, f, f3, 1.0f, (Color)object);
                } else {
                    f3 = f6 - f4;
                    f2 = Math.min(f3 * 0.25f, 15.0f);
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f4 - f8, f5, f9 + f8, f2 + f8, Color.BLACK);
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f4 - f8, f5 - f8, f2 + f8, f9 + f8, Color.BLACK);
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f6 - f9, f5, f9 + f8, f2 + f8, Color.BLACK);
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f6 - f2 - f8, f5 - f8, f2 + f8, f9 + f8, Color.BLACK);
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f4 - f8, f7 - f2, f9 + f8, f2 + f8, Color.BLACK);
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f4 - f8, f7 - f9, f2 + f8, f9 + f8, Color.BLACK);
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f6 - f9, f7 - f2, f9 + f8, f2 + f8, Color.BLACK);
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f6 - f2 - f8, f7 - f9, f2 + f8, f9 + f8, Color.BLACK);
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f4 - f9, f5, f9, f2, (Color)object);
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f4, f5 - f9, f2, f9, (Color)object);
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f6 - f9, f5, f9, f2, (Color)object);
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f6 - f2, f5 - f9, f2, f9, (Color)object);
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f4 - f9, f7 - f2, f9, f2, (Color)object);
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f4, f7 - f9, f2, f9, (Color)object);
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f6 - f9, f7 - f2, f9, f2, (Color)object);
                    com.vengeance.vengeanceclient.utils.w.r.za.a(f6 - f2, f7 - f9, f2, f9, (Color)object);
                }
            }
            if (!this.k.b() || !(class_12972 instanceof LivingEntity)) continue;
            LivingEntity class_13092 = (LivingEntity)class_12972;
            float f10 = class_13092.getHealth();
            f3 = class_13092.getMaxHealth();
            f2 = Math.min(f10 / f3, 1.0f);
            f = 1.5f;
            float f11 = f7 - f5;
            float f12 = f4 - f - 3.0f;
            float f13 = f5;
            float f14 = 0.3f;
            com.vengeance.vengeanceclient.utils.w.r.za.a(f12, f13, f + 0.5f, f11, Color.BLACK);
            com.vengeance.vengeanceclient.utils.w.r.za.a(f12, f13 - f14, f, f14, Color.BLACK);
            com.vengeance.vengeanceclient.utils.w.r.za.a(f12, f13 + f11, f, f14, Color.BLACK);
            float f15 = f11 * f2;
            float f16 = f13 + (f11 - f15);
            Color color = new Color(Math.max(0, ((Color)object).getRed() - 60), Math.max(0, ((Color)object).getGreen() - 60), Math.max(0, ((Color)object).getBlue() - 60));
            com.vengeance.vengeanceclient.utils.w.r.za.a(f12, f16, f, f15, 0.0f, (Color)object, color);
        }
        com.vengeance.vengeanceclient.utils.w.r.za.e();
    }

    private Color a(Entity class_12972) {
        Formatting Schema1483;
        LivingEntity class_13092;
        Team EmptyBlockView;
        if (this.l.b() && class_12972 instanceof LivingEntity && (EmptyBlockView = (class_13092 = (LivingEntity)class_12972).getScoreboardTeam()) != null && (Schema1483 = EmptyBlockView.getColor()) != null && Schema1483.getColorValue() != null) {
            return new Color(Schema1483.getColorValue());
        }
        if (class_12972 instanceof PlayerEntity) {
            return this.n.h();
        }
        if (class_12972 instanceof PassiveEntity) {
            return this.o.h();
        }
        if (class_12972 instanceof HostileEntity) {
            return this.p.h();
        }
        return this.m.h();
    }

    private boolean b(Entity class_12972) {
        if (class_12972 == zh.a.player && !this.c.b()) {
            return false;
        }
        if ((double)zh.a.player.distanceTo(class_12972) > this.d.f()) {
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

