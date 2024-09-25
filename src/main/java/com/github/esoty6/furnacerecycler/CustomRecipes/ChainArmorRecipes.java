package com.github.esoty6.furnacerecycler.CustomRecipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

public class ChainArmorRecipes {
  private final Plugin plugin;

  public ChainArmorRecipes(Plugin plugin) {
    this.plugin = plugin;

    generateRecipe();
  }


  private final void generateRecipe() {
    ShapedRecipe chainMailChestplateRecipe =
        new ShapedRecipe(new NamespacedKey(plugin, "chainmail_chestplate_armor"),
            new ItemStack(Material.CHAINMAIL_CHESTPLATE));
    chainMailChestplateRecipe.shape("C C", "CCC", "CCC");
    chainMailChestplateRecipe.setIngredient('C', Material.CHAIN);

    ShapedRecipe chainMailLegginsRecipe =
        new ShapedRecipe(new NamespacedKey(plugin, "chainmail_leggins_armor"),
            new ItemStack(Material.CHAINMAIL_LEGGINGS));
    chainMailLegginsRecipe.shape("CCC", "C C", "C C");
    chainMailLegginsRecipe.setIngredient('C', Material.CHAIN);

    ShapedRecipe chainMailBootsRecipe =
        new ShapedRecipe(new NamespacedKey(plugin, "chainmail_boots_armor"),
            new ItemStack(Material.CHAINMAIL_BOOTS));
    chainMailBootsRecipe.shape("   ", "C C", "C C");
    chainMailBootsRecipe.setIngredient('C', Material.CHAIN);

    ShapedRecipe chainMailHelmetRecipe =
        new ShapedRecipe(new NamespacedKey(plugin, "chainmail_helmet_armor"),
            new ItemStack(Material.CHAINMAIL_HELMET));
    chainMailHelmetRecipe.shape("   ", "CCC", "C C");
    chainMailHelmetRecipe.setIngredient('C', Material.CHAIN);

    plugin.getServer().addRecipe(chainMailChestplateRecipe);
    plugin.getServer().addRecipe(chainMailLegginsRecipe);
    plugin.getServer().addRecipe(chainMailBootsRecipe);
    plugin.getServer().addRecipe(chainMailHelmetRecipe);
  }
}
