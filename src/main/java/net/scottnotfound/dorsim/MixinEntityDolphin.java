package net.scottnotfound.dorsim;

import net.minecraft.entity.passive.EntityDolphin;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityDolphin.class)
public abstract class MixinEntityDolphin {


    @Inject(
            method = "processInteract",
            at = @At(value = "HEAD")
    )
    public void onDolphinInteract(EntityPlayer p_processInteract_1_, EnumHand p_processInteract_2_, CallbackInfoReturnable<Boolean> cir) {

        ItemStack itemStack = p_processInteract_1_.getHeldItem(p_processInteract_2_);

        if (itemStack.isEmpty()) {
            p_processInteract_1_.rotationYaw = ((EntityDolphin) (Object) this).rotationYaw;
            p_processInteract_1_.rotationPitch = ((EntityDolphin) (Object) this).rotationPitch;

            if (((EntityDolphin) (Object) this).world.isRemote) {
                p_processInteract_1_.startRiding(((EntityDolphin) (Object) this));
            }
        }

    }
}
