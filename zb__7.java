/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.r.q.p;

import com.vengeance.vengeanceclient.r.r.zd;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import java.awt.Color;

public class zb
extends com.vengeance.vengeanceclient.r.zb {
    public static final com.vengeance.vengeanceclient.r.r.zb b = new com.vengeance.vengeanceclient.r.r.zb("Accent Color", new Color(124, 77, 255, 255));
    public static final zd c = new zd("Font", "Inter.ttf", "Inter.ttf", "jetbrainsmono.ttf", "poppins-medium.ttf", "Monaco.ttf");
    public static final com.vengeance.vengeanceclient.r.r.za d = new com.vengeance.vengeanceclient.r.r.za("Scrollable Categories", false);
    public static final ze e = new ze("GUI Scale", 0.0, 3.0, 1.0, 1.0);
    public static final ze f = new ze("GUI Transparency", 0.0, 100.0, 0.0, 1.0);
    public static final com.vengeance.vengeanceclient.r.r.za g = new com.vengeance.vengeanceclient.r.r.za("GUI Blur", false);
    public static final com.vengeance.vengeanceclient.r.r.za h = new com.vengeance.vengeanceclient.r.r.za("Panel Blur", false);
    public static final ze i = new ze("Panel Blur Radius", 5.0, 30.0, 12.0, 1.0);
    public static final com.vengeance.vengeanceclient.r.r.za j = new com.vengeance.vengeanceclient.r.r.za("Module Descriptions", true);
    public static final ze k = new ze("Toggle Width", 10.0, 40.0, 20.0, 1.0);
    public static final ze l = new ze("Toggle Height", 6.0, 20.0, 10.0, 1.0);
    public static final ze m = new ze("Slider Height", 2.0, 10.0, 4.0, 0.5);
    public static final ze n = new ze("Slider Handle Size", 3.0, 8.0, 5.0, 0.5);
    public static final com.vengeance.vengeanceclient.r.r.za o = new com.vengeance.vengeanceclient.r.r.za("GUI Glow", false);
    public static final com.vengeance.vengeanceclient.r.r.zb p = new com.vengeance.vengeanceclient.r.r.zb("Glow Color", new Color(124, 77, 255, 255));
    public static final ze q = new ze("Glow Intensity", 0.0, 2.0, 1.0, 0.1);
    public static final ze r = new ze("Glow Thickness", 2.0, 10.0, 5.0, 1.0);
    public static final ze s = new ze("Bloom Radius", 5.0, 15.0, 10.0, 1.0);
    public static final com.vengeance.vengeanceclient.r.r.za t = new com.vengeance.vengeanceclient.r.r.za("Auto Focus Search", true);
    public static final com.vengeance.vengeanceclient.r.r.za u = new com.vengeance.vengeanceclient.r.r.za("Snow Effect", false);
    public static final com.vengeance.vengeanceclient.r.r.za v = new com.vengeance.vengeanceclient.r.r.za("Auto Save Settings", false);

    public zb() {
        super("ClientSettings", "Customize GUI appearance", 0, za.f);
        this.a(b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v);
        this.a(true);
    }

    public static Color n() {
        return b.h();
    }

    public static String o() {
        return c.a();
    }

    public static boolean p() {
        return d.b();
    }

    public static float q() {
        return f.b() / 100.0f;
    }

    public static boolean r() {
        return g.b();
    }

    public static boolean s() {
        return h.b();
    }

    public static float t() {
        return i.b();
    }

    public static boolean u() {
        return j.b();
    }

    public static float v() {
        return k.b();
    }

    public static float w() {
        return l.b();
    }

    public static float x() {
        return m.b();
    }

    public static float y() {
        return n.b();
    }

    public static boolean z() {
        return o.b();
    }

    public static Color aa() {
        return p.h();
    }

    public static float ab() {
        return q.b();
    }

    public static float ac() {
        return r.b();
    }

    public static float ad() {
        return s.b();
    }

    public static boolean ae() {
        return t.b();
    }

    public static boolean af() {
        return u.b();
    }

    public static int ag() {
        return (int)e.f();
    }

    public static boolean ah() {
        return v.b();
    }
}

