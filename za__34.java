/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.w.s.r;

import java.awt.Color;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public final class za
extends Record {
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    public static final za a = new za(0, 0, 0, 0);
    public static final za b = new za(-1, -1, -1, -1);

    public za(Color color, Color color2, Color color3, Color color4) {
        this(color.getRGB(), color2.getRGB(), color3.getRGB(), color4.getRGB());
    }

    public za(Color color) {
        this(color, color, color, color);
    }

    public za(int n) {
        this(n, n, n, n);
    }

    public za(int n, int n2, int n3, int n4) {
        this.c = n;
        this.d = n2;
        this.e = n3;
        this.f = n4;
    }

    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{za.class, "color1;color2;color3;color4", "c", "d", "e", "f"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{za.class, "color1;color2;color3;color4", "c", "d", "e", "f"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{za.class, "color1;color2;color3;color4", "c", "d", "e", "f"}, this, object);
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    public int d() {
        return this.f;
    }
}

