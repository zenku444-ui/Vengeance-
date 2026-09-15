/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gl.RenderPipelines
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  org.joml.Matrix3x2fStack
 */
package com.vengeance.vengeanceclient.utils.w.r;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2fStack;

public final class za {
    private static final MinecraftClient a = MinecraftClient.getInstance();
    private static final int b = 1;
    private static final Map<Integer, Identifier> c = new HashMap<Integer, Identifier>();
    private static DrawContext d = null;
    private static int e = 0;
    private static int f = 0;
    private static int g = 1;

    public static void a() {
    }

    public static void b() {
    }

    public static boolean a(DrawContext class_3322) {
        if (class_3322 == null) {
            return false;
        }
        d = class_3322;
        ++e;
        return true;
    }

    public static boolean c() {
        if (d == null) {
            return false;
        }
        ++e;
        return true;
    }

    public static boolean d() {
        return true;
    }

    public static void e() {
        if (e <= 0) {
            return;
        }
        if (--e == 0) {
            while (f > 0 && d != null) {
                d.disableScissor();
                --f;
            }
            d = null;
        }
    }

    public static boolean f() {
        return e > 0 && d != null;
    }

    public static void a(float f, float f2, float f3, float f4, Color color) {
        if (!za.o()) {
            return;
        }
        int n = Math.round(f);
        int n2 = Math.round(f2);
        int n3 = Math.round(f + f3);
        int n4 = Math.round(f2 + f4);
        if (n3 <= n || n4 <= n2) {
            return;
        }
        d.fill(n, n2, n3, n4, za.a(color));
    }

    public static void a(float f, float f2, float f3, float f4, float f5, Color color) {
        za.a(f, f2, f3, f4, color);
    }

