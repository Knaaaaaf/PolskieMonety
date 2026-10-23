package pl.kna.polskimonety;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.text.Text;

public class PolskieMonetyClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register((drawContext, tickCounter) -> {
            var client = net.minecraft.client.MinecraftClient.getInstance();
            var player = client.player;
            if (player == null) return;

            int total = 0;
            for (var stack : player.getInventory().getMainStacks()) {
                if (stack.isOf(PolskieMonety.MONETA_1)) total += stack.getCount();
                else if (stack.isOf(PolskieMonety.MONETA_50)) total += stack.getCount() * 50;
                else if (stack.isOf(PolskieMonety.MONETA_100)) total += stack.getCount() * 100;
            }

            var stack = player.getOffHandStack();
            if (stack.isOf(PolskieMonety.MONETA_1)) total += stack.getCount();
            else if (stack.isOf(PolskieMonety.MONETA_50)) total += stack.getCount() * 50;
            else if (stack.isOf(PolskieMonety.MONETA_100)) total += stack.getCount() * 100;

            var text = Text.literal("Kasa: " + total + " zł");
            int x = drawContext.getScaledWindowWidth() - 8 - client.textRenderer.getWidth(text);
            drawContext.drawTextWithShadow(client.textRenderer, text, x, 8, 0xFFFFFF);
        });
    }
}
