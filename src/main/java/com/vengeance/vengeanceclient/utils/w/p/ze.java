/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.w.p;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class ze {
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    public static final ze a = new ze(0.0f, 0.0f, 0.0f, 0.0f);

    public ze(double d, double d2, double d3, double d4) {
        this((float)d, (float)d2, (float)d3, (float)d4);
    }

    public ze(double d) {
        this(d, d, d, d);
    }

    public ze(float f) {
        this(f, f, f, f);
    }

    public ze(float f, float f2, float f3, float f4) {
        this.b = f;
        this.c = f2;
        this.d = f3;
        this.e = f4;
    }

    public float a() {
        return this.b;
    }

    public float b() {
        return this.c;
    }

    public float c() {
        return this.d;
    }

    public float d() {
        return this.e;
    }

    @Override
    public String toString() {
        return "ze[b=" + this.b + ", c=" + this.c + ", d=" + this.d + ", e=" + this.e + "]";
    }

    @Override
    public int hashCode() {
        int result = Float.hashCode(this.b);
        result = 31 * result + Float.hashCode(this.c);
        result = 31 * result + Float.hashCode(this.d);
        result = 31 * result + Float.hashCode(this.e);
        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ze)) {
            return false;
        }
        ze other = (ze)object;
        return Float.compare(this.b, other.b) == 0 && Float.compare(this.c, other.c) == 0 && Float.compare(this.d, other.d) == 0 && Float.compare(this.e, other.e) == 0;
    }
}

