/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.w.s.r;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class zc
extends Record {
    private final float b;
    private final float c;
    public static final zc a = new zc(0.0f, 0.0f);

    public zc(double d, double d2) {
        this((float)d, (float)d2);
    }

    public zc(float f, float f2) {
        this.b = f;
        this.c = f2;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{zc.class, "width;height", "b", "c"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{zc.class, "width;height", "b", "c"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{zc.class, "width;height", "b", "c"}, this, object);
    }

    public float a() {
        return this.b;
    }

    public float b() {
        return this.c;
    }
}

