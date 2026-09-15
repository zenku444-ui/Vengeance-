/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 */
package com.vengeance.vengeanceclient.r.q.u;

import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import java.awt.Color;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.gui.DrawContext;

public class zd
extends zb {
    private final ze b = new ze("Blur Radius", 1.0, 30.0, 12.0, 1.0);
    private final ze c = new ze("Corner Radius", 0.0, 20.0, 8.0, 1.0);
    private final ze d = new ze("Width", 50.0, 400.0, 200.0, 1.0);
    private final ze e = new ze("Height", 50.0, 300.0, 100.0, 1.0);
    private final ze f = new ze("X Position", 0.0, 1000.0, 100.0, 1.0);
    private final ze g = new ze("Y Position", 0.0, 1000.0, 100.0, 1.0);
    private final com.vengeance.vengeanceclient.r.r.za h = new com.vengeance.vengeanceclient.r.r.za("Centered", true);
    private final com.vengeance.vengeanceclient.r.r.zb i = new com.vengeance.vengeanceclient.r.r.zb("Tint Color", Color.WHITE);

    public zd() {
        super("BlurTest", "Tests the blur rendering system", za.d);
        this.a(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
    }

    @EventHandler
    private void onRender2D(com.vengeance.vengeanceclient.p.p.t.za za2) {
        float f;
        float f2;
        if (zd.a.player == null || zd.a.world == null) {
            return;
        }
        DrawContext class_3322 = za2.a();
        float f3 = (float)this.d.f();
        float f4 = (float)this.e.f();
        if (this.h.b()) {
            int n = a.getWindow().getScaledWidth();
            int n2 = a.getWindow().getScaledHeight();
            f2 = ((float)n - f3) / 2.0f;
            f = ((float)n2 - f4) / 2.0f;
        } else {
            f2 = (float)this.f.f();
            f = (float)this.g.f();
        }
        com.vengeance.vengeanceclient.utils.w.p.zb.a(class_3322.getMatrices(), f2, f, f3, f4, (float)this.c.f(), this.i.h(), (float)this.b.f());
    }
}

