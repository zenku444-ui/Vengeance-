/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.opengl.GlStateManager
 *  net.minecraft.client.gui.hud.InGameHud
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.render.RenderTickCounter
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package com.vengeance.vengeanceclient.mixin;

import com.mojang.blaze3d.opengl.GlStateManager;
import com.vengeance.vengeanceclient.VengeanceClient;
import com.vengeance.vengeanceclient.p.p.t.za;
import com.vengeance.vengeanceclient.utils.w.zn;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={InGameHud.class})
public class InGameHudMixin {
    @Inject(method={"render(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/client/render/RenderTickCounter;)V"}, at={@At(value="TAIL")})
    private void onRender(DrawContext class_3322, RenderTickCounter class_97792, CallbackInfo callbackInfo) {
        zn.a();
        zn.b();
        GlStateManager._disableDepthTest();
        GlStateManager._enableBlend();
        GlStateManager._blendFuncSeparate((int)770, (int)771, (int)1, (int)771);
        GlStateManager._disableCull();
        if (com.vengeance.vengeanceclient.utils.w.r.za.a(class_3322)) {
            VengeanceClient.INSTANCE.getEventBus().post(new za(class_3322, class_3322.getScaledWindowWidth(), class_3322.getScaledWindowHeight()));
            com.vengeance.vengeanceclient.utils.w.r.za.e();
        }
        GlStateManager._enableDepthTest();
        GlStateManager._enableCull();
    }
}

