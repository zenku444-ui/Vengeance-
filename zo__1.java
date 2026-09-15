/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.sound.PositionedSoundInstance
 *  net.minecraft.client.sound.SoundInstance
 *  net.minecraft.entity.decoration.ArmorStandEntity
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Box
 *  net.minecraft.text.Text
 *  net.minecraft.sound.SoundEvent
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.client.util.math.MatrixStack
 *  org.lwjgl.opengl.GL11
 */
package com.vengeance.vengeanceclient.r.q.t;

import com.vengeance.vengeanceclient.p.p.s.zd;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.utils.w.zm;
import java.awt.Color;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.text.Text;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.client.util.math.MatrixStack;
import org.lwjgl.opengl.GL11;

public final class zo
extends com.vengeance.vengeanceclient.r.zb {
    private static final int b = 500;
    private static final int c = 3000;
    private static final String d = "[TrapSave] ";
    private static final Box e = new Box(0.0, 0.0, 0.0, 1.0, 0.0625, 1.0);
    private static final Box f = new Box(0.375, 0.0, 0.375, 0.625, 0.625, 0.625);
    private static final Box g = new Box(0.25, 0.0, 0.25, 0.75, 0.6, 0.75);
    private static final Box h = new Box(0.0625, 0.0, 0.0625, 0.9375, 0.0625, 0.9375);
    private static final Box i = new Box(0.375, 0.0, 0.125, 0.625, 0.625, 0.875);
    private static final Box j = new Box(0.0, 0.0, 0.0, 1.0, 0.125, 1.0);
    private static final Box k = new Box(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
    private final ze l = new ze("Scan Radius", 3.0, 20.0, 8.0, 1.0);
    private final ze m = new ze("Scan Height", 0.0, 30.0, 8.0, 1.0);
    private final ze n = new ze("Max Expansion", 0.0, 100.0, 20.0, 1.0);
    private final com.vengeance.vengeanceclient.r.r.za o = new com.vengeance.vengeanceclient.r.r.za("Sound Alert", true);
    private final com.vengeance.vengeanceclient.r.r.za p = new com.vengeance.vengeanceclient.r.r.za("Show Warning", true);
    private final ze q = new ze("Outline Width", 1.0, 5.0, 2.0, 1.0);
    private final ze r = new ze("TNT Color", 0.0, 1.6777215E7, 1.675392E7, 1.0);
    private final ze s = new ze("Redstone Color", 0.0, 1.6777215E7, 1.671168E7, 1.0);
    private final ze t = new ze("Piston Color", 0.0, 1.6777215E7, 9127187.0, 1.0);
    private final ze u = new ze("Lever Color", 0.0, 1.6777215E7, 1.677696E7, 1.0);
    private final ze v = new ze("Armor Stand Color", 0.0, 1.6777215E7, 65535.0, 1.0);
    private final com.vengeance.vengeanceclient.utils.s.zb x = new com.vengeance.vengeanceclient.utils.s.zb();
    private final com.vengeance.vengeanceclient.utils.s.zb y = new com.vengeance.vengeanceclient.utils.s.zb();
    private final List<za> z = new ArrayList<za>();
    private boolean aa;
    private String ab = "";
    private int ac;
    private BlockPos ad;
    private int ae;
    private int af;

    public zo() {
        super("Trap Save", "Detects trap blocks and armor stands around the player", -1, com.vengeance.vengeanceclient.r.za.b);
        this.a(this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v);
    }

    @EventHandler
    private void onRender3D(com.vengeance.vengeanceclient.p.p.t.zb zb2) {
        if (this.n() || this.z.isEmpty()) {
            return;
        }
        this.a(zb2.a());
    }

    @EventHandler
    private void onRender2D(com.vengeance.vengeanceclient.p.p.t.za za2) {
        if (this.n() || !this.p.b() || !this.aa) {
            return;
        }
        this.a(za2);
    }

    @EventHandler
    private void onTick(zd zd2) {
        if (this.n()) {
            return;
        }
        if (this.x.a(500L)) {
            this.o();
            this.x.a();
        }
        if (this.aa && this.y.a(3000L)) {
            this.p();
        }
    }

    private boolean n() {
        return zo.a.player == null || zo.a.world == null || !this.l();
    }

    private void o() {
        int n;
        int n2;
        BlockPos class_23382 = zo.a.player.getBlockPos();
        if (this.a(class_23382, n2 = this.l.a(), n = this.m.a())) {
            return;
        }
        List<za> list = this.c(class_23382, n2, n);
        this.z.clear();
        this.z.addAll(list);
        this.b(class_23382, n2, n);
        if (!list.isEmpty() && !this.aa) {
            this.a(list);
        }
    }

    private boolean a(BlockPos class_23382, int n, int n2) {
        return this.ad != null && this.ad.equals((Object)class_23382) && this.ae == n && this.af == n2;
    }

    private void b(BlockPos class_23382, int n, int n2) {
        this.ad = class_23382;
        this.ae = n;
        this.af = n2;
    }

    private List<za> c(BlockPos class_23382, int n, int n2) {
        HashSet<BlockPos> hashSet = new HashSet<BlockPos>();
        ArrayList<za> arrayList = new ArrayList<za>();
        int n3 = n * n;
        boolean bl = n2 == 0;
        int n4 = bl ? zo.a.world.getBottomY() : class_23382.getY() - n2;
        int n5 = bl ? zo.a.world.getBottomY() + zo.a.world.getHeight() - 1 : class_23382.getY() + n2;
        for (int i = -n; i <= n; ++i) {
            for (int j = -n; j <= n; ++j) {
                if (i * i + j * j > n3) continue;
                for (int k = n4; k <= n5; ++k) {
                    za za2;
                    Block class_22482;
                    zb zb2;
                    BlockPos class_23383 = new BlockPos(class_23382.getX() + i, k, class_23382.getZ() + j);
                    if (hashSet.contains(class_23383) || (zb2 = this.a(class_22482 = zo.a.world.getBlockState(class_23383).getBlock())) == zb.a || (za2 = this.a(class_23383, zb2, hashSet)).d()) continue;
                    arrayList.add(za2);
                }
            }
        }
        this.a(class_23382, n, n2, arrayList);
        return arrayList;
    }

    private za a(BlockPos class_23382, zb zb2, Set<BlockPos> set) {
        za za2 = new za(zb2);
        ArrayDeque<BlockPos> arrayDeque = new ArrayDeque<BlockPos>();
        HashSet<BlockPos> hashSet = new HashSet<BlockPos>();
        int n = this.n.a();
        boolean bl = n == 0;
        int n2 = 1000;
        arrayDeque.offer(class_23382);
        while (!arrayDeque.isEmpty() && (bl ? za2.e() < n2 : za2.e() < n)) {
            BlockPos class_23383 = (BlockPos)arrayDeque.poll();
            if (class_23383 == null || hashSet.contains(class_23383) || set.contains(class_23383)) continue;
            hashSet.add(class_23383);
            set.add(class_23383);
            Block class_22482 = zo.a.world.getBlockState(class_23383).getBlock();
            zb zb3 = this.a(class_22482);
            if (zb3 == zb.a || !this.a(zb2, zb3)) continue;
            za2.a(class_23383, zb3);
            for (BlockPos class_23384 : this.a(class_23383)) {
                if (hashSet.contains(class_23384)) continue;
                arrayDeque.offer(class_23384);
            }
        }
        return za2;
    }

    private boolean a(zb zb2, zb zb3) {
        if (zb2 == zb3) {
            return true;
        }
        EnumSet<zb> enumSet = EnumSet.of(zb.e, zb.c, zb.f, zb.g);
        EnumSet<zb> enumSet2 = EnumSet.of(zb.d, zb.h, zb.b);
        if (enumSet.contains((Object)zb2) && enumSet.contains((Object)zb3)) {
            return true;
        }
        if (enumSet2.contains((Object)zb2) && enumSet2.contains((Object)zb3)) {
            return true;
        }
        if (enumSet.contains((Object)zb2) && enumSet2.contains((Object)zb3)) {
            return true;
        }
        return enumSet2.contains((Object)zb2) && enumSet.contains((Object)zb3);
    }

    private List<BlockPos> a(BlockPos class_23382) {
        return Arrays.asList(class_23382.north(), class_23382.south(), class_23382.east(), class_23382.west(), class_23382.up(), class_23382.down(), class_23382.north().up(), class_23382.south().up(), class_23382.east().up(), class_23382.west().up(), class_23382.north().down(), class_23382.south().down(), class_23382.east().down(), class_23382.west().down());
    }

    private void a(BlockPos class_23382, int n, int n2, List<za> list) {
        boolean bl = n2 == 0;
        int n3 = bl ? zo.a.world.getBottomY() : class_23382.getY() - n2;
        int n4 = bl ? zo.a.world.getBottomY() + zo.a.world.getHeight() - 1 : class_23382.getY() + n2;
        Box HorizontalFacingBlock = new Box((double)(class_23382.getX() - n), (double)n3, (double)(class_23382.getZ() - n), (double)(class_23382.getX() + n), (double)n4, (double)(class_23382.getZ() + n));
        List list2 = zo.a.world.getEntitiesByClass(ArmorStandEntity.class, HorizontalFacingBlock, class_15312 -> class_15312 != null && class_15312.isAlive());
        if (!list2.isEmpty()) {
            za za2 = new za(zb.i);
            for (ArmorStandEntity class_15313 : list2) {
                za2.a(class_15313);
            }
            list.add(za2);
        }
    }

    private zb a(Block class_22482) {
        if (class_22482 == Blocks.TNT) {
            return zb.b;
        }
        if (class_22482 == Blocks.LEVER) {
            return zb.c;
        }
        if (class_22482 == Blocks.PISTON || class_22482 == Blocks.STICKY_PISTON) {
            return zb.d;
        }
        if (this.b(class_22482)) {
            return zb.e;
        }
        if (this.c(class_22482)) {
            return zb.f;
        }
        if (class_22482 == Blocks.TRIPWIRE_HOOK) {
            return zb.g;
        }
        if (class_22482 == Blocks.DISPENSER || class_22482 == Blocks.DROPPER) {
            return zb.h;
        }
        return zb.a;
    }

    private boolean b(Block class_22482) {
        return class_22482 == Blocks.REDSTONE_WIRE || class_22482 == Blocks.REDSTONE_TORCH || class_22482 == Blocks.REDSTONE_WALL_TORCH || class_22482 == Blocks.REDSTONE_BLOCK || class_22482 == Blocks.OBSERVER || class_22482 == Blocks.REPEATER || class_22482 == Blocks.COMPARATOR;
    }

    private boolean c(Block class_22482) {
        return class_22482 == Blocks.STONE_PRESSURE_PLATE || class_22482 == Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE || class_22482 == Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE;
    }

    private void a(List<za> list) {
        this.aa = true;
        this.ab = list.get(0).a().a();
        this.ac = list.size();
        this.y.a();
        if (this.o.b()) {
            a.getSoundManager().play((SoundInstance)PositionedSoundInstance.ui((SoundEvent)((SoundEvent)SoundEvents.BLOCK_NOTE_BLOCK_PLING.comp_349()), (float)2.0f));
        }
        com.vengeance.vengeanceclient.utils.t.za.e("[TrapSave] Trap detected: " + this.ab + " (" + this.ac + " traps)");
    }

    private void a(com.vengeance.vengeanceclient.p.p.t.za za2) {
        int n = za2.b() / 2;
        int n2 = 50;
        int n3 = 210;
        int n4 = 40;
        int n5 = n - n3 / 2;
        String string = "TRAP DETECTED!";
        String string2 = this.ab + " (" + this.ac + " traps)";
        za2.a().fill(n5 - 10, n2 - 10, n5 + n3, n2 + n4, -2130771968);
        za2.a().drawText(zo.a.textRenderer, (Text)Text.literal((String)string), n5, n2, -1, true);
        za2.a().drawText(zo.a.textRenderer, (Text)Text.literal((String)string2), n5, n2 + 15, -1, true);
    }

    private void a(MatrixStack class_45872) {
        zm.b();
        GL11.glLineWidth((float)this.q.b());
        for (za za2 : this.z) {
            this.a(class_45872, za2);
        }
        zm.c();
    }

    private void a(MatrixStack class_45872, za za2) {
        Color color = this.a(za2.a());
        for (Map.Entry<BlockPos, zb> class_15312 : za2.b().entrySet()) {
            BlockPos class_23382 = class_15312.getKey();
            Block class_22482 = zo.a.world.getBlockState(class_23382).getBlock();
            Box HorizontalFacingBlock = this.d(class_22482).offset(class_23382);
            zm.b(class_45872, HorizontalFacingBlock, color);
        }
        for (ArmorStandEntity class_15312 : za2.c()) {
            if (!class_15312.isAlive()) continue;
            zm.b(class_45872, class_15312.getBoundingBox(), color);
        }
    }

    private Color a(zb zb2) {
        int n = 200;
        return switch (zb2.ordinal()) {
            case 1 -> new Color(this.r.a() | n << 24, true);
            case 4 -> new Color(this.s.a() | n << 24, true);
            case 3 -> new Color(this.t.a() | n << 24, true);
            case 2, 5 -> new Color(this.u.a() | n << 24, true);
            case 8 -> new Color(this.v.a() | n << 24, true);
            case 6 -> new Color(0x800080 | n << 24, true);
            case 7 -> new Color(0x696969 | n << 24, true);
            default -> new Color(0xFFFFFF | n << 24, true);
        };
    }

    private Box d(Block class_22482) {
        if (class_22482 == Blocks.REDSTONE_WIRE) {
            return e;
        }
        if (class_22482 == Blocks.REDSTONE_TORCH || class_22482 == Blocks.REDSTONE_WALL_TORCH) {
            return f;
        }
        if (class_22482 == Blocks.LEVER) {
            return g;
        }
        if (this.c(class_22482)) {
            return h;
        }
        if (class_22482 == Blocks.TRIPWIRE_HOOK) {
            return i;
        }
        if (class_22482 == Blocks.REPEATER || class_22482 == Blocks.COMPARATOR) {
            return j;
        }
        return k;
    }

    private void p() {
        this.aa = false;
        this.ab = "";
        this.ac = 0;
    }

    @Override
    public void b() {
        super.b();
        this.z.clear();
        this.p();
        this.ad = null;
    }

    @Override
    public void c() {
        this.p();
        this.z.clear();
        this.ad = null;
        super.c();
    }

    private static final class zb
    extends Enum<zb> {
        public static final /* enum */ zb a = new zb("");
        public static final /* enum */ zb b = new zb("TNT");
        public static final /* enum */ zb c = new zb("Lever");
        public static final /* enum */ zb d = new zb("Piston");
        public static final /* enum */ zb e = new zb("Redstone");
        public static final /* enum */ zb f = new zb("Pressure Plate");
        public static final /* enum */ zb g = new zb("Tripwire");
        public static final /* enum */ zb h = new zb("Dispenser");
        public static final /* enum */ zb i = new zb("Armor Stand");
        private final String j;
        private static final /* synthetic */ zb[] k;

        public static zb[] values() {
            return (zb[])k.clone();
        }

        public static zb valueOf(String string) {
            return Enum.valueOf(zb.class, string);
        }

        private zb(String string2) {
            this.j = string2;
        }

        public String a() {
            return this.j;
        }

        private static /* synthetic */ zb[] b() {
            return new zb[]{a, b, c, d, e, f, g, h, i};
        }

        static {
            k = zb.b();
        }
    }

    private static class za {
        private final zb a;
        private final Map<BlockPos, zb> b = new HashMap<BlockPos, zb>();
        private final List<ArmorStandEntity> c = new ArrayList<ArmorStandEntity>();

        za(zb zb2) {
            this.a = zb2;
        }

        public zb a() {
            return this.a;
        }

        public Map<BlockPos, zb> b() {
            return this.b;
        }

        public List<ArmorStandEntity> c() {
            return this.c;
        }

        public void a(BlockPos class_23382, zb zb2) {
            this.b.put(class_23382, zb2);
        }

        public void a(ArmorStandEntity class_15312) {
            this.c.add(class_15312);
        }

        public boolean d() {
            return this.b.isEmpty() && this.c.isEmpty();
        }

        public int e() {
            return this.b.size() + this.c.size();
        }
    }
}

