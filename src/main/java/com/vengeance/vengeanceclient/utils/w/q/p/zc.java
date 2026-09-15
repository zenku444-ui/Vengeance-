/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.chars.Char2ObjectArrayMap
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.MinecraftClient
 */
package com.vengeance.vengeanceclient.utils.w.q.p;

import com.vengeance.vengeanceclient.utils.w.q.p.zb;
import com.vengeance.vengeanceclient.utils.w.q.q.zd;
import it.unimi.dsi.fastutil.chars.Char2ObjectArrayMap;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;

class zc {
    final char a;
    final char b;
    final Font[] c;
    final Identifier d;
    final int e;
    private final Char2ObjectArrayMap<zb> i = new Char2ObjectArrayMap();
    int f;
    int g;
    boolean h = false;

    public zb a(char c) {
        if (!this.h) {
            this.b();
        }
        return (zb)this.i.get(c);
    }

    public void a() {
        MinecraftClient.getInstance().getTextureManager().destroyTexture(this.d);
        this.i.clear();
        this.f = -1;
        this.g = -1;
        this.h = false;
    }

    public boolean b(char c) {
        return c >= this.a && c < this.b;
    }

    private Font c(char c) {
        for (Font font : this.c) {
            if (!font.canDisplay(c)) continue;
            return font;
        }
        return this.c[0];
    }

    public void b() {
        Object object;
        if (this.h) {
            return;
        }
        int n = this.b - this.a - 1;
        int n2 = (int)(Math.ceil(Math.sqrt(n)) * 1.5);
        this.i.clear();
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        ArrayList<zb> arrayList = new ArrayList<zb>();
        AffineTransform affineTransform = new AffineTransform();
        FontRenderContext fontRenderContext = new FontRenderContext(affineTransform, true, false);
        while (n3 <= n) {
            char c = (char)(this.a + n3);
            object = this.c(c);
            Rectangle2D rectangle2D = ((Font)object).getStringBounds(String.valueOf(c), fontRenderContext);
            int n10 = (int)Math.ceil(rectangle2D.getWidth());
            int n11 = (int)Math.ceil(rectangle2D.getHeight());
            ++n3;
            n5 = Math.max(n5, n7 + n10);
            n6 = Math.max(n6, n8 + n11);
            if (n4 >= n2) {
                n7 = 0;
                n8 += n9 + this.e;
                n4 = 0;
                n9 = 0;
            }
            n9 = Math.max(n9, n11);
            arrayList.add(new zb(n7, n8, n10, n11, c, this));
            n7 += n10 + this.e;
            ++n4;
        }
        BufferedImage bufferedImage = new BufferedImage(Math.max(n5 + this.e, 1), Math.max(n6 + this.e, 1), 2);
        this.f = bufferedImage.getWidth();
        this.g = bufferedImage.getHeight();
        object = bufferedImage.createGraphics();
        ((Graphics)object).setColor(new Color(255, 255, 255, 0));
        ((Graphics)object).fillRect(0, 0, this.f, this.g);
        ((Graphics)object).setColor(Color.WHITE);
        ((Graphics2D)object).setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
        ((Graphics2D)object).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        ((Graphics2D)object).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        for (zb zb2 : arrayList) {
            ((Graphics)object).setFont(this.c(zb2.e()));
            FontMetrics fontMetrics = ((Graphics)object).getFontMetrics();
            ((Graphics2D)object).drawString(String.valueOf(zb2.e()), zb2.a(), zb2.b() + fontMetrics.getAscent());
            this.i.put(zb2.e(), zb2);
        }
        zd.a(this.d, bufferedImage);
        this.h = true;
    }

    public zc(char c, char c2, Font[] fontArray, Identifier class_29602, int n) {
        this.a = c;
        this.b = c2;
        this.c = fontArray;
        this.d = class_29602;
        this.e = n;
    }
}

