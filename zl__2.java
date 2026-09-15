/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.MathHelper
 */
package com.vengeance.vengeanceclient.r.q.u;

import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import com.vengeance.vengeanceclient.utils.u.za;
import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.math.MathHelper;

public class zl
extends zb {
    private static final int b = 140;
    private static final int c = 28;
    private static final int d = 4;
    private static final int e = 8;
    private static final int f = 8;
    private static final int g = 16;
    private static final int h = 3;
    private static final int i = 6;
    private static final float j = 10.0f;
    private static final float k = 8.5f;
    private static final Color l = new Color(0, 255, 0);
    private static final Color m = new Color(255, 0, 0);
    private static final Color n = new Color(255, 165, 0);

    public zl() {
        super("Notifications", "Toggle notification display on/off", za.d);
    }

    @EventHandler
    private void onRender2D(com.vengeance.vengeanceclient.p.p.t.za za2) {
        if (zl.a.player == null || zl.a.world == null) {
            return;
        }
        List<com.vengeance.vengeanceclient.utils.u.za> list = com.vengeance.vengeanceclient.utils.u.zb.a().b();
        if (list.isEmpty()) {
            return;
        }
        this.a(list);
        this.a(za2.b(), za2.c(), list);
    }

    private void a(List<com.vengeance.vengeanceclient.utils.u.za> list) {
        Iterator<com.vengeance.vengeanceclient.utils.u.za> iterator = list.iterator();
        while (iterator.hasNext()) {
            com.vengeance.vengeanceclient.utils.u.za za2 = iterator.next();
            if (za2.a() && !za2.i()) {
                za2.a(true);
            }
            float f = za2.i() ? 0.0f : 1.0f;
            za2.a(MathHelper.lerp((float)0.15f, (float)za2.h(), (float)f));
            if (!za2.i() || !(za2.h() < 0.05f)) continue;
            iterator.remove();
        }
    }

    private void a(int n, int n2, List<com.vengeance.vengeanceclient.utils.u.za> list) {
        float f = 0.0f;
        for (int i = list.size() - 1; i >= 0; --i) {
            com.vengeance.vengeanceclient.utils.u.za za2 = list.get(i);
            float f2 = n - 140 - 8;
            float f3 = (float)(n2 - 8 - 28) - f;
            float f4 = za2.h();
            float f5 = (1.0f - f4) * 160.0f;
            this.a(za2, f2 += f5, f3);
            f += 32.0f * f4;
        }
    }

    private void a(com.vengeance.vengeanceclient.utils.u.za za2, float f, float f2) {
        float f3 = za2.h();
        Color color = switch (za2.e()) {
            default -> throw new MatchException(null, null);
            case za.za.a -> l;
            case za.za.b -> m;
            case za.za.c -> n;
        };
        Color color2 = new Color(25, 25, 30, (int)(200.0f * f3));
        com.vengeance.vengeanceclient.utils.w.r.za.a(f, f2, 140.0f, 28.0f, 3.0f, color2);
        float f4 = f + 6.0f + 8.0f;
        float f5 = f2 + 14.0f;
        float f6 = 8.0f;
        Color color3 = new Color(color.getRed(), color.getGreen(), color.getBlue(), (int)(80.0f * f3));
        com.vengeance.vengeanceclient.utils.w.r.za.a(f4, f5, f6, color3);
        int n = com.vengeance.vengeanceclient.utils.w.r.za.i();
        Color color4 = new Color(255, 255, 255, (int)(255.0f * f3));
        float f7 = 9.0f;
        String string = "i";
        float f8 = com.vengeance.vengeanceclient.utils.w.r.za.a(string, f7, n);
        com.vengeance.vengeanceclient.utils.w.r.za.a(string, f4 - f8 / 2.0f, f5 - f7 / 2.0f + 1.0f, f7, color4, n);
        float f9 = f + 12.0f + 16.0f + 2.0f;
        float f10 = f2 + 6.0f;
        Color color5 = new Color(255, 255, 255, (int)(255.0f * f3));
        com.vengeance.vengeanceclient.utils.w.r.za.a(za2.c(), f9, f10, 10.0f, color5, n);
        Color color6 = new Color(180, 180, 180, (int)(255.0f * f3));
        com.vengeance.vengeanceclient.utils.w.r.za.a(za2.d(), f9, f10 + 11.0f, 8.5f, color6, n);
        float f11 = 140.0f * (1.0f - za2.b());
        if (f11 > 0.0f) {
            Color color7 = new Color(color.getRed(), color.getGreen(), color.getBlue(), (int)(150.0f * f3));
            float f12 = f;
            float f13 = f2 + 28.0f - 2.0f;
            float f14 = 2.0f;
            com.vengeance.vengeanceclient.utils.w.r.za.a(f12, f13, f11, f14, color7);
        }
    }
}

