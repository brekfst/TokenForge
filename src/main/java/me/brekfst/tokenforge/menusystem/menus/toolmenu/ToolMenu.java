package me.brekfst.tokenforge.menusystem.menus.toolmenu;

import java.util.Arrays;
import java.util.Map;

import me.brekfst.tokenforge.TokenForge;
import me.brekfst.tokenforge.managers.PointsManager;
import me.brekfst.tokenforge.menusystem.Menu;
import me.brekfst.tokenforge.menusystem.menus.howtomenu.HowToMenu;
import me.brekfst.tokenforge.menusystem.menus.toolenchantment.*;
import me.brekfst.tokenforge.utilitys.PlayerMenuUtility;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ToolMenu extends Menu {

    ItemStack selectedTool;

    Map<Enchantment, Integer> selectedEnchantments;
    public ToolMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
        selectedEnchantments = playerMenuUtility.getSelectedEnchantments();
    }

    public String getMenuName() {
        return "Select a tool!";
    }

    public int getSlots() {
        return 54;
    }

    public void handleMenu(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        int slot = event.getRawSlot();

        switch (slot) {
            case 4:
                // points remaining
                break;
            case 13:
                ItemStack elytra = event.getCurrentItem();
                if (elytra != null) {
                    PlayerMenuUtility playerMenuUtility = TokenForge.getPlayerMenuUtility(player);
                    playerMenuUtility.setSelectedTool(elytra);
                }

                player.playSound(player.getLocation(), "entity.player.levelup", 1.0F, 1.0F);
                new ElytraMenu(TokenForge.getPlayerMenuUtility(player)).open();
                break;
            case 20:
                ItemStack sword = event.getCurrentItem();
                if (sword != null) {
                    PlayerMenuUtility playerMenuUtility = TokenForge.getPlayerMenuUtility(player);
                    playerMenuUtility.setSelectedTool(sword);
                }

                player.playSound(player.getLocation(), "entity.player.levelup", 1.0F, 1.0F);
                new SwordMenu(TokenForge.getPlayerMenuUtility(player)).open();
                break;
            case 21:
                ItemStack pickaxe = event.getCurrentItem();
                if (pickaxe != null) {
                    PlayerMenuUtility playerMenuUtility = TokenForge.getPlayerMenuUtility(player);
                    playerMenuUtility.setSelectedTool(pickaxe);
                }

                player.playSound(player.getLocation(), "entity.player.levelup", 1.0F, 1.0F);
                new PickaxeMenu(TokenForge.getPlayerMenuUtility(player)).open();
                break;
            case 22:
                ItemStack axe = event.getCurrentItem();
                if (axe != null) {
                    PlayerMenuUtility playerMenuUtility = TokenForge.getPlayerMenuUtility(player);
                    playerMenuUtility.setSelectedTool(axe);
                }

                player.playSound(player.getLocation(), "entity.player.levelup", 1.0F, 1.0F);
                new AxeMenu(TokenForge.getPlayerMenuUtility(player)).open();
                break;
            case 23:
                ItemStack shovel = event.getCurrentItem();
                if (shovel != null) {
                    PlayerMenuUtility playerMenuUtility = TokenForge.getPlayerMenuUtility(player);
                    playerMenuUtility.setSelectedTool(shovel);
                }

                player.playSound(player.getLocation(), "entity.player.levelup", 1.0F, 1.0F);
                new ShovelMenu(TokenForge.getPlayerMenuUtility(player)).open();
                break;
            case 24:
                ItemStack hoe = event.getCurrentItem();
                if (hoe != null) {
                    PlayerMenuUtility playerMenuUtility = TokenForge.getPlayerMenuUtility(player);
                    playerMenuUtility.setSelectedTool(hoe);
                }

                player.playSound(player.getLocation(), "entity.player.levelup", 1.0F, 1.0F);
                new HoeMenu(TokenForge.getPlayerMenuUtility(player)).open();
                break;
            case 29:
                ItemStack turtleHelmet = event.getCurrentItem();
                if (turtleHelmet != null) {
                    PlayerMenuUtility playerMenuUtility = TokenForge.getPlayerMenuUtility(player);
                    playerMenuUtility.setSelectedTool(turtleHelmet);
                }

                player.playSound(player.getLocation(), "entity.player.levelup", 1.0F, 1.0F);
                new TurtleMenu(TokenForge.getPlayerMenuUtility(player)).open();
                break;
            case 30:
                ItemStack helmet = event.getCurrentItem();
                if (helmet != null) {
                    PlayerMenuUtility playerMenuUtility = TokenForge.getPlayerMenuUtility(player);
                    playerMenuUtility.setSelectedTool(helmet);
                }

                player.playSound(player.getLocation(), "entity.player.levelup", 1.0F, 1.0F);
                new HelmetMenu(TokenForge.getPlayerMenuUtility(player)).open();
                break;
            case 31:
                ItemStack chestplate = event.getCurrentItem();
                if (chestplate != null) {
                    PlayerMenuUtility playerMenuUtility = TokenForge.getPlayerMenuUtility(player);
                    playerMenuUtility.setSelectedTool(chestplate);
                }

                player.playSound(player.getLocation(), "entity.player.levelup", 1.0F, 1.0F);
                new ChestplateMenu(TokenForge.getPlayerMenuUtility(player)).open();
                break;
            case 32:
                ItemStack leggings = event.getCurrentItem();
                if (leggings != null) {
                    PlayerMenuUtility playerMenuUtility = TokenForge.getPlayerMenuUtility(player);
                    playerMenuUtility.setSelectedTool(leggings);
                }

                player.playSound(player.getLocation(), "entity.player.levelup", 1.0F, 1.0F);
                new LeggingsMenu(TokenForge.getPlayerMenuUtility(player)).open();
                break;
            case 33:
                ItemStack boots = event.getCurrentItem();
                if (boots != null) {
                    PlayerMenuUtility playerMenuUtility = TokenForge.getPlayerMenuUtility(player);
                    playerMenuUtility.setSelectedTool(boots);
                }

                player.playSound(player.getLocation(), "entity.player.levelup", 1.0F, 1.0F);
                new BootsMenu(TokenForge.getPlayerMenuUtility(player)).open();
                break;
            case 38:
                ItemStack trident = event.getCurrentItem();
                if (trident != null) {
                    PlayerMenuUtility playerMenuUtility = TokenForge.getPlayerMenuUtility(player);
                    playerMenuUtility.setSelectedTool(trident);
                }

                player.playSound(player.getLocation(), "entity.player.levelup", 1.0F, 1.0F);
                new TridentMenu(TokenForge.getPlayerMenuUtility(player)).open();
                break;
            case 39:
                ItemStack bow = event.getCurrentItem();
                if (bow != null) {
                    PlayerMenuUtility playerMenuUtility = TokenForge.getPlayerMenuUtility(player);
                    playerMenuUtility.setSelectedTool(bow);
                }

                player.playSound(player.getLocation(), "entity.player.levelup", 1.0F, 1.0F);
                new BowMenu(TokenForge.getPlayerMenuUtility(player)).open();
                break;
            case 40:
                ItemStack crossbow = event.getCurrentItem();
                if (crossbow != null) {
                    PlayerMenuUtility playerMenuUtility = TokenForge.getPlayerMenuUtility(player);
                    playerMenuUtility.setSelectedTool(crossbow);
                }

                player.playSound(player.getLocation(), "entity.player.levelup", 1.0F, 1.0F);
                new CrossbowMenu(TokenForge.getPlayerMenuUtility(player)).open();
                break;
            case 41:
                ItemStack shears = event.getCurrentItem();
                if (shears != null) {
                    PlayerMenuUtility playerMenuUtility = TokenForge.getPlayerMenuUtility(player);
                    playerMenuUtility.setSelectedTool(shears);
                }

                player.playSound(player.getLocation(), "entity.player.levelup", 1.0F, 1.0F);
                new ShearsMenu(TokenForge.getPlayerMenuUtility(player)).open();
                break;
            case 42:
                ItemStack fishingRod = event.getCurrentItem();
                if (fishingRod != null) {
                    PlayerMenuUtility playerMenuUtility = TokenForge.getPlayerMenuUtility(player);
                    playerMenuUtility.setSelectedTool(fishingRod);
                }

                player.playSound(player.getLocation(), "entity.player.levelup", 1.0F, 1.0F);
                new FishingRodMenu(TokenForge.getPlayerMenuUtility(player)).open();
                break;
            case 45:
                player.playSound(player.getLocation(), "block.anvil.break", 1.0F, 1.0F);
                event.getWhoClicked().closeInventory();
                playerMenuUtility.clearPlayerData();
                break;
            case 53:
                player.playSound(player.getLocation(), "entity.player.levelup", 1.0F, 1.0F);
                new HowToMenu(TokenForge.getPlayerMenuUtility(player)).open();
                break;
        }
    }

    public void setMenuItems() {

        Player player = playerMenuUtility.getOwner();

        // elytra
        ItemStack elytra = new ItemStack(Material.ELYTRA);
        ItemMeta elytraMeta = elytra.getItemMeta();
        elytraMeta.setDisplayName(ChatColor.GOLD + "Elytra");
        elytraMeta.setLore(Arrays.asList(ChatColor.GRAY + "Click to select an elytra!"));
        elytra.setItemMeta(elytraMeta);

        // sword
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta swordMeta = sword.getItemMeta();
        swordMeta.setDisplayName(ChatColor.GOLD + "Sword");
        swordMeta.setLore(Arrays.asList(ChatColor.GRAY + "Click to select a sword!"));
        sword.setItemMeta(swordMeta);

        // pickaxe
        ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta pickaxeMeta = pickaxe.getItemMeta();
        pickaxeMeta.setDisplayName(ChatColor.GOLD + "Pickaxe");
        pickaxeMeta.setLore(Arrays.asList(ChatColor.GRAY + "Click to select a pickaxe!"));
        pickaxe.setItemMeta(pickaxeMeta);

        // axe
        ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta axeMeta = axe.getItemMeta();
        axeMeta.setDisplayName(ChatColor.GOLD + "Axe");
        axeMeta.setLore(Arrays.asList(ChatColor.GRAY + "Click to select an axe!"));
        axe.setItemMeta(axeMeta);

        // shovel
        ItemStack shovel = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta shovelMeta = shovel.getItemMeta();
        shovelMeta.setDisplayName(ChatColor.GOLD + "Shovel");
        shovelMeta.setLore(Arrays.asList(ChatColor.GRAY + "Click to select a shovel!"));
        shovel.setItemMeta(shovelMeta);

        // hoe
        ItemStack hoe = new ItemStack(Material.DIAMOND_HOE);
        ItemMeta hoeMeta = hoe.getItemMeta();
        hoeMeta.setDisplayName(ChatColor.GOLD + "Hoe");
        hoeMeta.setLore(Arrays.asList(ChatColor.GRAY + "Click to select a hoe!"));
        hoe.setItemMeta(hoeMeta);

        // turtle helmet
        ItemStack turtle = new ItemStack(Material.TURTLE_HELMET);
        ItemMeta turtleMeta = turtle.getItemMeta();
        turtleMeta.setDisplayName(ChatColor.GOLD + "Turtle Helmet");
        turtleMeta.setLore(Arrays.asList(ChatColor.GRAY + "Click to select a turtle helmet!"));
        turtle.setItemMeta(turtleMeta);

        // helmet
        ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta helmetMeta = helmet.getItemMeta();
        helmetMeta.setDisplayName(ChatColor.GOLD + "Helmet");
        helmetMeta.setLore(Arrays.asList(ChatColor.GRAY + "Click to select a helmet!"));
        helmet.setItemMeta(helmetMeta);

        // chestplate
        ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta chestplateMeta = chestplate.getItemMeta();
        chestplateMeta.setDisplayName(ChatColor.GOLD + "Chestplate");
        chestplateMeta.setLore(Arrays.asList(ChatColor.GRAY + "Click to select a chestplate!"));
        chestplate.setItemMeta(chestplateMeta);

        // leggings
        ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta leggingsMeta = leggings.getItemMeta();
        leggingsMeta.setDisplayName(ChatColor.GOLD + "Leggings");
        leggingsMeta.setLore(Arrays.asList(ChatColor.GRAY + "Click to select leggings!"));
        leggings.setItemMeta(leggingsMeta);

        // boots
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta bootsMeta = boots.getItemMeta();
        bootsMeta.setDisplayName(ChatColor.GOLD + "Boots");
        bootsMeta.setLore(Arrays.asList(ChatColor.GRAY + "Click to select boots!"));
        boots.setItemMeta(bootsMeta);

        // trident
        ItemStack trident = new ItemStack(Material.TRIDENT);
        ItemMeta tridentMeta = trident.getItemMeta();
        tridentMeta.setDisplayName(ChatColor.GOLD + "Trident");
        tridentMeta.setLore(Arrays.asList(ChatColor.GRAY + "Click to select a trident!"));
        trident.setItemMeta(tridentMeta);

        // bow
        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.setDisplayName(ChatColor.GOLD + "Bow");
        bowMeta.setLore(Arrays.asList(ChatColor.GRAY + "Click to select a bow!"));
        bow.setItemMeta(bowMeta);

        // crossbow
        ItemStack crossbow = new ItemStack(Material.CROSSBOW);
        ItemMeta crossbowMeta = crossbow.getItemMeta();
        crossbowMeta.setDisplayName(ChatColor.GOLD + "Crossbow");
        crossbowMeta.setLore(Arrays.asList(ChatColor.GRAY + "Click to select a crossbow!"));
        crossbow.setItemMeta(crossbowMeta);

        // shield
        ItemStack shears = new ItemStack(Material.SHEARS);
        ItemMeta shearsMeta = shears.getItemMeta();
        shearsMeta.setDisplayName(ChatColor.GOLD + "Shears");
        shearsMeta.setLore(Arrays.asList(ChatColor.GRAY + "Click to select shears!"));
        shears.setItemMeta(shearsMeta);

        // fishing rod
        ItemStack fishingRod = new ItemStack(Material.FISHING_ROD);
        ItemMeta fishingRodMeta = fishingRod.getItemMeta();
        fishingRodMeta.setDisplayName(ChatColor.GOLD + "Fishing Rod");
        fishingRodMeta.setLore(Arrays.asList(ChatColor.GRAY + "Click to select a fishing rod!"));
        fishingRod.setItemMeta(fishingRodMeta);

        // points remaining
        ItemStack pointsRemaining = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta pointsRemainingMeta = (SkullMeta) pointsRemaining.getItemMeta();
        pointsRemainingMeta.setDisplayName(ChatColor.GOLD + "Your Points: " + ChatColor.GREEN + PointsManager.getRemainingPoints(player));
        pointsRemainingMeta.setOwningPlayer(player);
        pointsRemaining.setItemMeta(pointsRemainingMeta);

        // how to
        ItemStack howTo = new ItemStack(Material.BOOK);
        ItemMeta howToMeta = howTo.getItemMeta();
        howToMeta.setDisplayName(ChatColor.GOLD + "How To");
        howToMeta.setLore(Arrays.asList(ChatColor.GRAY + "Click to learn how to use TokenForge!"));
        howTo.setItemMeta(howToMeta);

        // close
        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        close.setItemMeta(closeMeta);

        // frame
        ItemStack frame = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
        for (int i : new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 17, 26, 35, 44, 53, 52, 51, 50, 49, 48, 47, 46, 36, 27, 18, 9}) {
            inventory.setItem(i, frame);
        }

        inventory.setItem(4, pointsRemaining);
        inventory.setItem(53, howTo);
        inventory.setItem(13, elytra);
        inventory.setItem(20, sword);
        inventory.setItem(21, pickaxe);
        inventory.setItem(22, axe);
        inventory.setItem(23, shovel);
        inventory.setItem(24, hoe);
        inventory.setItem(29, turtle);
        inventory.setItem(30, helmet);
        inventory.setItem(31, chestplate);
        inventory.setItem(32, leggings);
        inventory.setItem(33, boots);
        inventory.setItem(38, trident);
        inventory.setItem(39, bow);
        inventory.setItem(40, crossbow);
        inventory.setItem(41, shears);
        inventory.setItem(42, fishingRod);
        inventory.setItem(45, close);
    }
}
