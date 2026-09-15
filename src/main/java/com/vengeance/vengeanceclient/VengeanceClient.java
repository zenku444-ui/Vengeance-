/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ClientModInitializer
 *  net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.screen.Screen
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package com.vengeance.vengeanceclient;

import com.vengeance.vengeanceclient.q.za;
import com.vengeance.vengeanceclient.r.zc;
import com.vengeance.vengeanceclient.utils.u.zb;
import io.github.racoondog.norbit.EventBus;
import java.io.File;
import java.lang.invoke.MethodHandles;
import meteordevelopment.orbit.IEventBus;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class VengeanceClient
implements ClientModInitializer {
    public static final String CLIENT_VERSION = "v1.0";
    public static final boolean shouldUseMouseEvent = System.getProperty("os.name").toLowerCase().contains("windows");
    public static VengeanceClient INSTANCE;
    public static MinecraftClient mc;
    public final IEventBus eventBus;
    public final zc moduleManager;
    public final com.vengeance.vengeanceclient.utils.w.q.za fontManager;
    public final com.vengeance.vengeanceclient.s.za profileManager;
    public final com.vengeance.vengeanceclient.r.p.za mouseModuleHandler;
    public final zb notificationManager;
    private boolean authScreenShown = false;
    private boolean defaultProfileLoaded = false;
    private final Logger logger = LoggerFactory.getLogger((String)"Vengeance Client");

    public VengeanceClient() {
        INSTANCE = this;
        mc = MinecraftClient.getInstance();
        this.eventBus = EventBus.threadSafe();
        this.eventBus.registerLambdaFactory("com.vengeance.vengeanceclient", (method, clazz) -> (MethodHandles.Lookup)method.invoke(null, clazz, MethodHandles.lookup()));
        com.vengeance.vengeanceclient.utils.p.za.a();
        this.moduleManager = new zc();
        this.fontManager = new com.vengeance.vengeanceclient.utils.w.q.za();
        this.profileManager = new com.vengeance.vengeanceclient.s.za();
        this.mouseModuleHandler = new com.vengeance.vengeanceclient.r.p.za();
        this.notificationManager = zb.a();
        ClientTickEvents.END_CLIENT_TICK.register(class_3102 -> {
            if (class_3102 == null) {
                return;
            }
            if (!com.vengeance.vengeanceclient.utils.p.za.b().c()) {
                boolean bl;
                boolean bl2 = bl = class_3102.player != null;
                if (com.vengeance.vengeanceclient.utils.p.za.b().f()) {
                    return;
                }
                if (bl && !(class_3102.currentScreen instanceof za)) {
                    class_3102.setScreen((Screen)new za());
                    this.authScreenShown = true;
                }
                return;
            }
            if (this.authScreenShown && class_3102.currentScreen instanceof za) {
                class_3102.setScreen(null);
                this.authScreenShown = false;
            }
            if (!this.defaultProfileLoaded && class_3102.world != null) {
                File file = new File(class_3102.runDirectory, "raven-z-/profiles/default.json");
                if (file.exists()) {
                    this.profileManager.a("default");
                }
                this.defaultProfileLoaded = true;
            }
        });
        this.eventBus.subscribe(this.mouseModuleHandler);
        this.eventBus.subscribe(this.notificationManager);
        new Thread(com.vengeance.vengeanceclient.utils.jvm.zb::a).start();
    }

    public static void requireAuthentication() {
        if (INSTANCE != null) {
            if (mc != null) {
                mc.execute(() -> {
                    if (VengeanceClient.mc.currentScreen == null) {
                        mc.setScreen((Screen)new za());
                    }
                });
            }
        }
    }

    public void onInitializeClient() {
    }

    public IEventBus getEventBus() {
        return this.eventBus;
    }

    public zc getModuleManager() {
        return this.moduleManager;
    }

    public com.vengeance.vengeanceclient.utils.w.q.za getFontManager() {
        return this.fontManager;
    }

    public com.vengeance.vengeanceclient.s.za getProfileManager() {
        return this.profileManager;
    }

    public com.vengeance.vengeanceclient.r.p.za getMouseModuleHandler() {
        return this.mouseModuleHandler;
    }

    public zb getNotificationManager() {
        return this.notificationManager;
    }

    public boolean isAuthScreenShown() {
        return this.authScreenShown;
    }

    public boolean isDefaultProfileLoaded() {
        return this.defaultProfileLoaded;
    }

    public Logger getLogger() {
        return this.logger;
    }
}

