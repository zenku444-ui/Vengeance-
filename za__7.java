/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.text.Text
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.widget.TextFieldWidget
 *  net.minecraft.client.gui.Element
 *  net.minecraft.client.gui.widget.ButtonWidget
 *  net.minecraft.client.gui.screen.Screen
 */
package com.vengeance.vengeanceclient.q;

import com.vengeance.vengeanceclient.utils.p.za;
import net.minecraft.text.Text;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.screen.Screen;

public class za
extends Screen {
    private TextFieldWidget a;
    private String b = "";
    private boolean c = false;
    private ButtonWidget d;

    public za() {
        super((Text)Text.literal((String)"Vengeance Client - Authentication"));
    }

    protected void init() {
        super.init();
        int n = this.width / 2;
        int n2 = this.height / 2;
        this.a = new TextFieldWidget(this.textRenderer, n - 150, n2 - 30, 300, 40, (Text)Text.literal((String)"Enter License Key"));
        this.a.setMaxLength(50);
        String string = com.vengeance.vengeanceclient.utils.p.za.b().g();
        if (string != null) {
            this.a.setText(string);
        }
        this.addDrawableChild((Element)this.a);
        this.d = ButtonWidget.builder((Text)Text.literal((String)"LOGIN"), class_41852 -> this.a()).dimensions(n - 150, n2 + 30, 300, 40).build();
        this.addDrawableChild((Element)this.d);
    }

    public void render(DrawContext class_3322, int n, int n2, float f) {
        class_3322.fill(0, 0, this.width, this.height, -871691502);
        int n3 = this.width / 2;
        int n4 = this.height / 2;
        class_3322.fill(n3 - 200, n4 - 100, n3 + 200, n4 + 150, -15066578);
        class_3322.fill(n3 - 200, n4 - 100, n3 + 200, n4 - 90, -9753253);
        class_3322.fill(n3 - 200, n4 + 140, n3 + 200, n4 + 150, -9753253);
        class_3322.drawCenteredTextWithShadow(this.textRenderer, "Vengeance Client", n3, n4 - 80, -9753253);
        class_3322.drawCenteredTextWithShadow(this.textRenderer, "Authentication Required", n3, n4 - 60, -5592406);
        class_3322.drawCenteredTextWithShadow(this.textRenderer, "Enter your license key to continue", n3, n4 - 45, -7829368);
        if (!this.b.isEmpty()) {
            int n5 = -43691;
            if (this.b.toLowerCase().contains("welcome") || this.b.toLowerCase().contains("success")) {
                n5 = -11141291;
            }
            class_3322.drawCenteredTextWithShadow(this.textRenderer, this.b, n3, n4 - 10, n5);
        }
        if (this.c) {
            class_3322.drawCenteredTextWithShadow(this.textRenderer, "Authenticating...", n3, n4 + 75, -171);
        }
        super.render(class_3322, n, n2, f);
    }

    private void a() {
        if (this.c) {
            return;
        }
        String string = this.a.getText().trim();
        if (string.isEmpty()) {
            this.b = "Please enter a license key";
            return;
        }
        if (!string.startsWith("VNG-")) {
            this.b = "Invalid key format";
            return;
        }
        this.c = true;
        this.b = "";
        this.d.setMessage((Text)Text.literal((String)"AUTHENTICATING..."));
        com.vengeance.vengeanceclient.utils.p.za.b().a(string, new za.za(){

            @Override
            public void a(String string, String string2) {
                za.this.c = false;
                za.this.b = "Welcome! Tier: " + string2;
                if (MinecraftClient.getInstance() != null && MinecraftClient.getInstance().player != null) {
                    MinecraftClient.getInstance().execute(() -> {
                        try {
                            Thread.sleep(1500L);
                        }
                        catch (InterruptedException interruptedException) {
                            // empty catch block
                        }
                        if (MinecraftClient.getInstance().currentScreen instanceof za) {
                            MinecraftClient.getInstance().setScreen(null);
                        }
                    });
                }
            }

            @Override
            public void a(String string) {
                za.this.c = false;
                za.this.b = "Error: " + string;
                za.this.d.setMessage((Text)Text.literal((String)"LOGIN"));
            }
        });
    }

    public boolean shouldCloseOnEsc() {
        return false;
    }

    public void close() {
    }
}

