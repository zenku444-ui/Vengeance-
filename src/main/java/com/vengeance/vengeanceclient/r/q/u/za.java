/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.ChatScreen
 */
package com.vengeance.vengeanceclient.r.q.u;

import com.vengeance.vengeanceclient.VengeanceClient;
import com.vengeance.vengeanceclient.r.q.p.zd;
import com.vengeance.vengeanceclient.r.r.ze;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;

public class za
extends com.vengeance.vengeanceclient.r.zb {
    private static final float b = 4.0f;
    private static final float c = 5.0f;
    private static final float d = 3.0f;
    private static final float e = 0.5f;
    private static final Color f = new Color(255, 255, 255, 255);
    private static final Color g = new Color(20, 20, 25);
    private final com.vengeance.vengeanceclient.r.r.zd h = new com.vengeance.vengeanceclient.r.r.zd("Position", "Top Right", "Top Left", "Top Right");
    private final ze i = new ze("Font Size", 8.0, 24.0, 14.0, 1.0);
    private final ze j = new ze("BG Alpha", 0.0, 255.0, 150.0, 1.0);
    private final com.vengeance.vengeanceclient.r.r.za k = new com.vengeance.vengeanceclient.r.r.za("Rounded", true);
    private final ze l = new ze("Bar Width", 1.0, 5.0, 2.0, 0.5);
    private final com.vengeance.vengeanceclient.r.r.za m = new com.vengeance.vengeanceclient.r.r.za("Text Shadow", true);

    public za() {
        super("ArrayList", "Displays enabled modules", -1, com.vengeance.vengeanceclient.r.za.d);
        this.a(this.h, this.i, this.j, this.k, this.l, this.m);
    }

    @EventHandler
    private void onRender2D(com.vengeance.vengeanceclient.p.p.t.za za2) {
        if (!this.o()) {
            return;
        }
        List<com.vengeance.vengeanceclient.r.zb> list = this.p();
        if (list.isEmpty()) {
            return;
        }
        com.vengeance.vengeanceclient.utils.w.r.za.c();
        this.a(list);
        com.vengeance.vengeanceclient.utils.w.r.za.e();
    }

    private boolean o() {
        return za.a.player != null && za.a.world != null && (za.a.currentScreen == null || za.a.currentScreen instanceof ChatScreen);
    }

    private List<com.vengeance.vengeanceclient.r.zb> p() {
        List<com.vengeance.vengeanceclient.r.zb> list = VengeanceClient.INSTANCE.getModuleManager().a();
        ArrayList<com.vengeance.vengeanceclient.r.zb> arrayList = new ArrayList<com.vengeance.vengeanceclient.r.zb>(list);
        float f = (float)this.i.f();
        arrayList.sort(Comparator.comparingDouble(zb2 -> -com.vengeance.vengeanceclient.utils.w.r.za.a(zb2.i(), f)));
        return arrayList;
    }

    private void a(List<com.vengeance.vengeanceclient.r.zb> list) {
        zb zb2 = new zb(this);
        for (int i = 0; i < list.size(); ++i) {
            za$Entry za2 = new za$Entry(this, list, i, zb2);
            this.a(za2, zb2);
        }
    }

    private void a(za$Entry za2, zb zb2) {
        this.b(za2, zb2);
        this.d(za2, zb2);
        this.e(za2, zb2);
        zb2.h += za2.e;
    }

    private void b(za$Entry za2, zb zb2) {
        if (zb2.e && za2.b()) {
            this.c(za2, zb2);
        } else {
            com.vengeance.vengeanceclient.utils.w.r.za.a(za2.f, za2.g, za2.d, za2.e, zb2.g);
        }
    }

    private void c(za$Entry za2, zb zb2) {
        if (zb2.d) {
            float f = 0.0f;
            float f2 = 0.0f;
            float f3 = 0.0f;
            float f4 = 0.0f;
            if (za2.h || za2.j) {
                f = 3.0f;
            }
            if (za2.i || za2.k) {
                f4 = 3.0f;
            }
            com.vengeance.vengeanceclient.utils.w.r.za.a(za2.f, za2.g, za2.d, za2.e, f, f2, f3, f4, zb2.g);
        } else {
            float f = 0.0f;
            float f5 = 0.0f;
            float f6 = 0.0f;
            float f7 = 0.0f;
            if (za2.h || za2.j) {
                f5 = 3.0f;
            }
            if (za2.i || za2.k) {
                f6 = 3.0f;
            }
            com.vengeance.vengeanceclient.utils.w.r.za.a(za2.f, za2.g, za2.d, za2.e, f, f5, f6, f7, zb2.g);
        }
    }

    private void d(za$Entry za2, zb zb2) {
        float f = zb2.d ? za2.f + za2.d - zb2.c : za2.f;
        com.vengeance.vengeanceclient.utils.w.r.za.a(f, za2.g, zb2.c, za2.e, zb2.f);
    }

    private void e(za$Entry za2, zb zb2) {
        float f = za2.f + 4.0f + (zb2.d ? 0.0f : zb2.c);
        float f2 = za2.g + 4.0f;
        if (this.m.b()) {
            com.vengeance.vengeanceclient.utils.w.r.za.b(za2.a, f, f2, zb2.b, za.f);
        } else {
            com.vengeance.vengeanceclient.utils.w.r.za.a(za2.a, f, f2, zb2.b, za.f);
        }
    }

    static /* synthetic */ MinecraftClient n() {
        return a;
    }

    private class zb {
        final int a = za.n().getWindow().getScaledWidth();
        final float b;
        final float c;
        final boolean d;
        final boolean e;
        final Color f;
        final Color g;
        float h;

        zb(za za2) {
            this.b = (float)za2.i.f();
            this.c = (float)za2.l.f();
            this.d = za2.h.a().contains("Right");
            this.e = za2.k.b();
            this.f = zd.n();
            this.g = new Color(this.f.getRed(), this.f.getGreen(), this.f.getBlue(), (int)za2.j.f());
            this.h = 5.0f;
        }
    }

    private class za$Entry {
        final String a;
        final float b;
        final float c;
        final float d;
        final float e;
        final float f;
        final float g;
        final boolean h;
        final boolean i;
        final boolean j;
        final boolean k;

        za$Entry(za za2, List<com.vengeance.vengeanceclient.r.zb> list, int n, zb zb2) {
            com.vengeance.vengeanceclient.r.zb zb3 = list.get(n);
            this.a = zb3.i();
            this.b = com.vengeance.vengeanceclient.utils.w.r.za.a(this.a, zb2.b);
            this.c = com.vengeance.vengeanceclient.utils.w.r.za.a(zb2.b);
            this.d = this.b + 8.0f;
            this.e = this.c + 8.0f;
            this.f = zb2.d ? (float)zb2.a - this.d - 5.0f : 5.0f;
            this.g = zb2.h;
            this.h = n == 0;
            this.i = n == list.size() - 1;
            this.j = !this.h && this.a(list.get(n - 1), zb2);
            this.k = !this.i && this.b(list.get(n + 1), zb2);
        }

        private boolean a(com.vengeance.vengeanceclient.r.zb zb2, zb zb3) {
            float f = com.vengeance.vengeanceclient.utils.w.r.za.a(zb2.i(), zb3.b);
            float f2 = f + 8.0f;
            return this.d < f2 - 0.5f;
        }

        private boolean b(com.vengeance.vengeanceclient.r.zb zb2, zb zb3) {
            float f = com.vengeance.vengeanceclient.utils.w.r.za.a(zb2.i(), zb3.b);
            float f2 = f + 8.0f;
            return this.d > f2 + 0.5f;
        }

        boolean a() {
            return this.h || this.i || this.j || this.k;
        }

        boolean b() {
            return this.a();
        }
    }
}

