/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 */
package com.vengeance.vengeanceclient.utils.w;

import com.vengeance.vengeanceclient.utils.w.zn;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public final class zi {
    private static final Map<String, za> a = new HashMap<String, za>();

    public static float a(String string2, float f, float f2, zc zc2) {
        za za2 = a.computeIfAbsent(string2, string -> new za(f, f2, zc2));
        za2.b = f;
        long l = System.currentTimeMillis();
        float f3 = (float)(l - za2.d) / 1000.0f;
        za2.d = l;
        if (Math.abs(za2.a - za2.b) > 0.01f) {
            float f4 = za2.b - za2.a;
            float f5 = f4 * za2.c * f3;
            f5 = zi.a(f5, za2.e);
            za2.a += f5;
            if (Math.abs(za2.a - za2.b) < 0.01f) {
                za2.a = za2.b;
            }
        }
        return za2.a;
    }

    private static float a(float f, zc zc2) {
        return switch (zc2.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> f;
            case 1 -> f * f;
            case 2 -> 1.0f - (1.0f - f) * (1.0f - f);
            case 3 -> {
                if (f < 0.5f) {
                    yield 2.0f * f * f;
                }
                yield 1.0f - 2.0f * (1.0f - f) * (1.0f - f);
            }
            case 4 -> zi.a(f);
            case 5 -> zi.b(f);
        };
    }

    private static float a(float f) {
        if (f < 0.36363637f) {
            return 7.5625f * f * f;
        }
        if (f < 0.72727275f) {
            return 7.5625f * (f -= 0.54545456f) * f + 0.75f;
        }
        if ((double)f < 0.9090909090909091) {
            return 7.5625f * (f -= 0.8181818f) * f + 0.9375f;
        }
        return 7.5625f * (f -= 0.95454544f) * f + 0.984375f;
    }

    private static float b(float f) {
        return (float)(Math.pow(2.0, -10.0f * f) * Math.sin(((double)f - 0.1) * (Math.PI * 2) / 0.4) + 1.0);
    }

    public static void a(DrawContext class_3322, int n, int n2, int n3, int n4, Color color, Color color2) {
        com.vengeance.vengeanceclient.utils.w.zd.a();
        class_3322.fillGradient(n, n2, n + n3, n2 + n4, color.getRGB(), color2.getRGB());
    }

    public static void a(DrawContext class_3322, int n, int n2, int n3, int n4, float f, Color color, Color color2) {
        f = Math.max(0.0f, Math.min(1.0f, f));
        zn.b(class_3322, n, n2, n3, n4, n4 / 2, color.getRGB());
        if (f > 0.0f) {
            int n5 = (int)((float)n3 * f);
            zn.b(class_3322, n, n2, n5, n4, n4 / 2, color2.getRGB());
        }
        Color color3 = new Color(255, 255, 255, 30);
        zn.b(class_3322, n, n2, n3, 1, n4 / 2, color3.getRGB());
    }

    public static void a(DrawContext class_3322, int n, int n2, int n3, int n4, String string, boolean bl, boolean bl2) {
        Color color = bl2 ? zb.b : (bl ? zb.b : zb.a);
        zn.b(class_3322, n, n2, n3, n4, 6, color.getRGB());
        Color color2 = bl ? zb.c : zb.k;
        zi.a(class_3322, n, n2, n3, n4, 6, 1, color2);
        zi.b(class_3322, string, n + n3 / 2, n2 + n4 / 2, zb.h);
    }

    public static void a(DrawContext class_3322, int n, int n2, int n3, int n4, float f, boolean bl) {
        int n5;
        f = Math.max(0.0f, Math.min(1.0f, f));
        Color color = new Color(40, 40, 40);
        zn.b(class_3322, n, n2 + n4 / 4, n3, n4 / 2, n4 / 4, color.getRGB());
        if (f > 0.0f) {
            n5 = (int)((float)n3 * f);
            zn.b(class_3322, n, n2 + n4 / 4, n5, n4 / 2, n4 / 4, zb.g.getRGB());
        }
        n5 = n + (int)((float)n3 * f) - n4 / 2;
        n5 = Math.max(n, Math.min(n + n3 - n4, n5));
        Color color2 = bl ? zb.g.brighter() : zb.g;
        Color color3 = new Color(0, 0, 0, 60);
        zn.b(class_3322, n5 + 1, n2 + 1, n4, n4, n4 / 2, color3.getRGB());
        zn.b(class_3322, n5, n2, n4, n4, n4 / 2, color2.getRGB());
    }

    public static void a(DrawContext class_3322, int n, int n2, int n3, boolean bl, boolean bl2) {
        Color color = bl ? zb.g : zb.a;
        Color color2 = bl2 ? zb.g : zb.k;
        zn.b(class_3322, n, n2, n3, n3, 3, color.getRGB());
        zi.a(class_3322, n, n2, n3, n3, 3, 1, color2);
        if (bl) {
            zi.a(class_3322, n + 2, n2 + 2, n3 - 4, zb.h);
        }
    }

    public static void a(DrawContext class_3322, int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
        Color color;
        Color color2 = color = bl ? zb.g : zb.a;
        Color color3 = bl2 ? zb.g.brighter() : (bl ? zb.g : zb.k);
        zn.b(class_3322, n, n2, n3, n4, n4 / 2, color.getRGB());
        zi.a(class_3322, n, n2, n3, n4, n4 / 2, 1, color3);
        int n5 = n4 - 4;
        int n6 = bl ? n + n3 - n5 - 2 : n + 2;
        Color color4 = zb.h;
        zn.b(class_3322, n6, n2 + 2, n5, n5, n5 / 2, color4.getRGB());
    }

    public static void b(DrawContext class_3322, int n, int n2, int n3, int n4, String string, boolean bl, boolean bl2) {
        Color color = bl2 ? zb.b : zb.a;
        zn.b(class_3322, n, n2, n3, n4, 4, color.getRGB());
        zi.a(class_3322, string, n + 8, n2 + n4 / 2 - 4, zb.h);
        zi.a(class_3322, n + n3 - 16, n2 + n4 / 2 - 3, 6, bl, zb.i);
    }

    public static void a(DrawContext class_3322, int n, int n2, String string) {
        int n3 = 6;
        int n4 = zi.a(string);
        int n5 = zi.a();
        int n6 = n4 + n3 * 2;
        int n7 = n5 + n3 * 2;
        Color color = new Color(0, 0, 0, 100);
        zn.b(class_3322, n + 2, n2 + 2, n6, n7, 4, color.getRGB());
        Color color2 = new Color(25, 25, 25, 240);
        zn.b(class_3322, n, n2, n6, n7, 4, color2.getRGB());
        zi.a(class_3322, string, n + n3, n2 + n3, zb.h);
    }

    public static void a(DrawContext class_3322, int n, int n2, int n3, String string, String string2, ze ze2, float f) {
        Color color = zi.a(ze2);
        zn.b(class_3322, n, n2, n3, 60, 8, zb.a.getRGB());
        zn.b(class_3322, n, n2, 4, 60, 2, color.getRGB());
        if (f > 0.0f) {
            int n4 = (int)((float)n3 * f);
            Color color2 = new Color(color.getRed(), color.getGreen(), color.getBlue(), 60);
            zn.b(class_3322, n, n2 + 56, n4, 4, 2, color2.getRGB());
        }
        zi.a(class_3322, n + 12, n2 + 12, ze2);
        zi.a(class_3322, string, n + 40, n2 + 12, zb.h);
        zi.a(class_3322, string2, n + 40, n2 + 32, zb.i);
    }

    private static Color a(ze ze2) {
        switch (ze2.ordinal()) {
            case 1: {
                return zb.m;
            }
            case 2: {
                return zb.n;
            }
            case 3: {
                return zb.o;
            }
        }
        return zb.p;
    }

    public static void a(DrawContext class_3322, int n, int n2, int n3, int n4, int n5, int n6, Color color) {
        zn.b(class_3322, n, n2, n3, n6, n5, color.getRGB());
        zn.b(class_3322, n, n2 + n4 - n6, n3, n6, n5, color.getRGB());
        zn.b(class_3322, n, n2, n6, n4, n5, color.getRGB());
        zn.b(class_3322, n + n3 - n6, n2, n6, n4, n5, color.getRGB());
    }

    public static void a(DrawContext class_3322, String string, int n, int n2, Color color) {
        class_3322.drawText(MinecraftClient.getInstance().textRenderer, string, n, n2, color.getRGB(), false);
    }

    public static void b(DrawContext class_3322, String string, int n, int n2, Color color) {
        int n3 = zi.a(string);
        int n4 = zi.a();
        zi.a(class_3322, string, n - n3 / 2, n2 - n4 / 2, color);
    }

    public static void a(DrawContext class_3322, int n, int n2, int n3, Color color) {
        int n4 = n + n3 / 2;
        int n5 = n2 + n3 / 2;
        class_3322.fill(n4 - 2, n5, n4, n5 + 2, color.getRGB());
        class_3322.fill(n4, n5 + 2, n4 + 4, n5 - 2, color.getRGB());
    }

    public static void a(DrawContext class_3322, int n, int n2, int n3, boolean bl, Color color) {
        int n4 = n + n3 / 2;
        int n5 = n2 + n3 / 2;
        if (bl) {
            for (int i = 0; i < n3 / 2; ++i) {
                class_3322.fill(n4 - i, n5 - n3 / 4 + i, n4 + i + 1, n5 - n3 / 4 + i + 1, color.getRGB());
            }
        } else {
            for (int i = 0; i < n3 / 2; ++i) {
                class_3322.fill(n4 - i, n5 + n3 / 4 - i, n4 + i + 1, n5 + n3 / 4 - i + 1, color.getRGB());
            }
        }
    }

    public static void a(DrawContext class_3322, int n, int n2, ze ze2) {
        Color color = zi.a(ze2);
        switch (ze2.ordinal()) {
            case 0: {
                zn.a(class_3322, n + 8, n2 + 8, 8, color.getRGB());
                zi.a(class_3322, "i", n + 6, n2 + 4, zb.h);
                break;
            }
            case 1: {
                zn.a(class_3322, n + 8, n2 + 8, 8, color.getRGB());
                zi.a(class_3322, n + 4, n2 + 4, 8, zb.h);
                break;
            }
            case 2: {
                zi.a(class_3322, "!", n + 6, n2 + 2, color);
                break;
            }
            case 3: {
                zi.a(class_3322, "X", n + 4, n2 + 4, color);
            }
        }
    }

    public static int a(String string) {
        return MinecraftClient.getInstance().textRenderer.getWidth(string);
    }

    public static int a() {
        Objects.requireNonNull(MinecraftClient.getInstance().textRenderer);
        return 9;
    }

    public static Color a(Color color, Color color2, float f) {
        f = Math.max(0.0f, Math.min(1.0f, f));
        int n = (int)((float)color.getRed() + (float)(color2.getRed() - color.getRed()) * f);
        int n2 = (int)((float)color.getGreen() + (float)(color2.getGreen() - color.getGreen()) * f);
        int n3 = (int)((float)color.getBlue() + (float)(color2.getBlue() - color.getBlue()) * f);
        int n4 = (int)((float)color.getAlpha() + (float)(color2.getAlpha() - color.getAlpha()) * f);
        return new Color(n, n2, n3, n4);
    }

    public static Color a(Color color, int n) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), Math.max(0, Math.min(255, n)));
    }

    public static Color a(float f, float f2, float f3) {
        float f4 = ((float)System.currentTimeMillis() * 0.001f + f) % 1.0f;
        return Color.getHSBColor(f4, f2, f3);
    }

    public static void b() {
        long l = System.currentTimeMillis();
        a.entrySet().removeIf(entry -> {
            za za2 = (za)entry.getValue();
            return l - za2.d > 5000L && Math.abs(za2.a - za2.b) < 0.01f;
        });
    }

    public enum zc { a, b, c, d, e, f }

    private static class za {
        float a;
        float b;
        float c;
        long d;
        zc e;

        za(float f, float f2, zc zc2) {
            this.a = f;
            this.b = f;
            this.c = f2;
            this.d = System.currentTimeMillis();
            this.e = zc2;
        }
    }

    public static class zb {
        public static final Color a = new Color(15, 15, 15, 180);
        public static final Color b = new Color(25, 25, 25, 200);
        public static final Color c = new Color(150, 64, 255);
        public static final Color d = new Color(76, 175, 80);
        public static final Color e = new Color(244, 67, 54);
        public static final Color f = new Color(255, 152, 0);
        public static final Color g = new Color(156, 39, 176);
        public static final Color h = new Color(255, 255, 255);
        public static final Color i = new Color(180, 180, 180);
        public static final Color j = new Color(120, 120, 120);
        public static final Color k = new Color(60, 60, 60);
        public static final Color l = new Color(30, 30, 30);
        public static final Color m = new Color(76, 175, 80);
        public static final Color n = new Color(255, 193, 7);
        public static final Color o = new Color(244, 67, 54);
        public static final Color p = new Color(33, 150, 243);
    }

    public enum ze { a, b, c, d }

    public static class zd {
        public static void a(DrawContext class_3322, int n, int n2, int n3, int n4, int n5, int n6, Color color) {
            int n7;
            int n8;
            for (n8 = 0; n8 <= n3 / n5; ++n8) {
                n7 = n + n8 * n5;
                class_3322.fill(n7, n2, n7 + 1, n2 + n4, color.getRGB());
            }
            for (n8 = 0; n8 <= n4 / n6; ++n8) {
                n7 = n2 + n8 * n6;
                class_3322.fill(n, n7, n + n3, n7 + 1, color.getRGB());
            }
        }

        public static void a(DrawContext class_3322, int n, int n2, int n3, int n4, String string, boolean bl, boolean bl2) {
            Color color = zb.a;
            Color color2 = zb.b;
            int n5 = 24;
            zn.b(class_3322, n, n2, n3, n5, 6, color2.getRGB());
            zi.a(class_3322, string, n + 8, n2 + 8, zb.h);
            if (bl) {
                zi.a(class_3322, n + n3 - 20, n2 + 8, 8, bl2, zb.i);
            }
            if (!bl2) {
                zn.b(class_3322, n, n2 + n5, n3, n4 - n5, 6, color.getRGB());
                zi.a(class_3322, n, n2, n3, n4, 6, 1, zb.k);
            }
        }
    }
}

