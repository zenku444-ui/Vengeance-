/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 */
package com.vengeance.vengeanceclient.r;

import com.vengeance.vengeanceclient.VengeanceClient;
import com.vengeance.vengeanceclient.r.r.zc;
import com.vengeance.vengeanceclient.r.r.zg;
import com.vengeance.vengeanceclient.r.za;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.client.MinecraftClient;

public abstract class zb
implements com.vengeance.vengeanceclient.utils.zb {
    protected static final MinecraftClient a = MinecraftClient.getInstance();
    private final List<zg> b = new ArrayList<zg>();
    private final za c;
    private final zc d;
    private final String e;
    private final String f;
    private String g;
    private boolean h;
    private int i;
    private boolean j;

    public zb(String string, String string2, int n, za za2) {
        this.e = string;
        this.f = string2;
        this.i = n;
        this.c = za2;
        this.h = false;
        this.d = new zc("Keybind", n, true);
        this.a((zg)this.d);
    }

    public zb(String string, String string2, za za2) {
        this(string, string2, -1, za2);
    }

    public void a() {
        this.a(!this.h);
    }

    public void b() {
    }

    public void c() {
    }

    public boolean d() {
        return zb.a.player == null || zb.a.world == null;
    }

    public void a(zg zg2) {
        this.b.add(zg2);
    }

    public void a(zg ... zgArray) {
        this.b.addAll(Arrays.asList(zgArray));
    }

    public int e() {
        if (this.d()) {
            return this.i;
        }
        return this.d != null ? this.d.e() : this.i;
    }

    public void a(int n) {
        if (this.d()) {
            return;
        }
        this.i = n;
        if (this.d != null) {
            this.d.a(n);
        }
    }

    public final void a(boolean bl) {
        if (this.h == bl) {
            return;
        }
        this.h = bl;
        if (bl) {
            this.b();
            if (this.h) {
                VengeanceClient.INSTANCE.getEventBus().subscribe(this);
                this.j = true;
                com.vengeance.vengeanceclient.utils.u.zb.a().a(this, true);
            }
        } else {
            if (this.j) {
                VengeanceClient.INSTANCE.getEventBus().unsubscribe(this);
                this.j = false;
            }
            this.c();
            com.vengeance.vengeanceclient.utils.u.zb.a().a(this, false);
        }
        com.vengeance.vengeanceclient.utils.za.a().b();
    }

    public void a(String string) {
        this.g = string;
    }

    public void b(boolean bl) {
        this.j = bl;
    }

    public List<zg> f() {
        return this.b;
    }

    public za g() {
        return this.c;
    }

    public zc h() {
        return this.d;
    }

    public String i() {
        return this.e;
    }

    public String j() {
        return this.f;
    }

    public String k() {
        return this.g;
    }

    public boolean l() {
        return this.h;
    }

    public boolean m() {
        return this.j;
    }
}

