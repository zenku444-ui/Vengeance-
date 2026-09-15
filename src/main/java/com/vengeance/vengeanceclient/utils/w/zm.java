/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.opengl.GlStateManager
 *  com.mojang.blaze3d.vertex.VertexFormat$DrawMode
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.client.render.BufferBuilder
 *  net.minecraft.client.render.Tessellator
 *  net.minecraft.client.render.VertexFormats
 *  net.minecraft.client.util.math.MatrixStack
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 */
package com.vengeance.vengeanceclient.utils.w;

import com.mojang.blaze3d.opengl.GlStateManager;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.vengeance.vengeanceclient.utils.w.q.q.za;
import com.vengeance.vengeanceclient.utils.w.zd;
import java.awt.Color;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;

public final class zm {
    private zm() {
    }

    public static void a() {
        GlStateManager._enableBlend();
        GlStateManager._blendFuncSeparate((int)770, (int)771, (int)1, (int)771);
        GlStateManager._disableCull();
        zd.a();
    }

    public static void b() {
        zm.a();
        GlStateManager._disableDepthTest();
    }

    public static void c() {
        GlStateManager._enableCull();
        GlStateManager._enableDepthTest();
        GlStateManager._disableBlend();
    }

    public static void a(MatrixStack class_45872, Box HorizontalFacingBlock, Color color) {
        zm.c(class_45872, HorizontalFacingBlock, color);
    }

    public static void a(MatrixStack class_45872, double d, double d2, double d3, float f, float f2, Color color) {
        float f3 = f / 2.0f;
        Box HorizontalFacingBlock = new Box(d - (double)f3, d2, d3 - (double)f3, d + (double)f3, d2 + (double)f2, d3 + (double)f3);
        zm.c(class_45872, HorizontalFacingBlock, color);
    }

