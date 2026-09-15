/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.w;

import java.awt.Color;

public class zb {
    public static Color a(Color color, Color color2, double d) {
        return zb.a(color, color2, d, d, d, d);
    }

    public static Color a(Color color, Color color2, double d, double d2, double d3, double d4) {
        return new Color((float)(((double)color.getRed() + (double)(color2.getRed() - color.getRed()) * d) / 255.0), (float)(((double)color.getGreen() + (double)(color2.getGreen() - color.getGreen()) * d2) / 255.0), (float)(((double)color.getBlue() + (double)(color2.getBlue() - color.getBlue()) * d3) / 255.0), (float)(((double)color.getAlpha() + (double)(color2.getAlpha() - color.getAlpha()) * d4) / 255.0));
    }
}

