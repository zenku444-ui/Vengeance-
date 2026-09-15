/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.w.s.r;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public record zc(float width, float height) {
    public static final zc a = new zc(0.0f, 0.0f);

    public zc(double d, double d2) {
        this((float)d, (float)d2);
    }

    public zc(float f, float f2) {
        this.width = f;
        this.height = f2;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{zc.class, "width;height", "width", "height"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{zc.class, "width;height", "width", "height"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{zc.class, "width;height", "width", "height"}, this, object);
    }

    public float a() {
        return this.width;
    }

    public float b() {
        return this.height;
    }
}

