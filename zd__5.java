/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Items
 */
package com.vengeance.vengeanceclient.r.q.t;

import com.vengeance.vengeanceclient.mixin.MinecraftClientAccessor;
import com.vengeance.vengeanceclient.r.r.zf;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.item.Items;

public final class zd
extends zb {
    public static final zf b = new zf("Delay (MS)", 0.0, 1200.0, 250.0, 330.0, 0.5);
    public static final com.vengeance.vengeanceclient.r.r.za c = new com.vengeance.vengeanceclient.r.r.za("Pick up after", false);
    public static final com.vengeance.vengeanceclient.r.r.za d = new com.vengeance.vengeanceclient.r.r.za("Rotate back", false);
    public static final com.vengeance.vengeanceclient.r.r.za e = new com.vengeance.vengeanceclient.r.r.za("Goto prev-slot", false);
    private final com.vengeance.vengeanceclient.utils.s.zb f = new com.vengeance.vengeanceclient.utils.s.zb();
    private final com.vengeance.vengeanceclient.utils.s.zb g = new com.vengeance.vengeanceclient.utils.s.zb();
    private boolean h = false;
    private float i;
    private int j;
    private long k;
    private za l = za.a;

    public zd() {
        super("Auto Extinguish", "Automatically places water to extinguish you", -1, com.vengeance.vengeanceclient.r.za.b);
        this.a(b, c, d, e);
    }

    @EventHandler
    private void onTickEvent(com.vengeance.vengeanceclient.p.p.s.zd zd2) {
        if (this.d()) {
            return;
        }
        if (zd.a.player.isOnFire()) {
            if (!this.h) {
                this.n();
            } else {
                this.o();
            }
        } else if (this.h) {
            this.p();
        }
    }

    private void n() {
        this.h = true;
        this.i = zd.a.player.getPitch();
        this.j = zd.a.player.getInventory().selectedSlot;
        long l = (long)b.c();
        long l2 = (long)b.d();
        this.k = (long)com.vengeance.vengeanceclient.utils.s.za.a(l, l2);
        this.l = za.b;
        this.f.a();
        this.g.a();
    }

    private void o() {
        if (this.f.a(this.k)) {
            switch (this.l.ordinal()) {
                case 1: {
                    com.vengeance.vengeanceclient.utils.t.zd.a(Items.WATER_BUCKET);
                    this.l = za.c;
                    this.f.a();
                    break;
                }
                case 2: {
                    zd.a.player.setPitch(89.9f);
                    this.l = za.d;
                    this.f.a();
                    break;
                }
                case 3: {
                    com.vengeance.vengeanceclient.utils.t.zd.a(Items.WATER_BUCKET);
                    ((MinecraftClientAccessor)a).invokeDoItemUse();
                    this.l = c.b() ? za.e : za.f;
                    this.f.a();
                    break;
                }
                case 4: {
                    if (!this.g.a(100L)) break;
                    ((MinecraftClientAccessor)a).invokeDoItemUse();
                    this.l = za.f;
                    this.f.a();
                    break;
                }
                case 5: {
                    if (e.b()) {
                        zd.a.player.getInventory().selectedSlot = this.j;
                    }
                    if (d.b()) {
                        zd.a.player.setPitch(this.i);
                    }
                    this.h = false;
                    this.l = za.a;
                    this.a();
                }
            }
        }
    }

    private void p() {
        this.h = false;
        if (e.b()) {
            zd.a.player.getInventory().selectedSlot = this.j;
        }
        if (d.b()) {
            zd.a.player.setPitch(this.i);
        }
        this.l = za.a;
    }

    @Override
    public void b() {
        this.g.a();
        this.f.a();
        this.h = false;
        this.l = za.a;
        super.b();
    }

    @Override
    public void c() {
        this.g.a();
        this.f.a();
        if (this.h) {
            this.p();
        }
        super.c();
    }

    private static final class za
    extends Enum<za> {
        public static final /* enum */ za a = new za();
        public static final /* enum */ za b = new za();
        public static final /* enum */ za c = new za();
        public static final /* enum */ za d = new za();
        public static final /* enum */ za e = new za();
        public static final /* enum */ za f = new za();
        private static final /* synthetic */ za[] g;

        public static za[] values() {
            return (za[])g.clone();
        }

        public static za valueOf(String string) {
            return Enum.valueOf(za.class, string);
        }

        private static /* synthetic */ za[] a() {
            return new za[]{a, b, c, d, e, f};
        }

        static {
            g = za.a();
        }
    }
}

