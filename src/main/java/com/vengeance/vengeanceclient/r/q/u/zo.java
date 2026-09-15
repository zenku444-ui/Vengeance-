/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.opengl.GlStateManager
 *  net.minecraft.client.render.RenderLayers
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.render.VertexConsumer
 *  net.minecraft.client.render.VertexConsumerProvider
 *  net.minecraft.client.render.VertexConsumerProvider$Immediate
 *  net.minecraft.util.math.RotationAxis
 *  net.minecraft.client.util.BufferAllocator
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Quaternionfc
 */
package com.vengeance.vengeanceclient.r.q.u;

import com.mojang.blaze3d.opengl.GlStateManager;
import com.vengeance.vengeanceclient.r.r.zd;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import com.vengeance.vengeanceclient.utils.w.zm;
import java.awt.Color;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.Identifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.client.util.BufferAllocator;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionfc;

public final class zo
extends zb {
    private static final Identifier b = Identifier.of((String)"vengeance-client", (String)"textures/visuals/firefly.png");
    private static final BufferAllocator c = new BufferAllocator(65536);
    private final zd d = new zd("Targets", "Players", "Players", "Living");
    private final ze e = new ze("Layers", 1.0, 5.0, 3.0, 1.0);
    private final ze f = new ze("Orbs Per Layer", 5.0, 20.0, 14.0, 1.0);
    private final ze g = new ze("Orb Size", 0.1, 0.8, 0.3, 0.05);
    private final ze h = new ze("Speed", 0.5, 5.0, 2.5, 0.1);
    private final ze i = new ze("Height Offset", 0.0, 2.0, 1.0, 0.1);
    private final zd j = new zd("Color Mode", "Single", "Single", "Gradient");
    private final com.vengeance.vengeanceclient.r.r.zb k = new com.vengeance.vengeanceclient.r.r.zb("Color", new Color(120, 240, 255, 220));
    private final com.vengeance.vengeanceclient.r.r.zb l = new com.vengeance.vengeanceclient.r.r.zb("Gradient Color 1", new Color(255, 0, 0, 220));
    private final com.vengeance.vengeanceclient.r.r.zb m = new com.vengeance.vengeanceclient.r.r.zb("Gradient Color 2", new Color(0, 0, 255, 220));

    public zo() {
        super("Target ESP", "Ghost-like spiral orbs around players", -1, za.d);
        this.a(this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
    }

    @EventHandler
    private void onRender3D(com.vengeance.vengeanceclient.p.p.t.zb zb2) {
        if (this.d()) {
            return;
        }
        MatrixStack class_45872 = zb2.a();
        float f = a.getRenderTickCounter().getTickProgress(true);
        GlStateManager._enableBlend();
        GlStateManager._blendFuncSeparate((int)770, (int)1, (int)1, (int)1);
        float f2 = this.g.b();
        float f3 = this.i.b();
        Color color = this.k.h();
        int n = this.e.a();
        int n2 = this.f.a();
        boolean bl = this.j.b("Gradient");
        float f4 = (float)(System.currentTimeMillis() % 100000L) / 50.0f;
        float f5 = f4 * this.h.b();
        for (Entity class_12972 : zo.a.world.getEntities()) {
            if (!this.a(class_12972)) continue;
            Vec3d VanillaChestLootTableGenerator = zm.a(class_12972, f);
            double d = VanillaChestLootTableGenerator.x;
            double d2 = VanillaChestLootTableGenerator.y + (double)f3;
            double d3 = VanillaChestLootTableGenerator.z;
            if (zo.a.player.canSee(class_12972)) {
                GlStateManager._enableDepthTest();
                GlStateManager._depthMask((boolean)false);
            } else {
                GlStateManager._disableDepthTest();
            }
            VertexConsumerProvider.Immediate class_45982 = VertexConsumerProvider.immediate((BufferAllocator)c);
            VertexConsumer class_45882 = class_45982.getBuffer(RenderLayers.entityTranslucent((Identifier)b));
            for (int i = 0; i < n; ++i) {
                float f6 = (float)i * 120.0f;
                float f7 = (float)i + 1.0f;
                for (int j = 0; j <= n2; ++j) {
                    int n3;
                    float f8 = j;
                    double d4 = Math.toRadians(((f8 / 1.5f + f4 * this.h.b()) * 8.0f + f6) % 2880.0f);
                    double d5 = Math.sin(Math.toRadians(f5 + (float)j * f7) * 3.0) / (double)1.8f;
                    float f9 = f8 / (float)n2;
                    if (bl) {
                        Color color2 = this.a(this.l.h(), this.m.h(), f9);
                        n3 = this.a(color2.getRGB(), f9);
                    } else {
                        n3 = this.a(color.getRGB(), f9);
                    }
                    double d6 = Math.cos(d4) * (double)class_12972.getWidth();
                    double d7 = d5;
                    double d8 = Math.sin(d4) * (double)class_12972.getWidth();
                    class_45872.push();
                    class_45872.translate(d + d6, d2 + d7, d3 + d8);
                    class_45872.multiply((Quaternionfc)RotationAxis.POSITIVE_Y.rotationDegrees(-zo.a.gameRenderer.getCamera().getYaw()));
                    class_45872.multiply((Quaternionfc)RotationAxis.POSITIVE_X.rotationDegrees(zo.a.gameRenderer.getCamera().getPitch()));
                    Matrix4f matrix4f = class_45872.peek().getPositionMatrix();
                    float f10 = (float)(n3 >>> 24 & 0xFF) / 255.0f;
                    float f11 = (float)(n3 >>> 16 & 0xFF) / 255.0f;
                    float f12 = (float)(n3 >>> 8 & 0xFF) / 255.0f;
                    float f13 = (float)(n3 & 0xFF) / 255.0f;
                    int n4 = Math.max(0, Math.min(255, Math.round(f11 * 255.0f)));
                    int n5 = Math.max(0, Math.min(255, Math.round(f12 * 255.0f)));
                    int n6 = Math.max(0, Math.min(255, Math.round(f13 * 255.0f)));
                    int n7 = Math.max(0, Math.min(255, Math.round(f10 * 255.0f)));
                    class_45882.vertex((Matrix4fc)matrix4f, -f2, f2, 0.0f).texture(0.0f, 1.0f).color(n4, n5, n6, n7).overlay(0).light(0xF000F0);
                    class_45882.vertex((Matrix4fc)matrix4f, f2, f2, 0.0f).texture(1.0f, 1.0f).color(n4, n5, n6, n7).overlay(0).light(0xF000F0);
                    class_45882.vertex((Matrix4fc)matrix4f, f2, -f2, 0.0f).texture(1.0f, 0.0f).color(n4, n5, n6, n7).overlay(0).light(0xF000F0);
                    class_45882.vertex((Matrix4fc)matrix4f, -f2, -f2, 0.0f).texture(0.0f, 0.0f).color(n4, n5, n6, n7).overlay(0).light(0xF000F0);
                    class_45872.pop();
                }
            }
            class_45982.draw();
            if (!zo.a.player.canSee(class_12972)) continue;
            GlStateManager._depthMask((boolean)true);
        }
        GlStateManager._enableDepthTest();
        GlStateManager._disableBlend();
    }

    private Color a(Color color, Color color2, float f) {
        f = Math.min(1.0f, Math.max(0.0f, f));
        int n = (int)((float)color.getRed() * (1.0f - f) + (float)color2.getRed() * f);
        int n2 = (int)((float)color.getGreen() * (1.0f - f) + (float)color2.getGreen() * f);
        int n3 = (int)((float)color.getBlue() * (1.0f - f) + (float)color2.getBlue() * f);
        int n4 = (int)((float)color.getAlpha() * (1.0f - f) + (float)color2.getAlpha() * f);
        return new Color(n, n2, n3, n4);
    }

    private int a(int n, float f) {
        f = Math.min(1.0f, Math.max(0.0f, f));
        Color color = new Color(n, true);
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), (int)((float)color.getAlpha() * f)).getRGB();
    }

    private boolean a(Entity class_12972) {
        if (class_12972 == zo.a.player) {
            return false;
        }
        if (this.d.b("Players")) {
            return class_12972 instanceof PlayerEntity;
        }
        return class_12972 instanceof LivingEntity;
    }
}

