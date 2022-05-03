package imexoodeex.supplementaryaccessories.registers;

import imexoodeex.supplementaryaccessories.items.trinkets.*;
import imexoodeex.supplementaryaccessories.util.ModItemGroup;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

import static imexoodeex.supplementaryaccessories.items.SAItems.registerItems;

public class ItemRegister {

    private static final Item.Settings createGroup = new Item.Settings().group(ModItemGroup.SUPPLEMENTARY_ACCESSORIES).maxCount(1).maxDamage(100);

    public static Item spectre_boots = new SpectreBoots(createGroup.rarity(Rarity.EPIC));
    public static Item combatshield = new CombatShield(createGroup.rarity(Rarity.EPIC));
    public static Item obsidianshield = new ObsidianShield(createGroup.rarity(Rarity.EPIC));

    public static Item hamburgercap = new HamburgerCap(createGroup.rarity(Rarity.RARE));
    public static Item rocket_boots = new RocketBoots(createGroup.rarity(Rarity.RARE));
    public static Item bandofregeneration = new BandOfRegeneration(createGroup.rarity(Rarity.RARE));
    public static Item feralclaws = new FeralClaws(createGroup.rarity(Rarity.RARE));

    public static Item hermes_boots = new HermesBoots(createGroup.rarity(Rarity.UNCOMMON));
    public static Item mask = new Mask(createGroup.rarity(Rarity.UNCOMMON));
    public static Item blindfold = new Blindfold(createGroup.rarity(Rarity.UNCOMMON));
    public static Item vitamins = new Vitamins(createGroup.rarity(Rarity.UNCOMMON));

    public static Item horseshoe = new Horseshoe(createGroup.rarity(Rarity.COMMON));
    public static Item aglet = new Aglet(createGroup.rarity(Rarity.COMMON));
    public static Item flipper = new Flipper(createGroup.rarity(Rarity.COMMON));
    public static Item cloudinabottle = new CloudInABottle(createGroup.rarity(Rarity.COMMON));
    public static Item balloon = new Balloon(createGroup.rarity(Rarity.COMMON));
    public static Item cloudinaballoon = new CloudInABalloon(createGroup.rarity(Rarity.COMMON));
    public static Item bezoar = new Bezoar(createGroup.rarity(Rarity.COMMON));
    public static Item watch = new Watch(createGroup.rarity(Rarity.COMMON));
    public static Item gps = new GPS(createGroup.rarity(Rarity.COMMON));
    public static Item radar = new Radar(createGroup.rarity(Rarity.COMMON));
    public static Item frogleg = new FrogLeg(createGroup.rarity(Rarity.COMMON));
    public static Item frogflipper = new FrogFlipper(createGroup.rarity(Rarity.COMMON));
    public static Item blackbelt = new BlackBelt(createGroup.rarity(Rarity.COMMON));
    public static Item warrioremblem = new WarriorEmblem(createGroup.rarity(Rarity.COMMON));

    public static void init() {
        registerItems("spectre_boots", spectre_boots);
        registerItems("rocket_boots", rocket_boots);
        registerItems("hermes_boots", hermes_boots);
        registerItems("horseshoe", horseshoe);
        registerItems("aglet", aglet);
        registerItems("bandofregeneration", bandofregeneration);
        registerItems("blindfold", blindfold);
        registerItems("feralclaws", feralclaws);
        registerItems("mask", mask);
        registerItems("bezoar", bezoar);
        registerItems("hamburgercap", hamburgercap);
        registerItems("combatshield", combatshield);
        registerItems("obsidianshield", obsidianshield);
        registerItems("balloon", balloon);
        registerItems("cloudinaballoon", cloudinaballoon);
        registerItems("cloudinabottle", cloudinabottle);
        registerItems("radar", radar);
        registerItems("gps", gps);
        registerItems("watch", watch);
        registerItems("vitamins", vitamins);
        registerItems("flipper", flipper);
        registerItems("frogleg", frogleg);
        registerItems("frogflipper", frogflipper);
        registerItems("blackbelt", blackbelt);
        registerItems("warrioremblem", warrioremblem);
    }
}