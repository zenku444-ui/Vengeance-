/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.r.r;

import com.vengeance.vengeanceclient.r.r.zg;
import com.vengeance.vengeanceclient.utils.za;

public class ze
extends zg {
    private final double a;
    private final double b;
    private final double c;
    private double d;

    public ze(String string, double d, double d2, double d3, double d4) {
        super(string);
        this.a = d;
        this.b = d2;
        this.c = d4;
        this.a(d3);
    }

    public void a(double d) {
        double d2 = 1.0 / this.c;
        this.d = (double)Math.round(Math.max(this.a, Math.min(this.b, d)) * d2) / d2;
        this.g();
    }

    public int a() {
        return (int)this.d;
    }

    public float b() {
        return (float)this.d;
    }

    private void g() {
        za.a().b();
    }

    public double c() {
        return this.a;
    }

    public double d() {
        return this.b;
    }

    public double e() {
        return this.c;
    }

    public double f() {
        return this.d;
    }
}

