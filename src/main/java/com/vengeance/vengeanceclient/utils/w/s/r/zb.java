/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.w.s.r;


public record zb(float radius1, float radius2, float radius3, float radius4) {
    public static final zb a = new zb(0.0f, 0.0f, 0.0f, 0.0f);

    public zb(double d, double d2, double d3, double d4) {
        this((float)d, (float)d2, (float)d3, (float)d4);
    }

    public zb(double d) {
        this(d, d, d, d);
    }

    public zb(float f) {
        this(f, f, f, f);
    }

    public float a() {
        return this.radius1;
    }

    public float b() {
        return this.radius2;
    }

    public float c() {
        return this.radius3;
    }

    public float d() {
        return this.radius4;
    }
}

