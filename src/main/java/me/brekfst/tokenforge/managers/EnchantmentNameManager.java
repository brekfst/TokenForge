package me.brekfst.tokenforge.managers;

import org.bukkit.enchantments.Enchantment;

import java.lang.constant.Constable;
import java.util.HashMap;
import java.util.Map;

import static org.bukkit.enchantments.Enchantment.*;

public class EnchantmentNameManager {

    private static final Map<String, Enchantment> enchantmentNameMappings = new HashMap<>();

    public static Enchantment getEnchantmentAPI(String enchantmentName) {
        return enchantmentNameMappings.get(enchantmentName);
    }
    // set map for conversion of API names to in game names
    static {
        enchantmentNameMappings.put("mending", MENDING);
        enchantmentNameMappings.put("unbreaking", DURABILITY);
        enchantmentNameMappings.put("efficiency", DIG_SPEED);
        enchantmentNameMappings.put("fortune", LOOT_BONUS_BLOCKS);
        enchantmentNameMappings.put("silk touch", SILK_TOUCH);
        enchantmentNameMappings.put("lure", LURE);
        enchantmentNameMappings.put("luck of the sea", LUCK);
        enchantmentNameMappings.put("aqua affinity", WATER_WORKER);
        enchantmentNameMappings.put("blast protection", PROTECTION_EXPLOSIONS);
        enchantmentNameMappings.put("fire protection", PROTECTION_FIRE);
        enchantmentNameMappings.put("projectile protection", PROTECTION_PROJECTILE);
        enchantmentNameMappings.put("protection", PROTECTION_ENVIRONMENTAL);
        enchantmentNameMappings.put("feather falling", PROTECTION_FALL);
        enchantmentNameMappings.put("frost walker", FROST_WALKER);
        enchantmentNameMappings.put("respiration", OXYGEN);
        enchantmentNameMappings.put("soul speed", SOUL_SPEED);
        enchantmentNameMappings.put("thorns", THORNS);
        enchantmentNameMappings.put("depth strider", DEPTH_STRIDER);
        enchantmentNameMappings.put("channeling", CHANNELING);
        enchantmentNameMappings.put("flame", ARROW_FIRE);
        enchantmentNameMappings.put("impaling", IMPALING);
        enchantmentNameMappings.put("infinity", ARROW_INFINITE);
        enchantmentNameMappings.put("loyalty", LOYALTY);
        enchantmentNameMappings.put("riptide", RIPTIDE);
        enchantmentNameMappings.put("multishot", MULTISHOT);
        enchantmentNameMappings.put("piercing", PIERCING);
        enchantmentNameMappings.put("power", ARROW_DAMAGE);
        enchantmentNameMappings.put("punch", ARROW_KNOCKBACK);
        enchantmentNameMappings.put("quick charge", QUICK_CHARGE);
        enchantmentNameMappings.put("bane of arthropods", DAMAGE_ARTHROPODS);
        enchantmentNameMappings.put("fire aspect", FIRE_ASPECT);
        enchantmentNameMappings.put("looting", LOOT_BONUS_MOBS);
        enchantmentNameMappings.put("knockback", KNOCKBACK);
        enchantmentNameMappings.put("sharpness", DAMAGE_ALL);
        enchantmentNameMappings.put("smite", DAMAGE_UNDEAD);
        enchantmentNameMappings.put("sweeping edge", SWEEPING_EDGE);
        enchantmentNameMappings.put("swift sneak", SWIFT_SNEAK);
    }

}
