/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.w.p;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class zf
extends Record {
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

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{zf.class, "width;height", "b", "c"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{zf.class, "width;height", "b", "c"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{zf.class, "width;height", "b", "c"}, this, object);
    }

    public float a() {
        return this.b;
    }

    public float b() {
        return this.c;
    }
}

