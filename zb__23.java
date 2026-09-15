/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Preconditions
 *  org.jetbrains.annotations.Range
 */
package com.vengeance.vengeanceclient.utils.w.q.q;

import com.google.common.base.Preconditions;
import org.jetbrains.annotations.Range;

public class zb {
    public static int a(@Range(from=0L, to=255L) int n, @Range(from=0L, to=255L) int n2, @Range(from=0L, to=255L) int n3, @Range(from=0L, to=255L) int n4) {
        Preconditions.checkArgument((boolean)zb.d(n), (Object)("Expected r to be 0-255, received " + n));
        Preconditions.checkArgument((boolean)zb.d(n2), (Object)("Expected g to be 0-255, received " + n2));
        Preconditions.checkArgument((boolean)zb.d(n3), (Object)("Expected b to be 0-255, received " + n3));
        Preconditions.checkArgument((boolean)zb.d(n4), (Object)("Expected a to be 0-255, received " + n4));
        return n4 << 24 | n << 16 | n2 << 8 | n3;
    }

    public static int b(@Range(from=0L, to=255L) int n, @Range(from=0L, to=255L) int n2, @Range(from=0L, to=255L) int n3, @Range(from=0L, to=255L) int n4) {
        Preconditions.checkArgument((boolean)zb.d(n), (Object)("Expected r to be 0-255, received " + n));
        Preconditions.checkArgument((boolean)zb.d(n2), (Object)("Expected g to be 0-255, received " + n2));
        Preconditions.checkArgument((boolean)zb.d(n3), (Object)("Expected b to be 0-255, received " + n3));
        Preconditions.checkArgument((boolean)zb.d(n4), (Object)("Expected a to be 0-255, received " + n4));
        return n << 24 | n2 << 16 | n3 << 8 | n4;
    }

    public static int[] a(int n) {
        int n2 = n >> 24 & 0xFF;
        int n3 = n >> 16 & 0xFF;
        int n4 = n >> 8 & 0xFF;
        int n5 = n & 0xFF;
        return new int[]{n2, n3, n4, n5};
    }

    public static int[] b(int n) {
        int n2 = n >> 24 & 0xFF;
        int n3 = n >> 16 & 0xFF;
        int n4 = n >> 8 & 0xFF;
        int n5 = n & 0xFF;
        return new int[]{n3, n4, n5, n2};
    }

    public static int[] c(int n) {
        int n2 = n >> 16 & 0xFF;
        int n3 = n >> 8 & 0xFF;
        int n4 = n & 0xFF;
        return new int[]{n2, n3, n4};
    }

    public static float[] a(int[] nArray) {
        Preconditions.checkArgument((nArray.length == 4 ? 1 : 0) != 0, (Object)("Expected int[] of size 4, got " + nArray.length));
        for (int i = 0; i < nArray.length; ++i) {
            Preconditions.checkArgument((boolean)zb.d(nArray[i]), (Object)("Expected in[" + i + "] to be 0-255, got " + nArray[i]));
        }
        return new float[]{(float)nArray[0] / 255.0f, (float)nArray[1] / 255.0f, (float)nArray[2] / 255.0f, (float)nArray[3] / 255.0f};
    }

    private static boolean d(int n) {
        return n >= 0 && n <= 255;
    }
}

