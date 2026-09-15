/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package com.vengeance.vengeanceclient.mixin;

import com.vengeance.vengeanceclient.VengeanceClient;
import com.vengeance.vengeanceclient.r.q.u.zn;
import java.util.Optional;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={LivingEntity.class})
public class LivingEntityMixin {
    @Inject(method={"getHandSwingDuration()I"}, at={@At(value="HEAD")}, cancellable=true)
    public void getHandSwingDurationInject(CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        zn zn2;
        if (VengeanceClient.INSTANCE == null || VengeanceClient.mc == null) {
            return;
        }
        Optional<zn> optional = VengeanceClient.INSTANCE.getModuleManager().a(zn.class);
        if (optional.isPresent() && (zn2 = optional.get()).l()) {
            callbackInfoReturnable.setReturnValue((Object)zn2.n());
        }
    }
}

