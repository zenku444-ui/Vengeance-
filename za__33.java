/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.opengl.GlStateManager
 *  com.mojang.blaze3d.vertex.VertexFormat$DrawMode
 *  net.minecraft.client.render.BufferBuilder
 *  net.minecraft.client.render.Tessellator
 *  net.minecraft.client.render.VertexFormats
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 */
package com.vengeance.vengeanceclient.utils.w.s.q;

import com.mojang.blaze3d.opengl.GlStateManager;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.vengeance.vengeanceclient.utils.w.s.r.zb;
import com.vengeance.vengeanceclient.utils.w.s.zc;
import com.vengeance.vengeanceclient.utils.w.zd;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;

public final class za
extends Record
implements zc {
    private final com.vengeance.vengeanceclient.utils.w.s.r.zc b;
    private final zb c;
    private final com.vengeance.vengeanceclient.utils.w.s.r.za d;
    private final float e;
    private final float f;

    public za(com.vengeance.vengeanceclient.utils.w.s.r.zc zc2, zb zb2, com.vengeance.vengeanceclient.utils.w.s.r.za za2, float f, float f2) {
        this.b = zc2;
        this.c = zb2;
        this.d = za2;
        this.e = f;
        this.f = f2;
    }

    @Override
    public void a(Matrix4f matrix4f, float f, float f2, float f3) {
        float f4 = this.b.a();
        float f5 = this.b.b();
        if (f4 <= 0.0f || f5 <= 0.0f) {
            return;
        }
        float f6 = Math.max(0.5f, this.e);
        f6 = Math.min(f6, Math.min(f4, f5) * 0.5f);
        GlStateManager._enableBlend();
        GlStateManager._blendFuncSeparate((int)770, (int)771, (int)1, (int)771);
        GlStateManager._disableCull();
        zd.a();
        BufferBuilder class_2872 = Tessellator.getInstance().begin(VertexFormat.class_5596.QUADS, VertexFormats.POSITION_COLOR);
        za.a(class_2872, matrix4f, f, f2, f3, f4, f6, this.d.a(), this.d.a(), this.d.d(), this.d.d());
        za.a(class_2872, matrix4f, f, f2 + f5 - f6, f3, f4, f6, this.d.b(), this.d.b(), this.d.c(), this.d.c());
        za.a(class_2872, matrix4f, f, f2 + f6, f3, f6, Math.max(0.0f, f5 - f6 * 2.0f), this.d.a(), this.d.b(), this.d.b(), this.d.a());
        za.a(class_2872, matrix4f, f + f4 - f6, f2 + f6, f3, f6, Math.max(0.0f, f5 - f6 * 2.0f), this.d.d(), this.d.c(), this.d.c(), this.d.d());
        com.vengeance.vengeanceclient.utils.w.q.q.za.a(class_2872);
        GlStateManager._enableCull();
        GlStateManager._disableBlend();
    }

    private static void a(BufferBuilder class_2872, Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, int n, int n2, int n3, int n4) {
        za.a(class_2872, matrix4f, f, f2, f3, n);
        za.a(class_2872, matrix4f, f, f2 + f5, f3, n2);
        za.a(class_2872, matrix4f, f + f4, f2 + f5, f3, n3);
        za.a(class_2872, matrix4f, f + f4, f2, f3, n4);
    }

    private static void a(BufferBuilder class_2872, Matrix4f matrix4f, float f, float f2, float f3, int n) {
        float f4 = (float)(n >>> 24 & 0xFF) / 255.0f;
        float f5 = (float)(n >>> 16 & 0xFF) / 255.0f;
        float f6 = (float)(n >>> 8 & 0xFF) / 255.0f;
        float f7 = (float)(n & 0xFF) / 255.0f;
        class_2872.vertex((Matrix4fc)matrix4f, f, f2, f3).color(f5, f6, f7, f4);
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{za.class, "size;radius;color;thickness;smoothness", "b", "c", "d", "e", "f"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{za.class, "size;radius;color;thickness;smoothness", "b", "c", "d", "e", "f"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{za.class, "size;radius;color;thickness;smoothness", "b", "c", "d", "e", "f"}, this, object);
    }

    public com.vengeance.vengeanceclient.utils.w.s.r.zc a() {
        return this.b;
    }

    public zb b() {
        return this.c;
    }

    public com.vengeance.vengeanceclient.utils.w.s.r.za c() {
        return this.d;
    }

    public float d() {
        return this.e;
    }

    public float e() {
        return this.f;
    }
}

