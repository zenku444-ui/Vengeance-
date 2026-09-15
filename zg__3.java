/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.screen.ChatScreen
 */
package com.vengeance.vengeanceclient.r.q.u;

import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import java.awt.Color;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.gui.screen.ChatScreen;

public class zg
extends zb {
    private static final float b = 6.0f;
    private static final float c = 12.0f;
    private static final float d = 14.0f;
    private static final float e = 8.0f;
    private static final float f = 8.0f;
    private static final Color g = new Color(12, 12, 12, 235);
    private static final Color h = new Color(230, 230, 230, 255);
    private static final Color i = new Color(120, 170, 255, 255);
    private static final Color j = new Color(70, 70, 70, 220);
    private final com.vengeance.vengeanceclient.r.r.za k = new com.vengeance.vengeanceclient.r.r.za("Show FPS", true);

    public zg() {
        super("Dynamic Island", "Shows a dynamic island HUD in the center-top", za.d);
        this.a(new com.vengeance.vengeanceclient.r.r.zg[]{this.k});
        this.a(true);
    }

    @EventHandler
    private void onRender2D(com.vengeance.vengeanceclient.p.p.t.za za2) {
        if (!this.n()) {
            return;
        }
        boolean bl = zg.a.currentScreen instanceof ChatScreen;
        if (zg.a.currentScreen != null && !bl) {
            return;
        }
        this.o();
    }

    private boolean n() {
        return zg.a.player != null && zg.a.world != null;
    }

    private void o() {
        String string = "Raven Z-";
        String string2 = "\u26a1 " + a.getCurrentFps() + " fps";
        float f = com.vengeance.vengeanceclient.utils.w.r.za.a(12.0f);
        float f2 = f + 12.0f;
        float f3 = 10.0f;
        float f4 = com.vengeance.vengeanceclient.utils.w.r.za.a(string, 12.0f);
        float f5 = 12.0f + f3 + 6.0f + f4;
        float f6 = 8.0f;
        float f7 = 8.0f;
        com.vengeance.vengeanceclient.utils.w.r.za.a(f6, f7, f5, f2, 14.0f, g);
        float f8 = f6 + 6.0f;
        float f9 = f7 + (f2 - f3) / 2.0f;
        com.vengeance.vengeanceclient.utils.w.r.za.a(f8, f9, f3, f3, f3 / 2.0f, i);
        float f10 = f8 + f3 + 6.0f;
        float f11 = f7 + 6.0f;
        com.vengeance.vengeanceclient.utils.w.r.za.a(string, f10, f11, 12.0f, h);
        if (!this.k.b()) {
            return;
        }
        float f12 = 6.0f;
        float f13 = com.vengeance.vengeanceclient.utils.w.r.za.a(string2, 12.0f);
        float f14 = 12.0f + f13;
        float f15 = f6 + f5 + f12;
        com.vengeance.vengeanceclient.utils.w.r.za.a(f15, f7, f14, f2, 14.0f, g);
        float f16 = f15 - f12 / 2.0f;
        float f17 = f7 + 4.0f;
        com.vengeance.vengeanceclient.utils.w.r.za.a(f16, f17, 1.5f, f2 - 8.0f, 1.0f, j);
        float f18 = f15 + 6.0f;
        com.vengeance.vengeanceclient.utils.w.r.za.a(string2, f18, f11, 12.0f, h);
    }
}

