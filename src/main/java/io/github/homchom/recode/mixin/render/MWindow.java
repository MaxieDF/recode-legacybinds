package io.github.homchom.recode.mixin.render;

import com.mojang.blaze3d.platform.Window;
import io.github.homchom.recode.feature.social.MCGuiWithSideChat;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Window.class)
public class MWindow {
    @Inject(method = "setGuiScale", at = @At("TAIL"))
    private void rescaleSideChat(CallbackInfo ci) {
        var gui = (MCGuiWithSideChat) Minecraft.getInstance().gui;
        gui.recode$getSideChat().rescaleChat();
    }
}