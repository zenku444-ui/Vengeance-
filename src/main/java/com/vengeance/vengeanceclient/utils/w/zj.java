/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 */
package com.vengeance.vengeanceclient.utils.w;

import com.vengeance.vengeanceclient.utils.w.zi;
import com.vengeance.vengeanceclient.utils.w.zn;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.gui.DrawContext;

public final class zj {
    public static void a(DrawContext class_3322, int n, int n2, int n3, int n4, List<Float> list, Color color, Color color2, String string) {
        int n5;
        if (list.isEmpty()) {
            return;
        }
        zn.b(class_3322, n, n2, n3, n4, 6, zi.zb.a.getRGB());
        if (string != null && !string.isEmpty()) {
            zi.a(class_3322, string, n + 8, n2 + 4, zi.zb.h);
            n2 += 16;
            n4 -= 16;
        }
        if (list.size() == 1) {
            float f = list.get(0).floatValue();
            int n6 = n + n3 / 2;
            int n7 = n2 + n4 / 2;
            zn.a(class_3322, n6, n7, 4, color.getRGB());
            zi.b(class_3322, String.format("%.1f", Float.valueOf(f)), n6, n7 - 15, zi.zb.h);
            return;
        }
        float f = Collections.min(list).floatValue();
        float f2 = Collections.max(list).floatValue();
        float f3 = f2 - f;
        if (f3 == 0.0f) {
            f3 = 1.0f;
        }
        Color color3 = zi.a(zi.zb.k, 60);
        for (int i = 1; i < 5; ++i) {
            int n8 = n2 + n4 * i / 5;
            class_3322.fill(n + 4, n8, n + n3 - 4, n8 + 1, color3.getRGB());
        }
        int[] nArray = new int[list.size()];
        int[] nArray2 = new int[list.size()];
        for (n5 = 0; n5 < list.size(); ++n5) {
            nArray[n5] = n + 4 + n5 * (n3 - 8) / (list.size() - 1);
            nArray2[n5] = n2 + n4 - 4 - (int)((list.get(n5).floatValue() - f) / f3 * (float)(n4 - 8));
        }
        if (color2 != null) {
            for (n5 = 0; n5 < list.size() - 1; ++n5) {
                int n9 = nArray[n5];
                int n10 = nArray2[n5];
                int n11 = nArray[n5 + 1];
                int n12 = nArray2[n5 + 1];
                zj.a(class_3322, n9, n10, n11, n12, n2 + n4 - 4, color2);
            }
        }
        for (n5 = 0; n5 < list.size() - 1; ++n5) {
            zj.b(class_3322, nArray[n5], nArray2[n5], nArray[n5 + 1], nArray2[n5 + 1], 2, color);
        }
        for (n5 = 0; n5 < list.size(); ++n5) {
            zn.a(class_3322, nArray[n5], nArray2[n5], 3, color.getRGB());
        }
        zi.a(class_3322, String.format("%.1f", Float.valueOf(f2)), n + n3 - 30, n2 + 4, zi.zb.i);
        zi.a(class_3322, String.format("%.1f", Float.valueOf(f)), n + n3 - 30, n2 + n4 - 12, zi.zb.i);
    }

    public static void a(DrawContext class_3322, int n, int n2, int n3, int n4, List<Float> list, List<String> list2, Color color, String string) {
        float f;
        if (list.isEmpty()) {
            return;
        }
        zn.b(class_3322, n, n2, n3, n4, 6, zi.zb.a.getRGB());
        if (string != null && !string.isEmpty()) {
            zi.a(class_3322, string, n + 8, n2 + 4, zi.zb.h);
            n2 += 16;
            n4 -= 16;
        }
        if ((f = Collections.max(list).floatValue()) == 0.0f) {
            f = 1.0f;
        }
        int n5 = (n3 - 16) / list.size() - 4;
        int n6 = n + 8;
        for (int i = 0; i < list.size(); ++i) {
            float f2 = list.get(i).floatValue();
            int n7 = (int)(f2 / f * (float)(n4 - 24));
            int n8 = n6 + i * (n5 + 4);
            int n9 = n2 + n4 - 20 - n7;
            Color color2 = zi.a(color, color.brighter(), f2 / f);
            zn.b(class_3322, n8, n9, n5, n7, 3, color2.getRGB());
            zi.b(class_3322, String.format("%.0f", Float.valueOf(f2)), n8 + n5 / 2, n9 - 12, zi.zb.i);
            if (list2 == null || i >= list2.size()) continue;
            zi.b(class_3322, list2.get(i), n8 + n5 / 2, n2 + n4 - 12, zi.zb.i);
        }
    }

