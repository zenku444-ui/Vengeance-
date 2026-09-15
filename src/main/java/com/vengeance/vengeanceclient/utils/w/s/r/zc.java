/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.w.s.r;


public record zc(float width, float height) {
    public static final zc a = new zc(0.0f, 0.0f);

    public zc(double d, double d2) {
        this((float)d, (float)d2);
    }

    public float a() {
        return this.width;
    }

    public float b() {
        return this.height;
    }
}

