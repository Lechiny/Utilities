package imexoodeex.supplementaryaccessories.items.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import imexoodeex.supplementaryaccessories.client.particles.RocketBootsParticles;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.TitleS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class RocketBoots extends TrinketItem {

    public RocketBoots(Settings settings) {
        super(settings);
    }

    int a = 0;

    private void resetTimer() {
        a = 0;
    }
    private final int activeValue = 15;

    /* 20 tick is 1 second, so 5 * 1 sec is 5 seconds of flying*/
    private double flightTime = 5 * 20;
    private final double flightTimeMax = 5 * 20;

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
            boolean isGrounded = entity.isOnGround();
            boolean isJumping = MinecraftClient.getInstance().options.jumpKey.isPressed();
            boolean isRocketFlying = isJumping && !isGrounded && !entity.isClimbing() && a >= activeValue;
            Vec3d v = entity.getVelocity();
            double yVelocity = v.getY();

            World world = entity.world;

        if (isJumping || !isGrounded) {
            a++;
        } else {
            resetTimer();
        }

            if (entity.isSwimming() && entity.isInSwimmingPose()) {
                entity.setVelocity(v.getX(), v.getY(), v.getZ());
            }
            else if (entity.isSubmergedInWater() && isJumping) {
                entity.setVelocity(v.getX(), (yVelocity * 0.9) + 0.01, v.getZ());
                RocketBootsParticles.spawnRocketParticles(entity, world);
            }
            else if (isJumping && !isGrounded && !entity.isClimbing() && a >= activeValue ) {
                if (flightTime > 0) {
                    entity.fallDistance = 0.0F;
                    flightTime--;
                    entity.setVelocity(v.getX(), (yVelocity * 0.9) + 0.1, v.getZ());
                    RocketBootsParticles.spawnRocketParticles(entity, world);
                    }
                }
        if (!isRocketFlying) {
            flightTime = flightTime + 0.15;
        }

        if (flightTime > flightTimeMax) {
            flightTime = flightTimeMax;
        }
        super.tick(stack, slot, entity);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        flightTime = flightTime + 0.15;
        if (flightTime > flightTimeMax) {
            flightTime = flightTimeMax;
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add( new TranslatableText(getClass().getSimpleName()).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}