/*
 * Decompiled with CFR 0.152.
 */
package com.vengeance.vengeanceclient.utils.p;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class zc {
    private static String a = null;

    public static String a() {
        if (a != null) {
            return a;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            zc.a(stringBuilder, zc.b());
            zc.a(stringBuilder, zc.c());
            zc.a(stringBuilder, zc.d());
            zc.a(stringBuilder, zc.e());
            zc.a(stringBuilder, zc.f());
            zc.a(stringBuilder, zc.g());
            a = zc.a(stringBuilder.toString());
            return a;
        }
        catch (Exception exception) {
            return zc.h();
        }
    }

    private static void a(StringBuilder stringBuilder, String string) {
        if (string != null && !string.isEmpty()) {
            stringBuilder.append(string).append(":");
        }
    }

    private static String b() {
        try {
            String[] stringArray;
            String string;
            String string2;
            String string3 = System.getProperty("os.name").toLowerCase();
            String string4 = string3.contains("windows") ? "wmic cpu get ProcessorId" : (string3.contains("mac") ? "sysctl -n machdep.cpu.brand_string" : "cat /proc/cpuinfo");
            Process process = Runtime.getRuntime().exec(string4);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder();
            while ((string2 = bufferedReader.readLine()) != null) {
                string = string2.trim();
                if (string3.contains("windows")) {
                    stringBuilder.append(string);
                    continue;
                }
                if (string3.contains("mac")) {
                    if (string.isEmpty()) continue;
                    return string;
                }
                if (!string.toLowerCase().contains("model name") && !string.toLowerCase().contains("hardware")) continue;
                stringBuilder.append(string);
                break;
            }
            if ((string = stringBuilder.toString()).contains("ProcessorId") && (stringArray = string.split("ProcessorId")).length > 1) {
                return stringArray[1].trim();
            }
            return "" + string.hashCode();
        }
        catch (Exception exception) {
            return "" + Runtime.getRuntime().availableProcessors();
        }
    }

    private static String c() {
        Object object;
        try {
            String string;
            object = System.getProperty("os.name").toLowerCase();
            String string2 = ((String)object).contains("windows") ? "wmic baseboard get SerialNumber" : (((String)object).contains("mac") ? "system_profiler SPHardwareDataType" : "cat /sys/class/dmi/id/board_serial");
            Process process = Runtime.getRuntime().exec(string2);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8));
            while ((string = bufferedReader.readLine()) != null) {
                String[] stringArray;
                String string3 = string.trim();
                if (((String)object).contains("mac") && string3.toLowerCase().startsWith("serial number") && (stringArray = string3.split(":", 2)).length == 2 && !stringArray[1].trim().isEmpty()) {
                    return stringArray[1].trim();
                }
                if (string3.isEmpty() || string3.equals("SerialNumber")) continue;
                return string3;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        object = System.getProperty("os.name", "unknown") + ":" + System.getProperty("os.arch", "unknown") + ":" + System.getProperty("user.name", "unknown") + ":" + System.getProperty("user.home", "unknown");
        return zc.a((String)object);
    }

    private static String d() {
        try {
            String string;
            String string2 = System.getProperty("os.name").toLowerCase();
            String string3 = string2.contains("windows") ? "wmic path win32_VideoController get PNPDeviceID" : (string2.contains("mac") ? "system_profiler SPDisplaysDataType" : "lspci");
            Process process = Runtime.getRuntime().exec(string3);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder();
            while ((string = bufferedReader.readLine()) != null) {
                String string4 = string.trim();
                if (string2.contains("mac")) {
                    if (!string4.toLowerCase().contains("chipset model")) continue;
                    stringBuilder.append(string4);
                    continue;
                }
                if (string2.contains("windows")) {
                    stringBuilder.append(string4);
                    continue;
                }
                if (!string4.toLowerCase().contains("vga") && !string4.toLowerCase().contains("display")) continue;
                stringBuilder.append(string4);
            }
            return stringBuilder.toString().isEmpty() ? "default" : stringBuilder.toString();
        }
        catch (Exception exception) {
            return "default";
        }
    }

    private static String e() {
        try {
            File[] fileArray = File.listRoots();
            if (fileArray.length > 0) {
                return "" + fileArray[0].getAbsolutePath().hashCode();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return "diskdefault";
    }

    private static String f() {
        try {
            ArrayList<String> arrayList = new ArrayList<String>();
            Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
            while (enumeration.hasMoreElements()) {
                NetworkInterface networkInterface = enumeration.nextElement();
                if (networkInterface == null || networkInterface.isLoopback() || networkInterface.getHardwareAddress() == null) continue;
                byte[] byArray = networkInterface.getHardwareAddress();
                StringBuilder stringBuilder = new StringBuilder();
                for (byte by : byArray) {
                    stringBuilder.append(String.format("%02X", by));
                }
                arrayList.add(stringBuilder.toString());
            }
            if (!arrayList.isEmpty()) {
                Collections.sort(arrayList);
                return String.join((CharSequence)"-", arrayList);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return "nomac";
    }

    private static String g() {
        try {
            String string = System.getProperty("os.name").toLowerCase();
            if (string.contains("windows")) {
                String string2;
                Process process = Runtime.getRuntime().exec("wmic csproduct get UUID");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8));
                while ((string2 = bufferedReader.readLine()) != null) {
                    if (!string2.trim().contains("-")) continue;
                    return string2.trim();
                }
            } else {
                String string3;
                BufferedReader bufferedReader;
                Object object;
                if (string.contains("mac")) {
                    object = Runtime.getRuntime().exec("ioreg -rd1 -c IOPlatformExpertDevice");
                    bufferedReader = new BufferedReader(new InputStreamReader(((Process)object).getInputStream(), StandardCharsets.UTF_8));
                    while ((string3 = bufferedReader.readLine()) != null) {
                        String[] stringArray;
                        String string4 = string3.trim();
                        if (!string4.contains("IOPlatformUUID") || (stringArray = string4.split("\"")).length < 4) continue;
                        return stringArray[3].trim();
                    }
                }
                if (((File)(object = new File("/etc/machine-id"))).exists()) {
                    bufferedReader = new BufferedReader(new FileReader((File)object));
                    string3 = bufferedReader.readLine();
                    bufferedReader.close();
                    if (string3 != null) {
                        return string3.trim();
                    }
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return "machine" + System.getProperty("user.name");
    }

    private static String h() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.getProperty("os.name")).append(":");
        stringBuilder.append(System.getProperty("os.arch")).append(":");
        stringBuilder.append(System.getProperty("os.version")).append(":");
        stringBuilder.append(System.getProperty("user.name")).append(":");
        stringBuilder.append(System.getProperty("user.home")).append(":");
        try {
            stringBuilder.append(Runtime.getRuntime().totalMemory());
            stringBuilder.append(Runtime.getRuntime().maxMemory());
        }
        catch (Exception exception) {
            // empty catch block
        }
        return zc.a(stringBuilder.toString());
    }

    private static String a(String string) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] byArray = messageDigest.digest(string.getBytes(StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder();
            for (byte by : byArray) {
                String string2 = Integer.toHexString(0xFF & by);
                if (string2.length() == 1) {
                    stringBuilder.append('0');
                }
                stringBuilder.append(string2);
            }
            return stringBuilder.toString();
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            return string.hashCode() + "fallback";
        }
    }
}

