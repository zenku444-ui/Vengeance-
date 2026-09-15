/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerInteractionManager
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.render.RenderTickCounter$Dynamic
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package com.vengeance.vengeanceclient.mixin;

import com.vengeance.vengeanceclient.VengeanceClient;
import com.vengeance.vengeanceclient.p.p.r.za;
import com.vengeance.vengeanceclient.p.p.s.zc;
import com.vengeance.vengeanceclient.p.p.s.zd;
import com.vengeance.vengeanceclient.r.q.q.zb;
import java.util.Optional;
import net.minecraft.util.hit.HitResult;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.RenderTickCounter;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={MinecraftClient.class})
public class MinecraftClientMixin
implements com.vengeance.vengeanceclient.utils.zb {
    @Shadow
    public ClientWorld world;
    @Shadow
    public HitResult crosshairTarget;
    @Shadow
    public ClientPlayerEntity player;
    @Shadow
    public ClientPlayerInteractionManager interactionManager;
    @Shadow
    @Final
    private RenderTickCounter.Dynamic renderTickCounter;

    @Inject(method={"getWindowTitle()Ljava/lang/String;"}, at={@At(value="HEAD")}, cancellable=true)
    public void setTitle(CallbackInfoReturnable<String> callbackInfoReturnable) {
        com.vengeance.vengeanceclient.r.q.p.za za2;
        if (VengeanceClient.INSTANCE == null || VengeanceClient.mc == null) {
            return;
        }
        Optional<com.vengeance.vengeanceclient.r.q.p.za> optional = VengeanceClient.INSTANCE.getModuleManager().a(com.vengeance.vengeanceclient.r.q.p.za.class);
        if (optional.isPresent() && (za2 = optional.get()).l() && za2.n()) {
            callbackInfoReturnable.setReturnValue("Vengeance Client 1.21.11");
        }
    }

    @Inject(method={"handleInputEvents()V"}, at={@At(value="HEAD")})
    public void ravenZHandleInputEvents(CallbackInfo callbackInfo) {
        if (VengeanceClient.INSTANCE != null) {
            com.vengeance.vengeanceclient.p.p.q.za za2 = new com.vengeance.vengeanceclient.p.p.q.za();
            VengeanceClient.INSTANCE.getEventBus().post(za2);
        }
    }

    @Inject(method={"tick()V"}, at={@At(value="HEAD")})
    private void onTick(CallbackInfo callbackInfo) {
        if (VengeanceClient.INSTANCE == null || VengeanceClient.mc == null) {
            return;
        }
        if (this.world != null) {
            VengeanceClient.INSTANCE.getEventBus().post(new zd());
        }
    }

    @Inject(method={"doAttack()Z"}, at={@At(value="HEAD")}, cancellable=true)
    public final void doAttackInject(CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        Object object;
        try {
            object = VengeanceClient.INSTANCE.getModuleManager().a(zb.class);
            if (((Optional)object).isPresent() && ((zb)((Optional)object).get()).l() && (this.crosshairTarget == null || this.crosshairTarget.getType() == HitResult.Type.MISS)) {
                callbackInfoReturnable.setReturnValue(false);
                return;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        object = new com.vengeance.vengeanceclient.p.p.s.zb();
        VengeanceClient.INSTANCE.getEventBus().post(object);
    }

    @Inject(method={"stop()V"}, at={@At(value="HEAD")})
    public void stopInject(CallbackInfo callbackInfo) {
        if (VengeanceClient.INSTANCE != null) {
            com.vengeance.vengeanceclient.s.za za2 = VengeanceClient.INSTANCE.getProfileManager();
            za2.a("default", true);
        }
    }

    @Inject(method={"setWorld(Lnet/minecraft/client/world/ClientWorld;Z)V"}, at={@At(value="HEAD")})
    public void onWorldChangeInject(ClientWorld NarrationMessageBuilder, boolean bl, CallbackInfo callbackInfo) {
        if (VengeanceClient.INSTANCE != null && VengeanceClient.mc != null) {
            VengeanceClient.INSTANCE.getEventBus().post(new com.vengeance.vengeanceclient.p.p.u.za(NarrationMessageBuilder));
        }
    }

    @Inject(method={"onDisconnected()V"}, at={@At(value="HEAD")})
    public final void onDisconnected(CallbackInfo callbackInfo) {
        za za2 = new za();
        VengeanceClient.INSTANCE.getEventBus().post(za2);
    }

    @Inject(method={"doItemUse()V"}, at={@At(value="HEAD")}, cancellable=true)
    public final void doItemUseInject(CallbackInfo callbackInfo) {
        zc zc2 = new zc();
        VengeanceClient.INSTANCE.getEventBus().post(zc2);
        if (zc2.d()) {
            callbackInfo.cancel();
        }
    }
}

