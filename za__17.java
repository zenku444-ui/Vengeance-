/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonSyntaxException
 */
package com.vengeance.vengeanceclient.s;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.vengeance.vengeanceclient.VengeanceClient;
import com.vengeance.vengeanceclient.r.r.zd;
import com.vengeance.vengeanceclient.r.r.ze;
import com.vengeance.vengeanceclient.r.r.zf;
import com.vengeance.vengeanceclient.r.r.zg;
import com.vengeance.vengeanceclient.r.r.zh;
import com.vengeance.vengeanceclient.r.zb;
import com.vengeance.vengeanceclient.r.zc;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.runtime.SwitchBootstraps;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Objects;

public final class za {
    private final zc a = VengeanceClient.INSTANCE != null ? VengeanceClient.INSTANCE.getModuleManager() : null;
    private final Gson b = new GsonBuilder().setPrettyPrinting().create();
    private final File c;

    public za() {
        this.c = VengeanceClient.mc != null && VengeanceClient.mc.runDirectory != null ? new File(VengeanceClient.mc.runDirectory, "raven-z-" + File.separator + "profiles") : new File("profiles");
        this.c();
    }

    private void c() {
        if (this.c != null && !this.c.exists() && !this.c.mkdirs()) {
            com.vengeance.vengeanceclient.utils.t.za.e("\u00a7cFailed to create profile directory: " + this.c.getAbsolutePath());
        }
    }

    public void a(String string) {
        if (string == null || this.a == null) {
            return;
        }
        File file = new File(this.c, string + ".json");
        if (!file.exists()) {
            com.vengeance.vengeanceclient.utils.t.za.e("Profile not found: " + string);
            return;
        }
        this.a();
        this.a(file);
    }

    private void a(File file) {
        if (file == null || !file.exists() || this.a == null) {
            return;
        }
        try (FileReader fileReader = new FileReader(file, StandardCharsets.UTF_8);){
            JsonObject jsonObject = (JsonObject)this.b.fromJson((Reader)fileReader, JsonObject.class);
            if (jsonObject != null) {
                for (Object t : this.a.b() != null ? this.a.b() : Collections.emptyList()) {
                    JsonObject jsonObject2;
                    zb zb2 = (zb)t;
                    if (zb2 == null || !jsonObject.has(zb2.i()) || (jsonObject2 = jsonObject.getAsJsonObject(zb2.i())) == null) continue;
                    this.a(zb2, jsonObject2);
                }
            }
            com.vengeance.vengeanceclient.utils.t.za.e("Profile loaded successfully.");
        }
        catch (JsonSyntaxException jsonSyntaxException) {
            com.vengeance.vengeanceclient.utils.t.za.e("\u00a7cFailed to parse profile (invalid JSON): " + file.getName());
            jsonSyntaxException.printStackTrace();
        }
        catch (IOException iOException) {
            com.vengeance.vengeanceclient.utils.t.za.e("\u00a7cFailed to load profile: " + iOException.getMessage());
        }
    }

    private void a(zb zb2, JsonObject jsonObject) {
        if (zb2 == null || jsonObject == null) {
            return;
        }
        zb2.a(jsonObject.has("enabled") && jsonObject.get("enabled").getAsBoolean());
        zb2.a(jsonObject.has("bind") ? jsonObject.get("bind").getAsInt() : 0);
        if (zb2.f() != null) {
            for (zg zg2 : zb2.f()) {
                if (zg2 == null) continue;
                this.a(zg2, jsonObject);
            }
        }
    }

