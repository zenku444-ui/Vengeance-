/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.screen.ChatScreen
 */
package com.vengeance.vengeanceclient.r.q.u;

import com.vengeance.vengeanceclient.r.r.zd;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.r.zh;
import java.awt.Color;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.gui.screen.ChatScreen;

public class zr
extends com.vengeance.vengeanceclient.r.zb {
    private static final float b = 6.0f;
    private static final float c = 11.0f;
    private static final float d = 12.0f;
    private static final float e = 6.0f;
    private static final float f = 4.0f;
    private static final float g = 6.0f;
    private static final float h = 4.0f;
    private static final float i = 5.0f;
    private static final Color j = new Color(200, 200, 200);
    private static final Color k = new Color(255, 255, 255, 255);
    private static final Color l = new Color(20, 20, 25);
    private static final DateTimeFormatter m = DateTimeFormatter.ofPattern("HH:mm:ss");
    private final zh n = new zh("Text", "Vengeance Client");
    private final ze o = new ze("Transparency", 0.0, 255.0, 200.0, 1.0);
    private final zd p = new zd("Color Mode", "Theme", "Theme", "Custom");
    private final com.vengeance.vengeanceclient.r.r.zb q = new com.vengeance.vengeanceclient.r.r.zb("Custom Color", new Color(255, 255, 255));
    private final com.vengeance.vengeanceclient.r.r.za r = new com.vengeance.vengeanceclient.r.r.za("Show Title", true);
    private final com.vengeance.vengeanceclient.r.r.za s = new com.vengeance.vengeanceclient.r.r.za("Show Username", true);
    private final com.vengeance.vengeanceclient.r.r.za t = new com.vengeance.vengeanceclient.r.r.za("Show FPS", true);
    private final com.vengeance.vengeanceclient.r.r.za u = new com.vengeance.vengeanceclient.r.r.za("Show Time", true);
    private final com.vengeance.vengeanceclient.r.r.za v = new com.vengeance.vengeanceclient.r.r.za("Show Coords", true);
    private final com.vengeance.vengeanceclient.r.r.za x = new com.vengeance.vengeanceclient.r.r.za("Show Ping", true);
    private com.vengeance.vengeanceclient.utils.w.ze y;
    private boolean z = true;
    private int aa = -1;
    private int ab = -1;
    private int ac = -1;
    private int ad = -1;

    public zr() {
        super("Watermark", "Displays client watermark", -1, com.vengeance.vengeanceclient.r.za.d);
        this.a(this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.x);
    }

    @Override
    public void b() {
        this.y();
    }

    @EventHandler
    private void onRender2D(com.vengeance.vengeanceclient.p.p.t.za za2) {
        if (!this.w()) {
            return;
        }
        this.y();
        this.x();
        boolean bl = zr.a.currentScreen instanceof ChatScreen;
        if (zr.a.currentScreen != null && !bl) {
            return;
        }
        this.c(bl);
    }

    private boolean w() {
        return zr.a.player != null && zr.a.world != null;
    }

    private void x() {
        if (this.y == null) {
            int n = a.getWindow().getScaledWidth();
            this.y = new com.vengeance.vengeanceclient.utils.w.ze((float)n / 2.0f, 10.0f, 200.0f, 20.0f);
            this.z = true;
        }
    }

    private void y() {
        if (this.aa == -1) {
            this.aa = com.vengeance.vengeanceclient.utils.w.r.za.a("assets/vengeance-client/textures/icons/fps.png");
        }
        if (this.ab == -1) {
            this.ab = com.vengeance.vengeanceclient.utils.w.r.za.a("assets/vengeance-client/textures/icons/user.png");
        }
        if (this.ac == -1) {
            this.ac = com.vengeance.vengeanceclient.utils.w.r.za.a("assets/vengeance-client/textures/icons/clock.png");
        }
        if (this.ad == -1) {
            this.ad = com.vengeance.vengeanceclient.utils.w.r.za.a("assets/vengeance-client/textures/icons/ping.png");
        }
    }

    private void c(boolean bl) {
        zc zc2 = new zc(this);
        List<za> list = this.a(zc2);
        zb zb2 = new zb(this, list);
        this.a(zb2);
        this.a(bl, zb2.a);
        this.a(list);
    }

    private List<za> a(zc zc2) {
        ArrayList<za> arrayList = new ArrayList<za>();
        Color color = this.aa();
        if (this.r.b()) {
            arrayList.add(new za(this, zc2.a, -1, color, true));
        }
        if (this.s.b()) {
            arrayList.add(new za(this, zc2.b, this.ab, j, false));
        }
        if (this.t.b()) {
            arrayList.add(new za(this, zc2.d, this.aa, j, false));
        }
        if (this.u.b()) {
            arrayList.add(new za(this, zc2.c, this.ac, j, false));
        }
        if (this.v.b()) {
            arrayList.add(new za(this, zc2.e, -1, j, false));
        }
        if (this.x.b()) {
            arrayList.add(new za(this, zc2.f, this.ad, j, false));
        }
        return arrayList;
    }

    private void a(zb zb2) {
        this.y.c(zb2.a);
        this.y.d(zb2.b);
        if (this.z) {
            int n = a.getWindow().getScaledWidth();
            this.y.a((float)n / 2.0f - zb2.a / 2.0f);
            this.z = false;
        }
    }

    private void a(boolean bl, float f) {
        if (bl) {
            this.y.a();
            this.a(f);
        }
    }

    private void a(List<za> list) {
        if (list.isEmpty()) {
            return;
        }
        float f = this.y.b();
        float f2 = this.y.c();
        float f3 = com.vengeance.vengeanceclient.utils.w.r.za.a(11.0f);
        int n = this.z();
        for (int i = 0; i < list.size(); ++i) {
            za za2 = list.get(i);
            this.a(za2, f, f2, f3);
            f += za2.d + 6.0f;
            if (i != n - 1 || i >= list.size() - 1) continue;
            f = this.y.b();
            f2 += f3 + 12.0f + 6.0f;
        }
    }

    private int z() {
        int n = 0;
        if (this.r.b()) {
            ++n;
        }
        if (this.s.b()) {
            ++n;
        }
        if (this.t.b()) {
            ++n;
        }
        if (this.u.b()) {
            ++n;
        }
        return n;
    }

    private void a(za za2, float f, float f2, float f3) {
        int n = (int)this.o.f();
        Color color = new Color(l.getRed(), l.getGreen(), l.getBlue(), n);
        float f4 = f3 + 12.0f;
        com.vengeance.vengeanceclient.utils.w.r.za.a(f, f2, za2.d, f4, 4.0f, color);
        float f5 = f + 6.0f;
        float f6 = f2 + 6.0f;
        float f7 = f2 + 6.0f + (f3 - 12.0f) / 2.0f;
        if (za2.b != -1) {
            com.vengeance.vengeanceclient.utils.w.r.za.a(za2.b, f5, f7, 12.0f, 12.0f, k);
            f5 += 16.0f;
        }
        com.vengeance.vengeanceclient.utils.w.r.za.a(za2.a, f5, f6, 11.0f, za2.c);
    }

    private void a(float f) {
        int n = a.getWindow().getScaledWidth();
        float f2 = (float)n / 2.0f;
        float f3 = this.y.b() + f / 2.0f;
        if (Math.abs(f3 - f2) < 5.0f) {
            this.y.a(f2 - f / 2.0f);
        }
    }

    private Color aa() {
        return switch (this.p.a()) {
            case "Custom" -> this.q.h();
            default -> com.vengeance.vengeanceclient.r.q.p.zd.n();
        };
    }

    private class zc {
        final String a;
        final String b;
        final String c;
        final String d;
        final String e;
        final String f;

        zc(zr zr2) {
            this.a = zr2.n.a();
            this.b = a.player.getName().getString();
            this.c = LocalTime.now().format(m);
            int n = a.getCurrentFps();
            this.d = n + " Fps";
            this.e = String.format("%d %d %d", (int)a.player.getX(), (int)a.player.getY(), (int)a.player.getZ());
            int n2 = a.player.networkHandler.getPlayerListEntry(a.player.getUuid()) != null ? a.player.networkHandler.getPlayerListEntry(a.player.getUuid()).getLatency() : 0;
            this.f = n2 + " Ping";
        }
    }

    private class zb {
        final float a;
        final float b;

        zb(zr zr2, List<za> list) {
            int n;
            if (list.isEmpty()) {
                this.a = 100.0f;
                this.b = 20.0f;
                return;
            }
            float f = com.vengeance.vengeanceclient.utils.w.r.za.a(11.0f);
            float f2 = f + 12.0f;
            int n2 = zr2.z();
            float f3 = 0.0f;
            for (int i = 0; i < Math.min(n2, list.size()); ++i) {
                f3 += list.get((int)i).d;
                if (i >= n2 - 1) continue;
                f3 += 6.0f;
            }
            float f4 = 0.0f;
            for (n = n2; n < list.size(); ++n) {
                f4 += list.get((int)n).d;
                if (n >= list.size() - 1) continue;
                f4 += 6.0f;
            }
            this.a = Math.max(f3, f4);
            n = list.size() > n2 ? 1 : 0;
            this.b = n != 0 ? f2 * 2.0f + 6.0f : f2;
        }
    }

    private class za {
        final String a;
        final int b;
        final Color c;
        final float d;

        za(zr zr2, String string, int n, Color color, boolean bl) {
            float f;
            this.a = string;
            this.b = n;
            this.c = color;
            float f2 = f = com.vengeance.vengeanceclient.utils.w.r.za.a(string, 11.0f);
            if (n != -1) {
                f2 += 16.0f;
            }
            this.d = f2 + 12.0f;
        }
    }
}

