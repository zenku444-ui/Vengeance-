/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.r.r;

import com.vengeance.vengeanceclient.r.r.zg;
import com.vengeance.vengeanceclient.utils.za;
import java.awt.Color;

public class zb
extends zg {
    private final boolean a;
    private Color b;

    public zb(String string, Color color) {
        this(string, color, false);
    }

    public zb(String string, Color color, boolean bl) {
        super(string);
        this.b = color;
        this.a = bl;
    }

    public zb(String string, int n) {
        this(string, new Color(n), false);
    }

    public zb(String string, int n, boolean bl) {
        this(string, new Color(n, bl), bl);
    }

    public void a(int n) {
        this.b = new Color(n, this.a);
        this.j();
    }

    public void a(int n, int n2, int n3) {
        this.b = new Color(n, n2, n3);
        this.j();
    }

    public void a(int n, int n2, int n3, int n4) {
        this.b = new Color(n, n2, n3, n4);
        this.j();
    }

    public void a(Color color) {
        this.b = color;
        this.j();
    }

    public int a() {
        return this.b.getRGB();
    }

    public int b() {
        return this.b.getRed();
    }

    public int c() {
        return this.b.getGreen();
    }

    public int d() {
        return this.b.getBlue();
    }

    public int e() {
        return this.b.getAlpha();
    }

    public float[] f() {
        return Color.RGBtoHSB(this.b.getRed(), this.b.getGreen(), this.b.getBlue(), null);
    }

    public void a(float f, float f2, float f3) {
        int n = Color.HSBtoRGB(f, f2, f3);
        this.b = this.a ? new Color(this.b.getAlpha() << 24 | n & 0xFFFFFF, true) : new Color(n);
        this.j();
    }

    private void j() {
        za.a().b();
    }

    public boolean g() {
        return this.a;
    }

    public Color h() {
        return this.b;
    }
}