    private void a(zg zg2, JsonObject jsonObject) {
        if (zg2 == null || jsonObject == null) {
            return;
        }
        String string = zg2.i();
        if (string == null || !jsonObject.has(string)) {
            return;
        }
        JsonElement jsonElement = jsonObject.get(string);
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return;
        }
        try {
            zg zg3 = zg2;
            Objects.requireNonNull(zg3);
            zg zg4 = zg3;
            int n = 0;
            switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{com.vengeance.vengeanceclient.r.r.za.class, ze.class, zf.class, zd.class, com.vengeance.vengeanceclient.r.r.zc.class, zh.class, com.vengeance.vengeanceclient.r.r.zb.class}, (Object)zg4, n)) {
                case 0: {
                    com.vengeance.vengeanceclient.r.r.za za2 = (com.vengeance.vengeanceclient.r.r.za)zg4;
                    za2.a(jsonElement.getAsBoolean());
                    break;
                }
                case 1: {
                    ze ze2 = (ze)zg4;
                    ze2.a(jsonElement.getAsDouble());
                    break;
                }
                case 2: {
                    zf zf2 = (zf)zg4;
                    if (jsonElement.isJsonObject()) {
                        JsonObject jsonObject2 = jsonElement.getAsJsonObject();
                        double d = jsonObject2.has("min") ? jsonObject2.get("min").getAsDouble() : zf2.c();
                        double d2 = jsonObject2.has("max") ? jsonObject2.get("max").getAsDouble() : zf2.d();
                        zf2.a(d, d2);
                    }
                    break;
                }
                case 3: {
                    zd zd2 = (zd)zg4;
                    String string2 = jsonElement.getAsString();
                    if (string2 != null) {
                        zd2.a(string2);
                    }
                    break;
                }
                case 4: {
                    com.vengeance.vengeanceclient.r.r.zc zc2 = (com.vengeance.vengeanceclient.r.r.zc)zg4;
                    zc2.a(jsonElement.getAsInt());
                    break;
                }
                case 5: {
                    zh zh2 = (zh)zg4;
                    zh2.a(jsonElement.getAsString());
                    break;
                }
                case 6: {
                    com.vengeance.vengeanceclient.r.r.zb zb2 = (com.vengeance.vengeanceclient.r.r.zb)zg4;
                    if (jsonElement.isJsonPrimitive()) {
                        if (jsonElement.getAsJsonPrimitive().isString()) {
                            String string3 = jsonElement.getAsString();
                            if (string3 != null) {
                                if ((string3 = string3.trim()).startsWith("#")) {
                                    string3 = string3.substring(1);
                                }
                                if (string3.length() >= 6) {
                                    int n2 = Integer.parseInt(string3.substring(0, 2), 16);
                                    int n3 = Integer.parseInt(string3.substring(2, 4), 16);
                                    int n4 = Integer.parseInt(string3.substring(4, 6), 16);
                                    if (zb2.g() && string3.length() >= 8) {
                                        int n5 = Integer.parseInt(string3.substring(6, 8), 16);
                                        zb2.a(n2, n3, n4, n5);
                                        break;
                                    }
                                    zb2.a(n2, n3, n4);
                                }
                            }
                        } else if (jsonElement.getAsJsonPrimitive().isNumber()) {
                            int n6 = jsonElement.getAsInt();
                            int n7 = n6 >> 24 & 0xFF;
                            int n8 = n6 >> 16 & 0xFF;
                            int n9 = n6 >> 8 & 0xFF;
                            int n10 = n6 & 0xFF;
                            if (zb2.g()) {
                                zb2.a(n8, n9, n10, n7);
                                break;
                            }
                            zb2.a(n8, n9, n10);
                        }
                    }
                    break;
                }
                default: {
                    com.vengeance.vengeanceclient.utils.t.za.e("\u00a7cUnknown setting type: " + zg2.getClass().getSimpleName());
                }
            }
        }
        catch (Exception exception) {
            com.vengeance.vengeanceclient.utils.t.za.e("\u00a7cFailed to load setting: " + string);
        }
    }

    public void b(String string) {
        this.a(string, false);
    }

    public void a(String string, boolean bl) {
        if (string == null) {
            return;
        }
        File file = new File(this.c, string + ".json");
        if (file.exists() && !bl) {
            com.vengeance.vengeanceclient.utils.t.za.e("\u00a7eProfile '" + string + "' already exists. Use .save <name> -override to overwrite it.");
            return;
        }
        try {
            if (!file.exists() && !file.createNewFile()) {
                com.vengeance.vengeanceclient.utils.t.za.e("\u00a7cFailed to create profile file: " + file.getAbsolutePath());
                return;
            }
            com.vengeance.vengeanceclient.utils.t.za.e(bl ? "\u00a7aProfile '" + string + "' overridden successfully." : "\u00a7aProfile '" + string + "' saved successfully.");
        }
        catch (IOException iOException) {
            com.vengeance.vengeanceclient.utils.t.za.e("\u00a7cFailed to save profile: " + iOException.getMessage());
            return;
        }
        this.b(file);
    }

    private void b(File file) {
        if (file == null || this.a == null) {
            return;
        }
        JsonObject jsonObject = new JsonObject();
        if (this.a.b() != null) {
            for (zb zb2 : this.a.b()) {
                if (zb2 == null) continue;
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("enabled", Boolean.valueOf(zb2.l()));
                jsonObject2.addProperty("bind", (Number)zb2.e());
                if (zb2.f() != null) {
                    for (zg zg2 : zb2.f()) {
                        if (zg2 == null) continue;
                        this.b(zg2, jsonObject2);
                    }
                }
                if (zb2.i() == null) continue;
                jsonObject.add(zb2.i(), (JsonElement)jsonObject2);
            }
        }
        try (FileWriter fileWriter = new FileWriter(file, StandardCharsets.UTF_8);){
            this.b.toJson((JsonElement)jsonObject, (Appendable)fileWriter);
        }
        catch (IOException iOException) {
            com.vengeance.vengeanceclient.utils.t.za.e("\u00a7cFailed to write profile: " + iOException.getMessage());
        }
    }

    private void b(zg zg2, JsonObject jsonObject) {
        if (zg2 == null || jsonObject == null) {
            return;
        }
        String string = zg2.i();
        if (string == null) {
            return;
        }
        try {
            zg zg3 = zg2;
            Objects.requireNonNull(zg3);
            zg zg4 = zg3;
            int n = 0;
            switch (SwitchBootstraps.typeSwitch("typeSwitch", new Object[]{com.vengeance.vengeanceclient.r.r.za.class, ze.class, zf.class, zd.class, com.vengeance.vengeanceclient.r.r.zc.class, zh.class, com.vengeance.vengeanceclient.r.r.zb.class}, (Object)zg4, n)) {
                case 0: {
                    com.vengeance.vengeanceclient.r.r.za za2 = (com.vengeance.vengeanceclient.r.r.za)zg4;
                    jsonObject.addProperty(string, Boolean.valueOf(za2.b()));
                    break;
                }
                case 1: {
                    ze ze2 = (ze)zg4;
                    jsonObject.addProperty(string, (Number)ze2.f());
                    break;
                }
                case 2: {
                    zf zf2 = (zf)zg4;
                    JsonObject jsonObject2 = new JsonObject();
                    jsonObject2.addProperty("min", (Number)zf2.c());
                    jsonObject2.addProperty("max", (Number)zf2.d());
                    jsonObject.add(string, (JsonElement)jsonObject2);
                    break;
                }
                case 3: {
                    zd zd2 = (zd)zg4;
                    String string2 = zd2.a();
                    if (string2 != null) {
                        jsonObject.addProperty(string, string2);
                    }
                    break;
                }
                case 4: {
                    com.vengeance.vengeanceclient.r.r.zc zc2 = (com.vengeance.vengeanceclient.r.r.zc)zg4;
                    jsonObject.addProperty(string, (Number)zc2.e());
                    break;
                }
                case 5: {
                    zh zh2 = (zh)zg4;
                    jsonObject.addProperty(string, zh2.a());
                    break;
                }
                case 6: {
                    com.vengeance.vengeanceclient.r.r.zb zb2 = (com.vengeance.vengeanceclient.r.r.zb)zg4;
                    Object object = String.format("#%02X%02X%02X", zb2.b(), zb2.c(), zb2.d());
                    if (zb2.g()) {
                        object = (String)object + String.format("%02X", zb2.e());
                    }
                    jsonObject.addProperty(string, (String)object);
                    break;
                }
                default: {
                    com.vengeance.vengeanceclient.utils.t.za.e("\u00a7cUnknown setting type: " + zg2.getClass().getSimpleName());
                }
            }
        }
        catch (Exception exception) {
            com.vengeance.vengeanceclient.utils.t.za.e("\u00a7cFailed to save setting: " + string);
        }
    }

    public void a() {
        if (this.a == null || this.a.b() == null) {
            return;
        }
        for (zb zb2 : this.a.b()) {
            if (zb2 == null) continue;
            zb2.a(false);
            zb2.a(0);
            if (zb2.f() == null) continue;
            for (zg zg2 : zb2.f()) {
                if (zg2 == null) continue;
                this.a(zg2);
            }
        }
    }

    private void a(zg zg2) {
        if (zg2 == null) {
            return;
        }
        try {
            zd zd2;
            if (zg2 instanceof com.vengeance.vengeanceclient.r.r.za) {
                com.vengeance.vengeanceclient.r.r.za za2 = (com.vengeance.vengeanceclient.r.r.za)zg2;
                za2.a(false);
            } else if (zg2 instanceof ze) {
                ze ze2 = (ze)zg2;
                ze2.a(ze2.c());
            } else if (zg2 instanceof zf) {
                zf zf2 = (zf)zg2;
                zf2.a(zf2.a(), zf2.b());
            } else if (zg2 instanceof zd && (zd2 = (zd)zg2).c() != null && !zd2.c().isEmpty()) {
                zd2.a((String)zd2.c().getFirst());
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public File b() {
        return this.c;
    }
}

