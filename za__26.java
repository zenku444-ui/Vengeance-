/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.v;

public class za {
    public static String a(String string) {
        if (string.length() < 2) {
            return string;
        }
        string = string.replace("_", " ");
        string = string.replace("$", "");
        return string.charAt(0) + string.substring(1).toLowerCase();
    }
}

