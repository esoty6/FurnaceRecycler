package com.github.esoty6.furnacerecycler;

import org.bukkit.plugin.java.JavaPlugin;
import com.github.esoty6.furnacerecycler.CustomRecipes.ChainArmorRecipes;
import com.github.esoty6.furnacerecycler.CustomRecipes.HorseArmorRecipes;
import com.github.esoty6.furnacerecycler.CustomRecipes.RottenFleshRecipes;

public class FurnaceRecyclerPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("FurnaceRecyclerPlugin enabled!");

        new ChainArmorRecipes(this);
        new HorseArmorRecipes(this);
        new RottenFleshRecipes(this);

        getServer().getScheduler().runTask(this, this::loadRecycleRecipes);
    }

    @Override
    public void onDisable() {
        getServer().getScheduler().cancelTasks(this);
    }

    private void loadRecycleRecipes() {
        new RecycleRecipes(this);
        getLogger().info(() -> "Loaded all recycle recipes!");
    }

}
