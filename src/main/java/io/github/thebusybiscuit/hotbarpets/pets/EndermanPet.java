package io.github.thebusybiscuit.hotbarpets.pets;

import org.bukkit.Sound;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.hotbarpets.SimpleBasePet;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public class EndermanPet extends SimpleBasePet {

    public EndermanPet(Category category, SlimefunItemStack item, ItemStack food, ItemStack[] recipe) {
        super(category, item, food, recipe);
    }

    @Override
    public void onUseItem(Player p) {
        p.launchProjectile(EnderPearl.class);
        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_AMBIENT, 1.0F, 2.0F);
    }

}
