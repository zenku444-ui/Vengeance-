/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.s2c.common.KeepAliveS2CPacket
 *  net.minecraft.network.packet.c2s.common.KeepAliveC2SPacket
 */
package com.vengeance.vengeanceclient.r.q.t;

import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.r.zg;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.common.KeepAliveS2CPacket;
import net.minecraft.network.packet.c2s.common.KeepAliveC2SPacket;

public final class zm
extends zb {
    private final ze b = new ze("Ms", 1.0, 500.0, 60.0, 1.0);

    public zm() {
        super("Ping Spoof", "Increases your ping", -1, za.b);
        this.a((zg)this.b);
    }

    @EventHandler
    private void onEventPacket(com.vengeance.vengeanceclient.p.p.r.zb zb2) {
        Object object = zb2.b();
        if (object instanceof KeepAliveS2CPacket) {
            KeepAliveS2CPacket class_26702 = (KeepAliveS2CPacket)object;
            if (this.d()) {
                return;
            }
            object = CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(this.b.a());
                    Objects.requireNonNull(a.getNetworkHandler()).getConnection().send((Packet)new KeepAliveC2SPacket(class_26702.getId()));
                }
                catch (InterruptedException interruptedException) {
                    throw new RuntimeException(interruptedException);
                }
            });
            ((CompletableFuture)object).join();
        }
    }
}