    public static void a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, Color color) {
        za.a(f, f2, f3, f4, color);
    }

    public static void a(float f, float f2, float f3, float f4, float f5, float f6, Color color) {
        if (!za.o()) {
            return;
        }
        float f7 = Math.max(1.0f, f6);
        za.a(f, f2, f3, f7, color);
        za.a(f, f2 + f4 - f7, f3, f7, color);
        za.a(f, f2 + f7, f7, Math.max(0.0f, f4 - f7 * 2.0f), color);
        za.a(f + f3 - f7, f2 + f7, f7, Math.max(0.0f, f4 - f7 * 2.0f), color);
    }

    public static void a(float f, float f2, float f3, float f4, float f5, Color color, Color color2) {
        if (!za.o()) {
            return;
        }
        int n = Math.max(1, Math.round(f4 / 2.0f));
        float f6 = f4 / (float)n;
        for (int i = 0; i < n; ++i) {
            float f7 = (float)i / (float)Math.max(1, n - 1);
            za.a(f, f2 + (float)i * f6, f3, f6 + 1.0f, za.a(color, color2, f7));
        }
    }

    public static void a(float f, float f2, float f3, float f4, float f5, Color color, Color color2, float f6, float f7) {
        za.a(f - f7, f2 - f7, f3 + f7 * 2.0f, f4 + f7 * 2.0f, color2);
        za.a(f, f2, f3, f4, f5, color);
    }

    public static void a(float f, float f2, float f3, Color color) {
        if (!za.o()) {
            return;
        }
        int n = Math.round(f);
        int n2 = Math.round(f2);
        int n3 = Math.max(1, Math.round(f3));
        int n4 = za.a(color);
        for (int i = -n3; i <= n3; ++i) {
            int n5 = (int)Math.sqrt((double)n3 * (double)n3 - (double)i * (double)i);
            d.fill(n - n5, n2 + i, n + n5 + 1, n2 + i + 1, n4);
        }
    }

    public static void b(float f, float f2, float f3, float f4, float f5, Color color) {
        if (!za.o()) {
            return;
        }
        int n = Math.max(1, Math.round(Math.max(Math.abs(f3 - f), Math.abs(f4 - f2))));
        float f6 = Math.max(0.5f, f5 / 2.0f);
        for (int i = 0; i <= n; ++i) {
            float f7 = (float)i / (float)n;
            float f8 = f + (f3 - f) * f7;
            float f9 = f2 + (f4 - f2) * f7;
            za.a(f8, f9, f6, color);
        }
    }

    public static void a(String string, float f, float f2, float f3, Color color) {
        za.b(string, f, f2, f3, color, false);
    }

    public static void a(String string, float f, float f2, float f3, Color color, boolean bl) {
        za.b(string, f, f2, f3, color, false);
    }

    public static void a(String string, float f, float f2, float f3, Color color, int n) {
        za.b(string, f, f2, f3, color, false);
    }

    public static void b(String string, float f, float f2, float f3, Color color) {
        za.b(string, f, f2, f3, color, true);
    }

    public static void b(String string, float f, float f2, float f3, Color color, int n) {
        za.b(string, f, f2, f3, color, true);
    }

    public static void a(String string, float f, float f2, float f3, Color color, float f4, float f5, Color color2) {
        za.b(string, f + f4, f2 + f5, f3, color2, false);
        za.b(string, f, f2, f3, color, false);
    }

    public static void a(String string, float f, float f2, float f3, Color color, int n, float f4, float f5, Color color2) {
        za.a(string, f, f2, f3, color, f4, f5, color2);
    }

    public static void c(String string, float f, float f2, float f3, Color color) {
        za.b(string, f, f2, f3, color, false);
    }

    public static float a(String string, float f) {
        if (string == null || string.isEmpty() || f <= 0.0f) {
            return 0.0f;
        }
        return (float)za.a.textRenderer.getWidth(string) * (f / 9.0f);
    }

    public static float a(String string, float f, boolean bl) {
        return za.a(string, f);
    }

    public static float a(String string, float f, int n) {
        return za.a(string, f);
    }

    public static float a(float f) {
        return Math.max(0.0f, f);
    }

    public static int g() {
        return 1;
    }

    public static int h() {
        return 1;
    }

    public static int i() {
        return 1;
    }

    public static int j() {
        return 1;
    }

    public static int a(String string) {
        Identifier class_29602 = za.b(string);
        if (class_29602 == null) {
            return -1;
        }
        int n = g++;
        c.put(n, class_29602);
        return n;
    }

    public static void a(int n, float f, float f2, float f3, float f4, Color color) {
        if (!za.o()) {
            return;
        }
        Identifier class_29602 = c.get(n);
        if (class_29602 == null) {
            return;
        }
        int n2 = Math.max(1, Math.round(f3));
        int n3 = Math.max(1, Math.round(f4));
        d.drawTexture(RenderPipelines.GUI_TEXTURED, class_29602, Math.round(f), Math.round(f2), 0.0f, 0.0f, n2, n3, n2, n3);
    }

    public static int a(int n, int n2, int n3) {
        return -1;
    }

    public static void a(int n) {
        c.remove(n);
    }

    public static void a(int n, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Color color) {
        if (!za.o()) {
            return;
        }
        Identifier class_29602 = c.get(n);
        if (class_29602 == null) {
            return;
        }
        d.drawTexture(RenderPipelines.GUI_TEXTURED, class_29602, Math.round(f7), Math.round(f8), f, f2, Math.max(1, Math.round(f9)), Math.max(1, Math.round(f10)), Math.max(1, Math.round(f5)), Math.max(1, Math.round(f6)));
    }

    public static void k() {
        if (!za.o()) {
            return;
        }
        d.getMatrices().pushMatrix();
    }

    public static void l() {
        if (!za.o()) {
            return;
        }
        d.getMatrices().popMatrix();
    }

    public static void a(float f, float f2) {
        if (!za.o()) {
            return;
        }
        d.getMatrices().translate(f, f2);
    }

    public static void b(float f, float f2) {
        if (!za.o()) {
            return;
        }
        d.getMatrices().scale(f, f2);
    }

    public static void a(float f, float f2, float f3, float f4) {
        if (!za.o()) {
            return;
        }
        d.enableScissor(Math.round(f), Math.round(f2), Math.round(f + f3), Math.round(f2 + f4));
        ++za.f;
    }

    public static void m() {
        if (!za.o() || f <= 0) {
            return;
        }
        d.disableScissor();
        --f;
    }

    public static void n() {
        c.clear();
        d = null;
        e = 0;
        f = 0;
    }

    private static boolean o() {
        return e > 0 && d != null;
    }

    private static int a(Color color) {
        return (color.getAlpha() & 0xFF) << 24 | (color.getRed() & 0xFF) << 16 | (color.getGreen() & 0xFF) << 8 | color.getBlue() & 0xFF;
    }

    private static void b(String string, float f, float f2, float f3, Color color, boolean bl) {
        if (!za.o() || string == null || string.isEmpty()) {
            return;
        }
        float f4 = Math.max(0.01f, f3 / 9.0f);
        Matrix3x2fStack matrix3x2fStack = d.getMatrices();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.translate(f, f2);
        matrix3x2fStack.scale(f4, f4);
        d.drawText(za.a.textRenderer, string, 0, 0, za.a(color), bl);
        matrix3x2fStack.popMatrix();
    }

    private static Identifier b(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }
        String string2 = string.trim();
        try {
            if (string2.startsWith("assets/")) {
                String string3 = string2.substring("assets/".length());
                int n = string3.indexOf(47);
                if (n <= 0 || n + 1 >= string3.length()) {
                    return null;
                }
                String string4 = string3.substring(0, n);
                String string5 = string3.substring(n + 1);
                return Identifier.of((String)string4, (String)string5);
            }
            if (string2.contains(":")) {
                return Identifier.of((String)string2);
            }
            return Identifier.of((String)"vengeance-client", (String)string2);
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static Color a(Color color, Color color2, float f) {
        float f2 = Math.max(0.0f, Math.min(1.0f, f));
        int n = Math.round((float)color.getRed() + (float)(color2.getRed() - color.getRed()) * f2);
        int n2 = Math.round((float)color.getGreen() + (float)(color2.getGreen() - color.getGreen()) * f2);
        int n3 = Math.round((float)color.getBlue() + (float)(color2.getBlue() - color.getBlue()) * f2);
        int n4 = Math.round((float)color.getAlpha() + (float)(color2.getAlpha() - color.getAlpha()) * f2);
        return new Color(n, n2, n3, n4);
    }

    private za() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

