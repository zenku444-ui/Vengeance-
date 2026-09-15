/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.w.s.r;

import java.awt.Color;

public record za(int color1, int color2, int color3, int color4) {
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

    public int a() {
        return this.color1;
    }

    public int b() {
        return this.color2;
    }

    public int c() {
        return this.color3;
    }

    public int d() {
        return this.color4;
    }
}

