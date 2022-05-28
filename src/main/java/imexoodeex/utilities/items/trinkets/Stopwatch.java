package imexoodeex.utilities.items.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import imexoodeex.utilities.config.ClothConfig;
import imexoodeex.utilities.utilities;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.text.DecimalFormat;
import java.util.List;

public class Stopwatch extends TrinketItem {

    public Stopwatch(Settings settings) {
        super(settings);
    }

    public static String text = "";
    int a = 0;
    String unit = "";

    Vec3d lastPos = new Vec3d(0, 0, 0);

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {

        DecimalFormat dec = new DecimalFormat("#0.00");
        PlayerEntity player = (PlayerEntity) entity;
        Vec3d pos = player.getPos();
        a++;

        if (a > 20) {
            a = 0;
        }

        if (a == 0) {
            lastPos = player.getPos();
        }

        double distance = lastPos.distanceTo(pos);
        double fixedDis = distance * 2;

        if (utilities.CONFIG.unit == ClothConfig.UNIT.KPH) {
            fixedDis *= 3.6;
            unit = "km/h";
        } else if (utilities.CONFIG.unit == ClothConfig.UNIT.MPS) {
            fixedDis *= 1;
            unit = "m/s";
        } else if (utilities.CONFIG.unit == ClothConfig.UNIT.MPH) {
            fixedDis *= 2.23;
            unit = "mph";
        }

        String formattedSpeed = dec.format(fixedDis);

        if (a == 20) {
            text = formattedSpeed + " " + unit;
        }


        super.tick(stack, slot, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText(getClass().getSimpleName()).formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}