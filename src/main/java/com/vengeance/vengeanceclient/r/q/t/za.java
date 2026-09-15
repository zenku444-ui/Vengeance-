/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.screen.slot.SlotActionType
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.client.gui.screen.ingame.CraftingScreen
 */
package com.vengeance.vengeanceclient.r.q.t;

import com.vengeance.vengeanceclient.p.p.s.zd;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.zb;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.Arrays;
import java.util.List;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.client.gui.screen.ingame.CraftingScreen;

public final class za
extends zb {
    private static final List<za$recipe> b = Arrays.asList(new za$recipe(Items.DIAMOND_SWORD, Items.DIAMOND, 2, Items.STICK, 1, new int[]{-1, 1, -1, -1, 1, -1, -1, 2, -1}), new za$recipe(Items.DIAMOND_PICKAXE, Items.DIAMOND, 3, Items.STICK, 2, new int[]{1, 1, 1, -1, 2, -1, -1, 2, -1}), new za$recipe(Items.DIAMOND_AXE, Items.DIAMOND, 3, Items.STICK, 2, new int[]{1, 1, -1, 1, 2, -1, -1, 2, -1}), new za$recipe(Items.DIAMOND_SHOVEL, Items.DIAMOND, 1, Items.STICK, 2, new int[]{-1, 1, -1, -1, 2, -1, -1, 2, -1}), new za$recipe(Items.IRON_SWORD, Items.IRON_INGOT, 2, Items.STICK, 1, new int[]{-1, 1, -1, -1, 1, -1, -1, 2, -1}), new za$recipe(Items.IRON_PICKAXE, Items.IRON_INGOT, 3, Items.STICK, 2, new int[]{1, 1, 1, -1, 2, -1, -1, 2, -1}), new za$recipe(Items.IRON_AXE, Items.IRON_INGOT, 3, Items.STICK, 2, new int[]{1, 1, -1, 1, 2, -1, -1, 2, -1}), new za$recipe(Items.IRON_SHOVEL, Items.IRON_INGOT, 1, Items.STICK, 2, new int[]{-1, 1, -1, -1, 2, -1, -1, 2, -1}), new za$recipe(Items.GOLDEN_SWORD, Items.GOLD_INGOT, 2, Items.STICK, 1, new int[]{-1, 1, -1, -1, 1, -1, -1, 2, -1}), new za$recipe(Items.GOLDEN_PICKAXE, Items.GOLD_INGOT, 3, Items.STICK, 2, new int[]{1, 1, 1, -1, 2, -1, -1, 2, -1}), new za$recipe(Items.GOLDEN_AXE, Items.GOLD_INGOT, 3, Items.STICK, 2, new int[]{1, 1, -1, 1, 2, -1, -1, 2, -1}), new za$recipe(Items.GOLDEN_SHOVEL, Items.GOLD_INGOT, 1, Items.STICK, 2, new int[]{-1, 1, -1, -1, 2, -1, -1, 2, -1}), new za$recipe(Items.WOODEN_SWORD, Items.OAK_PLANKS, 2, Items.STICK, 1, new int[]{-1, 1, -1, -1, 1, -1, -1, 2, -1}), new za$recipe(Items.WOODEN_PICKAXE, Items.OAK_PLANKS, 3, Items.STICK, 2, new int[]{1, 1, 1, -1, 2, -1, -1, 2, -1}), new za$recipe(Items.WOODEN_AXE, Items.OAK_PLANKS, 3, Items.STICK, 2, new int[]{1, 1, -1, 1, 2, -1, -1, 2, -1}), new za$recipe(Items.WOODEN_SHOVEL, Items.OAK_PLANKS, 1, Items.STICK, 2, new int[]{-1, 1, -1, -1, 2, -1, -1, 2, -1}), new za$recipe(Items.DIAMOND_HELMET, Items.DIAMOND, 5, new int[]{1, 1, 1, 1, -1, 1, -1, -1, -1}), new za$recipe(Items.DIAMOND_CHESTPLATE, Items.DIAMOND, 8, new int[]{1, -1, 1, 1, 1, 1, 1, 1, 1}), new za$recipe(Items.DIAMOND_LEGGINGS, Items.DIAMOND, 7, new int[]{1, 1, 1, 1, -1, 1, 1, -1, 1}), new za$recipe(Items.DIAMOND_BOOTS, Items.DIAMOND, 4, new int[]{-1, -1, -1, 1, -1, 1, 1, -1, 1}), new za$recipe(Items.IRON_HELMET, Items.IRON_INGOT, 5, new int[]{1, 1, 1, 1, -1, 1, -1, -1, -1}), new za$recipe(Items.IRON_CHESTPLATE, Items.IRON_INGOT, 8, new int[]{1, -1, 1, 1, 1, 1, 1, 1, 1}), new za$recipe(Items.IRON_LEGGINGS, Items.IRON_INGOT, 7, new int[]{1, 1, 1, 1, -1, 1, 1, -1, 1}), new za$recipe(Items.IRON_BOOTS, Items.IRON_INGOT, 4, new int[]{-1, -1, -1, 1, -1, 1, 1, -1, 1}), new za$recipe(Items.GOLDEN_HELMET, Items.GOLD_INGOT, 5, new int[]{1, 1, 1, 1, -1, 1, -1, -1, -1}), new za$recipe(Items.GOLDEN_CHESTPLATE, Items.GOLD_INGOT, 8, new int[]{1, -1, 1, 1, 1, 1, 1, 1, 1}), new za$recipe(Items.GOLDEN_LEGGINGS, Items.GOLD_INGOT, 7, new int[]{1, 1, 1, 1, -1, 1, 1, -1, 1}), new za$recipe(Items.GOLDEN_BOOTS, Items.GOLD_INGOT, 4, new int[]{-1, -1, -1, 1, -1, 1, 1, -1, 1}), new za$recipe(Items.LEATHER_HELMET, Items.LEATHER, 5, new int[]{1, 1, 1, 1, -1, 1, -1, -1, -1}), new za$recipe(Items.LEATHER_CHESTPLATE, Items.LEATHER, 8, new int[]{1, -1, 1, 1, 1, 1, 1, 1, 1}), new za$recipe(Items.LEATHER_LEGGINGS, Items.LEATHER, 7, new int[]{1, 1, 1, 1, -1, 1, 1, -1, 1}), new za$recipe(Items.LEATHER_BOOTS, Items.LEATHER, 4, new int[]{-1, -1, -1, 1, -1, 1, 1, -1, 1}), new za$recipe(Items.GOLDEN_APPLE, Items.GOLD_INGOT, 8, Items.APPLE, 1, new int[]{1, 1, 1, 1, 2, 1, 1, 1, 1}));
    private final com.vengeance.vengeanceclient.r.r.za c = new com.vengeance.vengeanceclient.r.r.za("Swords", true);
    private final com.vengeance.vengeanceclient.r.r.za d = new com.vengeance.vengeanceclient.r.r.za("Pickaxes", true);
    private final com.vengeance.vengeanceclient.r.r.za e = new com.vengeance.vengeanceclient.r.r.za("Axes", true);
    private final com.vengeance.vengeanceclient.r.r.za f = new com.vengeance.vengeanceclient.r.r.za("Shovels", true);
    private final com.vengeance.vengeanceclient.r.r.za g = new com.vengeance.vengeanceclient.r.r.za("Helmets", true);
    private final com.vengeance.vengeanceclient.r.r.za h = new com.vengeance.vengeanceclient.r.r.za("Chestplates", true);
    private final com.vengeance.vengeanceclient.r.r.za i = new com.vengeance.vengeanceclient.r.r.za("Leggings", true);
    private final com.vengeance.vengeanceclient.r.r.za j = new com.vengeance.vengeanceclient.r.r.za("Boots", true);
    private final com.vengeance.vengeanceclient.r.r.za k = new com.vengeance.vengeanceclient.r.r.za("Golden Apples", true);
    private final ze l = new ze("Craft Delay", 0.0, 500.0, 100.0, 10.0);
    private final com.vengeance.vengeanceclient.utils.s.zb m = new com.vengeance.vengeanceclient.utils.s.zb();
    private boolean n = false;

    public za() {
        super("Auto Crafter", "Automatically crafts items when crafting table is open", -1, com.vengeance.vengeanceclient.r.za.b);
        this.a(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
    }

    @EventHandler
    private void onTickEvent(zd zd2) {
        if (!this.n()) {
            return;
        }
        if (!this.m.a(this.l.a())) {
            return;
        }
        if (this.n) {
            this.s();
        } else if (this.o()) {
            this.p();
        }
    }

    private boolean n() {
        return za.a.player != null && za.a.world != null && za.a.currentScreen instanceof CraftingScreen;
    }

    private boolean o() {
        return this.c.b() || this.d.b() || this.e.b() || this.f.b() || this.g.b() || this.h.b() || this.i.b() || this.j.b() || this.k.b();
    }

    private void p() {
        za$recipe za2 = this.q();
        if (za2 != null) {
            this.c(za2);
        }
    }

    private za$recipe q() {
        Object object;
        if (this.k.b() && (object = this.t()) != null && this.b((za$recipe)object)) {
            return (za$recipe)object;
        }
        for (za$recipe za2 : b) {
            if (za2.a == Items.GOLDEN_APPLE || !this.a(za2) || !this.b(za2) || !this.a(za2.a) || this.k.b() && this.e(za2)) continue;
            return za2;
        }
        return null;
    }

    private boolean a(za$recipe za2) {
        Item class_17922 = za2.a;
        if (this.i(class_17922)) {
            return this.c.b();
        }
        if (this.j(class_17922)) {
            return this.d.b();
        }
        if (this.k(class_17922)) {
            return this.e.b();
        }
        if (this.l(class_17922)) {
            return this.f.b();
        }
        if (this.e(class_17922)) {
            return this.g.b();
        }
        if (this.f(class_17922)) {
            return this.h.b();
        }
        if (this.g(class_17922)) {
            return this.i.b();
        }
        if (this.h(class_17922)) {
            return this.j.b();
        }
        return false;
    }

    private boolean b(za$recipe za2) {
        if (this.c(za2.b) < za2.c) {
            return false;
        }
        return za2.d == null || this.c(za2.d) >= za2.e;
    }

    private boolean a(Item class_17922) {
        if (class_17922 == Items.GOLDEN_APPLE) {
            return true;
        }
        return !this.d(class_17922);
    }

    private void c(za$recipe za2) {
        this.r();
        this.d(za2);
        this.n = true;
        this.m.a();
    }

    private void d(za$recipe za2) {
        for (int i = 0; i < za2.f.length; ++i) {
            Item class_17922;
            int n = za2.f[i];
            if (n == -1) continue;
            Item class_17923 = class_17922 = n == 1 ? za2.b : za2.d;
            if (class_17922 == null) continue;
            this.a(class_17922, i + 1);
        }
    }

    private void a(Item class_17922, int n) {
        int n2 = this.b(class_17922);
        if (n2 != -1) {
            za.a.interactionManager.clickSlot(za.a.player.currentScreenHandler.syncId, n2, 1, SlotActionType.PICKUP, (PlayerEntity)za.a.player);
            za.a.interactionManager.clickSlot(za.a.player.currentScreenHandler.syncId, n, 1, SlotActionType.PICKUP, (PlayerEntity)za.a.player);
        }
    }

    private void r() {
        for (int i = 1; i <= 9; ++i) {
            ItemStack class_17992 = za.a.player.currentScreenHandler.getSlot(i).getStack();
            if (class_17992.isEmpty()) continue;
            za.a.interactionManager.clickSlot(za.a.player.currentScreenHandler.syncId, i, 0, SlotActionType.QUICK_MOVE, (PlayerEntity)za.a.player);
        }
    }

    private void s() {
        ItemStack class_17992 = za.a.player.currentScreenHandler.getSlot(0).getStack();
        if (!class_17992.isEmpty()) {
            za.a.interactionManager.clickSlot(za.a.player.currentScreenHandler.syncId, 0, 0, SlotActionType.QUICK_MOVE, (PlayerEntity)za.a.player);
        }
        this.n = false;
        this.m.a();
    }

    private int b(Item class_17922) {
        int n = -1;
        int n2 = 0;
        for (int i = 1; i < za.a.player.currentScreenHandler.slots.size(); ++i) {
            ItemStack class_17992 = za.a.player.currentScreenHandler.getSlot(i).getStack();
            if (class_17992.isEmpty() || class_17992.getItem() != class_17922 || class_17992.getCount() <= n2) continue;
            n2 = class_17992.getCount();
            n = i;
        }
        return n;
    }

    private int c(Item class_17922) {
        int n = 0;
        for (int i = 0; i < za.a.player.getInventory().size(); ++i) {
            ItemStack class_17992 = za.a.player.getInventory().getStack(i);
            if (class_17992.isEmpty() || class_17992.getItem() != class_17922) continue;
            n += class_17992.getCount();
        }
        return n;
    }

    private boolean d(Item class_17922) {
        return this.c(class_17922) > 0;
    }

    private za$recipe t() {
        return b.stream().filter(za2 -> za2.a == Items.GOLDEN_APPLE).findFirst().orElse(null);
    }

    private boolean e(za$recipe za2) {
        return za2.b == Items.GOLD_INGOT || za2.d == Items.GOLD_INGOT;
    }

    private boolean e(Item class_17922) {
        return class_17922 == Items.DIAMOND_HELMET || class_17922 == Items.IRON_HELMET || class_17922 == Items.GOLDEN_HELMET || class_17922 == Items.LEATHER_HELMET;
    }

    private boolean f(Item class_17922) {
        return class_17922 == Items.DIAMOND_CHESTPLATE || class_17922 == Items.IRON_CHESTPLATE || class_17922 == Items.GOLDEN_CHESTPLATE || class_17922 == Items.LEATHER_CHESTPLATE;
    }

    private boolean g(Item class_17922) {
        return class_17922 == Items.DIAMOND_LEGGINGS || class_17922 == Items.IRON_LEGGINGS || class_17922 == Items.GOLDEN_LEGGINGS || class_17922 == Items.LEATHER_LEGGINGS;
    }

    private boolean h(Item class_17922) {
        return class_17922 == Items.DIAMOND_BOOTS || class_17922 == Items.IRON_BOOTS || class_17922 == Items.GOLDEN_BOOTS || class_17922 == Items.LEATHER_BOOTS;
    }

    private boolean i(Item class_17922) {
        return class_17922 == Items.DIAMOND_SWORD || class_17922 == Items.IRON_SWORD || class_17922 == Items.GOLDEN_SWORD || class_17922 == Items.WOODEN_SWORD;
    }

    private boolean j(Item class_17922) {
        return class_17922 == Items.DIAMOND_PICKAXE || class_17922 == Items.IRON_PICKAXE || class_17922 == Items.GOLDEN_PICKAXE || class_17922 == Items.WOODEN_PICKAXE;
    }

    private boolean k(Item class_17922) {
        return class_17922 == Items.DIAMOND_AXE || class_17922 == Items.IRON_AXE || class_17922 == Items.GOLDEN_AXE || class_17922 == Items.WOODEN_AXE;
    }

    private boolean l(Item class_17922) {
        return class_17922 == Items.DIAMOND_SHOVEL || class_17922 == Items.IRON_SHOVEL || class_17922 == Items.GOLDEN_SHOVEL || class_17922 == Items.WOODEN_SHOVEL;
    }

    @Override
    public void b() {
        this.u();
        super.b();
    }

    @Override
    public void c() {
        this.u();
        super.c();
    }

    private void u() {
        this.n = false;
        this.m.a();
    }

    private record za$recipe(Item a, Item b, int c, Item d, int e, int[] f) {
        za$recipe(Item class_17922, Item class_17923, int n, int[] nArray) {
            this(class_17922, class_17923, n, null, 0, nArray);
        }

        @Override
        public final String toString() {
            return "Recipe[result=" + this.a + ", material1=" + this.b + ", count1=" + this.c + ", material2=" + this.d + ", count2=" + this.e + ", pattern=" + java.util.Arrays.toString(this.f) + "]";
        }
    }
}

