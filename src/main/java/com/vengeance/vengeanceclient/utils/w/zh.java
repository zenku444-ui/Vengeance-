/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.util.math.MatrixStack
 */
package com.vengeance.vengeanceclient.utils.w;

import com.vengeance.vengeanceclient.r.q.p.zb;
import com.vengeance.vengeanceclient.utils.w.zg;
import java.awt.Color;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;

public class zh {
    public static void a(DrawContext class_3322, float f, float f2, float f3, float f4, float f5) {
        if (!zb.z()) {
            return;
        }
        MatrixStack class_45872 = new MatrixStack();
        Color color = zb.aa();
        float f6 = zb.ab();
        float f7 = zb.ac();
        float f8 = zb.ad();
        zg.a(class_45872, f, f2, f3, f4, f5, color, f6, f7, f8);
    }

    public static void a(DrawContext class_3322, float f, float f2, float f3, float f4, float f5, Color color) {
        if (!zb.z()) {
            return;
        }
        MatrixStack class_45872 = new MatrixStack();
        float f6 = zb.ab();
        float f7 = zb.ac();
        float f8 = zb.ad();
        zg.a(class_45872, f, f2, f3, f4, f5, color, f6, f7, f8);
    }

    public static void a(DrawContext class_3322, float f, float f2, float f3, float f4, float f5, Color color, float f6, float f7, float f8) {
        MatrixStack class_45872 = new MatrixStack();
        zg.a(class_45872, f, f2, f3, f4, f5, color, f6, f7, f8);
    }

    public static void b(DrawContext class_3322, float f, float f2, float f3, float f4, float f5) {
        if (!zb.z()) {
            return;
        }
        MatrixStack class_45872 = new MatrixStack();
        Color color = zb.aa();
        double d = (double)System.currentTimeMillis() / 1000.0;
        zg.a(class_45872, f, f2, f3, f4, f5, color, d);
    }

    public static void c(DrawContext class_3322, float f, float f2, float f3, float f4, float f5) {
        if (!zb.z()) {
            return;
        }
        MatrixStack class_45872 = new MatrixStack();
        Color color = zb.aa();
        zg.b(class_45872, f, f2, f3, f4, f5, color);
    }

    public static void b(DrawContext class_3322, float f, float f2, float f3, float f4, float f5, Color color) {
        MatrixStack class_45872 = new MatrixStack();
        zg.a(class_45872, f, f2, f3, f4, f5, color, 0.5f, 6.0f, 10.0f);
    }

    public static void a(DrawContext class_3322, float f, float f2, float f3, float f4) {
        zh.a(class_3322, f, f2, f3, f4, 8.0f);
    }

    public static void a(DrawContext class_3322, float f, float f2, float f3, float f4, boolean bl) {
        if (bl) {
            zh.a(class_3322, f, f2, f3, f4, 4.0f);
        } else {
            zh.b(class_3322, f, f2, f3, f4, 4.0f, zb.aa());
        }
    }
}

