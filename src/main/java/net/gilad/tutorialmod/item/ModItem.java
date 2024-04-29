package net.gilad.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.gilad.tutorialmod.TutorialMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItem {
    public static final Item SMILE = regiterItem("smile", new Item(new FabricItemSettings()));

    public static void addItemToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(SMILE);
    }

    public static Item regiterItem (String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items For " + TutorialMod.MOD_ID );
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItem::addItemToIngredientItemGroup);
    }
}
