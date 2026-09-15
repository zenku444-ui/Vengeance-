/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.render.WorldRenderer
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package com.vengeance.vengeanceclient.mixin;

import com.vengeance.vengeanceclient.r.q.u.zf;
import com.vengeance.vengeanceclient.utils.w.zl;
import java.awt.Color;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={WorldRenderer.class})
public abstract class WorldRendererMixin {
    @Shadow
    @Final
    private MinecraftClient client;
    @Shadow
    private Framebuffer entityOutlineFramebuffer;

    @Inject(method={"drawEntityOutlinesFramebuffer()V"}, at={@At(value="HEAD")}, cancellable=true)
    private void onDrawEntityOutlines(CallbackInfo callbackInfo) {
        zf zf2 = zf.n();
        if (zf2 == null || !zf2.l()) {
            return;
        }
        if (this.entityOutlineFramebuffer == null) {
            return;
        }
        zf2.o();
        Color color = zf2.p().stream().findFirst().map(zf2::b).orElse(new Color(255, 50, 50));
        zl.a(this.entityOutlineFramebuffer, color, zf2.q(), zf2.r(), zf2.s(), zf2.t());
        callbackInfo.cancel();
    }
}

