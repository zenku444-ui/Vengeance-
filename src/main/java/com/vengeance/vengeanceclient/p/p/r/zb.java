/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.packet.Packet
 */
package com.vengeance.vengeanceclient.p.p.r;

import com.vengeance.vengeanceclient.p.q.za;
import com.vengeance.vengeanceclient.p.q.zc;
import net.minecraft.network.packet.Packet;

public class zb
extends za {
    private final zc a;
    private Packet b;

    public zb(Packet class_25962, zc zc2) {
        this.b = class_25962;
        this.a = zc2;
    }

    public zc a() {
        return this.a;
    }

    public Packet b() {
        return this.b;
    }

    public void a(Packet class_25962) {
        this.b = class_25962;
    }
}