    public static void b(MatrixStack class_45872, Box HorizontalFacingBlock, Color color) {
        Matrix4f matrix4f = class_45872.peek().getPositionMatrix();
        BufferBuilder class_2872 = Tessellator.getInstance().begin(VertexFormat.DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
        float f = (float)color.getRed() / 255.0f;
        float f2 = (float)color.getGreen() / 255.0f;
        float f3 = (float)color.getBlue() / 255.0f;
        float f4 = (float)color.getAlpha() / 255.0f;
        float f5 = (float)HorizontalFacingBlock.minX;
        float f6 = (float)HorizontalFacingBlock.minY;
        float f7 = (float)HorizontalFacingBlock.minZ;
        float f8 = (float)HorizontalFacingBlock.maxX;
        float f9 = (float)HorizontalFacingBlock.maxY;
        float f10 = (float)HorizontalFacingBlock.maxZ;
        zm.a(class_2872, matrix4f, f5, f6, f7, f8, f6, f7, f, f2, f3, f4);
        zm.a(class_2872, matrix4f, f8, f6, f7, f8, f6, f10, f, f2, f3, f4);
        zm.a(class_2872, matrix4f, f8, f6, f10, f5, f6, f10, f, f2, f3, f4);
        zm.a(class_2872, matrix4f, f5, f6, f10, f5, f6, f7, f, f2, f3, f4);
        zm.a(class_2872, matrix4f, f5, f9, f7, f8, f9, f7, f, f2, f3, f4);
        zm.a(class_2872, matrix4f, f8, f9, f7, f8, f9, f10, f, f2, f3, f4);
        zm.a(class_2872, matrix4f, f8, f9, f10, f5, f9, f10, f, f2, f3, f4);
        zm.a(class_2872, matrix4f, f5, f9, f10, f5, f9, f7, f, f2, f3, f4);
        zm.a(class_2872, matrix4f, f5, f6, f7, f5, f9, f7, f, f2, f3, f4);
        zm.a(class_2872, matrix4f, f8, f6, f7, f8, f9, f7, f, f2, f3, f4);
        zm.a(class_2872, matrix4f, f8, f6, f10, f8, f9, f10, f, f2, f3, f4);
        zm.a(class_2872, matrix4f, f5, f6, f10, f5, f9, f10, f, f2, f3, f4);
        za.a(class_2872);
    }

    public static void b(MatrixStack class_45872, double d, double d2, double d3, float f, float f2, Color color) {
        float f3 = f / 2.0f;
        Box HorizontalFacingBlock = new Box(d - (double)f3, d2, d3 - (double)f3, d + (double)f3, d2 + (double)f2, d3 + (double)f3);
        zm.b(class_45872, HorizontalFacingBlock, color);
    }

    public static void c(MatrixStack class_45872, Box HorizontalFacingBlock, Color color) {
        Matrix4f matrix4f = class_45872.peek().getPositionMatrix();
        BufferBuilder class_2872 = Tessellator.getInstance().begin(VertexFormat.DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
        float f = (float)color.getRed() / 255.0f;
        float f2 = (float)color.getGreen() / 255.0f;
        float f3 = (float)color.getBlue() / 255.0f;
        float f4 = (float)color.getAlpha() / 255.0f;
        float f5 = (float)HorizontalFacingBlock.minX;
        float f6 = (float)HorizontalFacingBlock.minY;
        float f7 = (float)HorizontalFacingBlock.minZ;
        float f8 = (float)HorizontalFacingBlock.maxX;
        float f9 = (float)HorizontalFacingBlock.maxY;
        float f10 = (float)HorizontalFacingBlock.maxZ;
        zm.a(class_2872, matrix4f, f5, f6, f7, f8, f6, f7, f8, f9, f7, f, f2, f3, f4);
        zm.a(class_2872, matrix4f, f5, f6, f7, f8, f9, f7, f5, f9, f7, f, f2, f3, f4);
        zm.a(class_2872, matrix4f, f8, f6, f7, f8, f6, f10, f8, f9, f10, f, f2, f3, f4);
        zm.a(class_2872, matrix4f, f8, f6, f7, f8, f9, f10, f8, f9, f7, f, f2, f3, f4);
        zm.a(class_2872, matrix4f, f8, f6, f10, f5, f6, f10, f5, f9, f10, f, f2, f3, f4);
        zm.a(class_2872, matrix4f, f8, f6, f10, f5, f9, f10, f8, f9, f10, f, f2, f3, f4);
        zm.a(class_2872, matrix4f, f5, f6, f10, f5, f6, f7, f5, f9, f7, f, f2, f3, f4);
        zm.a(class_2872, matrix4f, f5, f6, f10, f5, f9, f7, f5, f9, f10, f, f2, f3, f4);
        zm.a(class_2872, matrix4f, f5, f9, f7, f8, f9, f7, f8, f9, f10, f, f2, f3, f4);
        zm.a(class_2872, matrix4f, f5, f9, f7, f8, f9, f10, f5, f9, f10, f, f2, f3, f4);
        zm.a(class_2872, matrix4f, f5, f6, f7, f5, f6, f10, f8, f6, f10, f, f2, f3, f4);
        zm.a(class_2872, matrix4f, f5, f6, f7, f8, f6, f10, f8, f6, f7, f, f2, f3, f4);
        za.a(class_2872);
    }

    public static void c(MatrixStack class_45872, double d, double d2, double d3, float f, float f2, Color color) {
        float f3 = f / 2.0f;
        Box HorizontalFacingBlock = new Box(d - (double)f3, d2, d3 - (double)f3, d + (double)f3, d2 + (double)f2, d3 + (double)f3);
        zm.c(class_45872, HorizontalFacingBlock, color);
    }

    public static void a(MatrixStack class_45872, Vec3d VanillaChestLootTableGenerator, Vec3d WallPlayerSkullBlock, Color color) {
        Matrix4f matrix4f = class_45872.peek().getPositionMatrix();
        BufferBuilder class_2872 = Tessellator.getInstance().begin(VertexFormat.DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
        float f = (float)color.getRed() / 255.0f;
        float f2 = (float)color.getGreen() / 255.0f;
        float f3 = (float)color.getBlue() / 255.0f;
        float f4 = (float)color.getAlpha() / 255.0f;
        zm.a(class_2872, matrix4f, (float)VanillaChestLootTableGenerator.x, (float)VanillaChestLootTableGenerator.y, (float)VanillaChestLootTableGenerator.z, (float)WallPlayerSkullBlock.x, (float)WallPlayerSkullBlock.y, (float)WallPlayerSkullBlock.z, f, f2, f3, f4);
        za.a(class_2872);
    }

    public static Vec3d a(Entity class_12972, float f) {
        return class_12972.getLerpedPos(f);
    }

    private static void a(BufferBuilder class_2872, Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        class_2872.vertex((Matrix4fc)matrix4f, f, f2, f3).color(f7, f8, f9, f10);
        class_2872.vertex((Matrix4fc)matrix4f, f4, f5, f6).color(f7, f8, f9, f10);
    }

    private static void a(BufferBuilder class_2872, Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        class_2872.vertex((Matrix4fc)matrix4f, f, f2, f3).color(f10, f11, f12, f13);
        class_2872.vertex((Matrix4fc)matrix4f, f4, f5, f6).color(f10, f11, f12, f13);
        class_2872.vertex((Matrix4fc)matrix4f, f7, f8, f9).color(f10, f11, f12, f13);
    }
}

