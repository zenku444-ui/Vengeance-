/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.item.Items
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package com.vengeance.vengeanceclient.mixin;

import com.vengeance.vengeanceclient.VengeanceClient;
import com.vengeance.vengeanceclient.r.q.u.ze;
import com.vengeance.vengeanceclient.utils.w.q.za;
import net.minecraft.screen.slot.Slot;
import net.minecraft.item.Items;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={HandledScreen.class})
public class HandledScreenMixin {
    @Inject(method={"drawSlot(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/screen/slot/Slot;II)V"}, at={@At(value="TAIL")})
    public void postDrawSlot(DrawContext class_3322, Slot class_17352, int n, int n2, CallbackInfo callbackInfo) {
        if (!VengeanceClient.INSTANCE.moduleManager.a(ze.class).get().l()) {
            return;
        }
        if (ze.e.b() && class_17352.hasStack() && class_17352.getStack().getItem() == Items.TOTEM_OF_UNDYING) {
            class_3322.fill(class_17352.x, class_17352.y, class_17352.x + 16, class_17352.y + 16, ze.f.h().getRGB());
        }
        if (ze.d.b()) {
            return;
        }
        if (ze.b.b("Inter")) {
            VengeanceClient.INSTANCE.fontManager.a(10, za.zb.a).a(new MatrixStack(), String.valueOf(class_17352.getIndex()), class_17352.x, class_17352.y, ze.c.h());
        } else {
            class_3322.drawText(VengeanceClient.mc.textRenderer, String.valueOf(class_17352.getIndex()), class_17352.x, class_17352.y, ze.c.h().getRGB(), false);
        }
    }
}

