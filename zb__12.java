/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.opengl.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.util.math.MathHelper
 */
package com.vengeance.vengeanceclient.r.q.u;

import com.mojang.blaze3d.opengl.GlStateManager;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.utils.w.zq;
import java.awt.Color;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.Identifier;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.math.MathHelper;

public final class zb
extends com.vengeance.vengeanceclient.r.zb {
    private static final Identifier b = Identifier.of((String)"vengeance-client", (String)"textures/visuals/triangle.png");
    private final com.vengeance.vengeanceclient.r.r.za c = new com.vengeance.vengeanceclient.r.r.za("Show Self", false);
    private final ze d = new ze("Range", 10.0, 200.0, 120.0, 5.0);
    private final ze e = new ze("Size", 8.0, 64.0, 24.0, 1.0);
    private final ze f = new ze("Offset", 0.0, 64.0, 28.0, 1.0);
    private final com.vengeance.vengeanceclient.r.r.zb g = new com.vengeance.vengeanceclient.r.r.zb("Color", new Color(255, 255, 255, 200), true);

    public zb() {
        super("Arrow ESP", "Displays arrows pointing to players", -1, za.d);
        this.a(this.c, this.d, this.e, this.f, this.g);
    }

    @EventHandler
    private void onRender2D(com.vengeance.vengeanceclient.p.p.t.za za2) {
        if (this.d()) {
            return;
        }
        DrawContext class_3322 = za2.a();
        int n = za2.b();
        int n2 = za2.c();
        float f = (float)n * 0.5f;
        float f2 = (float)n2 * 0.5f;
        float f3 = a.getRenderTickCounter().getTickProgress(true);
        Vec3d VanillaChestLootTableGenerator = zb.a.gameRenderer.getCamera().getCameraPos();
        float f4 = zb.a.gameRenderer.getCamera().getYaw();
        GlStateManager._disableDepthTest();
        GlStateManager._depthMask((boolean)false);
        GlStateManager._enableBlend();
        GlStateManager._blendFuncSeparate((int)770, (int)771, (int)1, (int)771);
        Color color = this.g.h();
        int n3 = color.getAlpha();
        float f5 = this.e.b();
        float f6 = this.f.b();
        double d = this.d.f();
        for (PlayerEntity class_16572 : zb.a.world.getPlayers()) {
            double d2;
            if (!this.a(class_16572) || (d2 = zb.a.player.squaredDistanceTo((Entity)class_16572)) > d * d) continue;
            Vec3d WallPlayerSkullBlock = class_16572.getLerpedPos(f3);
            double d3 = WallPlayerSkullBlock.x - VanillaChestLootTableGenerator.x;
            double d4 = WallPlayerSkullBlock.z - VanillaChestLootTableGenerator.z;
            double d5 = Math.sqrt(d3 * d3 + d4 * d4);
            if (d5 < 1.0E-6) continue;
            float f7 = (float)MathHelper.wrapDegrees((double)(Math.toDegrees(Math.atan2(d4, d3)) - 90.0 - (double)f4));
            double d6 = Math.sqrt(d2);
            float f8 = (float)Math.min(d6 / d, 1.0);
            float f9 = 1.0f - f8 * 0.6f;
            int n4 = Math.max(24, Math.min(255, (int)((float)n3 * f9)));
            int n5 = n4 << 24 | color.getRed() << 16 | color.getGreen() << 8 | color.getBlue();
            float f10 = f;
            float f11 = f2 - (f6 + f8 * f6);
            zq.a(class_3322, b, f10, f11, f5, f5, f7, n5, true);
        }
        GlStateManager._disableBlend();
        GlStateManager._depthMask((boolean)true);
        GlStateManager._enableDepthTest();
    }

    private boolean a(PlayerEntity class_16572) {
        if (class_16572 == zb.a.player && !this.c.b()) {
            return false;
        }
        return !class_16572.isSpectator();
    }
}

