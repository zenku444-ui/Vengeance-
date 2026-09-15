/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.p.p.q;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;

public record zb(int a, int b, int c) implements com.vengeance.vengeanceclient.p.q.zb
{
    @Override
    public final String toString() {
        return ObjectMethods.bootstrap("toString", new MethodHandle[]{zb.class, "button;action;mods", "a", "b", "c"}, this);
    }

    @Override
    public final int hashCode() {
        return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{zb.class, "button;action;mods", "a", "b", "c"}, this);
    }

    @Override
    public final boolean equals(Object object) {
        return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{zb.class, "button;action;mods", "a", "b", "c"}, this, object);
    }
}

