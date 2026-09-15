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
import com.vengeance.vengeanceclient.utils.w.s.r.za;
import com.vengeance.vengeanceclient.utils.w.s.zc;
import com.vengeance.vengeanceclient.utils.w.zd;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;

public record zb(com.vengeance.vengeanceclient.utils.w.s.r.zc size, com.vengeance.vengeanceclient.utils.w.s.r.zb radius, za color, float smoothness) implements zc {

    public zb(com.vengeance.vengeanceclient.utils.w.s.r.zc zc2, com.vengeance.vengeanceclient.utils.w.s.r.zb zb2, za za2, float f) {
        this.size = zc2;
        this.radius = zb2;
        this.color = za2;
        this.smoothness = f;
    }

    @Override
    public void a(Matrix4f matrix4f, float f, float f2, float f3) {
        float f4 = this.size.a();
        float f5 = this.size.b();
        if (f4 <= 0.0f || f5 <= 0.0f) {
            return;
        }
        GlStateManager._enableBlend();
        GlStateManager._blendFuncSeparate((int)770, (int)771, (int)1, (int)771);
        GlStateManager._disableCull();
        zd.a();
        BufferBuilder class_2872 = Tessellator.getInstance().begin(VertexFormat.class_5596.QUADS, VertexFormats.POSITION_COLOR);
        zb.a(class_2872, matrix4f, f, f2, f3, f4, f5, this.color.a(), this.color.b(), this.color.c(), this.color.d());
        com.vengeance.vengeanceclient.utils.w.q.q.za.a(class_2872);
        GlStateManager._enableCull();
        GlStateManager._disableBlend();
    }

    private static void a(BufferBuilder class_2872, Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, int n, int n2, int n3, int n4) {
        zb.a(class_2872, matrix4f, f, f2, f3, n);
        zb.a(class_2872, matrix4f, f, f2 + f5, f3, n2);
        zb.a(class_2872, matrix4f, f + f4, f2 + f5, f3, n3);
        zb.a(class_2872, matrix4f, f + f4, f2, f3, n4);
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
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{zb.class, "size;radius;color;smoothness", "size", "radius", "color", "smoothness"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{zb.class, "size;radius;color;smoothness", "size", "radius", "color", "smoothness"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{zb.class, "size;radius;color;smoothness", "size", "radius", "color", "smoothness"}, this, object);
    }

    public com.vengeance.vengeanceclient.utils.w.s.r.zc a() {
        return this.size;
    }

    public com.vengeance.vengeanceclient.utils.w.s.r.zb b() {
        return this.radius;
    }

    public za c() {
        return this.color;
    }

    public float d() {
        return this.smoothness;
    }
}

