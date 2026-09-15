/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.input.MouseInput
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.Mouse
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package com.vengeance.vengeanceclient.mixin;

import com.vengeance.vengeanceclient.VengeanceClient;
import com.vengeance.vengeanceclient.p.p.q.zb;
import net.minecraft.client.input.MouseInput;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Mouse.class})
public class MouseMixin {
    @Shadow
    @Final
    private MinecraftClient client;

    @Inject(method={"onMouseButton(JLnet/minecraft/client/input/MouseInput;I)V"}, at={@At(value="HEAD")})
    private void onMouseButton(long l, MouseInput class_119102, int n, CallbackInfo callbackInfo) {
        if (VengeanceClient.INSTANCE == null) {
            return;
        }
        if (l != this.client.getWindow().getHandle()) {
            return;
        }
        if (this.client.currentScreen != null) {
            return;
        }
        zb zb2 = new zb(class_119102.comp_4801(), n, class_119102.comp_4797());
        VengeanceClient.INSTANCE.getEventBus().post(zb2);
    }
}

