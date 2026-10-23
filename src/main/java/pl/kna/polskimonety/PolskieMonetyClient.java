package pl.kna.polskimonety;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.text.Text;

public class PolskieMonetyClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register((drawContext, tickCounter) -> {
            if (net.minecraft.client.MinecraftClient.getInstance().player == null) return;

            var player = net.minecraft.client.MinecraftClient.getInstance().player;
            int total = 0;
            for (var stack : player.getInventory().main) {
                if (stack.isOf(PolskieMonety.MONETA_1)) total += stack.getCount();
                else if (stack.isOf(PolskieMonety.MONETA_50)) total += stack.getCount() * 50;
                else if (stack.isOf(PolskieMonety.MONETA_100)) total += stack.getCount() * 100;
            }
            for (var stack : player.getInventory().offHand) {
                if (stack.isOf(PolskieMonety.MONETA_1)) total += stack.getCount();
                else if (stack.isOf(PolskieMonety.MONETA_50)) total += stack.getCount() * 50;
                else if (stack.isOf(PolskieMonety.MONETA_100)) total += stack.getCount() * 100;
            }

            var text = Text.literal("Kasa: " + total + " zł");
            int x = drawContext.getScaledWindowWidth() - 8 - net.minecraft.client.MinecraftClient.getInstance().textRenderer.getWidth(text);
            drawContext.drawTextWithShadow(
                net.minecraft.client.MinecraftClient.getInstance().textRenderer,
                text, x, 8, 0xFFFFFF
            );
        });
    }
}
