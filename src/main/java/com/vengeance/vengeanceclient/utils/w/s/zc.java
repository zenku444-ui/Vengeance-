/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.joml.Matrix4f
 */
package com.vengeance.vengeanceclient.utils.w.s;

import org.joml.Matrix4f;

public interface zc {
    public static final Matrix4f a = new Matrix4f();

    default public void a(double d, double d2) {
        this.a((float)d, (float)d2);
    }

    default public void a(float f, float f2) {
        this.a(a, f, f2);
    }

    default public void a(Matrix4f matrix4f, double d, double d2) {
        this.a(matrix4f, (float)d, (float)d2);
    }

    default public void a(Matrix4f matrix4f, float f, float f2) {
        this.a(matrix4f, f, f2, 0.0f);
    }

    default public void a(double d, double d2, double d3) {
        this.a((float)d, (float)d2, (float)d3);
    }

    default public void a(float f, float f2, float f3) {
        this.a(a, f, f2, f3);
    }

    default public void a(Matrix4f matrix4f, double d, double d2, double d3) {
        this.a(matrix4f, (float)d, (float)d2, (float)d3);
    }

    public void a(Matrix4f var1, float var2, float var3, float var4);
}

