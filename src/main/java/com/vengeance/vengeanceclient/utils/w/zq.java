/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.opengl.GlStateManager
 *  com.mojang.blaze3d.vertex.VertexFormat$DrawMode
 *  net.minecraft.client.gl.RenderPipelines
 *  net.minecraft.client.render.RenderLayers
 *  net.minecraft.client.render.BufferBuilder
 *  net.minecraft.client.render.Tessellator
 *  net.minecraft.client.render.VertexFormats
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.util.math.MatrixStack
 *  org.joml.Matrix3x2fStack
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 */
package com.vengeance.vengeanceclient.utils.w;

import com.mojang.blaze3d.opengl.GlStateManager;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.vengeance.vengeanceclient.utils.w.q.q.za;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.Identifier;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix3x2fStack;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;

public final class zq {
    private zq() {
    }

    public static void a() {
        GlStateManager._texParameter((int)3553, (int)10241, (int)9729);
        GlStateManager._texParameter((int)3553, (int)10240, (int)9729);
    }

    public static void b() {
        GlStateManager._texParameter((int)3553, (int)10241, (int)9728);
        GlStateManager._texParameter((int)3553, (int)10240, (int)9728);
    }

    public static void c() {
        GlStateManager._enableDepthTest();
        GlStateManager._depthFunc((int)519);
        GlStateManager._depthMask((boolean)false);
        GlStateManager._colorMask((boolean)false, (boolean)false, (boolean)false, (boolean)false);
    }

    public static void d() {
        GlStateManager._depthFunc((int)514);
        GlStateManager._depthMask((boolean)false);
        GlStateManager._colorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
    }

    public static void e() {
        GlStateManager._depthFunc((int)515);
        GlStateManager._depthMask((boolean)true);
        GlStateManager._colorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
        GlStateManager._disableDepthTest();
    }

    public static void a(MatrixStack class_45872, Identifier class_29602, float f, float f2, int n) {
        zq.a(class_45872, class_29602, f, f2, n, false);
    }

    public static void a(MatrixStack class_45872, Identifier class_29602, float f, float f2, int n, boolean bl) {
        if (class_45872 == null || class_29602 == null) {
            return;
        }
        if (bl) {
            zq.a();
        }
        float f3 = (float)(n >>> 24 & 0xFF) / 255.0f;
        float f4 = (float)(n >>> 16 & 0xFF) / 255.0f;
        float f5 = (float)(n >>> 8 & 0xFF) / 255.0f;
        float f6 = (float)(n & 0xFF) / 255.0f;
        Matrix4f matrix4f = class_45872.peek().getPositionMatrix();
        float f7 = f * 0.5f;
        float f8 = f2 * 0.5f;
        BufferBuilder class_2872 = Tessellator.getInstance().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
        class_2872.vertex((Matrix4fc)matrix4f, -f7, f8, 0.0f).texture(0.0f, 1.0f).color(f4, f5, f6, f3);
        class_2872.vertex((Matrix4fc)matrix4f, f7, f8, 0.0f).texture(1.0f, 1.0f).color(f4, f5, f6, f3);
        class_2872.vertex((Matrix4fc)matrix4f, f7, -f8, 0.0f).texture(1.0f, 0.0f).color(f4, f5, f6, f3);
        class_2872.vertex((Matrix4fc)matrix4f, -f7, -f8, 0.0f).texture(0.0f, 0.0f).color(f4, f5, f6, f3);
        za.a(class_2872, RenderLayers.entityTranslucent((Identifier)class_29602));
        if (bl) {
            zq.b();
        }
    }

    public static void a(DrawContext class_3322, Identifier class_29602, float f, float f2, float f3, float f4, float f5, int n) {
        zq.a(class_3322, class_29602, f, f2, f3, f4, f5, n, false);
    }

    public static void a(DrawContext class_3322, Identifier class_29602, float f, float f2, float f3, float f4, float f5, int n, boolean bl) {
        Matrix3x2fStack matrix3x2fStack = class_3322.getMatrices();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.translate(f, f2);
        if (f5 != 0.0f) {
            matrix3x2fStack.rotate((float)Math.toRadians(f5));
        }
        int n2 = Math.max(1, Math.round(f3));
        int n3 = Math.max(1, Math.round(f4));
        int n4 = Math.round(-f3 * 0.5f);
        int n5 = Math.round(-f4 * 0.5f);
        if (bl) {
            zq.a();
        }
        class_3322.drawTexture(RenderPipelines.GUI_TEXTURED, class_29602, n4, n5, 0.0f, 0.0f, n2, n3, n2, n3);
        if (bl) {
            zq.b();
        }
        matrix3x2fStack.popMatrix();
    }

    public static void a(DrawContext class_3322, Identifier class_29602, float f, float f2, float f3, float f4, int n) {
        zq.b(class_3322, class_29602, f, f2, f3, f4, 0.0f, n, false);
    }

    public static void b(DrawContext class_3322, Identifier class_29602, float f, float f2, float f3, float f4, float f5, int n, boolean bl) {
        zq.a(class_3322, class_29602, f, f2, f3, f4, f5, n, bl);
    }
}

