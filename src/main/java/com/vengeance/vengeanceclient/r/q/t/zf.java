/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.screen.slot.SlotActionType
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.potion.Potion
 *  net.minecraft.component.type.PotionContentsComponent
 *  net.minecraft.client.gui.screen.Screen
 *  net.minecraft.client.gui.screen.ingame.InventoryScreen
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.component.DataComponentTypes
 */
package com.vengeance.vengeanceclient.r.q.t;

import com.vengeance.vengeanceclient.mixin.HandledScreenAccessor;
import com.vengeance.vengeanceclient.p.p.s.zd;
import com.vengeance.vengeanceclient.r.r.zc;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import com.vengeance.vengeanceclient.r.zb;
import java.util.ArrayList;
import java.util.Random;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.component.DataComponentTypes;

public final class zf
extends zb {
    private static final ze c = new ze("Delay", 10.0, 200.0, 50.0, 10.0);
    private static final ze d = new ze("Hover Delay", 10.0, 100.0, 25.0, 5.0);
    private static final ze e = new ze("Min Stack", 1.0, 64.0, 16.0, 1.0);
    private static final com.vengeance.vengeanceclient.r.r.za f = new com.vengeance.vengeanceclient.r.r.za("Hover Mode", false);
    private static final com.vengeance.vengeanceclient.r.r.za g = new com.vengeance.vengeanceclient.r.r.za("Health", true);
    private static final com.vengeance.vengeanceclient.r.r.za h = new com.vengeance.vengeanceclient.r.r.za("Regen", true);
    private static final com.vengeance.vengeanceclient.r.r.za i = new com.vengeance.vengeanceclient.r.r.za("Strength", false);
    private static final com.vengeance.vengeanceclient.r.r.za j = new com.vengeance.vengeanceclient.r.r.za("Speed", false);
    private static final com.vengeance.vengeanceclient.r.r.za k = new com.vengeance.vengeanceclient.r.r.za("TNT Carts", false);
    private static final com.vengeance.vengeanceclient.r.r.za l = new com.vengeance.vengeanceclient.r.r.za("Random Pick", true);
    private final zc m = new zc("Key", 82, false);
    private final com.vengeance.vengeanceclient.utils.s.zb n = new com.vengeance.vengeanceclient.utils.s.zb();
    private final Random o = new Random();
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;

    public zf() {
        super("Auto Refill", "Refills hotbar with potions and TNT carts", -1, za.b);
        this.a(this.m, c, d, e, f, g, h, i, j, k, l);
    }

    @EventHandler
    private void onTickEvent(zd zd2) {
        if (this.d()) {
            return;
        }
        if (f.b()) {
            this.n();
            return;
        }
        if (zf.a.currentScreen != null && !(zf.a.currentScreen instanceof InventoryScreen)) {
            return;
        }
        boolean bl = com.vengeance.vengeanceclient.utils.r.za.b(this.m.e());
        if (bl && !this.p) {
            this.o();
        }
        this.p = bl;
        if (!this.r) {
            return;
        }
        if (this.n.a(c.a())) {
            this.p();
        }
    }

    private void n() {
        Screen class_4372 = zf.a.currentScreen;
        if (!(class_4372 instanceof InventoryScreen)) {
            return;
        }
        InventoryScreen RealmsConnection = (InventoryScreen)class_4372;
        try {
            Slot focusedSlot = ((HandledScreenAccessor)RealmsConnection).getFocusedSlot();
            if (focusedSlot == null || focusedSlot.getIndex() < 9 || !this.a(focusedSlot.getStack()) || !this.r()) {
                return;
            }
            if (this.n.a(d.a() + this.o.nextInt(10))) {
                this.b(focusedSlot.getIndex());
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private void o() {
        if (!this.t()) {
            return;
        }
        this.q = zf.a.currentScreen instanceof InventoryScreen;
        if (!this.q) {
            assert (zf.a.player != null);
            a.setScreen((Screen)new InventoryScreen((PlayerEntity)zf.a.player));
        }
        this.r = true;
        this.n.a();
    }

    private void p() {
        if (!(zf.a.currentScreen instanceof InventoryScreen) || !this.r()) {
            this.q();
            return;
        }
        int n = this.s();
        if (n == -1) {
            this.q();
            return;
        }
        this.b(n);
    }

    private void q() {
        if (!this.q) {
            a.setScreen(null);
        }
        this.r = false;
    }

    private boolean r() {
        for (int i = 0; i < 9; ++i) {
            ItemStack class_17992 = zf.a.player.getInventory().getStack(i);
            if (!class_17992.isEmpty() && (!this.a(class_17992) || class_17992.getCount() >= e.a())) continue;
            return true;
        }
        return false;
    }

    private int s() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 9; i < 36; ++i) {
            if (!this.a(zf.a.player.getInventory().getStack(i))) continue;
            arrayList.add(i);
        }
        return arrayList.isEmpty() ? -1 : (Integer)arrayList.get(this.o.nextInt(arrayList.size()));
    }

    private boolean t() {
        return this.s() != -1;
    }

    private boolean a(ItemStack class_17992) {
        if (class_17992.isEmpty()) {
            return false;
        }
        if (k.b() && class_17992.getItem() == Items.TNT_MINECART) {
            return true;
        }
        if (!this.a(class_17992.getItem())) {
            return false;
        }
        PotionContentsComponent class_18442 = (PotionContentsComponent)class_17992.get(DataComponentTypes.POTION_CONTENTS);
        if (class_18442 == null || class_18442.potion().isEmpty()) {
            return false;
        }
        return class_18442.potion().map(RegistryEntry::value).map(Potion::getEffects).orElse(java.util.Collections.emptyList()).stream().anyMatch(class_12932 -> g.b() && class_12932.getEffectType().equals((Object)StatusEffects.INSTANT_HEALTH) || h.b() && class_12932.getEffectType().equals((Object)StatusEffects.REGENERATION) || i.b() && class_12932.getEffectType().equals((Object)StatusEffects.STRENGTH) || j.b() && class_12932.getEffectType().equals((Object)StatusEffects.SPEED));
    }

    private boolean a(Item class_17922) {
        return class_17922 == Items.POTION || class_17922 == Items.SPLASH_POTION || class_17922 == Items.LINGERING_POTION;
    }

    private void b(int n) {
        zf.a.interactionManager.clickSlot(zf.a.player.currentScreenHandler.syncId, n, 0, SlotActionType.QUICK_MOVE, (PlayerEntity)zf.a.player);
        this.n.a();
    }

    @Override
    public void b() {
        this.n.a();
        this.p = com.vengeance.vengeanceclient.utils.r.za.b(this.m.e());
        this.r = false;
        super.b();
    }

    @Override
    public void c() {
        if (zf.a.currentScreen instanceof InventoryScreen && !this.q) {
            a.setScreen(null);
        }
        this.r = false;
        super.c();
    }
}