    public static void a(DrawContext class_3322, int n, int n2, int n3, float f, float f2, Color color, String string) {
        f = Math.max(0.0f, Math.min(f2, f));
        float f3 = f / f2;
        zn.a(class_3322, n, n2, n3, zi.zb.a.getRGB());
        zn.a(class_3322, n, n2, n3 - 6, zi.zb.b.getRGB());
        zj.a(class_3322, n, n2, n3 - 3, -90, -90 + (int)(270.0f * f3), 6, color);
        String string2 = String.format("%.0f", Float.valueOf(f));
        zi.b(class_3322, string2, n, n2 - 4, zi.zb.h);
        if (string != null && !string.isEmpty()) {
            zi.b(class_3322, string, n, n2 + 8, zi.zb.i);
        }
        String string3 = String.format("%.0f%%", Float.valueOf(f3 * 100.0f));
        zi.b(class_3322, string3, n, n2 + 20, zi.zb.i);
    }

    public static void a(DrawContext class_3322, int n, int n2, int n3, int n4, String string, float f, float f2, Color color) {
        zn.b(class_3322, n, n2, n3, n4, 4, zi.zb.a.getRGB());
        zi.a(class_3322, string, n + 6, n2 + 4, zi.zb.h);
        String string2 = String.format("%.0f/%.0f", Float.valueOf(f), Float.valueOf(f2));
        int n5 = zi.a(string2);
        zi.a(class_3322, string2, n + n3 - n5 - 6, n2 + 4, zi.zb.i);
        int n6 = n2 + 16;
        int n7 = n4 - 20;
        float f3 = Math.max(0.0f, Math.min(1.0f, f / f2));
        zn.b(class_3322, n + 6, n6, n3 - 12, n7, 2, zi.zb.l.getRGB());
        if (f3 > 0.0f) {
            int n8 = (int)((float)(n3 - 12) * f3);
            Color color2 = f3 < 0.25f ? zi.zb.o : (f3 < 0.5f ? zi.zb.n : color);
            zn.b(class_3322, n + 6, n6, n8, n7, 2, color2.getRGB());
        }
    }

    public static void a(DrawContext class_3322, int n, int n2, int n3, int n4, String string, List<zb> list) {
        zn.b(class_3322, n, n2, n3, n4, 6, zi.zb.a.getRGB());
        zi.a(class_3322, string, n + 8, n2 + 8, zi.zb.h);
        class_3322.fill(n + 8, n2 + 22, n + n3 - 8, n2 + 23, zi.zb.k.getRGB());
        int n5 = n2 + 30;
        for (zb zb2 : list) {
            zi.a(class_3322, zb2.a, n + 8, n5, zi.zb.i);
            int n6 = zi.a(zb2.b);
            zi.a(class_3322, zb2.b, n + n3 - n6 - 8, n5, zb2.c != null ? zb2.c : zi.zb.h);
            n5 += 14;
        }
    }

    public static void a(DrawContext class_3322, int n, int n2, int n3, List<zc> list, Color color) {
        zn.b(class_3322, n, n2, n3, n3, 6, color.getRGB());
        zi.a(class_3322, n, n2, n3, n3, 6, 1, zi.zb.k);
        int n4 = n + n3 / 2;
        int n5 = n2 + n3 / 2;
        class_3322.fill(n4 - 4, n5, n4 + 4, n5 + 1, zi.zb.h.getRGB());
        class_3322.fill(n4, n5 - 4, n4 + 1, n5 + 4, zi.zb.h.getRGB());
        for (zc zc2 : list) {
            int n6 = n4 + (int)(zc2.a * (float)n3 / 2.0f);
            int n7 = n5 + (int)(zc2.b * (float)n3 / 2.0f);
            if (n6 < n || n6 > n + n3 || n7 < n2 || n7 > n2 + n3) continue;
            zn.a(class_3322, n6, n7, zc2.d, zc2.c.getRGB());
        }
    }

