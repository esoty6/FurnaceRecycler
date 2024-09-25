package com.github.esoty6.furnacerecycler.CustomRecipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class RottenFleshRecipes {
  private final Plugin plugin;

  public RottenFleshRecipes(Plugin plugin) {
    this.plugin = plugin;

    generateRecycleRecipe();
  };

  public void generateRecycleRecipe() {
    FurnaceRecipe rottenFleshToLeatherFurnaceRecipe =
        new FurnaceRecipe(new NamespacedKey(plugin, "leather_from_rotten_flesh"),
            new ItemStack(Material.LEATHER), Material.ROTTEN_FLESH, 2, 300);

    plugin.getServer().addRecipe(rottenFleshToLeatherFurnaceRecipe);
  }
}
