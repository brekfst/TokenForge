package me.brekfst.tokenforge.managers;

import me.brekfst.tokenforge.TokenForge;
import me.brekfst.tokenforge.files.EnchantmentFile;
import me.brekfst.tokenforge.utilitys.EnchantmentUtility;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class PointsManager {

    static Plugin plugin = TokenForge.getPlugin(TokenForge.class);

    private static final Map<Enchantment, Map<Integer, Integer>> enchantmentPoints = new HashMap<>();
    private static Map<Player, Integer> playerPoints = new HashMap<>();
    private static int maxPoints = 5000;

    public static int getRemainingPoints(Player player) {
        return playerPoints.getOrDefault(player, maxPoints);
    }

    public static boolean canAffordPoints(Player player, int points) {
        int remainingPoints = getRemainingPoints(player);
        return remainingPoints >= points;
    }

    public static void deductPoints(Player player, int points) {
        int remainingPoints = getRemainingPoints(player);
        playerPoints.put(player, remainingPoints - points);

    }

    public static void addPoints(Player player, int points) {
        int remainingPoints = getRemainingPoints(player);
        playerPoints.put(player, remainingPoints + points);
    }

    public static void removePlayerPoints(Player player) {
        playerPoints.remove(player);
    }

    public static int getEnchantmentPoints(Enchantment enchantment, int level) {
        Map<Integer, Integer> levelPoints = enchantmentPoints.get(enchantment);
        if (levelPoints != null) {
            Integer points = levelPoints.get(level);
            if (points != null) {
                return points;
            }
        }
        // Default if enchantment or level not found
        return 0;
    }

    static  {
        // mending points
        Map<Integer, Integer> mendingPoints = new HashMap<>();
        mendingPoints.put(1, EnchantmentFile.get().getInt("enchantment_points.enchantments.MENDING.1"));


        enchantmentPoints.put(Enchantment.MENDING, mendingPoints);
        // unbreaking points
        Map<Integer, Integer> unbreakingPoints = new HashMap<>();
        unbreakingPoints.put(3, EnchantmentFile.get().getInt("enchantments.DURABILITY.3"));
        unbreakingPoints.put(4, EnchantmentFile.get().getInt("enchantments.DURABILITY.4"));
        unbreakingPoints.put(5, EnchantmentFile.get().getInt("enchantments.DURABILITY.5"));
        unbreakingPoints.put(6, EnchantmentFile.get().getInt("enchantments.DURABILITY.6"));

        enchantmentPoints.put(Enchantment.DURABILITY, unbreakingPoints);
        // efficiency points
        Map<Integer, Integer> efficiencyPoints = new HashMap<>();
        efficiencyPoints.put(5, EnchantmentFile.get().getInt("enchantments.DIG_SPEED.5"));
        efficiencyPoints.put(6, EnchantmentFile.get().getInt("enchantments.DIG_SPEED.6"));
        efficiencyPoints.put(7, EnchantmentFile.get().getInt("enchantments.DIG_SPEED.7"));

        enchantmentPoints.put(Enchantment.DIG_SPEED, efficiencyPoints);
        // fortune points
        Map<Integer, Integer> fortunePoints = new HashMap<>();
        fortunePoints.put(3, EnchantmentFile.get().getInt("enchantments.LOOT_BONUS_BLOCKS.3"));
        fortunePoints.put(4, EnchantmentFile.get().getInt("enchantments.LOOT_BONUS_BLOCKS.4"));
        fortunePoints.put(5, EnchantmentFile.get().getInt("enchantments.LOOT_BONUS_BLOCKS.5"));

        enchantmentPoints.put(Enchantment.LOOT_BONUS_BLOCKS, fortunePoints);
        // silk touch points
        Map<Integer, Integer> silkTouchPoints = new HashMap<>();
        silkTouchPoints.put(1, EnchantmentFile.get().getInt("enchantments.SILK_TOUCH.1"));

        enchantmentPoints.put(Enchantment.SILK_TOUCH, silkTouchPoints);
        // lure points
        Map<Integer, Integer> lurePoints = new HashMap<>();
        lurePoints.put(3, EnchantmentFile.get().getInt("enchantments.LURE.3"));
        lurePoints.put(4, EnchantmentFile.get().getInt("enchantments.LURE.4"));
        lurePoints.put(5, EnchantmentFile.get().getInt("enchantments.LURE.5"));
        lurePoints.put(6, EnchantmentFile.get().getInt("enchantments.LURE.6"));

        enchantmentPoints.put(Enchantment.LURE, lurePoints);
        // luck of the sea points
        Map<Integer, Integer> luckOfTheSeaPoints = new HashMap<>();
        luckOfTheSeaPoints.put(3, EnchantmentFile.get().getInt("enchantments.LUCK.3"));
        luckOfTheSeaPoints.put(4, EnchantmentFile.get().getInt("enchantments.LUCK.4"));
        luckOfTheSeaPoints.put(5, EnchantmentFile.get().getInt("enchantments.LUCK.5"));
        luckOfTheSeaPoints.put(6, EnchantmentFile.get().getInt("enchantments.LUCK.6"));

        enchantmentPoints.put(Enchantment.LUCK, luckOfTheSeaPoints);
        // aqua affinity points
        Map<Integer, Integer> aquaAffinityPoints = new HashMap<>();
        aquaAffinityPoints.put(1, EnchantmentFile.get().getInt("enchantments.WATER_WORKER.1"));

        enchantmentPoints.put(Enchantment.WATER_WORKER, aquaAffinityPoints);
        // blast protection points
        Map<Integer, Integer> blastProtectionPoints = new HashMap<>();
        blastProtectionPoints.put(4, EnchantmentFile.get().getInt("enchantments.PROTECTION_EXPLOSIONS.4"));
        blastProtectionPoints.put(5, EnchantmentFile.get().getInt("enchantments.PROTECTION_EXPLOSIONS.5"));
        blastProtectionPoints.put(6, EnchantmentFile.get().getInt("enchantments.PROTECTION_EXPLOSIONS.6"));

        enchantmentPoints.put(Enchantment.PROTECTION_EXPLOSIONS, blastProtectionPoints);
        // fire protection points
        Map<Integer, Integer> fireProtectionPoints = new HashMap<>();
        fireProtectionPoints.put(4, EnchantmentFile.get().getInt("enchantments.PROTECTION_FIRE.4"));
        fireProtectionPoints.put(5, EnchantmentFile.get().getInt("enchantments.PROTECTION_FIRE.5"));
        fireProtectionPoints.put(6, EnchantmentFile.get().getInt("enchantments.PROTECTION_FIRE.6"));

        enchantmentPoints.put(Enchantment.PROTECTION_FIRE, fireProtectionPoints);
        // projectile protection points
        Map<Integer, Integer> projectileProtectionPoints = new HashMap<>();
        projectileProtectionPoints.put(4, EnchantmentFile.get().getInt("enchantments.PROTECTION_PROJECTILE.4"));
        projectileProtectionPoints.put(5, EnchantmentFile.get().getInt("enchantments.PROTECTION_PROJECTILE.5"));
        projectileProtectionPoints.put(6, EnchantmentFile.get().getInt("enchantments.PROTECTION_PROJECTILE.6"));

        enchantmentPoints.put(Enchantment.PROTECTION_PROJECTILE, projectileProtectionPoints);
        // protection points
        Map<Integer, Integer> protectionPoints = new HashMap<>();
        protectionPoints.put(4, EnchantmentFile.get().getInt("enchantments.PROTECTION_ENVIRONMENTAL.4"));
        protectionPoints.put(5, EnchantmentFile.get().getInt("enchantments.PROTECTION_ENVIRONMENTAL.5"));
        protectionPoints.put(6, EnchantmentFile.get().getInt("enchantments.PROTECTION_ENVIRONMENTAL.6"));

        enchantmentPoints.put(Enchantment.PROTECTION_ENVIRONMENTAL, protectionPoints);
        // feather falling points
        Map<Integer, Integer> featherFallingPoints = new HashMap<>();
        featherFallingPoints.put(4, EnchantmentFile.get().getInt("enchantments.PROTECTION_FALL.4"));
        featherFallingPoints.put(5, EnchantmentFile.get().getInt("enchantments.PROTECTION_FALL.5"));

        enchantmentPoints.put(Enchantment.PROTECTION_FALL, featherFallingPoints);
        // frost walker points
        Map<Integer, Integer> frostWalkerPoints = new HashMap<>();
        frostWalkerPoints.put(2, EnchantmentFile.get().getInt("enchantments.FROST_WALKER.2"));
        frostWalkerPoints.put(3, EnchantmentFile.get().getInt("enchantments.FROST_WALKER.3"));
        frostWalkerPoints.put(4, EnchantmentFile.get().getInt("enchantments.FROST_WALKER.4"));
        frostWalkerPoints.put(5, EnchantmentFile.get().getInt("enchantments.FROST_WALKER.5"));
        frostWalkerPoints.put(6, EnchantmentFile.get().getInt("enchantments.FROST_WALKER.6"));

        enchantmentPoints.put(Enchantment.FROST_WALKER, frostWalkerPoints);
        // respiration points
        Map<Integer, Integer> respirationPoints = new HashMap<>();
        respirationPoints.put(3, EnchantmentFile.get().getInt("enchantments.OXYGEN.3"));
        respirationPoints.put(4, EnchantmentFile.get().getInt("enchantments.OXYGEN.4"));
        respirationPoints.put(5, EnchantmentFile.get().getInt("enchantments.OXYGEN.5"));
        respirationPoints.put(6, EnchantmentFile.get().getInt("enchantments.OXYGEN.6"));

        enchantmentPoints.put(Enchantment.OXYGEN, respirationPoints);
        // soul speed points
        Map<Integer, Integer> soulSpeedPoints = new HashMap<>();
        soulSpeedPoints.put(3, EnchantmentFile.get().getInt("enchantments.SOUL_SPEED.3"));
        soulSpeedPoints.put(4, EnchantmentFile.get().getInt("enchantments.SOUL_SPEED.4"));
        soulSpeedPoints.put(5, EnchantmentFile.get().getInt("enchantments.SOUL_SPEED.5"));

        enchantmentPoints.put(Enchantment.SOUL_SPEED, soulSpeedPoints);
        // thorns points
        Map<Integer, Integer> thornsPoints = new HashMap<>();
        thornsPoints.put(3, EnchantmentFile.get().getInt("enchantments.THORNS.3"));
        thornsPoints.put(4, EnchantmentFile.get().getInt("enchantments.THORNS.4"));
        thornsPoints.put(5, EnchantmentFile.get().getInt("enchantments.THORNS.5"));
        thornsPoints.put(6, EnchantmentFile.get().getInt("enchantments.THORNS.6"));

        enchantmentPoints.put(Enchantment.THORNS, thornsPoints);
        // depth strider points
        Map<Integer, Integer> depthStriderPoints = new HashMap<>();
        depthStriderPoints.put(3, EnchantmentFile.get().getInt("enchantments.DEPTH_STRIDER.3"));
        depthStriderPoints.put(4, EnchantmentFile.get().getInt("enchantments.DEPTH_STRIDER.4"));
        depthStriderPoints.put(5, EnchantmentFile.get().getInt("enchantments.DEPTH_STRIDER.5"));
        depthStriderPoints.put(6, EnchantmentFile.get().getInt("enchantments.DEPTH_STRIDER.6"));

        enchantmentPoints.put(Enchantment.DEPTH_STRIDER, depthStriderPoints);
        // channeling points
        Map<Integer, Integer> channelingPoints = new HashMap<>();
        channelingPoints.put(1, EnchantmentFile.get().getInt("enchantments.CHANNELING.1"));

        // flame points
        Map<Integer, Integer> flamePoints = new HashMap<>();
        flamePoints.put(1, EnchantmentFile.get().getInt("enchantments.ARROW_FIRE.1"));
        flamePoints.put(2, EnchantmentFile.get().getInt("enchantments.ARROW_FIRE.2"));
        flamePoints.put(3, EnchantmentFile.get().getInt("enchantments.ARROW_FIRE.3"));
        flamePoints.put(4, EnchantmentFile.get().getInt("enchantments.ARROW_FIRE.4"));
        flamePoints.put(5, EnchantmentFile.get().getInt("enchantments.ARROW_FIRE.5"));

        enchantmentPoints.put(Enchantment.ARROW_FIRE, flamePoints);
        // impaling points
        Map<Integer, Integer> impalingPoints = new HashMap<>();
        impalingPoints.put(5, EnchantmentFile.get().getInt("enchantments.DAMAGE_ALL.5"));
        impalingPoints.put(6, EnchantmentFile.get().getInt("enchantments.DAMAGE_ALL.6"));

        enchantmentPoints.put(Enchantment.IMPALING, impalingPoints);
        // infinity points
        Map<Integer, Integer> infinityPoints = new HashMap<>();
        infinityPoints.put(1, EnchantmentFile.get().getInt("enchantments.ARROW_INFINITE.1"));

        enchantmentPoints.put(Enchantment.ARROW_INFINITE, infinityPoints);
        // loyalty points
        Map<Integer, Integer> loyaltyPoints = new HashMap<>();
        loyaltyPoints.put(3, EnchantmentFile.get().getInt("enchantments.LOYALTY.3"));
        loyaltyPoints.put(4, EnchantmentFile.get().getInt("enchantments.LOYALTY.4"));
        loyaltyPoints.put(5, EnchantmentFile.get().getInt("enchantments.LOYALTY.5"));
        loyaltyPoints.put(6, EnchantmentFile.get().getInt("enchantments.LOYALTY.6"));

        enchantmentPoints.put(Enchantment.LOYALTY, loyaltyPoints);
        // rip tide points
        Map<Integer, Integer> ripTidePoints = new HashMap<>();
        ripTidePoints.put(3, EnchantmentFile.get().getInt("enchantments.RIPTIDE.3"));
        ripTidePoints.put(4, EnchantmentFile.get().getInt("enchantments.RIPTIDE.4"));
        ripTidePoints.put(5, EnchantmentFile.get().getInt("enchantments.RIPTIDE.5"));
        ripTidePoints.put(6, EnchantmentFile.get().getInt("enchantments.RIPTIDE.6"));

        enchantmentPoints.put(Enchantment.RIPTIDE, ripTidePoints);
        // multishot points
        Map<Integer, Integer> multishotPoints = new HashMap<>();
        multishotPoints.put(1, EnchantmentFile.get().getInt("enchantments.MULTISHOT.1"));

        enchantmentPoints.put(Enchantment.MULTISHOT, multishotPoints);
        // piercing points
        Map<Integer, Integer> piercingPoints = new HashMap<>();
        piercingPoints.put(4, EnchantmentFile.get().getInt("enchantments.PIERCING.4"));
        piercingPoints.put(5, EnchantmentFile.get().getInt("enchantments.PIERCING.5"));
        piercingPoints.put(6, EnchantmentFile.get().getInt("enchantments.PIERCING.6"));
        piercingPoints.put(7, EnchantmentFile.get().getInt("enchantments.PIERCING.7"));

        enchantmentPoints.put(Enchantment.PIERCING, piercingPoints);
        // power points
        Map<Integer, Integer> powerPoints = new HashMap<>();
        powerPoints.put(5, EnchantmentFile.get().getInt("enchantments.ARROW_DAMAGE.5"));
        powerPoints.put(6, EnchantmentFile.get().getInt("enchantments.ARROW_DAMAGE.6"));

        enchantmentPoints.put(Enchantment.ARROW_DAMAGE, powerPoints);
        // punch points
        Map<Integer, Integer> punchPoints = new HashMap<>();
        punchPoints.put(2, EnchantmentFile.get().getInt("enchantments.ARROW_KNOCKBACK.2"));
        punchPoints.put(3, EnchantmentFile.get().getInt("enchantments.ARROW_KNOCKBACK.3"));
        punchPoints.put(4, EnchantmentFile.get().getInt("enchantments.ARROW_KNOCKBACK.4"));
        punchPoints.put(5, EnchantmentFile.get().getInt("enchantments.ARROW_KNOCKBACK.5"));
        punchPoints.put(6, EnchantmentFile.get().getInt("enchantments.ARROW_KNOCKBACK.6"));

        enchantmentPoints.put(Enchantment.ARROW_KNOCKBACK, punchPoints);
        // quick charge points
        Map<Integer, Integer> quickChargePoints = new HashMap<>();
        quickChargePoints.put(3, EnchantmentFile.get().getInt("enchantments.QUICK_CHARGE.3"));
        quickChargePoints.put(4, EnchantmentFile.get().getInt("enchantments.QUICK_CHARGE.4"));
        quickChargePoints.put(5, EnchantmentFile.get().getInt("enchantments.QUICK_CHARGE.5"));

        enchantmentPoints.put(Enchantment.QUICK_CHARGE, quickChargePoints);
        // bane of arthropods points
        Map<Integer, Integer> baneOfArthropodsPoints = new HashMap<>();
        baneOfArthropodsPoints.put(5, EnchantmentFile.get().getInt("enchantments.DAMAGE_ARTHROPODS.5"));
        baneOfArthropodsPoints.put(6, EnchantmentFile.get().getInt("enchantments.DAMAGE_ARTHROPODS.6"));

        enchantmentPoints.put(Enchantment.DAMAGE_ARTHROPODS, baneOfArthropodsPoints);
        // fire aspect points
        Map<Integer, Integer> fireAspectPoints = new HashMap<>();
        fireAspectPoints.put(2, EnchantmentFile.get().getInt("enchantments.FIRE_ASPECT.2"));
        fireAspectPoints.put(3, EnchantmentFile.get().getInt("enchantments.FIRE_ASPECT.3"));
        fireAspectPoints.put(4, EnchantmentFile.get().getInt("enchantments.FIRE_ASPECT.4"));
        fireAspectPoints.put(5, EnchantmentFile.get().getInt("enchantments.FIRE_ASPECT.5"));
        fireAspectPoints.put(6, EnchantmentFile.get().getInt("enchantments.FIRE_ASPECT.6"));

        enchantmentPoints.put(Enchantment.FIRE_ASPECT, fireAspectPoints);
        // looting points
        Map<Integer, Integer> lootingPoints = new HashMap<>();
        lootingPoints.put(3, EnchantmentFile.get().getInt("enchantments.LOOT_BONUS_MOBS.3"));
        lootingPoints.put(4, EnchantmentFile.get().getInt("enchantments.LOOT_BONUS_MOBS.4"));
        lootingPoints.put(5, EnchantmentFile.get().getInt("enchantments.LOOT_BONUS_MOBS.5"));
        lootingPoints.put(6, EnchantmentFile.get().getInt("enchantments.LOOT_BONUS_MOBS.6"));


        enchantmentPoints.put(Enchantment.LOOT_BONUS_MOBS, lootingPoints);
        // knockback points
        Map<Integer, Integer> knockbackPoints = new HashMap<>();
        knockbackPoints.put(2, EnchantmentFile.get().getInt("enchantments.KNOCKBACK.2"));
        knockbackPoints.put(3, EnchantmentFile.get().getInt("enchantments.KNOCKBACK.3"));
        knockbackPoints.put(4, EnchantmentFile.get().getInt("enchantments.KNOCKBACK.4"));
        knockbackPoints.put(5, EnchantmentFile.get().getInt("enchantments.KNOCKBACK.5"));
        knockbackPoints.put(6, EnchantmentFile.get().getInt("enchantments.KNOCKBACK.6"));

        enchantmentPoints.put(Enchantment.KNOCKBACK, knockbackPoints);
        // sharpness points
        Map<Integer, Integer> sharpnessPoints = new HashMap<>();
        sharpnessPoints.put(5, EnchantmentFile.get().getInt("enchantments.DAMAGE_ALL.5"));
        sharpnessPoints.put(6, EnchantmentFile.get().getInt("enchantments.DAMAGE_ALL.6"));
        sharpnessPoints.put(7, EnchantmentFile.get().getInt("enchantments.DAMAGE_ALL.7"));

        enchantmentPoints.put(Enchantment.DAMAGE_ALL, sharpnessPoints);
        // smite points
        Map<Integer, Integer> smitePoints = new HashMap<>();
        smitePoints.put(5, EnchantmentFile.get().getInt("enchantments.DAMAGE_UNDEAD.5"));
        smitePoints.put(6, EnchantmentFile.get().getInt("enchantments.DAMAGE_UNDEAD.6"));

        enchantmentPoints.put(Enchantment.DAMAGE_UNDEAD, smitePoints);
        // sweeping edge points
        Map<Integer, Integer> sweepingEdgePoints = new HashMap<>();
        sweepingEdgePoints.put(3, EnchantmentFile.get().getInt("enchantments.SWEEPING_EDGE.3"));
        sweepingEdgePoints.put(4, EnchantmentFile.get().getInt("enchantments.SWEEPING_EDGE.4"));
        sweepingEdgePoints.put(5, EnchantmentFile.get().getInt("enchantments.SWEEPING_EDGE.5"));
        sweepingEdgePoints.put(6, EnchantmentFile.get().getInt("enchantments.SWEEPING_EDGE.6"));

        enchantmentPoints.put(Enchantment.SWEEPING_EDGE, sweepingEdgePoints);
        // swift sneak points
        Map<Integer, Integer> swiftSneakPoints = new HashMap<>();
        swiftSneakPoints.put(3, EnchantmentFile.get().getInt("enchantments.SWIFT_SNEAK.3"));
        swiftSneakPoints.put(4, EnchantmentFile.get().getInt("enchantments.SWIFT_SNEAK.4"));
        swiftSneakPoints.put(5, EnchantmentFile.get().getInt("enchantments.SWIFT_SNEAK.5"));
        swiftSneakPoints.put(6, EnchantmentFile.get().getInt("enchantments.SWIFT_SNEAK.6"));

        enchantmentPoints.put(Enchantment.SWIFT_SNEAK, swiftSneakPoints);

    }
}