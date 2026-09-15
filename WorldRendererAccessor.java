/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gl.Framebuffer
 *  net.minecraft.client.render.WorldRenderer
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package com.vengeance.vengeanceclient.mixin;

import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={WorldRenderer.class})
public interface WorldRendererAccessor {
    @Accessor(value="entityOutlineFramebuffer")
    public Framebuffer getEntityOutlineFramebuffer();

    @Invoker(value="canDrawEntityOutlines")
    public boolean invokeCanDrawEntityOutlines();
}

