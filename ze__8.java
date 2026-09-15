/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.w.p;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class ze
extends Record {
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

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{ze.class, "radius1;radius2;radius3;radius4", "b", "c", "d", "e"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{ze.class, "radius1;radius2;radius3;radius4", "b", "c", "d", "e"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{ze.class, "radius1;radius2;radius3;radius4", "b", "c", "d", "e"}, this, object);
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
}

