/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.input.KeyInput
 *  net.minecraft.client.Keyboard
 *  net.minecraft.client.MinecraftClient
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package com.vengeance.vengeanceclient.mixin;

import com.vengeance.vengeanceclient.VengeanceClient;
import com.vengeance.vengeanceclient.r.zb;
import com.vengeance.vengeanceclient.utils.r.za;
import net.minecraft.client.input.KeyInput;
import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Keyboard.class})
public class KeyboardMixin {
    @Shadow
    @Final
    private MinecraftClient client;

    @Inject(method={"onKey(JILnet/minecraft/client/input/KeyInput;)V"}, at={@At(value="HEAD")})
    private void onPress(long l, int n, KeyInput class_119082, CallbackInfo callbackInfo) {
        int n2 = class_119082.getKeycode();
        if (l == this.client.getWindow().getHandle() && this.client.currentScreen == null) {
            for (zb zb2 : VengeanceClient.INSTANCE.moduleManager.b()) {
                if (n2 != zb2.e()) continue;
                if (zb2.h().g()) {
                    if (n == 1 && !zb2.l()) {
                        zb2.a(true);
                        continue;
                    }
                    if (n != 0 || !zb2.l()) continue;
                    zb2.a(false);
                    continue;
                }
                if (n != 1 || !za.b(n2)) continue;
                zb2.a();
            }
        }
    }
}

