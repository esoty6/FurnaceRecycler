package com.github.esoty6.furnacerecycler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Tag;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;
import com.github.esoty6.furnacerecycler.CustomRecipes.HorseArmorRecipes;

public class RecycleRecipes {
  private final Plugin plugin;
  private final List<Material> materialList;
  private final List<RecipeChoice> recipesToRecycle;

  public RecycleRecipes(Plugin plugin) {
    this.plugin = plugin;
    materialList = Arrays.asList(Material.values());
    recipesToRecycle = new ArrayList<>();

    recycleRecipes();
  }

  private final void recycleRecipes() {
    RecipeChoice chestArmorRecipes = new RecipeChoice.MaterialChoice(Tag.ITEMS_CHEST_ARMOR);
    RecipeChoice legArmorRecipes = new RecipeChoice.MaterialChoice(Tag.ITEMS_LEG_ARMOR);
    RecipeChoice headArmorRecipes = new RecipeChoice.MaterialChoice(Tag.ITEMS_HEAD_ARMOR);
    RecipeChoice footArmorRecipes = new RecipeChoice.MaterialChoice(Tag.ITEMS_FOOT_ARMOR);
    RecipeChoice axeRecipes = new RecipeChoice.MaterialChoice(Tag.ITEMS_AXES);
    RecipeChoice pickaxeRecipes = new RecipeChoice.MaterialChoice(Tag.ITEMS_PICKAXES);
    RecipeChoice swordRecipes = new RecipeChoice.MaterialChoice(Tag.ITEMS_SWORDS);
    RecipeChoice hoeRecipes = new RecipeChoice.MaterialChoice(Tag.ITEMS_HOES);
    RecipeChoice shovelRecipes = new RecipeChoice.MaterialChoice(Tag.ITEMS_SHOVELS);
    RecipeChoice horseArmorRecipes =
        new RecipeChoice.MaterialChoice(HorseArmorRecipes.getHorseArmors());

    recipesToRecycle.add(chestArmorRecipes);
    recipesToRecycle.add(legArmorRecipes);
    recipesToRecycle.add(headArmorRecipes);
    recipesToRecycle.add(footArmorRecipes);
    recipesToRecycle.add(axeRecipes);
    recipesToRecycle.add(pickaxeRecipes);
    recipesToRecycle.add(swordRecipes);
    recipesToRecycle.add(hoeRecipes);
    recipesToRecycle.add(shovelRecipes);
    recipesToRecycle.add(horseArmorRecipes);

    generateRecycleRecipe("golden", Material.GOLD_INGOT);
    generateRecycleRecipe("diamond", Material.DIAMOND);
    generateRecycleRecipe("iron", Material.IRON_INGOT);
    generateRecycleRecipe("chainmail", Material.IRON_NUGGET);
    generateRecycleRecipe("leather", Material.LEATHER);
  }

  private final void generateRecycleRecipe(String keyword, Material resultMaterial) {
    for (RecipeChoice recipeChoice : recipesToRecycle) {
      List<ItemStack> resultMaterials = new ArrayList<>();

      List<Material> filteredMaterials = materialList.stream()
          .filter(
              material -> material.isItem() && material.getItemTranslationKey().contains(keyword))
          .toList();

      for (Material material : filteredMaterials) {
        ItemStack itemStack = new ItemStack(material);

        if (recipeChoice.test(itemStack)) {
          List<Recipe> res = plugin.getServer().getRecipesFor(itemStack);
          ShapedRecipe rec = (ShapedRecipe) res.get(0);

          for (ItemStack itemstack : rec.getIngredientMap().values()) {
            if (itemstack == null || itemstack.getType() != resultMaterial) {
              continue;
            }
            resultMaterials.add(itemstack);
          }

          if (resultMaterials.isEmpty()) {
            resultMaterials.add(resultMaterial.asItemType().createItemStack());
          }

          ItemStack result = new ItemStack(resultMaterial);
          Integer totalAmount = resultMaterials.stream().mapToInt(ItemStack::getAmount).sum();
          result.setAmount(totalAmount);

          FurnaceRecipe furnaceRecipe = new FurnaceRecipe(
              new NamespacedKey(plugin, "recycle_" + material.getItemTranslationKey()), result,
              material, 12, 400);

          plugin.getServer().addRecipe(furnaceRecipe);
        }
      }
    }
  }

}
