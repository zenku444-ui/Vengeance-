/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.util.math.MatrixStack
 *  org.joml.Matrix3x2fStack
 *  org.joml.Matrix4f
 */
package com.vengeance.vengeanceclient.utils.w.p;

import com.vengeance.vengeanceclient.utils.w.p.za;
import com.vengeance.vengeanceclient.utils.w.p.zc;
import com.vengeance.vengeanceclient.utils.w.p.ze;
import java.awt.Color;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix3x2fStack;
import org.joml.Matrix4f;

public final class zb {
    private static final za a = new za();

    private zb() {
    }

    public static void a(MatrixStack class_45872, float f, float f2, float f3, float f4, float f5, Color color, float f6) {
        Matrix4f matrix4f = class_45872.peek().getPositionMatrix();
        zc zc2 = a.a(f3, f4).a(f5).a(color).b(1.0f).c(f6).a();
        zc2.a(matrix4f, f, f2, 0.0f);
    }

    public static void a(Matrix3x2fStack matrix3x2fStack, float f, float f2, float f3, float f4, float f5, Color color, float f6) {
        zc zc2 = a.a(f3, f4).a(f5).a(color).b(1.0f).c(f6).a();
        zc2.a(zb.a(matrix3x2fStack), f, f2, 0.0f);
    }

    public static void a(MatrixStack class_45872, float f, float f2, float f3, float f4, float[] fArray, Color color, float f5) {
        Matrix4f matrix4f = class_45872.peek().getPositionMatrix();
        float[] fArray2 = new float[4];
        for (int i = 0; i < 4; ++i) {
            fArray2[i] = fArray[i];
            if (fArray[i] == 0.0f) continue;
            fArray2[i] = fArray[i] - 2.0f;
        }
        zc zc2 = a.a(f3, f4).a(new ze(fArray2[0], fArray2[1], fArray2[2], fArray2[3])).a(color).b(1.0f).c(f5).a();
        zc2.a(matrix4f, f, f2, 0.0f);
    }

    public static void a(Matrix3x2fStack matrix3x2fStack, float f, float f2, float f3, float f4, float[] fArray, Color color, float f5) {
        float[] fArray2 = new float[4];
        for (int i = 0; i < 4; ++i) {
            fArray2[i] = fArray[i];
            if (fArray[i] == 0.0f) continue;
            fArray2[i] = fArray[i] - 2.0f;
        }
        zc zc2 = a.a(f3, f4).a(new ze(fArray2[0], fArray2[1], fArray2[2], fArray2[3])).a(color).b(1.0f).c(f5).a();
        zc2.a(zb.a(matrix3x2fStack), f, f2, 0.0f);
    }

    public static void a(MatrixStack class_45872, float f, float f2, float f3, float f4, float f5, Color color) {
        zb.a(class_45872, f, f2, f3, f4, f5, Color.WHITE, 12.0f);
    }

    public static void b(MatrixStack class_45872, float f, float f2, float f3, float f4, float[] fArray, Color color, float f5) {
        zb.a(class_45872, f, f2, f3, f4, fArray, Color.WHITE, f5);
    }

    public static void a(MatrixStack class_45872, float f, float f2, float f3, float f4) {
        zb.a(class_45872, f, f2, f3, f4, 0.0f, Color.WHITE, 10.0f);
    }

    public static void a(MatrixStack class_45872, float f, float f2, float f3, float f4, float f5) {
        zb.a(class_45872, f, f2, f3, f4, f5, Color.WHITE, 12.0f);
    }

    private static Matrix4f a(Matrix3x2fStack matrix3x2fStack) {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.identity();
        matrix4f.m00(matrix3x2fStack.m00());
        matrix4f.m01(matrix3x2fStack.m01());
        matrix4f.m10(matrix3x2fStack.m10());
        matrix4f.m11(matrix3x2fStack.m11());
        matrix4f.m30(matrix3x2fStack.m20());
        matrix4f.m31(matrix3x2fStack.m21());
        return matrix4f;
    }
}

