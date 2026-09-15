/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.input.MouseInput
 *  net.minecraft.client.Mouse
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package com.vengeance.vengeanceclient.mixin;

import net.minecraft.client.input.MouseInput;
import net.minecraft.client.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={Mouse.class})
public interface MouseHandlerAccessor {
    @Invoker(value="onMouseButton")
    public void press(long var1, MouseInput var3, int var4);
}

