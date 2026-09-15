/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.util.math.MatrixStack
 *  org.joml.Matrix4f
 */
package com.vengeance.vengeanceclient.utils.w.s;

import com.vengeance.vengeanceclient.utils.w.s.r.za;
import com.vengeance.vengeanceclient.utils.w.s.r.zc;
import com.vengeance.vengeanceclient.utils.w.s.zb;
import java.awt.Color;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix4f;

public class ze {
    public static void a(MatrixStack class_45872, float f, float f2, float f3, float f4, float f5, Color color) {
        Matrix4f matrix4f = class_45872.peek().getPositionMatrix();
        com.vengeance.vengeanceclient.utils.w.s.q.zb zb2 = (com.vengeance.vengeanceclient.utils.w.s.q.zb)zb.a().a(new zc(f3, f4)).a(new com.vengeance.vengeanceclient.utils.w.s.r.zb(f5)).a(new za(color)).a(1.0f).a();
        zb2.a(matrix4f, f, f2, 0.0f);
    }

    public static void a(MatrixStack class_45872, float f, float f2, float f3, float f4, float[] fArray, Color color) {
        Matrix4f matrix4f = class_45872.peek().getPositionMatrix();
        com.vengeance.vengeanceclient.utils.w.s.q.zb zb2 = (com.vengeance.vengeanceclient.utils.w.s.q.zb)zb.a().a(new zc(f3, f4)).a(new com.vengeance.vengeanceclient.utils.w.s.r.zb(fArray[0], fArray[1], fArray[2], fArray[3])).a(new za(color)).a(1.0f).a();
        zb2.a(matrix4f, f, f2, 0.0f);
    }

    public static void a(MatrixStack class_45872, float f, float f2, float f3, float f4, float f5, Color color, float f6) {
        Matrix4f matrix4f = class_45872.peek().getPositionMatrix();
        com.vengeance.vengeanceclient.utils.w.s.q.za za2 = (com.vengeance.vengeanceclient.utils.w.s.q.za)zb.b().a(new zc(f3, f4)).a(new com.vengeance.vengeanceclient.utils.w.s.r.zb(f5)).a(new za(color)).a(f6).b(1.0f).a();
        za2.a(matrix4f, f, f2, 0.0f);
    }

    public static void a(MatrixStack class_45872, float f, float f2, float f3, float f4, float[] fArray, Color color, float f5) {
        Matrix4f matrix4f = class_45872.peek().getPositionMatrix();
        com.vengeance.vengeanceclient.utils.w.s.q.za za2 = (com.vengeance.vengeanceclient.utils.w.s.q.za)zb.b().a(new zc(f3, f4)).a(new com.vengeance.vengeanceclient.utils.w.s.r.zb(fArray[0], fArray[1], fArray[2], fArray[3])).a(new za(color)).a(f5).b(1.0f).a();
        za2.a(matrix4f, f, f2, 0.0f);
    }

    public static void a(MatrixStack class_45872, float f, float f2, float f3, float f4, float f5, Color color, Color color2) {
        Matrix4f matrix4f = class_45872.peek().getPositionMatrix();
        com.vengeance.vengeanceclient.utils.w.s.q.zb zb2 = (com.vengeance.vengeanceclient.utils.w.s.q.zb)zb.a().a(new zc(f3, f4)).a(new com.vengeance.vengeanceclient.utils.w.s.r.zb(f5)).a(new za(color, color2, color2, color)).a(1.0f).a();
        zb2.a(matrix4f, f, f2, 0.0f);
    }
}

