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
package com.vengeance.vengeanceclient.utils.w.p;

import com.mojang.blaze3d.opengl.GlStateManager;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.vengeance.vengeanceclient.utils.w.p.ze;
import com.vengeance.vengeanceclient.utils.w.p.zf;
import com.vengeance.vengeanceclient.utils.w.q.q.za;
import com.vengeance.vengeanceclient.utils.w.zd;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;

public record zc(zf a, ze b, com.vengeance.vengeanceclient.utils.w.p.zd c, float d, float e) {
    public void a(Matrix4f matrix4f, float f, float f2, float f3) {
        int n;
        float f4 = this.a.a();
        float f5 = this.a.b();
        if (f4 <= 0.0f || f5 <= 0.0f) {
            return;
        }
        GlStateManager._enableBlend();
        GlStateManager._blendFuncSeparate((int)770, (int)771, (int)1, (int)771);
        GlStateManager._disableCull();
        zd.a();
        int n2 = Math.max(1, Math.min(16, Math.round(Math.max(1.0f, this.e))));
        int n3 = this.f();
        BufferBuilder class_2872 = Tessellator.getInstance().begin(VertexFormat.class_5596.QUADS, VertexFormats.POSITION_COLOR);
        for (n = n2; n >= 1; --n) {
            float f6 = (float)n * 0.75f;
            float f7 = (float)n / (float)n2;
            int n4 = zc.a(n3, f7 * 0.2f * Math.max(0.25f, this.d));
            zc.a(class_2872, matrix4f, f - f6, f2 - f6, f3, f4 + f6 * 2.0f, f5 + f6 * 2.0f, n4);
        }
        n = zc.a(n3, 0.12f * Math.max(0.25f, this.d));
        zc.a(class_2872, matrix4f, f, f2, f3, f4, f5, n);
        za.a(class_2872);
        GlStateManager._enableCull();
        GlStateManager._disableBlend();
    }

    private int f() {
        int n = ((this.c.a() >>> 24 & 0xFF) + (this.c.b() >>> 24 & 0xFF) + (this.c.c() >>> 24 & 0xFF) + (this.c.d() >>> 24 & 0xFF)) / 4;
        int n2 = ((this.c.a() >>> 16 & 0xFF) + (this.c.b() >>> 16 & 0xFF) + (this.c.c() >>> 16 & 0xFF) + (this.c.d() >>> 16 & 0xFF)) / 4;
        int n3 = ((this.c.a() >>> 8 & 0xFF) + (this.c.b() >>> 8 & 0xFF) + (this.c.c() >>> 8 & 0xFF) + (this.c.d() >>> 8 & 0xFF)) / 4;
        int n4 = ((this.c.a() & 0xFF) + (this.c.b() & 0xFF) + (this.c.c() & 0xFF) + (this.c.d() & 0xFF)) / 4;
        return (n & 0xFF) << 24 | (n2 & 0xFF) << 16 | (n3 & 0xFF) << 8 | n4 & 0xFF;
    }

    private static int a(int n, float f) {
        int n2 = n >>> 24 & 0xFF;
        int n3 = Math.max(0, Math.min(255, Math.round((float)n2 * Math.max(0.0f, Math.min(1.0f, f)))));
        return n3 << 24 | n & 0xFFFFFF;
    }

    private static void a(BufferBuilder class_2872, Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, int n) {
        zc.a(class_2872, matrix4f, f, f2, f3, n);
        zc.a(class_2872, matrix4f, f, f2 + f5, f3, n);
        zc.a(class_2872, matrix4f, f + f4, f2 + f5, f3, n);
        zc.a(class_2872, matrix4f, f + f4, f2, f3, n);
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
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{zc.class, "size;radius;color;smoothness;blurRadius", "a", "b", "c", "d", "e"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{zc.class, "size;radius;color;smoothness;blurRadius", "a", "b", "c", "d", "e"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{zc.class, "size;radius;color;smoothness;blurRadius", "a", "b", "c", "d", "e"}, this, object);
    }
}

