/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.p;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class zb {
    private static final String a = "AES/GCM/NoPadding";
    private static final int b = 12;
    private static final int c = 128;
    private static final byte[] d = zb.c("VengeanceClient_SecureKey_2024");

    public static String a(String string) {
        try {
            byte[] byArray = new byte[12];
            new SecureRandom().nextBytes(byArray);
            Cipher cipher = Cipher.getInstance(a);
            SecretKeySpec secretKeySpec = new SecretKeySpec(d, "AES");
            GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, byArray);
            cipher.init(1, (Key)secretKeySpec, gCMParameterSpec);
            byte[] byArray2 = cipher.doFinal(string.getBytes(StandardCharsets.UTF_8));
            byte[] byArray3 = new byte[byArray.length + byArray2.length];
            System.arraycopy(byArray, 0, byArray3, 0, byArray.length);
            System.arraycopy(byArray2, 0, byArray3, byArray.length, byArray2.length);
            return Base64.getEncoder().encodeToString(byArray3);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static String b(String string) {
        try {
            byte[] byArray = Base64.getDecoder().decode(string);
            byte[] byArray2 = new byte[12];
            byte[] byArray3 = new byte[byArray.length - 12];
            System.arraycopy(byArray, 0, byArray2, 0, byArray2.length);
            System.arraycopy(byArray, byArray2.length, byArray3, 0, byArray3.length);
            Cipher cipher = Cipher.getInstance(a);
            SecretKeySpec secretKeySpec = new SecretKeySpec(d, "AES");
            GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, byArray2);
            cipher.init(2, (Key)secretKeySpec, gCMParameterSpec);
            byte[] byArray4 = cipher.doFinal(byArray3);
            return new String(byArray4, StandardCharsets.UTF_8);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static String a(String string, String string2) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(string2.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            mac.init(secretKeySpec);
            byte[] byArray = mac.doFinal(string.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(byArray);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static boolean a(String string, String string2, String string3) {
        String string4 = zb.a(string, string2);
        if (string4 == null || string3 == null) {
            return false;
        }
        return string4.equals(string3);
    }

    private static byte[] c(String string) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] byArray = messageDigest.digest(string.getBytes(StandardCharsets.UTF_8));
            byte[] byArray2 = new byte[32];
            System.arraycopy(byArray, 0, byArray2, 0, 32);
            return byArray2;
        }
        catch (Exception exception) {
            byte[] byArray = new byte[32];
            new SecureRandom().nextBytes(byArray);
            return byArray;
        }
    }

    public static String b(String string, String string2) {
        try {
            String string3 = string + string2;
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] byArray = messageDigest.digest(string3.getBytes(StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder();
            for (byte by : byArray) {
                String string4 = Integer.toHexString(0xFF & by);
                if (string4.length() == 1) {
                    stringBuilder.append('0');
                }
                stringBuilder.append(string4);
            }
            return stringBuilder.toString();
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static String a() {
        byte[] byArray = new byte[32];
        new SecureRandom().nextBytes(byArray);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(byArray);
    }
}

