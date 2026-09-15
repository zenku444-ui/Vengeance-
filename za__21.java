/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.option.KeyBinding
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.util.InputUtil$Key
 */
package com.vengeance.vengeanceclient.utils.r.p;

import com.vengeance.vengeanceclient.VengeanceClient;
import com.vengeance.vengeanceclient.utils.r.p.zb;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;

public final class za {
    public static void a() {
        if (VengeanceClient.shouldUseMouseEvent) {
            zb.a.a(2, 0, 0, 0, 0);
            zb.a.a(4, 0, 0, 0, 0);
        } else {
            MinecraftClient class_3102 = MinecraftClient.getInstance();
            KeyBinding class_3042 = class_3102.options.attackKey;
            InputUtil.class_306 FunctionCommand = class_3042.getDefaultKey();
            KeyBinding.setKeyPressed((InputUtil.class_306)FunctionCommand, (boolean)true);
            KeyBinding.onKeyPressed((InputUtil.class_306)FunctionCommand);
            class_3102.execute(() -> KeyBinding.setKeyPressed((InputUtil.class_306)FunctionCommand, (boolean)false));
        }
    }

    private za() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

