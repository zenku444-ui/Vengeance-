/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.opengl.GlStateManager
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.util.math.MatrixStack
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.opengl.GL30
 */
package com.vengeance.vengeanceclient.utils.w;

import com.mojang.blaze3d.opengl.GlStateManager;
import com.vengeance.vengeanceclient.utils.w.zp;
import java.awt.Color;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public class zo {
    private static final String a = "rounded_rect";
    private static int b = -1;
    private static int c = -1;
    private static boolean d = false;
    private static final float[] e = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f};
    private static final int[] f = new int[]{0, 1, 2, 2, 3, 0};

    public static void a() {
        if (d) {
            return;
        }
        zp.a(a, "shaders/gui/roundedrect.vsh", "shaders/gui/roundedrect.fsh");
        b = GL30.glGenVertexArrays();
        c = GL20.glGenBuffers();
        int n = GL20.glGenBuffers();
        GL30.glBindVertexArray((int)b);
        GL20.glBindBuffer((int)34962, (int)c);
        GL20.glBufferData((int)34962, (float[])e, (int)35044);
        GL20.glBindBuffer((int)34963, (int)n);
        GL20.glBufferData((int)34963, (int[])f, (int)35044);
        GL20.glVertexAttribPointer((int)0, (int)2, (int)5126, (boolean)false, (int)8, (long)0L);
        GL20.glEnableVertexAttribArray((int)0);
        GL30.glBindVertexArray((int)0);
        d = true;
    }

    public static void a(MatrixStack class_45872, float f, float f2, float f3, float f4, float f5, Color color) {
        zo.a(class_45872, f, f2, f3, f4, f5, (float)color.getRed() / 255.0f, (float)color.getGreen() / 255.0f, (float)color.getBlue() / 255.0f, (float)color.getAlpha() / 255.0f);
    }

    public static void a(MatrixStack class_45872, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        if (!d) {
            zo.a();
        }
        MinecraftClient class_3102 = MinecraftClient.getInstance();
        int n = class_3102.getWindow().getScaledWidth();
        int n2 = class_3102.getWindow().getScaledHeight();
        GlStateManager._enableBlend();
        GlStateManager._blendFuncSeparate((int)770, (int)771, (int)1, (int)771);
        GlStateManager._disableDepthTest();
        GlStateManager._disableCull();
        zp.a(a);
        zp.a(a, "u_resolution", n, n2);
        zp.a(a, "u_position", f, f2);
        zp.a(a, "u_size", f3, f4);
        zp.a(a, "u_radius", f5);
        zp.a(a, "u_color", f6, f7, f8, f9);
        GL30.glBindVertexArray((int)b);
        GL20.glDrawElements((int)4, (int)6, (int)5125, (long)0L);
        GL30.glBindVertexArray((int)0);
        zp.a();
        GlStateManager._enableDepthTest();
        GlStateManager._enableCull();
        GlStateManager._disableBlend();
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
        d = false;
    }
}

