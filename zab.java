/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;

public final class zab
extends zb {
    public static final ze b = new ze("Chance (%)", 1.0, 100.0, 100.0, 1.0);
    public static final com.vengeance.vengeanceclient.r.r.za c = new com.vengeance.vengeanceclient.r.r.za("Ignore S press", true);
    public static final com.vengeance.vengeanceclient.r.r.za d = new com.vengeance.vengeanceclient.r.r.za("Ignore on fire", true);

    public zab() {
        super("Velocity", "Automatically jump resets to reduce your velocity", -1, za.a);
        this.a(b, c, d);
    }

    @EventHandler
    private void onPacketEvent(com.vengeance.vengeanceclient.p.p.r.zb zb2) {
        EntityVelocityUpdateS2CPacket class_27432;
        if (this.d()) {
            return;
        }
        Packet class_25962 = zb2.b();
        if (class_25962 instanceof EntityVelocityUpdateS2CPacket && (class_27432 = (EntityVelocityUpdateS2CPacket)class_25962).getEntityId() == zab.a.player.getId() && this.n() && zab.a.player.isOnGround()) {
            if (c.b() && zab.a.options.backKey.isPressed()) {
                return;
            }
            if (d.b() && zab.a.player.isOnFire()) {
                return;
            }
            if (zab.a.currentScreen != null) {
                return;
            }
            zab.a.player.jump();
        }
    }

    private boolean n() {
        return Math.random() * 100.0 < (double)b.b();
    }
}

