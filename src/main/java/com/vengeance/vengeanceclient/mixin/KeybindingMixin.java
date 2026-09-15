/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.client.util.InputUtil$Key
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
import com.vengeance.vengeanceclient.r.q.s.zd;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={KeyBinding.class})
public class KeybindingMixin {
    @Shadow
    @Final
    private InputUtil.Key defaultKey;
    @Shadow
    private boolean pressed;

    @Inject(method={"isPressed()Z"}, at={@At(value="HEAD")}, cancellable=true)
    public void onGetPressed(CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (!VengeanceClient.INSTANCE.moduleManager.a(zd.class).get().l()) {
            return;
        }
        if (this.defaultKey.getCode() == 65) {
            if (this.pressed) {
                if (zd.c == 0L) {
                    callbackInfoReturnable.setReturnValue(true);
                    callbackInfoReturnable.cancel();
                    return;
                }
                callbackInfoReturnable.setReturnValue(zd.c <= zd.b);
                callbackInfoReturnable.cancel();
            }
        } else if (this.defaultKey.getCode() == 68) {
            if (this.pressed) {
                if (zd.b == 0L) {
                    callbackInfoReturnable.setReturnValue(true);
                    callbackInfoReturnable.cancel();
                    return;
                }
                callbackInfoReturnable.setReturnValue(zd.b <= zd.c);
                callbackInfoReturnable.cancel();
            }
        } else if (this.defaultKey.getCode() == 87) {
            if (this.pressed) {
                if (zd.e == 0L) {
                    callbackInfoReturnable.setReturnValue(true);
                    callbackInfoReturnable.cancel();
                    return;
                }
                callbackInfoReturnable.setReturnValue(zd.e <= zd.d);
                callbackInfoReturnable.cancel();
            }
        } else if (this.defaultKey.getCode() == 83 && this.pressed) {
            if (zd.d == 0L) {
                callbackInfoReturnable.setReturnValue(true);
                callbackInfoReturnable.cancel();
                return;
            }
            callbackInfoReturnable.setReturnValue(zd.d <= zd.e);
            callbackInfoReturnable.cancel();
        }
    }

    @Inject(method={"setPressed(Z)V"}, at={@At(value="HEAD")})
    public void setPressed(boolean bl, CallbackInfo callbackInfo) {
        if (!VengeanceClient.INSTANCE.moduleManager.a(zd.class).get().l()) {
            return;
        }
        if (this.defaultKey.getCode() == 65) {
            zd.b = bl ? System.currentTimeMillis() : 0L;
        } else if (this.defaultKey.getCode() == 68) {
            zd.c = bl ? System.currentTimeMillis() : 0L;
        } else if (this.defaultKey.getCode() == 87) {
            zd.d = bl ? System.currentTimeMillis() : 0L;
        } else if (this.defaultKey.getCode() == 83) {
            zd.e = bl ? System.currentTimeMillis() : 0L;
        }
    }
}

