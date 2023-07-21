package me.brekfst.tokenforge.files;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;

public class EnchantmentFile {

    private static File file;
    private static FileConfiguration enchantmentFile;

    // finds or generates the enchantments.yml file
    public static void setup() {
        File dataFolder = Bukkit.getPluginManager().getPlugin("TokenForge").getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        file = new File(dataFolder, "enchantment_points.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(ChatColor.RED + "Couldn't create file");
                e.printStackTrace();
            }
        }

        enchantmentFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get() {
        return enchantmentFile;
    }

    public static void save() {
        try {
            enchantmentFile.save(file);
        } catch (IOException e) {
            System.out.println("Couldn't save file");
            e.printStackTrace();
        }
    }

    public static void reload() {
        enchantmentFile = YamlConfiguration.loadConfiguration(file);
    }

    public static void setDefaultValues() {
        FileConfiguration config = EnchantmentFile.get();

        config.addDefault("enchantments.MENDING.1", 0);
        config.addDefault("enchantments.DURABILITY.3", 0);
        config.addDefault("enchantments.DURABILITY.4", 1000);
        config.addDefault("enchantments.DURABILITY.5", 1200);
        config.addDefault("enchantments.DURABILITY.6", 1500);
        config.addDefault("enchantments.DIG_SPEED.5", 0);
        config.addDefault("enchantments.DIG_SPEED.6", 1000);
        config.addDefault("enchantments.DIG_SPEED.7", 1250);
        config.addDefault("enchantments.LOOT_BONUS_BLOCKS.3", 0);
        config.addDefault("enchantments.LOOT_BONUS_BLOCKS.4", 750);
        config.addDefault("enchantments.LOOT_BONUS_BLOCKS.5", 1250);
        config.addDefault("enchantments.SILK_TOUCH.1", 0);
        config.addDefault("enchantments.LURE.3", 0);
        config.addDefault("enchantments.LURE.4", 750);
        config.addDefault("enchantments.LURE.5", 1000);
        config.addDefault("enchantments.LURE.6", 1300);
        config.addDefault("enchantments.LUCK.3", 0);
        config.addDefault("enchantments.LUCK.4", 500);
        config.addDefault("enchantments.LUCK.5", 750);
        config.addDefault("enchantments.LUCK.6", 1000);
        config.addDefault("enchantments.WATER_WORKER.1", 0);
        config.addDefault("enchantments.PROTECTION_EXPLOSIONS.4", 0);
        config.addDefault("enchantments.PROTECTION_EXPLOSIONS.5", 750);
        config.addDefault("enchantments.PROTECTION_EXPLOSIONS.6", 1000);
        config.addDefault("enchantments.PROTECTION_FIRE.4", 0);
        config.addDefault("enchantments.PROTECTION_FIRE.5", 750);
        config.addDefault("enchantments.PROTECTION_FIRE.6", 1000);
        config.addDefault("enchantments.PROTECTION_PROJECTILE.4", 0);
        config.addDefault("enchantments.PROTECTION_PROJECTILE.5", 750);
        config.addDefault("enchantments.PROTECTION_PROJECTILE.6", 1000);
        config.addDefault("enchantments.PROTECTION_ENVIRONMENTAL.4", 0);
        config.addDefault("enchantments.PROTECTION_ENVIRONMENTAL.5", 1500);
        config.addDefault("enchantments.PROTECTION_ENVIRONMENTAL.6", 2500);
        config.addDefault("enchantments.PROTECTION_FALL.4", 0);
        config.addDefault("enchantments.PROTECTION_FALL.5", 1000);
        config.addDefault("enchantments.FROST_WALKER.2", 0);
        config.addDefault("enchantments.FROST_WALKER.3", 500);
        config.addDefault("enchantments.FROST_WALKER.4", 750);
        config.addDefault("enchantments.FROST_WALKER.5", 1000);
        config.addDefault("enchantments.FROST_WALKER.6", 1250);
        config.addDefault("enchantments.OXYGEN.3", 0);
        config.addDefault("enchantments.OXYGEN.4", 500);
        config.addDefault("enchantments.OXYGEN.5", 750);
        config.addDefault("enchantments.OXYGEN.6", 1250);
        config.addDefault("enchantments.SOUL_SPEED.3", 0);
        config.addDefault("enchantments.SOUL_SPEED.4", 500);
        config.addDefault("enchantments.SOUL_SPEED.5", 750);
        config.addDefault("enchantments.THORNS.3", 0);
        config.addDefault("enchantments.THORNS.4", 500);
        config.addDefault("enchantments.THORNS.5", 750);
        config.addDefault("enchantments.THORNS.6", 1250);
        config.addDefault("enchantments.DEPTH_STRIDER.3", 0);
        config.addDefault("enchantments.DEPTH_STRIDER.4", 750);
        config.addDefault("enchantments.DEPTH_STRIDER.5", 1000);
        config.addDefault("enchantments.DEPTH_STRIDER.6", 1500);
        config.addDefault("enchantments.CHANNELING.1", 0);
        config.addDefault("enchantments.ARROW_FIRE.1", 0);
        config.addDefault("enchantments.ARROW_FIRE.2", 500);
        config.addDefault("enchantments.ARROW_FIRE.3", 750);
        config.addDefault("enchantments.ARROW_FIRE.4", 1000);
        config.addDefault("enchantments.ARROW_FIRE.5", 1250);
        config.addDefault("enchantments.IMPALING.5", 0);
        config.addDefault("enchantments.IMPALING.6", 500);
        config.addDefault("enchantments.ARROW_INFINITE.1", 0);
        config.addDefault("enchantments.LOYALTY.3", 0);
        config.addDefault("enchantments.LOYALTY.4", 500);
        config.addDefault("enchantments.LOYALTY.5", 750);
        config.addDefault("enchantments.LOYALTY.6", 1000);
        config.addDefault("enchantments.RIPTIDE.3", 0);
        config.addDefault("enchantments.RIPTIDE.4", 500);
        config.addDefault("enchantments.RIPTIDE.5", 750);
        config.addDefault("enchantments.RIPTIDE.6", 1000);
        config.addDefault("enchantments.MULTISHOT.1", 0);
        config.addDefault("enchantments.PIERCING.4", 0);
        config.addDefault("enchantments.PIERCING.5", 750);
        config.addDefault("enchantments.PIERCING.6", 1000);
        config.addDefault("enchantments.PIERCING.7", 1250);
        config.addDefault("enchantments.ARROW_DAMAGE.5", 0);
        config.addDefault("enchantments.ARROW_DAMAGE.6", 1000);
        config.addDefault("enchantments.ARROW_KNOCKBACK.2", 0);
        config.addDefault("enchantments.ARROW_KNOCKBACK.3", 750);
        config.addDefault("enchantments.ARROW_KNOCKBACK.4", 1000);
        config.addDefault("enchantments.ARROW_KNOCKBACK.5", 1250);
        config.addDefault("enchantments.ARROW_KNOCKBACK.6", 1750);
        config.addDefault("enchantments.QUICK_CHARGE.3", 0);
        config.addDefault("enchantments.QUICK_CHARGE.4", 500);
        config.addDefault("enchantments.QUICK_CHARGE.5", 750);
        config.addDefault("enchantments.DAMAGE_ARTHROPODS.5", 0);
        config.addDefault("enchantments.DAMAGE_ARTHROPODS.6", 500);
        config.addDefault("enchantments.FIRE_ASPECT.2", 0);
        config.addDefault("enchantments.FIRE_ASPECT.3", 500);
        config.addDefault("enchantments.FIRE_ASPECT.4", 750);
        config.addDefault("enchantments.FIRE_ASPECT.5", 1000);
        config.addDefault("enchantments.FIRE_ASPECT.6", 1300);
        config.addDefault("enchantments.LOOT_BONUS_MOBS.3", 0);
        config.addDefault("enchantments.LOOT_BONUS_MOBS.4", 1000);
        config.addDefault("enchantments.LOOT_BONUS_MOBS.5", 1250);
        config.addDefault("enchantments.LOOT_BONUS_MOBS.6", 2000);
        config.addDefault("enchantments.KNOCKBACK.2", 0);
        config.addDefault("enchantments.KNOCKBACK.3", 750);
        config.addDefault("enchantments.KNOCKBACK.4", 1000);
        config.addDefault("enchantments.KNOCKBACK.5", 1250);
        config.addDefault("enchantments.KNOCKBACK.6", 1500);
        config.addDefault("enchantments.DAMAGE_ALL.5", 0);
        config.addDefault("enchantments.DAMAGE_ALL.6", 1250);
        config.addDefault("enchantments.DAMAGE_ALL.7", 2000);
        config.addDefault("enchantments.DAMAGE_UNDEAD.5", 0);
        config.addDefault("enchantments.DAMAGE_UNDEAD.6", 500);
        config.addDefault("enchantments.SWEEPING_EDGE.3", 0);
        config.addDefault("enchantments.SWEEPING_EDGE.4", 500);
        config.addDefault("enchantments.SWEEPING_EDGE.5", 750);
        config.addDefault("enchantments.SWEEPING_EDGE.6", 1000);
        config.addDefault("enchantments.SWIFT_SNEAK.3", 0);
        config.addDefault("enchantments.SWIFT_SNEAK.4", 500);
        config.addDefault("enchantments.SWIFT_SNEAK.5", 750);
        config.addDefault("enchantments.SWIFT_SNEAK.6", 1250);

        EnchantmentFile.get().options().copyDefaults(true);
        EnchantmentFile.save();
    }

}



