/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.VertexFormat$DrawMode
 *  net.minecraft.client.render.BufferBuilder
 *  net.minecraft.client.render.Tessellator
 *  net.minecraft.client.render.VertexFormats
 *  net.minecraft.client.util.math.MatrixStack
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 */
package com.vengeance.vengeanceclient.utils.w;

import com.mojang.blaze3d.vertex.VertexFormat;
import com.vengeance.vengeanceclient.utils.w.q.q.za;
import com.vengeance.vengeanceclient.utils.w.zd;
import java.awt.Color;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;

public class zf {
    public static void a(MatrixStack class_45872, float f, float f2, float f3, float f4, Color color) {
        Matrix4f matrix4f = class_45872.peek().getPositionMatrix();
        zf.a();
        zd.a();
        BufferBuilder class_2872 = Tessellator.getInstance().begin(VertexFormat.class_5596.QUADS, VertexFormats.POSITION_COLOR);
        class_2872.vertex((Matrix4fc)matrix4f, f, f4, 0.0f).color(color.getRGB());
        class_2872.vertex((Matrix4fc)matrix4f, f3, f4, 0.0f).color(color.getRGB());
        class_2872.vertex((Matrix4fc)matrix4f, f3, f2, 0.0f).color(color.getRGB());
        class_2872.vertex((Matrix4fc)matrix4f, f, f2, 0.0f).color(color.getRGB());
        za.a(class_2872);
        zf.b();
    }

    public static void a(MatrixStack class_45872, float f, float f2, float f3, float f4, Color color, Color color2) {
        Matrix4f matrix4f = class_45872.peek().getPositionMatrix();
        zf.a();
        zd.a();
        BufferBuilder class_2872 = Tessellator.getInstance().begin(VertexFormat.class_5596.QUADS, VertexFormats.POSITION_COLOR);
        class_2872.vertex((Matrix4fc)matrix4f, f, f4, 0.0f).color(color.getRGB());
        class_2872.vertex((Matrix4fc)matrix4f, f3, f4, 0.0f).color(color.getRGB());
        class_2872.vertex((Matrix4fc)matrix4f, f3, f2, 0.0f).color(color.getRGB());
        class_2872.vertex((Matrix4fc)matrix4f, f, f2, 0.0f).color(color.getRGB());
        za.a(class_2872);
        class_2872 = Tessellator.getInstance().begin(VertexFormat.class_5596.DEBUG_LINE_STRIP, VertexFormats.POSITION_COLOR);
        class_2872.vertex((Matrix4fc)matrix4f, f, f4, 0.0f).color(color2.getRGB());
        class_2872.vertex((Matrix4fc)matrix4f, f3, f4, 0.0f).color(color2.getRGB());
        class_2872.vertex((Matrix4fc)matrix4f, f3, f2, 0.0f).color(color2.getRGB());
        class_2872.vertex((Matrix4fc)matrix4f, f, f2, 0.0f).color(color2.getRGB());
        class_2872.vertex((Matrix4fc)matrix4f, f, f4, 0.0f).color(color2.getRGB());
        za.a(class_2872);
        zf.b();
    }

    public static void b(MatrixStack class_45872, float f, float f2, float f3, float f4, Color color, Color color2) {
        Matrix4f matrix4f = class_45872.peek().getPositionMatrix();
        zf.a();
        zd.a();
        BufferBuilder class_2872 = Tessellator.getInstance().begin(VertexFormat.class_5596.QUADS, VertexFormats.POSITION_COLOR);
        class_2872.vertex((Matrix4fc)matrix4f, f, f2, 0.0f).color(color.getRGB());
        class_2872.vertex((Matrix4fc)matrix4f, f, f4, 0.0f).color(color.getRGB());
        class_2872.vertex((Matrix4fc)matrix4f, f3, f4, 0.0f).color(color2.getRGB());
        class_2872.vertex((Matrix4fc)matrix4f, f3, f2, 0.0f).color(color2.getRGB());
        za.a(class_2872);
        zf.b();
    }

    public static void a() {
    }

    public static void b() {
    }

    public static void a(BufferBuilder class_2872, Matrix4f matrix4f, float f, float f2, float f3, float f4, Color color, Color color2) {
        zf.a(class_2872, matrix4f, f, f2, f3, f4, color, color, color2, color2);
    }

    public static void b(BufferBuilder class_2872, Matrix4f matrix4f, float f, float f2, float f3, float f4, Color color, Color color2) {
        zf.a(class_2872, matrix4f, f, f2, f3, f4, color, color2, color2, color);
    }

    public static void a(BufferBuilder class_2872, Matrix4f matrix4f, float f, float f2, float f3, float f4, Color color) {
        zf.a(class_2872, matrix4f, f, f2, f3, f4, color, color, color, color);
    }

    public static void a(BufferBuilder class_2872, Matrix4f matrix4f, float f, float f2, float f3, float f4, Color color, Color color2, Color color3, Color color4) {
        class_2872.vertex((Matrix4fc)matrix4f, f3, f2, 0.0f).color(color2.getRGB());
        class_2872.vertex((Matrix4fc)matrix4f, f, f2, 0.0f).color(color.getRGB());
        class_2872.vertex((Matrix4fc)matrix4f, f, f4, 0.0f).color(color4.getRGB());
        class_2872.vertex((Matrix4fc)matrix4f, f3, f4, 0.0f).color(color3.getRGB());
    }
}

