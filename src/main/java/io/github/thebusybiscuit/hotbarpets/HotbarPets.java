package io.github.thebusybiscuit.hotbarpets;

import io.github.thebusybiscuit.hotbarpets.groups.BossMobs;
import io.github.thebusybiscuit.hotbarpets.groups.FarmAnimals;
import io.github.thebusybiscuit.hotbarpets.groups.HostileMobs;
import io.github.thebusybiscuit.hotbarpets.groups.PassiveMobs;
import io.github.thebusybiscuit.hotbarpets.groups.PeacefulAnimals;
import io.github.thebusybiscuit.hotbarpets.groups.SpecialPets;
import io.github.thebusybiscuit.hotbarpets.groups.UtilityPets;
import io.github.thebusybiscuit.hotbarpets.listeners.DamageListener;
import io.github.thebusybiscuit.hotbarpets.listeners.FoodListener;
import io.github.thebusybiscuit.hotbarpets.listeners.GeneralListener;
import io.github.thebusybiscuit.hotbarpets.listeners.PhantomListener;
import io.github.thebusybiscuit.hotbarpets.listeners.ProjectileListener;
import io.github.thebusybiscuit.hotbarpets.listeners.SoulPieListener;
import io.github.thebusybiscuit.hotbarpets.listeners.TNTListener;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import net.guizhanss.guizhanlibplugin.updater.GuizhanUpdater;
import org.bstats.bukkit.Metrics;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class HotbarPets extends JavaPlugin implements Listener, SlimefunAddon {

    private ItemGroup itemGroup;

    @Override
    public void onEnable() {
        if (!getServer().getPluginManager().isPluginEnabled("GuizhanLibPlugin")) {
            getLogger().log(Level.SEVERE, "本插件需要 鬼斩前置库插件(GuizhanLibPlugin) 才能运行!");
            getLogger().log(Level.SEVERE, "从此处下载: https://50L.cc/gzlib");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        Config cfg = new Config(this);

        // Setting up bStats
        new Metrics(this, 4859);

        if (cfg.getBoolean("options.auto-update") && getDescription().getVersion().startsWith("Build")) {
            GuizhanUpdater.start(this, getFile(), "SlimefunGuguProject", "HotbarPets", "master");
        }

        itemGroup = new ItemGroup(new NamespacedKey(this, "pets"), new CustomItemStack(PetTexture.CATEGORY.getAsItem(), "&d背包宠物"));

        // Add all the Pets via their Group class
        new FarmAnimals(this);
        new PeacefulAnimals(this);
        new PassiveMobs(this);
        new HostileMobs(this);
        new BossMobs(this);
        new UtilityPets(this);
        new SpecialPets(this);

        // Registering the Listeners
        new DamageListener(this);
        new FoodListener(this);
        new GeneralListener(this);
        new PhantomListener(this);
        new ProjectileListener(this);
        new SoulPieListener(this);
        new TNTListener(this);

        // Registering our task
        getServer().getScheduler().scheduleSyncRepeatingTask(this, new HotbarPetsRunnable(), 0L, 2000L);
    }

    public ItemGroup getItemGroup() {
        return itemGroup;
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/SlimefunGuguProject/HotbarPets/issues";
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }
}
