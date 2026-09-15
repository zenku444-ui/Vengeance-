/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.w.p;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class zf {
    private final float b;
    private final float c;
    public static final zf a = new zf(0.0f, 0.0f);

    public zf(double d, double d2) {
        this((float)d, (float)d2);
    }

    public zf(float f, float f2) {
        this.b = f;
        this.c = f2;
    }

    public float a() {
        return this.b;
    }

    public float b() {
        return this.c;
    }

    @Override
    public String toString() {
        return "zf[b=" + this.b + ", c=" + this.c + "]";
    }

    @Override
    public int hashCode() {
        int result = Float.hashCode(this.b);
        result = 31 * result + Float.hashCode(this.c);
        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zf)) {
            return false;
        }
        zf other = (zf)object;
        return Float.compare(this.b, other.b) == 0 && Float.compare(this.c, other.c) == 0;
    }
}

