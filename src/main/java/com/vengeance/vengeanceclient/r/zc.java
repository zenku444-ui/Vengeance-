/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.r;

import com.vengeance.vengeanceclient.r.q.q.za;
import com.vengeance.vengeanceclient.r.q.q.zaa;
import com.vengeance.vengeanceclient.r.q.q.zab;
import com.vengeance.vengeanceclient.r.q.q.zac;
import com.vengeance.vengeanceclient.r.q.q.zad;
import com.vengeance.vengeanceclient.r.q.q.zb;
import com.vengeance.vengeanceclient.r.q.q.zg;
import com.vengeance.vengeanceclient.r.q.q.zs;
import com.vengeance.vengeanceclient.r.q.q.zt;
import com.vengeance.vengeanceclient.r.q.q.zu;
import com.vengeance.vengeanceclient.r.q.q.zw;
import com.vengeance.vengeanceclient.r.q.q.zx;
import com.vengeance.vengeanceclient.r.q.q.zy;
import com.vengeance.vengeanceclient.r.q.q.zz;
import com.vengeance.vengeanceclient.r.q.u.zd;
import com.vengeance.vengeanceclient.r.q.u.ze;
import com.vengeance.vengeanceclient.r.q.u.zf;
import com.vengeance.vengeanceclient.r.q.u.zh;
import com.vengeance.vengeanceclient.r.q.u.zi;
import com.vengeance.vengeanceclient.r.q.u.zj;
import com.vengeance.vengeanceclient.r.q.u.zk;
import com.vengeance.vengeanceclient.r.q.u.zl;
import com.vengeance.vengeanceclient.r.q.u.zm;
import com.vengeance.vengeanceclient.r.q.u.zn;
import com.vengeance.vengeanceclient.r.q.u.zo;
import com.vengeance.vengeanceclient.r.q.u.zp;
import com.vengeance.vengeanceclient.r.q.u.zq;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public final class zc {
    private final List<com.vengeance.vengeanceclient.r.zb> a = new ArrayList<com.vengeance.vengeanceclient.r.zb>();

    public zc() {
        this.c();
    }

    public List<com.vengeance.vengeanceclient.r.zb> a() {
        return this.a.stream().filter(com.vengeance.vengeanceclient.r.zb::l).toList();
    }

    public List<com.vengeance.vengeanceclient.r.zb> a(com.vengeance.vengeanceclient.r.za za2) {
        return this.a.stream().filter(zb2 -> zb2.g() == za2).toList();
    }

    public List<com.vengeance.vengeanceclient.r.zb> b(com.vengeance.vengeanceclient.r.za za2) {
        return this.a(za2);
    }

    public <T extends com.vengeance.vengeanceclient.r.zb> Optional<T> a(Class<T> clazz) {
        return this.a.stream().filter(zb2 -> zb2.getClass().equals(clazz)).map(clazz::cast).findFirst();
    }

    private void c() {
        this.a(new com.vengeance.vengeanceclient.r.q.q.ze(), new zz(), new zaa(), new zab(), new zs(), new zy(), new com.vengeance.vengeanceclient.r.q.q.zj(), new zb(), new zac(), new com.vengeance.vengeanceclient.r.q.q.zq(), new za(), new zw(), new com.vengeance.vengeanceclient.r.q.q.zd(), new zx(), new zg(), new com.vengeance.vengeanceclient.r.q.q.zo(), new com.vengeance.vengeanceclient.r.q.q.zn(), new com.vengeance.vengeanceclient.r.q.q.zp(), new com.vengeance.vengeanceclient.r.q.q.zf(), new com.vengeance.vengeanceclient.r.q.q.zc(), new com.vengeance.vengeanceclient.r.q.q.zi(), new com.vengeance.vengeanceclient.r.q.q.zh(), new zad(), new com.vengeance.vengeanceclient.r.q.q.zm(), new com.vengeance.vengeanceclient.r.q.q.zk(), new zt(), new zu());
        this.a(new com.vengeance.vengeanceclient.r.q.s.ze(), new com.vengeance.vengeanceclient.r.q.s.za(), new com.vengeance.vengeanceclient.r.q.s.zb(), new com.vengeance.vengeanceclient.r.q.s.zc(), new com.vengeance.vengeanceclient.r.q.s.zd());
        this.a(new com.vengeance.vengeanceclient.r.q.t.zd(), new com.vengeance.vengeanceclient.r.q.t.zg(), new com.vengeance.vengeanceclient.r.q.t.zh(), new com.vengeance.vengeanceclient.r.q.t.zf(), new com.vengeance.vengeanceclient.r.q.t.zc(), new com.vengeance.vengeanceclient.r.q.t.za(), new com.vengeance.vengeanceclient.r.q.t.zl(), new com.vengeance.vengeanceclient.r.q.t.zj(), new com.vengeance.vengeanceclient.r.q.t.zo(), new com.vengeance.vengeanceclient.r.q.t.zm(), new com.vengeance.vengeanceclient.r.q.t.zb(), new com.vengeance.vengeanceclient.r.q.t.ze(), new com.vengeance.vengeanceclient.r.q.t.zk(), new com.vengeance.vengeanceclient.r.q.t.zn(), new com.vengeance.vengeanceclient.r.q.t.zi());
        this.a(new ze(), new zj(), new zp(), new zn(), new zl(), new com.vengeance.vengeanceclient.r.q.u.zb(), new zm(), new zf(), new zh(), new zi(), new zo(), new com.vengeance.vengeanceclient.r.q.u.za(), new zq(), new zd(), new com.vengeance.vengeanceclient.r.q.u.zc(), new zk());
        this.a(new com.vengeance.vengeanceclient.r.q.r.za(), new com.vengeance.vengeanceclient.r.q.r.zd(), new com.vengeance.vengeanceclient.r.q.r.ze(), new com.vengeance.vengeanceclient.r.q.r.zg(), new com.vengeance.vengeanceclient.r.q.r.zf(), new com.vengeance.vengeanceclient.r.q.r.zi(), new com.vengeance.vengeanceclient.r.q.r.zh(), new com.vengeance.vengeanceclient.r.q.r.zb(), new com.vengeance.vengeanceclient.r.q.r.zc());
        this.a(new com.vengeance.vengeanceclient.r.q.p.zd(), new com.vengeance.vengeanceclient.r.q.p.zb(), new com.vengeance.vengeanceclient.r.q.p.za(), new com.vengeance.vengeanceclient.r.q.p.zc(), new com.vengeance.vengeanceclient.r.q.p.ze());
    }

    private void a(com.vengeance.vengeanceclient.r.zb ... zbArray) {
        this.a.addAll(Arrays.asList(zbArray));
    }

    public List<com.vengeance.vengeanceclient.r.zb> b() {
        return this.a;
    }
}

