/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket
 */
package com.vengeance.vengeanceclient.r.q.p;

import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;

public class zc
extends zb {
    public zc() {
        super("Debugger", "Debugs inv packets (dev purposes)", -1, za.f);
    }

    @EventHandler
    public void onPacketSend(com.vengeance.vengeanceclient.p.p.r.zb zb2) {
        if (this.d()) {
            return;
        }
        if (zb2.b() == null) {
            return;
        }
        Packet class_25962 = zb2.b();
        if (!(class_25962 instanceof ClickSlotC2SPacket)) {
            return;
        }
        ClickSlotC2SPacket class_28132 = (ClickSlotC2SPacket)class_25962;
        com.vengeance.vengeanceclient.utils.t.za.e("ClickSlotPacket\n  syncId: %s\n  revision: %s\n  slot: %s\n  button: %s\n  actionType: %s\n  modifiedItems: %s\n  cursor: %s\n".formatted(class_28132.comp_3842(), class_28132.comp_3843(), class_28132.comp_3844(), class_28132.comp_3845(), class_28132.comp_3846(), class_28132.comp_3847(), class_28132.comp_3848()));
    }
}

