/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.opengl.GlStateManager
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.util.math.MatrixStack
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.opengl.GL30
 */
package com.vengeance.vengeanceclient.utils.w;

import com.mojang.blaze3d.opengl.GlStateManager;
import com.vengeance.vengeanceclient.utils.w.zp;
import java.awt.Color;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public class zg {
    private static final String a = "glow";
    private static int b = -1;
    private static int c = -1;
    private static int d = -1;
    private static boolean e = false;
    private static final float[] f = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f};
    private static final int[] g = new int[]{0, 1, 2, 2, 3, 0};

    public static void a() {
        if (e) {
            return;
        }
        int n = zp.a(a, "shaders/post/glow.vsh", "shaders/post/glow.fsh");
        if (n == 0) {
            System.err.println("Failed to load glow shader program");
            return;
        }
        b = GL30.glGenVertexArrays();
        c = GL20.glGenBuffers();
        d = GL20.glGenBuffers();
        GL30.glBindVertexArray((int)b);
        GL20.glBindBuffer((int)34962, (int)c);
        GL20.glBufferData((int)34962, (float[])f, (int)35044);
        GL20.glBindBuffer((int)34963, (int)d);
        GL20.glBufferData((int)34963, (int[])g, (int)35044);
        GL20.glVertexAttribPointer((int)0, (int)2, (int)5126, (boolean)false, (int)8, (long)0L);
        GL20.glEnableVertexAttribArray((int)0);
        GL20.glBindBuffer((int)34962, (int)0);
        GL30.glBindVertexArray((int)0);
        e = true;
    }

    public static void a(MatrixStack class_45872, float f, float f2, float f3, float f4, float f5, Color color) {
        zg.a(class_45872, f, f2, f3, f4, f5, color, 1.0f, 10.0f, 15.0f);
    }

    public static void a(MatrixStack class_45872, float f, float f2, float f3, float f4, float f5, Color color, float f6) {
        zg.a(class_45872, f, f2, f3, f4, f5, color, f6, 10.0f, 15.0f);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void a(MatrixStack class_45872, float f, float f2, float f3, float f4, float f5, Color color, float f6, float f7, float f8) {
        Integer n;
        if (!e) {
            zg.a();
        }
        if ((n = zp.b(a)) == null || n == 0) {
            return;
        }
        if (b == -1 || c == -1) {
            return;
        }
        MinecraftClient class_3102 = MinecraftClient.getInstance();
        int n2 = class_3102.getWindow().getScaledWidth();
        int n3 = class_3102.getWindow().getScaledHeight();
        int[] nArray = new int[1];
        GL11.glGetIntegerv((int)34229, (int[])nArray);
        int[] nArray2 = new int[1];
        GL11.glGetIntegerv((int)35725, (int[])nArray2);
        boolean bl = GL11.glIsEnabled((int)3042);
        boolean bl2 = GL11.glIsEnabled((int)2929);
        boolean bl3 = GL11.glIsEnabled((int)2884);
        try {
            GlStateManager._enableBlend();
            GlStateManager._blendFuncSeparate((int)770, (int)771, (int)1, (int)771);
            GlStateManager._disableDepthTest();
            GlStateManager._depthMask((boolean)false);
            GlStateManager._disableCull();
            GL30.glBindVertexArray((int)b);
            zp.a(a);
            zp.a(a, "u_resolution", n2, n3);
            zp.a(a, "u_position", f, f2);
            zp.a(a, "u_size", f3, f4);
            zp.a(a, "u_radius", f5);
            zp.a(a, "u_color", (float)color.getRed() / 255.0f, (float)color.getGreen() / 255.0f, (float)color.getBlue() / 255.0f, (float)color.getAlpha() / 255.0f);
            zp.a(a, "u_glowIntensity", f6);
            zp.a(a, "u_glowThickness", f7);
            zp.a(a, "u_bloomRadius", f8);
            GL20.glDrawElements((int)4, (int)6, (int)5125, (long)0L);
        }
        finally {
            GL30.glBindVertexArray((int)nArray[0]);
            GL20.glUseProgram((int)nArray2[0]);
            GlStateManager._depthMask((boolean)true);
            if (bl2) {
                GlStateManager._enableDepthTest();
            } else {
                GlStateManager._disableDepthTest();
            }
            if (bl3) {
                GlStateManager._enableCull();
            } else {
                GlStateManager._disableCull();
            }
            GlStateManager._blendFuncSeparate((int)770, (int)771, (int)1, (int)771);
            if (!bl) {
                GlStateManager._disableBlend();
            }
        }
    }

    public static void a(MatrixStack class_45872, float f, float f2, float f3, float f4, float f5, Color color, double d) {
        float f6 = (float)((double)0.7f + (double)0.3f * Math.sin(d * 2.0));
        zg.a(class_45872, f, f2, f3, f4, f5, color, f6, 10.0f, 15.0f);
    }

    public static void b(MatrixStack class_45872, float f, float f2, float f3, float f4, float f5, Color color) {
        zg.a(class_45872, f, f2, f3, f4, f5, color, 0.8f, 8.0f, 12.0f);
        zg.a(class_45872, f, f2, f3, f4, f5, color, 0.6f, 12.0f, 20.0f);
        zg.a(class_45872, f, f2, f3, f4, f5, color, 0.4f, 16.0f, 28.0f);
    }

    public static void b() {
        if (b != -1) {
            GL30.glDeleteVertexArrays((int)b);
            b = -1;
        }
        if (c != -1) {
            GL20.glDeleteBuffers((int)c);
            c = -1;
        }
        if (d != -1) {
            GL20.glDeleteBuffers((int)d);
            d = -1;
        }
        e = false;
    }
}

