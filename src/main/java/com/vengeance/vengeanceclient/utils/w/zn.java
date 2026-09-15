/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.VertexFormat$DrawMode
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.client.render.BufferBuilder
 *  net.minecraft.client.render.Tessellator
 *  net.minecraft.client.render.VertexFormats
 *  net.minecraft.client.font.TextRenderer
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.util.math.MatrixStack
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 */
package com.vengeance.vengeanceclient.utils.w;

import com.mojang.blaze3d.vertex.VertexFormat;
import com.vengeance.vengeanceclient.utils.w.q.p.za;
import java.awt.Color;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;

public final class zn {
    public static boolean a = true;

    public static void a() {
        a = false;
    }

    public static void b() {
        a = true;
    }

    public static void a(MatrixStack class_45872, Box HorizontalFacingBlock, Color color) {
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
        class_2872.vertex((Matrix4fc)matrix4f, f5, f6, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f6, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f6, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f6, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f6, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f6, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f6, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f6, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f9, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f9, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f9, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f9, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f9, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f9, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f9, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f9, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f6, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f9, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f6, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f9, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f6, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f9, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f6, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f9, f10).color(f, f2, f3, f4);
        com.vengeance.vengeanceclient.utils.w.q.q.za.a(class_2872);
    }

    public static void b(MatrixStack class_45872, Box HorizontalFacingBlock, Color color) {
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
        class_2872.vertex((Matrix4fc)matrix4f, f5, f6, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f6, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f9, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f6, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f9, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f9, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f6, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f6, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f9, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f6, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f9, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f9, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f6, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f6, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f9, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f6, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f9, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f9, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f6, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f6, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f9, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f6, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f9, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f9, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f9, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f9, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f9, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f9, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f9, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f9, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f6, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f6, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f6, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f5, f6, f7).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f6, f10).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, f8, f6, f7).color(f, f2, f3, f4);
        com.vengeance.vengeanceclient.utils.w.q.q.za.a(class_2872);
    }

    public static void a(MatrixStack class_45872, Vec3d VanillaChestLootTableGenerator, Vec3d WallPlayerSkullBlock, Color color) {
        Matrix4f matrix4f = class_45872.peek().getPositionMatrix();
        BufferBuilder class_2872 = Tessellator.getInstance().begin(VertexFormat.DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
        float f = (float)color.getRed() / 255.0f;
        float f2 = (float)color.getGreen() / 255.0f;
        float f3 = (float)color.getBlue() / 255.0f;
        float f4 = (float)color.getAlpha() / 255.0f;
        class_2872.vertex((Matrix4fc)matrix4f, (float)VanillaChestLootTableGenerator.x, (float)VanillaChestLootTableGenerator.y, (float)VanillaChestLootTableGenerator.z).color(f, f2, f3, f4);
        class_2872.vertex((Matrix4fc)matrix4f, (float)WallPlayerSkullBlock.x, (float)WallPlayerSkullBlock.y, (float)WallPlayerSkullBlock.z).color(f, f2, f3, f4);
        com.vengeance.vengeanceclient.utils.w.q.q.za.a(class_2872);
    }

    public static void a(DrawContext class_3322, int n, int n2, int n3, int n4, int n5, int n6) {
        class_3322.fill(n + n5, n2, n + n3 - n5, n2 + n4, n6);
        class_3322.fill(n, n2 + n5, n + n5, n2 + n4 - n5, n6);
        class_3322.fill(n + n3 - n5, n2 + n5, n + n3, n2 + n4 - n5, n6);
        zn.b(class_3322, n + n5, n2 + n5, n5, n6, 0);
        zn.b(class_3322, n + n3 - n5, n2 + n5, n5, n6, 1);
        zn.b(class_3322, n + n5, n2 + n4 - n5, n5, n6, 2);
        zn.b(class_3322, n + n3 - n5, n2 + n4 - n5, n5, n6, 3);
    }

    public static void a(DrawContext class_3322, int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        class_3322.fillGradient(n + n5, n2, n + n3 - n5, n2 + n4, n6, n7);
        class_3322.fillGradient(n, n2 + n5, n + n5, n2 + n4 - n5, n6, n7);
        class_3322.fillGradient(n + n3 - n5, n2 + n5, n + n3, n2 + n4 - n5, n6, n7);
        zn.d(class_3322, n + n5, n2 + n5, n5, n6, n7, 0);
        zn.d(class_3322, n + n3 - n5, n2 + n5, n5, n6, n7, 1);
        zn.d(class_3322, n + n5, n2 + n4 - n5, n5, n6, n7, 2);
        zn.d(class_3322, n + n3 - n5, n2 + n4 - n5, n5, n6, n7, 3);
    }

    private static void b(DrawContext class_3322, int n, int n2, int n3, int n4, int n5) {
        float f = n3;
        for (int i = 0; i < n3; ++i) {
            for (int j = 0; j < n3; ++j) {
                float f2 = (float)Math.sqrt(i * i + j * j);
                if (!(f2 <= f)) continue;
                int n6 = n;
                int n7 = n2;
                switch (n5) {
                    case 0: {
                        n6 = n - i;
                        n7 = n2 - j;
                        break;
                    }
                    case 1: {
                        n6 = n + i;
                        n7 = n2 - j;
                        break;
                    }
                    case 2: {
                        n6 = n - i;
                        n7 = n2 + j;
                        break;
                    }
                    case 3: {
                        n6 = n + i;
                        n7 = n2 + j;
                    }
                }
                float f3 = 1.0f;
                if (f2 > f - 1.0f) {
                    f3 = Math.max(0.0f, f - f2);
                }
                int n8 = n4 >> 24 & 0xFF;
                int n9 = (int)((float)n8 * f3);
                int n10 = n9 << 24 | n4 & 0xFFFFFF;
                class_3322.fill(n6, n7, n6 + 1, n7 + 1, n10);
            }
        }
    }

    public static void a(DrawContext class_3322, int n, int n2, int n3, int n4) {
        for (int i = -n3; i <= n3; ++i) {
            for (int j = -n3; j <= n3; ++j) {
                if (j * j + i * i > n3 * n3) continue;
                class_3322.fill(n + j, n2 + i, n + j + 1, n2 + i + 1, n4);
            }
        }
    }

    private static void d(DrawContext class_3322, int n, int n2, int n3, int n4, int n5, int n6) {
        float f = n3;
        for (int i = 0; i < n3; ++i) {
            for (int j = 0; j < n3; ++j) {
                float f2 = (float)Math.sqrt(i * i + j * j);
                if (!(f2 <= f)) continue;
                int n7 = n;
                int n8 = n2;
                switch (n6) {
                    case 0: {
                        n7 = n - i;
                        n8 = n2 - j;
                        break;
                    }
                    case 1: {
                        n7 = n + i;
                        n8 = n2 - j;
                        break;
                    }
                    case 2: {
                        n7 = n - i;
                        n8 = n2 + j;
                        break;
                    }
                    case 3: {
                        n7 = n + i;
                        n8 = n2 + j;
                    }
                }
                float f3 = (float)j / (float)n3;
                int n9 = zn.a(n4, n5, f3);
                float f4 = 1.0f;
                if (f2 > f - 1.0f) {
                    f4 = Math.max(0.0f, f - f2);
                }
                int n10 = n9 >> 24 & 0xFF;
                int n11 = (int)((float)n10 * f4);
                int n12 = n11 << 24 | n9 & 0xFFFFFF;
                class_3322.fill(n7, n8, n7 + 1, n8 + 1, n12);
            }
        }
    }

    private static int a(int n, int n2, float f) {
        int n3 = n >> 24 & 0xFF;
        int n4 = n >> 16 & 0xFF;
        int n5 = n >> 8 & 0xFF;
        int n6 = n & 0xFF;
        int n7 = n2 >> 24 & 0xFF;
        int n8 = n2 >> 16 & 0xFF;
        int n9 = n2 >> 8 & 0xFF;
        int n10 = n2 & 0xFF;
        int n11 = (int)((float)n3 + (float)(n7 - n3) * f);
        int n12 = (int)((float)n4 + (float)(n8 - n4) * f);
        int n13 = (int)((float)n5 + (float)(n9 - n5) * f);
        int n14 = (int)((float)n6 + (float)(n10 - n6) * f);
        return n11 << 24 | n12 << 16 | n13 << 8 | n14;
    }

    public static void b(DrawContext class_3322, int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        for (int i = 1; i <= n7; ++i) {
            int n8 = (int)((float)(n6 >> 24 & 0xFF) * (1.0f - (float)i / (float)n7) * 0.3f);
            int n9 = n8 << 24 | n6 & 0xFFFFFF;
            zn.a(class_3322, n - i, n2 - i, n3 + i * 2, n4 + i * 2, n5 + i, n9);
        }
    }

    public static void a(DrawContext class_3322, int n, int n2, int n3, int n4, int n5) {
        class_3322.fill(n, n2, n + n3, n2 + n4, n5);
        int n6 = n5 & 0xFFFFFF | (n5 >> 24 & 0xFF) / 2 << 24;
        class_3322.fill(n - 1, n2, n, n2 + n4, n6);
        class_3322.fill(n + n3, n2, n + n3 + 1, n2 + n4, n6);
        class_3322.fill(n, n2 - 1, n + n3, n2, n6);
        class_3322.fill(n, n2 + n4, n + n3, n2 + n4 + 1, n6);
    }

    public static void b(DrawContext class_3322, int n, int n2, int n3, int n4, int n5, int n6) {
        class_3322.fill(n + n5, n2, n + n3 - n5, n2 + n4, n6);
        class_3322.fill(n, n2 + n5, n + n5, n2 + n4 - n5, n6);
        class_3322.fill(n + n3 - n5, n2 + n5, n + n3, n2 + n4 - n5, n6);
        zn.c(class_3322, n + n5, n2 + n5, n5, n6, 0);
        zn.c(class_3322, n + n3 - n5, n2 + n5, n5, n6, 1);
        zn.c(class_3322, n + n5, n2 + n4 - n5, n5, n6, 2);
        zn.c(class_3322, n + n3 - n5, n2 + n4 - n5, n5, n6, 3);
    }

    private static void c(DrawContext class_3322, int n, int n2, int n3, int n4, int n5) {
        float f = n3;
        for (float f2 = 0.0f; f2 < (float)n3; f2 += 0.5f) {
            for (float f3 = 0.0f; f3 < (float)n3; f3 += 0.5f) {
                float f4 = (float)Math.sqrt(f2 * f2 + f3 * f3);
                if (!(f4 <= f)) continue;
                int n6 = n;
                int n7 = n2;
                switch (n5) {
                    case 0: {
                        n6 = n - (int)f2;
                        n7 = n2 - (int)f3;
                        break;
                    }
                    case 1: {
                        n6 = n + (int)f2;
                        n7 = n2 - (int)f3;
                        break;
                    }
                    case 2: {
                        n6 = n - (int)f2;
                        n7 = n2 + (int)f3;
                        break;
                    }
                    case 3: {
                        n6 = n + (int)f2;
                        n7 = n2 + (int)f3;
                    }
                }
                float f5 = zn.a(f2, f3, f);
                if (!(f5 > 0.0f)) continue;
                int n8 = n4 >> 24 & 0xFF;
                int n9 = (int)((float)n8 * f5);
                int n10 = n9 << 24 | n4 & 0xFFFFFF;
                class_3322.fill(n6, n7, n6 + 1, n7 + 1, n10);
            }
        }
    }

    private static float a(float f, float f2, float f3) {
        float f4 = (float)Math.sqrt(f * f + f2 * f2);
        if (f4 <= f3 - 1.0f) {
            return 1.0f;
        }
        if (f4 >= f3) {
            return 0.0f;
        }
        return Math.max(0.0f, f3 - f4);
    }

    public static void c(DrawContext class_3322, int n, int n2, int n3, int n4, int n5, int n6) {
        class_3322.fillGradient(n, n2, n + n3, n2 + n4, n5, n6);
    }

    public static void a(DrawContext class_3322, int n, int n2, int n3, int n4, int n5, float f) {
        Color color = new Color(n5, true);
        for (int i = 0; i < 4; ++i) {
            int n6 = 0;
            int n7 = 0;
            switch (i) {
                case 0: {
                    n6 = 3;
                    n7 = (int)((float)color.getAlpha() * f * 0.15f);
                    break;
                }
                case 1: {
                    n6 = 2;
                    n7 = (int)((float)color.getAlpha() * f * 0.3f);
                    break;
                }
                case 2: {
                    n6 = 1;
                    n7 = (int)((float)color.getAlpha() * f * 0.5f);
                    break;
                }
                case 3: {
                    n6 = 0;
                    n7 = color.getAlpha();
                }
            }
            int n8 = new Color(color.getRed(), color.getGreen(), color.getBlue(), n7).getRGB();
            class_3322.fill(n - n6, n2 - n6, n3 + n6, n4 + n6, n8);
        }
    }

    public static void a(DrawContext class_3322, TextRenderer PackResourceMetadata, String string, int n, int n2, int n3, float f) {
        Color color = new Color(n3, true);
        for (int i = 0; i < 4; ++i) {
            int n4 = 0;
            int n5 = 0;
            int n6 = 0;
            switch (i) {
                case 0: {
                    n4 = (int)((float)color.getAlpha() * f * 0.2f);
                    n5 = 1;
                    n6 = 1;
                    break;
                }
                case 1: {
                    n4 = (int)((float)color.getAlpha() * f * 0.3f);
                    n5 = 1;
                    n6 = 0;
                    break;
                }
                case 2: {
                    n4 = (int)((float)color.getAlpha() * f * 0.3f);
                    n5 = 0;
                    n6 = 1;
                    break;
                }
                case 3: {
                    n4 = color.getAlpha();
                    n5 = 0;
                    n6 = 0;
                }
            }
            int n7 = new Color(color.getRed(), color.getGreen(), color.getBlue(), n4).getRGB();
            class_3322.drawText(PackResourceMetadata, string, n + n5, n2 + n6, n7, false);
        }
    }

    public static void a(MatrixStack class_45872, za za2, String string, int n, int n2, int n3, float f) {
        Color color = new Color(n3, true);
        for (int i = 0; i < 4; ++i) {
            int n4 = 0;
            int n5 = 0;
            int n6 = 0;
            switch (i) {
                case 0: {
                    n4 = (int)((float)color.getAlpha() * f * 0.2f);
                    n5 = 1;
                    n6 = 1;
                    break;
                }
                case 1: {
                    n4 = (int)((float)color.getAlpha() * f * 0.3f);
                    n5 = 1;
                    n6 = 0;
                    break;
                }
                case 2: {
                    n4 = (int)((float)color.getAlpha() * f * 0.3f);
                    n5 = 0;
                    n6 = 1;
                    break;
                }
                case 3: {
                    n4 = color.getAlpha();
                    n5 = 0;
                    n6 = 0;
                }
            }
            int n7 = new Color(color.getRed(), color.getGreen(), color.getBlue(), n4).getRGB();
            za2.a(class_45872, string, n + n5, n2 + n6, new Color(n7, true));
        }
    }

    private zn() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

