/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.screen.Screen
 */
package com.vengeance.vengeanceclient.r.q.r;

import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import net.minecraft.client.gui.screen.Screen;

public class zc
extends zb {
    public zc() {
        super("Friends", "Manage your friends list", za.e);
    }

    @Override
    public void b() {
        if (zc.a.player != null) {
            a.setScreen((Screen)new com.vengeance.vengeanceclient.q.zc());
        }
        this.a(false);
    }
}

