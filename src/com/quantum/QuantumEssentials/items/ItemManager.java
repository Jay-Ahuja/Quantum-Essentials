package com.quantum.QuantumEssentials.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemManager {

    public static void init() {
        creationMemeHoe();

    }

    public static ItemStack meme_hoe;

    public static void creationMemeHoe() {
        ItemStack item = new ItemStack(Material.NETHERITE_HOE, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§5Impossible");
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.LOYALTY, 69, true);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("§6Why does this exist?");
        meta.setLore(lore);
        item.setItemMeta(meta);
        meme_hoe = item;
    }




}
