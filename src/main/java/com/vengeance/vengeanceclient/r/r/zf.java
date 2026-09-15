/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.r.r;

import com.vengeance.vengeanceclient.r.r.zg;

public class zf
extends zg {
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;

    public zf(String string, double d, double d2, double d3, double d4, double d5) {
        super(string);
        this.a = d;
        this.b = d2;
        this.c = Math.max(d, Math.min(d2, d3));
        this.d = Math.max(d, Math.min(d2, d4));
        this.e = d5;
        if (this.c > this.d) {
            double d6 = this.c;
            this.c = this.d;
            this.d = d6;
        }
    }

    public void a(double d) {
        this.c = Math.max(this.a, Math.min(this.b, d));
        if (this.c > this.d) {
            this.d = this.c;
        }
    }

    public void b(double d) {
        this.d = Math.max(this.a, Math.min(this.b, d));
        if (this.d < this.c) {
            this.c = this.d;
        }
    }

    public void a(double d, double d2) {
        if (d > d2) {
            double d3 = d;
            d = d2;
            d2 = d3;
        }
        this.c = Math.max(this.a, Math.min(this.b, d));
        this.d = Math.max(this.a, Math.min(this.b, d2));
    }

    public double a() {
        return this.a;
    }

    public double b() {
        return this.b;
    }

    public double c() {
        return this.c;
    }

    public double d() {
        return this.d;
    }

    public double e() {
        return this.e;
    }

    public void c(double d) {
        this.a = d;
    }

    public void d(double d) {
        this.b = d;
    }

    public void e(double d) {
        this.e = d;
    }
}

