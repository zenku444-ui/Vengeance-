/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket$PositionAndOnGround
 */
package com.vengeance.vengeanceclient.r.q.q;

import com.vengeance.vengeanceclient.r.r.zd;
import com.vengeance.vengeanceclient.r.r.zg;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

public class zh
extends zb {
    public final zd b = new zd("Mode", "Vanilla", "Vanilla", "Watchdog Old", "Mospixel");

    public zh() {
        super("Criticals", "Makes you hit every crit (BLATANT)", -1, za.a);
        this.a((zg)this.b);
    }

    @EventHandler
    public void onAttack(com.vengeance.vengeanceclient.p.p.s.za za2) {
        boolean bl;
        if (this.d()) {
            return;
        }
        boolean bl2 = bl = zh.a.player.fallDistance > 0.0 && !zh.a.player.isOnGround() && !zh.a.player.isClimbing() && !zh.a.player.isTouchingWater() && !zh.a.player.hasStatusEffect(StatusEffects.BLINDNESS) && !zh.a.player.hasVehicle() && za2.a() instanceof LivingEntity;
        if (bl) {
            return;
        }
        switch (this.b.a()) {
            case "Vanilla": {
                zh.a.player.networkHandler.sendPacket((Packet)new PlayerMoveC2SPacket.class_2829(zh.a.player.getEntityPos().x, zh.a.player.getEntityPos().y + 0.2, zh.a.player.getEntityPos().z, false, false));
                zh.a.player.networkHandler.sendPacket((Packet)new PlayerMoveC2SPacket.class_2829(zh.a.player.getEntityPos().x, zh.a.player.getEntityPos().y + 0.1, zh.a.player.getEntityPos().z, false, false));
                break;
            }
            case "Watchdog Old": {
                if (!zh.a.player.isOnGround()) break;
                zh.a.player.setPosition(zh.a.player.getX(), zh.a.player.getY() + 0.001, zh.a.player.getZ());
                break;
            }
            case "Mospixel": {
                zh.a.player.networkHandler.sendPacket((Packet)new PlayerMoveC2SPacket.class_2829(zh.a.player.getEntityPos().x, zh.a.player.getEntityPos().y + 2.71875E-7, zh.a.player.getEntityPos().z, false, false));
                zh.a.player.networkHandler.sendPacket((Packet)new PlayerMoveC2SPacket.class_2829(zh.a.player.getEntityPos().x, zh.a.player.getEntityPos().y, zh.a.player.getEntityPos().z, false, false));
            }
        }
    }
}

