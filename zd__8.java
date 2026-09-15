/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.registry.tag.ItemTags
 */
package com.vengeance.vengeanceclient.utils.t;

import com.vengeance.vengeanceclient.utils.zb;
import java.util.Objects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;

public final class zd
implements zb {
    private static final int b = 9;

    public static void a(Item class_17922) {
        for (int n = 0; n < 9; n = (int)((byte)(n + 1))) {
            assert (zd.w.player != null);
            ItemStack class_17992 = zd.w.player.getInventory().getStack(n);
            if (class_17992.isEmpty() || !class_17992.getItem().equals(class_17922)) continue;
            zd.w.player.getInventory().setSelectedSlot(n);
            return;
        }
    }

    public static boolean b(Item class_17922) {
        for (int n = 0; n < Objects.requireNonNull(zd.w.player).getInventory().size(); n = (int)((byte)(n + 1))) {
            ItemStack class_17992 = zd.w.player.getInventory().getStack(n);
            if (class_17992.getItem() != class_17922) continue;
            return true;
        }
        return false;
    }

    public static boolean a(Class<? extends Item> clazz) {
        for (int n = 0; n < 9; n = (int)((byte)(n + 1))) {
            ItemStack class_17992 = zd.w.player.getInventory().getStack(n);
            if (!clazz.isInstance(class_17992.getItem())) continue;
            return true;
        }
        return false;
    }

    public static void b(Class<? extends Item> clazz) {
        for (int n = 0; n < 9; n = (int)((byte)(n + 1))) {
            ItemStack class_17992 = zd.w.player.getInventory().getStack(n);
            if (!clazz.isInstance(class_17992.getItem())) continue;
            zd.w.player.getInventory().setSelectedSlot(n);
            break;
        }
    }

    public static boolean a() {
        for (int n = 0; n < 9; n = (int)((byte)(n + 1))) {
            ItemStack class_17992 = zd.w.player.getInventory().getStack(n);
            if (!class_17992.isIn(ItemTags.SWORDS)) continue;
            return true;
        }
        return false;
    }

    public static void b() {
        for (int n = 0; n < 9; n = (int)((byte)(n + 1))) {
            ItemStack class_17992 = zd.w.player.getInventory().getStack(n);
            if (!class_17992.isIn(ItemTags.SWORDS)) continue;
            zd.w.player.getInventory().setSelectedSlot(n);
            break;
        }
    }

    private zd() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

