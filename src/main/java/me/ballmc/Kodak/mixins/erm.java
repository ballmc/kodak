package me.ballmc.Kodak.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.Debug;


import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ChatComponentText;

import me.ballmc.Kodak.Kodak;
import me.ballmc.Kodak.Config;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
@Mixin(EntityRenderer.class)
public abstract class erm {
    Kodak kodak = Kodak.getInstance();
    Config config = kodak.getConfig();

    // @Redirect(method = "orientCamera", at = @At(value = "FIELD", target = "Lnet/minecraft/client/settings/GameSettings;thirdPersonView:I", ordinal = 0))
    // private int bypassCheck(GameSettings instance) {
    //     return config.KodakEnabled ? 1 : instance.thirdPersonView;
    // }

    @ModifyArg(method = "orientCamera", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;translate(FFF)V", ordinal = 2), index = 2)
    private float modifyThirdArgInGLStateManagerTranslate(float x){
        // if (config.KodakEnabled) {
        //     Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("kodak on!"));
        //     return (float)(config.KodakDistance * -1);
        // } else {
        //     Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("kodak off!"));
        //     return -x;
        // }
        return (float)(config.KodakDistance * -1);
    }


    // @SuppressWarnings("ConstantConditions")
    // @Redirect(
    //     method = "orientCamera",
    //     at = @At(
    //         value = "INVOKE",
    //         target = "Lnet/minecraft/client/renderer/GlStateManager;translate(FFF)V",
    //         ordinal = 2
    //     )
    // )

    // @ModifyArg(method = "orientCamera", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;translate(FFF)V", ordinal = 2, shift = At.Shift.BEFORE, by = -2), index = 2)
    // private float modifyThirdArgInGLStateManagerTranslate(float x){
    //     if (config.KodakEnabled) {
    //         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("kodak on!"));
    //         return (float)(config.KodakDistance * -1);
    //     } else {
    //         Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("kodak off!"));
    //         return (float)(-x);
    //     }
    // }

    // public void redirectTranslate(float x, float y, float z) {
    //   Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Redirected!"));
    //   if (config.KodakEnabled) {
    //     GlStateManager.translate(0.0F, 0.0F, (float)(config.KodakDistance * -1));
    //   } else {
    //     GlStateManager.translate(0.0F, 0.0F, (float)(-4.0D));
    //   }
    // }
}