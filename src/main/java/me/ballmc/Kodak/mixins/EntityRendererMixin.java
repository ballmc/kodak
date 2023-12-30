package me.ballmc.Kodak.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.util.Vec3;
import me.ballmc.Kodak.Kodak;
import me.ballmc.Kodak.Config;

@Mixin(EntityRenderer.class)
public abstract class EntityRendererMixin {
    @Shadow
    private float thirdPersonDistanceTemp;
    @Shadow
    private float thirdPersonDistance;
    Kodak kodak = Kodak.getInstance();
    Config config = kodak.getConfig();

    @Redirect(method = "orientCamera", at = @At(value = "FIELD", target = "Lnet/minecraft/client/renderer/EntityRenderer;thirdPersonDistanceTemp:F"))
    public float thirdPersonDistanceTemp(EntityRenderer instance) {
        return config.KodakEnabled ? (float)config.KodakDistance : this.thirdPersonDistanceTemp;
    }

    @Redirect(method = "orientCamera", at = @At(value = "FIELD", target = "Lnet/minecraft/client/renderer/EntityRenderer;thirdPersonDistance:F"))
    public float thirdPersonDistance(EntityRenderer instance) {
        return config.KodakEnabled ? (float)config.KodakDistance : this.thirdPersonDistance;
    }

    @Redirect(method = "orientCamera", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Vec3;distanceTo(Lnet/minecraft/util/Vec3;)D"))
    public double onCamera(Vec3 instance, Vec3 vec) {
        return config.KodakEnabled ? config.KodakDistance : instance.distanceTo(vec);
    }
}