    private static void a(DrawContext class_3322, int n, int n2, int n3, int n4, int n5, Color color) {
        int n6 = Math.abs(n3 - n);
        if (n6 == 0) {
            return;
        }
        for (int i = 0; i <= n6; ++i) {
            float f = (float)i / (float)n6;
            int n7 = n + (int)((float)(n3 - n) * f);
            int n8 = n2 + (int)((float)(n4 - n2) * f);
            class_3322.fill(n7, n8, n7 + 1, n5, color.getRGB());
        }
    }

    /*
     * Unable to fully structure code
     */
    private static void b(DrawContext var0, int var1_1, int var2_2, int var3_3, int var4_4, int var5_5, Color var6_6) {
        int var7_7 = Math.abs(var3_3 - var1_1);
        int var8_8 = Math.abs(var4_4 - var2_2);
        int var9_9 = var1_1 < var3_3 ? 1 : -1;
        int var10_10 = var2_2 < var4_4 ? 1 : -1;
        int var11_11 = var7_7 - var8_8;
        int var12_12 = var1_1;
        int var13_13 = var2_2;
        while (true) {
            for (int var14_14 = -var5_5 / 2; var14_14 <= var5_5 / 2; ++var14_14) {
                for (int var15_15 = -var5_5 / 2; var15_15 <= var5_5 / 2; ++var15_15) {
                    var0.fill(var12_12 + var14_14, var13_13 + var15_15, var12_12 + var14_14 + 1, var13_13 + var15_15 + 1, var6_6.getRGB());
                }
            }
            if (var12_12 == var3_3 && var13_13 == var4_4) break;
            int var14_14 = 2 * var11_11;
            if (var14_14 > -var8_8) {
                var11_11 -= var8_8;
                var12_12 += var9_9;
            }
            if (var14_14 >= var7_7) continue;
            var11_11 += var7_7;
            var13_13 += var10_10;
        }
    }

    private static void a(DrawContext class_3322, int n, int n2, int n3, int n4, int n5, int n6, Color color) {
        for (int i = n4; i <= n5; i += 2) {
            double d = Math.toRadians(i);
            int n7 = n + (int)((double)n3 * Math.cos(d));
            int n8 = n2 + (int)((double)n3 * Math.sin(d));
            for (int j = -n6 / 2; j <= n6 / 2; ++j) {
                for (int k = -n6 / 2; k <= n6 / 2; ++k) {
                    if (j * j + k * k > n6 / 2 * (n6 / 2)) continue;
                    class_3322.fill(n7 + j, n8 + k, n7 + j + 1, n8 + k + 1, color.getRGB());
                }
            }
        }
    }

    private zj() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public record zb(String a, String b, Color c) {
        public zb(String string, String string2) {
            this(string, string2, null);
        }

    }

    public record zc(float a, float b, Color c, int d, String e) {
    }

    public static class za {
        private final List<Float> a;
        private final int b;

        public za(int n) {
            this.b = n;
            this.a = new ArrayList<Float>();
        }

        public void a(float f) {
            this.a.add(Float.valueOf(f));
            if (this.a.size() > this.b) {
                this.a.remove(0);
            }
        }

        public List<Float> a() {
            return new ArrayList<Float>(this.a);
        }

        public float b() {
            if (this.a.isEmpty()) {
                return 0.0f;
            }
            return (float)this.a.stream().mapToDouble(Float::doubleValue).average().orElse(0.0);
        }

        public float c() {
            return this.a.isEmpty() ? 0.0f : Collections.max(this.a).floatValue();
        }

        public float d() {
            return this.a.isEmpty() ? 0.0f : Collections.min(this.a).floatValue();
        }

        public void e() {
            this.a.clear();
        }
    }
}

