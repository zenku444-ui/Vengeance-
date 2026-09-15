/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.passive.PassiveEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.mob.HostileEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.scoreboard.Team
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.Frustum
 */
package com.vengeance.vengeanceclient.r.q.u;

import com.vengeance.vengeanceclient.r.r.zd;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import com.vengeance.vengeanceclient.utils.w.zm;
import java.awt.Color;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.scoreboard.Team;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.Frustum;

public class zi
extends zb {
    private final zd b = new zd("Targets", "Players", "Players", "Passives", "Hostiles", "All");
    private final com.vengeance.vengeanceclient.r.r.za c = new com.vengeance.vengeanceclient.r.r.za("Show Self", false);
    private final ze d = new ze("Range", 10.0, 200.0, 64.0, 5.0);
    private final zd e = new zd("Mode", "Both", "Outline", "Filled", "Both");
    private final ze f = new ze("Fill Opacity", 0.0, 255.0, 50.0, 5.0);
    private final com.vengeance.vengeanceclient.r.r.za g = new com.vengeance.vengeanceclient.r.r.za("Through Walls", true);
    private final com.vengeance.vengeanceclient.r.r.za h = new com.vengeance.vengeanceclient.r.r.za("Team Color", false);
    private final com.vengeance.vengeanceclient.r.r.zb i = new com.vengeance.vengeanceclient.r.r.zb("Player Color", new Color(255, 50, 50));
    private final com.vengeance.vengeanceclient.r.r.zb j = new com.vengeance.vengeanceclient.r.r.zb("Friend Color", new Color(50, 255, 50));
    private final com.vengeance.vengeanceclient.r.r.zb k = new com.vengeance.vengeanceclient.r.r.zb("Passive Color", new Color(50, 255, 50));
    private final com.vengeance.vengeanceclient.r.r.zb l = new com.vengeance.vengeanceclient.r.r.zb("Hostile Color", new Color(255, 165, 0));

    public zi() {
        super("3D ESP", "Draws 3D boxes around entities", -1, za.d);
        this.a(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
    }

    @EventHandler
    private void onRender3D(com.vengeance.vengeanceclient.p.p.t.zb zb2) {
        if (this.d() || zi.a.world == null) {
            return;
        }
        MatrixStack class_45872 = zb2.a();
        float f = a.getRenderTickCounter().getTickProgress(true);
        if (this.g.b()) {
            zm.b();
        } else {
            zm.a();
        }
        for (Entity class_12972 : zi.a.world.getEntities()) {
            if (!(class_12972 instanceof LivingEntity) || !this.a(class_12972)) continue;
            Box HorizontalFacingBlock = class_12972.getBoundingBox();
            Frustum class_46042 = zi.a.worldRenderer.getCapturedFrustum();
            if (class_46042 != null && !class_46042.isVisible(HorizontalFacingBlock)) continue;
            Vec3d VanillaChestLootTableGenerator = zm.a(class_12972, f);
            Color color = this.b(class_12972);
            if (this.e.b("Filled") || this.e.b("Both")) {
                Color color2 = new Color(color.getRed(), color.getGreen(), color.getBlue(), this.f.a());
                zm.c(class_45872, VanillaChestLootTableGenerator.x, VanillaChestLootTableGenerator.y, VanillaChestLootTableGenerator.z, class_12972.getWidth(), class_12972.getHeight(), color2);
            }
            if (!this.e.b("Outline") && !this.e.b("Both")) continue;
            zm.b(class_45872, VanillaChestLootTableGenerator.x, VanillaChestLootTableGenerator.y, VanillaChestLootTableGenerator.z, class_12972.getWidth(), class_12972.getHeight(), color);
        }
        zm.c();
    }

    private boolean a(Entity class_12972) {
        if (class_12972 == zi.a.player && !this.c.b()) {
            return false;
        }
        if (zi.a.player.squaredDistanceTo(class_12972) > this.d.f() * this.d.f()) {
            return false;
        }
        String string = this.b.a();
        if (class_12972 instanceof PlayerEntity) {
            return string.equals("Players") || string.equals("All");
        }
        if (class_12972 instanceof PassiveEntity) {
            return string.equals("Passives") || string.equals("All");
        }
        if (class_12972 instanceof HostileEntity) {
            return string.equals("Hostiles") || string.equals("All");
        }
        return string.equals("All");
    }

    private Color b(Entity class_12972) {
        if (class_12972 instanceof PlayerEntity) {
            Team EmptyBlockView;
            PlayerEntity class_16572 = (PlayerEntity)class_12972;
            if (com.vengeance.vengeanceclient.utils.q.za.c(class_16572.getUuid())) {
                return this.j.h();
            }
            if (this.h.b() && (EmptyBlockView = class_16572.getScoreboardTeam()) != null && EmptyBlockView.getColor().getColorValue() != null) {
                return new Color(EmptyBlockView.getColor().getColorValue());
            }
            return this.i.h();
        }
        if (class_12972 instanceof PassiveEntity) {
            return this.k.h();
        }
        if (class_12972 instanceof HostileEntity) {
            return this.l.h();
        }
        return this.i.h();
    }
}

