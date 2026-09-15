/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelFutureListener
 *  io.netty.channel.ChannelHandlerContext
 *  net.minecraft.network.ClientConnection
 *  net.minecraft.network.packet.Packet
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package com.vengeance.vengeanceclient.mixin;

import com.vengeance.vengeanceclient.VengeanceClient;
import com.vengeance.vengeanceclient.p.p.r.za;
import com.vengeance.vengeanceclient.p.p.r.zb;
import com.vengeance.vengeanceclient.p.q.zc;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ClientConnection.class})
public class MixinClientConnection {
    @Inject(method={"channelRead0(Lio/netty/channel/ChannelHandlerContext;Lnet/minecraft/network/packet/Packet;)V"}, at={@At(value="INVOKE", target="Lnet/minecraft/network/ClientConnection;handlePacket(Lnet/minecraft/network/packet/Packet;Lnet/minecraft/network/listener/PacketListener;)V")}, cancellable=true)
    private static void receivePacketEventInject(ChannelHandlerContext channelHandlerContext, Packet<?> class_25962, CallbackInfo callbackInfo) {
        MixinClientConnection.postPacketEvent(class_25962, zc.b, callbackInfo);
    }

    @Unique
    private static void postPacketEvent(Packet<?> class_25962, zc zc2, CallbackInfo callbackInfo) {
        if (VengeanceClient.INSTANCE == null) {
            return;
        }
        zb zb2 = new zb(class_25962, zc2);
        VengeanceClient.INSTANCE.getEventBus().post(zb2);
        if (zb2.d()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"sendInternal(Lnet/minecraft/network/packet/Packet;Lio/netty/channel/ChannelFutureListener;Z)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void sendPacketEventInject(Packet<?> class_25962, ChannelFutureListener channelFutureListener, boolean bl, CallbackInfo callbackInfo) {
        MixinClientConnection.postPacketEvent(class_25962, zc.a, callbackInfo);
    }

    @Inject(method={"handleDisconnection()V"}, at={@At(value="HEAD")})
    private void handleDisconnectionInject(CallbackInfo callbackInfo) {
        if (VengeanceClient.INSTANCE != null) {
            VengeanceClient.INSTANCE.getEventBus().post(new za());
        }
    }
}

