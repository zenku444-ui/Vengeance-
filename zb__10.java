/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.BlockState
 */
package com.vengeance.vengeanceclient.r.q.s;

import com.vengeance.vengeanceclient.p.p.s.zd;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.za;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;

public final class zb
extends com.vengeance.vengeanceclient.r.zb {
    private final ze b = new ze("Jump Delay", 0.0, 500.0, 100.0, 10.0);
    private final com.vengeance.vengeanceclient.r.r.za c = new com.vengeance.vengeanceclient.r.r.za("Holding Space", false);
    private final com.vengeance.vengeanceclient.utils.s.zb d = new com.vengeance.vengeanceclient.utils.s.zb();

    public zb() {
        super("Auto Head Hitter", "Auto jumps when there's a solid block above to make u go fast", -1, za.c);
        this.a(this.b, this.c);
    }

    @EventHandler
    private void onTickEvent(zd zd2) {
        if (this.d()) {
            return;
        }
        if (this.c.b() && !zb.a.options.jumpKey.isPressed()) {
            return;
        }
        if (this.b.a() > 0 && !this.d.a(this.b.a())) {
            return;
        }
        if (!zb.a.player.isOnGround()) {
            return;
        }
        BlockPos class_23382 = zb.a.player.getBlockPos();
        BlockPos class_23383 = class_23382.up(2);
        BlockState class_26802 = zb.a.world.getBlockState(class_23383);
        if (!class_26802.isAir() && class_26802.getBlock() != Blocks.WATER && class_26802.getBlock() != Blocks.LAVA) {
            zb.a.player.jump();
            this.d.a();
        }
    }
}

