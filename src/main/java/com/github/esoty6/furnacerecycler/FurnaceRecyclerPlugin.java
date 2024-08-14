package com.github.esoty6.furnacerecycler;

import org.bukkit.plugin.java.JavaPlugin;

public class FurnaceRecyclerPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("FurnaceRecyclerPlugin enabled!");
        new CustomRecipes(this);
    }

}