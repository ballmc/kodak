package me.ballmc.Kodak.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ChatComponentText;

@Mixin(EntityRenderer.class)
public abstract class erm {
    @Redirect(
        method = "orientCamera",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/renderer/GlStateManager;translate(FFF)V",
            ordinal = 2
        )
    )
    public void redirectTranslate(float x, float y, float z) {
      Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Redirected!"));
      GlStateManager.translate(0.0F, 0.0F, (float)(-4.0D));
    }
}