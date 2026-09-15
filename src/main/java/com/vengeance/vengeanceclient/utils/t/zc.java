/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.world.World
 *  net.minecraft.registry.Registry
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.registry.RegistryKeys
 *  net.minecraft.component.type.ItemEnchantmentsComponent
 *  net.minecraft.component.DataComponentTypes
 */
package com.vengeance.vengeanceclient.utils.t;

import java.util.Optional;
import net.minecraft.item.ItemStack;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.world.World;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.component.DataComponentTypes;

public final class zc {
    public static boolean a(ItemStack class_17992, World class_19372, RegistryEntry<Enchantment> class_68802) {
        if (class_17992 == null || class_19372 == null || class_68802 == null) {
            return false;
        }
        ItemEnchantmentsComponent class_93042 = (ItemEnchantmentsComponent)class_17992.get(DataComponentTypes.ENCHANTMENTS);
        if (class_93042 == null) {
            return false;
        }
        return class_93042.getLevel(class_68802) > 0;
    }

    public static boolean a(ItemStack class_17992, World class_19372, Enchantment class_18872) {
        Object object;
        Registry class_23782;
        if (class_17992 == null || class_19372 == null || class_18872 == null) {
            return false;
        }
        ItemEnchantmentsComponent class_93042 = (ItemEnchantmentsComponent)class_17992.get(DataComponentTypes.ENCHANTMENTS);
        if (class_93042 == null) {
            return false;
        }
        try {
            class_23782 = class_19372.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
            object = class_23782.getEntry((Object)class_18872);
            if (object != null) {
                return class_93042.getLevel((RegistryEntry)object) > 0;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        try {
            class_23782 = (Registry)class_19372.getRegistryManager().getClass().getMethod("get", RegistryKey.class).invoke((Object)class_19372.getRegistryManager(), RegistryKeys.ENCHANTMENT);
            object = class_23782.getClass().getMethod("getEntry", Object.class).invoke((Object)class_23782, class_18872);
            Integer n = (Integer)class_93042.getClass().getMethod("getLevel", object.getClass()).invoke((Object)class_93042, object);
            return n != null && n > 0;
        }
        catch (Throwable throwable) {
            try {
                Integer n = (Integer)class_93042.getClass().getMethod("getLevel", Enchantment.class).invoke((Object)class_93042, class_18872);
                return n != null && n > 0;
            }
            catch (Throwable throwable2) {
                return false;
            }
        }
    }

    public static boolean a(ItemStack class_17992, World class_19372, RegistryKey<Enchantment> class_53212) {
        Object object;
        Object object2;
        Object object3;
        if (class_17992 == null || class_19372 == null || class_53212 == null) {
            return false;
        }
        ItemEnchantmentsComponent class_93042 = (ItemEnchantmentsComponent)class_17992.get(DataComponentTypes.ENCHANTMENTS);
        if (class_93042 == null) {
            return false;
        }
        try {
            object3 = class_19372.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
            object2 = (Enchantment)object3.get(class_53212);
            if (object2 != null && (object = object3.getEntry(object2)) != null) {
                return class_93042.getLevel((RegistryEntry)object) > 0;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        try {
            object3 = class_19372.getRegistryManager().getClass().getMethod("get", RegistryKey.class).invoke((Object)class_19372.getRegistryManager(), RegistryKeys.ENCHANTMENT);
            object2 = object3.getClass().getMethod("getOrEmpty", RegistryKey.class).invoke(object3, class_53212);
            object = (Optional)object2;
            if (((Optional)object).isPresent()) {
                Object t = ((Optional)object).get();
                Object object4 = object3.getClass().getMethod("getEntry", Object.class).invoke(object3, t);
                return zc.a(class_17992, class_19372, (RegistryEntry<Enchantment>)((RegistryEntry)object4));
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return false;
    }
}

