/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.opengl.GlStateManager
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.screen.Screen
 *  org.jetbrains.annotations.Nullable
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package com.vengeance.vengeanceclient.mixin;

import com.mojang.blaze3d.opengl.GlStateManager;
import com.vengeance.vengeanceclient.q.zc;
import com.vengeance.vengeanceclient.r.q.p.zb;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Screen.class})
public abstract class ScreenMixin {
    @Shadow
    @Nullable
    protected MinecraftClient client;

    @Inject(method={"renderBackground(Lnet/minecraft/client/gui/DrawContext;IIF)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void renderBackgroundInject(DrawContext class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        if (this.client == null) {
            return;
        }
        Screen class_4372 = this.client.currentScreen;
        if (class_4372 instanceof zc && !zb.r()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"render(Lnet/minecraft/client/gui/DrawContext;IIF)V"}, at={@At(value="TAIL")})
    private void onRenderTail(DrawContext class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        if (this.client == null) {
            return;
        }
        Screen class_4372 = this.client.currentScreen;
        if (class_4372 instanceof zc) {
            GlStateManager._enableBlend();
            GlStateManager._blendFuncSeparate((int)770, (int)771, (int)1, (int)771);
            GlStateManager._enableDepthTest();
            GlStateManager._depthFunc((int)515);
            GlStateManager._enableCull();
            GlStateManager._disableScissorTest();
            GlStateManager._colorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
            GlStateManager._depthMask((boolean)true);
        }
    }
}

