/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.screen.Screen
 */
package com.vengeance.vengeanceclient.r.q.p;

import com.vengeance.vengeanceclient.q.zc;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import java.awt.Color;
import net.minecraft.client.gui.screen.Screen;

public class zd
extends zb {
    public zd() {
        super("RichModernGUI", "Rich Modern ClickGUI", 344, za.f);
    }

    @Override
    public void b() {
        if (zd.a.currentScreen == null) {
            a.setScreen((Screen)new zc());
        }
        this.a(false);
    }

    public static Color n() {
        return com.vengeance.vengeanceclient.r.q.p.zb.n();
    }
}

