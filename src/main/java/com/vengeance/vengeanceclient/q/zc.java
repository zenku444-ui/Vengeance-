/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.util.DefaultSkinHelper
 *  net.minecraft.client.input.CharInput
 *  net.minecraft.client.input.KeyInput
 *  net.minecraft.client.gui.Click
 *  net.minecraft.text.Text
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  org.lwjgl.glfw.GLFW
 */
package com.vengeance.vengeanceclient.q;

import com.vengeance.vengeanceclient.VengeanceClient;
import com.vengeance.vengeanceclient.q.zb;
import com.vengeance.vengeanceclient.r.r.zd;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.r.zf;
import com.vengeance.vengeanceclient.r.r.zg;
import com.vengeance.vengeanceclient.r.za;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import net.minecraft.client.util.DefaultSkinHelper;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.client.gui.Click;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import org.lwjgl.glfw.GLFW;

public class zc
extends Screen {
    private static final int a = 760;
    private static final int b = 460;
    private static final int c = 168;
    private static final int d = 236;
    private static final int e = 356;
    private static final float f = 12.0f;
    private static final int g = 14;
    private static final int h = 108;
    private static final int i = 28;
    private static final int j = 36;
    private static final int k = 54;
    private static final int l = 44;
    private static final int m = 58;
    private static final int n = 50;
    private static final int o = 54;
    private static final int p = 50;
    private static final int q = 58;
    private static final int r = 40;
    private static final int s = 36;
    private static final int t = 44;
    private static final int u = 44;
    private static final Color v = new Color(26, 26, 34);
    private static final Color w = new Color(32, 32, 44);
    private static final Color x = new Color(44, 44, 58);
    private static final Color y = new Color(228, 228, 240);
    private static final Color z = new Color(106, 106, 124);
    private static final Color aa = new Color(54, 54, 70);
    private static final Color ab = new Color(38, 38, 52);
    private static final Color ac = new Color(30, 30, 42);
    private static final Color ad = new Color(52, 52, 70);
    private static final Color ae = new Color(46, 46, 64);
    private static final Color af = new Color(20, 20, 30);
    private static final Color ag = new Color(28, 28, 42);
    private za ah = za.a;
    private com.vengeance.vengeanceclient.r.zb ai = null;
    private String aj = "";
    private boolean ak = false;
    private float al = 0.0f;
    private float am = 0.0f;
    private boolean an = false;
    private boolean ao = false;
    private ze ap = null;
    private float aq;
    private float ar;
    private zf as = null;
    private boolean at = false;
    private float au;
    private float av;
    private zd aw = null;
    private float ax;
    private float ay;
    private float az;
    private final HashMap<za, Float> ba = new HashMap();
    private float bb = 0.0f;
    private boolean bc = false;
    private long bd = System.currentTimeMillis();
    private static int be = -1;
    private static String bf = null;
    private final List<String> bg = new ArrayList<String>();
    private String bh = null;
    private String bi = null;
    private long bj = 0L;
    private boolean bk = false;
    private String bl = "";
    private float bm = 0.0f;
    private static final long bn = 3000L;

    public zc() {
        super((Text)Text.literal((String)"Rich Modern"));
        zb.a();
        this.a();
    }

    private void a() {
        this.ai = null;
        for (com.vengeance.vengeanceclient.r.zb zb2 : VengeanceClient.INSTANCE.getModuleManager().b(this.ah)) {
            if (zb2.f().size() <= 1) continue;
            this.ai = zb2;
            return;
        }
    }

    public void render(DrawContext class_3322, int n, int n2, float f) {
        super.render(class_3322, n, n2, f);
        long l = System.currentTimeMillis();
        float f2 = Math.min((float)(l - this.bd) / 1000.0f, 0.1f);
        this.bd = l;
        if (this.bc) {
            this.bb -= f2 * 6.0f;
            if (this.bb <= 0.0f) {
                this.bb = 0.0f;
                if (this.client != null) {
                    this.client.setScreen(null);
                }
                return;
            }
        } else {
            this.bb += f2 * 6.0f;
            if (this.bb > 1.0f) {
                this.bb = 1.0f;
            }
        }
        float f3 = this.b(this.bb) * this.h();
        float f4 = this.bb;
        int n3 = this.width / 2;
        int n4 = this.height / 2;
        float f5 = (float)n3 - 380.0f;
        float f6 = (float)n4 - 230.0f;
        float f7 = this.a((float)n, n3, f3);
        float f8 = this.b((float)n2, n4, f3);
        if (this.bi != null && l - this.bj >= 3000L) {
            this.bi = null;
        }
        this.b(f2, f7, f8, f5, f6);
        boolean bl = com.vengeance.vengeanceclient.utils.w.r.za.a(class_3322);
        if (!bl && !com.vengeance.vengeanceclient.utils.w.r.za.f()) {
            this.a(class_3322);
            return;
        }
        com.vengeance.vengeanceclient.utils.w.r.za.k();
        com.vengeance.vengeanceclient.utils.w.r.za.a(n3, (float)n4);
        com.vengeance.vengeanceclient.utils.w.r.za.b(f3, f3);
        com.vengeance.vengeanceclient.utils.w.r.za.a(-n3, (float)(-n4));
        com.vengeance.vengeanceclient.utils.w.r.za.a(f5, f6, 760.0f, 460.0f, 12.0f, this.a(v, f4));
        com.vengeance.vengeanceclient.utils.w.r.za.a(f5, f6, 168.0f, 460.0f, 12.0f, 0.0f, 0.0f, 12.0f, this.a(w, f4));
        com.vengeance.vengeanceclient.utils.w.r.za.a(f5, f6, 760.0f, 460.0f, 12.0f, 1.0f, this.a(x, f4 * 0.8f));
        Color color = this.a(x, f4 * 0.6f);
        com.vengeance.vengeanceclient.utils.w.r.za.a(f5 + 168.0f, f6 + 1.0f, 1.0f, 458.0f, color);
        com.vengeance.vengeanceclient.utils.w.r.za.a(f5 + 168.0f + 236.0f, f6 + 1.0f, 1.0f, 458.0f, color);
        this.a(f5, f6, f7, f8, f4);
        this.c(f5 + 168.0f + 1.0f, f6, f7, f8, f4);
        this.d(f5 + 168.0f + 236.0f + 1.0f, f6, f7, f8, f4);
        if (this.aw != null) {
            this.a(f4);
        }
        com.vengeance.vengeanceclient.utils.w.r.za.l();
        com.vengeance.vengeanceclient.utils.w.r.za.e();
    }

    private void a(float f, float f2, float f3, float f4, float f5) {
        float f6 = 168.0f;
        Color color = com.vengeance.vengeanceclient.r.q.p.zb.n();
        float f7 = 50.0f;
        float f8 = f + (f6 - f7) / 2.0f;
        float f9 = f2 + 22.0f;
        com.vengeance.vengeanceclient.utils.w.r.za.a(f8, f9, f7, f7, 10.0f, this.a(new Color(color.getRed(), color.getGreen(), color.getBlue(), 40), f5));
        com.vengeance.vengeanceclient.utils.w.r.za.a(f8, f9, f7, f7, 10.0f, 1.5f, this.a(color, f5));
        this.g();
        this.a(f8, f9, f7, f5);
        com.vengeance.vengeanceclient.utils.w.r.za.a(f8 + f7 - 7.0f, f9 + f7 - 7.0f, 5.5f, this.a(new Color(26, 26, 36), f5));
        com.vengeance.vengeanceclient.utils.w.r.za.a(f8 + f7 - 7.0f, f9 + f7 - 7.0f, 4.0f, this.a(new Color(52, 210, 82), f5));
        String string = VengeanceClient.mc != null && VengeanceClient.mc.player != null ? VengeanceClient.mc.player.getName().getString() : "null";
        float f10 = f9 + f7 + 9.0f;
        com.vengeance.vengeanceclient.utils.w.r.za.a(string, f + (f6 - com.vengeance.vengeanceclient.utils.w.r.za.a(string, 11.5f)) / 2.0f, f10, 11.5f, this.a(y, f5), true);
        float f11 = f2 + 108.0f;
        this.a(f + 14.0f, f11, f6 - 28.0f, "Main", f5);
        za[] zaArray = new za[]{za.a, za.c, za.d, za.b, za.e};
        float f12 = f11 + 28.0f;
        for (za za2 : zaArray) {
            this.a(f, f12, f6, za2, f3, f4, f5);
            f12 += 36.0f;
        }
        this.a(f + 14.0f, f12 + 4.0f, f6 - 28.0f, "Other", f5);
        this.a(f, f12 += 36.0f, f6, za.f, f3, f4, f5);
        float f13 = 28.0f;
        float f14 = f2 + 460.0f - 44.0f;
        float f15 = (f6 - 28.0f - 5.0f) / 2.0f;
        boolean bl = f3 >= f + 14.0f && f3 <= f + 14.0f + f15 && f4 >= f14 && f4 <= f14 + f13;
        boolean bl2 = this.an;
        com.vengeance.vengeanceclient.utils.w.r.za.a(f + 14.0f, f14, f15, f13, 7.0f, this.a(bl2 ? new Color(color.getRed(), color.getGreen(), color.getBlue(), 40) : (bl ? new Color(36, 36, 52) : new Color(26, 26, 38)), f5));
        com.vengeance.vengeanceclient.utils.w.r.za.a(f + 14.0f, f14, f15, f13, 7.0f, 1.0f, this.a(bl2 ? color : x, f5 * (bl2 ? 1.0f : 0.7f)));
        String string2 = "Credits";
        com.vengeance.vengeanceclient.utils.w.r.za.a(string2, f + 14.0f + (f15 - com.vengeance.vengeanceclient.utils.w.r.za.a(string2, 9.5f)) / 2.0f, f14 + 10.0f, 9.5f, this.a(bl2 ? color : z, f5));
        float f16 = f + 14.0f + f15 + 5.0f;
        boolean bl3 = f3 >= f16 && f3 <= f16 + f15 && f4 >= f14 && f4 <= f14 + f13;
        boolean bl4 = this.ao;
        com.vengeance.vengeanceclient.utils.w.r.za.a(f16, f14, f15, f13, 7.0f, this.a(bl4 ? new Color(color.getRed(), color.getGreen(), color.getBlue(), 40) : (bl3 ? new Color(36, 36, 52) : new Color(26, 26, 38)), f5));
        com.vengeance.vengeanceclient.utils.w.r.za.a(f16, f14, f15, f13, 7.0f, 1.0f, this.a(bl4 ? color : x, f5 * (bl4 ? 1.0f : 0.7f)));
        String string3 = "Config";
        com.vengeance.vengeanceclient.utils.w.r.za.a(string3, f16 + (f15 - com.vengeance.vengeanceclient.utils.w.r.za.a(string3, 9.5f)) / 2.0f, f14 + 10.0f, 9.5f, this.a(bl4 ? color : z, f5));
    }

    private void a(float f, float f2, float f3, String string, float f4) {
        float f5 = com.vengeance.vengeanceclient.utils.w.r.za.a(string, 8.5f);
        float f6 = f2 + 7.0f;
        float f7 = 5.0f;
        float f8 = (f3 - f5 - f7 * 2.0f) / 2.0f;
        com.vengeance.vengeanceclient.utils.w.r.za.a(f, f6, f8, 1.0f, this.a(aa, f4 * 0.6f));
        com.vengeance.vengeanceclient.utils.w.r.za.a(string, f + f8 + f7, f2, 8.5f, this.a(z, f4 * 0.75f));
        com.vengeance.vengeanceclient.utils.w.r.za.a(f + f8 + f7 * 2.0f + f5, f6, f8, 1.0f, this.a(aa, f4 * 0.6f));
    }

    private void a(float f, float f2, float f3, za za2, float f4, float f5, float f6) {
        boolean bl = za2 == this.ah;
        Color color = com.vengeance.vengeanceclient.r.q.p.zb.n();
        float f7 = this.ba.getOrDefault((Object)za2, Float.valueOf(0.0f)).floatValue();
        if (bl) {
            com.vengeance.vengeanceclient.utils.w.r.za.a(f + 4.0f, f2 + 2.0f, f3 - 8.0f, 32.0f, this.a(new Color(color.getRed(), color.getGreen(), color.getBlue(), 28), f6));
            com.vengeance.vengeanceclient.utils.w.r.za.a(f + 4.0f, f2 + 9.0f, 3.0f, 18.0f, 1.5f, this.a(color, f6));
        } else if (f7 > 0.01f) {
            com.vengeance.vengeanceclient.utils.w.r.za.a(f + 4.0f, f2 + 2.0f, f3 - 8.0f, 32.0f, this.a(new Color(color.getRed(), color.getGreen(), color.getBlue(), (int)(15.0f * f7)), f6));
        }
        float f8 = 14.0f;
        zb.a(za2, f + 22.0f, f2 + (36.0f - f8) / 2.0f, this.a(bl ? color : z, f6));
        float f9 = f + 22.0f + f8 + 8.0f;
        float f10 = f2 + 13.0f;
        Color color2 = bl ? this.a(y, f6) : this.a(new Color(155, 155, 175), f6 * (0.6f + 0.4f * f7));
        com.vengeance.vengeanceclient.utils.w.r.za.a(za2.a(), f9, f10, 10.0f, color2, bl);
    }

    private void b(float f, float f2, float f3, float f4, float f5) {
        za[] zaArray = new za[]{za.a, za.c, za.d, za.b, za.e};
        float f6 = f5 + 108.0f + 28.0f;
        for (za za2 : zaArray) {
            boolean bl = za2 != this.ah && f2 >= f4 && f2 <= f4 + 168.0f && f3 >= f6 && f3 <= f6 + 36.0f;
            this.ba.put(za2, Float.valueOf(this.b(this.ba.getOrDefault((Object)za2, Float.valueOf(0.0f)).floatValue(), bl ? 1.0f : 0.0f, f * 12.0f)));
            f6 += 36.0f;
        }
        boolean bl = za.f != this.ah && f2 >= f4 && f2 <= f4 + 168.0f && f3 >= (f6 += 36.0f) && f3 <= f6 + 36.0f;
        this.ba.put(za.f, Float.valueOf(this.b(this.ba.getOrDefault((Object)za.f, Float.valueOf(0.0f)).floatValue(), bl ? 1.0f : 0.0f, f * 12.0f)));
    }

    private void c(float f, float f2, float f3, float f4, float f5) {
        float f6;
        float f7 = 235.0f;
        float f8 = f7 - 28.0f;
        float f9 = 26.0f;
        float f10 = f + 14.0f;
        float f11 = f2 + 54.0f - f9 - 8.0f;
        Color color = this.ak ? this.a(com.vengeance.vengeanceclient.r.q.p.zb.n(), f5) : this.a(x, f5 * 0.7f);
        com.vengeance.vengeanceclient.utils.w.r.za.a(f10, f11, f8, f9, 6.0f, this.a(af, f5));
        com.vengeance.vengeanceclient.utils.w.r.za.a(f10, f11, f8, f9, 6.0f, 1.0f, color);
        Color color2 = this.a(z, f5 * 0.9f);
        com.vengeance.vengeanceclient.utils.w.r.za.a(f10 + 11.0f, f11 + f9 / 2.0f - 1.0f, 4.5f, color2);
        com.vengeance.vengeanceclient.utils.w.r.za.a(f10 + 11.0f, f11 + f9 / 2.0f - 1.0f, 2.8f, this.a(af, f5));
        com.vengeance.vengeanceclient.utils.w.r.za.b(f10 + 14.0f, f11 + f9 / 2.0f + 2.0f, f10 + 17.0f, f11 + f9 / 2.0f + 5.0f, 1.5f, color2);
        String string = this.aj.isEmpty() ? "Search Modules..." : this.aj;
        com.vengeance.vengeanceclient.utils.w.r.za.a(string, f10 + 23.0f, f11 + 9.0f, 9.5f, this.aj.isEmpty() ? this.a(z, f5 * 0.65f) : this.a(y, f5));
        if (this.ak && System.currentTimeMillis() % 1000L < 500L) {
            f6 = f10 + 23.0f + com.vengeance.vengeanceclient.utils.w.r.za.a(this.aj, 9.5f);
            com.vengeance.vengeanceclient.utils.w.r.za.a(f6, f11 + 6.0f, 1.2f, 14.0f, this.a(y, f5));
        }
        com.vengeance.vengeanceclient.utils.w.r.za.a(f, f2 + 54.0f, f7, 1.0f, this.a(x, f5 * 0.5f));
        f6 = f2 + 54.0f + 1.0f;
        float f12 = 405.0f;
        com.vengeance.vengeanceclient.utils.w.r.za.a(f, f6, f7, f12);
        List<com.vengeance.vengeanceclient.r.zb> list = this.b();
        float f13 = list.size() * 44;
        this.al = this.c(this.al, 0.0f, Math.max(0.0f, f13 - f12));
        float f14 = f6 - this.al;
        for (com.vengeance.vengeanceclient.r.zb zb2 : list) {
            this.a(zb2, f, f14, f7, f3, f4, f5);
            f14 += 44.0f;
        }
        com.vengeance.vengeanceclient.utils.w.r.za.m();
        if (f13 > f12) {
            float f15 = f12 / f13 * f12;
            float f16 = f6 + this.al / f13 * f12;
            com.vengeance.vengeanceclient.utils.w.r.za.a(f + f7 - 4.0f, f16, 3.0f, f15, 1.5f, this.a(com.vengeance.vengeanceclient.r.q.p.zb.n(), f5 * 0.45f));
        }
    }

    private void a(com.vengeance.vengeanceclient.r.zb zb2, float f, float f2, float f3, float f4, float f5, float f6) {
        boolean bl = f4 >= f && f4 <= f + f3 && f5 >= f2 && f5 <= f2 + 44.0f;
        boolean bl2 = zb2 == this.ai;
        boolean bl3 = zb2.l();
        Color color = com.vengeance.vengeanceclient.r.q.p.zb.n();
        if (bl2) {
            com.vengeance.vengeanceclient.utils.w.r.za.a(f, f2, f3, 44.0f, this.a(new Color(color.getRed(), color.getGreen(), color.getBlue(), 18), f6));
        } else if (bl) {
            com.vengeance.vengeanceclient.utils.w.r.za.a(f, f2, f3, 44.0f, this.a(ab, f6 * 0.5f));
        }
        if (bl3) {
            com.vengeance.vengeanceclient.utils.w.r.za.a(f, f2 + 6.0f, 3.0f, 32.0f, 1.5f, this.a(color, f6));
        }
        com.vengeance.vengeanceclient.utils.w.r.za.a(f + 14.0f, f2 + 44.0f - 1.0f, f3 - 28.0f, 1.0f, this.a(x, f6 * 0.3f));
        Color color2 = bl3 ? this.a(y, f6) : this.a(new Color(155, 155, 175), f6 * 0.75f);
        com.vengeance.vengeanceclient.utils.w.r.za.a(zb2.i(), f + 14.0f + 4.0f, f2 + 10.0f, 11.0f, color2);
        if (zb2.j() != null && !zb2.j().isEmpty()) {
            String string = this.a(zb2.j(), f3 - 42.0f - 50.0f, 8.5f);
            com.vengeance.vengeanceclient.utils.w.r.za.a(string, f + 14.0f + 4.0f, f2 + 25.0f, 8.5f, this.a(z, f6 * 0.65f));
        }
        float f7 = 22.0f;
        float f8 = 11.0f;
        float f9 = f + f3 - 14.0f - f7 - 16.0f;
        float f10 = f2 + (44.0f - f8) / 2.0f;
        this.a(f9, f10, f7, f8, bl3, f6, color);
        float f11 = f + f3 - 14.0f - 11.0f;
        Color color3 = bl ? this.a(y, f6) : this.a(z, f6 * 0.55f);
        com.vengeance.vengeanceclient.utils.w.r.za.a("...", f11, f2 + 17.0f, 10.0f, color3);
    }

    private void a(float f, float f2, float f3, float f4, boolean bl, float f5, Color color) {
        com.vengeance.vengeanceclient.utils.w.r.za.a(f, f2, f3, f4, f4 / 2.0f, bl ? this.a(color, f5) : this.a(ad, f5));
        float f6 = f4 / 2.0f - 1.5f;
        float f7 = bl ? f + f3 - f6 - 2.5f : f + f6 + 2.5f;
        com.vengeance.vengeanceclient.utils.w.r.za.a(f7, f2 + f4 / 2.0f, f6, this.a(Color.WHITE, f5));
    }

    private List<com.vengeance.vengeanceclient.r.zb> b() {
        List<com.vengeance.vengeanceclient.r.zb> list = VengeanceClient.INSTANCE.getModuleManager().b(this.ah);
        if (this.aj.isEmpty()) {
            return list;
        }
        String string = this.aj.toLowerCase();
        return list.stream().filter(zb2 -> zb2.i().toLowerCase().contains(string)).collect(Collectors.toList());
    }

    private void d(float f, float f2, float f3, float f4, float f5) {
        float f6;
        float f7;
        float f8;
        float f9;
        if (this.an) {
            this.a(f, f2, f5);
            return;
        }
        if (this.ao) {
            this.e(f, f2, f3, f4, f5);
            return;
        }
        float f10 = 355.0f;
        if (this.ai == null) {
            String string = "Select a module for settings";
            com.vengeance.vengeanceclient.utils.w.r.za.a(string, f + (f10 - com.vengeance.vengeanceclient.utils.w.r.za.a(string, 10.0f)) / 2.0f, f2 + 230.0f, 10.0f, this.a(z, f5 * 0.45f));
            return;
        }
        Color color = com.vengeance.vengeanceclient.r.q.p.zb.n();
        com.vengeance.vengeanceclient.utils.w.r.za.a(f, f2, f10, 58.0f, this.a(new Color(28, 28, 40), f5 * 0.55f));
        com.vengeance.vengeanceclient.utils.w.r.za.a(this.ai.i(), f + 14.0f, f2 + 22.0f, 16.0f, this.a(y, f5), true);
        if (this.ai.l()) {
            f9 = com.vengeance.vengeanceclient.utils.w.r.za.a("ENABLED", 8.0f) + 14.0f;
            f8 = 17.0f;
            f7 = f + f10 - 14.0f - f9;
            f6 = f2 + (58.0f - f8) / 2.0f;
            com.vengeance.vengeanceclient.utils.w.r.za.a(f7, f6, f9, f8, f8 / 2.0f, this.a(new Color(color.getRed(), color.getGreen(), color.getBlue(), 40), f5));
            com.vengeance.vengeanceclient.utils.w.r.za.a(f7, f6, f9, f8, f8 / 2.0f, 1.0f, this.a(color, f5 * 0.55f));
            com.vengeance.vengeanceclient.utils.w.r.za.a("ENABLED", f7 + 7.0f, f6 + (f8 - 8.0f) / 2.0f, 8.0f, this.a(color, f5));
        }
        com.vengeance.vengeanceclient.utils.w.r.za.a(f, f2 + 58.0f, f10, 1.0f, this.a(x, f5 * 0.5f));
        f9 = f2 + 58.0f + 1.0f;
        f8 = 401.0f;
        f7 = this.e();
        this.am = this.c(this.am, 0.0f, Math.max(0.0f, f7 - f8));
        com.vengeance.vengeanceclient.utils.w.r.za.a(f, f9, f10, f8);
        f6 = f9 + 8.0f - this.am;
        for (zg zg2 : this.ai.f()) {
            float f11 = this.a(zg2);
            if (f6 + f11 > f9 - 5.0f && f6 < f9 + f8 + 5.0f) {
                this.a(zg2, f + 14.0f, f6, f10 - 28.0f, f3, f4, f5, color);
            }
            f6 += f11;
        }
        com.vengeance.vengeanceclient.utils.w.r.za.m();
        if (f7 > f8) {
            float f12 = f8 / f7 * f8;
            float f13 = f9 + this.am / f7 * f8;
            com.vengeance.vengeanceclient.utils.w.r.za.a(f + f10 - 4.0f, f13, 3.0f, f12, 1.5f, this.a(color, f5 * 0.45f));
        }
    }

    private void a(float f, float f2, float f3) {
        float f4 = 355.0f;
        Color color = com.vengeance.vengeanceclient.r.q.p.zb.n();
        com.vengeance.vengeanceclient.utils.w.r.za.a(f + f4 / 2.0f - 28.0f, f2 + 18.0f, 56.0f, 3.0f, 1.5f, this.a(color, f3 * 0.55f));
        String string = "Vengeance Client Client";
        com.vengeance.vengeanceclient.utils.w.r.za.a(string, f + (f4 - com.vengeance.vengeanceclient.utils.w.r.za.a(string, 18.0f, true)) / 2.0f, f2 + 36.0f, 18.0f, this.a(y, f3), true);
        String string2 = "v1.0.0";
        com.vengeance.vengeanceclient.utils.w.r.za.a(string2, f + (f4 - com.vengeance.vengeanceclient.utils.w.r.za.a(string2, 9.5f)) / 2.0f, f2 + 58.0f, 9.5f, this.a(z, f3 * 0.7f));
        float f5 = f2 + 86.0f;
        this.a(f + 14.0f, f5, f4 - 28.0f, "Developers", f3);
        this.a(f, f5 += 34.0f, f4, "Vengeance Client / 3xecutablefile", "Lead Developer", f3, color);
    }

    private void a(float f, float f2, float f3, String string, String string2, float f4, Color color) {
        com.vengeance.vengeanceclient.utils.w.r.za.a(f + 14.0f + 4.0f, f2 + 9.0f, 3.0f, this.a(color, f4 * 0.75f));
        com.vengeance.vengeanceclient.utils.w.r.za.a(string, f + 14.0f + 14.0f, f2 + 4.0f, 11.0f, this.a(y, f4), true);
        com.vengeance.vengeanceclient.utils.w.r.za.a(string2, f + 14.0f + 14.0f, f2 + 19.0f, 9.0f, this.a(z, f4 * 0.65f));
    }

    private void e(float f, float f2, float f3, float f4, float f5) {
        float f6;
        float f7;
        float f8 = 355.0f;
        Color color = com.vengeance.vengeanceclient.r.q.p.zb.n();
        com.vengeance.vengeanceclient.utils.w.r.za.a(f, f2, f8, 58.0f, this.a(new Color(28, 28, 40), f5 * 0.55f));
        com.vengeance.vengeanceclient.utils.w.r.za.a("Profiles", f + 14.0f, f2 + 22.0f, 16.0f, this.a(y, f5), true);
        float f9 = 22.0f;
        float f10 = 42.0f;
        float f11 = f + f8 - 14.0f - f10;
        float f12 = f2 + (58.0f - f9) / 2.0f;
        boolean bl = f3 >= f11 && f3 <= f11 + f10 && f4 >= f12 && f4 <= f12 + f9;
        com.vengeance.vengeanceclient.utils.w.r.za.a(f11, f12, f10, f9, 5.0f, this.a(bl ? new Color(color.getRed(), color.getGreen(), color.getBlue(), 50) : new Color(28, 28, 42), f5));
        com.vengeance.vengeanceclient.utils.w.r.za.a(f11, f12, f10, f9, 5.0f, 1.0f, this.a(bl ? color : x, f5 * (bl ? 1.0f : 0.7f)));
        String string = "Save";
        com.vengeance.vengeanceclient.utils.w.r.za.a(string, f11 + (f10 - com.vengeance.vengeanceclient.utils.w.r.za.a(string, 9.0f)) / 2.0f, f12 + 7.0f, 9.0f, this.a(bl ? color : z, f5));
        if (this.bh != null) {
            f7 = f11 - 6.0f - f10;
            f6 = f12;
            boolean bl2 = f3 >= f7 && f3 <= f7 + f10 && f4 >= f6 && f4 <= f6 + f9;
            com.vengeance.vengeanceclient.utils.w.r.za.a(f7, f6, f10, f9, 5.0f, this.a(bl2 ? new Color(color.getRed(), color.getGreen(), color.getBlue(), 50) : new Color(28, 28, 42), f5));
            com.vengeance.vengeanceclient.utils.w.r.za.a(f7, f6, f10, f9, 5.0f, 1.0f, this.a(bl2 ? color : x, f5 * (bl2 ? 1.0f : 0.7f)));
            String string2 = "Load";
            com.vengeance.vengeanceclient.utils.w.r.za.a(string2, f7 + (f10 - com.vengeance.vengeanceclient.utils.w.r.za.a(string2, 9.0f)) / 2.0f, f6 + 7.0f, 9.0f, this.a(bl2 ? color : z, f5));
        }
        com.vengeance.vengeanceclient.utils.w.r.za.a(f, f2 + 58.0f, f8, 1.0f, this.a(x, f5 * 0.5f));
        f7 = f2 + 58.0f + 1.0f;
        f6 = 401.0f;
        float f13 = (this.bg.size() + 1) * 44;
        this.bm = this.c(this.bm, 0.0f, Math.max(0.0f, f13 - f6));
        com.vengeance.vengeanceclient.utils.w.r.za.a(f, f7, f8, f6);
        float f14 = f7 - this.bm;
        for (String string3 : this.bg) {
            this.a(string3, f, f14, f8, f3, f4, f5, color);
            f14 += 44.0f;
        }
        this.a(f, f14, f8, f3, f4, f5, color);
        com.vengeance.vengeanceclient.utils.w.r.za.m();
        if (f13 > f6) {
            float f15 = f6 / f13 * f6;
            float f16 = f7 + this.bm / f13 * f6;
            com.vengeance.vengeanceclient.utils.w.r.za.a(f + f8 - 4.0f, f16, 3.0f, f15, 1.5f, this.a(color, f5 * 0.45f));
        }
    }

    private void a(String string, float f, float f2, float f3, float f4, float f5, float f6, Color color) {
        boolean bl = f4 >= f && f4 <= f + f3 && f5 >= f2 && f5 <= f2 + 44.0f;
        boolean bl2 = string.equals(this.bh);
        boolean bl3 = string.equals(this.bi);
        if (bl3) {
            com.vengeance.vengeanceclient.utils.w.r.za.a(f, f2, f3, 44.0f, this.a(new Color(160, 40, 40, 60), f6));
        } else if (bl2) {
            com.vengeance.vengeanceclient.utils.w.r.za.a(f, f2, f3, 44.0f, this.a(new Color(color.getRed(), color.getGreen(), color.getBlue(), 20), f6));
            com.vengeance.vengeanceclient.utils.w.r.za.a(f, f2 + 6.0f, 3.0f, 32.0f, 1.5f, this.a(color, f6));
        } else if (bl) {
            com.vengeance.vengeanceclient.utils.w.r.za.a(f, f2, f3, 44.0f, this.a(ab, f6 * 0.5f));
        }
        com.vengeance.vengeanceclient.utils.w.r.za.a(f + 14.0f, f2 + 44.0f - 1.0f, f3 - 28.0f, 1.0f, this.a(x, f6 * 0.3f));
        if (bl3) {
            String string2 = "Delete?";
            com.vengeance.vengeanceclient.utils.w.r.za.a(string2, f + 14.0f + 4.0f, f2 + 10.0f, 11.0f, this.a(new Color(255, 100, 100), f6), true);
            com.vengeance.vengeanceclient.utils.w.r.za.a("Right-click again to confirm", f + 14.0f + 4.0f, f2 + 26.0f, 8.0f, this.a(new Color(200, 80, 80), f6 * 0.75f));
        } else {
            Color color2 = bl2 ? this.a(y, f6) : this.a(new Color(155, 155, 175), f6 * 0.85f);
            com.vengeance.vengeanceclient.utils.w.r.za.a(string, f + 14.0f + 4.0f, f2 + 10.0f, 11.0f, color2, bl2);
        }
    }

    private void a(float f, float f2, float f3, float f4, float f5, float f6, Color color) {
        boolean bl;
        boolean bl2 = bl = f4 >= f && f4 <= f + f3 && f5 >= f2 && f5 <= f2 + 44.0f;
        if (bl || this.bk) {
            com.vengeance.vengeanceclient.utils.w.r.za.a(f, f2, f3, 44.0f, this.a(new Color(color.getRed(), color.getGreen(), color.getBlue(), this.bk ? 18 : 10), f6));
        }
        com.vengeance.vengeanceclient.utils.w.r.za.a(f + 14.0f, f2 + 44.0f - 1.0f, f3 - 28.0f, 1.0f, this.a(x, f6 * 0.3f));
        if (this.bk) {
            com.vengeance.vengeanceclient.utils.w.r.za.a(this.bl, f + 14.0f + 4.0f, f2 + 10.0f, 11.0f, this.a(y, f6));
            if (System.currentTimeMillis() % 1000L < 500L) {
                float f7 = f + 14.0f + 4.0f + com.vengeance.vengeanceclient.utils.w.r.za.a(this.bl, 11.0f);
                com.vengeance.vengeanceclient.utils.w.r.za.a(f7, f2 + 8.0f, 1.2f, 14.0f, this.a(y, f6));
            }
            com.vengeance.vengeanceclient.utils.w.r.za.a("Enter to save | Esc to cancel", f + 14.0f + 4.0f, f2 + 27.0f, 8.0f, this.a(z, f6 * 0.6f));
        } else {
            com.vengeance.vengeanceclient.utils.w.r.za.a("+ New Profile", f + 14.0f + 4.0f, f2 + 10.0f, 11.0f, this.a(bl ? color : z, f6 * (bl ? 0.9f : 0.55f)));
        }
    }

    private void c() {
        this.bg.clear();
        com.vengeance.vengeanceclient.s.za za2 = VengeanceClient.INSTANCE.getProfileManager();
        if (za2 == null) {
            return;
        }
        File file3 = za2.b();
        if (!file3.exists() || !file3.isDirectory()) {
            return;
        }
        File[] fileArray = file3.listFiles((file, string) -> string.endsWith(".json"));
        if (fileArray == null) {
            return;
        }
        Arrays.sort(fileArray, (file, file2) -> Long.compare(file2.lastModified(), file.lastModified()));
        for (File file4 : fileArray) {
            this.bg.add(file4.getName().replace(".json", ""));
        }
    }

    private void d() {
        this.bk = false;
        this.bl = "";
    }

    private float e() {
        if (this.ai == null) {
            return 0.0f;
        }
        float f = 8.0f;
        for (zg zg2 : this.ai.f()) {
            f += this.a(zg2);
        }
        return f + 8.0f;
    }

    private float a(zg zg2) {
        if (zg2 instanceof com.vengeance.vengeanceclient.r.r.za) {
            return 50.0f;
        }
        if (zg2 instanceof ze) {
            return 54.0f;
        }
        if (zg2 instanceof zd) {
            return 50.0f;
        }
        if (zg2 instanceof zf) {
            return 58.0f;
        }
        if (zg2 instanceof com.vengeance.vengeanceclient.r.r.zb) {
            return 40.0f;
        }
        if (zg2 instanceof com.vengeance.vengeanceclient.r.r.zc) {
            return 44.0f;
        }
        return 36.0f;
    }

    private void a(zg zg2, float f, float f2, float f3, float f4, float f5, float f6, Color color) {
        com.vengeance.vengeanceclient.utils.w.r.za.a(f - 4.0f, f2, f3 + 8.0f, this.a(zg2) - 2.0f, this.a(ac, f6 * 0.38f));
        if (zg2 instanceof com.vengeance.vengeanceclient.r.r.za) {
            com.vengeance.vengeanceclient.r.r.za za2 = (com.vengeance.vengeanceclient.r.r.za)zg2;
            this.a(za2, f, f2, f3, f6, color);
        } else if (zg2 instanceof ze) {
            ze ze2 = (ze)zg2;
            this.a(ze2, f, f2, f3, f6, color);
        } else if (zg2 instanceof zd) {
            zd zd2 = (zd)zg2;
            this.a(zd2, f, f2, f3, f6, color);
        } else if (zg2 instanceof zf) {
            zf zf2 = (zf)zg2;
            this.a(zf2, f, f2, f3, f6, color);
        } else if (zg2 instanceof com.vengeance.vengeanceclient.r.r.zb) {
            com.vengeance.vengeanceclient.r.r.zb zb2 = (com.vengeance.vengeanceclient.r.r.zb)zg2;
            this.a(zb2, f, f2, f3, f6, color);
        } else if (zg2 instanceof com.vengeance.vengeanceclient.r.r.zc) {
            com.vengeance.vengeanceclient.r.r.zc zc2 = (com.vengeance.vengeanceclient.r.r.zc)zg2;
            this.a(zc2, f, f2, f3, f6, color);
        } else {
            com.vengeance.vengeanceclient.utils.w.r.za.a(zg2.i(), f, f2 + 14.0f, 10.0f, this.a(y, f6));
        }
        com.vengeance.vengeanceclient.utils.w.r.za.a(f - 4.0f, f2 + this.a(zg2) - 2.0f, f3 + 8.0f, 1.0f, this.a(x, f6 * 0.28f));
    }

    private void a(com.vengeance.vengeanceclient.r.r.za za2, float f, float f2, float f3, float f4, Color color) {
        com.vengeance.vengeanceclient.utils.w.r.za.a(za2.i(), f, f2 + 14.0f, 11.0f, this.a(y, f4));
        float f5 = com.vengeance.vengeanceclient.r.q.p.zb.v();
        float f6 = com.vengeance.vengeanceclient.r.q.p.zb.w();
        float f7 = f + f3 - f5;
        float f8 = f2 + (50.0f - f6) / 2.0f;
        com.vengeance.vengeanceclient.utils.w.r.za.a(f7, f8, f5, f6, f6 / 2.0f, za2.b() ? this.a(color, f4) : this.a(ad, f4));
        float f9 = f6 / 2.0f - 1.5f;
        float f10 = za2.b() ? f7 + f5 - f9 - 2.0f : f7 + f9 + 2.0f;
        com.vengeance.vengeanceclient.utils.w.r.za.a(f10, f8 + f6 / 2.0f, f9, this.a(Color.WHITE, f4));
    }

    private void a(ze ze2, float f, float f2, float f3, float f4, Color color) {
        com.vengeance.vengeanceclient.utils.w.r.za.a(ze2.i(), f, f2 + 12.0f, 11.0f, this.a(y, f4));
        double d = ze2.f();
        String string = d % 1.0 == 0.0 ? String.valueOf((long)d) : String.format("%.2f", d);
        com.vengeance.vengeanceclient.utils.w.r.za.a(string, f + f3 - com.vengeance.vengeanceclient.utils.w.r.za.a(string, 9.5f), f2 + 12.0f, 9.5f, this.a(z, f4));
        float f5 = com.vengeance.vengeanceclient.r.q.p.zb.x();
        float f6 = com.vengeance.vengeanceclient.r.q.p.zb.y();
        float f7 = f2 + 32.0f;
        float f8 = f;
        com.vengeance.vengeanceclient.utils.w.r.za.a(f8, f7 + f6 - f5 / 2.0f, f3, f5, f5 / 2.0f, this.a(ae, f4));
        double d2 = ze2.d() - ze2.c();
        float f9 = d2 > 0.0 ? (float)((d - ze2.c()) / d2) : 0.0f;
        float f10 = f9 * f3;
        if (f10 > f5) {
            com.vengeance.vengeanceclient.utils.w.r.za.a(f8, f7 + f6 - f5 / 2.0f, f10, f5, f5 / 2.0f, this.a(color, f4));
        }
        com.vengeance.vengeanceclient.utils.w.r.za.a(f8 + f10, f7 + f6, f6, this.a(Color.WHITE, f4));
        com.vengeance.vengeanceclient.utils.w.r.za.a(f8 + f10, f7 + f6, f6 - 2.0f, this.a(color, f4));
    }

    private void a(zd zd2, float f, float f2, float f3, float f4, Color color) {
        com.vengeance.vengeanceclient.utils.w.r.za.a(zd2.i(), f, f2 + 15.0f, 11.0f, this.a(y, f4));
        boolean bl = zd2 == this.aw;
        String string = zd2.a();
        float f5 = Math.max(80.0f, Math.min(f3 * 0.52f, com.vengeance.vengeanceclient.utils.w.r.za.a(string, 9.5f) + 24.0f));
        float f6 = 22.0f;
        float f7 = f + f3 - f5;
        float f8 = f2 + (50.0f - f6) / 2.0f;
        Color color2 = bl ? this.a(new Color(42, 42, 58), f4) : this.a(af, f4);
        Color color3 = bl ? this.a(color, f4) : this.a(x, f4 * 0.8f);
        com.vengeance.vengeanceclient.utils.w.r.za.a(f7, f8, f5, f6, 5.0f, color2);
        com.vengeance.vengeanceclient.utils.w.r.za.a(f7, f8, f5, f6, 5.0f, 1.0f, color3);
        com.vengeance.vengeanceclient.utils.w.r.za.a(string, f7 + 8.0f, f8 + 7.0f, 9.5f, this.a(y, f4));
        this.a(f7 + f5 - 12.0f, f8 + f6 / 2.0f, bl, f4);
        if (bl) {
            this.ax = f7;
            this.ay = f8 + f6;
            this.az = f5;
        }
    }

    private void a(zf zf2, float f, float f2, float f3, float f4, Color color) {
        com.vengeance.vengeanceclient.utils.w.r.za.a(zf2.i(), f, f2 + 12.0f, 11.0f, this.a(y, f4));
        String string = String.format("%.1f - %.1f", zf2.c(), zf2.d());
        com.vengeance.vengeanceclient.utils.w.r.za.a(string, f + f3 - com.vengeance.vengeanceclient.utils.w.r.za.a(string, 9.0f), f2 + 12.0f, 9.0f, this.a(z, f4));
        float f5 = com.vengeance.vengeanceclient.r.q.p.zb.x();
        float f6 = com.vengeance.vengeanceclient.r.q.p.zb.y();
        float f7 = f2 + 34.0f;
        float f8 = f;
        com.vengeance.vengeanceclient.utils.w.r.za.a(f8, f7 + f6 - f5 / 2.0f, f3, f5, f5 / 2.0f, this.a(ae, f4));
        double d = zf2.b() - zf2.a();
        float f9 = d > 0.0 ? (float)((zf2.c() - zf2.a()) / d) : 0.0f;
        float f10 = d > 0.0 ? (float)((zf2.d() - zf2.a()) / d) : 1.0f;
        float f11 = f8 + f9 * f3;
        float f12 = (f10 - f9) * f3;
        if (f12 > 0.0f) {
            com.vengeance.vengeanceclient.utils.w.r.za.a(f11, f7 + f6 - f5 / 2.0f, f12, f5, f5 / 2.0f, this.a(color, f4));
        }
        com.vengeance.vengeanceclient.utils.w.r.za.a(f8 + f9 * f3, f7 + f6, f6, this.a(Color.WHITE, f4));
        com.vengeance.vengeanceclient.utils.w.r.za.a(f8 + f9 * f3, f7 + f6, f6 - 2.0f, this.a(color, f4));
        com.vengeance.vengeanceclient.utils.w.r.za.a(f8 + f10 * f3, f7 + f6, f6, this.a(Color.WHITE, f4));
        com.vengeance.vengeanceclient.utils.w.r.za.a(f8 + f10 * f3, f7 + f6, f6 - 2.0f, this.a(color, f4));
    }

    private void a(com.vengeance.vengeanceclient.r.r.zb zb2, float f, float f2, float f3, float f4, Color color) {
        com.vengeance.vengeanceclient.utils.w.r.za.a(zb2.i(), f, f2 + 14.0f, 11.0f, this.a(y, f4));
        float f5 = 18.0f;
        float f6 = f + f3 - f5;
        float f7 = f2 + (40.0f - f5) / 2.0f;
        com.vengeance.vengeanceclient.utils.w.r.za.a(f6, f7, f5, f5, 4.0f, this.a(zb2.h(), f4));
        com.vengeance.vengeanceclient.utils.w.r.za.a(f6, f7, f5, f5, 4.0f, 1.0f, this.a(x, f4));
    }

    private void a(com.vengeance.vengeanceclient.r.r.zc zc2, float f, float f2, float f3, float f4, Color color) {
        com.vengeance.vengeanceclient.utils.w.r.za.a(zc2.i(), f, f2 + 15.0f, 11.0f, this.a(y, f4));
        boolean bl = zc2.f();
        String string = bl ? "Press key..." : this.a(zc2.e());
        float f5 = Math.max(70.0f, com.vengeance.vengeanceclient.utils.w.r.za.a(string, 9.0f) + 20.0f);
        float f6 = 22.0f;
        float f7 = f + f3 - f5;
        float f8 = f2 + (44.0f - f6) / 2.0f;
        com.vengeance.vengeanceclient.utils.w.r.za.a(f7, f8, f5, f6, 5.0f, bl ? this.a(new Color(42, 42, 58), f4) : this.a(af, f4));
        com.vengeance.vengeanceclient.utils.w.r.za.a(f7, f8, f5, f6, 5.0f, 1.0f, bl ? this.a(color, f4) : this.a(x, f4 * 0.8f));
        com.vengeance.vengeanceclient.utils.w.r.za.a(string, f7 + (f5 - com.vengeance.vengeanceclient.utils.w.r.za.a(string, 9.0f)) / 2.0f, f8 + 7.0f, 9.0f, bl ? this.a(color, f4) : this.a(y, f4 * 0.9f));
    }

    private String a(int n) {
        int n2;
        if (n <= -100 && (n2 = -100 - n) >= 0 && n2 <= 7) {
            return "M" + (n2 + 1);
        }
        if (n < -1 && (n2 = -(n + 1)) >= 0 && n2 <= 7) {
            return "M" + (n2 + 1);
        }
        if (n >= 1 && n <= 7) {
            return "M" + (n + 1);
        }
        if (n == -1 || n == 0) {
            return "NONE";
        }
        String string = GLFW.glfwGetKeyName((int)n, (int)0);
        if (string != null && !string.isBlank()) {
            return string.toUpperCase();
        }
        return switch (n) {
            case 32 -> "SPACE";
            case 256 -> "ESC";
            case 257 -> "ENTER";
            case 258 -> "TAB";
            case 259 -> "BKSP";
            case 340, 344 -> "SHIFT";
            case 341, 345 -> "CTRL";
            case 342, 346 -> "ALT";
            case 290 -> "F1";
            case 291 -> "F2";
            case 292 -> "F3";
            case 293 -> "F4";
            case 294 -> "F5";
            case 295 -> "F6";
            case 296 -> "F7";
            case 297 -> "F8";
            case 298 -> "F9";
            case 299 -> "F10";
            case 300 -> "F11";
            case 301 -> "F12";
            default -> "K" + n;
        };
    }

    private boolean b(int n) {
        if (n < 0 || n > 7) {
            return false;
        }
        com.vengeance.vengeanceclient.r.r.zc zc2 = this.f();
        if (zc2 == null) {
            return false;
        }
        zc2.a(-100 - n);
        zc2.a(false);
        return true;
    }

    private com.vengeance.vengeanceclient.r.r.zc f() {
        if (this.ai == null) {
            return null;
        }
        for (zg zg2 : this.ai.f()) {
            com.vengeance.vengeanceclient.r.r.zc zc2;
            if (!(zg2 instanceof com.vengeance.vengeanceclient.r.r.zc) || !(zc2 = (com.vengeance.vengeanceclient.r.r.zc)zg2).f()) continue;
            return zc2;
        }
        return null;
    }

    private void a(float f) {
        List<String> list = this.aw.c();
        float f2 = 22.0f;
        float f3 = (float)list.size() * f2 + 4.0f;
        Color color = com.vengeance.vengeanceclient.r.q.p.zb.n();
        com.vengeance.vengeanceclient.utils.w.r.za.a(this.ax, this.ay, this.az, f3, 5.0f, this.a(ag, f));
        com.vengeance.vengeanceclient.utils.w.r.za.a(this.ax, this.ay, this.az, f3, 5.0f, 1.0f, this.a(x, f));
        float f4 = this.ay + 2.0f;
        for (String string : list) {
            boolean bl = string.equals(this.aw.a());
            if (bl) {
                com.vengeance.vengeanceclient.utils.w.r.za.a(this.ax + 2.0f, f4, this.az - 4.0f, f2 - 2.0f, 4.0f, this.a(new Color(color.getRed(), color.getGreen(), color.getBlue(), 55), f));
            }
            com.vengeance.vengeanceclient.utils.w.r.za.a(string, this.ax + 8.0f, f4 + 7.0f, 9.5f, bl ? this.a(color, f) : this.a(y, f * 0.85f));
            f4 += f2;
        }
    }

    private void a(float f, float f2, boolean bl, float f3) {
        float f4 = 3.5f;
        Color color = this.a(z, f3);
        if (bl) {
            com.vengeance.vengeanceclient.utils.w.r.za.b(f - f4, f2 + f4 * 0.5f, f, f2 - f4 * 0.5f, 1.3f, color);
            com.vengeance.vengeanceclient.utils.w.r.za.b(f, f2 - f4 * 0.5f, f + f4, f2 + f4 * 0.5f, 1.3f, color);
        } else {
            com.vengeance.vengeanceclient.utils.w.r.za.b(f - f4, f2 - f4 * 0.5f, f, f2 + f4 * 0.5f, 1.3f, color);
            com.vengeance.vengeanceclient.utils.w.r.za.b(f, f2 + f4 * 0.5f, f + f4, f2 - f4 * 0.5f, 1.3f, color);
        }
    }

    private void g() {
        try {
            String string;
            if (this.client == null || this.client.player == null) {
                return;
            }
            Identifier class_29602 = null;
            net.minecraft.client.network.PlayerListEntry entry;
            if (this.client.getNetworkHandler() != null && (entry = this.client.getNetworkHandler().getPlayerListEntry(this.client.player.getUuid())) != null && entry.getSkinTextures() != null && entry.getSkinTextures().body() != null) {
                class_29602 = entry.getSkinTextures().body().texturePath();
            }
            if (class_29602 == null) {
                class_29602 = DefaultSkinHelper.getSkinTextures((UUID)this.client.player.getUuid()).body().texturePath();
            }
            if (class_29602 == null) {
                return;
            }
            string = class_29602.toString();
            if (!string.equals(bf)) {
                if (be != -1) {
                    com.vengeance.vengeanceclient.utils.w.r.za.a(be);
                }
                be = com.vengeance.vengeanceclient.utils.w.r.za.a(string);
                bf = string;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private void a(float f, float f2, float f3, float f4) {
        if (be == -1) {
            return;
        }
        float f5 = 3.0f;
        float f6 = f + f5;
        float f7 = f2 + f5;
        float f8 = f3 - f5 * 2.0f;
        Color color = this.a(Color.WHITE, f4);
        com.vengeance.vengeanceclient.utils.w.r.za.k();
        com.vengeance.vengeanceclient.utils.w.r.za.a(f6, f7, f8, f8);
        com.vengeance.vengeanceclient.utils.w.r.za.a(be, 8.0f, 8.0f, 8.0f, 8.0f, 64.0f, 64.0f, f6, f7, f8, f8, color);
        com.vengeance.vengeanceclient.utils.w.r.za.a(be, 40.0f, 8.0f, 8.0f, 8.0f, 64.0f, 64.0f, f6, f7, f8, f8, color);
        com.vengeance.vengeanceclient.utils.w.r.za.m();
        com.vengeance.vengeanceclient.utils.w.r.za.l();
    }

    public boolean mouseClicked(Click class_119092, boolean bl) {
        double d = class_119092.x();
        double d2 = class_119092.y();
        int n = class_119092.button();
        float f = this.b(this.bb) * this.h();
        int n2 = this.width / 2;
        int n3 = this.height / 2;
        float f2 = this.a((float)d, n2, f);
        float f3 = this.b((float)d2, n3, f);
        float f4 = (float)n2 - 380.0f;
        float f5 = (float)n3 - 230.0f;
        if (this.b(n)) {
            return true;
        }
        if (this.aw != null) {
            if (this.a(f2, f3)) {
                return true;
            }
            this.aw = null;
        }
        if (this.a(f2, f3, f4, f5, n)) {
            return true;
        }
        if (this.b(f2, f3, f4 + 168.0f + 1.0f, f5, n)) {
            return true;
        }
        if (this.c(f2, f3, f4 + 168.0f + 236.0f + 1.0f, f5, n)) {
            return true;
        }
        this.ak = false;
        return super.mouseClicked(class_119092, bl);
    }

    private boolean a(float f, float f2) {
        List<String> list = this.aw.c();
        float f3 = 22.0f;
        float f4 = (float)list.size() * f3 + 4.0f;
        if (f >= this.ax && f <= this.ax + this.az && f2 >= this.ay && f2 <= this.ay + f4) {
            int n = (int)((f2 - this.ay - 2.0f) / f3);
            if (n >= 0 && n < list.size()) {
                this.aw.a(list.get(n));
            }
            this.aw = null;
            return true;
        }
        this.aw = null;
        return false;
    }

    private boolean a(float f, float f2, float f3, float f4, int n) {
        float f5;
        if (f < f3 || f > f3 + 168.0f) {
            return false;
        }
        if (n == 0) {
            za[] zaArray = new za[]{za.a, za.c, za.d, za.b, za.e};
            f5 = f4 + 108.0f + 28.0f;
            for (za za2 : zaArray) {
                if (f2 >= f5 && f2 <= f5 + 36.0f) {
                    this.a(za2);
                    return true;
                }
                f5 += 36.0f;
            }
            if (f2 >= (f5 += 36.0f) && f2 <= f5 + 36.0f) {
                this.a(za.f);
                return true;
            }
        }
        float f6 = 28.0f;
        f5 = f4 + 460.0f - 44.0f;
        float f7 = 67.5f;
        if (f2 >= f5 && f2 <= f5 + f6 && n == 0) {
            if (f >= f3 + 14.0f && f <= f3 + 14.0f + f7) {
                this.an = !this.an;
                this.ao = false;
                this.d();
                this.bi = null;
                if (this.an) {
                    this.ai = null;
                }
                return true;
            }
            float f8 = f3 + 14.0f + f7 + 5.0f;
            if (f >= f8 && f <= f8 + f7) {
                this.ao = !this.ao;
                this.an = false;
                this.bi = null;
                if (this.ao) {
                    this.ai = null;
                    this.c();
                } else {
                    this.d();
                }
                return true;
            }
        }
        return false;
    }

    private void a(za za2) {
        if (za2 == this.ah && !this.an && !this.ao) {
            return;
        }
        this.an = false;
        this.ao = false;
        this.d();
        this.bi = null;
        this.ah = za2;
        this.al = 0.0f;
        this.aj = "";
        this.a();
        this.am = 0.0f;
    }

    private boolean b(float f, float f2, float f3, float f4, int n) {
        float f5 = 235.0f;
        float f6 = f5 - 28.0f;
        float f7 = 26.0f;
        float f8 = f3 + 14.0f;
        float f9 = f4 + 54.0f - f7 - 8.0f;
        if (n == 0 && f >= f8 && f <= f8 + f6 && f2 >= f9 && f2 <= f9 + f7) {
            this.ak = true;
            return true;
        }
        this.ak = false;
        float f10 = f4 + 54.0f + 1.0f;
        float f11 = 405.0f;
        if (f < f3 || f > f3 + f5 || f2 < f10 || f2 > f10 + f11) {
            return false;
        }
        List<com.vengeance.vengeanceclient.r.zb> list = this.b();
        float f12 = f10 - this.al;
        for (com.vengeance.vengeanceclient.r.zb zb2 : list) {
            if (f2 >= f12 && f2 <= f12 + 44.0f) {
                boolean bl;
                long l = this.client != null ? this.client.getWindow().getHandle() : 0L;
                boolean bl2 = l != 0L && (GLFW.glfwGetKey((long)l, (int)341) == 1 || GLFW.glfwGetKey((long)l, (int)345) == 1);
                boolean bl3 = bl = n == 1 || n == 0 && bl2;
                if (bl) {
                    this.a(zb2);
                    return true;
                }
                if (n != 0) {
                    return false;
                }
                float f13 = f3 + f5 - 14.0f - 11.0f;
                if (f >= f13 - 6.0f) {
                    this.a(zb2);
                } else {
                    zb2.a();
                }
                return true;
            }
            f12 += 44.0f;
        }
        return false;
    }

    private void a(com.vengeance.vengeanceclient.r.zb zb2) {
        this.an = false;
        this.ao = false;
        this.d();
        this.bi = null;
        this.ai = zb2;
        this.am = 0.0f;
        this.aw = null;
    }

    private boolean c(float f, float f2, float f3, float f4, int n) {
        if (this.ao) {
            float f5;
            float f6;
            float f7 = 355.0f;
            float f8 = 22.0f;
            float f9 = 42.0f;
            float f10 = f3 + f7 - 14.0f - f9;
            float f11 = f4 + (58.0f - f8) / 2.0f;
            if (n == 0 && f >= f10 && f <= f10 + f9 && f2 >= f11 && f2 <= f11 + f8) {
                com.vengeance.vengeanceclient.s.za za2 = VengeanceClient.INSTANCE.getProfileManager();
                if (za2 != null) {
                    za2.a(this.bh != null ? this.bh : "quicksave", true);
                    this.c();
                }
                return true;
            }
            if (this.bh != null) {
                f6 = f10 - 6.0f - f9;
                f5 = f11;
                if (n == 0 && f >= f6 && f <= f6 + f9 && f2 >= f5 && f2 <= f5 + f8) {
                    com.vengeance.vengeanceclient.s.za za3 = VengeanceClient.INSTANCE.getProfileManager();
                    if (za3 != null) {
                        za3.a(this.bh);
                    }
                    return true;
                }
            }
            f6 = f4 + 58.0f + 1.0f;
            f5 = 401.0f;
            if (f < f3 || f > f3 + f7 || f2 < f6 || f2 > f6 + f5) {
                return false;
            }
            float f12 = f6 - this.bm;
            for (String string : this.bg) {
                if (f2 >= f12 && f2 < f12 + 44.0f) {
                    if (n == 0) {
                        this.bh = string;
                        this.bi = null;
                        this.bk = false;
                    } else if (n == 1) {
                        boolean bl;
                        boolean bl2 = bl = string.equals(this.bi) && System.currentTimeMillis() - this.bj < 3000L;
                        if (bl) {
                            File file;
                            com.vengeance.vengeanceclient.s.za za4 = VengeanceClient.INSTANCE.getProfileManager();
                            if (za4 != null && (file = new File(za4.b(), string + ".json")).delete()) {
                                if (string.equals(this.bh)) {
                                    this.bh = null;
                                }
                                this.bi = null;
                                this.c();
                            }
                        } else {
                            this.bi = string;
                            this.bj = System.currentTimeMillis();
                        }
                    }
                    return true;
                }
                f12 += 44.0f;
            }
            if (f2 >= f12 && f2 < f12 + 44.0f && n == 0) {
                if (!this.bk) {
                    this.bk = true;
                    this.bl = "";
                    this.bh = null;
                }
                return true;
            }
            return false;
        }
        if (this.an || this.ai == null) {
            return false;
        }
        float f13 = 355.0f;
        float f14 = f4 + 58.0f + 1.0f;
        float f15 = 401.0f;
        if (f < f3 || f > f3 + f13 || f2 < f14 || f2 > f14 + f15) {
            return false;
        }
        float f16 = f3 + 14.0f;
        float f17 = f13 - 28.0f;
        float f18 = f14 + 8.0f - this.am;
        for (zg zg2 : this.ai.f()) {
            float f19 = this.a(zg2);
            if (f2 >= f18 && f2 < f18 + f19) {
                float f20;
                float f21;
                float f22;
                float f23;
                zg zg3;
                if (zg2 instanceof com.vengeance.vengeanceclient.r.r.za) {
                    com.vengeance.vengeanceclient.r.r.za za5 = (com.vengeance.vengeanceclient.r.r.za)zg2;
                    za5.a();
                    return true;
                }
                if (zg2 instanceof ze) {
                    zg3 = (ze)zg2;
                    f23 = com.vengeance.vengeanceclient.r.q.p.zb.y();
                    f22 = f18 + 32.0f;
                    if (f2 >= f22 - 5.0f && f2 <= f22 + f23 * 2.0f + 5.0f) {
                        this.aq = f16;
                        this.ar = f17;
                        this.ap = (ze)zg3;
                        ((ze)zg3).a(((ze)zg3).c() + (double)this.c((f - f16) / f17, 0.0f, 1.0f) * (((ze)zg3).d() - ((ze)zg3).c()));
                        return true;
                    }
                }
                if (zg2 instanceof zd) {
                    zg3 = (zd)zg2;
                    f23 = Math.max(80.0f, Math.min(f17 * 0.52f, com.vengeance.vengeanceclient.utils.w.r.za.a(((zd)zg3).a(), 9.5f) + 24.0f));
                    f22 = 22.0f;
                    f21 = f16 + f17 - f23;
                    f20 = f18 + (50.0f - f22) / 2.0f;
                    if (f >= f21 && f <= f21 + f23 && f2 >= f20 && f2 <= f20 + f22) {
                        this.aw = this.aw == zg3 ? null : (zd)zg3;
                        this.ax = f21;
                        this.ay = f20 + f22;
                        this.az = f23;
                        return true;
                    }
                }
                if (zg2 instanceof zf) {
                    zg3 = (zf)zg2;
                    f23 = com.vengeance.vengeanceclient.r.q.p.zb.y();
                    f22 = f18 + 34.0f;
                    if (f2 >= f22 - 5.0f && f2 <= f22 + f23 * 2.0f + 5.0f) {
                        double d = ((zf)zg3).b() - ((zf)zg3).a();
                        float f24 = d > 0.0 ? (float)((((zf)zg3).c() - ((zf)zg3).a()) / d) : 0.0f;
                        float f25 = d > 0.0 ? (float)((((zf)zg3).d() - ((zf)zg3).a()) / d) : 1.0f;
                        this.as = (zf)zg3;
                        this.at = Math.abs(f - (f16 + f24 * f17)) <= Math.abs(f - (f16 + f25 * f17));
                        this.au = f16;
                        this.av = f17;
                        return true;
                    }
                }
                if (zg2 instanceof com.vengeance.vengeanceclient.r.r.zc) {
                    zg3 = (com.vengeance.vengeanceclient.r.r.zc)zg2;
                    String string = ((com.vengeance.vengeanceclient.r.r.zc)zg3).f() ? "Press key..." : this.a(((com.vengeance.vengeanceclient.r.r.zc)zg3).e());
                    f22 = Math.max(70.0f, com.vengeance.vengeanceclient.utils.w.r.za.a(string, 9.0f) + 20.0f);
                    f21 = 22.0f;
                    f20 = f16 + f17 - f22;
                    float f26 = f18 + (44.0f - f21) / 2.0f;
                    if (f >= f20 && f <= f20 + f22 && f2 >= f26 && f2 <= f26 + f21) {
                        for (zg zg4 : this.ai.f()) {
                            com.vengeance.vengeanceclient.r.r.zc zc2;
                            if (!(zg4 instanceof com.vengeance.vengeanceclient.r.r.zc) || (zc2 = (com.vengeance.vengeanceclient.r.r.zc)zg4) == zg3) continue;
                            zc2.a(false);
                        }
                        ((com.vengeance.vengeanceclient.r.r.zc)zg3).a();
                        return true;
                    }
                }
                return false;
            }
            f18 += f19;
        }
        return false;
    }

    public boolean mouseDragged(Click class_119092, double d, double d2) {
        double d3 = class_119092.x();
        double d4 = class_119092.y();
        float f = this.b(this.bb) * this.h();
        int n = this.width / 2;
        int n2 = this.height / 2;
        float f2 = this.a((float)d3, n, f);
        int n3 = class_119092.button();
        if (this.ap != null) {
            float f3 = this.c((f2 - this.aq) / this.ar, 0.0f, 1.0f);
            this.ap.a(this.ap.c() + (double)f3 * (this.ap.d() - this.ap.c()));
            return true;
        }
        if (this.as != null) {
            double d5 = this.as.a() + (double)this.c((f2 - this.au) / this.av, 0.0f, 1.0f) * (this.as.b() - this.as.a());
            if (this.at) {
                this.as.a(d5);
            } else {
                this.as.b(d5);
            }
            return true;
        }
        return super.mouseDragged(class_119092, d, d2);
    }

    public boolean mouseReleased(Click class_119092) {
        this.ap = null;
        this.as = null;
        return super.mouseReleased(class_119092);
    }

    public boolean mouseScrolled(double d, double d2, double d3, double d4) {
        float f;
        float f2;
        float f3;
        float f4 = this.b(this.bb) * this.h();
        int n = this.width / 2;
        int n2 = this.height / 2;
        float f5 = this.a((float)d, n, f4);
        float f6 = this.b((float)d2, n2, f4);
        float f7 = (float)n - 380.0f;
        float f8 = (float)n2 - 230.0f;
        if (this.ao) {
            f3 = f7 + 168.0f + 236.0f + 1.0f;
            f2 = f8 + 58.0f + 1.0f;
            f = 401.0f;
            if (f5 >= f3 && f5 <= f3 + 356.0f - 1.0f && f6 >= f2 && f6 <= f2 + f) {
                float f9 = (this.bg.size() + 1) * 44;
                this.bm = this.c(this.bm - (float)d4 * 15.0f, 0.0f, Math.max(0.0f, f9 - f));
                return true;
            }
        }
        f3 = f7 + 168.0f + 1.0f;
        f2 = f8 + 54.0f + 1.0f;
        f = 405.0f;
        if (f5 >= f3 && f5 <= f3 + 236.0f - 1.0f && f6 >= f2 && f6 <= f2 + f) {
            float f10 = this.b().size() * 44;
            this.al = this.c(this.al - (float)d4 * 15.0f, 0.0f, Math.max(0.0f, f10 - f));
            return true;
        }
        float f11 = f7 + 168.0f + 236.0f + 1.0f;
        float f12 = f8 + 58.0f + 1.0f;
        float f13 = 401.0f;
        if (!this.ao && f5 >= f11 && f5 <= f11 + 356.0f - 1.0f && f6 >= f12 && f6 <= f12 + f13) {
            float f14 = this.e();
            this.am = this.c(this.am - (float)d4 * 15.0f, 0.0f, Math.max(0.0f, f14 - f13));
            return true;
        }
        return super.mouseScrolled(d, d2, d3, d4);
    }

    public boolean charTyped(CharInput class_119052) {
        char c = (char)class_119052.codepoint();
        int n = class_119052.modifiers();
        if (this.bk) {
            if (Character.isLetterOrDigit(c) || c == '_' || c == '-') {
                this.bl = this.bl + c;
                return true;
            }
            return false;
        }
        if (this.ak) {
            this.aj = this.aj + c;
            this.al = 0.0f;
            return true;
        }
        return super.charTyped(class_119052);
    }

    public boolean keyPressed(KeyInput class_119082) {
        int n = class_119082.key();
        int n2 = class_119082.scancode();
        int n3 = class_119082.modifiers();
        if (this.bk) {
            if (n == 259) {
                if (!this.bl.isEmpty()) {
                    this.bl = this.bl.substring(0, this.bl.length() - 1);
                }
                return true;
            }
            if (n == 257 || n == 335) {
                if (!this.bl.isEmpty()) {
                    com.vengeance.vengeanceclient.s.za za2 = VengeanceClient.INSTANCE.getProfileManager();
                    if (za2 != null) {
                        za2.b(this.bl);
                        this.c();
                    }
                    this.bl = "";
                }
                this.bk = false;
                return true;
            }
            if (n == 256) {
                this.bk = false;
                this.bl = "";
                return true;
            }
        }
        if (this.ak) {
            if (n == 259) {
                if (!this.aj.isEmpty()) {
                    this.aj = this.aj.substring(0, this.aj.length() - 1);
                }
                return true;
            }
            if (n == 256) {
                this.ak = false;
                return true;
            }
        }
        if (this.ai != null) {
            for (zg zg2 : this.ai.f()) {
                com.vengeance.vengeanceclient.r.r.zc zc2;
                if (!(zg2 instanceof com.vengeance.vengeanceclient.r.r.zc) || !(zc2 = (com.vengeance.vengeanceclient.r.r.zc)zg2).f()) continue;
                if (n != 256) {
                    zc2.a(n);
                }
                zc2.a(false);
                return true;
            }
        }
        if (n == 256) {
            this.close();
            return true;
        }
        return super.keyPressed(class_119082);
    }

    public void close() {
        this.bc = true;
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }

    public boolean shouldPause() {
        return false;
    }

    public void renderBackground(DrawContext class_3322, int n, int n2, float f) {
        if (com.vengeance.vengeanceclient.r.q.p.zb.r()) {
            super.renderBackground(class_3322, n, n2, f);
        }
    }

    private void a(DrawContext class_3322) {
        if (this.client == null) {
            return;
        }
        int n = this.width / 2;
        int n2 = this.height / 2;
        class_3322.drawCenteredTextWithShadow(this.client.textRenderer, (Text)Text.literal((String)"Rich GUI is open, but renderer is unavailable."), n, n2 - 8, 0xFFFFFF);
        class_3322.drawCenteredTextWithShadow(this.client.textRenderer, (Text)Text.literal((String)"This build has NanoVG removed."), n, n2 + 6, 0xA8A8A8);
    }

    private float b(float f) {
        return 1.0f - (float)Math.pow(1.0f - f, 3.0);
    }

    private float b(float f, float f2, float f3) {
        return f + (f2 - f) * Math.min(1.0f, f3);
    }

    private Color a(Color color, float f) {
        int n = Math.max(0, Math.min(255, (int)((float)color.getAlpha() * f)));
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), n);
    }

    private float a(float f, int n, float f2) {
        return (f - (float)n) / f2 + (float)n;
    }

    private float b(float f, int n, float f2) {
        return (f - (float)n) / f2 + (float)n;
    }

    private float c(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    private float h() {
        return switch (com.vengeance.vengeanceclient.r.q.p.zb.ag()) {
            case 0 -> 0.75f;
            case 2 -> 1.25f;
            case 3 -> 1.5f;
            default -> 1.0f;
        };
    }

    private String a(String string, float f, float f2) {
        if (com.vengeance.vengeanceclient.utils.w.r.za.a(string, f2) <= f) {
            return string;
        }
        while (string.length() > 1 && com.vengeance.vengeanceclient.utils.w.r.za.a(string + "..", f2) > f) {
            string = string.substring(0, string.length() - 1);
        }
        return string + "..";
    }
}

