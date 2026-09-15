/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.screen.ChatScreen
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package com.vengeance.vengeanceclient.mixin;

import com.vengeance.vengeanceclient.VengeanceClient;
import com.vengeance.vengeanceclient.p.p.p.za;
import net.minecraft.client.gui.screen.ChatScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ChatScreen.class})
public class ChatScreenMixin {
    @Inject(method={"sendMessage(Ljava/lang/String;Z)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void onSendMessage(String string, boolean bl, CallbackInfo callbackInfo) {
        za za2 = new za(string);
        VengeanceClient.INSTANCE.getEventBus().post(za2);
        if (za2.d()) {
            callbackInfo.cancel();
        }
    }
}

