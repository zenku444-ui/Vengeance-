/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.screen.slot.Slot
 *  net.minecraft.client.gui.screen.ingame.HandledScreen
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package com.vengeance.vengeanceclient.mixin;

import net.minecraft.screen.slot.Slot;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={HandledScreen.class})
public interface HandledScreenAccessor {
    @Accessor(value="focusedSlot")
    public Slot getFocusedSlot();
}

