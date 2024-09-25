package com.github.esoty6.furnacerecycler.CustomRecipes;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

public class HorseArmorRecipes {
  private final Plugin plugin;
  private static final Material[] HORSE_ARMORS = {Material.LEATHER_HORSE_ARMOR,
      Material.IRON_HORSE_ARMOR, Material.GOLDEN_HORSE_ARMOR, Material.DIAMOND_HORSE_ARMOR};

  public HorseArmorRecipes(Plugin plugin) {
    this.plugin = plugin;

    generateRecipe(Material.IRON_INGOT, Material.LEATHER_HORSE_ARMOR, Material.IRON_HORSE_ARMOR);

    generateRecipe(Material.GOLD_INGOT, Material.IRON_HORSE_ARMOR, Material.GOLDEN_HORSE_ARMOR);

    generateRecipe(Material.DIAMOND, Material.GOLDEN_HORSE_ARMOR, Material.DIAMOND_HORSE_ARMOR);
  };

  public void generateRecipe(Material material, Material base, Material result) {
    ShapedRecipe horseArmorRecipe = new ShapedRecipe(
        new NamespacedKey(plugin, result.getTranslationKey()), new ItemStack(result));

    horseArmorRecipe.shape("M M", "MBM", "M M");
    horseArmorRecipe.setIngredient('B', base);
    horseArmorRecipe.setIngredient('M', material);

    plugin.getServer().addRecipe(horseArmorRecipe);
  }

  public static Material[] getHorseArmors() {
    return HORSE_ARMORS;
  }

}
