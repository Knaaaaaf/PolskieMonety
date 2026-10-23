package pl.kna.polskimonety;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PolskieMonety implements ModInitializer {
    public static final String MOD_ID = "polskie_monety";

    public static final Item MONETA_1 = register("moneta_1zl", new Item(new Item.Settings()));
    public static final Item MONETA_50 = register("moneta_50zl", new Item(new Item.Settings()));
    public static final Item MONETA_100 = register("moneta_100zl", new Item(new Item.Settings()));

    private static Item register(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), item);
    }

    @Override
    public void onInitialize() {
        // Monety rejestrowane są podczas inicjalizacji klasy.
    }
}
